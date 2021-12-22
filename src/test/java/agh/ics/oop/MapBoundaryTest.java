//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class MapBoundaryTest {
//
//    @Test
//    void addElementTest() {
//        AbstractWorldMap map = new RectangularMap(5, 10);
//        MapBoundary mapBoundary = new MapBoundary(map);
//
//        AbstractWorldMapElement thisAnimal = new Animal(map, new Vector2d(1, 2));
//        mapBoundary.addElement(thisAnimal);
//        assertEquals(1, mapBoundary.getSetXSize());
//        assertEquals(1, mapBoundary.getSetYSize());
//
//        AbstractWorldMapElement thatAnimal = new Animal(map, new Vector2d(2, 3));
//        mapBoundary.addElement(thatAnimal);
//        assertEquals(2, mapBoundary.getSetXSize());
//        assertEquals(2, mapBoundary.getSetYSize());
//    }
//
//    @Test
//    void removeElementTest() {
//        AbstractWorldMap map = new RectangularMap(5, 10);
//        MapBoundary mapBoundary = new MapBoundary(map);
//
//        AbstractWorldMapElement thisAnimal = new Animal(map, new Vector2d(1, 2));
//        mapBoundary.addElement(thisAnimal);
//        AbstractWorldMapElement thatAnimal = new Animal(map, new Vector2d(2, 3));
//        mapBoundary.addElement(thatAnimal);
//
//        mapBoundary.removeElement(thisAnimal);
//        assertEquals(1, mapBoundary.getSetXSize());
//        assertEquals(1, mapBoundary.getSetYSize());
//
//        mapBoundary.removeElement(thatAnimal);
//        assertEquals(0, mapBoundary.getSetXSize());
//        assertEquals(0, mapBoundary.getSetYSize());
//    }
//    @Test
//    void getLowerLeftTest() {
//        AbstractWorldMap map = new RectangularMap(5, 10);
//        MapBoundary mapBoundary = new MapBoundary(map);
//
//        mapBoundary.addElement(new Animal(map, new Vector2d(1, 2)));
//        mapBoundary.addElement(new Animal(map, new Vector2d(2, 3)));
//
//        assertEquals(new Vector2d(1, 2), mapBoundary.getLowerLeft());
//    }
//
//    @Test
//    void getUpperRightTest() {
//        AbstractWorldMap map = new RectangularMap(5, 10);
//        MapBoundary mapBoundary = new MapBoundary(map);
//
//        mapBoundary.addElement(new Animal(map, new Vector2d(1, 2)));
//        mapBoundary.addElement(new Animal(map, new Vector2d(2, 3)));
//
//        assertEquals(new Vector2d(2, 3), mapBoundary.getUpperRight());
//    }
//}
