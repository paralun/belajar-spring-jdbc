package com.paralun.app;

import com.paralun.app.model.Barang;
import com.paralun.app.service.BarangService;
import com.paralun.app.service.BarangServiceSupport;
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
        //BarangServiceSupport service = (BarangServiceSupport) context.getBean("barangServiceSupport");
        //Barang barang = new Barang("B008", "Test", "Coba", 40, new BigDecimal("100000"));
        
//        if(service.simpan(barang)){
//            System.out.println("Simpan data berhasil!!!");
//            for(Barang b : service.fingAll()){
//                System.out.println("====DATA BARANG====");
//                System.out.println("Kode : " + b.getKode());
//                System.out.println("Nama : " + b.getNama());
//                System.out.println("Kategori : " + b.getKategori());
//                System.out.println("Stok : " + b.getStok());
//                System.out.println("Harga : " + b.getHarga());
//                System.out.println("===================");
//            }
//        }else{
//            System.out.println("Simpan data gagal!!!");
//        }
//       
//        if(service.hapus("B001")){
//            System.out.println("Hapus data berhasil!!!");
//            for(Barang b : service.fingAll()){
//                System.out.println("====DATA BARANG====");
//                System.out.println("Kode : " + b.getKode());
//                System.out.println("Nama : " + b.getNama());
//                System.out.println("Kategori : " + b.getKategori());
//                System.out.println("Stok : " + b.getStok());
//                System.out.println("Harga : " + b.getHarga());
//                System.out.println("===================");
//            }
//        }else{
//            System.out.println("Hapus data gagal!!!");
//        }
        
        Barang barang3 = service.getByKode("B008");
        barang3.setNama("Bala-bala");
        barang3.setKategori("Gorengan");
        barang3.setStok(10);
        barang3.setHarga(new BigDecimal("2000"));
        if(service.update(barang3)){
            System.out.println("Update berhasil");
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
            System.out.println("Update Gagal");
        }
    }
}
