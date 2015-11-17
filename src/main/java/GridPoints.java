import java.util.HashSet;
import java.util.Set;

class GridPoints {

    private Set<GridPoint> values = new HashSet<>();

    GridPoints(GridPoint one, GridPoint another) {
        values.add(one);
        values.add(another);
    }

    GridPoints(GridPoint one, GridPoint another, GridPoint theOther) {
        values.add(one);
        values.add(another);
        values.add(theOther);
    }

    GridPoints(GridPoint one, GridPoint another, GridPoint theOther, GridPoint fourth) {
        values.add(one);
        values.add(another);
        values.add(theOther);
        values.add(fourth);
    }

    boolean contains(GridPoint target) {
        return values.stream().anyMatch(gridPoint -> gridPoint.hasSameCoordinatesWith(target));
    }

    boolean connected() {
        if (containsSameCoordinates()) return false;
        return allGridPointHasNeighbor();
    }

    private boolean allGridPointHasNeighbor() {
        return values.stream().allMatch(one -> hasNeighborOf(one));
    }

    private boolean hasNeighborOf(GridPoint one) {
        return values.stream().anyMatch(another -> one.isNeighborOf(another));
    }

    private boolean containsSameCoordinates() {
        return values.stream().anyMatch(one -> hasSameCoordinatesWith(one));
    }

    private boolean hasSameCoordinatesWith(GridPoint one) {
        return values.stream().filter(another -> another.hasSameCoordinatesWith(one)).count() != 1;
    }

    int count() {
        return values.size();
    }

    boolean traversable() {
        return connected() && allGridPointHasLessThanThreeNeighbors();
    }

    private boolean allGridPointHasLessThanThreeNeighbors() {
        return values.stream().allMatch(one -> countNeighbors(one) < 3);
    }

    private long countNeighbors(GridPoint target) {
        return values.stream().filter(one -> one.isNeighborOf(target)).count();
    }
}
