package agh.ics.oop;

import java.util.Random;


import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap implements IWorldMap{
    private final MapBoundary mapBoundary = new MapBoundary();
    private final int grassTuftsNumber;


    public GrassField(int grassTuftsNumber) {
        this.grassTuftsNumber = grassTuftsNumber;
//        this.topRight = new Vector2d(0, 0);
//        this.bottomLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
        sowGrass();
    }

    public void sowGrass(){
        int n = this.grassTuftsNumber;
        Random random = new Random();
        while (n!=0){
            int randomX = random.nextInt((int) sqrt(grassTuftsNumber*10));
            int randomY = random.nextInt((int) sqrt(grassTuftsNumber*10));
            Vector2d newGrassPosition = new Vector2d(randomX,randomY);

            if (!(objectAt(newGrassPosition) instanceof Grass)){
                mapElements.put(newGrassPosition, new Grass(newGrassPosition));
                this.mapBoundary.addElement(newGrassPosition);
                n-=1;
            }
        }
    }


    @Override
    public boolean place(Animal animal) {
        super.place(animal);
        this.mapBoundary.addElement(animal.getPosition());
        return true;
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        Object object = objectAt(position);
        if (object instanceof Grass) {
            mapElements.remove(((Grass) object).position, object);
            mapBoundary.removeElement(position);
            Vector2d potentialPosition = new Vector2d((int) (Math.random() * sqrt(grassTuftsNumber*10)),
                    (int) (Math.random() * sqrt(grassTuftsNumber*10)));
            Object temp = objectAt(potentialPosition);
            if (temp == null) {
                mapElements.put(potentialPosition, new Grass(potentialPosition));
                this.mapBoundary.addElement(potentialPosition);
            }
        }
        return super.canMoveTo(position);
    }

    @Override
    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
        AbstractWorldMapElement mapElement = mapElements.get(oldPosition);
        if (mapElement instanceof Animal) {
            mapElements.put(newPosition, mapElement);
            mapElements.remove(oldPosition);
            this.mapBoundary.positionChanged(oldPosition, newPosition);
        }
    }

    @Override
    public String toString() {
        this.topRight = this.mapBoundary.getUpperRight();
        this.bottomLeft = this.mapBoundary.getLowerLeft();
        return super.toString();
    }
}
