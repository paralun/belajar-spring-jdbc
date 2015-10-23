package com.paralun.app.dao;

import com.paralun.app.model.Barang;
import java.util.List;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
public interface BarangDao {
    public void simpan(Barang barang) throws Exception;
    public void update(Barang barang) throws Exception;
    public void hapus(String kode) throws Exception;
    public Barang getByKode(String kode) throws Exception;
    public List<Barang> findAll() throws Exception;
}
