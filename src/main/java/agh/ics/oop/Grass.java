package agh.ics.oop;

public class Grass extends AbstractWorldMapElement
{
    public Grass(Vector2d grassPosition){
        this.position = grassPosition;
    }

    public Vector2d getPosition(){
        return this.position;
    }

    @Override
    public String getFileName() {
        return "src/main/resources/grass.png";
    }

    @Override
    public String toString(){
        return "*";
    }
}