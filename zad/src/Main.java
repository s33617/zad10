public class Main {
    public static void main(String[] args) {
           try{
        Kontenerowiec statek1 = new Kontenerowiec(25, 10, 1000);
   KonteneryNaPłyny kon1 = new KonteneryNaPłyny(20, 15, 45, 22, "2242", 25, true);
   KonteneryNaGaz kon2 = new KonteneryNaGaz(40, 21, 900, 22, "2156", 50);
   KonteneryChlodniczy kon3 = new KonteneryChlodniczy(25, 22, 150, 22, "2125", 60, "banany", 13.3, 20);
Kontenerowiec statek2 = new Kontenerowiec(25, 10, 1000);
   kon1.zaladowanieKontener();
   kon2.zaladowanieKontener();
   kon3.zaladowanieKontener();

   statek1.zaladujKontener(kon1);
   statek1.zamienKontener(kon2.getNumerSeryjny(), kon2);
   statek1.zamienKontener(kon3.getNumerSeryjny(), kon3);


   statek1.pokazInformacjeOStatku();
    }catch (Exception e){
       System.out.println("Błąd: " + e.getMessage());}
    }
}