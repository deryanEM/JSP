/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.query;

import com.dao.KelasDAO;
import com.model.Kelas;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dibaj
 */
public class KelasQuery implements KelasDAO {
    
    private Connection conn;

    public KelasQuery(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void insert(Kelas kl) {
        String sql = "insert into kelas (kodekelas,namakelas,jurusan,ketuakelas,walikelas,jumlahsiswa) values (?,?,?,?,?,?)";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kl.getKode_kelas());
            st.setString(2, kl.getNama_kelas());
            st.setString(3, kl.getJurusan());
            st.setString(4, kl.getKetua());
            st.setString(5, kl.getWali());
            st.setString(6, kl.getJml_Siswa());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KelasQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete(String kodekelas) {
        String sql = "delete from kelas where kodekelas = ?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kodekelas);
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KelasQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update(String oldkodekelas, Kelas kl) {
        String sql = "update kelas set namakelas=?, jurusan=?, ketuakelas=?, walikelas=?, jumlahsiswa=? where kodekelas=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kl.getNama_kelas());
            st.setString(2, kl.getJurusan());
            st.setString(3, kl.getKetua());
            st.setString(4, kl.getWali());
            st.setString(5, kl.getJml_Siswa());
            st.setString(6, oldkodekelas);
            st.executeUpdate();
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(KelasQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Kelas loadNama(String jurusan) {
        Kelas kl = null;
        String sql = "select kodekelas,namakelas,ketuakelas,walikelas,jumlahsiswa where jurusan=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                kl = new Kelas();
                kl.setKode_kelas(rs.getString(1));
                kl.setNama_kelas(rs.getString(2));
                kl.setKetua(rs.getString(3));
                kl.setWali(rs.getString(4));
                kl.setJml_Siswa(rs.getString(5));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kl;
    }

    @Override
    public Kelas load(String kodekelas) {
        Kelas kl = null;
        String sql = "select kodekelas,namakelas,jurusan,ketuakelas,walikelas,jumlahsiswa where kodekelas=?";
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, kodekelas);
            ResultSet rs = st.executeQuery();
            if(rs.next()){
                kl = new Kelas();
                kl.setKode_kelas(rs.getString(1));
                kl.setNama_kelas(rs.getString(2));
                kl.setJurusan(rs.getString(3));
                kl.setKetua(rs.getString(4));
                kl.setWali(rs.getString(5));
                kl.setJml_Siswa(rs.getString(6));
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasQuery.class.getName()).log(Level.SEVERE, null, ex);
        }
        return kl;
    }

    @Override
    public List<Kelas> getAll() {
        String sql = "select kodekelas,namakelas,jurusan,ketuakelas,walikelas,jumlahsiswa from kelas";
        List<Kelas> list = new ArrayList<Kelas>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kelas k = new Kelas();
                k.setKode_kelas(rs.getString(1));
                k.setNama_kelas(rs.getString(2));
                k.setJurusan(rs.getString(3));
                k.setKetua(rs.getString(4));
                k.setWali(rs.getString(5));
                k.setJml_Siswa(rs.getString(6));
                list.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Kelas> getAll(String jurusan) {
        String sql = "SELECT * FROM kelas WHERE jurusan like?";
        List<Kelas> list = new ArrayList<Kelas>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + jurusan + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kelas k = new Kelas();
                k.setKode_kelas(rs.getString(1));
                k.setNama_kelas(rs.getString(2));
                k.setJurusan(rs.getString(3));
                k.setKetua(rs.getString(4));
                k.setWali(rs.getString(5));
                k.setJml_Siswa(rs.getString(6));
                list.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    @Override
    public List<Kelas> getAllNis(String kodekelas) {
        String sql = "SELECT * FROM kelas WHERE kodekelas LIKE ?";
        List<Kelas> list = new ArrayList<Kelas>();
        try {
            PreparedStatement st = conn.prepareStatement(sql);
            st.setString(1, "%" + kodekelas + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Kelas k = new Kelas();
                k.setKode_kelas(rs.getString(1));
                k.setNama_kelas(rs.getString(2));
                k.setJurusan(rs.getString(3));
                k.setKetua(rs.getString(4));
                k.setWali(rs.getString(5));
                k.setJml_Siswa(rs.getString(6));
                list.add(k);
            }
        } catch (SQLException ex) {
            Logger.getLogger(KelasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}    