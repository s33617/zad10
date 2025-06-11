public class Main {
    public static void main(String[] args) {
        try {
            Kontenerowiec transportowiec = new Kontenerowiec(25, 10, 1000);

            KonteneryNaPłyny plynowy = new KonteneryNaPłyny(15, 15, 50, 20, "PL-9955", 30, true);
            KonteneryNaGaz gazowy = new KonteneryNaGaz(30, 21, 900, 22, "GZ-1122", 40);
            KonteneryChlodniczy chlodniczy = new KonteneryChlodniczy(30, 25, 150, 22, "CH-2233", 60, "Lody", 5.5, -1.0);

            Kontenerowiec rezerwowy = new Kontenerowiec(25, 10, 1000);

            plynowy.zaladowanieKontener();
            gazowy.zaladowanieKontener();
            chlodniczy.zaladowanieKontener();

            transportowiec.zaladujKontener(plynowy);
            transportowiec.zamienKontener(gazowy.getNumerSeryjny(), gazowy);
            transportowiec.zamienKontener(chlodniczy.getNumerSeryjny(), chlodniczy);

            transportowiec.pokazInformacjeOStatku();

        } catch (Exception ex) {
            System.out.println("[Błąd systemu]: " + ex.getMessage());
        }
    }
}