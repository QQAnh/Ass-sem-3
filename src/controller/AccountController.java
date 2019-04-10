package controller;

import entity.Account;
import model.AccountModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class AccountController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        Account account = new Account(username, password, 2);

        if (!account.isValid()) {

            HashMap<String, ArrayList<String>> errors = account.getErrors();

            req.setAttribute("account", account);

            req.setAttribute("errors", errors);

            req.getRequestDispatcher("register.jsp").forward(req, resp);

            return;
        }
        AccountModel accountModel = new AccountModel();
        System.out.println(account.getUsername());
        accountModel.insert(account);
        resp.sendRedirect("/index");
    }
}
