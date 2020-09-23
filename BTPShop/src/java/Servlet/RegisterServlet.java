/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.jpa.Account;
import model.jpa.controller.AccountJpaController;
import model.jpa.controller.exceptions.RollbackFailureException;

/**
 *
 * @author user
 */
public class RegisterServlet extends HttpServlet {

   @PersistenceUnit(unitName = "BTPShopPU")
   EntityManagerFactory emf;
   @Resource
   UserTransaction utx;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, RollbackFailureException, Exception {
       
        HttpSession session = request.getSession(false);

        String username = request.getParameter("username").trim();
        String email = request.getParameter("email").trim();
        String password = request.getParameter("password").trim();
        String err = "";

        if (session != null) {
            session.invalidate();
        }

        if (username == null || username.length()<= 0 || email == null || email.length() <=0 || password == null || password.length()<=0) {
            request.setAttribute("err", "ERROR : Please full fill & No spaces");
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
   
        }
        AccountJpaController regisCtrl = new AccountJpaController(utx, emf);
        List<Account> regList = regisCtrl.findAccountEntities();

        for (Account regc : regList) {

            if (regisCtrl.findAccount(regc.getUsername()).getUsername().equals(username)) {

                err = err + "User is repeatedly, ";
            }
            if (regisCtrl.findAccount(regc.getUsername()).getEmail().equals(email)) {

                err = err + "Email is repeatedly, ";
            }
        }

        if (!(err.equals(""))) {
            request.setAttribute("err", "ERROR : " + err);
            getServletContext().getRequestDispatcher("/Register.jsp").forward(request, response);
            return;
        }

        Account regis = new Account();
        
        regis.setUsername(username);
        regis.setEmail(email);
        regis.setPassword(password);
        regisCtrl.create(regis);      
       
        getServletContext().getRequestDispatcher("/Login.jsp").forward(request, response);
        return;
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
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
       }
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
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
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
