/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.model.Siswa;

/**
 *
 * @author Dibaj
 */
public interface SiswaDAO {
    
    public void insert(Siswa sw);
    public void delete(String nis);
    public void update(String oldNis, Siswa sw);
    public Siswa loadNama(String nama);
    public Siswa load(String nis);
    public List<Siswa> getAll();
    public List<Siswa> getAll(String name);
    public List<Siswa> getAllNis(String nis);
    
}
