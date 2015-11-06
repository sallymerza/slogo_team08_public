
package model.data;

import command.commandsObservers.ViewDisplayObserver;
import javafx.scene.paint.Color;

/**
 *
 * @author Sally Al
 *
 */
public class BackgroundData {
	private ViewDisplayObserver viewisplayObserver;
	private transient Color myColor;

	protected BackgroundData() {
		viewisplayObserver = new ViewDisplayObserver(this);

	}

	public Color getMyColor() {
		return myColor;

	}

	public void setMyColor(Color color) {
		myColor = color;
	}

	public ViewDisplayObserver getDisplayCommandsObserver() {
		return viewisplayObserver;
	}

}
