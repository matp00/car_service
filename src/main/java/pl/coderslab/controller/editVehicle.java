package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "editVehicle", urlPatterns = "/editVehicle")
public class editVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> params=new HashMap<>();
        try {
            String brand = request.getParameter("brand").trim(); params.put("brand",brand);
            String model = request.getParameter("model").trim(); params.put("model", model);
            String production_year = request.getParameter("production_year").trim(); params.put("production_year", production_year);
            String registration_number = request.getParameter("registration_number").trim(); params.put("registration_number",registration_number);
            String next_service = request.getParameter("next_service").trim(); params.put("next_service", next_service);
            int customer_id = Integer.parseInt(request.getParameter("customer_id").trim()); params.put("customer_id",String.valueOf(customer_id));
        }catch(Exception e){
            System.out.println(e);
        }
        Cookie[] cookies=request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("vehicleId")) {
                int vehicleId = Integer.parseInt(c.getValue());
                VehicleDao.editVehicle(params,vehicleId);
                getServletContext().getRequestDispatcher("/WEB-INF/fragments/editVehicle.jsp").forward(request,response);
            }
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Sprawdza po id
        try {
            int vehicleId = Integer.parseInt(request.getParameter("id"));
            Cookie cookie= new Cookie("vehicleId",String.valueOf(vehicleId));
            response.addCookie(cookie);
            Vehicle vehicle = VehicleDao.loadById(vehicleId);
            request.setAttribute("vehicle",vehicle);
        }catch (Exception e){
            System.out.println("Cannot convert editVehicle to Integer");
        }


        getServletContext().getRequestDispatcher("/WEB-INF/fragments/editVehicle.jsp").forward(request,response);
    }
}
