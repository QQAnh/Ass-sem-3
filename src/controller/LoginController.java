package controller;

import entity.Account;
import model.AccountModel;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.Random;


public class LoginController extends HttpServlet {
    AccountModel accountModel = new AccountModel();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = checkLogin(username, password);
        if (account != null) {
            HttpSession session = req.getSession();
            session.setAttribute("username",username);
            session.setAttribute("role",account.getRole());
            System.out.println("Login Success");
            resp.sendRedirect("/index");
        } else {
            req.setAttribute("error", "Login fail");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
            return;
        }
    }

    private Account checkLogin(String username, String password) {
        Account account = accountModel.getAccountByUserNameAndPassword(username, password);
        if (account != null) {
            return account;
        }
        return null;
    }
}
