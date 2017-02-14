package Servlets;

import Hibernate.HybernateUtil;
import Beans.statefulBean;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import EntityBeans.Car;
import java.util.Iterator;

/**
 *
 * @author Johan Nilsson
 */
@WebServlet(name = "showavilableCarsServlet", urlPatterns = {"/showavilableCarsServlet"})
public class showavilableCarsServlet extends HttpServlet {

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

        //first we check what the user wants to do? either look thru booking history or rent a car
        if (request.getParameter("checkcars") != null) {
            //here we come if you want to rent a car
            Transaction tx = null;
            Session session = null;
            String pickupstring = "";
            String dropoffstring = "";
            HybernateUtil hu = null;
            ArrayList<Car> Cars = null;

            
            //first we handle the information needed to find a car
            //the dates and where it is going to be picked up/dropped off
            //this gets saved to the datastorage
            pickupstring = request.getParameter("pickupdate");
            System.out.println(pickupstring);
            dropoffstring = request.getParameter("dropoffdate");
            System.out.println(dropoffstring);

            String[] fpuDate = pickupstring.split("/");
            String[] fdoDate = dropoffstring.split("/");

            String corrpuDate = fpuDate[2] + "-" + fpuDate[0] + "-" + fpuDate[1];
            String corrdoDate = fdoDate[2] + "-" + fdoDate[0] + "-" + fdoDate[1];
            System.out.println("correct pick up date: " + corrpuDate);
            System.out.println("correct drop of date: " + corrdoDate);

            statefulBean sfb = new statefulBean();

            sfb.setPickUpDate(pickupstring);
            sfb.setDropOfDate(dropoffstring);
            sfb.setCorrPickUpDate(corrpuDate);
            sfb.setCorrDropOfDate(corrdoDate);

            if (sfb.getLoggedIn() == 1) {

            } else {
                //if its not member the client must fill in some extra information that we dont know yet
                //so that we can create a full booking
                //this happens here
                //saves more to datastorage
                String name = request.getParameter("name");
                String address = request.getParameter("adress");
                String email = request.getParameter("email");
                String phone = request.getParameter("phone");

                sfb.setName(name);
                sfb.setAddres(address);
                sfb.setMail(email);
                sfb.setPhone(phone);
            }

            
            
            String pickupLocation = request.getParameter("pickuploc");
            String dropoffLocation = request.getParameter("dropoffloc");
            System.out.println(pickupLocation);
            System.out.println(dropoffLocation);
            sfb.setPickUpLocation(pickupLocation);
            sfb.setDropOfLocation(dropoffLocation);

            //here we get the avaliaable cars before sending them in a list to the next jsp we get redirected to
            //we connect to the database to get the carlist
            hu = new HybernateUtil();
            SessionFactory sessionFactory = hu.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            System.out.println("cretaied sessions");

            String queryString = "SELECT * FROM car WHERE idCar not in (SELECT Car_idCar FROM BOOKING WHERE startdate BETWEEN :startdate  AND :returndate)";

            Query query = session.createSQLQuery(queryString);
            System.out.println("Query::::" + query.getQueryString().toString());
            query.setParameter("startdate", corrpuDate);
            query.setParameter("returndate", corrdoDate);
            request.setAttribute("Carlist", query.list());
            request.getRequestDispatcher("listcars.jsp").forward(request, response);
            tx.commit();
            System.out.println("txcommit.............................................................................");
            hu.close();
        }
        if (request.getParameter("billhistory") != null) {
            HybernateUtil hu = null;
            Transaction tx = null;
            Session session = null;
            statefulBean sfb = new statefulBean();
            
            //here we do the same as the code above but we get a list of bookings instead so that
            //we can append the bookings from the list we get from the database in the next jsp we get redirected to
            hu = new HybernateUtil();
            SessionFactory sessionFactory = hu.getSessionFactory();
            session = sessionFactory.getCurrentSession();
            tx = session.beginTransaction();
            System.out.println("cretaied sessions");

            String queryString = "SELECT * FROM booking where ClientName = :ClientName";
            
            Query query = session.createSQLQuery(queryString);
            query.setParameter("ClientName", sfb.getName());
            request.setAttribute("Bookinglist", query.list());
            request.getRequestDispatcher("listBookings.jsp").forward(request, response);
            tx.commit();
            hu.close();

            
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
