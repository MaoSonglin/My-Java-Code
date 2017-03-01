package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet(urlPatterns={"/loginServlet"}, name="login_servlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		String username = request.getParameter("username");
		String password = request.getParameter("userpass");
		String checkInfo = null;
		String sql = "select * from users where 用户名 = '"+username+"'";
		
		Connection con = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.hxtt.sql.access.AccessDriver");
			con = DriverManager.getConnection("jdbc:Access:/C:/Users/acer-pc/Documents/ffasdb.accdb");
			st = con.createStatement();
			rs = st.executeQuery(sql);
			if(rs.next()){
				if(rs.getString("密码").equals(password)){
					checkInfo = "登录成功！";
					javax.servlet.http.HttpSession session = request.getSession();
					bean.User cur_user = new bean.User(username);
					cur_user.setUsertype(rs.getString("用户类型"));
					session.setAttribute("current_user", cur_user);
					//session.setAttribute("password", password);
					response.sendRedirect("first_page.jsp");
				}else{
					checkInfo = "密码错误！";
					request.setAttribute("checkInfo", checkInfo);
					RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
					rd.forward(request, response);
				}
			}else{
				checkInfo = "用户不存在！";
				request.setAttribute("checkInfo", checkInfo);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
			rs.close();
			st.close();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
