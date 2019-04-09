package filter;

import model.AccountModel;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filtering.........");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        String token = String.valueOf(session.getAttribute("username"));
        AccountModel accountModel = new AccountModel();
        boolean check = accountModel.getAccountByUserName(token);
        System.out.println("token " +token);
         Object id = session.getAttribute("role");
        System.out.println(id);
//        System.out.println(role);
        if ( token != "null" && token.length() != 0 && check == true) {
           if ( id=="1"){
//            ((HttpServletResponse) servletResponse).sendRedirect("/admin");
            filterChain.doFilter(servletRequest, servletResponse);
           }else {
            ((HttpServletResponse) servletResponse).sendRedirect("/index");
           }

        }
        else {
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            ((HttpServletResponse) servletResponse).sendRedirect("/login");


        }

    }

    @Override
    public void destroy() {

    }
}
