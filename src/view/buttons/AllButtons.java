package view.buttons;

import java.util.ResourceBundle;
import controller.ModelController;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import view.GUIManager;
import view.console.ConsoleUI;


public class AllButtons extends VBox {

    private RunButton myRunButton;
    private ClearHistoryButton myClearHistoryButton;
    private ClearConsoleButton myClearConsoleButton;

    public AllButtons (ConsoleUI console,
                       ModelController controller,
                       Scene scene,
                       GUIManager guimanager,
                       ResourceBundle resource) {

        myRunButton = new RunButton(console, controller, guimanager, resource, "RUN");
        myClearHistoryButton =
                new ClearHistoryButton(console, controller, guimanager, resource, "CLEARHISTORY");
        myClearConsoleButton =
                new ClearConsoleButton(console, controller, guimanager, resource, "CLEAR");

        setPrefWidth(scene.getWidth() / 11);
        setPadding(
                   new Insets(scene.getWidth() / 40, scene.getWidth() / 40,
                              scene.getWidth() / 40, scene.getWidth() / 40));
        setSpacing(20);
        setStyle("-fx-background-color: #dbdbdb");
        getChildren().addAll(myRunButton, myClearConsoleButton, myClearHistoryButton);
    }

}
