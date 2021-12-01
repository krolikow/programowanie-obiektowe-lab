package agh.ics.oop;
import java.lang.String;
import java.util.ArrayList;

class Animal {
    private MapDirection direction;
    private Vector2d position;
    private final IWorldMap map;
    private final ArrayList<IPositionChangeObserver> positionObservers=new ArrayList<>();

    Animal(IWorldMap map,Vector2d initialPosition){
        this.direction = MapDirection.NORTH;
        this.position = initialPosition;
        this.map =  map;
    }


    public MapDirection getDirection() {
        return direction;
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
                    this.position = newPosition;
                }
            }
            case BACKWARD -> {
                Vector2d newPosition = this.position.subtract(this.direction.toUnitVector());
                if (this.map.canMoveTo(newPosition)) {
                    this.position = newPosition;
                }
            }
        }
    }

    public void addObserver(IPositionChangeObserver observer){
        positionObservers.add(observer);
    }

    public void removeObserver(IPositionChangeObserver observer){
        positionObservers.remove(observer);
    }

    private void positionChanged(Vector2d oldPosition){
        for (IPositionChangeObserver positionObserver : positionObservers)
            positionObserver.positionChanged(oldPosition, position);
    }
}
