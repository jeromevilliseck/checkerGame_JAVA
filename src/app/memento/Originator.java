package app.memento;

import app.Token;

public class Originator {
	private Token[][] state;

    //Setter
    public void setState(Token[][] state){
        this.state = state;
    }

    //Getter
    public Token[][] getState(){
        return state;
    }

    //Save state with new Memento object
    public Memento saveStateToMemento(){
        return new Memento(state); //Important -> l'état placé dans l'attribut de l'objet Originator passe en paramètre dans un nouvel objet Memento et donc l'état est placé dans l'attribut de l'objet Memento également
    }

    //Get state from Memento Object
    public Token[][] getStateFromMemento(Memento _memento){
        return _memento.getState();
    }
}
