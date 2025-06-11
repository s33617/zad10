public abstract class Kontenery {
    protected double masaLadunku; //kg
    protected double wysokosc; //centymetry
    protected double wagaWlasna; //waga samego kontenera w kilogramach
    protected double glebokosc; // centymetry
    protected String numerSeryjny; //centymetry
    protected double maxLadunku; //kg

    public Kontenery(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maxLadunku) {
        this.masaLadunku = masaLadunku;
        this.wysokosc = wysokosc;
        this.wagaWlasna = wagaWlasna;
        this.glebokosc = glebokosc;
        this.numerSeryjny = numerSeryjny;
        this.maxLadunku = maxLadunku;
    }
    public abstract void oproznienieLadunku();

    public void zaladowanieKontener() throws OverfillException {
        if (masaLadunku > maxLadunku) {
            throw new OverfillException("Masa ładunku jest większa niż maksymalna ładowność");
        }
    }
    public double wagaCalkowita(){
        return (wagaWlasna+masaLadunku);
    }

    @Override
    public String toString() {
        return "Kontener na płyny\nNumer seryjny: " + numerSeryjny + "\nMasa kontenera: " + (wagaWlasna + masaLadunku);
    }

    public double getMasaLadunku() {
        return masaLadunku;
    }

    public void setMasaLadunku(double masaLadunku) {
        this.masaLadunku = masaLadunku;
    }

    public double getWysokosc() {
        return wysokosc;
    }

    public void setWysokosc(double wysokosc) {
        this.wysokosc = wysokosc;
    }

    public double getWagaWlasna() {
        return wagaWlasna;
    }

    public void setWagaWlasna(double wagaWlasna) {
        this.wagaWlasna = wagaWlasna;
    }

    public double getGlebokosc() {
        return glebokosc;
    }

    public void setGlebokosc(double glebokosc) {
        this.glebokosc = glebokosc;
    }

    public String getNumerSeryjny() {
        return numerSeryjny;
    }

    public void setNumerSeryjny(String numerSeryjny) {
        this.numerSeryjny = numerSeryjny;
    }

    public double getMaxLadunku() {
        return maxLadunku;
    }

    public void setMaxLadunku(double maxLadunku) {
        this.maxLadunku = maxLadunku;
    }
}


