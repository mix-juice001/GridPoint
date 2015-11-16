class GridPoint {
    final private int x;
    final private int y;

    GridPoint(int x, int y) {
        this.x = x;
        this.y = y;
    }

    String notation() {
        return String.format("(%d,%d)", x, y);
    }

    boolean hasSameCoordinatesWith(GridPoint other) {
        return this.x == other.x && this.y == other.y;
    }

    boolean isNeighborOf(GridPoint other) {
        return distanceFrom(other) == 1.0;
    }

    private double distanceFrom(GridPoint other) {
        return Math.sqrt(Math.pow(this.x - other.x, 2) + Math.pow(this.y - other.y, 2));
    }

}
