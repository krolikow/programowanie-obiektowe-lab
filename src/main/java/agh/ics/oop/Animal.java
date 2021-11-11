package agh.ics.oop;


class Animal {
    private MapDirection dir;
    private Vector2d pos;
    private final IWorldMap map;


    Animal(IWorldMap map,Vector2d initialPosition){
        this.dir = MapDirection.NORTH;
        this.pos = initialPosition;
        this.map =  map;
    }


    public MapDirection getDir() {
        return dir;
    }

    public Vector2d getPos() {
        return pos;
    }


    @Override
    public String toString(){
        return switch (dir){
            case NORTH -> "N";
            case EAST -> "E";
            case WEST -> "W";
            case SOUTH -> "S";
        };
    }

    boolean isAt(Vector2d position) {
        return pos.equals(position);
    }


    public void move(MoveDirection direction) {
        switch (direction) {
            case RIGHT -> dir = dir.next();
            case LEFT -> dir = dir.previous();
            case FORWARD -> {
                Vector2d pos = this.pos.add(dir.toUnitVector());
                if (this.map.canMoveTo(pos)){
                    this.pos = pos;
                }
            }
            case BACKWARD -> {
                Vector2d pos = this.pos.subtract(dir.toUnitVector());
                if (this.map.canMoveTo(pos)) {
                    this.pos = pos;
                }
            }
        }
    }
}

