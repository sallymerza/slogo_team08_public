package view.props;

import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Callback;


public class ColorComboBox extends ComboBox<Color> {

    public ColorComboBox () {
        super();
        getItems().addAll(Color.ALICEBLUE, Color.PURPLE, Color.CADETBLUE, Color.AQUAMARINE,
                          Color.AZURE,
                          Color.GREEN, Color.DARKGREEN, Color.CHARTREUSE, Color.CORAL,
                          Color.RED, Color.YELLOW,
                          Color.DARKGOLDENROD, Color.DEEPPINK, Color.HOTPINK, Color.BROWN,
                          Color.ROSYBROWN, Color.ORANGE,
                          Color.ORCHID, Color.DARKORCHID, Color.BLACK, Color.BLANCHEDALMOND,
                          Color.ANTIQUEWHITE, Color.GREY);

        setCellFactory(new Callback<ListView<Color>, ListCell<Color>>() {
            @Override
            public ListCell<Color> call (ListView<Color> p) {
                return new ListCell<Color>() {
                    private final Rectangle rectangle;

                    {
                        setContentDisplay(ContentDisplay.GRAPHIC_ONLY);
                        rectangle = new Rectangle(10, 10);
                    }

                    @Override
                    protected void updateItem (Color item, boolean empty) {
                        super.updateItem(item, empty);

                        if (item == null || empty) {
                            setGraphic(null);
                        }
                        else {
                            rectangle.setFill(item);
                            setGraphic(rectangle);
                        }
                    }
                };
            }
        });
    }
}
