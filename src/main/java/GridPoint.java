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

    GridPoint rightOf() {
        return new GridPoint(this.x + 1, this.y);
    }

    GridPoint aboveOf() {
        return new GridPoint(this.x, this.y + 1);
    }

    GridPoint rightAboveOf() {
        return new GridPoint(this.x + 1, this.y + 1);
    }

    GridPoint leftOf() {
        return new GridPoint(this.x -1, this.y);
    }

    GridPoint beneathOf() {
        return new GridPoint(this.x, this.y -1);
    }
}
