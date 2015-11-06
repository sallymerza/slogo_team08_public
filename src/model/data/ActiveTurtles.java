// This entire file is part of my masterpiece.
// Sally Al
package model.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Sally Al
 *
 */
public class ActiveTurtles implements Serializable {


	private static final long serialVersionUID = 1920533774790920840L;
	private List<Integer> activeTurtles;

    protected ActiveTurtles () {
        activeTurtles = new ArrayList<Integer>();
        activeTurtles.add(0);

    }

    public void update (int activeTobe) {

        if (activeTurtles.contains(activeTobe) == false) {
            activeTurtles.add(activeTobe);

        }
    }

    public int size () {
        return activeTurtles.size();
    }

    public void remove(int index){
    	activeTurtles.remove(index);
    }
    public void clear(){
    	activeTurtles.clear();
    }

    public int activeTurtleListValue (int index) {
        if (index < activeTurtles.size()) {
            return activeTurtles.get(index);
        }
        else {
            return 0;
        }
    }

    public List<Integer> getActives(){
    	return activeTurtles;
    }
}
