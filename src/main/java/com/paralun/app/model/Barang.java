package com.paralun.app.model;

import java.math.BigDecimal;

/**
 * @author James Kusmambang
 * @Since 22/10/2015
 */
public class Barang {
    private String kode;
    private String nama;
    private String kategori;
    private Integer stok;
    private BigDecimal harga;

    public Barang() {
    }

    public Barang(String kode, String nama, String kategori, Integer stok, BigDecimal harga) {
        this.kode = kode;
        this.nama = nama;
        this.kategori = kategori;
        this.stok = stok;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public Integer getStok() {
        return stok;
    }

    public void setStok(Integer stok) {
        this.stok = stok;
    }

    public BigDecimal getHarga() {
        return harga;
    }

    public void setHarga(BigDecimal harga) {
        this.harga = harga;
    }
}
