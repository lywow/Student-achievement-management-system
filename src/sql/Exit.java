package sql;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

@WebServlet("/exit.do")
public class Exit extends HttpServlet{
	private static final long serialVersionUID=1L;

	public void init()
	{}
	public void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		request.getSession().invalidate();
		response.sendRedirect("index.jsp");
		System.out.println("一个用户退出系统");
	}
}



