package com.paralun.app.service;

import com.paralun.app.dao.impl.JDBCBarangDaoImplSupport;
import com.paralun.app.model.Barang;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author James Kusmambang
 * @Since 23/10/2015
 */
@Service("barangServiceSupport")
public class BarangServiceSupport {
    
    JDBCBarangDaoImplSupport dao;
    
    @Autowired
    public void setDao(@Qualifier("barangDaoSupport") JDBCBarangDaoImplSupport dao) {
        this.dao = dao;
    }
    
    public boolean simpan(Barang b){
        try {
            dao.simpan(b);
            return true;
        }catch(Throwable t){
            System.out.println(t.getMessage());
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
