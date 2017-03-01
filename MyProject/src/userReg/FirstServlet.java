package userReg;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class FirstServlet extends HttpServlet{
	
	public void init(ServletConfig config)throws ServletException{
		super.init(config);
	}
	
	public void service(HttpServletRequest request,HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.println("<HTML> <BODY>");
		out.println("这是一个简单的servlet。");
		out.println("客户端IP地址是："+request.getRemoteAddr()+"<br>");
		out.println("</body></html>");
	}
}
