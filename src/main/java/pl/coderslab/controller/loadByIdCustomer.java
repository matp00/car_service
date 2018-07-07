package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "loadByIdCustomer", urlPatterns = "/loadByIdCustomer")
public class loadByIdCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    try {
        int id = Integer.parseInt(request.getParameter("id"));
        Customer customer=CustomerDao.loadById(id);
        request.setAttribute("customer",customer);
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadByIdCustomer.jsp").forward(request,response);
    }catch(Exception e){
        request.setAttribute("information", "Zly format!! Id musi byc liczba!");
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadByIdCustomer.jsp").forward(request,response);
        System.out.println(e);
    }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadByIdCustomer.jsp").forward(request,response);
    }
}
