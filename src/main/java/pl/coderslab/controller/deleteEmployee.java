package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "deleteEmployee", urlPatterns = "/deleteEmployee")
public class deleteEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int employeeId = Integer.parseInt(request.getParameter("id"));

            EmployeeDao employeeDao = new EmployeeDao();
            employeeDao.delete(employeeId);
        }catch (Exception e){
            System.out.println("Cannot convert loadByIdEmployee to Integer");
        }

        getServletContext().getRequestDispatcher("/WEB-INF/Administration.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        getServletContext().getRequestDispatcher("/WEB-INF/deleteEmployee.jsp").forward(request,response);
    }
}
