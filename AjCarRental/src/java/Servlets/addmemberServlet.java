/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Hibernate.HybernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author Johan Nilsson
 */
@WebServlet(name = "addmemberServlet", urlPatterns = {"/addmemberServlet"})
public class addmemberServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        if (request.getParameter("Submit") != null) {
            String username = request.getParameter("username");
            String userpass = request.getParameter("password");
            String name = request.getParameter("name");
            String adress = request.getParameter("adress");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            try{
                HybernateUtil hu = new HybernateUtil();
            SessionFactory sessionFactory = hu.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();
            
            String queryString = "INSERT INTO login set username = :username, userpass = :userpass";
            Query query = session.createSQLQuery(queryString);
            query.setParameter("username", username);
            query.setParameter("userpass", userpass);
            
            queryString = "INSERT INTO user set Login_idLogin = LAST_INSERT_ID(), Name = :name, Adress=:adress, Email =:email, Phone = :phone";
            query = session.createSQLQuery(queryString);
            query.setParameter("name", name);
            query.setParameter("adress", adress);
            query.setParameter("email", email);
            query.setParameter("phone", phone);
            tx.commit();
            hu.close();
                System.out.println("Success");
            }catch(Exception e){
                e.printStackTrace();
            }
                
         
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
