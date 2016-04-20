package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/logado/*")
public class FiltroAutenticacao implements Filter {

	public FiltroAutenticacao() {
	}

	public void destroy() {
	}

	//Método onde iremos criar a regra do filter
	public void doFilter(ServletRequest request, 
				   ServletResponse response,
			FilterChain chain) throws IOException, 
			ServletException {
		
		//chamando a sessão do java

		HttpServletRequest  req  = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		

		HttpSession session = req.getSession();
		
		if(session.getAttribute("usuario") != null){ 
		//se o usuario existe na sessão

			chain.doFilter(request, response); //tudo certo!!			
		}
		else{
			resp.sendRedirect("/login.jsp"); //expulso!!!
		}
		
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}
}

