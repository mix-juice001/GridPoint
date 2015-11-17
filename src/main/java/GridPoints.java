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
        if (hasSameCoordinates()) return false;
        return values.stream().allMatch(one -> hasNeighbor(one));
    }

    private boolean hasNeighbor(GridPoint one) {
        return values.stream().anyMatch(another -> one.isNeighborOf(another));
    }

    private boolean hasSameCoordinates() {
        return values.stream().anyMatch(one -> containsSameCoordinates(one));
    }

    private boolean containsSameCoordinates(GridPoint one) {
        return values.stream().filter(another -> another.hasSameCoordinatesWith(one)).count() != 1;
    }

    int count() {
        return values.size();
    }
}
