package pl.coderslab.controller;
import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "addCustomer", urlPatterns = "/addCustomer")
public class addCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            List<String> params=new ArrayList<>();
            String name = request.getParameter("name"); params.add(name);
            String surname = request.getParameter("surname"); params.add(surname);
            String address = request.getParameter("address"); params.add(address);
            String phone = request.getParameter("phone"); params.add(phone);
            String email = request.getParameter("email"); params.add(email);
            String birth_date = request.getParameter("birth_date"); params.add(birth_date);

            CustomerDao.addCustomer(params);
            request.setAttribute("information", "Dodano do bazy");
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/addCustomer.jsp").forward(request,response);

            //request.setAttribute("information", "Incorrect data");
            //getServletContext().getRequestDispatcher("/WEB-INF/fragments/addCustomer.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/addCustomer.jsp").forward(request, response);
    }
}
