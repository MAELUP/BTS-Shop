/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.Resource;
import javax.persistence.Entity;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.transaction.UserTransaction;
import model.jpa.Product;
import model.jpa.controller.ProductJpaController;

/**
 *
 * @author user
 */
public class SearchServlet extends HttpServlet {

    @PersistenceUnit(unitName = "BTPShopPU")
    EntityManagerFactory emf;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String findProduct = request.getParameter("findProduct");
        String costMin = request.getParameter("costMin");
        String costMax = request.getParameter("costMax");
       ProductJpaController productJpa = new ProductJpaController(utx, emf);
        List<Product> proList = productJpa.findProductEntities();
        ArrayList<Object> storeList = new ArrayList<Object>();

        if (findProduct != null) {
            for (Product strc : proList) {
                if (productJpa.findProduct(strc.getProductname()).equals(findProduct)) {
                    storeList.add(strc);
                } else if (productJpa.findProduct(strc.getProductname()).getProductname().indexOf(findProduct) >= 0) {
                    storeList.add(strc);
                } else if (productJpa.findProduct(strc.getProductname()).getProducttype().indexOf(findProduct) >= 0) {
                    storeList.add(strc);
                } else if (productJpa.findProduct(strc.getProductname()).getProductprice().equals(findProduct)) {
                    storeList.add(strc);
                }
            }
            request.setAttribute("store", storeList);
            getServletContext().getRequestDispatcher("/ShowProduct.jsp").forward(request, response);
            return;
        }
        if (costMin != null && costMax != null) {
            if (Integer.valueOf(costMin) <= Integer.valueOf(costMax)) {   
                for (Product strc : proList) {
                    if (Integer.valueOf(productJpa.findProduct(strc.getProductname()).getProductprice()) >= Integer.valueOf(costMin)
                            && Integer.valueOf(productJpa.findProduct(strc.getProductname()).getProductprice()) <= Integer.valueOf(costMax)) {
                        storeList.add(strc);
                    }
                }

            }
            request.setAttribute("store", storeList);
            getServletContext().getRequestDispatcher("/ShowProduct.jsp").forward(request, response);
            return;
          } else {
            request.setAttribute("store", proList);

            getServletContext().getRequestDispatcher("/ShowProduct.jsp").forward(request, response);
            return;
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
