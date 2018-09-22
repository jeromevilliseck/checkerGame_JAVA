package app;

public class Display {
		private final static String GAMENAME = "Jeu de Dames";
		private final static String PLAYER1 = "Joueur 1";
		private final static String PLAYER2 = "Joueur 2";
		
		//Messages à l'utilisateur
		public static void displayWelcomeMessage() {
			System.out.println("Bienvenue dans : " + GAMENAME);
			System.out.println();
		}
		
		public static void displayTurnPlayer1() {
			System.out.println("C'est au tour du joueur " + PLAYER1);
		}
		
		public static void displayTurnPlayer2() {
			System.out.println("C'est au tour du joueur " + PLAYER2);
		}
		
		public static void displayChoosenPiece(int _n, int _m) {
			System.out.println("Vous avez choisi la pièce N°" + _n + _m);
		}
		
		public static void displayChoosenWrongPiece() {
			System.out.println("Vous avez choisi une case non jouable, recommencez");
		}
		
		public static void displayHelpToSave() {
			System.out.println("NOTE POUR SAUVEGARDER tapez 10 en ligne et 10 en colonne");
		}
		
		public static void displayBoardWithPiecesNumber(Token[][] _board) {
			System.out.println("NUMEROS DES CASES");
			for (int i = 0; i < _board.length; i++) { //1ER boucle fait varier le premier indice
	            for (int j = 0; j < _board[i].length; j++) { //2EME boucle fait varier le deuxième indice
	            	if(_board[i][j] != null) {
	                System.out.print(" [" + _board[i][j].getPosition() + "] ");
	            	} else if(_board[i][j] == null) {
	            		System.out.print(" [  ] ");
	            	}
	            }
	            System.out.println();
	        }
			System.out.println();
		}
		
		public static void displayBoardWithPiecesColor(Token[][] _board) {
			System.out.println("PLATEAU DE JEU AVEC LES PIECES");
			for (int i = 0; i < _board.length; i++) { //1ER boucle fait varier le premier indice
	            for (int j = 0; j < _board[i].length; j++) { //2EME boucle fait varier le deuxième indice
	            	if(_board[i][j] != null) {
	                System.out.print(" [" + _board[i][j].getColor() + "] ");
	            	} else if(_board[i][j] == null) {
	            		System.out.print(" [  ] ");
	            	}
	            }
	            System.out.println();
	        }
			System.out.println();
		}
		
}
