package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import view.GUIManager;
import view.scene.TurtleScene;


public class AllProperties extends TabPane {

    private List<Tab> allTabs = new ArrayList<Tab>();
    private TurtleProps myTurtProps;
    private SceneProps mySceneProps;
    private PenProps myPenProps;

    public AllProperties (Scene scene,
                          TurtleScene turtScene,
                          GUIManager gui,
                          ResourceBundle resource,
                          Stage stage,
                          ModelController controller) {
        myTurtProps = new TurtleProps(turtScene, resource, controller, stage);
        mySceneProps = new SceneProps(turtScene, resource, controller);
        myPenProps = new PenProps(turtScene, resource, controller);
        allTabs.add(myTurtProps);
        allTabs.add(mySceneProps);
        allTabs.add(myPenProps);
        getTabs().addAll(allTabs);
        setPrefWidth(scene.getWidth() * 2 / 7);
        setPrefHeight(scene.getHeight()*2/5);

    }

}
