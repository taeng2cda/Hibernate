package Filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

//@WebFilter("/admin/*")
public class CheckAdminLoginFilter extends HttpFilter implements Filter{
    private static final long serialVersionUID = 1L;

    public CheckAdminLoginFilter() {
        super();
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        boolean loggedIn = session != null && session.getAttribute("user_id") != null;
        String loginURI = httpRequest.getContextPath() + "/admin/login.do";
        boolean loginRequest = httpRequest.getRequestURI().equals(loginURI);
        boolean loginPage = httpRequest.getRequestURI().endsWith("login.do");

        if (loggedIn && (loginRequest || loginPage)) {
            RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/");
            dispatcher.forward(request, response);

        } else if (loggedIn || loginRequest) {
            System.out.println("user logged in");
            chain.doFilter(request, response);
        } else {
            System.err.println("user not logged in");
            getServletContext().getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {
    }
}
