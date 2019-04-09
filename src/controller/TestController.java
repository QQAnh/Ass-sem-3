package controller;

import entity.Account;
import entity.Feedback;
import model.AccountModel;
import model.FeedbackModel;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class TestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.getFeedback();
        req.getRequestDispatcher("sendfeedback.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String description = req.getParameter("description");
        Feedback feedback = new Feedback(description);
        if (!feedback.isValid()){

            HashMap<String, ArrayList<String>> errors = feedback.getErrors();

            req.setAttribute("feedback",feedback);

            req.setAttribute("errors", errors);

            req.getRequestDispatcher("sendfeedback.jsp").forward(req,resp);

            return;
        }
        FeedbackModel feedbackModel = new FeedbackModel();
        feedbackModel.userSend(feedback);
        resp.sendRedirect("/index");
    }
}
