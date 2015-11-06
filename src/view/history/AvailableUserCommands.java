package view.history;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import view.GUIManager;

public class AvailableUserCommands extends PastCommandsAbstract {

    public AvailableUserCommands (GUIManager guiManager, Scene scene, ResourceBundle resource, String label) {
        super(guiManager, scene, resource, "USERINFO");
    }

}
