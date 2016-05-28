package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controllers.Controller;
import controllers.ControllerFactory;
import entity.PessoaFisica;

@WebServlet("/MackPresenca")
public class MackPresenca extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public MackPresenca() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
				HttpSession session = request.getSession();
				PessoaFisica pf = (PessoaFisica) session.getAttribute("pf");
				session.removeAttribute("pf");
				session.invalidate();
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
				PrintWriter out = response.getWriter();
				out.println("<font color=green>Obrigado por usar o sistema, " + pf.getNome() + ".</font>");
				rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			String controller = request.getParameter("control");
			Controller control = ControllerFactory.getControllerByFullClassName(controller);
			control.init(request);
			control.execute();
			RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(control.getReturnPage());
			requestDispatcher.forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
