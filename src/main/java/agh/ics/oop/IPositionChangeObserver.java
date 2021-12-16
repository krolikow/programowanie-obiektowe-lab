package agh.ics.oop;

public interface IPositionChangeObserver {
//    void positionChanged(Vector2d oldPosition, Vector2d newPosition);

    void positionChanged(IMapElement map_object, Vector2d oldPosition, Vector2d newPosition);
}

