package view.console;

import java.util.ResourceBundle;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;


public class Console extends ConsoleTabPane {

    public Console (Scene scene, ResourceBundle resource) {
        super(scene);
        myFirstTab.setText(resource.getString("CONSOLE"));
    }

    public String getTextFromConsole () {
        TextArea currTextArea = (TextArea) getSelectionModel().getSelectedItem().getContent();
        String currText = currTextArea.getText();
        return currText;
    }

    public void clearTextFromConsole () {
        TextArea currTextArea = (TextArea) getSelectionModel().getSelectedItem().getContent();
        currTextArea.clear();
        currTextArea.requestFocus();
    }

    public void setConsoleText (String text) {
        TextArea currTextArea = (TextArea) getSelectionModel().getSelectedItem().getContent();

        String currText = currTextArea.getAccessibleText();
        String newText = "";
        if (currText == null) {
            newText = text;
        }
        else {
            newText = currText + text;
        }

        currTextArea.setText(newText);
    }

}
