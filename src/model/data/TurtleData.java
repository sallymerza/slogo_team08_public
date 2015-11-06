// This entire file is part of my masterpiece.
// Sally Al
package model.data;

import java.util.ArrayList;
import java.util.List;

import command.commandsObservers.DisplayCommandObserver;
import command.commandsObservers.TurtleCommandsObserver;
import command.commandsObservers.TurtleDisplayObserver;
import model.data.interfaces.iActive;
import model.data.interfaces.iAllTurtles;
import model.turtleinfo.Trail;
import model.turtleinfo.Turtle;

/**
 *
 * @author Sally Al
 *
 */
public class TurtleData implements iActive,iAllTurtles {


	private List<Trail> myTrails;
	private ActiveTurtles activeTurtles;
	private AllMyTurtles myTurtles;
	private int activeTurtle = 0;
	private int turtleID = 0;
	private TurtleCommandsObserver turtleCommandsObserver;
	private DisplayCommandObserver turtleDisplayObserver;

	protected TurtleData() {

		myTrails = new ArrayList<Trail>();
		myTurtles= new AllMyTurtles();
		createTurtle();
		activeTurtles = new ActiveTurtles();
		activeTurtles.update(0);
		turtleCommandsObserver = new TurtleCommandsObserver(this);
		turtleDisplayObserver = new TurtleDisplayObserver(this);

	}

	public void createTurtle() {
		Turtle defaultTurtle = new Turtle();
		myTurtles.add(defaultTurtle);
		myTurtles.setTurtle(turtleID, defaultTurtle);
		myTrails.add(defaultTurtle.getTrail());
		turtleID++;

	}

	public Trail getTrail(int turtleId) {
		return myTrails.get(turtleId);
	}

	public void recreate() {
		for (int i = 0; i < myTrails.size(); i++) {
			myTrails.get(i).recreate();
			myTurtles.getTurtle(i).getPen().recreate();
		}
	}

	public TurtleCommandsObserver getTurtleCommandsObserver() {
		return turtleCommandsObserver;
	}

	public DisplayCommandObserver getTurtleDisplayObserver() {
		return turtleDisplayObserver;
	}

	@Override
	public ActiveTurtles prepareActiveTurtles() {
		return activeTurtles;
	}

	public void setActiveTurtle(int value) {
		activeTurtle = value;
	}

	public int getActiveTurtleID() {
		return activeTurtle + 1;
	}


	@Override
	public AllMyTurtles myTurtles() {
		return myTurtles;
	}

}