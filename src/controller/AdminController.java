package controller;

import model.AccountModel;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackModel feedbackModel = new FeedbackModel();
        AccountModel accountModel = new AccountModel();
        req.setAttribute("data", feedbackModel.getAllFeedback());
        HttpSession session = req.getSession();
        String token = String.valueOf(session.getAttribute("username"));
        System.out.println(accountModel.getRoleByUsernam(token).getRole());
        System.out.println(token);

            req.setAttribute("role", accountModel.getRoleByUsernam(token).getRole());
            req.getRequestDispatcher("admin.jsp").forward(req, resp);

    }
}
