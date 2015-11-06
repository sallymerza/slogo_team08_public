package controller;

import java.util.List;

import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import model.SlogoScene;
import model.data.AllMyTurtles;
import model.data.Data;
import model.turtleinfo.SlogoObjects;
import view.GUIManager;
import view.console.Prompt;
import view.props.CurrentTurtleState;
import view.scene.TurtleScene;


public class ModelController extends ControlFunctions {
    private static final int FRAMES_PER_SECOND = 10;
    private static final int MILLISECOND_DELAY = 1000 / FRAMES_PER_SECOND;

    private Timeline myAnimation;
    private SlogoScene myScene;
    private GUIManager myGuiManager;

    public ModelController (Stage stage) {
        super();
        myScene = new SlogoScene();
        myGuiManager = new GUIManager(stage, this);
        TurtleScene turtScene = myGuiManager.getTurtScene();
        addObservable(turtScene, myScene);

        createAnimation();
    }

    public ModelController (Stage stage, GUIManager guiManager, SlogoScene scene) {
        super();
        myScene = scene;
        Data newData = new Data();
        List<SlogoObjects> allTurtles = allTurtlesList(newData).getAllTurtles();
        for (int i = 0; i < allTurtles.size(); i++) {
            SlogoObjects turtle = allTurtles.get(i);
            turtle.getTrail().setPoint(new Point2D(0, 0));
            allTurtlesList(newData).setTurtle(i, turtle);
        }
        myScene.getAllData().add(newData);

        myGuiManager = guiManager;
        TurtleScene turtScene = myGuiManager.getTurtScene();
        addObservable(turtScene, myScene);
        turtScene.createNewTab(this);

        createAnimation();
    }

	private AllMyTurtles allTurtlesList(Data newData) {
		return newData.getturtleData().myTurtles();
	}

    /**
     * Create the animation and timeline.
     */
    private void createAnimation () {
        // KeyFrame frame = new KeyFrame(Duration.millis(MILLISECOND_DELAY), e -> myManager.step());
        // myAnimation = new Timeline();
        // myAnimation.setCycleCount(Timeline.INDEFINITE);
        // myAnimation.getKeyFrames().add(frame);
    }

    /**
     * The controller connects the observables and observers between the front
     * end and back end.
     */
    public void addObservable (TurtleScene turtleScene, SlogoScene scene) {
        CurrentTurtleState currTurtState = myGuiManager.getMyCurrTurtState();

        scene.addObserver(turtleScene);
        scene.addObserver(currTurtState);

        Prompt prompt = myGuiManager.getMyPrompt();
        scene.addObserver(prompt);

    }

    public GUIManager getGuiManager () {
        return myGuiManager;
    }

    public SlogoScene getMyScene () {
        return myScene;
    }

}
