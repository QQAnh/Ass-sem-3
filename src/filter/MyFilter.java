package filter;


import model.AccountModel;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class MyFilter implements Filter {
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
        Integer role = (Integer) session.getAttribute("role");
        AccountModel accountModel = new AccountModel();
         boolean check = accountModel.getAccountByUserName(token);
        if ( token == null && token.length() == 0 && check == false) {
            ((HttpServletResponse) servletResponse).sendRedirect("/login");

        }
        else {
//            httpServletResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
            filterChain.doFilter(servletRequest, servletResponse);

        }
    }

    @Override
    public void destroy() {

    }
}
