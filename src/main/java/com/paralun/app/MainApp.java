package com.paralun.app;

import com.paralun.app.model.Barang;
import com.paralun.app.service.BarangService;
import com.paralun.app.service.JDBCBarangService;
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
        //BarangService service = (BarangService) context.getBean("barangService");
        JDBCBarangService service = (JDBCBarangService) context.getBean("jdbcBarangService");
        Barang barang = new Barang("B006", "Baso", "Makanan", 10, new BigDecimal("9000"));
        
        if(service.simpan(barang)){
            System.out.println("Simpan data berhasil!!!");
            for(Barang b : service.fingAll()){
                System.out.println("====DATA BARANG====");
                System.out.println("Kode : " + b.getKode());
                System.out.println("Nama : " + b.getNama());
                System.out.println("Kategori : " + b.getKategori());
                System.out.println("Stok : " + b.getStok());
                System.out.println("Harga : " + b.getHarga());
                System.out.println("===================");
            }
        }else{
            System.out.println("Simpan data gagal!!!");
        }
    }
}
