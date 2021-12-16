//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.*;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class SimulationEngineTest {
//
//    @Test
//    public void movementTest(){
//        ArrayList<MoveDirection> directions = OptionsParser.parse(new String[]{"f", "b", "r", "l", "f", "f", "r", "r", "f", "f", "f", "f", "f", "f", "f", "f"});
//        AbstractWorldMap map = new RectangularMap(10,5);
//        Vector2d[] startPositions = { new Vector2d(2,2), new Vector2d(3,4) };
////        IEngine engine = new SimulationEngine(directions,map,startPositions);
////        engine.run();
//
////        Map<Vector2d, AbstractWorldMapElement> res = map.mapElements;
//        Vector2d[] expectedRes = new Vector2d[]{new Vector2d(3,4),new Vector2d(2,0) } ;
//        List<Vector2d> finalPositions = new ArrayList<>();
//        for(Map.Entry<Vector2d, AbstractWorldMapElement> element : res.entrySet()) {
//            finalPositions.add(element.getKey());
//        }
//
//        for (int i=0;i<2; i++)
//        {
//            assertEquals(expectedRes[i], finalPositions.get(i));
//        }
//   }
//}
