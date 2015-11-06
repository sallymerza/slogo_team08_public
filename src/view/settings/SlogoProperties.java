package view.settings;

import java.util.ArrayList;
import java.util.Arrays;

import javafx.scene.paint.Color;
import javafx.stage.Screen;


public class SlogoProperties {
    private static final double SCENE_WIDTH = Screen.getPrimary().getVisualBounds().getWidth();
    private static final double SCENE_HEIGHT = Screen.getPrimary().getVisualBounds().getHeight();
    private static String[] myStartColors = {Color.ALICEBLUE.toString(), Color.PURPLE.toString(), Color.CADETBLUE.toString(), Color.AQUAMARINE.toString(),
            Color.AZURE.toString(),
            Color.GREEN.toString(), Color.DARKGREEN.toString(), Color.CHARTREUSE.toString(), Color.CORAL.toString(),
            Color.RED.toString(), Color.YELLOW.toString(),
            Color.DARKGOLDENROD.toString(), Color.DEEPPINK.toString(), Color.HOTPINK.toString(), Color.BROWN.toString(),
            Color.ROSYBROWN.toString(), Color.ORANGE.toString(),
            Color.ORCHID.toString(), Color.DARKORCHID.toString(), Color.BLACK.toString(), Color.BLANCHEDALMOND.toString(),
            Color.ANTIQUEWHITE.toString(), Color.GREY.toString()};
	private static ArrayList<String> myColors = new ArrayList<String>(Arrays.asList(myStartColors));
    
	public static double getSceneWidth () {
        return SCENE_WIDTH;
    }

    public static double getSceneHeight () {
        return SCENE_HEIGHT;
    }
    
    public static ArrayList<String> getColorArray(){
    	return myColors;
    }
    
    public static void addColor(int index, String color){
    	myColors.add(index, color);
    }
}
