package id.ac.polban.service;

import java.util.Scanner;
import id.ac.polban.model.Produk;
import id.ac.polban.model.Anggota;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Katalog produk tetap
        Produk[] katalog = {
                new Produk("Buku", 20000),
                new Produk("Pensil", 5000),
                new Produk("Roti", 15000),
                new Produk("Minuman", 10000)
        };

        System.out.print("Jumlah anggota: ");
        int jumlah = sc.nextInt();
        sc.nextLine();

        Anggota[] daftarAnggota = new Anggota[jumlah];

        for (int i = 0; i < jumlah; i++) {
            System.out.println("\nInput data anggota ke-" + (i + 1));
            System.out.print("Nama: ");
            String nama = sc.nextLine();
            System.out.print("ID: ");
            String id = sc.nextLine();
            System.out.print("Saldo awal: ");
            double saldo = sc.nextDouble();
            sc.nextLine();

            // Membuat objek anggota (otomatis masuk ke semuaAnggota di class Anggota)
            Anggota a = new Anggota(nama, id, saldo);

            // Tampilkan katalog produk
            System.out.println("\nKatalog Produk:");
            for (int j = 0; j < katalog.length; j++) {
                System.out.printf("%d. %-10s : Rp%.2f\n", j + 1, katalog[j].getNamaProduk(), katalog[j].getHarga());
            }

            System.out.print("Jumlah produk yang ingin dibeli: ");
            int nBeli = sc.nextInt();
            sc.nextLine();

            // Pilih produk sesuai jumlah yang diinginkan
            for (int k = 0; k < nBeli; k++) {
                System.out.print("Pilih nomor produk ke-" + (k + 1) + ": ");
                int pilihan = sc.nextInt();
                sc.nextLine();
                if (pilihan >= 1 && pilihan <= katalog.length) {
                    a.beliProduk(katalog[pilihan - 1]);
                } else {
                    System.out.println("Pilihan tidak valid");
                }
            }

            // Simpan anggota ke array
            daftarAnggota[i] = a;
        }

        // Tampilkan struk masing-masing anggota
        System.out.println("\n=== Struk Semua Anggota ===");
        for (Anggota a : daftarAnggota) {
            a.tampilkanStruk();
        }

        // Panggil method static untuk menampilkan semua anggota
        Anggota.tampilkanSemuaAnggota();

        // Tambahan: tampilkan jumlah produk (pakai static di Produk)
        System.out.println("Jumlah produk dalam katalog: " + Produk.getJumlahProduk());

        sc.close();
    }
}
