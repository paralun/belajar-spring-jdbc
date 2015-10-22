package com.paralun.app.service;

import com.paralun.app.dao.BarangDao;
import com.paralun.app.model.Barang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
@Service("barangService")
public class BarangService {
    
    private BarangDao dao;
    
    @Autowired
    public void setDao(@Qualifier("barangDao") BarangDao dao) {
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
    
}
