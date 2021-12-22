package agh.ics.oop;


class RectangularMap extends AbstractWorldMap implements IWorldMap {

    public RectangularMap(int width, int height){

        this.upperRight =new Vector2d(width-1,height-1);
        this.lowerLeft = new Vector2d(0, 0);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(position.precedes(this.upperRight) && position.follows(this.lowerLeft)){
            if(this.isOccupied(position)){
                return !(this.objectAt(position) instanceof Animal);}
            else{
                return true;
            }
        }
        return false;
    }


    @Override
    public void positionChanged() {
    }
}
//    @Override
//    public void positionChanged(Vector2d oldPosition, Vector2d newPosition) {
//        super.positionChanged(oldPosition, newPosition);
//    }
