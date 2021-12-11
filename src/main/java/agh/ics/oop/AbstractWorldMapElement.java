package agh.ics.oop;

public abstract class AbstractWorldMapElement extends AbstractWorldMap implements IMapElement {
    protected Vector2d position;

    public Vector2d getPosition() {
        return position;
    }
}
