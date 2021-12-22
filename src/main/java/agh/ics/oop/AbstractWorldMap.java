package agh.ics.oop;


import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractWorldMap implements IWorldMap, IPositionChangeObserver {
    protected Map<Vector2d, AbstractWorldMapElement> mapElements = new LinkedHashMap<>();
//    private final MapBoundary mapBoundary = new MapBoundary(this);
    protected Vector2d lowerLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
    protected Vector2d upperRight = new Vector2d(Integer.MIN_VALUE, Integer.MIN_VALUE);
    protected MapVisualizer visualizer = new MapVisualizer(this);

    public Vector2d getUpperRight(){
        return upperRight;
    }

    public Vector2d getLowerLeft(){
        return lowerLeft;
    }

    @Override
    public AbstractWorldMapElement objectAt(Vector2d position) {
        return mapElements.get(position);
    }

    public boolean isOccupied(Vector2d position) {
        AbstractWorldMapElement element = mapElements.get(position);
        return element != null;
    }

    public boolean place(Animal animal) throws IllegalArgumentException {
        Vector2d position = animal.getPosition();

        if (canMoveTo(position)) {
            this.mapElements.put(position, animal);
            return true;
        } else {
            throw new IllegalArgumentException("Wrong animal's position: " + position + " is already occupied.");
        }
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }

    @Override
    public String toString() {
        return this.visualizer.draw(this.lowerLeft, this.upperRight);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement element = this.mapElements.get(oldPosition);
        this.mapElements.remove(oldPosition);
        this.mapElements.put(newPosition, element);
    }

}