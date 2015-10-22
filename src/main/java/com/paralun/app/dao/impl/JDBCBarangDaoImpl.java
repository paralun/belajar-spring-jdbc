package com.paralun.app.dao.impl;

import com.paralun.app.dao.BarangDao;
import com.paralun.app.model.Barang;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
@Repository("jdbcBarangDao")
public class JDBCBarangDaoImpl implements BarangDao{
    
    @Autowired
    private DataSource dataSource;
    private JdbcTemplate jdbcTemplate;
    
    private final String INSERT_SQL = "insert into barang (kode,nama,kategori,stok,harga) values (?,?,?,?,?)";
    private final String SELECT_SQL = "select * from barang";
    
    @Override
    public void simpan(Barang barang) throws Exception {
        jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(INSERT_SQL, new Object[]{
            barang.getKode(),barang.getNama(),barang.getKategori(),barang.getStok(),barang.getHarga()});
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
        List<Barang> list = jdbcTemplate.query(SELECT_SQL, new BarangRowMapper());
        return list;
    }

}
