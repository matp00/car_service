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
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "RaportHours" , urlPatterns = "/raportHours")
public class RaportHours extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String dateBegin = request.getParameter("dateBegin");
        String dateEnd = request.getParameter("dateEnd");

        String query = "SELECT * FROM car_service.`order` WHERE maintenance_start BETWEEN '"+dateBegin+"' AND '"+dateEnd+"';";
        try {
            List<Order> orderListRaport = OrderDao.loadAll(query);
            EmployeeDao employeeDao = new EmployeeDao();
            List<Employee> employeeListRaport = employeeDao.loadAll();

            double []timeSpendByDate = new double[employeeListRaport.size()];

            Iterator<Order> it = orderListRaport.iterator();

            while (it.hasNext()){
                Order order = it.next();
                timeSpendByDate[order.getEmployee_id()-1] += order.getHours_amount();
            }


            request.setAttribute("employeeListRaport", employeeListRaport);
            request.setAttribute("timeSpendByDate",timeSpendByDate);

        } catch (Exception e) {
            System.out.println("Error in raportHours");
            System.out.println(e.getMessage());
        }






        getServletContext().getRequestDispatcher("/WEB-INF/raportHours.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {



        getServletContext().getRequestDispatcher("/WEB-INF/raportHours.jsp").forward(request,response);
    }
}
