/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package servlet;

import com.model.Kelas;
import com.query.KelasQuery;
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
@WebServlet(name = "InsertActionKelas", urlPatterns = {"/insertactionkelas.jsp"})
public class InsertActionKelas extends HttpServlet {

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
                Kelas kelas = new Kelas();
                kelas.setKode_kelas(request.getParameter("txtKode"));
                kelas.setJurusan(request.getParameter("txtJurusan"));
                kelas.setNama_kelas(request.getParameter("txtNama"));
                kelas.setKetua(request.getParameter("txtKetua"));
                kelas.setWali(request.getParameter("txtWali"));
                kelas.setJml_Siswa(request.getParameter("txtJumlah"));
            try {
                DBConnection conn = DBConnection.getInstance();
                KelasQuery daoKelas = new KelasQuery(conn.getCon());
                daoKelas.insert(kelas);
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
            out.println("<title>Simpan Data Kelas</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<center><h1><u>Data Kelas Berhasil Disimpan</u></h1></center>");
            out.println("<center><a href=forminsertkelas.jsp>back</a></center>");
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
