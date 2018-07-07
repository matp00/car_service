package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "editEmployee" ,urlPatterns = "/editEmployee")
public class editEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        //Edytuje
        try{
            int id = Integer.parseInt(request.getParameter("id"));
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String note = request.getParameter("note");
            Double hourly = Double.parseDouble(request.getParameter("hourly"));
            String email = request.getParameter("email");

            //Formatowanie daty
            String birthDate = request.getParameter("birthDate");

            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = new Employee(id,name,surname,address,phone,note,hourly,email,birthDate);

            employeeDao.editEmployee(employee);

            response.getWriter().append("Dodano do bazy");




        }catch (Exception e){
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/editEmployee.jsp").forward(request,response);
        }

        getServletContext().getRequestDispatcher("/WEB-INF/editEmployee.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        int employeeId = 1;
        //Sprawdza po id
        try {
            employeeId = Integer.parseInt(request.getParameter("id"));
            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = employeeDao.getEmployeeById(employeeId);
            request.setAttribute("employee",employee);
        }catch (Exception e){
            System.out.println("Cannot convert editEmployee to Integer");
        }


        getServletContext().getRequestDispatcher("/WEB-INF/editEmployee.jsp").forward(request,response);
    }
}
