package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "OrderDetail" , urlPatterns = "/orderDetail")
public class OrderDetail extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String submit = request.getParameter("submit");

        try {
            Order order = OrderDao.loadById(Integer.parseInt(submit));
            Vehicle vehicle = VehicleDao.loadById(order.getVehicle_id());
            Customer customer = CustomerDao.loadById(vehicle.getCustomer_id());


            request.setAttribute("vehicle",vehicle);
            request.setAttribute("customer",customer);
        }catch (Exception e){
            System.out.println("Something wrong in OrderDetail.java");
            System.out.println(e.getMessage());
        }

        getServletContext().getRequestDispatcher("/WEB-INF/orderDetail.jsp").forward(request,response);
    }
}
