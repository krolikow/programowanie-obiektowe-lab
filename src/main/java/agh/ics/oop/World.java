package agh.ics.oop;

import java.util.ArrayList;

import static java.lang.System.out;

public class World {

    public static void main(String[] args) {
        out.println("Start");
        run(change(args));
        Animal animal = new Animal();
        ArrayList<MoveDirection> moveTab = OptionsParser.parse(args);
        for (MoveDirection elem : moveTab) {
            animal.move(elem);
        }
        out.println(animal);
        out.println("Stop");

    }

    public static ArrayList<Direction> change(String[] args) {
        ArrayList<Direction> enumArgs = new ArrayList<>();
        for (String arg : args) {
            switch (arg) {
                case "f" -> enumArgs.add(Direction.FORWARD);
                case "b" -> enumArgs.add(Direction.BACKWARD);
                case "l" -> enumArgs.add(Direction.LEFT);
                case "r" -> enumArgs.add(Direction.RIGHT);
            }
        }
        return enumArgs;
    }

    public static void run(ArrayList<Direction> args) {
        for (Direction arg : args) {
            switch (arg) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case LEFT -> out.println("Zwierzak skręca w lewo");
                case RIGHT -> out.println("Zwierzak skręca w prawo");
            }
        }
    }
}
