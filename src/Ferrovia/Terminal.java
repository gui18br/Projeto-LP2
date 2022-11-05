package Ferrovia;

import java.util.Scanner;
import java.util.Stack;

public class Terminal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locomotiva l1 = new Locomotiva('1');
		Locomotiva l2 = new Locomotiva('2');
		Stack<Object> viaFerreaMin = new Stack<>();
		Stack<Object> viaFerreaGra = new Stack<>();

		for (int i =0; i<=13; i++) {
			
			System.out.println("Informe o endereco do Vagao: ");
			char ende = sc.next().charAt(0);
			
			System.out.println("Informe para qual locomotiva o vagao irá: ");
			int loc = sc.nextInt();
			
			System.out.println("Informe o peso do vagao: ");
			double peso = sc.nextDouble();
			
			System.out.println("Qual commoditie o vagao esta levando? ");
			String cm = sc.next();
			
			Vagao vagao = new Vagao(ende, loc, peso, cm);
					
		}
		
		
	}

}
