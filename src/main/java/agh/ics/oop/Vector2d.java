package agh.ics.oop;

import java.util.Objects;

class Vector2d {
    public final int x, y;


    public Vector2d(int x, int y) {
        this.x = x;
        this.y = y;
    }


    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }



    public boolean precedes(Vector2d that) {
        return this.x <= that.x && this.y <= that.y ;
    }



    public boolean follows(Vector2d that) {
        return this.x >= that.x && this.y >= that.y;
    }



    public Vector2d upperRight(Vector2d that) {
        return new Vector2d(Math.max(this.x, that.x), Math.max(this.y, that.y));
    }



    public Vector2d lowerLeft(Vector2d that) {
        return new Vector2d(Math.min(this.x, that.x), Math.min(this.y, that.y));
    }



    public Vector2d add(Vector2d other) {
        return new Vector2d(this.x + other.x, this.y + other.y);
    }



    public Vector2d subtract(Vector2d other) {
        return new Vector2d(this.x - other.x, this.y - other.y);
    }



    @Override
    public boolean equals(Object that){
        if (this == that)
            return true;
        if (!(that instanceof Vector2d))
            return false;
        Vector2d other = (Vector2d) that;
        return this.x == other.x && this.y == other.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.x, this.y);
    }

    public Vector2d opposite() {
        return new Vector2d(-this.x, -this.y);
    }
}
