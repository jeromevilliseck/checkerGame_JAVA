package app;

import java.util.Scanner;

public class Questions {
	
		//SCANNER
		private static Scanner keyb = new Scanner(System.in);
		
		//NOMBRE
		private static int numberX;
		private static int numberY;
		
		public static int LaunchGame() {
			int n;
			do {
				System.out.println("Bienvenue dans un jeu de dames");
				System.out.println("Que voulez-vous faire ?");
				System.out.println("Lancer nouvelle partie [tapez 1] | Charger une partie [tapez 2]");
				n = keyb.nextInt();
			} while ((n < 1) || (n > 2));
			return n;
		}
		
		public static int ChooseTokenX(){
			int n;
			do {
				System.out.println("Choisissez la ligne que vous voulez déplacer de -> 1 à 10");
				n = keyb.nextInt();
			} while ((n > 10) || (n < 1));
			n -= 1;
			numberX = n;
			return numberX;
		}
		
		public static int ChooseTokenY() {
			int m;
			do {
				System.out.println("Choisissez la colonne que vous voulez déplacer de -> 1 à 10");
				m = keyb.nextInt();
			} while ((m > 10) || (m < 1));
			m -= 1;
			numberY = m;
			return numberY;
		}
		
		public static int[] ChooseTokenWithControl(int[] _indice) {
			int temp;
			do {
			_indice[0] = Questions.ChooseTokenX();
			_indice[1] = Questions.ChooseTokenY();
			
			temp = Integer.valueOf(String.valueOf(_indice[0]) + String.valueOf(_indice[1]));
			Display.displayChoosenPiece(_indice[0], _indice[1]);
			if ((temp == 0) || (temp == 2) || (temp == 4) || (temp == 6) || (temp == 8) || (temp == 11) || (temp == 13) || (temp == 15) || (temp == 17) || (temp == 19) || (temp == 20) || (temp == 22) || (temp == 24) || (temp == 26) || (temp == 28) || (temp == 31) || (temp == 33) || (temp == 35) || (temp == 37) || (temp == 39) || (temp == 40) || (temp == 42) || (temp == 44) || (temp == 46) || (temp == 48) || (temp == 51) || (temp == 53) || (temp == 55) || (temp == 57) || (temp == 59) || (temp == 60) || (temp == 62) || (temp == 64) || (temp == 66) || (temp == 68) || (temp == 71) || (temp == 73) || (temp == 75) || (temp == 77) || (temp == 79) || (temp == 80) || (temp == 82) || (temp == 84) || (temp == 86) || (temp == 88) || (temp == 91) || (temp == 93) || (temp == 95) || (temp == 97)) {
				Display.displayChoosenWrongPiece();
			}
			} while((temp == 0) || (temp == 2) || (temp == 4) || (temp == 6) || (temp == 8) || (temp == 11) || (temp == 13) || (temp == 15) || (temp == 17) || (temp == 19) || (temp == 20) || (temp == 22) || (temp == 24) || (temp == 26) || (temp == 28) || (temp == 31) || (temp == 33) || (temp == 35) || (temp == 37) || (temp == 39) || (temp == 40) || (temp == 42) || (temp == 44) || (temp == 46) || (temp == 48) || (temp == 51) || (temp == 53) || (temp == 55) || (temp == 57) || (temp == 59) || (temp == 60) || (temp == 62) || (temp == 64) || (temp == 66) || (temp == 68) || (temp == 71) || (temp == 73) || (temp == 75) || (temp == 77) || (temp == 79) || (temp == 80) || (temp == 82) || (temp == 84) || (temp == 86) || (temp == 88) || (temp == 91) || (temp == 93) || (temp == 95) || (temp == 97));
	
			return _indice;
		}
}
