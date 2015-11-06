package view.props;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Tab;
import javafx.scene.layout.HBox;
import view.scene.TurtleScene;


public abstract class AbstractProperties extends Tab {
    private static final int OFFSET_SPACE = 10;
    private Insets myInset = new Insets(OFFSET_SPACE);

    protected List<Node> allElements;
    protected ResourceBundle myResource;
    protected TurtleScene myTurtleScene;
    protected ModelController myController;

    AbstractProperties (TurtleScene scene, ResourceBundle resource, ModelController controller) {
        allElements = new ArrayList<Node>();
        myResource = resource;
        myTurtleScene = scene;
        myController = controller;
        createTab();
    }

    protected abstract void createTab ();

    protected void setAllMargins (List<Node> nodes) {
        for (Node n : nodes) {
            HBox.setMargin(n, myInset);
        }
    }
}
