package view.scene;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import controller.ModelController;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import model.SlogoScene;
import model.data.ActiveTurtles;
import model.turtleinfo.SlogoObjects;
import view.settings.SlogoProperties;
import view.turtles.SlogoImage;


public class TurtleScene extends TabPane implements Observer {
    private List<TurtleSceneTab> myTabs = new ArrayList<TurtleSceneTab>();
    private ModelController myController;
    private ResourceBundle myResource;

    private double myCanvasWidth = SlogoProperties.getSceneWidth() * 3 / 7;
    private double myCanvasHeight = SlogoProperties.getSceneHeight() * 5 / 7;
    private boolean activeVis = true;

    public TurtleScene (ModelController controller, ResourceBundle resource) {
        myResource = resource;
        myController = controller;
        TurtleSceneTab newTab = new TurtleSceneTab(this, myController);

        // check
        List<SlogoImage> allSlogoImages = newTab.getAllSlogoImages();
        for (SlogoImage slogoImage : allSlogoImages) {
            ImageView image = slogoImage.getMyImage();
            image.setX(0);
            image.setY(0);
            setScreenLoc(image, image.getX(), image.getY());
            addChildren(image);
        }

        addListener();
    }

    public void setActiveVisibility(String chosen){
    	if(chosen.equals("Yes")){
    		activeVis = true;
    	}
    	else{
    		activeVis = false;
    	}
    }
    public void addTab (TurtleSceneTab tab) {
        myTabs.add(tab);
    }

    public void updateMyTabs (int id, TurtleSceneTab tab) {
        myTabs.set(id, tab);
    }

    public List<TurtleSceneTab> getMyTabs () {
        return myTabs;
    }

    public TurtleSceneTab getTabById (int id) {
        return myTabs.get(id);
    }

    public int getIdOfTab () {
        return getSelectionModel().getSelectedIndex();
    }

    public TurtleSceneTab getCurrTab () {
        int ind = getSelectionModel().getSelectedIndex();
        return myTabs.get(ind);
    }

    // maybe here
    public TurtleSceneTab createNewTab (ModelController newController) {
        TurtleSceneTab newTab = new TurtleSceneTab(this, newController);
        myTabs.add(newTab);

        return newTab;
    }

    public void addChildren (Node node) {
        getChildren().add(node);
    }

    // use
    public void removeChildren (Node node) {
        getChildren().remove(node);
    }

    public double getX () {
        return getTranslateX();
    }

    public double getY () {
        return getTranslateY();
    }

    public double getMyCanvasWidth () {
        return myCanvasWidth;
    }

    public double getMyCanvasHeight () {
        return myCanvasHeight;
    }

    public double getCanvasX () {
        return getCurrTab().getCanvas().getTranslateX();
    }

    public double getCanvasY () {
        return getCurrTab().getCanvas().getTranslateY();
    }

    /**
     * translates coordinates to a point on the canvas TurtleScene
     *
     * @param x
     * @param y
     */
    public void setScreenLoc (ImageView imageView, double x, double y) {
        TurtleSceneTab currTab = getCurrTab();
        int id = getIdOfTab();

        double newLocX =
                Math.floorMod((long) (x + getX() + currTab.getMyCanvasWidth() / 2),
                              (long) myCanvasWidth);
        double newLocY =
                Math.floorMod((long) (getY() + currTab.getMyCanvasHeight() / 2 - y),
                              (long) myCanvasHeight);
        if (checkBounds(newLocX, newLocY)) {
            imageView.setLayoutX(newLocX);
            imageView.setLayoutY(newLocY);
        }

        updateMyTabs(id, currTab);
    }

    private boolean checkBounds (double x, double y) {
        TurtleSceneTab currTab = getCurrTab();

        return (getX() + currTab.getMyCanvasWidth() > x  && x > getX()  &&
        		getY() + currTab.getMyCanvasHeight() > y && y > getY() );
    }

    public void setActiveTurtleID(int ID){
    	getTurtleFromActive().clear();
    	getTurtleFromActive().update(ID);
        for(int i = 0; i<getCurrTab().getAllSlogoImages().size();i++){
        	if((!getTurtleFromActive().getActives().contains(i)) && activeVis){
        		getCurrTab().getAllSlogoImages().get(i).makeInactive();
        	}
        	else{
        		getCurrTab().getAllSlogoImages().get(i).makeActive();
        	}
        }
    }

	private ActiveTurtles getTurtleFromActive() {
		return myController.getMyScene().getAllData().get(getIdOfTab()).getturtleData().prepareActiveTurtles();
	}

    public void addListener () {
        getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed (ObservableValue<? extends Number> ov,
                                 Number oldValue,
                                 Number newValue) {
                oldTab(oldValue);
                newTab(newValue);
            }

            private void newTab (Number newValue) {
                int tabId = (int) newValue;

                TurtleSceneTab newTab = myTabs.get(tabId);

                List<SlogoImage> newTurts = newTab.getAllSlogoImages();
                for(int j=0; j<newTurts.size(); j++) {
                	SlogoImage slogoImage = newTurts.get(j);
                    ImageView image = slogoImage.getMyImage();
                    newTab.getTurtScene().addChildren(image);
                    newTab.getTurtScene().setScreenLoc(image, image.getX(), image.getY());
                    newTab.setSlogoImage(j, slogoImage);
                }

                newTab.getTurtScene().updateMyTabs((int) newValue, newTab);
            }

            private void oldTab (Number oldValue) {
                int tabId = (int) oldValue;
                TurtleSceneTab oldTab = myTabs.get(tabId);

                List<Object> oldLines = oldTab.getShape().getAllShapes();
                for (Object line : oldLines) {
                    oldTab.getTurtScene().removeChildren((Node) line);
                }

                List<SlogoImage> oldTurts = oldTab.getAllSlogoImages();
                for (SlogoImage slogoImage : oldTurts) {
                    ImageView image = slogoImage.getMyImage();
                    oldTab.getTurtScene().removeChildren(image);
                }
            }
        });
    }

    @Override
    public void update (Observable o, Object arg) {
    	SlogoScene otherSlogoObj = (SlogoScene) o;

        int tabId = getIdOfTab();
        TurtleSceneTab tab = getCurrTab();
        // check if pen down or up
        // when pendown() changes
        for (Object i : tab.getShape().getAllShapes()) {
            Line temp = (Line) i;
            removeChildren(temp);
        }
        ArrayList<ArrayList<Line>> allLines = new ArrayList<ArrayList<Line>>();
        for(int i = 0; i<otherSlogoObj.getTurtleData(tabId).myTurtles().getAllTurtles().size();i++){
        SlogoObjects turt = otherSlogoObj.getTurtleData(tabId).myTurtles().getAllTurtles().get(i);
        ArrayList<Point2D> currTrailList =
                turt.getTrail().getPathCoordinates();
        ArrayList<Double> penStatusList =
                turt.getTrail().getPenPath();
        ArrayList<String> penColors =
                turt.getTrail().getColorPath();
        ArrayList<Integer> penThicks =
                turt.getTrail().getThicknessPath();
        ArrayList<Double> penDashes =
                turt.getTrail().getDashPath();
        ArrayList<Line> currLine =
                tab.getShape().drawShape(currTrailList, penStatusList, penColors, penThicks,
                                         penDashes);
        allLines.add(currLine);
        }
        for (ArrayList<Line> i : allLines) {
            for(Line j:i){
        	tab.getShape().addShape(j);
            addChildren(j);
            }
        }

        // when setRotationAngle() changes and setTrail() changes
        List<SlogoObjects> turts = otherSlogoObj.getTurtleData(tabId).myTurtles().getAllTurtles();
        for (int i = 0; i < turts.size(); i++) {
            SlogoObjects slogoObject = turts.get(i);
            double newRotAngle = slogoObject.getRotationAngle();
            double newLocX = slogoObject.getTrail().getX();
            double newLocY = slogoObject.getTrail().getY();


            SlogoImage currSlogoImage;
            try{
            	currSlogoImage = tab.getSlogoImage(i);
            }catch(Exception e){
            	currSlogoImage = new SlogoImage(this,tab.getAllSlogoImages().size());
            	tab.getAllSlogoImages().add(currSlogoImage);
            	this.addChildren(currSlogoImage.getMyImage());
            }
            currSlogoImage.setX(newLocX);
            currSlogoImage.setY(newLocY);
            currSlogoImage.setRotation(newRotAngle);
            setScreenLoc(currSlogoImage.getMyImage(), currSlogoImage.getX(),
                         currSlogoImage.getY());
            tab.setSlogoImage(i, currSlogoImage);
        }

        for(int i = 0; i<getCurrTab().getAllSlogoImages().size();i++){
        	if((!getTurtleFromActive().getActives().contains(i)) && activeVis){
        		getCurrTab().getAllSlogoImages().get(i).makeInactive();
        	}
        	else{
        		getCurrTab().getAllSlogoImages().get(i).makeActive();

        	}
        }

        // when setClear() changes
        if(otherSlogoObj.getTurtleData(tabId).myTurtles().getTurtle(0).getClearTrail() == true){
        	List<Object> currLines = tab.getShape().getAllShapes();
        	for (Object line : currLines) this.removeChildren((Node) line);
        	otherSlogoObj.getTurtleData(tabId).myTurtles().getTurtle(0).setClearTrail(false);
        }



        // when setScene() changes
        Color newColor = otherSlogoObj.ColorData(tabId).getMyColor();
        GraphicsContext gc = tab.getCanvas().getGraphicsContext2D();
        gc.setFill(newColor);
        gc.fillRect(0, 0, tab.getCanvas().getWidth(), tab.getCanvas().getHeight());

        updateMyTabs(tabId, tab);
    }
}
