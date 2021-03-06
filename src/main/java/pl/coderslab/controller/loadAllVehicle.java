package pl.coderslab.controller;

import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "loadAllVehicle", urlPatterns = "/loadAllVehicle")
public class loadAllVehicle extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            List<Vehicle> vehicles = VehicleDao.loadAll();
            request.setAttribute("vehicles", vehicles);
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/loadAllVehicle.jsp").forward(request,response);


    }
}
