package view.props;

import java.util.ResourceBundle;
import controller.ModelController;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;


public class SceneProps extends AbstractProperties {

    public SceneProps (TurtleScene turtscene, ResourceBundle resource, ModelController controller) {
        super(turtscene, resource, controller);
    }

    @Override
    protected void createTab () {
        setText(myResource.getString("SCENE"));
        VBox vb = new VBox();
        HBox hb2 = addBGColorLabel();

        setAllMargins(allElements);

        vb.getChildren().addAll(hb2);

        setContent(vb);
    }

    private HBox addBGColorLabel () {
        HBox hb7 = new HBox();
        Label background = new Label(myResource.getString("BACKGROUNDC"));

        ComboBox<Color> cmbColors = new ColorComboBox();

        cmbColors.setOnAction( (event) -> {
            Color chosenColor = cmbColors.getSelectionModel().getSelectedItem();
            Canvas currCanvas =
                    (Canvas) myTurtleScene.getSelectionModel().getSelectedItem().getContent();

            TurtleSceneTab currTab = myTurtleScene.getCurrTab();
            int mySceneId = myTurtleScene.getIdOfTab();

            myController.getMyScene().ColorData(mySceneId).setMyColor(chosenColor);
            currTab.setBackgroundColor(currCanvas.getGraphicsContext2D(), currCanvas, myController.getMyScene().ColorData(mySceneId).getMyColor());
            System.out.println("ComboBox Action (selected: " +
                               chosenColor.toString().toUpperCase() + ")");

            myTurtleScene.updateMyTabs(mySceneId, currTab);
        });

        hb7.getChildren().addAll(background, cmbColors);

        allElements.add(background);
        allElements.add(cmbColors);

        return hb7;
    }
}
