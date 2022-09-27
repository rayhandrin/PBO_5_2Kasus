public class RestaurantMain {
    public static void main(String[] args) {
        Restaurant menu = new Restaurant(10);
        menu.tambahMenuMakanan("Bala-bala", 1_000, 20);
        menu.nextId();
        menu.tambahMenuMakanan("Gehu", 1_000, 20);
        menu.nextId();
        menu.tambahMenuMakanan("Tahu", 1_000, 0);
        menu.nextId();
        menu.tambahMenuMakanan("Molen", 1_000, 0);
        menu.nextId();

        menu.tampilMenuMakanan();

        menu.pesanMakanan("Gehu", 22);
        menu.pesanMakanan("Gehu", 20);
    }
}