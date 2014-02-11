/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.Kelas;
import java.util.List;

/**
 *
 * @author Dibaj
 */
public interface KelasDAO {
    
    public void insert(Kelas kl);
    public void delete(String kodekelas);
    public void update(String oldkodekelas, Kelas kl);
    public Kelas loadNama(String jurusan);
    public Kelas load(String kodekelas);
    public List<Kelas> getAll();
    public List<Kelas> getAll(String jurusan);
    public List<Kelas> getAllNis(String kodekelas);
    
}
