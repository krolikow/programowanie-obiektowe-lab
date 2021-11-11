package agh.ics.oop;

import java.util.ArrayList;

class SimulationEngine implements IEngine{
    private final RectangularMap map;
    private final ArrayList<MoveDirection> moves;

    public SimulationEngine(ArrayList<MoveDirection> moves, IWorldMap map, Vector2d[] startPos){
        this.map= (RectangularMap) map;
        this.moves=moves;
        for(Vector2d elem : startPos){
            Animal animal = new Animal(this.map,elem);
            this.map.place(animal);
        }
    }

    public void run(){
        int len = this.moves.size();
        int i = 0;
        while (i < len) {
            for (Animal animal : map.animals) {
                animal.move(moves.get(i));
//                System.out.println(moves.get(i));
//                System.out.println(animal.getPos());
//                System.out.println(map);
                i++;
            }
        }
    }
}