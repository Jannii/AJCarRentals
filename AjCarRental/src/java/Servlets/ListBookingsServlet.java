/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.statefulBean;
import EntityBeans.Booking;
import EntityBeans.Car;
import Hibernate.HybernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
@WebServlet(name = "ListBookingsServlet", urlPatterns = {"/ListBookingsServlet"})
public class ListBookingsServlet extends HttpServlet {

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
        
        //the loop checks what button you have clicked
        //the name of the button is the same as the bookings id
        // so that we can get the correct booking info from the database
        for (int i = 0; i < 1000; i++) {
            if (request.getParameter("" + i) != null) {
                System.out.println("The booking you chose had id: " + i);
                HybernateUtil hu = new HybernateUtil();
                SessionFactory sessionFactory = hu.getSessionFactory();
                
                //connects to the database and gets the correct booking info
                //and updates the datastorage
                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Booking b = new Booking();
                b = (Booking) session.get(Booking.class, i);
                session.getTransaction().commit();
                
                Car c = b.getCar();
                
                statefulBean stb = new statefulBean();
                stb.setBookingId(i);
                stb.setUpdate("true");
                
                //sends attributes to the next jsp so that the client can see what he is paying for
                request.setAttribute("carName", c.getCarName());
                request.setAttribute("carType", c.getCarType());
                request.setAttribute("carHome", c.getCarHome());
                request.setAttribute("carLocation", c.getCarlocation());
                request.setAttribute("pickUpDate", b.getStartDate());
                request.setAttribute("dropOdDate", b.getReturnDate());
                request.setAttribute("loggedIn", "" + stb.getLoggedIn());
                request.setAttribute("carPrice", b.getPrice());
                
                request.getRequestDispatcher("confirmPurchase.jsp").forward(request, response);
                
                
                
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
