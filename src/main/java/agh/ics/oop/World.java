package agh.ics.oop;

import static java.lang.System.out;
import java.util.ArrayList;

public class World {
    public static void main(String[] args) {
        out.println("Start");
        run(change(args));
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
                case FORWARD -> out.println("Do przodu");
                case BACKWARD -> out.println("Do tyłu");
                case LEFT -> out.println("W lewo");
                case RIGHT -> out.println("W prawo");
            }
        }
    }
}
