package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;
import pl.coderslab.model.Vehicle;
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

@WebServlet(name = "Main", urlPatterns = "")
public class Main extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        String submit = request.getParameter("submit");
        String [] sub = submit.split(" ");
        submit = "/detailOrderByEmployee?submit="+sub[2];

        response.sendRedirect(submit);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



//        List<Order> orderList = null;
//        List<Vehicle> vehicleList = null;
//        List<Customer> customerList = null;
//
//        //TODO nie chce tutaj miec try catch, wyglada to paskudnie
//        try {
//            orderList = OrderDao.loadAll();
//            vehicleList = VehicleDao.loadAll();
//            customerList = CustomerDao.loadAll();
//
//            System.out.println("");
//        }catch (SQLException e){
//            System.out.println("error with loadAll from OrderDao in /Main");
//        }

        EmployeeDao employeeDao = new EmployeeDao();
        List<Employee> employeeList = employeeDao.loadAll();


        int[] ordersHaveEmployee = howMutchOrdersHaveEmployee(employeeList.size());



        request.setAttribute("ordersHaveEmployee",ordersHaveEmployee);
        request.setAttribute("employeeList" , employeeList);
        getServletContext().getRequestDispatcher("/WEB-INF/main.jsp").forward(request,response);
    }


    //Help function- how mutch orgers have Employee


    private int[] howMutchOrdersHaveEmployee(int sizeEmployee){
        String query = "";
        int[] orderValue = new int[sizeEmployee];
        for(int employeeId =1 ; employeeId<=sizeEmployee;employeeId++){
            int counter = 0;
            query = "SELECT * FROM car_service.`order` WHERE status_id=3 && employee_id="+employeeId;

            try(ResultSet rs = DBService.executeQuery(DBService.connect("car_service"),query)){

                while (rs.next()){
                    orderValue[employeeId-1] = ++counter;
                }

            }catch (SQLException e){
                System.out.println("Error in howMutchOrdersHaveEmployee FROM Main.java");
            }
        }


        return orderValue;
    }
}
