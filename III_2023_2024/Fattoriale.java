/******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class Fattoriale{
	public static void main(String[] args) {
		Scanner tastiera = new Scanner(System.in);
		int i=1, num=0, risultato=0;
		num = tastiera.nextInt();
		risultato=num;
		
		//fattoriale con il while
		while (i<num){
		    risultato=risultato*i;
		    i++;
		}
		
		//fattoriale con il for
		/*for (i=1; i<num; i++){
		    risultato=risultato*i;
		    i++;
		}*/
		
		if(num==0){
		    risultato=1;
		}
		System.out.println(risultato);
	}
}
