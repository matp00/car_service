package pl.coderslab.controller;
import pl.coderslab.dao.VehicleDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addVehicle", urlPatterns = "/addVehicle")
public class addVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<String> params=new ArrayList<>();
            try{
            String brand = request.getParameter("brand"); params.add(brand);
            String model = request.getParameter("model"); params.add(model);
            int production_year = Integer.parseInt(request.getParameter("production_year")); params.add(String.valueOf(production_year));
            String registration_number = request.getParameter("registration_number"); params.add(registration_number);
            String next_service = request.getParameter("next_service"); params.add(next_service);
            Integer customer_id=null;
            if(request.getParameter("customer_id") != "") {
                customer_id = Integer.parseInt(request.getParameter("customer_id"));
                params.add(String.valueOf(customer_id));
            }
            else params.add("NULL");

            VehicleDao.addVehicle(params);
                request.setAttribute("information", "Dodano do bazy");
                getServletContext().getRequestDispatcher("/WEB-INF/fragments/addVehicle.jsp").forward(request,response);
       }catch (Exception e){
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/addVehicle.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    getServletContext().getRequestDispatcher("/WEB-INF/fragments/addVehicle.jsp").forward(request, response);
    }
}
