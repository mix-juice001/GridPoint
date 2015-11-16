class GridPoints {
    private final GridPoint one;
    private final GridPoint another;

    GridPoints(GridPoint one, GridPoint another) {
        this.one = one;
        this.another = another;
    }

    boolean contains(GridPoint target) {
        return this.one.hasSameCoordinatesWith(target) || this.another.hasSameCoordinatesWith(target);
    }

    boolean connected() {
        return one.isNeighborOf(another);
    }
}
