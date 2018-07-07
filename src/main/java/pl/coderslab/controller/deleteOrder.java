package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteOrder", urlPatterns = "/deleteOrder")
public class deleteOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            OrderDao.deleteOrder(id);
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/deleteOrder.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("information", "Zly format!! Id musi byc liczba!");
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/deleteOrder.jsp").forward(request, response);
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/deleteOrder.jsp").forward(request,response);
    }
}
