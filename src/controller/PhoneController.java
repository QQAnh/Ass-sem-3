package controller;

import entity.Phone;
import model.PhoneModel;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class PhoneController  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("addphones.jsp").forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        String name = req.getParameter("name");
        String brand = req.getParameter("brand");
        String price = req.getParameter("price");
        String description = req.getParameter("description");
        Phone phone = new Phone(name,brand,price,description);
        if (!phone.isValid()) {

            HashMap<String, ArrayList<String>> errors = phone.getErrors();

            req.setAttribute("phone", phone);

            req.setAttribute("errors", errors);

            req.getRequestDispatcher("addphones.jsp").forward(req, resp);

            return;
        }
        PhoneModel phoneModel = new PhoneModel();
        phoneModel.insert(phone);
        resp.sendRedirect("/index");
    }
}
