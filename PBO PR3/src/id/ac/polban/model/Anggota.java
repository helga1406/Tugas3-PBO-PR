package id.ac.polban.model;

import java.util.ArrayList;

public class Anggota {
    private String nama;
    private String id;
    private double saldo;
    private ArrayList<Produk> daftarBeli;

    // Daftar semua anggota (static → milik class, bukan objek)
    private static ArrayList<Anggota> semuaAnggota = new ArrayList<>();

    public Anggota(String nama, String id, double saldo) {
        this.nama = nama;
        this.id = id;
        this.saldo = saldo;
        this.daftarBeli = new ArrayList<>();

        // Setiap kali objek Anggota dibuat, otomatis masuk ke daftar statis
        semuaAnggota.add(this);
    }

    // Getter dan Setter
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public ArrayList<Produk> getDaftarBeli() {
        return daftarBeli;
    }

    // Method beli produk (non-static, tergantung objek anggota)
    public boolean beliProduk(Produk p) {
        if (saldo >= p.getHarga()) {
            saldo -= p.getHarga();
            daftarBeli.add(p);
            System.out.println(p.getNamaProduk() + " - Rp" + p.getHarga() + " → Berhasil dibeli");
            return true;
        } else {
            System.out.println(p.getNamaProduk() + " - Rp" + p.getHarga() + " → Saldo tidak cukup");
            return false;
        }
    }

    // Cetak struk untuk anggota ini
    public void tampilkanStruk() {
        System.out.println("\n==================================");
        System.out.println("           KOPERASI XYZ           ");
        System.out.println("==================================");
        System.out.println("Nama Anggota : " + nama);
        System.out.println("ID Anggota   : " + id);
        System.out.println("----------------------------------");
        System.out.println("Daftar Produk Dibeli:");
        double total = 0;
        for (Produk p : daftarBeli) {
            System.out.printf("%-15s : Rp%.2f\n", p.getNamaProduk(), p.getHarga());
            total += p.getHarga();
        }
        System.out.println("----------------------------------");
        System.out.printf("Total Belanja : Rp%.2f\n", total);
        System.out.printf("Sisa Saldo   : Rp%.2f\n", saldo);
        System.out.println("==================================\n");
    }

    // Method static: tampilkan semua anggota yang pernah dibuat
    public static void tampilkanSemuaAnggota() {
        System.out.println("\n=== Daftar Semua Anggota ===");
        for (Anggota a : semuaAnggota) {
            System.out.println(a.getId() + " - " + a.getNama());
        }
        System.out.println("============================\n");
    }
}
