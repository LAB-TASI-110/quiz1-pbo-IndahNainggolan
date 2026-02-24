package driver;

import java.util.ArrayList;

// 1. Class Pakaian dengan fitur Catatan Kondisi dari Laundry
class Pakaian {
    private String jenis;
    private String keteranganUser;
    private String catatanLaundry; // Fitur baru untuk feedback laundry

    public Pakaian(String jenis, String keteranganUser) {
        this.jenis = jenis;
        this.keteranganUser = keteranganUser;
        this.catatanLaundry = "Kondisi Baik"; // Default awal
    }

    public void setCatatanLaundry(String catatan) {
        this.catatanLaundry = catatan;
    }

    @Override
    public String toString() {
        return "- " + jenis + " [" + keteranganUser + "] | Catatan Laundry: " + catatanLaundry;
    }
}

// 2. Class Mahasiswa dengan Asrama MAX PLANCK
class MahasiswaDel {
    private String nim;
    private String nama;
    private String asrama;

    public MahasiswaDel(String nim, String nama, String asrama) {
        this.nim = nim;
        this.nama = nama;
        this.asrama = asrama;
    }

    public String getInfo() {
        return nama + " (" + nim + ") | Lokasi: " + asrama;
    }
}

// 3. Class Transaksi
class TransaksiLaundry {
    private MahasiswaDel mhs;
    private ArrayList<Pakaian> daftarBaju;
    private String status;

    public TransaksiLaundry(MahasiswaDel mhs) {
        this.mhs = mhs;
        this.daftarBaju = new ArrayList<>();
        this.status = "Dijemput dari Asrama";
    }

    public void tambahBaju(Pakaian p) {
        this.daftarBaju.add(p);
    }

    public void setStatus(String statusBaru) {
        this.status = statusBaru;
    }

    public ArrayList<Pakaian> getDaftarBaju() {
        return daftarBaju;
    }

    public void cetakNota() {
        System.out.println("\n========== NOTA LAUNDRY DEL ==========");
        System.out.println("IDENTITAS : " + mhs.getInfo());
        System.out.println("STATUS    : " + status);
        System.out.println("--------------------------------------");
        System.out.println("DAFTAR CUCIAN & KONDISI:");
        for (Pakaian p : daftarBaju) {
            System.out.println(p);
        }
        System.out.println("======================================\n");
    }
}

// 4. Driver Utama
public class Driver3 {
    public static void main(String[] args) {
        // Data Indah dengan Asrama MAX PLANCK
        MahasiswaDel indah = new MahasiswaDel("12S24046", "INDAH ELSADAI NAINGGOLAN", "Asrama MAX PLANCK");

        // 1. Indah mengisi list baju awal
        Pakaian baju1 = new Pakaian("Kemeja Putih", "Seragam");
        Pakaian baju2 = new Pakaian("Celana Panjang Hitam", "Bahan Kain");

        TransaksiLaundry laundryIndah = new TransaksiLaundry(indah);
        laundryIndah.tambahBaju(baju1);
        laundryIndah.tambahBaju(baju2);

        // Cetak kondisi awal saat baru dijemput
        System.out.println(">>> Tampilan Saat Penjemputan:");
        laundryIndah.cetakNota();

        // 2. PIHAK LAUNDRY melakukan pengecekan dan mengisi sistem
        System.out.println("... Pihak Laundry sedang mengecek baju ...\n");
        
        // Laundry menemukan noda permanen di baju pertama
        laundryIndah.getDaftarBaju().get(0).setCatatanLaundry("Ada noda kuning susah hilang/permanen");
        
        // Laundry menemukan celana koyak di baju kedua
        laundryIndah.getDaftarBaju().get(1).setCatatanLaundry("Celana dalam keadaan koyak sebelumnya");

        // Update status pengantaran
        laundryIndah.setStatus("Sudah Dicuci & Diantar Kembali ke Asrama");

        // 3. Cetak nota akhir untuk konfirmasi ke mahasiswa
        System.out.println(">>> Tampilan Saat Pengembalian:");
        laundryIndah.cetakNota();
    }
}
