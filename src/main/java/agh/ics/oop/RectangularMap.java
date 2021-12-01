package agh.ics.oop;



class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height){
        this.uppRight=new Vector2d(width,height);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(this.isOccupied(position)){
            return !(this.objectAt(position) instanceof Animal);
        }
        return true;
    }}
