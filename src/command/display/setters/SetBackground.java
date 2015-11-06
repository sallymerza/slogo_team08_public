
package command.display.setters;

import command.display.Display;
import model.data.BackgroundData;


/**
 *
 * @author Sally Al
 *
 */
public class SetBackground extends SetDisplayCommands {


	public SetBackground(BackgroundData displayData) {
		super(displayData);
	}

	private static final long serialVersionUID = -2648763549594643733L;

    @Override
    public Display getEnum () {
    	System.out.println("SA");
        return Display.SETBG;
    }

}
