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
        HttpSession session = httpServletRequest.getSession();
        String token = String.valueOf(session.getAttribute("username"));
        Integer role = (Integer) session.getAttribute("role");
        System.out.println("role(adminfilter) : " +role);
        System.out.println("token :" +token);

        AccountModel accountModel = new AccountModel();

        if (token == null && token.length() == 0 ) {
            boolean check = accountModel.getAccountByUserName(token);
            if (check == false){
                ((HttpServletResponse) servletResponse).sendRedirect("login.jsp");
            }
        } else {
            System.out.println("hihihihi");
            if (role == 1 ) {
                filterChain.doFilter(servletRequest, servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
