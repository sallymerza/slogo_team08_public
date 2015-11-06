
package command.display.setters;

import command.display.Display;
import model.data.BackgroundData;


/**
 *
 * @author Sally Al
 *
 */
public class SetPalette extends SetDisplayCommands {


	public SetPalette(BackgroundData displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = 7026916684777044850L;

    @Override
    public Display getEnum () {
        return Display.SETPALETTE;
    }

}
