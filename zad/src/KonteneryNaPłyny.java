public class KonteneryNaPłyny extends Kontenery implements IHazardNotifier {
    protected boolean czyBezpieczny;

    public KonteneryNaPłyny(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maxLadunku, boolean czyBezpieczny) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, numerSeryjny, maxLadunku);
        this.numerSeryjny = "KON-L-" + numerSeryjny;
        this.czyBezpieczny = czyBezpieczny;
    }

    @Override
    public void zaladowanieKontener() throws OverfillException {
        double limit;
        if (czyBezpieczny) {
            limit=0.9;
        }else{
            limit=0.5;
        }
        if(masaLadunku>maxLadunku*limit){
            hazardNotify(numerSeryjny);
            throw new OverfillException("Próba wykonania niebezpiecznej operacji");
        } 
        this.masaLadunku = masaLadunku;
    }

    @Override
    public String toString() {
        return "Kontener na płyny\nNumer seryjny: " + numerSeryjny + "\nMasa kontenera: " + (wagaWlasna + masaLadunku);
    }

    @Override
    public void hazardNotify(String numerKontenera) {
        System.out.println("NIEBEZPIECZNA SYTUACJA W KONTENERZE NR: "+numerKontenera);
    }

    @Override
    public void oproznienieLadunku() {
        this.masaLadunku=0;
    }

    public boolean isCzyBezpieczny() {
        return czyBezpieczny;
    }

    public void setCzyBezpieczny(boolean czyBezpieczny) {
        this.czyBezpieczny = czyBezpieczny;
    }
}
