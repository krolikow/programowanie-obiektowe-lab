package agh.ics.oop;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GrassFieldTest {
    @Test
    public void canMoveToTest(){
        GrassField field = new GrassField(5);
        System.out.println(field);
        Grass anyGrass = field.getGrass().get(0);
        Animal animal = new Animal(field, new Vector2d(3, 3));
        assertTrue(field.canMoveTo(anyGrass.getPosition()));
        assertTrue(field.canMoveTo(animal.getPosition()));
        field.place(animal);
        assertFalse(field.canMoveTo(animal.getPosition()));
        assertTrue(field.canMoveTo(new Vector2d(100, 100)));
        assertTrue(field.canMoveTo(new Vector2d(-10, -10)));
    }
}
