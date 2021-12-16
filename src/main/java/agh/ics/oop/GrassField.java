package agh.ics.oop;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;


import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap{
    private final MapBoundary mapBoundary = new MapBoundary(this);
    protected final Map<Vector2d, Grass> tufts = new LinkedHashMap<>();
    private final int grassTuftsNumber;


    public GrassField(int grassTuftsNumber) {
        this.grassTuftsNumber = grassTuftsNumber;
        this.topRight = new Vector2d(0, 0);
        this.bottomLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        sowGrass();
    }
    public Vector2d getUpperRight(){
        return mapBoundary.getUpperRight();
    }

    public Vector2d getLowerLeft(){
        return mapBoundary.getLowerLeft();
    }
    public void sowGrass(){
        int n = this.grassTuftsNumber;
        Random random = new Random();
        while (n!=0){
            int randomX = random.nextInt((int) sqrt(grassTuftsNumber*10));
            int randomY = random.nextInt((int) sqrt(grassTuftsNumber*10));
            Grass newGrass = new Grass(new Vector2d(randomX,randomY));

            if (!(objectAt(newGrass.getPosition()) instanceof Grass)){
                tufts.put(newGrass.getPosition(), newGrass);
                this.mapBoundary.addElement(newGrass);
                n-=1;
            }
        }
    }


    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        this.mapBoundary.addElement(animal);
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (this.isOccupied(position)) {
            return (objectAt(position) instanceof Grass);
        }
        return true;
    }

    @Override
    public void positionChanged(IMapElement map_object,Vector2d oldPosition, Vector2d newPosition) {
        super.positionChanged(map_object, oldPosition, newPosition);
        mapBoundary.positionChanged(map_object, oldPosition, newPosition);
    }

    @Override
    public String toString() {
        this.topRight = this.mapBoundary.getUpperRight();
        this.bottomLeft = this.mapBoundary.getLowerLeft();
        return super.toString();
    }
}
