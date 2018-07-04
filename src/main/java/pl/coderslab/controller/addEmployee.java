package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "addEmployee", urlPatterns = "/addEmployee")
public class addEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //Validujemy przyjete dane w tym celu uzyjemy try Catch, jezeli cos zostanie podane nie tak to wraca do podania employee

        try{
            String name = request.getParameter("name");
            String surname = request.getParameter("surname");
            String address = request.getParameter("address");
            int phone = Integer.parseInt(request.getParameter("phone"));
            String note = request.getParameter("note");
            Double hourly = Double.parseDouble(request.getParameter("hourly"));
            String email = request.getParameter("email");

            //Formatowanie daty
            int year = Integer.parseInt(request.getParameter("year"));
            int month = Integer.parseInt(request.getParameter("month"));
            int day = Integer.parseInt(request.getParameter("day"));
            String birthDate ="";
            if(year <= 3000 && month <= 12 && day <= 31) birthDate = year+"-"+month+ "-"+day;
            else birthDate = " " +1/0;


            EmployeeDao employeeDao = new EmployeeDao();
            Employee employee = new Employee(employeeDao.getId()+1,name,surname,address,phone,note,hourly,email,birthDate);
            employeeDao.addEmployee(employee);

            response.getWriter().append("Dodano do bazy");




        }catch (Exception e){
            request.setAttribute("information", "Incorrect data");
            getServletContext().getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/addEmployee.jsp").forward(request,response);
    }
}
