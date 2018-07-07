package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.dao.VehicleDao;
import pl.coderslab.model.Customer;
import pl.coderslab.model.Vehicle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "editCustomer", urlPatterns = "/editCustomer")
public class editCustomer extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> params=new HashMap<>();
        try {
            String name = request.getParameter("name").trim();
            params.put("name", name);
            String surname = request.getParameter("surname").trim();
            params.put("surname", surname);
            String address = request.getParameter("address").trim();
            params.put("address", address);
            String phone = request.getParameter("phone").trim();
            params.put("phone", phone);
            String email = request.getParameter("email").trim();
            params.put("email", email);
            String birth_date = request.getParameter("birth_date").trim();
            params.put("birth_date", birth_date);
        }catch(Exception e){
            System.out.println(e);
        }

        Cookie[] cookies=request.getCookies();
        for (Cookie c : cookies) {
            if (c.getName().equals("customerId")) {
                int customerId = Integer.parseInt(c.getValue());
                CustomerDao.editCustomer(params,customerId);
                getServletContext().getRequestDispatcher("/WEB-INF/fragments/editCustomer.jsp").forward(request,response);
            }
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            int customerId = Integer.parseInt(request.getParameter("id"));
            Cookie cookie= new Cookie("customerId",String.valueOf(customerId));
            response.addCookie(cookie);
            Customer customer = CustomerDao.loadById(customerId);
            request.setAttribute("customer",customer);
            getServletContext().getRequestDispatcher("/WEB-INF/fragments/editCustomer.jsp").forward(request,response);
        }catch (Exception e){
            System.out.println("Cannot convert editCustomer to Integer");
            System.out.println(e);
        }


       getServletContext().getRequestDispatcher("/WEB-INF/fragments/editCustomer.jsp").forward(request,response);
    }
}
