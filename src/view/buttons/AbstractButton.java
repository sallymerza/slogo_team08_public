package view.buttons;

import java.util.ResourceBundle;
import controller.ModelController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.GUIManager;
import view.console.ConsoleUI;


public abstract class AbstractButton extends Button {
    protected static final int OFFSET_SPACE = 10;
    protected Insets myInset = new Insets(OFFSET_SPACE);

    protected ResourceBundle myResources;
    protected GUIManager myGUIManager;
    protected ConsoleUI myConsole;
    protected ModelController myController;

    protected EventHandler<ActionEvent>[] myEvents = new EventHandler[1];

    AbstractButton (ConsoleUI console,
                    ModelController controller,
                    GUIManager guimanager,
                    ResourceBundle resource,
                    String buttonName) {
        myGUIManager = guimanager;
        myConsole = console;
        myController = controller;
        myResources = resource;
        myEvents[0] = (e) -> action();
        createButton(buttonName);
    }

    protected void createButton (String name) {
        setText(myResources.getString(name));

        applyCss();
        setOnAction(myEvents[0]);

        setAllMargins(this);
    }

    protected abstract void action ();

    private void setAllMargins (Node n) {
        HBox.setMargin(n, myInset);
    }
}
