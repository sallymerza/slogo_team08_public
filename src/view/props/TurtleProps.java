package view.props;

import java.io.File;
import java.io.FileInputStream;
import java.util.ResourceBundle;
import controller.ModelController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import view.scene.TurtleScene;
import view.scene.TurtleSceneTab;


public class TurtleProps extends AbstractProperties {
    private Stage myStage;

    public TurtleProps (TurtleScene scene,
                        ResourceBundle resource,
                        ModelController controller,
                        Stage stage) {
        super(scene, resource, controller);
        myStage = stage;
    }

    @Override
    protected void createTab () {
        setText(myResource.getString("TURTLE"));
        VBox vb = new VBox();

        HBox hb1 = addNumTurtLabel();
        HBox hb4 = addTurtShapeLabel();
        HBox hb5 = addTurtVisibleLable();
        HBox hb6 = activeTurtVisibleLabel();

        setAllMargins(allElements);

        vb.getChildren().addAll(hb1, hb4, hb5, hb6);

        setContent(vb);
    }

    private HBox addNumTurtLabel () {
        HBox hb1 = new HBox();
        Label numTurtles = new Label(myResource.getString("NUMTURT"));
        ObservableList<String> numTurtlesOptions = FXCollections.observableArrayList("1", "2", "3");
        final ComboBox cbNumTurtles = new ComboBox(numTurtlesOptions);
        hb1.getChildren().addAll(numTurtles, cbNumTurtles);

        allElements.add(numTurtles);
        allElements.add(cbNumTurtles);

        return hb1;
    }

    private HBox addTurtShapeLabel () {
        HBox hb4 = new HBox();
        Label turtleShape = new Label(myResource.getString("TURTSHAPE"));
        Button chooseShape = new Button("Choose Shape");
        chooseShape.setOnAction( (e) -> {
            openImage();
        });
        hb4.getChildren().addAll(turtleShape, chooseShape);

        allElements.add(turtleShape);
        allElements.add(chooseShape);

        return hb4;
    }

    private void openImage () {
        FileChooser chooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter = new FileChooser.ExtensionFilter(
                                                                                      "Image files (*.png), (*.jpg), (*.bmp)",
                                                                                      "*.png",
                                                                                      "*.jpg",
                                                                                      "*.bmp");
        chooser.getExtensionFilters().add(extensionFilter);
        File userDirectory = getDataDirectory();
        if (userDirectory.canRead()) {
            chooser.setInitialDirectory(userDirectory);
        }
        File file = chooser.showOpenDialog(myStage);
        try {
            if (file != null) {
                FileInputStream stream = new FileInputStream(file);
                Image img = new Image(stream);
                ImageView newTurt = new ImageView(img);

                TurtleSceneTab currTab = myTurtleScene.getCurrTab();
                int sceneId = myTurtleScene.getIdOfTab();
                currTab.setTurtImage(newTurt, 0);
                currTab.getSlogoImage(0).changeTurtImage(newTurt);

                myTurtleScene.updateMyTabs(sceneId, currTab);
            }
        }
        catch (Exception e) {
            // showError("Error!","Failed to load "+file.getName(),e);
        }
    }

    private HBox addTurtVisibleLable () {
        HBox hb5 = new HBox();
        Label turtVisible = new Label(myResource.getString("TURTVIS"));
        ObservableList<String> visibleOptions =
                FXCollections.observableArrayList("Visible", "Invisible");
        final ComboBox cbTurtVisible = new ComboBox(visibleOptions);
        hb5.getChildren().addAll(turtVisible, cbTurtVisible);

        allElements.add(turtVisible);
        allElements.add(cbTurtVisible);

        return hb5;
    }
    
    private HBox activeTurtVisibleLabel () {
        HBox hb6 = new HBox();
        Label turtVisible = new Label(myResource.getString("ACTVIS"));
        ObservableList<String> visibleOptions =
                FXCollections.observableArrayList("Yes", "No");
        final ComboBox cbTurtVisible = new ComboBox(visibleOptions);
        cbTurtVisible.setOnAction(e->myTurtleScene.setActiveVisibility((String)cbTurtVisible.getSelectionModel().getSelectedItem()));
        hb6.getChildren().addAll(turtVisible, cbTurtVisible);

        allElements.add(turtVisible);
        allElements.add(cbTurtVisible);

        return hb6;
    }

    private File getDataDirectory () {
        File file = new File(System.getProperty("user.dir") + File.separator + "data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }
}
