package com.paralun.app.dao.impl;

import com.paralun.app.model.Barang;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
public class BarangRowMapper implements RowMapper<Barang>{

    @Override
    public Barang mapRow(ResultSet rs, int i) throws SQLException {
        Barang b = new Barang();
        b.setKode(rs.getString("kode"));
        b.setNama(rs.getString("nama"));
        b.setKategori(rs.getString("kategori"));
        b.setStok((Integer) rs.getObject("stok"));
        b.setHarga(rs.getBigDecimal("harga"));
        return b;
    }

}
