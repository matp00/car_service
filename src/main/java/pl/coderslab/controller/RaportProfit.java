package pl.coderslab.controller;

import pl.coderslab.dao.EmployeeDao;
import pl.coderslab.dao.OrderDao;
import pl.coderslab.model.Employee;
import pl.coderslab.model.Order;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "RaportProfit", urlPatterns = "/raportProfit")
public class RaportProfit extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        String dateBegin = request.getParameter("dateBegin");
        String dateEnd = request.getParameter("dateEnd");

        String query = "SELECT * FROM car_service.`order` WHERE maintenance_start BETWEEN '"+dateBegin+"' AND '"+dateEnd+"';";
        //nie mamy daty zakonczenia naprawy wiec bedzie po dacie rozpoczecia naprawy

        double profit = 0;

        try {

            List<Order> orderListProfitRaport = OrderDao.loadAll(query);
            EmployeeDao employeeDao = new EmployeeDao();
            List<Employee> employeeList = employeeDao.loadAll();

            Iterator<Order> it = orderListProfitRaport.iterator();

            while (it.hasNext()){
                Order order = it.next();

                double hours = order.getHours_amount();
                int employeeId = order.getEmployee_id();


                profit = profit+ (hours*employeeList.get(employeeId-1).getHourly());
            }


        }catch (Exception e){
            System.out.println("Error in RaportProfit");
            System.out.println(e.getMessage());
        }

        request.setAttribute("profit", profit);
        getServletContext().getRequestDispatcher("/WEB-INF/raportProfit.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        getServletContext().getRequestDispatcher("/WEB-INF/raportProfit.jsp").forward(request,response);
    }
}
