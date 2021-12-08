package agh.ics.oop;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class AnimalTest {
//    AbstractWorldMap map = new RectangularMap(10,5);
//    Animal a = new Animal(map, new Vector2d(1,2));
//    Animal b = new Animal(map, new Vector2d(3,4));

//    @Test
//    public void movementTest() {
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
//        assertEquals(MapDirection.WEST, a.getDirection());
//
//        b.move(MoveDirection.BACKWARD);
//        b.move(MoveDirection.BACKWARD);
//        b.move(MoveDirection.BACKWARD);
//        assertFalse(b.isAt(new Vector2d(2, -1)));
//        assertTrue(b.isAt(new Vector2d(2, 0)));
//        assertEquals(MapDirection.NORTH, b.getDirection());
//        b.move(MoveDirection.LEFT);
//        b.move(MoveDirection.FORWARD);
//        b.move(MoveDirection.FORWARD);
//        b.move(MoveDirection.FORWARD);
//        assertFalse(b.isAt(new Vector2d(-1, 0)));
//        assertTrue(b.isAt(new Vector2d(0, 0)));
//        assertEquals(MapDirection.WEST, b.getDirection());
//    }

    @Test
    public void parserTest() throws IllegalArgumentException{
        String[] notLegalArgs = {"forward", "f", "backward", "b", "left", "l", "right", "r", "llama"};
        String[] legalArgs = {"forward", "f", "backward", "b", "left", "l", "right", "r"};

        Exception exception = assertThrows(IllegalArgumentException.class, () -> OptionsParser.parse(notLegalArgs));
        assertEquals("llama is not legal move specification", exception.getMessage());

        ArrayList<MoveDirection> parsed = OptionsParser.parse(legalArgs);

        ArrayList<MoveDirection> moves = new ArrayList<>();
        moves.add(MoveDirection.FORWARD);
        moves.add(MoveDirection.FORWARD);
        moves.add(MoveDirection.BACKWARD);
        moves.add(MoveDirection.BACKWARD);
        moves.add(MoveDirection.LEFT);
        moves.add(MoveDirection.LEFT);
        moves.add(MoveDirection.RIGHT);
        moves.add(MoveDirection.RIGHT);
        assertEquals(moves, parsed);
    }
}
