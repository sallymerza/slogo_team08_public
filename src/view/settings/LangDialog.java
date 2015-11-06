package view.settings;

import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;


public class LangDialog extends Dialog {

    protected ButtonType myOKer;

    public LangDialog () {
        super();
        setHeaderText("Language");
        addOk();
        Label lang = new Label("Language: ");
        ObservableList<String> languages =
                FXCollections.observableArrayList("Chinese", "English", "French", "German",
                                                  "Italian", "Portuguese", "Russian", "Spanish");
        ComboBox<String> languageChoice = new ComboBox<String>(languages);
        languageChoice.setValue("English");
        GridPane grid = new GridPane();
        grid.add(lang, 0, 0);
        grid.add(languageChoice, 1, 0);
        getDialogPane().setContent(grid);
        setResultConverter(new Callback<ButtonType, ResourceBundle>() {
            @Override
            public ResourceBundle call (ButtonType ok) {
                if (ok == myOKer) {
                    ResourceBundle ret =
                            ResourceBundle
                                    .getBundle("resources.languages/" + languageChoice.getValue());
                    return ret;
                }
                return null;
            }
        });
    }

    private void addOk () {
        myOKer = new ButtonType("Okay", ButtonData.OK_DONE);
        getDialogPane().getButtonTypes().add(myOKer);
    }
}
