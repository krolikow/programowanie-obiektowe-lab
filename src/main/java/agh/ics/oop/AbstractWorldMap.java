package agh.ics.oop;

import java.util.ArrayList;

public class AbstractWorldMap implements IWorldMap{
    protected Vector2d lowLeft;
    protected Vector2d uppRight;
    protected ArrayList<Animal> animals;

    @Override
    public boolean canMoveTo(Vector2d position) {
        if (position.precedes(new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE)) && position.follows(new Vector2d(0,0))){
            if(this.isOccupied(position)){
                return !(this.objectAt(position) instanceof Animal);
            }
            return true;
        }
        return false;
    }

    public boolean place(Animal animal){
        if(!isOccupied(animal.getPosition())){
            this.animals.add(animal);
            return true;
        }
        return false;
    }

    public boolean isOccupied(Vector2d position) {
        for (Animal animal : animals) {
            if (position.equals(animal.getPosition())) {
                return true;
            }
        }
        return false;
    }
    public Object objectAt(Vector2d position) {
        for(Animal animal:animals){
            if(animal.getPosition().equals(position)){
                return animal;
            }
        }
        return null;

    }
    public String toString(){
        return new MapVisualizer(this).draw(lowLeft,uppRight);
    }
}




