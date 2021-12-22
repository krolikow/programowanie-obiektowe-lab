package agh.ics.oop;

import agh.ics.oop.gui.App;
import javafx.application.Application;
import javafx.application.Platform;

import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;

public class SimulationEngine implements IEngine,Runnable {
    protected ArrayList<MoveDirection> directions;
    private final AbstractWorldMap map;
    private final List<Animal> animals = new ArrayList<>();
    private final List<IPositionChangeObserver> observers = new ArrayList<>();
    int moveDelay;


    public SimulationEngine(ArrayList<MoveDirection> directions, AbstractWorldMap map, Vector2d[] initialPositions, int moveDelay){
        this.directions = directions;
        this.map = map;
        this.moveDelay = moveDelay;
        initializeMap(initialPositions);
    }
    public SimulationEngine(AbstractWorldMap map, Vector2d[] initialPositions){
        this.map = map;
        initializeMap(initialPositions);
    }


    public SimulationEngine(AbstractWorldMap map, Vector2d[] initialPositions, int moveDelay) {
        this.map = map;
        this.moveDelay = moveDelay;
        initializeMap(initialPositions);
    }


    private void initializeMap(Vector2d[] initialPositions){
        for (Vector2d position : initialPositions){
            Animal animal = new Animal(this.map, position);
            if (this.map.place(animal)) {
                this.animals.add(animal);
                animal.addObserver(this.map);
            }

        }
    }


    public void run(){
        out.println(this.map);
        for (IPositionChangeObserver animalMoveObserver : this.observers)
           animalMoveObserver.positionChanged();
        try{
            Thread.sleep(300);
        }
        catch (InterruptedException ex){
            System.out.println("Error has occured: " + ex);
        }
        int animalsAmount = this.animals.size();
        int len = this.directions.size();
        for (int i = 0; i < len; i++) {
            this.animals.get(i % animalsAmount).move(this.directions.get(i));
            for (IPositionChangeObserver animalMoveObserver : this.observers)
                animalMoveObserver.positionChanged();
            try {
                int moveDelay = 300;
                Thread.sleep(moveDelay);
                System.out.println(this.map);
            } catch (InterruptedException e) {
                System.out.println("Simulation stopped");
            }
        }
    }
    public void addObserver(IPositionChangeObserver observer) {
        this.observers.add(observer);
    }
}






