package view.history;

import java.util.ResourceBundle;

import javafx.scene.Scene;
import view.GUIManager;

public class History extends PastCommandsAbstract {

    public History (GUIManager guiManager, Scene scene, ResourceBundle resource, String label) {
        super(guiManager, scene, resource, "HISTBAR");
    }

}
