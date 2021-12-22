package agh.ics.oop.gui;

import agh.ics.oop.AbstractWorldMapElement;
import agh.ics.oop.Animal;
import agh.ics.oop.IMapElement;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;

public class GuiElementBox {
    Image imageUp, imageDown, imageRight, imageLeft, imageGrass;
    ArrayList<Image> images = new ArrayList<>(Arrays.asList(imageUp, imageDown, imageRight, imageLeft, imageGrass));

    private void loadImages() {
        try {
            this.imageUp = new Image(new FileInputStream("src/main/resources/up.png"));
            this.imageDown = new Image(new FileInputStream("src/main/resources/down.png"));
            this.imageRight = new Image(new FileInputStream("src/main/resources/right.png"));
            this.imageLeft = new Image(new FileInputStream("src/main/resources/left.png"));
            this.imageGrass = new Image(new FileInputStream("src/main/resources/grass.png"));
        } catch (FileNotFoundException ex) {
            System.out.println("File doesn't exist.");
        }
    }

    public GuiElementBox(){
        loadImages();
    }

    public VBox setImages(IMapElement element) {

        Label elementLabel;
        ImageView elementView;

        if (element instanceof Animal) {
            elementLabel = new Label("Zwierz " + element.getPosition());
            elementView = switch (((Animal)element).getDirection()) {
                case NORTH -> new ImageView(imageUp);
                case EAST -> new ImageView(imageRight);
                case WEST -> new ImageView(imageLeft);
                case SOUTH -> new ImageView(imageDown);
            };
        } else {
            elementLabel = new Label("Trawka");
            elementView = new ImageView(imageGrass);
        }
        elementView.setFitWidth(40);
        elementView.setFitHeight(40);
        VBox elementVBox = new VBox();
        elementVBox.getChildren().addAll(elementView, elementLabel);
        elementVBox.setAlignment(Pos.CENTER);

        return elementVBox;

    }
}

