package agh.ics.oop;
import java.lang.String;
import java.util.ArrayList;

public class Animal implements IMapElement{
    private MapDirection direction;
    private Vector2d position;
    private final IWorldMap map;
    private final ArrayList<IPositionChangeObserver> observers = new ArrayList<>();

    public Animal(IWorldMap map,Vector2d initialPosition){
        this.position = initialPosition;
        this.direction = MapDirection.NORTH;
        this.map =  map;
    }

    public Animal(IWorldMap map) {

        this.map = map;
    }

    public MapDirection getDirection() {
        return this.direction;
    }

    public Vector2d getPosition() {
        return position;
    }


    @Override
    public String toString(){
        return switch (direction){
            case NORTH -> "^";
            case EAST -> ">";
            case WEST -> "<";
            case SOUTH -> "v";
        };
    }

    boolean isAt(Vector2d position) {
        return this.position.equals(position);
    }


    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> this.direction = this.direction.next();
            case LEFT -> this.direction = this.direction.previous();
            case FORWARD -> {
                Vector2d newPosition = this.position.add(this.direction.toUnitVector());
                if (this.map.canMoveTo(newPosition)){
                    positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    positionChanged(this.position, newPosition);
                    this.position = newPosition;
                }
            }
        }
    }
    
    public void addObserver(IPositionChangeObserver observer){
        observers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        observers.remove(observer);
    }

    void positionChanged(Vector2d oldPosition, Vector2d newPosition){
        for (IPositionChangeObserver observer : this.observers)
            observer.positionChanged(this,oldPosition, newPosition);
    }

    @Override
    public String getFileName() {
        return switch (this.direction) {
            case NORTH -> "up.png";
            case EAST -> "right.png";
            case SOUTH -> "down.png";
            case WEST -> "left.png";
        };
    }
}
