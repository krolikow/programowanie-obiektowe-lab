//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.ArrayList;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//public class AnimalTest {
//
//    @Test
//    public void movementTest() {
//
//        Animal a = new Animal();
//
//        a.move(MoveDirection.FORWARD);
//        a.move(MoveDirection.LEFT);
//        a.move(MoveDirection.BACKWARD);
//        a.move(MoveDirection.BACKWARD);
//        a.move(MoveDirection.FORWARD);
//        a.move(MoveDirection.LEFT);
//        a.move(MoveDirection.FORWARD);
//        a.move(MoveDirection.FORWARD);
//        a.move(MoveDirection.RIGHT);
//
//        assertTrue(a.isAt(new Vector2d(3, 1)));
//        assertEquals(MapDirection.WEST, a.getDir());
//
//        Animal b = new Animal();
//
//        b.move(MoveDirection.BACKWARD);
//        b.move(MoveDirection.BACKWARD);
//        b.move(MoveDirection.BACKWARD);
//        assertFalse(b.isAt(new Vector2d(2, -1)));
//        assertTrue(b.isAt(new Vector2d(2, 0)));
//        assertEquals(MapDirection.NORTH, b.getDir());
//        b.move(MoveDirection.LEFT);
//        b.move(MoveDirection.FORWARD);
//        b.move(MoveDirection.FORWARD);
//        b.move(MoveDirection.FORWARD);
//        assertFalse(b.isAt(new Vector2d(-1, 0)));
//        assertTrue(b.isAt(new Vector2d(0, 0)));
//        assertEquals(MapDirection.WEST, b.getDir());
//    }
//
//    @Test
//    public void parserTest() {
//        String[] args = {"forward", "f", "backward", "b", "left", "l", "right", "r", "llama"};
//        ArrayList<MoveDirection> parsed = OptionsParser.parse(args);
//        ArrayList<MoveDirection> moves = new ArrayList<>();
//        moves.add(MoveDirection.FORWARD);
//        moves.add(MoveDirection.FORWARD);
//        moves.add(MoveDirection.BACKWARD);
//        moves.add(MoveDirection.BACKWARD);
//        moves.add(MoveDirection.LEFT);
//        moves.add(MoveDirection.LEFT);
//        moves.add(MoveDirection.RIGHT);
//        moves.add(MoveDirection.RIGHT);
//        assertEquals(moves, parsed);
//    }
//}