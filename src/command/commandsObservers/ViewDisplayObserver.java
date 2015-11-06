
package command.commandsObservers;

import java.util.List;
import java.util.Map;
import java.util.Observable;

import command.display.Display;
import command.display.DisplayCommands;
import javafx.scene.paint.Color;
import model.data.BackgroundData;
import view.settings.SlogoProperties;

/**
 *
 * @author Sally Al
 *
 */
public class ViewDisplayObserver extends DisplayCommandObserver{

private BackgroundData bgData;
	public ViewDisplayObserver(BackgroundData bgData) {
		super(bgData);
		this.bgData=bgData;
	}


	private static final long serialVersionUID = 7058494254225115820L;


	@Override
	public void update(Observable o, Object arg) {

		DisplayCommands observedClass = (DisplayCommands) o;
		Map<Display, List<Double>> map=observedClass.getMap();
		if(map.get(Display.SETBG)!=null){
			bgData.setMyColor(Color.web(myColors.get(map.get(Display.SETBG).get(0).intValue())));
		}

		if(map.get(Display.SETPALETTE)!=null){
			String added = Color.rgb(map.get(Display.SETPALETTE).get(1).intValue(), map.get(Display.SETPALETTE).get(2).intValue(), map.get(Display.SETPALETTE).get(3).intValue()).toString();
			SlogoProperties.addColor(map.get(Display.SETPALETTE).get(0).intValue(),added);
		}

		}


}
