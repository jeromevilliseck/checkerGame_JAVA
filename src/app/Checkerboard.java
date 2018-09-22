package app;

public class Checkerboard{
		private final int WIDTH = 10;
		private final int LENGTH = 10;
		
		private Token[][] board;
		
		private static Checkerboard instance = new Checkerboard(); //SINGLETON INSTRUCTION n°1 ->  Creer un objet instancié avec la classe elle même
		//Static obligatoire pour que le corps de la méthode de l'instruction n°3 fonctionne sans instanciation
		
		public Token[][] CheckerboardCreate() {
			
				this.board = new Token[WIDTH][LENGTH];
				for(int i = 0; i <= 9; i++) {
					if(i == 0 || i == 2) { //Les lignes noires d'origine en pair
						for (int j = 1; j <= 9; j += 2) { //Les jetons noirs sur cette paire
							board[i][j]= new Token(EnumType.SIMPLE, EnumColor.X, Integer.valueOf(String.valueOf(i) + String.valueOf(j))); //La valeur qui vaut noir
						}
					}
					else if (i == 1 || i==3) { //Les lignes noires d'origine en impair
						for (int j = 0; j <= 8; j += 2) { //Les jetons noirs sur cette paire
							board[i][j]= new Token(EnumType.SIMPLE, EnumColor.X, Integer.valueOf(String.valueOf(i) + String.valueOf(j))); //La valeur qui vaut noir
						}
					}
					else if (i == 6 || i== 8) { //Les lignes blanches d'origine en pair
						for (int j = 1; j <= 9; j += 2) { //Les jetons blanc sur cette paire
							board[i][j]= new Token(EnumType.SIMPLE, EnumColor.O, Integer.valueOf(String.valueOf(i) + String.valueOf(j))); //La valeur qui vaut blanc
						}
					}
					else if (i == 7 || i == 9) { //Les lignes blanches d'origine en impair
						for (int j = 0; j<= 8; j+=2) { //Les jetons blanc sur cette paire
							board[i][j]= new Token(EnumType.SIMPLE, EnumColor.O, Integer.valueOf(String.valueOf(i) + String.valueOf(j)));//La valeur qui vaut blanc
						}
					}
				}
				
				return this.board;
		}		
		
		public static Checkerboard getInstance() { //SINGLETON INSTRUCTION n°3 -> Obtenir l'unique objet disponible (accesseur/getter)
			return instance; //Le retour de la méthode donne un objet Checkerboard. Penser sur l'objet crée dans la feuille principale à appeler la méthode CheckerboardCreate()
		}
		
		private Checkerboard() {} //SINGLETON INSTRUCTION n°2 -> Creer un constructeur privé de façon à ce que la classe ne puisse pas être instanciée.
}
