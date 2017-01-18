/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Beans.statefulBean;
import EntityBeans.Car;
import Hibernate.HybernateUtil;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author bumblebee
 */
@WebServlet(name = "chooseCarServlet", urlPatterns = {"/chooseCarServlet"})
public class chooseCarServlet extends HttpServlet {

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
        for (int i = 0; i < 1000; i++) {
            if (request.getParameter("" + i) != null) {
                System.out.println("the car id you choose: " + i);

                HybernateUtil hu = new HybernateUtil();
                SessionFactory sessionFactory = hu.getSessionFactory();

                Session session = sessionFactory.openSession();
                session.beginTransaction();
                Car c = new Car();
                c = (Car) session.get(Car.class, i);
                session.getTransaction().commit();

                int price = c.getDailyPrice();

                statefulBean sfb = new statefulBean();
                String pickUpDate = sfb.getPickUpDate();
                String dropOfDate = sfb.getDropOfDate();
                Date startDate;
                Date endDate;
                DateFormat df = new SimpleDateFormat("yyyy-mm-dd");
                try {
                    startDate = df.parse(pickUpDate);
                    endDate = df.parse(dropOfDate);
                } catch (ParseException ex) {
                    Logger.getLogger(chooseCarServlet.class.getName()).log(Level.SEVERE, null, ex);
                }
                

                request.setAttribute("carName", c.getCarName());
                request.setAttribute("carType", c.getCarType());
                request.setAttribute("carHome", c.getCarHome());
                request.setAttribute("carLocation", c.getCarlocation());
                request.setAttribute("carPrice", price);
                request.getRequestDispatcher("paypal.jsp").forward(request, response);
                break;
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
