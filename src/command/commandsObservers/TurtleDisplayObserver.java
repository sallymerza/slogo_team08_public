
package command.commandsObservers;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import command.display.Display;
import command.display.DisplayCommands;
import javafx.scene.paint.Color;
import model.data.ActiveTurtles;
import model.data.TurtleData;
import model.turtleinfo.Pen;

/**
 *
 * @author Sally Al
 *
 */
public class TurtleDisplayObserver extends DisplayCommandObserver {

	private static final long serialVersionUID = -350004370138167591L;
	TurtleData data;

	public TurtleDisplayObserver(TurtleData turtleData) {
		super(turtleData);
		this.data = turtleData;
	}

	@Override
	public void update(Observable o, Object arg) {

		DisplayCommands observedClass = (DisplayCommands) o;
		Map<Display, List<Double>> map=observedClass.getMap();

		if(map.get(Display.SETPC)!=null){
			for(int i = 0; i<getCurrent().size();i++){
				int turt = getCurrent().activeTurtleListValue(i);
				getPen(turt).setColor(Color.web(myColors.get(map.get(Display.SETPC).get(0).intValue())));
			}
		}
		if(map.get(Display.SETPS)!=null){
			for(int i = 0; i<getCurrent().size();i++){
				int turt = getCurrent().activeTurtleListValue(i);
				getPen(turt).setThickness(map.get(Display.SETPS).get(0).intValue());
			}
		}
		if(map.get(Display.SETSH)!=null){
			for(int i = 0; i<getCurrent().size();i++){
				int turt = getCurrent().activeTurtleListValue(i);
				getPen(turt).setDashes(map.get(Display.SETPS).get(0));
			}
		}



	}

	private ActiveTurtles getCurrent() {
		return data.prepareActiveTurtles();
	}

	private Pen getPen(int turt) {
		return data.myTurtles().getAllTurtles().get(turt).getPen();
	}

}
