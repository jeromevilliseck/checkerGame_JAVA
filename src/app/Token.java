/**
 * 
 */
package app;

import java.util.Scanner;

/**
 * @author jerome
 *
 */
public class Token{
	
		//Déclaration d'un objet scanner statique pour l'ensemble de la classe
		private static Scanner keyb = new Scanner(System.in);
		
		//Etats
		private EnumType type; //SIMPLE pour Pion, CHECKER pour Dame
		private EnumColor color; //Noir ou Blanc
		private int position; //Coordonnées en cours du Pion -> Obtenues avec une concatenation spécifique
	
/*--------------------------------------------------------------------------------------------------------------------------------*/		
			
		//Comportements
		public void move() {//Déplacement en valeur absolue --> (0) JE VEUX FAIRE QUOI ? modifier la position de mon pion (1) JE RECOIS QUOI ? rien (2) JE RETOURNE QUOI ? rien. JE MODIFIE QUOI ? int position (3) JE FAIS CE QUOI COMMENT ? bloc instructions
			if(this.type == EnumType.SIMPLE) {
				System.out.print("PION, couleur ");
				if(this.color == EnumColor.X) {
					System.out.println(EnumColor.X + " : ");
					if((this.position == 1) || (this.position == 3) || (this.position == 5) || (this.position == 7) || (this.position == 12) || (this.position == 14) || (this.position == 16) || (this.position == 18) || (this.position == 21) || (this.position == 23) || (this.position == 25) || (this.position == 27) || (this.position == 32) || (this.position == 34) || (this.position == 36) || (this.position == 38) || (this.position == 41) || (this.position == 43) || (this.position == 45) || (this.position == 47) || (this.position == 52) || (this.position == 54) || (this.position == 56) || (this.position == 58) || (this.position == 61) || (this.position == 63) || (this.position == 65) || (this.position == 67) || (this.position == 72) || (this.position == 74) || (this.position == 76) || (this.position == 78) || (this.position == 81) || (this.position == 83) || (this.position == 85) || (this.position == 87) ) {
						int n;
						do { //MECANISME DE CONTROLE SUR SAISIE UTILISATEUR
						System.out.println("Voulez-vous allez à gauche ou à droite ? /n Gauche : tapez 1, Droite : tapez 2");
						n = keyb.nextInt();
						} while ((n < 1) || (n > 2));
						
						if(n == 1) {
							this.setPosition(this.position + 9);
						}else if(n == 2) {
							this.setPosition(this.position + 11);
						}
						
					} else if((this.position == 10) || (this.position == 30) || (this.position == 50) || (this.position == 70) || (this.position == 90)) { //Partie gauche du damier
							this.setPosition(this.position + 11);
					} else if((this.position == 9) || (this.position == 29) || (this.position == 49) || (this.position == 69) || (this.position == 89)) { //Partie droite du damier
							this.setPosition(this.position + 9);
					}
				} else if(this.color == EnumColor.O) {
					System.out.println(EnumColor.O + " : ");
					if((this.position == 12) || (this.position == 14) || (this.position == 16) || (this.position == 18) || (this.position == 21) || (this.position == 23) || (this.position == 25) || (this.position == 27) || (this.position == 32) || (this.position == 34) || (this.position == 36) || (this.position == 38) || (this.position == 41) || (this.position == 43) || (this.position == 45) || (this.position == 47) || (this.position == 52) || (this.position == 54) || (this.position == 56) || (this.position == 58) || (this.position == 61) || (this.position == 63) || (this.position == 65) || (this.position == 67) || (this.position == 72) || (this.position == 74) || (this.position == 76) || (this.position == 78) || (this.position == 81) || (this.position == 83) || (this.position == 85) || (this.position == 87) || (this.position == 92) || (this.position == 94) || (this.position == 96) || (this.position == 98)) {
							int m;
							do {
								System.out.println("Voulez-vous allez à gauche ou à droite ? Gauche : tapez 1, Droite : tapez 2");
								m = keyb.nextInt();
							} while ((m < 1) || (m > 2));
							
							if(m == 1) {
								this.setPosition(this.position - 11);
							}else if(m == 2) {
								this.setPosition(this.position - 9);
							}
					
					} else if((this.position == 10) || (this.position == 30) || (this.position == 50) || (this.position == 70) || (this.position == 90)) { //Partie gauche du damier
						this.setPosition(this.position - 9);
					} else if((this.position == 9) || (this.position == 29) || (this.position == 49) || (this.position == 69) || (this.position == 89)) { //Partie droite du damier
						this.setPosition(this.position - 11);
					}
				}
			} else if(this.type == EnumType.CHECKER) { //Déplacement d'une dame
					int userChoice;
					double tempA;
					double tempB;
					do {
						System.out.println("Saisir une case autorisée ou vous voulez aller (déplacement en diagonale uniquement");
						userChoice = keyb.nextInt();
						tempA = this.position - userChoice;
						tempA = tempA / 11; //La division par 11 de la soustraction de la case choisie par la case d'origine renvoie 0f si on a choisi une diagonale
						tempB = this.position - userChoice;
						tempB = tempB / 9; //La division par 9 idem pour l'autre diagonale
					} while ((tempA != 0f) || (tempB != 0f));	 //Tant que l'on à pas un choix utilisateur qui correspond à un déplacement autorisé on lui redemande de saisir un choix valide
					this.position = userChoice;
				}
			}
		

		public static Token changePosition(Token[][] _board, Token _actualToken, int _initialPosition, int _a, int _b, Token _originToken){
			int _newPosition = _actualToken.getPosition(); //Position de la manipulée
			
			//EXPLODE -> Scindement de la position pour la manipuler à travers les indices
			int unit, decim = 0;
			if(_newPosition > 9) { //CONTROLE decimale irrecuperable sur n => 9 
				//TODO check if >= OR >
				decim = _newPosition / 10; //Recupération de la décimale si chiffre > 9
			}
			unit = _newPosition % 10; //Recupération de l'unité via modulo
			
			Token _targetToken = _board[decim][unit]; //Variable locale de type Objet Token instancié avec l'indice cible du mouvement
			//On peut maintenant manipuler l'objet cible et les faire s'affronter entre eux
			
			
			//ECRIRE DES CONDITIONS IMBRIQUEES
				if(_targetToken != null) { //Si la case n'est pas nulle, on effectue les contrôles suivants
						if(_targetToken.getColor() != _actualToken.getColor()) { //Si la cible est de couleur différente que la manipulée -> Si cette condition n'est pas remplie il faut sortir, afficher un message déplacement impossible et remttre la position d'origine à la manipulée
							switch (_initialPosition - _targetToken.getPosition()) {
							case 9: //PRODUIT DU CALCUL DANS L'ESPACE La pièce que je veux prendre se situe en : haut / droite
								_board[decim][unit] = null; //Je détruit la pièce cible en accédant au bon indice grâce aux variables locales decim et unit
								_actualToken.setPosition(_initialPosition-9*2); //J'actualise la position de la manipulée pour passer au dessus de la pièce détruite en diagonale
								//La portée des variables locales étant encore plus faible ci-dessous, je peux les réaffecter
									if(_actualToken.getPosition() > 9) { 
										decim = _actualToken.getPosition() / 10; //J'utilise les accesseurs pour ne pas me faire pièger 
									}
									unit = _actualToken.getPosition() % 10;
								_board[decim][unit] = _actualToken; //Je place la manipulée sur le bon emplacement (l'OBJET dans le bon INDICE)
								
								_board[_a][_b] = null; //Destruction de l'objet sur la position d'origine
								
								break;
							case 11: //DIAGONALE HAUT GAUCHE
								_board[decim][unit] = null; 
								_actualToken.setPosition(_initialPosition-11*2); 
									if(_actualToken.getPosition() > 9) { 
										decim = _actualToken.getPosition() / 10; 
									}
									unit = _actualToken.getPosition() % 10;
								_board[decim][unit] = _actualToken; 
								
								_board[_a][_b] = null; //Destruction de l'objet sur la position d'origine
								
								break;
							case -11: //DIAGONALE BAS GAUCHE
								_board[decim][unit] = null; 
								_actualToken.setPosition(_initialPosition-(-11*2)); 
									if(_actualToken.getPosition() > 9) { 
										decim = _actualToken.getPosition() / 10; 
									}
									unit = _actualToken.getPosition() % 10;
								_board[decim][unit] = _actualToken; 
								
								_board[_a][_b] = null; //Destruction de l'objet sur la position d'origine
								
								break;
							case -9: //DIAGONALE BAS DROITE
								_board[decim][unit] = null; 
								_actualToken.setPosition(_initialPosition-(-9*2)); 
									if(_actualToken.getPosition() > 9) { 
										decim = _actualToken.getPosition() / 10; 
									}
									unit = _actualToken.getPosition() % 10;
								_board[decim][unit] = _actualToken; 
								
								_board[_a][_b] = null; //Destruction de l'objet sur la position d'origine
								
								break;
							default:
								break;
							}
						} else if (_targetToken.getColor() == _actualToken.getColor()) { //Tentative de prise d'une pièce du même type
							System.out.println("Vous n'avez pas le droit à ce mouvement, jouez autre chose");
							
							//Important : on ne détruit pas la pièce sur la position d'origine vu qu'on ne bouge pas
							
							//Remettre la position d'origine à l'attribut position de la pièce via une variable locale de type int concaténée avec 2 int
							int initialPosition = Integer.valueOf(String.valueOf(_a) + String.valueOf(_b));
							_actualToken.setPosition(initialPosition);
							
						}
					} else if (_targetToken == null) { //Tentative de déplacement de la manipulée sur un indice du plateau ne contenant pas d'objet
						_board[decim][unit] = _actualToken; //Affectation sur le nouvel indice de la manipulée
							
						_board[_a][_b] = null; //Destruction de l'objet sur la position d'origine
					}
				
				return _actualToken; //Je suis obligé de retourner le Token actuel pour obtenir sa nouvelle position, et contrôler si ce dernier va devenir une dame
			}
				
			
		
		public void changeStatus() {
			if (this.type == EnumType.SIMPLE) { //1ER CONTROLE -> Ne pas effectuer l'opération sur une dame
				if (this.color == EnumColor.X) { //Si on joue avec les X
					if ((this.position == 90) || (this.position == 92) || (this.position == 94) || (this.position == 96) || (this.position == 98)) { //Si on est arrivé de l'autre côté du plateau
						this.type = EnumType.CHECKER; //Passage en dame
					}
				} else if (this.color == EnumColor.O){ //Si on joue avec les O
					if ((this.position == 1) || (this.position == 3) || (this.position == 5) || (this.position == 7) || (this.position == 9)) { //Si on est arrivé de l'autre côté du plateau
						this.type = EnumType.CHECKER; //Passage en dame
					}
				}
			}
		}
		
		
		public static Token tempStockage(Token _board) {
			return _board;
		}
			
		//Ecrire la methode public void die() {} //Destruction de la pièce
		
		
		public EnumType changeType() {
			return null;
		} //Changement du type de la pièce
		
		
		//Accesseurs et mutateurs
		public EnumType getType() {
			return type;
		}
		public void setType(EnumType type) {
			this.type = type;
		}
		public EnumColor getColor() {
			
			return color;
			
		}
		public void setColor(EnumColor color) {
			this.color = color;
		}
		public int getPosition() {
			return position;
		}
		public void setPosition(int position) {
			this.position = position;
		}
		
		//Accesseurs spécifiques
		public int getPositionX() {
			if(this.position > 10) { 
				position =  this.position / 10; 
			}
			return position;
		}
		
		public int getPositionY() {
			position = this.position % 10;
			return position;
		}
		
		//Constructeur
		public Token(EnumType type, EnumColor color, int position) {
			this.type = type;
			this.color = color;
			this.position = position;
		}

		@Override
		public String toString() {
			return "Token [type=" + type + ", color=" + color + ", position=" + position + "]";
		}
}
