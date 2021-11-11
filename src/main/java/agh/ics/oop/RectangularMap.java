package agh.ics.oop;

import java.util.ArrayList;

class RectangularMap implements IWorldMap {

    final int width,height;
    final Vector2d lowerLeft = new Vector2d(0,0);
    final Vector2d upperRight;
    final ArrayList<Animal> animals = new ArrayList<>();

    public RectangularMap(int width,int height){
        this.width = width;
        this.height = height;
        this.upperRight = new Vector2d(this.width,this.height);
    }


    @Override
    public String toString() {
        return new MapVisualizer(this).draw(this.lowerLeft,this.upperRight);
    }

    @Override
    public boolean canMoveTo(Vector2d vector){
        return this.lowerLeft.precedes(vector) && this.upperRight.follows(vector) && !(isOccupied(vector));
    }

    @Override
    public Object objectAt(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPos().equals(position)){
                return animal;
            }
        }
        return null;
    }

    @Override
    public boolean place(Animal animal) {
        if (this.isOccupied(animal.getPos())) return false;
        this.animals.add(animal);
        return true;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        for(Animal animal : animals){
            if(animal.getPos().equals(position)){
                return true;
            }
        }
        return false;
    }

}
