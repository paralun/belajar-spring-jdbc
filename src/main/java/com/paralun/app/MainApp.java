package com.paralun.app;

import com.paralun.app.model.Barang;
import com.paralun.app.service.BarangService;
import java.math.BigDecimal;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
public class MainApp {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-config-beans.xml");
        BarangService service = (BarangService) context.getBean("barangService");
        Barang barang = new Barang("B002", "Indomie", "Makanan", 20, new BigDecimal("60000"));
        if(service.simpan(barang)){
            System.out.println("Simpan data berhasil!!!");
        }else{
            System.out.println("Simpan data gagal!!!");
        }
    }
}
