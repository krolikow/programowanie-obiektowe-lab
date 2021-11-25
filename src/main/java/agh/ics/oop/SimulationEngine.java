package agh.ics.oop;

import java.util.ArrayList;
import java.util.List;

class SimulationEngine implements IEngine{
    private final IWorldMap map;
    private final ArrayList<MoveDirection> moves;
    private final List<Animal> animals = new ArrayList<>();


    public SimulationEngine(ArrayList<MoveDirection> moves, IWorldMap map, Vector2d[] startPositions){
        this.moves=moves;
        this.map = map;
        initializeMap(startPositions);
    }


    private void initializeMap(Vector2d[] startPositions){
        for(Vector2d position : startPositions){
            Animal animal = new Animal(this.map,position);
            if (this.map.place(animal)){
                animals.add(animal);
            }
        }
    }


    public void run(){
        int len = this.moves.size();
        int i = 0;
        while (i < len) {
            for (Animal animal : animals) {
                animal.move(moves.get(i));
                System.out.println(moves.get(i));
                System.out.println(animal.getPosition());
                System.out.println(map);
                i++;
            }
        }
    }
}