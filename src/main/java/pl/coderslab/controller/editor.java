package pl.coderslab.controller;

import pl.coderslab.dao.CustomerDao;
import pl.coderslab.model.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

@WebServlet(name = "editor", urlPatterns = "/edit")
public class editor extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String, String> param=new HashMap();
        String name = request.getParameter("name").trim();
        if(name.length()>0) param.put("name",name);
        String surname = request.getParameter("surname").trim();
        if(surname.length()>0)param.put("surname",surname);
        String address = request.getParameter("address").trim();
        if(address.length()>0)param.put("address",address);
        String phone = request.getParameter("phone").trim();
        if(phone.length()>0)param.put("phone",phone);
        String email = request.getParameter("email").trim();
        if(email.length()>0)param.put("email",email);
        String birth_date = request.getParameter("birth_date").trim();
        if(birth_date.length()>0)param.put("birth_date",birth_date);
        //Set<String> keys=new HashSet<>();
        //for(String key: keys){
         //   String tmp=param.get(key);
          //  if(tmp == null || tmp == "Mateusz") param.remove(key);
        //}

        PrintWriter wr=response.getWriter();
        wr.println(param);
        int id=1;
        CustomerDao.editCustomer(param,id);



    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/WEB-INF/fragments/testedit.jsp").forward(request,response);
    }
}
