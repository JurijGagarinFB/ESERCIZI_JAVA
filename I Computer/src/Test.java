// Classe di test
public class Test {
    public static void main(String[] args) {
        // Istanziazione di oggetti per ciascuna tipologia

        // Oggetto PC base
        PC pcBase = new PC("Intel i5", 8, 512, "HP", "ProBook", "Windows 10");
        System.out.println(pcBase.toString());

        // Oggetto PCFisso generico
        PCFisso pcFisso = new PCFisso("AMD Ryzen 5", 16, 1024, "Dell", "Optiplex", "Linux", tipoContenitore.medio);
        System.out.println(pcFisso.toString());

        // Oggetto Desktop
        Desktop desktop = new Desktop("Intel i7", 16, 2048, "Lenovo", "ThinkCentre", "Windows 11", tipoContenitore.grande, "NVIDIA GTX 1660");
        System.out.println(desktop.toString());

        // Oggetto Server
        Server server = new Server("Intel Xeon", 32, 4096, "IBM", "System x", "Linux", tipoContenitore.piccolo, 4, true);
        System.out.println(server.toString());

        // Oggetto PCPortatile (Notebook)
        PCPortatile notebook = new PCPortatile("Intel i7", 16, 512, "Apple", "MacBook Pro", "macOS",
                1.8, 1.2, 30.4, 21.2, 13.3);
        System.out.println(notebook.toString());

        // Esempio di equals
        Desktop desktop2 = new Desktop("Intel i7", 16, 2048, "Lenovo", "ThinkCentre", "Windows 11", tipoContenitore.grande, "NVIDIA GTX 1660");
        System.out.println("desktop e desktop2 sono uguali? " + desktop.equals(desktop2));

        // Esempio di up-casting
        // Un Desktop è anche un PCFisso e quindi anche un PC.
        PC pcUpCast = desktop;   // Up-casting implicito
        System.out.println("Up-casting: " + pcUpCast.toString());

        // Esempio di down-casting
        // Supponiamo di avere un riferimento di tipo PC che in realtà punta a un Desktop
        if (pcUpCast instanceof Desktop) {
            Desktop downCastDesktop = (Desktop) pcUpCast;  // Down-casting esplicito
            System.out.println("Down-casting: Scheda video = " + downCastDesktop.getSchedaVideo());
        }

        // Esempio di down-casting NON valido (per evitare ClassCastException)
        // Ad esempio, un oggetto PCPortatile non può essere castato a PCFisso.
        PC pcPortatile = notebook; // up-casting implicito (notebook è un PC)
        if (pcPortatile instanceof PCFisso) {
            PCFisso pcFissoFromPortatile = (PCFisso) pcPortatile; // questo blocco non verrà eseguito
            System.out.println(pcFissoFromPortatile.toString());
        } else {
            System.out.println("Impossibile effettuare down-casting da PCPortatile a PCFisso.");
        }
    }
}