package com.paralun.app.service;

import com.paralun.app.dao.BarangDao;
import com.paralun.app.dao.impl.JDBCBarangDaoImpl;
import com.paralun.app.model.Barang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
@Service("jdbcBarangService")
@Transactional(readOnly = true)
public class JDBCBarangService {
    
    private BarangDao dao;
    
    @Autowired
    public void setDao(@Qualifier("jdbcBarangDao") BarangDao dao) {
        this.dao = dao;
    }
    
    @Transactional(readOnly = false, propagation = Propagation.REQUIRED)
    public boolean simpan(Barang b){
        try {
            dao.simpan(b);
            return true;
        }catch(Throwable t){
            return false;
        }
    }
    
    public List<Barang> fingAll(){
        try {
            return dao.findAll();
        }catch(Throwable t){
            return null;
        }
    }
}
