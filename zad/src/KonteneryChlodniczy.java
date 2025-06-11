import java.util.HashMap;

public class KonteneryChlodniczy extends Kontenery {
    protected String rodzajProduktu;
    protected double temperaturaWKontenerze;
    protected double temperaturaProduktu;

    public KonteneryChlodniczy(double masaLadunku, double wysokosc, double wagaWlasna, double glebokosc, String numerSeryjny, double maxLadunku, String rodzajProduktu, double temperaturaWKontenerze, double temperaturaProduktu) {
        super(masaLadunku, wysokosc, wagaWlasna, glebokosc, numerSeryjny, maxLadunku);
        this.numerSeryjny = "KON-C-" + numerSeryjny;
        this.rodzajProduktu = rodzajProduktu;
        this.temperaturaWKontenerze = temperaturaWKontenerze;
        this.temperaturaProduktu = temperaturaProduktu;
    }

    private static final HashMap<String, Double> wymaganaTemperatura = new HashMap<>();
    static {
        wymaganaTemperatura.put("Bananas", 13.3);
        wymaganaTemperatura.put("Chocolate", 18.0);
        wymaganaTemperatura.put("Fish", 2.0);
        wymaganaTemperatura.put("Meat", -15.0);
        wymaganaTemperatura.put("Ice cream", -18.0);
        wymaganaTemperatura.put("Frozen pizza", -30.0);
        wymaganaTemperatura.put("Cheese", 7.2);
        wymaganaTemperatura.put("Sausage", 5.0);
        wymaganaTemperatura.put("Butter", 20.5);
        wymaganaTemperatura.put("Eggs", 19.0);
    }

    public double sprawdzTemperatureWKontenerze(String typProduktu, double temperatura) throws Exception {
        Double minTemperatura = wymaganaTemperatura.get(typProduktu);
        if (temperatura < minTemperatura) {
            throw new Exception("TEMPERATURA W KONTENERZE ZBYT NISKA:  " + minTemperatura);
        }
        return minTemperatura;
    }

    @Override
    public void oproznienieLadunku() {
    }

    public String getRodzajProduktu() {
        return rodzajProduktu;
    }

    public void setRodzajProduktu(String rodzajProduktu) {
        this.rodzajProduktu = rodzajProduktu;
    }

    public double getTemperaturaProduktu() {
        return temperaturaProduktu;
    }

    public void setTemperaturaProduktu(double temperaturaProduktu) {
        this.temperaturaProduktu = temperaturaProduktu;
    }

    public double getTemperaturaWKontenerze() {
        return temperaturaWKontenerze;
    }

    public void setTemperaturaWKontenerze(double temperaturaWKontenerze) {
        this.temperaturaWKontenerze = temperaturaWKontenerze;
    }
}

