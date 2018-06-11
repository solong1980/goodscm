package springboot.mybatis;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class MyBatisConfigureRefreshServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MyBatisSqlSessionManager manager;

	public MyBatisConfigureRefreshServlet(MyBatisSqlSessionManager manager) {
		this.manager = manager;
	}

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		super.service(req, res);
		
		try {
			manager.refresh();
		} catch (Exception e) {
			e.printStackTrace();
		}
		res.setContentType("text/html");
		PrintWriter out = res.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Hello World</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h1>finish!!!</h1>");
		out.println("</body>");
		out.println("</html>");
	}

}
