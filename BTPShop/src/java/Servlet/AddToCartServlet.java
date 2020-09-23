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
import javax.annotation.Resource;
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
 * @author lenovo
 */
public class AddToCartServlet extends HttpServlet {

    @PersistenceUnit(unitName = "BTPShopPU")
    EntityManagerFactory emf;
    @Resource
    UserTransaction utx;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        String productname = request.getParameter("productname");
        String quantity = request.getParameter("quantity");
        int TotalPrice = 0;
        int thisquantity = 0;

        thisquantity = Integer.valueOf(quantity);

        if (thisquantity > 0) {
            ProductJpaController productC = new ProductJpaController(utx, emf);
            Product P = productC.findProduct(productname);
            if (session != null) {
                List<Product> cart = (List<Product>) session.getAttribute("cart");
                if (cart == null) {
                    cart = new ArrayList<>();
                    P.setProductqueslity(Integer.valueOf(quantity));
                    cart.add(P);

                } else {

                    boolean isFound = false;
                    for (Product product : cart) {
                        if (P.getProductname().equals(product.getProductname())) {
                            product.setProductqueslity(product.getProductqueslity() + thisquantity);
                            isFound = true;
                        }
                    }
                    if (!isFound) {
                        P.setProductqueslity(Integer.valueOf(quantity));
                        cart.add(P);
                    }

                }

                session.setAttribute("cart", cart);
            }

            getServletContext().getRequestDispatcher("/Store").forward(request, response);
            return;
        }
        getServletContext().getRequestDispatcher("/Store").forward(request, response);
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
