package pl.coderslab.controller;

import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "editOrder", urlPatterns = "/editOrder")
public class editOrder extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> params=new HashMap<>();
        try {
            int status_id=Integer.parseInt(request.getParameter("status_id")); params.put("status_id",String.valueOf(status_id));
            int vehicle_id=Integer.parseInt(request.getParameter("vehicle_id"));params.put("vehicle_id",String.valueOf(vehicle_id));
            String problem_description=request.getParameter("problem_description");params.put("problem_description",problem_description);
            String acceptance=request.getParameter("acceptance");params.put("acceptance",acceptance);
            String planned_maintenance=request.getParameter("planned_maintenance");params.put("planned_maintenance",planned_maintenance);
            String maintenance_start=request.getParameter("maintenance_start");params.put("maintenance_start",maintenance_start);
            int employee_id=Integer.parseInt(request.getParameter("employee_id"));params.put("employee_id",String.valueOf(employee_id));
            String maintenance_description=request.getParameter ("maintenance_description");params.put("maintenance_description",maintenance_description);
            double total_price=Double.parseDouble(request.getParameter("total_price"));params.put("total_price",String.valueOf(total_price));
            double parts_cost=Double.parseDouble(request.getParameter("parts_cost"));params.put("parts_cost",String.valueOf(parts_cost));
            int hours_amount=Integer.parseInt(request.getParameter("hours_amount"));params.put("hours_amount",String.valueOf(hours_amount));
        }catch(Exception e){
            System.out.println(e);
        }
        Cookie[] cookies=request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("orderId")) {
                int orderId = Integer.parseInt(c.getValue());
                OrderDao.editOrder(params,orderId);
                getServletContext().getRequestDispatcher("/WEB-INF/fragments/editOrder.jsp").forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int orderId = Integer.parseInt(request.getParameter("id"));
            Cookie cookie= new Cookie("orderId",String.valueOf(orderId));
            response.addCookie(cookie);
            Order order = OrderDao.loadById(orderId);
            request.setAttribute("order",order);
        }catch (Exception e){
            System.out.println("Cannot convert editOrder to Integer");
        }


        getServletContext().getRequestDispatcher("/WEB-INF/fragments/editOrder.jsp").forward(request,response);
    }
}
