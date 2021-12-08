package agh.ics.oop;

import java.util.ArrayList;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        try{
            out.println("Start");

            ArrayList<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
            AbstractWorldMap map = new GrassField(10);
            Vector2d[] positions = { new Vector2d(2,2), new Vector2d(3,4) };
            IEngine engine = new SimulationEngine(directions, map, positions);
            engine.run();

            out.println("Stop");
        }
        catch (IllegalArgumentException exception){
            out.println(exception.toString());
            out.println("Stop");
            System.exit(0);
        }
    }
}