package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import pl.coderslab.services.DBService;

@WebServlet(name = "test", urlPatterns = "/test")
public class test extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


       List<Customer> customers=null;
        Customer customer=new Customer("marcin","zaluk","bratkowa 13","509467034","za2l@gmail.com","1991-03-15");
        CustomerDao.addCustomer(customer);
        response.getWriter().append(customer.getId()+"");
        try (Connection conn=DBService.connect("car_service")){
            customers=CustomerDao.loadAll(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.setAttribute("customers", customers);
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/test.jsp").forward(request,response);
    }
}
