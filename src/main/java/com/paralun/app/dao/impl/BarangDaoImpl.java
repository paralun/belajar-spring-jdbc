package com.paralun.app.dao.impl;

import com.paralun.app.dao.BarangDao;
import com.paralun.app.model.Barang;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
@Repository("barangDao")
public class BarangDaoImpl implements BarangDao{
    
    @Autowired
    private DataSource dataSource;
    
    private final String INSERT_SQL = "insert into barang (kode,nama,kategori,stok,harga) values (?,?,?,?,?)";
    private final String SELECT_SQL = "select * from barang";
    @Override
    public void simpan(Barang barang) throws Exception {
        Connection conn = dataSource.getConnection();
        try (PreparedStatement statement = conn.prepareStatement(INSERT_SQL)){
            conn.setAutoCommit(false);
            statement.setString(1, barang.getKode());
            statement.setString(2, barang.getNama());
            statement.setString(3, barang.getKategori());
            statement.setInt(4, barang.getStok());
            statement.setBigDecimal(5, barang.getHarga());
            statement.executeUpdate();
            conn.commit();
        }catch(SQLException ex){
            conn.rollback();
            throw new Exception(ex);
        }finally{
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    @Override
    public void update(Barang barang) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void hapus(String kode) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Barang> findAll() throws Exception {
        Connection conn = dataSource.getConnection();
        List<Barang> list = new ArrayList<>();
        try (PreparedStatement statement = conn.prepareStatement(SELECT_SQL);
                ResultSet result = statement.executeQuery()){
            while(result.next()){
                Barang barang = new Barang(
                        result.getString(1), 
                        result.getString(2), 
                        result.getString(3), 
                        result.getInt(4), 
                        result.getBigDecimal(5));
                list.add(barang);
            }
        }catch(SQLException ex){
            throw new Exception(ex);
        }finally{
            conn.close();
            return list;
        }
    }
}
