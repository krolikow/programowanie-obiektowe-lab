package agh.ics.oop;

import java.util.ArrayList;
import java.util.Random;
import static java.lang.Math.sqrt;

public class GrassField extends AbstractWorldMap {
    private final int grassTuftsNumber;
    private final ArrayList<Grass> tuftsPositions= new ArrayList<>();;

    public GrassField(int grassTuftsNumber) {
        this.grassTuftsNumber = grassTuftsNumber;
        this.uppRight = new Vector2d(0, 0);
        this.lowLeft = new Vector2d(Integer.MAX_VALUE, Integer.MAX_VALUE);
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
                Grass newGrass= new Grass(newGrassPosition);
                tuftsPositions.add(newGrass);
                actualizeSize(newGrass.getPosition());
                n-=1;
            }
        }
    }

    public void actualizeSize(Vector2d vector){
        uppRight = uppRight.upperRight(vector);
        lowLeft = lowLeft.lowerLeft(vector);
    }

    public ArrayList<Grass> getGrass(){
        return this.tuftsPositions;
    }

    @Override
    public boolean isOccupied(Vector2d position) {
        boolean bool = super.isOccupied(position);
        if (bool) return true;
        for (Grass grass : this.tuftsPositions) {
            if (position.equals(grass.getPosition())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position) {
        Object object = super.objectAt(position);
        if(object!=null) return object;

        for(Grass grass: tuftsPositions){
                if(grass.getPosition().equals(position)){
                    return grass;
                }
            }
        return null;
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(this.isOccupied(position)){
            return !(this.objectAt(position) instanceof Animal);
        }
        return true;
    }

    @Override
    public boolean place(Animal animal){
        boolean bool = super.place(animal);
        actualizeSize(animal.getPosition());
        return bool;
    }

    @Override
    public String toString(){
        return super.toString();
    }
}

