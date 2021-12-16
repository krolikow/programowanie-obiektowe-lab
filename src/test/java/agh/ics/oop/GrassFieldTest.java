//package agh.ics.oop;
//import org.junit.jupiter.api.Test;
//import static org.junit.jupiter.api.Assertions.*;
//
//public class GrassFieldTest {
//    @Test
//    public void canMoveToTest(){
//        GrassField field = new GrassField(5);
//        System.out.println(field);
//        Animal animal = new Animal(field, new Vector2d(3, 3));
//        assertTrue(field.canMoveTo(animal.getPosition()));
//        field.place(animal);
//        assertFalse(field.canMoveTo(animal.getPosition()));
//        assertTrue(field.canMoveTo(new Vector2d(100, 100)));
//        assertTrue(field.canMoveTo(new Vector2d(-10, -10)));
//    }
//
//    @Test
//    public void placeTest() {
//        GrassField map = new GrassField(10);
//        assertTrue(map.place(new Animal(map, new Vector2d(0, 0))));
//        assertTrue(map.place(new Animal(map, new Vector2d(7, 7))));
//        Animal illegalAnimal = new Animal(map,new Vector2d(7,7));
//
//        Exception exception = assertThrows(IllegalArgumentException.class, () -> map.place(illegalAnimal));
//        assertEquals("Wrong animal's position: (7,7) is already occupied.", exception.getMessage());
//
//        assertTrue(map.place(new Animal(map, new Vector2d(-1, -3))));
//        assertTrue(map.place(new Animal(map, new Vector2d(-4, 4))));
//        assertTrue(map.place(new Animal(map, new Vector2d(-1, 8))));
//        assertTrue(map.place(new Animal(map, new Vector2d(5, 9))));
//    }
//}
