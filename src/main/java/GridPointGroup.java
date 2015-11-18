import java.util.HashSet;
import java.util.Set;

class GridPointGroup {

    private Set<GridPoint> values = new HashSet<>();

    GridPointGroup(GridPoint... gridPoints) {
        for (GridPoint gp : gridPoints) {
            values.add(gp);
        }
    }

    boolean contains(GridPoint target) {
        return values.stream().anyMatch(gridPoint -> gridPoint.hasSameCoordinatesWith(target));
    }

    boolean connected() {
        if (containsSameCoordinates()) return false;
        return allGridPointsHaveNeighbor();
    }

    private boolean allGridPointsHaveNeighbor() {
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
        return values.stream().allMatch(one -> countNeighborsOf(one) < 3);
    }

    private long countNeighborsOf(GridPoint target) {
        return values.stream().filter(one -> one.isNeighborOf(target)).count();
    }
}
