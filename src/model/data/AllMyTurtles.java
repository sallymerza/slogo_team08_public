// This entire file is part of my masterpiece.
// Sally Al
package model.data;

import java.util.ArrayList;
import java.util.List;

import model.turtleinfo.SlogoObjects;

/**
 *
 * @author Sally Al
 *
 */
public class AllMyTurtles {
	private List<SlogoObjects> myTurtles;

	protected AllMyTurtles() {
		myTurtles = new ArrayList<SlogoObjects>();

	}

	public void setTurtle(int turtleId, SlogoObjects turtle) {
		myTurtles.set(turtleId, turtle);
	}

	public SlogoObjects getTurtle(int turtleId) {
		return myTurtles.get(turtleId);
	}

	public List<SlogoObjects> getAllTurtles() {
		return myTurtles;
	}

	public int turtleListSize() {

		return myTurtles.size();
	}

	public Boolean contains(int value) {

		return (myTurtles.contains(value));
	}

	public void add(SlogoObjects turtle) {
		myTurtles.add(turtle);

	}

}
