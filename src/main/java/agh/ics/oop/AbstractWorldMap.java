package agh.ics.oop;


import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected final Map<Vector2d, Animal> animals = new LinkedHashMap<>();
    private final MapBoundary mapBoundary = new MapBoundary(this);
    protected Vector2d bottomLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d topRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected MapVisualizer visualizer = new MapVisualizer(this);

    public Vector2d getUpperRight(){
        return mapBoundary.getUpperRight();
    }

    public Map<Vector2d, Animal> getAnimals() {
        return this.animals;
    }

    public Vector2d getLowerLeft(){
        return mapBoundary.getLowerLeft();
    }

    @Override
    public Object objectAt(Vector2d position) {
        return animals.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        return animals.get(position) != null;
    }

//    public boolean place(Animal animal) throws IllegalArgumentException {
//        Vector2d position = animal.getPosition();
//
//        if (canMoveTo(position)) {
//            this.animals.put(position, animal);
//            return true;
//        } else {
//            throw new IllegalArgumentException("Wrong animal's position: " + position + " is already occupied.");
//        }
//    }


    @Override
    public boolean place(Animal animal) {
        if (!this.canMoveTo(animal.getPosition())) throw new IllegalArgumentException("It is not legal to place animal on " + animal.getPosition());
        this.animals.put(animal.getPosition(), animal);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) { // ok
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public String toString() {
        return this.visualizer.draw(this.bottomLeft, this.topRight);
    }

//    @Override
//    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
//        Animal animal = this.animals.get(oldPosition);
//        this.animals.remove(oldPosition);
//        this.animals.put(newPosition, animal );
//    }

    @Override
    public void positionChanged(IMapElement map_object, Vector2d oldPosition, Vector2d newPosition) {
        this.animals.remove(oldPosition);
        this.animals.put(newPosition, (Animal) map_object);
    }

}