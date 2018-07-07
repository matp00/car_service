package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;
import pl.coderslab.services.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "DetailOrderByEmployee" , urlPatterns = "/detailOrderByEmployee")
public class DetailOrderByEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String submit = request.getParameter("submitShowOrder");
        String [] sub = submit.split(" ");
        submit = "/orderDetail?submit="+sub[1];

        response.sendRedirect(submit);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {




        String employee = request.getParameter("submit");
        String query = "SELECT * FROM car_service.`order` WHERE status_id=3 && employee_id="+employee;
        List<Order> orderList = null;
        try {
            orderList = (List) OrderDao.loadAll(query);
        }catch (SQLException e){
            System.out.println("error with loadAll from OrderDao in /detailOrderByEmployee");
        }

        System.out.println("");



        request.setAttribute("orderList",orderList);
        getServletContext().getRequestDispatcher("/WEB-INF/detailOrderByEmployee.jsp").forward(request,response);
    }


}
