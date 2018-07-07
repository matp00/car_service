package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addOrder", urlPatterns = "/addOrder")
public class addOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> params=new ArrayList<>();
        try{
        int status_id=Integer.parseInt(request.getParameter("status_id")); params.add(String.valueOf(status_id));
        int vehicle_id=Integer.parseInt(request.getParameter("vehicle_id"));params.add(String.valueOf(vehicle_id));
        String problem_description=request.getParameter("problem_description");params.add(problem_description);
        String acceptance=request.getParameter("acceptance");params.add(acceptance);
        String planned_maintenance=request.getParameter("planned_maintenance");params.add(planned_maintenance);
        String maintenance_start=request.getParameter("maintenance_start");params.add(maintenance_start);
        int employee_id=Integer.parseInt(request.getParameter("employee_id"));params.add(String.valueOf(employee_id));
        String maintenance_description=request.getParameter ("maintenance_description");params.add(maintenance_description);
        double total_price=Double.parseDouble(request.getParameter("total_price"));params.add(String.valueOf(total_price));
        double parts_cost=Double.parseDouble(request.getParameter("parts_cost"));params.add(String.valueOf(parts_cost));
        int hours_amount=Integer.parseInt(request.getParameter("hours_amount"));params.add(String.valueOf(hours_amount));

    }catch (Exception e){
        System.out.println(e);
            request.setAttribute("information", "Wrong format");
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/addOrder.jsp").forward(request,response);
    }
        System.out.println(params.size());
        System.out.println(params.toString());
        OrderDao.addOrder(params);
        request.setAttribute("information", "Dodano do bazy");
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/addOrder.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/addOrder.jsp").forward(request, response);
    }
}
