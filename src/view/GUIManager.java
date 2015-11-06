package view;

import java.util.Optional;
import java.util.ResourceBundle;
import controller.ModelController;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.console.ConsoleUI;
import view.console.Prompt;
import view.history.AvailableUserCommands;
import view.history.History;
import view.props.AllProperties;
import view.props.CurrentTurtleState;
import view.scene.TurtleScene;
import view.settings.LangDialog;
import view.settings.MenuPanel;


public class GUIManager extends BorderPane {
    private static final String TITLE = "SLogo";
    public static final String DEFAULT_RESOURCE_PACKAGE = "resources/";
    public static final String STYLESHEET = "default.css";

    protected Stage myStage;
    private Scene myScene;
    private Group myRoot;

    private ModelController myModelController;
    private AvailableUserCommands myAvailableUserCommands;
    private History myHistory;
    private ConsoleUI myConsoleUI;
    private TurtleScene myTurtleScene;
    private CurrentTurtleState myCurrTurtState;
    private AllProperties myProps;
    private MenuPanel myMenu;
    public ResourceBundle myResource;

    /**
     * Instantiates the entire view
     *
     * @param stage
     * @param modelController
     */
    public GUIManager (Stage stage, ModelController modelController) {
        langInput();
        myStage = stage;
        myModelController = modelController;
        Scene scene = init((int) stage.getWidth(), (int) stage.getHeight());
        stage.setScene(scene);
        stage.setTitle(TITLE);

        prefHeightProperty().bind(scene.heightProperty());
        prefWidthProperty().bind(scene.widthProperty());

        addTopPane();
        addCenterPane();
        addBottomPane(scene);
        addRightPane(scene);
        addLeftPane(scene);

        myRoot.getChildren().addAll(this);
        stage.show();
    }

    /**
     * Prompts user to choose a language for the IDE platform
     */
    private void langInput () {
        LangDialog lang = new LangDialog();
        Optional<ResourceBundle> resource = lang.showAndWait();
        if (resource.isPresent()) {
            myResource = resource.get();
        }
    }

    /**
     * The next 5 methods instantiate different parts of the view: Menu Console
     * Scene Properties History/User Commands
     */
    private void addTopPane () {
        myMenu = new MenuPanel(myStage, myModelController, myResource);
        setTop(myMenu);
    }

    private void addCenterPane () {
        myTurtleScene = new TurtleScene(myModelController, myResource);
        setCenter(myTurtleScene);
    }

    private void addBottomPane (Scene scene) {
        myConsoleUI = new ConsoleUI(scene, myModelController, this, myResource, myTurtleScene);
        setBottom(myConsoleUI);
    }

    private void addRightPane (Scene scene) {
        GridPane turtstateAndProps = new GridPane();
        myCurrTurtState = new CurrentTurtleState(this, scene, myResource, myTurtleScene);
        turtstateAndProps.add(myCurrTurtState, 0, 1);
        myProps =
                new AllProperties(scene, myTurtleScene, this, myResource, myStage,
                                  myModelController);
        turtstateAndProps.add(myProps, 0, 2);
        setRight(turtstateAndProps);
    }

    private void addLeftPane (Scene scene) {
        GridPane histAndUser = new GridPane();
        myHistory = new History(this, scene, myResource, "HISTBAR");
        histAndUser.add(myHistory, 1, 1);
        myAvailableUserCommands = new AvailableUserCommands(this, scene, myResource, "USERINFO");
        histAndUser.add(myAvailableUserCommands, 2, 1);
        setLeft(histAndUser);
    }

    /**
     * Gets the root of the scene.
     *
     * @return
     */
    public Group getRoot () {
        return myRoot;
    }

    /**
     * Sets the language of the IDE platform.
     *
     * @param lang
     */
    public void setLanguage (String lang) {
        myResource = ResourceBundle.getBundle("resources.languages/" + lang);
        System.out.print(myResource.getString("RUN"));
    }

    public TurtleScene getTurtScene () {
        return myTurtleScene;
    }

    public History getMyHistory () {
        return myHistory;
    }

    public AvailableUserCommands getMyUserCommands () {
        return myAvailableUserCommands;
    }

    public CurrentTurtleState getMyCurrTurtState () {
        return myCurrTurtState;
    }

    public Prompt getMyPrompt () {
        return myConsoleUI.getPrompt();
    }
    
    public ConsoleUI getMyConsole() {
    	return myConsoleUI;
    }

    /**
     * Initialize the window
     *
     * @param width
     *        The width of the window
     * @param height
     *        The height of the window
     * @return the Scene that was initialized
     */
    private Scene init (int width, int height) {
        myRoot = new Group();
        myScene = new Scene(myRoot, width, height, Color.AZURE);
        // myScene.getStylesheets().add(DEFAULT_RESOURCE_PACKAGE + STYLESHEET);
        return myScene;
    }

}
