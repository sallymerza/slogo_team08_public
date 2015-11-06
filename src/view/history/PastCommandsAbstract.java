package view.history;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.GUIManager;

public abstract class PastCommandsAbstract extends VBox implements PastCommandsInterface {

    private Scene myScene;
    private GUIManager myGuiManager;
    private ResourceBundle myResource;
    private ScrollPane myScroller = new ScrollPane();
    private List<Button> myAllButtons = new ArrayList<Button>();
    private List<String> myButtonStrings = new ArrayList<String>();
    private VBox myVbox = new VBox();

    protected PastCommandsAbstract (GUIManager guiManager, Scene scene, ResourceBundle resource, String label) {
    	myScene = scene;
        myResource = resource;
        myGuiManager = guiManager;
        addLabel(label);
        myScroller.setPrefHeight(scene.getHeight() * 4 / 5);
        myScroller.setContent(myVbox);
        myScroller.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        myScroller.setHbarPolicy(ScrollBarPolicy.ALWAYS);
        setPrefWidth(scene.getWidth() / 7);
        getChildren().add(myScroller);
        getChildren().add(myVbox);
    }

    protected void addLabel (String name) {
        Label label = new Label(myResource.getString(name));
        label.setPrefWidth(myScene.getWidth() / 7);
        label.setBackground(new Background(new BackgroundFill(Color.CADETBLUE, new CornerRadii(0),
                                                              new Insets(0))));
        getChildren().add(label);
    }

    @Override
    public void addCommand (String name) {
        if (!myButtonStrings.contains(name)) {
            myButtonStrings.add(name);
            Button newButton = new Button(name);
            myAllButtons.add(newButton);
            myVbox.getChildren().add(newButton);
            addButtonEvent(newButton);
        }
    }

    @Override
    public void clear () {
        myVbox.getChildren().removeAll(myAllButtons);
    }

    protected void addButtonEvent (Button b) {
        b.setOnMouseClicked(new EventHandler<MouseEvent>() {

            @Override
            public void handle (MouseEvent event) {
                String buttonText = b.getText();
                String currConsoleText = myGuiManager.getMyConsole().getTextFromConsole();
                myGuiManager.getMyConsole().setConsoleText(buttonText);
            }

        });
    }

}
