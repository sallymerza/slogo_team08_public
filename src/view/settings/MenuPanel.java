package view.settings;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.input.KeyCombination;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.SlogoScene;
import model.data.Data;
import view.GUIManager;


public class MenuPanel extends MenuBar {

    private Stage myStage;
    private FileChooser myFileChooser;
    private ModelController myController;
    private ResourceBundle myResource;

    public MenuPanel (Stage stage, ModelController controller, ResourceBundle resource) {
        super();
        myResource = resource;
        myController = controller;
        myFileChooser = new FileChooser();
        FileChooser.ExtensionFilter extensionFilter =
                new FileChooser.ExtensionFilter("Java files (*.ser)", "*.ser");
        myFileChooser.getExtensionFilters().add(extensionFilter);
        myStage = stage;
        getMenus().addAll(fileMenu(myStage));
    }

    /**
     * create file menu
     *
     * @return menu
     */
    private Menu fileMenu (Stage stage) {
        Menu menu = new Menu(myResource.getString("FILE"));

        MenuItem newfile = new MenuItem(myResource.getString("NEW"));
        newfile.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        newfile.setOnAction(e -> {
            newSlogo();
        });

        MenuItem open = new MenuItem(myResource.getString("OPEN"));
        open.setAccelerator(KeyCombination.keyCombination("Ctrl+O"));
        open.setOnAction(e -> {
            openSlogo();
        });

        MenuItem save = new MenuItem(myResource.getString("SAVE"));
        save.setAccelerator(KeyCombination.keyCombination("Ctrl+S"));
        save.setOnAction(e -> {
            try {
                saveSlogo();
            }
            catch (Exception e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });

        MenuItem colorArray = new MenuItem("Color Values");
        colorArray.setOnAction(e->showColorArray());

        MenuItem help = new MenuItem(myResource.getString("HELP"));
        help.setAccelerator(KeyCombination.keyCombination("Ctrl+H"));
        help.setOnAction(e -> {
            openHelp();
        });

        MenuItem exit = new MenuItem(myResource.getString("EXIT"));
        exit.setAccelerator(KeyCombination.keyCombination("Ctrl+Q"));
        exit.setOnAction(e -> {
            System.exit(0);
        });

        menu.getItems().addAll(newfile, open, save,colorArray, help, new SeparatorMenuItem(), exit);

        return menu;
    }

    private void newSlogo () {
        SlogoScene currScene = myController.getMyScene();
        GUIManager currGuiManager = myController.getGuiManager();
        new ModelController(myStage, currGuiManager, currScene);
    }

    private void openSlogo () {
        myFileChooser.setTitle(myResource.getString("OPEN"));
        File file = myFileChooser.showOpenDialog(myStage);

        try {
            if (file != null) {
                FileInputStream f = new FileInputStream(file);
                ObjectInputStream o = new ObjectInputStream(f);
                Data newDat = (Data) o.readObject();
                o.close();
                newDat.getturtleData().recreate();
                myController.getGuiManager().getTurtScene();
                myController.getGuiManager().getMyHistory().clear();
                myController.getMyScene().setData(0, newDat);
                for (String i : newDat.getHistoryData().getUserHistory()) {
                    myController.getGuiManager().getMyHistory().addCommand(i);
                    System.out.println(i);
                }
                for (String j : newDat.getCommandData().getUserCommandMap().keySet()) {
                    myController.getGuiManager().getMyUserCommands().addCommand(j);
                }
                for (String k : newDat.getCommandData().getVariableMap().keySet()) {
                    myController.getGuiManager().getMyUserCommands().addCommand(k);
                }

            }
        }
        catch (Exception e) {
            // showError("Error!","Failed to load "+file.getName(),e);
            e.printStackTrace();
        }
    }

    private void saveSlogo () throws IOException {
        myFileChooser.setTitle(myResource.getString("SAVE"));
        File slogo = myFileChooser.showSaveDialog(myStage);
        if (!slogo.exists()) {
            slogo.createNewFile();
        }
        try {
            FileOutputStream f = new FileOutputStream(slogo);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(myController.getMyScene().getAllData().get(0));
            f.close();
        }
        catch (Exception e) {
            // showError("Save Exception","Failed to save current model as an
            // XML",e);
            e.printStackTrace();
        }
    }

    public void openHelp () {
        File html = new File("HelpPage.html");
        try {
            Desktop.getDesktop().browse(html.toURI());
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showColorArray(){
    	ColorAlert array = new ColorAlert();
    	array.showAndWait();
    }

    private File getDataDirectory () {
        File file = new File(System.getProperty("user.dir") + File.separator + "data");
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

}
