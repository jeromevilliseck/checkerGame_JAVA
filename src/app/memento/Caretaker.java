package app.memento;

import java.util.ArrayList;
import java.util.List;

public class Caretaker {
	
	   private List<Memento> mementoList = new ArrayList<Memento>(); //Liste d'objets Memento, chaque objet contient une sauvegarde

	    //Add save to the list
	    public void add(Memento state){
	        mementoList.add(state);
	    }

	    //Get save from the list with indice
	    public Memento get(int index){
	        return mementoList.get(index);
	    }
	    
	    //Get the last object from list
	    public int getLastObject() {
	    		return mementoList.size() - 1;
	    }
	
}
