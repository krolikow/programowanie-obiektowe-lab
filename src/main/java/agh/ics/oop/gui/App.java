package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.List;

public class App extends Application implements IPositionChangeObserver{
    private IWorldMap map;
    private Thread engineThread;
    private ArrayList<MoveDirection> directions;
    GridPane grid = new GridPane();
    private SimulationEngine engine;
    GuiElementBox elementCreator = new GuiElementBox();



    @Override
    public void init() {
        List<String> args = getParameters().getRaw();
        this.directions = OptionsParser.parse(args.toArray(new String[0]));
        this.map = new GrassField(5);
        Vector2d[] positions = {new Vector2d(2, 2), new Vector2d(3, 4)};
        this.engine = new SimulationEngine( directions,map, positions,this);
        this.engineThread = new Thread(engine::run);
    }


public void createGrid() {
    grid.setGridLinesVisible(true);

    Vector2d lowLeftBound = this.map.getLowerLeft();
    Vector2d upRightBound = this.map.getUpperRight();
    int height = upRightBound.y - lowLeftBound.y;
    int width = upRightBound.x - lowLeftBound.x;


    for (int i = 1; i <= width + 1; i++) {
        grid.getColumnConstraints().add(new ColumnConstraints(70));

        Label xAxis = new Label(String.format("%d", lowLeftBound.x + i - 1));
        GridPane.setHalignment(xAxis, HPos.CENTER);
        grid.add(xAxis, i, 0, 1, 1);
    }

    for (int i = 1; i <= height + 1; i++) {
        grid.getRowConstraints().add(new RowConstraints(70));

        Label yAxis = new Label(String.format("%d", upRightBound.y - i + 1));
        GridPane.setHalignment(yAxis, HPos.CENTER);
        grid.add(yAxis, 0, i, 1, 1);
    }

    for (int i = 1; i <= height + 1; i++) {
        for (int j = 1; j <= width + 1; j++) {
            Vector2d currentPosition = new Vector2d(lowLeftBound.x + j - 1, upRightBound.y - i + 1);
            if (map.isOccupied(currentPosition)) {
                VBox element = elementCreator.setImages((IMapElement) map.objectAt(currentPosition));
                GridPane.setHalignment(element, HPos.CENTER);
                grid.add(element, j, i, 1, 1);
            }
        }
    }

    Label label = new Label("y\\x");
    grid.add(label, 0, 0, 1, 1);
    grid.getColumnConstraints().add(new ColumnConstraints(70));
    grid.getRowConstraints().add(new RowConstraints(70));
    GridPane.setHalignment(label, HPos.CENTER);
}

    public VBox createInterfaceVBox() {
        TextField text = new TextField();
        Button btn = new Button("Start");
        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(text, btn);
        vbox.setAlignment(Pos.CENTER);

        btn.setOnAction(e -> {
            String[] txt = text.getText().split(" ");
            ArrayList<MoveDirection> newDirections = new OptionsParser().parse(txt);
            engine.getDirections(newDirections);
            Thread newEngineThread = new Thread(engine::run);
            newEngineThread.start();
        });
        return vbox;
    }
    public void positionChanged(IMapElement map_object, Vector2d oldPosition, Vector2d newPosition) {
        grid.setGridLinesVisible(false);
        grid.getColumnConstraints().clear();
        grid.getRowConstraints().clear();
        grid.getChildren().clear();
        grid.setGridLinesVisible(true);
        createGrid();
    }

    public void start(Stage primaryStage) {
        this.grid.setGridLinesVisible(true);
        createGrid();
        HBox hbox = new HBox(15);
        hbox.getChildren().add(grid);
        VBox vboxInterface = createInterfaceVBox();
        hbox.getChildren().add(vboxInterface);

        hbox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(hbox);
        primaryStage.setScene(scene);
        primaryStage.show();
        engineThread.start();
    }
}
