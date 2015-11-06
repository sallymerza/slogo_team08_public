package view.buttons;

import java.util.ResourceBundle;
import java.util.Set;

import controller.ModelController;
import view.GUIManager;
import view.console.ConsoleUI;
import view.scene.TurtleScene;


public class RunButton extends AbstractButton {

    RunButton (ConsoleUI console,
               ModelController controller,
               GUIManager guimanager,
               ResourceBundle resource,
               String buttonName) {
        super(console, controller, guimanager, resource, buttonName);
    }

    @Override
    protected void action () {
        TurtleScene myTurtScene = myGUIManager.getTurtScene();
        int mySceneId = myTurtScene.getIdOfTab();
        String consoleText = myConsole.getTextFromConsole();

        myController.getMyScene().parse(consoleText, mySceneId);
        myController.getMyScene().traverse(mySceneId);

        myGUIManager.getMyHistory().addCommand(consoleText);
        myController.getMyScene().getAllData().get(mySceneId).getHistoryData().getUserHistory().add(consoleText);
        addUserDefinitions();
    }

    private void addUserDefinitions () {
        TurtleScene myTurtScene = myGUIManager.getTurtScene();
        int mySceneId = myTurtScene.getIdOfTab();
        if (myController.getMyScene().getCommandData(mySceneId).getUserCommandMap().size() != 0) {
            Set<String> allUserCommands =
                    myController.getMyScene().getCommandData(mySceneId).getUserCommandMap()
                            .keySet();
            for (String i : allUserCommands) {
                myGUIManager.getMyUserCommands().addCommand(i);
            }
        }
        if (myController.getMyScene().getCommandData(mySceneId).getVariableMap().size() != 0) {
            for (String j : myController.getMyScene().getCommandData(mySceneId).getVariableMap()
                    .keySet()) {
                myGUIManager.getMyUserCommands().addCommand(j);
            }
        }
    }

}
