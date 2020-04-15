/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bilisim.personelweb.controller;

import com.bilisim.personelweb.dao.GirisDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author taner
 */
// Giris.jsp de giriskontrol oldugu icin burdada url patterns ayni olmali
@WebServlet(name = "GirisKontrolServlet", urlPatterns = {"/girisKontrol"})
public class GirisKontrolServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String ad = request.getParameter("ad");//giris.jsp de ne yazdi isek onu yazacagiz.
        String sifre = request.getParameter("sifre");

        boolean sonuc = GirisDAO.giriseYetkilimi(ad, sifre);

        if (sonuc) {
            RequestDispatcher rd = request.getRequestDispatcher("Menu.jsp");//gidecegi sayfayi bildiriyoruz.
            HttpSession seasion = request.getSession();
            seasion.setAttribute("kullanici", ad);
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = request.getRequestDispatcher("giris.jsp");//Hata varsada buraya gotursun
            request.setAttribute("hata", "Kullanici adi veya sifre hatali");
            rd.forward(request, response);
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
