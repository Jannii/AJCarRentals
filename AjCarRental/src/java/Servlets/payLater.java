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
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.jms.ConnectionFactory;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
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
@WebServlet(name = "payLater", urlPatterns = {"/payLater"})
public class payLater extends HttpServlet {

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

    private void sendMessage(String message) throws IOException {
        try {
            Context ctx = new InitialContext();
            //ConnectionFactory     connectionFactory = (ConnectionFactory)ctx.lookup("tConnectionFactory");
            //Queue     queue = (Queue)ctx.lookup("jms/tQueue");

            //connects to the JMS via connectionFactory and queue
            //sends the message about the booking to the MBD
            //MDB uses javaMail to send the mail to the client
            System.out.println("1111111111111111111111111111");
            ConnectionFactory connectionFactory = (ConnectionFactory) ctx.lookup("ReqConnectionFactory");
            Queue queue = (Queue) ctx.lookup("jms/Queue");

            javax.jms.Connection connection = connectionFactory.createConnection();
            javax.jms.Session session = connection.createSession(false, javax.jms.Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            TextMessage JMSmessage = session.createTextMessage();
            JMSmessage.setText(message);
            System.out.println("***** RegServlet: Sent the message to YourQueue:" + JMSmessage.getText());
            messageProducer.send(JMSmessage);
        } catch (Exception ex) {
            ex.printStackTrace();
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

        System.out.println("Det gick som det skall");
        //if (request.getParameter("Submit") == null) {
        try {
            //gets the current date for the booking info
            statefulBean stb = new statefulBean();
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date today = dateFormat.parse(dateFormat.format(new Date()));
            String todayDate = dateFormat.format(today);
            //get parameters
            System.out.println("DET FUNKAR!!!!");

            HybernateUtil hu = new HybernateUtil();
            SessionFactory sessionFactory = hu.getSessionFactory();

            //connects to the database to get car info
            Session session = sessionFactory.openSession();
            session.beginTransaction();
            Car c = new Car();
            c = (Car) session.get(Car.class, stb.getCarId());
            session.getTransaction().commit();

            session = sessionFactory.openSession();
            //Transaction tx = session.beginTransaction();
            session.beginTransaction();

            String totalPrice = "" + stb.getCarPrice();

            System.out.println(stb.getName() + "/" + stb.getAddres() + "/" + stb.getMail() + "/" + stb.getPhone() + "/false/ " + totalPrice + "/" + todayDate + "/" + stb.getCorrPickUpDate() + "/" + stb.getCorrDropOfDate() + "/" + stb.getPickUpLocation() + "/" + stb.getDropOfLocation() + "/" + stb.getCarName());

            //creates new booking and adds it to the database
            Booking b = new Booking(c, stb.getName(), stb.getAddres(), stb.getMail(), stb.getPhone(), "false", totalPrice, todayDate, stb.getCorrPickUpDate(), stb.getCorrDropOfDate(), stb.getPickUpLocation(), stb.getDropOfLocation());
//            Booking b = new Booking(c, "axel malmberg", "ribersborgsvagen 13b", "axel.malmberg0002@stud.hkr.se", "0733447411", "true", "2000", "02/14/2017", "02/18/2017", "02/20/2017", "Kristianstad", "Kristianstad");
            session.save(b);
            session.getTransaction().commit();
            //String message = "Johan Nilsson/gatan2/axel.malmberg0002@stud.hkr.se/0713131/false/2000/2017-01-16/2017-01-16/2017-01-21/Kristianstad/Kristianstad/Volkswagen Passat";
            //Creates a message string that is sent to the mdb where java mail is.
            String message = stb.getName() + "/" + stb.getAddres() + "/" + stb.getMail() + "/" + stb.getPhone() + "/false/ " + stb.getCarPrice() + "/" + todayDate + "/" + stb.getCorrPickUpDate() + "/" + stb.getCorrDropOfDate() + "/" + stb.getPickUpLocation() + "/" + stb.getDropOfLocation() + "/" + stb.getCarName();
            sendMessage(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //  }
//        System.out.println(stb.getName() + "/" + stb.getAddres() + "/" + stb.getMail() + "/" + stb.getPhone() + "/true/ " + stb.getCarPrice() + "/" + todayDate + "/" + stb.getPickUpDate() + "/" + stb.getDropOfDate() + "/" + stb.getPickUpLocation() + "/" + stb.getDropOfLocation() + "/" + stb.getCarName());
        request.getRequestDispatcher("index.jsp").forward(request, response);
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
