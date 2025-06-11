public class KonteneryNaGaz extends Kontenery implements IHazardNotifier{
    public KonteneryNaGaz(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maxLadunku) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, numerSeryjny, maxLadunku);
        this.numerSeryjny = "KON-G-" + numerSeryjny;
    }

    @Override
    public void oproznienieLadunku(){
        this.masaLadunku = this.masaLadunku*0.05;
    }

    @Override
    public void hazardNotify(String numerKontenera) {
        System.out.println("NEBEZPIECZNE ZDARZENIE W KONTENERZE O NUMERZE: "+numerKontenera);
    }
}
