package syncthread;



public class Share {
  private int contents;
  public int get(){//从共享区取数字
    return contents;
  }
  public void put(int value){//放入共享区
    contents=value;
  }
}
