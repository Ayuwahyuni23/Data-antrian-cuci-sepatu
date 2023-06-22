import java.util.ArrayList;
import java.util.Scanner;

public class Sepatu {

    ArrayList<Shoe> antrian = new ArrayList<>();

    class Shoe {
        String nameCustomer, merk, color;
        int size;

        public Shoe(String nameCustomer, String merk, int size, String color) {
            this.nameCustomer = nameCustomer;
            this.merk = merk;
            this.size = size;
            this.color = color;
        }
    }

    public void tambahCucianSepatu(Scanner scanner) {
        System.out.print("Nama Pelanggan : ");
        String nameCustomer = scanner.next();
        System.out.print("Merk Sepatu : ");
        String merk = scanner.next();
        System.out.print("Ukuran Sepatu : ");
        int size = scanner.nextInt();
        System.out.print("Warna Sepatu : ");
        String color = scanner.next();

        // Membuat objek "shoe" utk menyimpan nilai dr parameter yg berisi data sepatu
        Shoe shoe = new Shoe(nameCustomer, merk, size, color);

        // Menambahkan data dari objek shoe ke dalam array list "antrian"
        antrian.add(shoe);

        System.out.println("Antrian sepatu berhasil ditambahkan");
    }

    public void printAntrian() {
        if (antrian != null) {
            System.out.println("----------------------------------------------------");
            // perulangan for
            for (int i = 0; i < antrian.size(); i++) {
                Shoe shoe = antrian.get(i);
                System.out.println("Antrian sepatu ke-" + (i + 1));
                System.out.println("Nama pelanggan  : " + shoe.nameCustomer);
                System.out.println("Merk Sepatu     : " + shoe.merk);
                System.out.println("Ukuran Sepatu   : " + shoe.size);
                System.out.println("Warna Sepatu    : " + shoe.color);
                System.out.println("----------------------------------------------------");
            }
        } else {
            System.out.println("Antrian sepatu kosong");
        }
    }

    public void hapusAntrian(Scanner scanner) {
        printAntrian();

        System.out.print("\nMasukkan urutan antrian yang akan dihapus : ");
        int nomor = scanner.nextInt();

        if ((nomor > 0) && (nomor < antrian.size() || nomor == antrian.size())) {
            antrian.remove(nomor - 1);
            System.out.println("Antrian berhasil dihapus");
            System.out.println("\nAntrian sekarang :");
            printAntrian();
        } else {
            System.out.println("Nomor antrian tidak valid");
        }
    }

    public static void main(String[] args) {
        // Objek scanner untuk membaca inputan user
        Scanner scanner = new Scanner(System.in);

        // Membuat objek dengan nama "sepatu" dari class Sepatu
        Sepatu sepatu = new Sepatu();

        while (true) {
            System.out.println("Menu :");
            System.out.println("1. Tambah antrian cuci sepatu");
            System.out.println("2. Tampilkan antrian cuci sepatu");
            System.out.println("3. Hapus antrian cuci sepatu");
            System.out.print("Masukkan pilihan Anda : ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    sepatu.tambahCucianSepatu(scanner);
                    break;
                case 2:
                    sepatu.printAntrian();
                    break;
                case 3:
                    sepatu.hapusAntrian(scanner);
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia");
                    break;
            }

            System.out.println("\nApakah Anda ingin kembali ke menu? (ya/tidak)");
            String respon = scanner.next();
            if (respon.equalsIgnoreCase("ya")) {
                continue;
            } else {
                System.exit(0);
            }
        }
    }
}