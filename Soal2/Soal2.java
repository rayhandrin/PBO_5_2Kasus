import java.util.Scanner;

public class Soal2 {
    public static void main(String[] args) {
        Scanner scan_this_str = new Scanner(System.in);
        Scanner scan_this_int = new Scanner(System.in);

        final int array_length = 15; // Menentukan jumlah menu yang ada pada penjualan

        Penjualan open = new Penjualan(array_length); // Membuat objek dari class Penjualan

        // DEFAULT MENU (10)
        open.tambah_menu("Gehu", 1000, 10);
        open.tambah_menu("Bala-bala", 1000, 8);
        open.tambah_menu("Cireng", 1000, 7);
        open.tambah_menu("Lumpia kering", 1000, 12);
        open.tambah_menu("Leupeut", 1000, 10);
        open.tambah_menu("Tempe goreng", 1000, 3);
        open.tambah_menu("Pisang bolen", 1000, 9);
        open.tambah_menu("Pisang goreng", 1000, 5);
        open.tambah_menu("Singkong goreng", 1000, 1);
        open.tambah_menu("Teh tawar panas", 1000, 10);
        open.daftar_menu();

        System.out.println("\nSIMULASI - Tambah satu menu"); // TEST CASE 1
        System.out.print("Nama menu: ");
        String nama_menu = scan_this_str.nextLine();
        System.out.print("Harga menu: ");
        int harga_menu = scan_this_int.nextInt();
        System.out.print("Stok menu: ");
        int stok_menu = scan_this_int.nextInt();
        open.tambah_menu(nama_menu, harga_menu, stok_menu);
        scan_this_str.close(); // Menutup resource dari Scanner - [01]
        scan_this_int.close(); // [01]

        System.out.println("\nSIMULASI - Pesan satu menu dengan jumlah pesanan 1"); // TEST CASE 2
        open.pesan_menu("Leupeut", 1);
        open.daftar_menu();

        System.out.println("\nSIMULASI - Pesan satu menu dengan jumlah pesanan lebih dari 1"); // TEST CASE 3
        open.pesan_menu("Leupeut", 8);
        open.daftar_menu();
    }
}

class Menu {
    private String nama_menu;
    private int harga_menu;
    private int stok_menu;

    public Menu(String nama_menu, int harga_menu, int stok_menu) {
        this.nama_menu = nama_menu;
        this.harga_menu = harga_menu;
        this.stok_menu = stok_menu;
    }

    public String get_nama_menu() {
        return nama_menu;
    }

    public int get_harga_menu() {
        return harga_menu;
    }

    public int get_stok_menu() {
        return stok_menu;
    }

    public void kurangi_stok_menu(int jumlah_pesanan) {
        System.out.println("Stok menu " + nama_menu + " sebelumnya: " + stok_menu);
        this.stok_menu -= jumlah_pesanan;
        System.out.println("Stok menu " + nama_menu + " sesudahnya: " + stok_menu);
    }

    public void tambah_stok_menu(int jumlah_stok) {
        this.stok_menu += jumlah_stok;
    }
}

class Penjualan {
    private Menu[] menu;
    private int id;

    public Penjualan(int jumlah_menu) {
        this.menu = new Menu[jumlah_menu];
    }

    public void tambah_menu(String nama_menu, int harga_menu, int stok_menu) {
        menu[id] = new Menu(nama_menu, harga_menu, stok_menu);
        id_baru();
    }

    public void pesan_menu(String nama_menu, int jumlah) {
        for (int i = 0; i < id; i++) {
            if (menu[i].get_nama_menu().equals(nama_menu)) {
                if (menu[i].get_stok_menu() >= jumlah) {
                    menu[i].kurangi_stok_menu(jumlah);
                    break;
                } else {
                    System.out.println("Stok tidak cukup");
                }
            }
        }
    }

    public void daftar_menu() {
        System.out.println("Daftar menu ------------------");
        for (int i = 0; i < id; i++) {
            System.out.println((i + 1) + ". " + menu[i].get_nama_menu() + " " + menu[i].get_harga_menu() + " "
                    + menu[i].get_stok_menu());
        }
    }

    private void id_baru() {
        id++;
    }
}