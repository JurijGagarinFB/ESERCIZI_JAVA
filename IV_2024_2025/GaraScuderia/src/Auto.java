public class Auto {
    private Scuderie scuderia;
    private Pilota pilota;
    private int cilindrata;

    public Auto(Scuderie scuderia, Pilota pilota, int cilindrata) throws Exception {
        setPilota(pilota);
        setScuderia(scuderia);
        setCilindrata(cilindrata);
    }

    public void setScuderia(Scuderie scuderia) throws Exception {
        try {
            this.scuderia = scuderia;
        } catch (Exception e) {
            throw new Exception("Errore scuderia");
        }
    }

    public Scuderie getScuderia() {
        return scuderia;
    }

    public void setPilota(Pilota pilota) throws Exception {
        try {
            this.pilota = pilota;
        } catch (Exception e) {
            throw new Exception("Errore pilota");
        }
    }

    public Pilota getPilota() {
        return pilota;
    }

    public void setCilindrata(int cilindrata) throws Exception {
        try {
            this.cilindrata = cilindrata;
        } catch (Exception e) {
            throw new Exception("Errore cilindrata");
        }
    }

    public int getCilindrata() {
        return cilindrata;
    }

    @Override
    public String toString() {
        return "Auto: Scuderia: " + getScuderia() + " - Cilindrata: " + getCilindrata() + " - Pilota: " + getPilota();
    }
}
