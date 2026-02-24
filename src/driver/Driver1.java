package driver;

import java.util.Scanner;
import java.util.ArrayList;

public class Driver1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> strukLines = new ArrayList<>();
        long totalBayar = 0;

        // Membaca input sampai bertemu kata "END"
        while (sc.hasNext()) {
            String kode = sc.next();
            if (kode.equalsIgnoreCase("END")) break;

            // Membaca porsi milik Butet
            if (sc.hasNextInt()) {
                int porsiButet = sc.nextInt();
                
                // Logika: Ucok (100kg) & Butet (50kg). 
                // Porsi total = 2x Butet (Ucok) + 1x Butet = 3 * porsiButet
                int porsiTotal = 3 * porsiButet;

                String namaMenu = "";
                int hargaMenu = 0;

                // Penentuan Menu berdasarkan Kode dari gambar
                switch (kode.toUpperCase()) {
                    case "NGS": namaMenu = "Nasi Goreng Spesial"; hargaMenu = 15000; break;
                    case "AP":  namaMenu = "Ayam Penyet"; hargaMenu = 20000; break;
                    case "SA":  namaMenu = "Sate Ayam (10 Tusuk)"; hargaMenu = 25000; break;
                    case "BU":  namaMenu = "Bakso Urat"; hargaMenu = 18000; break;
                    case "MAP": namaMenu = "Mie Ayam Pangsit"; hargaMenu = 15000; break;
                    case "GG":  namaMenu = "Gado-Gado"; hargaMenu = 15000; break;
                    case "SAM": namaMenu = "Soto Ayam"; hargaMenu = 17000; break;
                    case "RD":  namaMenu = "Rendang Daging"; hargaMenu = 25000; break;
                    case "IB":  namaMenu = "Ikan Bakar"; hargaMenu = 35000; break;
                    case "NUK": namaMenu = "Nasi Uduk Komplit"; hargaMenu = 20000; break;
                    default: continue; 
                }

                long totalPerMenu = (long) hargaMenu * porsiTotal;
                totalBayar += totalPerMenu;

                // Format baris struk agar rapi seperti di contoh output
                strukLines.add(String.format("%-19s %-7d %-7d %-7d", 
                               namaMenu, porsiTotal, hargaMenu, totalPerMenu));
            }
        }

        // Tampilan Output Struk
        System.out.println("Menu                Porsi   Harga   Total");
        System.out.println("==============================================");
        for (String line : strukLines) {
            System.out.println(line);
        }
        System.out.println("==============================================");
        System.out.printf("Total Pembayaran                    %d\n", totalBayar);
        
        sc.close();
    }
}
