package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteCustomer", urlPatterns = "/deleteCustomer")
public class deleteCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            CustomerDao.deleteCustomer(id);
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/deleteCustomer.jsp").forward(request, response);
        } catch (Exception e) {
            request.setAttribute("information", "Zly format!! Id musi byc liczba!");
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/deleteCustomer.jsp").forward(request, response);
            System.out.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/deleteCustomer.jsp").forward(request, response);
    }
}
