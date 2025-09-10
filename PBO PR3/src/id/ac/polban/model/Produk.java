package id.ac.polban.model;

public class Produk {
    private String namaProduk;
    private double harga;

    // static variable untuk menghitung jumlah produk
    private static int jumlahProduk = 0;

    public Produk(String namaProduk, double harga) {
        this.namaProduk = namaProduk;
        this.harga = harga;
        jumlahProduk++; // setiap kali objek dibuat, counter bertambah
    }

    public String getNamaProduk() {
        return namaProduk;
    }

    public void setNamaProduk(String namaProduk) { // setter
        this.namaProduk = namaProduk;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) { // setter
        this.harga = harga;
    }

    // method static untuk ambil jumlah produk
    public static int getJumlahProduk() {
        return jumlahProduk;
    }
}
