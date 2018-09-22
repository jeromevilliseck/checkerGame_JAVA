package app.memento;

import app.Token;

public class Memento {
	private Token[][] state; //L'etat sauvegardé de type Token 

    //Constructor
    public Memento(Token[][] state){
        this.state = state;
    }

    //Getter
    public Token[][] getState(){
        return state;
    }
}
