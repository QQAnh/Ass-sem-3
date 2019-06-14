package controller;

import model.AccountModel;
import model.FeedbackModel;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PhoneModel phoneModel = new PhoneModel();
        req.setAttribute("data",phoneModel.getPhone());
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
