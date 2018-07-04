package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "loadAllEmployee" , urlPatterns = "/loadAllEmployee")
public class loadAllEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.loadAll();
        System.out.println("");


        request.setAttribute("employeList", employeeList);
        getServletContext().getRequestDispatcher("/WEB-INF/loadAllEmployee.jsp").forward(request,response);
    }
}
