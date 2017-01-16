/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import EntityBeans.Login;
import EntityBeans.User;
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
            Login lid = null;
            try {
                HybernateUtil hu = new HybernateUtil();
                SessionFactory sessionFactory = hu.getSessionFactory();
                Session session = sessionFactory.getCurrentSession();
                Transaction tx = session.beginTransaction();
    
                Login l = new Login(username, userpass, "member");
                session.save(l);
                session.getTransaction().commit();
                        
                session = sessionFactory.getCurrentSession();
                tx = session.beginTransaction();


                String queryString = "Select l from Login l where l.username= :user";
                Query query = session.createQuery(queryString);
                query.setParameter("user", username);

                List<EntityBeans.Login> loginlist = query.list();
                for (EntityBeans.Login login : loginlist) {
                    if (login.getUsername().equals(username) && login.getUserpass().equals(userpass)) {
                        lid = new Login(login.getUsername(), login.getUserpass(), login.getStatus());
                        lid.setIdLogin(login.getIdLogin());
                    }
                }
                tx.commit();
                session = sessionFactory.getCurrentSession();
                tx = session.beginTransaction();

                User u = new User(lid, name, adress, email, phone);
                u.setLoginIdLogin(lid.getIdLogin());

                session.save(u);
                session.getTransaction().commit();
                

                hu.close();
                System.out.println("Success");
            } catch (Exception e) {
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
