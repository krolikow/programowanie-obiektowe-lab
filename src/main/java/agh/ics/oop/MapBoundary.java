package agh.ics.oop;

import java.util.SortedSet;
import java.util.TreeSet;


public class MapBoundary implements IPositionChangeObserver {

    private final SortedSet<Vector2d> setX = new TreeSet<>((object1, object2) -> object1.x == object2.x ? object1.y - object2.y : object1.x - object2.x);

    private final SortedSet<Vector2d> setY = new TreeSet<>((object1, object2) -> object1.y == object2.y ? object1.x - object2.x : object1.y - object2.y);

    // not sure if above works, in case not:

    // --------------------------------------------------

    private final SortedSet<Vector2d> setXVol1 = new TreeSet<>((object, anotherObject) -> {
        if (object.x > anotherObject.x) {
            return 1;
        } else if (object.x < anotherObject.x) {
            return -1;
        } else {
            if (object.y > anotherObject.y) {
                return 1;
            } else if (object.y < anotherObject.y) {
                return -1;
            }
        }

        return 0;
    });

    private final SortedSet<Vector2d> setYVol2 = new TreeSet<>((object, anotherObject) -> {
        if (object.y > anotherObject.y) {
            return 1;
        } else if (object.y < anotherObject.y) {
            return -1;
        } else {
            if (object.x > anotherObject.x) {
                return 1;
            } else if (object.x < anotherObject.x) {
                return -1;
            }
        }

        return 0;
    });

    // --------------------------------------------------

    public void addElement(Vector2d element) {
        this.setX.add(element);
        this.setY.add(element);
    }

    public void removeElement(Vector2d element) {
        this.setX.remove(element);
        this.setY.remove(element);
    }

    public Vector2d getLowerLeft() {
        return (this.setX.size() == 0 ? new Vector2d(0, 0) : new Vector2d(this.setX.first().x, this.setY.first().y));
    }

    public Vector2d getUpperRight() {
        return (this.setX.size() == 0 ? new Vector2d(0, 0) : new Vector2d(this.setX.last().x, this.setY.last().y));
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        removeElement(oldPosition);
        addElement(newPosition);
    }
}