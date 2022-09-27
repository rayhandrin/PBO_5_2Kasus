public class Restaurant {
    // 1. Always keep data private
    private String[] nama_makanan;
    private double[] harga_makanan;
    private int[] stok;
    private static byte id = 0;

    // 2. Always initialize data.
    public Restaurant(final int b) {
        nama_makanan = new String[b];
        harga_makanan = new double[b];
        stok = new int[10];
    }

    public void tambahMenuMakanan(String nama, double harga, int stok) {
        this.nama_makanan[id] = nama;
        this.harga_makanan[id] = harga;
        this.stok[id] = stok;
    }

    public void tampilMenuMakanan() {
        for (int i = 0; i <= id; i++) {
            if (!isOutOfStock(i)) {
                System.out.println(nama_makanan[i] + "[" + stok[i] + "]" + "\tRp" + harga_makanan[i]);
            }
        }
    }

    public boolean isOutOfStock(int id) {
        if (stok[id] == 0) {
            return true;
        } else {
            return false;
        }
    }

    // Data encapsulation
    public void nextId() {
        id++;
    }

    // Pengurangan stok
    public void pesanMakanan(String nama, int jumlah) {
        for (int i = 0; i <= id; i++) {
            if (nama.equals(this.nama_makanan[i])) {
                if (isOutOfStock(i)) {
                    stok[i] -= jumlah;
                    System.out.println("Pesanan Anda sedang diproses!");
                } else {
                    System.out.println("Pesanan melibihi stok yang tersedia!");
                }
            }
        }
    }
}