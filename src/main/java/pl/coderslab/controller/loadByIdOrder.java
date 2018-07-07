package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "loadByIdOrder", urlPatterns = "/loadByIdOrder")
public class loadByIdOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            Order order=OrderDao.loadById(id);
            request.setAttribute("order",order);
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadByIdOrder.jsp").forward(request,response);
        }catch(Exception e){
            request.setAttribute("information", "Zly format!! Id musi byc liczba!");
                getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadByIdOrder.jsp").forward(request,response);
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadByIdOrder.jsp").forward(request,response);
    }
}
