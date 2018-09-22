package dist.console;

import app.Checkerboard;
import app.Display;
import app.Questions;
import app.Token;
import app.memento.Caretaker;
import app.memento.Originator;

public class Main {

	public static void main(String[] args) {
			
			//Variables locales (indice) qui servent à manipuler le tableau d'objet
			int x, y;
			int a, b;
			int pos0;
			int xyvalues[] = new int[2];
			
			Token[][] board0 = null; //Obligation d'initialiser objet à null sinon problème de portée
			Originator originator = new Originator();
			Caretaker careTaker = new Caretaker();
		
			//Instanciation du plateau
			int userChoice = Questions.LaunchGame();
			
			if(userChoice == 1) {
				//Création d'un plateau de jeu vide
				Checkerboard board = Checkerboard.getInstance(); //utilisation du singleton
				
				//Instanciation du plateau de jeu
				board0 = board.CheckerboardCreate(); 
				
				//Mettre en place le système de sauvegarde
				
			} else if (userChoice == 2) {
				//Mettre en place le système de sauvegarde
				
				//Charger une partie
		        board0 = originator.getStateFromMemento(careTaker.get(careTaker.getLastObject()));
			}
			
			//Message de bienvenue
			Display.displayWelcomeMessage();
			
			do {
				//Affichage du plateau
				Display.displayBoardWithPiecesNumber(board0); //En numéro de positions 
				Display.displayBoardWithPiecesColor(board0); //En type
				Display.displayHelpToSave(); //Message d'aide à la sauvegarde en tapant 99
				
				
				//Choix de la pièce sur laquelle effectuer l'action
				Questions.ChooseTokenWithControl(xyvalues);
				x = xyvalues[0];
				y = xyvalues[1];
					
				//Stockage des valeurs d'origine des indices avant opérations
				a = x;
				b = y;	
				
				while ((x == 9) && (y == 9)) {
					//Faire une sauvegarde de la partie
			        originator.setState(board0); //EN 1 -> Plaçage du tableau en cours dans un objet Originator
			        careTaker.add(originator.saveStateToMemento()); //EN 2 -> On ajoute à la liste d'objet Memento un nouvel objet Memento crée à partir de la méthode saveStateToMemento
			        System.out.println("PARTIE SAUVERGARDEE");
			        
			        //Obligation de reposer la question et de choisir une pièce valide
			        //Choix de la pièce sur laquelle effectuer l'action
					Questions.ChooseTokenWithControl(xyvalues);
					x = xyvalues[0];
					y = xyvalues[1];
						
					//Stockage des valeurs d'origine des indices avant opérations
					a = x;
					b = y;
				}
				
				Display.displayChoosenPiece(x, y); 					//Affichage de la pièce choisie
					pos0 = board0[x][y].getPosition(); 				//Valeur de l'attribut position de la pièce avant sa modification en position cible
				
				//Traitements liés au déplacement de la pièce
				board0[x][y].move(); 								//Changement de l'attribut int position de la pièce, 
					
				Token localToken = Token.changePosition(board0, board0[x][y], pos0, a, b, board0[a][b]); 	//Déplacement de la pièce de manière intelligente -> COMPLEXE
				
				//Traitements liés à la modification du statut de la pièce
				localToken.changeStatus();
			} while (board0 != null);
			
	}
}
