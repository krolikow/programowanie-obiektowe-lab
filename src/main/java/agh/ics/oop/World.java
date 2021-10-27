package agh.ics.oop;

import static java.lang.System.out;

public class World {
    public static Direction[] change(String[] args) {
        Direction[] enumArgs = new Direction[args.length];
        for (int i = 0; i < args.length; i++) {
            enumArgs[i] = switch (args[i]) {
                case "f" -> Direction.FORWARD;
                case "b" -> Direction.BACKWARD;
                case "l" -> Direction.LEFT;
                case "r" -> Direction.RIGHT;
                default -> Direction.NONE;
            };
        }
        return enumArgs;
    }

    public static void run(Direction[] enumArgs) {
        for (Direction enumArg : enumArgs) {
            switch (enumArg) {
                case FORWARD -> out.println("Zwierzak idzie do przodu");
                case BACKWARD -> out.println("Zwierzak idzie do tyłu");
                case LEFT -> out.println("Zwierzak skręca w lewo");
                case RIGHT -> out.println("Zwierzak skręca w prawo");
            }
        }
    }

    public static void main(String[] args) {
        out.println("Start");
        String[] tab = new String[]{"f", "b", "l", "l", "6", "l", "r"};
        Direction[] enumArgs;
        enumArgs = change(tab);
        run(enumArgs);
        out.println("Stop");
    }
}
