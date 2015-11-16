class GridPoints {
    private final GridPoint one;
    private final GridPoint another;
    private GridPoint theOther;

    GridPoints(GridPoint one, GridPoint another) {
        this(one, another, GridPoint.nullGridPoint());
    }

    GridPoints(GridPoint one, GridPoint another, GridPoint theOther) {
        this.one = one;
        this.another = another;
        this.theOther = theOther;
    }

    boolean contains(GridPoint target) {
        return this.one.hasSameCoordinatesWith(target)
                || this.another.hasSameCoordinatesWith(target)
                || this.theOther.hasSameCoordinatesWith(target);

    }

    boolean connected() {
        if (theOther != GridPoint.nullGridPoint())
            return (one.isNeighborOf(another) && one.isNeighborOf(theOther))
                    || (another.isNeighborOf(one)) && another.isNeighborOf(theOther)
                    || (theOther.isNeighborOf(one) && theOther.isNeighborOf(another));
        return one.isNeighborOf(another);
    }
}
