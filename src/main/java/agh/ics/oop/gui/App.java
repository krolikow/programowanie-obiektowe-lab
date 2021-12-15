package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class App extends Application {
    private AbstractWorldMap map;

    @Override
    public void init() {
        List<String> args = getParameters().getRaw();
        ArrayList<MoveDirection> directions = OptionsParser.parse(args.toArray(new String[0]));
        this.map = new GrassField(5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        IEngine engine = new SimulationEngine(directions, map, positions);
        engine.run();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();
        grid.setGridLinesVisible(true);
        GuiElementBox elementCreator = new GuiElementBox();

        Vector2d lowLeftBound = this.map.getLowerLeft();
        Vector2d upRightBound = this.map.getUpperRight();
        int height = upRightBound.y - lowLeftBound.y;
        int width = upRightBound.x - lowLeftBound.x;


        for (int i = 1; i <= width+1; i++) {
            grid.getColumnConstraints().add(new ColumnConstraints(70));

            Label xAxis = new Label( String.format("%d", lowLeftBound.x+i-1));
            GridPane.setHalignment(xAxis, HPos.CENTER);
            grid.add(xAxis, i, 0, 1, 1);
        }

        for (int i = 1; i <= height + 1; i++) {
            grid.getRowConstraints().add(new RowConstraints(70));

            Label yAxis = new Label(String.format("%d", upRightBound.y - i + 1));
            GridPane.setHalignment(yAxis, HPos.CENTER);
            grid.add(yAxis, 0, i, 1, 1);
        }

        for (int i=1; i<= height+1; i++) {
            for (int j=1; j<= width+1; j++) {
                Vector2d currentPosition = new Vector2d(lowLeftBound.x+j-1, upRightBound.y-i+1);
                if (map.isOccupied(currentPosition)) {
                    VBox element = elementCreator.setImages((IMapElement) map.objectAt(currentPosition));
                    GridPane.setHalignment(element, HPos.CENTER);
                    grid.add(element, j, i,1,1);
                }
            }
        }

        Label label = new Label("y\\x");
        grid.add(label, 0, 0, 1, 1);
        grid.getColumnConstraints().add(new ColumnConstraints(70));
        grid.getRowConstraints().add(new RowConstraints(70));
        GridPane.setHalignment(label, HPos.CENTER);

        Scene scene = new Scene(grid, 600, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


}