/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;
 
import EntityBeans.Login;
import EntityBeans.User;
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
import org.hibernate.cfg.Configuration;
import Hibernate.HybernateUtil;
import static java.util.Collections.list;
import java.util.List;
import org.hibernate.Query;
import java.util.LinkedList;
import Beans.statefulBean;
 
/**
 *
 * @author Johan Nilsson
 */
@WebServlet(name = "loginServlet", urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
 
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
        if (request.getParameter("Submit") != null) {
            System.out.println("Submit pressed");
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            HybernateUtil hu = new HybernateUtil();
            SessionFactory sessionFactory = hu.getSessionFactory();
 
            Session session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            System.out.println("Session beginTransaction");
 
            String queryString = "Select * from Login where Login.username= :user";
            Query query = session.createSQLQuery(queryString);
            System.out.println("querylist made");
            query.setParameter("user", user);
            List loginlist = query.list();
            Object[] obj = null;
            for(Object o : loginlist){
                obj =(Object[])o;
                System.out.println(obj[0]);
            }
            System.out.println("added query.list to List ");
            session.getTransaction().commit();
            System.out.println("commit");
            int id = Integer.parseInt(obj[0].toString());
            String gotname =obj[1].toString();
            String gotpass =obj[2].toString();
            String gotstatus=obj[3].toString();
 
            session = sessionFactory.openSession();
            session.beginTransaction();
            User u = new User();
            System.out.println("new user");
            u = (User) session.get(User.class, id);
            session.getTransaction().commit();
            System.out.println("commit");
 
            for (int i = 0; i < loginlist.size(); i++) {
                System.out.println("in for loop");
 
                if (gotname.equals(user) && gotpass.equals(pass)) {
                    System.out.println("Success");
                    statefulBean stb = new statefulBean();
                    stb.setName(u.getName());
                    stb.setAddres(u.getAdress());
                    stb.setMail(u.getEmail());
                    stb.setPhone(u.getPhone());
                    stb.setLoggedIn(1);
                    try {
 
                        if (gotstatus.equals("member")) {
                            session = sessionFactory.getCurrentSession();
                            session.beginTransaction();
                            queryString = "SELECT * FROM Office";
                            query = session.createSQLQuery(queryString);
                            System.out.println("Query::::" + query.getQueryString().toString());;
                            request.setAttribute("Loc", query.list());
                            request.setAttribute("Username", gotname);
                            System.out.println("member");
                            request.getRequestDispatcher("homemember.jsp").forward(request, response);
                        } else if (gotstatus.equals("admin")) {
                            session = sessionFactory.getCurrentSession();
                            session.beginTransaction();
                            queryString = "SELECT * FROM Office";
                            query = session.createSQLQuery(queryString);
                            System.out.println("Query::::" + query.getQueryString().toString());;
                            request.setAttribute("Loc", query.list());
                            request.setAttribute("Username", gotname);
                            System.out.println("admin");
                            request.getRequestDispatcher("homeadmin.jsp").forward(request, response);
                        }
 
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
 
                } else {
                    String error = "Your Username and/or Password dont exist";
                    System.out.println("redirect to login in for");
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("payment.jsp").forward(request, response);
                }
            }
            if (obj.length == 0) {
                String error = "Your Username and/or Password dont exist";
                System.out.println("redirekt to login utside for");
                request.setAttribute("error", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
//        hu.close();
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
