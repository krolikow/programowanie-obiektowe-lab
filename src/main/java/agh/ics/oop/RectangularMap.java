package agh.ics.oop;


class RectangularMap extends AbstractWorldMap implements IWorldMap {

    public RectangularMap(int width, int height){

        this.topRight =new Vector2d(width-1,height-1);
        this.bottomLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(position.precedes(this.topRight) && position.follows(this.bottomLeft)){
            if(this.isOccupied(position)){
                return !(this.objectAt(position) instanceof Animal);}
            else{
                return true;
                }
        }
        return false;
    }
}
//    @Override
//    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
//        super.positionChanged(oldPosition, newPosition);
//    }
