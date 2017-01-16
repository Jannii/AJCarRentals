/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EntityBeans.Booking;
import EntityBeans.Car;
import Hibernate.HybernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author bumblebee
 */
@WebServlet(name = "rentcarServlet", urlPatterns = {"/rentcarServlet"})
public class rentcarServlet extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet rentcarServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet rentcarServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
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
        if (request.getParameter("Submit") != null) {
            try {
                //get parameters
                
                //PaymentCode goes here
                
                HybernateUtil hu = new HybernateUtil();
                SessionFactory sessionFactory = hu.getSessionFactory();

               Session session = sessionFactory.openSession();
               session.beginTransaction();
               Car c = new Car();        
               c = (Car) session.get(Car.class, 1);
               session.getTransaction().commit();

                session = sessionFactory.openSession();
                //Transaction tx = session.beginTransaction();
                session.beginTransaction();

                Booking b = new Booking(c, "Johan Nilsson", "gatan2", "johan@mail.se", "0713131", "false", "2000", "2017-01-16", "2017-01-16", "2017-01-21", "Kristianstad", "Kristianstad");
                session.save(b);
                session.getTransaction().commit();

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        processRequest(request, response);

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
