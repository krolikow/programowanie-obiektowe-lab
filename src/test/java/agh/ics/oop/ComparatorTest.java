package agh.ics.oop;

import javafx.util.Pair;
import org.junit.jupiter.api.Test;

//import java.util.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class ComparatorTest {
//
//    @Test
//    void comparatorXTest1() {
//        AbstractWorldMap map1 = new RectangularMap(5, 10);
//        MapBoundary mapBoundary1 = new MapBoundary(map1);
//
//        AbstractWorldMapElement firstAnimal = new Animal(map1, new Vector2d(1, 2));
//        AbstractWorldMapElement secondAnimal = new Animal(map1, new Vector2d(3, 4));
//        AbstractWorldMapElement thirdAnimal = new Animal(map1, new Vector2d(2, 6));
//
//        mapBoundary1.addElement(firstAnimal);
//        mapBoundary1.addElement(secondAnimal);
//        mapBoundary1.addElement(thirdAnimal);
//
//        ArrayList<Pair<Vector2d, Class>> expected1 = new ArrayList<>(Arrays.asList(new Pair<>(firstAnimal.getPosition(), firstAnimal.getClass()), new Pair<>(thirdAnimal.getPosition(), thirdAnimal.getClass()), new Pair<>(secondAnimal.getPosition(), secondAnimal.getClass())));
//        ArrayList<Pair<Vector2d, Class>> result1 = new ArrayList<>(mapBoundary1.getSetX());
//
//        assertEquals(expected1, result1);}
//
//    @Test
//    void comparatorXTest2() {
//        AbstractWorldMap map2 = new RectangularMap(5, 10);
//        MapBoundary mapBoundary2 = new MapBoundary(map2);
//
//        AbstractWorldMapElement fourthAnimal = new Animal(map2, new Vector2d(0, 2));
//        AbstractWorldMapElement sixthAnimal = new Grass(new Vector2d(1, 3));
//        AbstractWorldMapElement fifthAnimal = new Animal(map2, new Vector2d(1, 3));
//
//        mapBoundary2.addElement(fourthAnimal);
//        mapBoundary2.addElement(fifthAnimal);
//        mapBoundary2.addElement(sixthAnimal);
//
//        ArrayList<Pair<Vector2d, Class>> expected2 = new ArrayList<>(Arrays.asList(new Pair<>(fourthAnimal.getPosition(), fourthAnimal.getClass()), new Pair<>(sixthAnimal.getPosition(), sixthAnimal.getClass()), new Pair<>(fifthAnimal.getPosition(), fifthAnimal.getClass())));
//        ArrayList<Pair<Vector2d, Class>> result2 = new ArrayList<>(mapBoundary2.getSetX());
//
//        assertEquals(expected2, result2);
//    }
//    // comparatorY works exactly the same (with obvious differences), so assumed there's no need to test it
//}