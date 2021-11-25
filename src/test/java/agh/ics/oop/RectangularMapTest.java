package agh.ics.oop;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class RectangularMapTest {
    @Test
    public void integralTest1(){
        IWorldMap map = new RectangularMap(5, 10);
        System.out.println(map);
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r",
                "f", "f", "f", "f", "f", "f", "f", "f"};
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        Vector2d[] positions1 = {new Vector2d(3, 4), new Vector2d(2, 5)};
        IEngine engine = new SimulationEngine(directions, map, positions1);
        engine.run();
        ArrayList<Animal> aRes = ((RectangularMap) map).animals;
        Vector2d[] expectedRes = {new Vector2d(1,0), new Vector2d(2,5)} ;
        var i = 0;
        for(Animal a : aRes){
            assertEquals(expectedRes[i],a.getPosition());
            i+=1;
        }
    }

}