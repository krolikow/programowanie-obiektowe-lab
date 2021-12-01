package agh.ics.oop;

import java.util.HashMap;

public class AbstractWorldMap implements IWorldMap, IPositionChangeObserver{
    protected Vector2d lowLeft = new Vector2d(0,0);
    protected Vector2d uppRight = new Vector2d(0,0);
    final HashMap<Vector2d, Animal> animals = new HashMap<>();

    @Override
    public boolean canMoveTo(Vector2d position) {
        return isOccupied(position);
    }


    public boolean place(Animal animal){
        animal.addObserver(this);
        if(this.canMoveTo(animal.getPosition())) {
            this.animals.put(animal.getPosition(), animal);
            return true;
        }
        throw new IllegalArgumentException("Wrong animal's position - already occupied.");
    }
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return animals.containsKey(position);
    }

    public void actualizeSize(Vector2d vector){
        uppRight = uppRight.upperRight(vector);
        lowLeft = lowLeft.lowerLeft(vector);
    }

    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        Animal animal =  animals.get(oldPosition);
        animals.remove(oldPosition);
        place(animal);
    }

    @Override
    public String toString(){
        return new MapVisualizer(this).draw(lowLeft,uppRight);
    }
}
