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
    
    private JdbcTemplate jdbcTemplate;
    
    private final String INSERT_SQL = "insert into barang (kode,nama,kategori,stok,harga) values (?,?,?,?,?)";
    private final String SELECT_SQL = "select * from barang";
    private final String UPFATE_SQL = "update barang set nama = ?, kategori = ?, stok = ?, harga = ? where kode = ?";
    private final String DELETE_SQL = "delete from barang where kode = ?";
    private final String SELECT_BY_ID_SQL = "select * from barang where kode = ?";
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
    
    @Override
    public void simpan(Barang barang) throws Exception {
        jdbcTemplate.update(INSERT_SQL, new Object[]{
            barang.getKode(),barang.getNama(),barang.getKategori(),barang.getStok(),barang.getHarga()});
    }

    @Override
    public void update(Barang barang) throws Exception {
        jdbcTemplate.update(UPFATE_SQL, new Object[]{
            barang.getNama(),barang.getKategori(),barang.getStok(),barang.getHarga(),barang.getKode()});
    }

    @Override
    public void hapus(String kode) throws Exception {
        jdbcTemplate.update(DELETE_SQL, kode);
    }
    
    @Override
    public Barang getByKode(String kode) throws Exception {
        Barang barang = jdbcTemplate.queryForObject(SELECT_BY_ID_SQL, new Object[]{kode}, new BarangRowMapper());
        return barang;
    }

    @Override
    public List<Barang> findAll() throws Exception {
        List<Barang> list = jdbcTemplate.query(SELECT_SQL, new BarangRowMapper());
        return list;
    }

}
