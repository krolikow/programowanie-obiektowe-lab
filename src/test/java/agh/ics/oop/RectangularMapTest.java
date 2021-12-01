package agh.ics.oop;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
public class RectangularMapTest {
    @Test
    public void integralTest1(){
        RectangularMap map = new RectangularMap(5, 10);
        System.out.println(map);
        String[] args = {"f", "b", "r", "l", "f", "f", "r", "r",
                "f", "f", "f", "f", "f", "f", "f", "f"};
        ArrayList<MoveDirection> directions = OptionsParser.parse(args);
        Vector2d[] positions1 = {new Vector2d(3, 4), new Vector2d(2, 5)};
        IEngine engine = new SimulationEngine(directions, map, positions1);
        engine.run();
        Vector2d[] expectedRes = { new Vector2d(4,1),new Vector2d(1,8)} ;
        assertEquals(expectedRes[0], map.animals.get(0).getPosition());
        assertEquals(expectedRes[1], map.animals.get(1).getPosition());
        }
    }
