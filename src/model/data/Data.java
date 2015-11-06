// This entire file is part of my masterpiece.
// Sally Al
package model.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javafx.scene.paint.Color;
import model.data.interfaces.iBackgroundData;
import model.data.interfaces.iCommandData;
import model.data.interfaces.iError;
import model.data.interfaces.iHistory;
import model.data.interfaces.iTurtleData;

public class Data implements iTurtleData, iCommandData, iBackgroundData, iError, iHistory, Serializable {

	private static final long serialVersionUID = 2437173979976418913L;

	private TurtleData turtleData;
	private CommandData commandData;
	private BackgroundData bgData;
	private ErrorData errorData;
	private HistoryData historyData;

	public Data() {
		turtleData = new TurtleData();
		commandData = new CommandData();
		bgData = new BackgroundData();
		errorData = new ErrorData();
		historyData = new HistoryData();

		bgData.setMyColor(Color.ALICEBLUE);
		errorData.setError(false);

	}

	public void writeObject(ObjectOutputStream o) throws IOException {
		o.defaultWriteObject();
	}

	public void readObject(ObjectInputStream i) throws ClassNotFoundException, IOException {
		i.defaultReadObject();
	}

	@Override
	public TurtleData getturtleData() {
		return turtleData;
	}

	@Override
	public CommandData getCommandData() {
		return commandData;
	}

	@Override
	public BackgroundData getBackgroundData() {
		return bgData;
	}

	@Override
	public ErrorData getErrorData() {
		return errorData;
	}

	@Override
	public HistoryData getHistoryData() {
		return historyData;
	}

}
