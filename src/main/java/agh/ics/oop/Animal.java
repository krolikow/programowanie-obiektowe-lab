package agh.ics.oop;


class Animal {
    private MapDirection dir;
    private Vector2d pos;


    public Animal() {
        this.dir = MapDirection.NORTH;
        this.pos = new Vector2d(2, 2);
    }

    public MapDirection getDir() {
        return dir;
    }

    @Override
    public String toString() {
        return "direction: " + dir + ", position: " + pos;
    }

    boolean isAt(Vector2d position) {
        return pos.equals(position);
    }

    public boolean canMove(Vector2d position){
        return (0 <= position.x && position.x <= 4 && 0 <= position.y && position.y <= 4);
    }

    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> dir = dir.next();
            case LEFT -> dir = dir.previous();
            case FORWARD -> {
                Vector2d pos = this.pos.add(dir.toUnitVector());
                if (this.canMove(pos)){
                    this.pos = pos;
                }
            }
            case BACKWARD -> {
                Vector2d pos = this.pos.subtract(dir.toUnitVector());
                if (this.canMove(pos)) {
                    this.pos = pos;
                }
            }
        }
    }
}

