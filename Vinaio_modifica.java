/* Bazaj Francesco modifica vinaio*/

import java.util.Scanner;	//importo la classe "Scanner" dal pacchetto java.util. La classe Scanner permette di inserire dati in input
import java.text.DecimalFormat;	//importo la classe "DecimalFormat" dal pacchetto java.text. La classe DecimalFormat permette di formattare i numeri decimali secondo un determinato pattern
public class Vinaio_modifica{
  public static void main (String[]args){
    Scanner tastiera = new Scanner (System.in);
    int scelta, barbera, merlot, lugana, numClienti = 0;
    double prezzo, iva, totale, fineGiornata = 0;
    String sceltaFineGiornata="N";
    DecimalFormat decimalFormat = new DecimalFormat ("#.##");	//crea un oggetto "DecimalFormat" con il pattern "#.##" per ridurre il numero di decimali dopo la virgola
    do{
      System.out.println("Quale vino vuoi acquistare? barbera 1, merlot 2, lugana 3");
      scelta = tastiera.nextInt ();
      if (scelta == 1){
        System.out.println("Quanti bottiglioni di barbera ha acquistato il cliente?");
        barbera = tastiera.nextInt ();
        while (barbera <= 0){
          System.out.println ("Numero di bottiglioni errato");
          barbera = tastiera.nextInt ();
        }
        prezzo = barbera * 2.25;
        iva = (prezzo / 100) * 21;
        totale = prezzo + iva;
        String prezzoOut = decimalFormat.format (prezzo);
        String ivaOut = decimalFormat.format (iva);
        String totaleOut = decimalFormat.format (totale);
        System.out.println ("VINO DA GINO \n" + "Numero di bottiglioni acquistati: " + barbera + "\n" + "Costo senza iva: " + prezzoOut + "€ \n" + "Costo totale: " + totaleOut + "€, \n" + "Di cui IVA: " + ivaOut + "€,");
        numClienti = numClienti + 1;
        fineGiornata = fineGiornata + totale;
        System.out.println ("\nSei un nuovo cliente? (S/N)");
        sceltaFineGiornata = tastiera.next ();
      }else if (scelta == 2){
        System.out.println("Quanti bottiglioni di merlot ha acquistato il cliente?");
        merlot = tastiera.nextInt ();
        while (merlot <= 0){
          System.out.println ("Numero di bottiglioni errato");
          merlot = tastiera.nextInt ();
        }
        prezzo = merlot * 1.5;
        iva = (prezzo / 100) * 21;
        totale = prezzo + iva;
        String prezzoOut = decimalFormat.format (prezzo);
        String ivaOut = decimalFormat.format (iva);
        String totaleOut = decimalFormat.format (totale);
        System.out.println ("VINO DA GINO \n" + "Numero di bottiglioni acquistati: " + merlot + "\n" + "Costo senza iva: " + prezzoOut + "€, \n" + "Costo totale: " + totaleOut + "€ \n" + "Di cui IVA: " + ivaOut + "€,");
        numClienti = numClienti + 1;
        fineGiornata = fineGiornata + totale;
        System.out.println ("\nSei un nuovo cliente? (S/N)");
        sceltaFineGiornata = tastiera.next ();
      }else if(scelta == 3){
        System.out.println("Quanti bottiglioni di lugana ha acquistato il cliente?");
        lugana = tastiera.nextInt ();
        while (lugana <= 0){
          System.out.println ("Numero di bottiglioni errato");
          lugana = tastiera.nextInt ();
        }
        prezzo = lugana * 3;
        iva = (prezzo / 100) * 21;
        totale = prezzo + iva;
        String prezzoOut = decimalFormat.format (prezzo);
        String ivaOut = decimalFormat.format (iva);
        String totaleOut = decimalFormat.format (totale);
        System.out.println ("VINO DA GINO \n" + "Numero di bottiglioni acquistati: " + lugana + "\n" + "Costo senza iva: " + prezzoOut + "€, \n" + "Costo totale: " + totaleOut + "€, \n" + "Di cui IVA: " + ivaOut + "€,");
        numClienti = numClienti + 1;
        fineGiornata = fineGiornata + totale;
        System.out.println ("\nSei un nuovo cliente? (S/N)");
        sceltaFineGiornata = tastiera.next ();
      }else{
        System.out.println("Scelta vino errata");
      }
    }while (sceltaFineGiornata.equals("S"));
    String fineGiornataOut = decimalFormat.format (fineGiornata);
    System.out.println ("Grazie per aver acquistato da 'VINO DA GINO'\n" + "Buon alcolismo!");
    System.out.println ("Chiusura cassa\n" + "Numero di clienti: " + numClienti + "\n Guadagno totale: " + fineGiornataOut + "€");
  }
}
