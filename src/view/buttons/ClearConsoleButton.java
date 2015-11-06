package view.buttons;

import java.util.ResourceBundle;
import controller.ModelController;
import view.GUIManager;
import view.console.ConsoleUI;


public class ClearConsoleButton extends AbstractButton {

    ClearConsoleButton (ConsoleUI console,
                        ModelController controller,
                        GUIManager guimanager,
                        ResourceBundle resource,
                        String buttonName) {
        super(console, controller, guimanager, resource, buttonName);
    }

    @Override
    protected void action () {
        myConsole.clearTextFromConsole();
    }

}
