import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.HashMap;
import java.util.Map;


public class FileWatcherDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//创建一个WatchService对象，此对象将用于管理特定文件夹的变动信息队列。
		try(WatchService service=FileSystems.getDefault().newWatchService()) {
			//此集合可保存多个文件夹的监控信息，当前只使用了一个
			Map<WatchKey, Path> keyMap=new HashMap<>();
			Path path=Paths.get("D:\\test");
			//设置WatchService对象管理的内部队列，将保存指定的文件夹的创建、删除和修改事件信息
			//返回的WatchKey对象可用于从事件队列中获取事件对象
			WatchKey key=path.register(service, StandardWatchEventKinds.ENTRY_CREATE,
					StandardWatchEventKinds.ENTRY_DELETE,StandardWatchEventKinds.ENTRY_MODIFY);
			keyMap.put(key, path);
			
			do {
				//开始监控，阻塞等待，当感兴趣的事件发生时，take()方法返回。
				key=service.take();
				Path eventDir=keyMap.get(key);
				//从事件队列中提取所有的事件
				for (WatchEvent<?> event : key.pollEvents()) {
					//是什么类型的事件？
					WatchEvent.Kind<?> kind=event.kind();
					//是哪个对象发生了变动？
					Path eventPath=(Path)event.context();
					System.out.println(eventDir+":"+kind+":"+eventPath);
				}
			} while (key.reset()); //reset方法重置此对象，让其可以重新接收信息
			
		} catch (Exception e) {
			
		}

	}

}
