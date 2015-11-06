package view.console;

import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import javafx.scene.Scene;
import model.SlogoScene;
import view.scene.TurtleScene;


public class Prompt extends ConsoleTabPane implements Observer {
    private TurtleScene myTurtScene;

    public Prompt (Scene scene, ResourceBundle resource, TurtleScene turtScene) {
        super(scene);
        myFirstTab.setText(resource.getString("PROMPT"));
        myTextArea.setEditable(false);
        myTurtScene = turtScene;
    }

    private void setPromptText (String text) {
        myTextArea.clear();
        myTextArea.setText(text);
    }

    @Override
    public void update (Observable o, Object arg) {
        SlogoScene scene = (SlogoScene) o;

        int tabId = myTurtScene.getIdOfTab();
        myTurtScene.getCurrTab();

        double currValue = scene.getCommandData(tabId).getCommandValue();

        setPromptText(currValue + "");

        String errorMessage = scene.getErrorData(tabId).getErrorMessage();
        if (errorMessage != null) {
            setPromptText(errorMessage + "");
        }
    }

}
