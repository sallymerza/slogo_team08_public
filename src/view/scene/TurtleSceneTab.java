package view.scene;

import java.util.ArrayList;
import java.util.List;

import controller.ModelController;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Tab;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import model.turtleinfo.Turtle;
import view.settings.SlogoProperties;
import view.shapes.AbstractShape;
import view.shapes.StraightLine;
import view.turtles.SlogoImage;

public class TurtleSceneTab extends Tab {
	private List<SlogoImage> myAllSlogoImages;
	private AbstractShape myShape; // check this
	private Canvas myCanvas;
	private ModelController myModelController;
	private TurtleScene myTurtScene;
	private int myTempID;

	private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
	private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;

	public TurtleSceneTab(TurtleScene turtScene, ModelController controller) {
		setText("New Text");
		turtScene.getSelectionModel().select(this);
		myAllSlogoImages = new ArrayList<SlogoImage>();
		myTurtScene = turtScene;
		myModelController = controller;
		myCanvas = new Canvas(myCanvasWidth, myCanvasHeight);
		myShape = new StraightLine(turtScene, myModelController);

		setTurtleAndTrail(myTurtScene);
		setContent(myCanvas);

		turtScene.addTab(this);
		turtScene.getTabs().add(this);
	}

	public void setTurtleAndTrail(TurtleScene turtScene) {
		SlogoImage slogoImage = new SlogoImage(turtScene,myAllSlogoImages.size());
		myAllSlogoImages.add(slogoImage);
	}

	public void setTurtImage(ImageView image, int id) {
		int sceneId = myTurtScene.getIdOfTab();
		Turtle currTurt = (Turtle) myModelController.getMyScene().getTurtleData(sceneId).myTurtles().getTurtle(id);
		double currTurtLocX = currTurt.getTrail().getX();
		double currTurtLocY = currTurt.getTrail().getY();
		SlogoImage slogoImage = getSlogoImage(id);
		slogoImage.setX(currTurtLocX);
		slogoImage.setY(currTurtLocY);
		setSlogoImage(id, slogoImage);
	}

	public Object getRecentShape() {
		int ind = myShape.getAllShapes().size() - 1;
		return myShape.getAllShapes().get(ind);
	}

	public AbstractShape getShape() {
		return myShape;
	}

	public Canvas getCanvas() {
		return myCanvas;
	}

	public double getMyCanvasWidth() {
		return myCanvasWidth;
	}

	public double getMyCanvasHeight() {
		return myCanvasHeight;
	}

	public void setBackgroundColor(GraphicsContext gc, Canvas canvas, Color color) {
		gc.setFill(color);
		gc.fillRect(0, 0, canvas.getWidth(), canvas.getHeight());
	}

	public void setSlogoImage(int id, SlogoImage slogoImage) {
		myAllSlogoImages.set(id, slogoImage);
	}

	public SlogoImage getSlogoImage(int id) {
		return myAllSlogoImages.get(id);
	}

	public List<SlogoImage> getAllSlogoImages() {
		return myAllSlogoImages;
	}

	public TurtleScene getTurtScene() {
		return myTurtScene;
	}

}
