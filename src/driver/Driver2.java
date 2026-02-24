package driver;

import java.util.Scanner;
import model.solution;

public class Driver2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Data array sesuai deret nilai di soal
        solution[] rak = {
            new solution("yohana", 75),
            new solution("julius", 65),
            new solution("indah", 80),
            new solution("wilson", 70)
        };

        // Tambahkan pesan ini agar tidak bingung
        System.out.print("Masukkan jumlah data (N): ");

        if (input.hasNextInt()) {
            int n = input.nextInt();
            int total = 0;

            for (int i = 0; i < n && i < rak.length; i++) {
                total += rak[i].nilai;
            }
            
            System.out.println("Total Nilai: " + total);
        } else {
            System.out.println("Input yang kamu masukkan bukan angka!");
        }
        input.close();
    }
}
