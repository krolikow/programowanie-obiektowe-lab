//package agh.ics.oop;
//
//import java.util.ArrayList;
//
//class RectangularMap implements IWorldMap {
//
//    final int width,height;
//    final Vector2d lowerLeft = new Vector2d(0,0);
//    final Vector2d upperRight;
//    final ArrayList<Animal> animals = new ArrayList<>();
//    private final MapVisualizer visualizer = new MapVisualizer(this);
//
//    public RectangularMap(int width,int height){
//        this.width = width;
//        this.height = height;
//        this.upperRight = new Vector2d(this.width,this.height);
//    }
//
//    @Override
//    public String toString() {
//        return visualizer.draw(this.lowerLeft,this.upperRight);
//    }
//
//    @Override
//    public boolean canMoveTo(Vector2d vector){
//        return this.lowerLeft.precedes(vector) && this.upperRight.follows(vector) && !(isOccupied(vector));
//    }
//
//    @Override
//    public Object objectAt(Vector2d position) {
//        for(Animal animal : animals){
//            if(animal.getPosition().equals(position)){
//                return animal;
//            }
//        }
//        return null;
//    }
//
//    @Override
//    public boolean place(Animal animal) {
//        if (this.isOccupied(animal.getPosition())) return false;
//        this.animals.add(animal);
//        return true;
//    }
//
//    @Override
//    public boolean isOccupied(Vector2d position) {
//        return objectAt(position) != null;
//    }
//}


package agh.ics.oop;



class RectangularMap extends AbstractWorldMap {

    public RectangularMap(int width, int height){
        this.uppRight=new Vector2d(width-1,height-1);
    }

    @Override
    public boolean canMoveTo(Vector2d position){
        if(this.isOccupied(position)){
            return !(this.objectAt(position) instanceof Animal);
        }
        return true;
    }

//    @Override
//    public boolean canMoveTo(Vector2d position) {
//        if (position.x<= uppRight.x && position.x>=0 && !isOccupied(position)){
//            return position.y <= uppRight.y && position.y >= 0;
//        }
//        else {
//            return false;
//        }
//    }
}
