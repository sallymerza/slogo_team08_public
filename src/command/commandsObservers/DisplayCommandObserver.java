
package command.commandsObservers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Observer;

import model.data.BackgroundData;
import model.data.TurtleData;
import view.settings.SlogoProperties;

/**
 *
 * @author Sally Al
 *
 */
public abstract class DisplayCommandObserver implements Observer,Serializable {

	private static final long serialVersionUID = 3904275080077140560L;

	protected ArrayList<String> myColors = SlogoProperties.getColorArray();

	public DisplayCommandObserver(BackgroundData bgData) {
	}
	public DisplayCommandObserver(TurtleData data){

	}



	}


