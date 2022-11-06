package Ferrovia;

import java.util.Scanner;

public class Terminal {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Locomotiva l1 = new Locomotiva('1');
		Locomotiva l2 = new Locomotiva('2');
		ViaFerreaMin vfm = new ViaFerreaMin();
		ViaFerreaGra vfg = new ViaFerreaGra();
		
		vfm.embarque(l1);
		vfg.embarque(l2);
		

		for (int i =0; i<=13; i++) {
			
			System.out.println("Informe o endereco do Vagao: ");
			char ende = sc.next().charAt(0);
			
			System.out.println("Informe para qual locomotiva o vagao irá: [1] Minérios [2]Grãos ");
			int loc = sc.nextInt();
			
			System.out.println("Informe o peso do vagao: ");
			double peso = sc.nextDouble();
			
			System.out.println("Qual commoditie o vagao esta levando? ");
			String cm = sc.next();
			
			Vagao vagao = new Vagao(ende, loc, peso, cm);
			
			if(loc == 1) {
				vfm.embarque(vagao);
			}else if (loc == 2){
				vfg.embarque(vagao);
			}
		
		}

	}	
	
}
