// Classe Desktop, sottoclasse di PCFisso
public class Desktop extends PCFisso {
    private String schedaVideo;

    public Desktop(String processore, int ram, int memoria, String marca, String modello, String sistemaOperativo, tipoContenitore grandezzaCase, String schedaVideo) {
        super(processore, ram, memoria, marca, modello, sistemaOperativo, grandezzaCase);
        this.schedaVideo = schedaVideo;
    }

    public String getSchedaVideo() {
        return schedaVideo;
    }

    public void setSchedaVideo(String schedaVideo) {
        this.schedaVideo = schedaVideo;
    }

    @Override
    public String toString() {
        return super.toString() + "Desktop [schedaVideo=" + schedaVideo + "]\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (obj == null || !(obj instanceof Desktop)) return false;
        Desktop other = (Desktop) obj;
        return this.schedaVideo.equals(other.schedaVideo);
    }
}
