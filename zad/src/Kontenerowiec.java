import java.util.ArrayList;
import java.util.List;

public class Kontenerowiec {
    public double maxPredkosc;
    public int maxKontenerow;
    public double maxWaga;
    public List<Kontenery> kontenerowiec;

    public Kontenerowiec(double maxPredkosc, int maxKontenerow, double maxWaga) {
        this.kontenerowiec = new ArrayList<>();
        this.maxPredkosc = maxPredkosc;
        this.maxKontenerow = maxKontenerow;
        this.maxWaga = maxWaga;
    }
    public void zaladujKontener(Kontenery nowyKontener) throws Exception {
        if (kontenerowiec.contains(nowyKontener)) {
            throw new OverfillException("Kontener już istnieje na pokładzie");
        }
        double przyszlaWaga = obliczWageKontenerowca(nowyKontener);
        if (przyszlaWaga > maxWaga) {
            throw new OverfillException("Przekroczono dopuszczalną wagę statku");
        }
        if (kontenerowiec.size() >= maxKontenerow) {
            throw new OverfillException("Limit liczby kontenerów został osiągnięty");
        }
        kontenerowiec.add(nowyKontener);
    }

    public void usunKontener(String numer){
        for(int i=0; i<kontenerowiec.size(); i++){
            if(kontenerowiec.get(i).getNumerSeryjny().equals(numer)){
                kontenerowiec.remove(i);
                break;
            }
        }
    }

    public double obliczWageKontenerowca(Kontenery kontenery) {
        double suma = 0.0;
        for(int i=0; i<kontenerowiec.size(); i++){
            suma+=kontenerowiec.get(i).wagaWlasna;
        }
        return suma;
    }

    public void rozladowanieKontenerowca(Kontenery kontenery) {
        kontenerowiec.removeAll(List.of(kontenery));
    }
    public void zamienKontener(String numer, Kontenery nowy){
        for(int i=0; i<kontenerowiec.size(); i++){
            if(kontenerowiec.get(i).getNumerSeryjny().equals(numer)){
                kontenerowiec.set(i, nowy);
                break;
            }
        }
    }
    public void przeniesKontener(String numerSeryjny, Kontenerowiec drugi) throws Exception {
        for (int i = 0; i < kontenerowiec.size(); i++) {
            if (kontenerowiec.get(i).getNumerSeryjny().equals(numerSeryjny)) {
                drugi.zaladujKontener(kontenerowiec.get(i));
                kontenerowiec.remove(i);
                break;
            }
        }
    }
    public void pokazInformacjeOStatku() {
        System.out.println("=== Informacje o statku ===");
        System.out.println("Prędkość maksymalna: " + maxPredkosc + " węzłów");
        System.out.println("Dopuszczalna ładowność: " + maxWaga + " kg");
        System.out.println("Zawartość statku:");
        for (int i = 0; i < kontenerowiec.size(); i++) {
            System.out.println("- Kontener nr: " + kontenerowiec.get(i).getNumerSeryjny());
        }
    }

}

