package agh.ics.oop;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class SimulationEngineTest {

    @Test
    public void movementTest(){
        ArrayList<MoveDirection> moves = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
        RectangularMap map = new RectangularMap(10, 5);
        Vector2d[] startPos = { new Vector2d(2,2), new Vector2d(3,4) };
        IEngine engine = new SimulationEngine(moves,map,startPos);
        engine.run();

        ArrayList<Animal> res = map.animals;
        Vector2d[] expectedRes = new Vector2d[]{new Vector2d(2,0), new Vector2d(3,5)} ;
        var i = 0;
        for(Animal animal : res){
            assertEquals(expectedRes[i],animal.getPos());
            i+=1;
        }
    }
}
