/*Dato un insieme disordinato (di dimensione minima 8 e massima 10 elementi) di numeri interi non ripetuti (valore minimo 1, valore massimo 30),
ordini, in ordine crescente, i soli numeri PARI, lasciando gli eventuali dispari nella loro posizione originaria.*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner tastiera = new Scanner(System.in);
        int[] array;
        int inserimento, numNumeri=1;
        boolean presente;
        System.out.println("Quanti elementi vuoi inserire?");
        do {
            array = new int[Integer.parseInt(tastiera.nextLine())];
            if (array.length<8 || array.length>10){
                System.out.println("Inserire una quantità valida (tra 8 e 10)");
            }
        }while(array.length<8 || array.length>10);
        for (int i=0; i< array.length; i++){
            numNumeri++;
            do{
                presente=false;
                System.out.println("Inserisci il "+(i+1)+"° numero (tra 1 e 30)");
                try {
                    inserimento = Integer.parseInt(tastiera.nextLine());
                }catch (Exception)

                for (int j=0; j<numNumeri; j++){
                    if (array[j]==inserimento){
                        presente=true;
                        System.out.println("Numero già inserito");
                    }else{
                        array[i]=inserimento;
                    }
                }
            }while(inserimento<1 || inserimento>10 || presente==true);
        }
        for (int i=0; i< array.length; i++){
            System.out.println(array[i]);
        }
    }
}