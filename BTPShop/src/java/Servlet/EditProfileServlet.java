/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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

/**
 *
 * @author lenovo
 */
public class EditProfileServlet extends HttpServlet {

   @Resource
   UserTransaction utx;
   @PersistenceUnit(unitName = "BTPShopPU")
   EntityManagerFactory emf;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        HttpSession session = request.getSession(false);
        //
        String fullname = request.getParameter("fullname");
        
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String province = request.getParameter("province");
        String district = request.getParameter("district");
        String postalcode = request.getParameter("postalcode");
        String tel = request.getParameter("tel");

        AccountJpaController accJpaCtrl = new AccountJpaController(utx, emf);

        Account acc;

        if (session != null) {
            acc = accJpaCtrl.findAccount(((Account) session.getAttribute("acc")).getUsername());
            if (acc != null) {
                if (fullname != null && fullname.trim().length() > 0
                        
                        && email != null && email.trim().length() > 0
                        && address != null && address.trim().length() > 0
                        && province != null && province.trim().length() > 0
                        && district != null && district.trim().length() > 0
                        && postalcode != null && postalcode.trim().length() > 0
                        && tel != null && tel.trim().length() > 0
                        ) {
                    
                   acc.setFullname(fullname);
                   
                   acc.setEmail(email);
                   acc.setAddress(address);
                   acc.setProvince(province);
                   acc.setDistrict(district);
                   acc.setPostalcode(postalcode);
                   acc.setTel(tel);
                    accJpaCtrl.edit(acc);

                    session.setAttribute("acc", acc);

                    request.getServletContext().getRequestDispatcher("/ProfileView.jsp").forward(request, response);
                }
            }
        }
        getServletContext().getRequestDispatcher("/EditProfileView.jsp").forward(request, response);
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
           Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(EditProfileServlet.class.getName()).log(Level.SEVERE, null, ex);
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
