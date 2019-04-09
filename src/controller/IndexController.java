package controller;

import model.AccountModel;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackModel feedbackModel = new FeedbackModel();
        req.setAttribute("data",feedbackModel.getFeedback());
        HttpSession session = req.getSession();
        String token = String.valueOf(session.getAttribute("username"));
        System.out.println(token);
        if (token != "null" && token.length() >0) {
            AccountModel accountModel = new AccountModel();
//            req.setAttribute("role", accountModel.getRoleByUsernam(token).getRole());
            req.setAttribute("role", 1);

            req.getRequestDispatcher("index.jsp").forward(req, resp);
        }
        resp.sendRedirect("/login");
    }
}
