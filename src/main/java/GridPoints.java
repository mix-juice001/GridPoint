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

    boolean contains(GridPoint target) {
        return values.stream().anyMatch(gridPoint -> gridPoint.hasSameCoordinatesWith(target));
    }

    boolean connected() {
        if (hasSameCoordinates()) return false;
        return values.stream().allMatch(one -> values.stream().anyMatch(another -> one.isNeighborOf(another)));
    }

    private boolean hasSameCoordinates() {
        return values.stream().anyMatch(one -> values.stream().filter(another -> another.hasSameCoordinatesWith(one)).count() != 1);
    }
}
