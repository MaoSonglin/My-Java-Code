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
		out.println("����һ���򵥵�servlet��");
		out.println("�ͻ���IP��ַ�ǣ�"+request.getRemoteAddr()+"<br>");
		out.println("</body></html>");
	}
}
