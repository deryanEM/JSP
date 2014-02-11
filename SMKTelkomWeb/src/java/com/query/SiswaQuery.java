/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import com.dao.SiswaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.model.Siswa;

/**
 *
 * @author Dibaj
 */
public class SiswaQuery implements SiswaDAO {

    private Connection conn = null;

    public SiswaQuery(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Siswa sw) {
        String sql = "insert into siswa(nis,nama,alamat,IDtelp) values(?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, sw.getNis());
            st.setString(2, sw.getNama());
            st.setString(3, sw.getAlamat());
            st.setString(4, sw.getIDtelp());
            st.executeUpdate();
            System.out.println("Berhasil insert");
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String nis) {
        String sql = "delete from siswa where nis=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nis);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String oldNis, Siswa sw) {
        String sql = "update siswa set nama=?, alamat=?, IDtelp=? where nis=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, sw.getNama());
            st.setString(2, sw.getAlamat());
            st.setString(3, sw.getIDtelp());
            st.setString(4, oldNis);
            st.executeUpdate();
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Siswa loadNama(String nama) {
        Siswa siswa = null;
        String sql = "select nis,nama,alamat,IDtelp from siswa where nama=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                siswa = new Siswa();
                siswa.setNis(rs.getString(1));
                siswa.setNama(rs.getString(2));
                siswa.setAlamat(rs.getString(3));
                siswa.setIDtelp(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return siswa;
    }

    @Override
    public Siswa load(String nis) {
        Siswa siswa = null;
        String sql = "SELECT nis,nama,alamat,IDtelp FROM siswa WHERE nis=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, nis);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                siswa = new Siswa();
                siswa.setNis(rs.getString(1));
                siswa.setNama(rs.getString(2));
                siswa.setAlamat(rs.getString(3));
                siswa.setIDtelp(rs.getString(4));
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return siswa;
    }

    @Override
    public List<Siswa> getAll() {
        String sql = "SELECT nis,nama,alamat,IDTelp FROM siswa";
        List<Siswa> list = new ArrayList<Siswa>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Siswa s = new Siswa();
                s.setNis(rs.getString(1));
                s.setNama(rs.getString(2));
                s.setAlamat(rs.getString(3));
                s.setIDtelp(rs.getString(4));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Siswa> getAll(String name) {
        String sql = "SELECT * FROM siswa WHERE nama like?";
        List<Siswa> list = new ArrayList<Siswa>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + name + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Siswa s = new Siswa();
                s.setNis(rs.getString(1));
                s.setNama(rs.getString(2));
                s.setAlamat(rs.getString(3));
                s.setIDtelp(rs.getString(4));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Siswa> getAllNis(String nis) {
        String sql = "SELECT * FROM siswa WHERE nis LIKE ?";
        List<Siswa> list = new ArrayList<Siswa>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + nis + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Siswa s = new Siswa();
                s.setNis(rs.getString(1));
                s.setNama(rs.getString(2));
                s.setAlamat(rs.getString(3));
                s.setIDtelp(rs.getString(4));
                list.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SiswaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
