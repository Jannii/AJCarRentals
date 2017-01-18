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
import Beans.Userinfo;

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
            String user = request.getParameter("username");
            String pass = request.getParameter("password");
            Userinfo u = new Userinfo();
            HybernateUtil hu = new HybernateUtil();
            SessionFactory sessionFactory = hu.getSessionFactory();
            Session session = sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            String queryString = "Select l from Login l where l.username= :user";
            Query query = session.createQuery(queryString);
            query.setParameter("user", user);
            List<EntityBeans.Login> loginlist = query.list();
            System.out.println("cretaing list");
            for (EntityBeans.Login login : loginlist) {
                System.out.println("in for loop");
                
                if (login.getUsername().equals(user) && login.getUserpass().equals(pass)) {
                    System.out.println("Success");
                    try {
                        int  id = Integer.parseInt(loginlist.get(0).toString());
                        SessionFactory sessionFactory1 = hu.getSessionFactory();
                        Session session1 = sessionFactory1.getCurrentSession();
                        Transaction tx1 = session1.beginTransaction();
                        String queryString1 = "Select * from user where Login_idLogin= :id";
                        Query query1 = session1.createSQLQuery(queryString);
                        query.setParameter("id", id);
                        List<EntityBeans.User> User = query.list();
                        
                        u.setName(User.get(1).toString());
                        u.setAdress(User.get(2).toString());
                        u.setEmail(User.get(3).toString());
                        u.setPhone(User.get(4).toString());
                        if (login.getStatus().equals("member")) {
                            System.out.println("member");
                            request.getRequestDispatcher("homemember.jsp").forward(request, response);
                        } else if (login.getStatus().equals("admin")) {
                            request.getRequestDispatcher("homeadmin.jsp").forward(request, response);
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }

                } else {
                    String error = "Your Username and/or Password dont exist";
                    System.out.println("redirect to login in for");
                    request.setAttribute("error", error);
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
            }
            if (loginlist.size() == 0) {
                String error = "Your Username and/or Password dont exist";
                System.out.println("redirekt to login utside for");
                request.setAttribute("error", error);
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
            System.out.println("tx.commit");
            tx.commit();
            hu.close();
//            try {
//               Session session = hu.getSessionFactory().openSession();
//               session.beginTransaction();
//               u = (Login) session.get(Login.class, 2);
//               String name  = u.getUsername();
//               System.out.println(name);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }

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
