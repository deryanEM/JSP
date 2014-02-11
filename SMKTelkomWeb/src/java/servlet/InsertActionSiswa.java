/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import com.model.Siswa;
import com.query.SiswaQuery;
import com.utils.DBConnection;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Dibaj
 */
@WebServlet(name = "InsertActionSiswa", urlPatterns = {"/insertactionsiswa.jsp"})
public class InsertActionSiswa extends HttpServlet {

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
                Siswa siswa = new Siswa();
                siswa.setNis(request.getParameter("txtNis"));
                siswa.setNama(request.getParameter("txtNama"));
                siswa.setAlamat(request.getParameter("txtAlamat"));
                siswa.setIDtelp(request.getParameter("txtNoTelp"));
            try {
                DBConnection conn = DBConnection.getInstance();
                SiswaQuery daoSiswa = new SiswaQuery(conn.getCon());
                daoSiswa.insert(siswa);
            } catch (Exception e) {
                System.out.println("gagal");
            }
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Simpan Data Siswa</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1><u>Data Siswa Berhasil Disimpan</h1></u></h1></center>");
            out.println("<center><a href=forminsertsiswa.jsp>back</a></center>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
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
