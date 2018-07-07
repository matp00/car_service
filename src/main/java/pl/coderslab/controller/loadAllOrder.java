package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loadAllOrder", urlPatterns = "/loadAllOrder")
public class loadAllOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Order> orders=OrderDao.loadAll();
        System.out.println(orders.size());
        request.setAttribute("orders",orders);
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadAllOrder.jsp").forward(request, response);
    }
}
