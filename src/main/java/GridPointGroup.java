import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

class GridPointGroup {

    final private Set<GridPoint> values = new HashSet<>();

    GridPointGroup(GridPoint... gridPoints) {
        Stream.of(gridPoints).forEach(gridPoint -> values.add(gridPoint));
    }

    boolean contains(GridPoint target) {
        return values.stream().anyMatch(gridPoint -> gridPoint.hasSameCoordinatesWith(target));
    }

    boolean connected() {
        if (containsSameCoordinates()) return false;
        return countNeighborsPair() - countSquare()  >= count() - 1;
    }

    private long countSquare() {
        return values.stream().filter(gridPoint -> containsRight(gridPoint) && containsAbove(gridPoint) && containsRightAbove(gridPoint)).count();
    }

    private boolean containsRightAbove(GridPoint gridPoint) {
        return contains(gridPoint.rightAboveOf());
    }

    private boolean containsAbove(GridPoint gridPoint) {
        return contains(gridPoint.aboveOf());
    }

    private boolean containsRight(GridPoint gridPoint) {
        return contains(gridPoint.rightOf());
    }



    private long countNeighborsPair() {
        return values.stream().mapToLong(one -> countNeighborsOf(one)).sum() / 2;
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
        if (count() == 3 && connected()) return true;
        return connected() && allGridPointsHaveLessThanOneNeighborThatHaveOnlyOneNeighbor();
    }

    private boolean allGridPointsHaveLessThanOneNeighborThatHaveOnlyOneNeighbor() {
        if (values.stream().anyMatch(one -> countNeighborsOnlyConnectedWith(one) >= 2)) return false;
        return values.stream().filter(one -> countNeighborsOnlyConnectedWith(one) == 1).count() <= 2;
    }

    private int countNeighborsOnlyConnectedWith(GridPoint gridPoint) {
        int countOfNeighborsOnlyConnectedWith = 0;
        GridPoint right = gridPoint.rightOf();
        GridPoint above = gridPoint.aboveOf();
        GridPoint left = gridPoint.leftOf();
        GridPoint beneath = gridPoint.beneathOf();
        if (contains(right) && countNeighborsOf(right) == 1) countOfNeighborsOnlyConnectedWith++;
        if (contains(above) && countNeighborsOf(above) == 1) countOfNeighborsOnlyConnectedWith++;
        if (contains(left) && countNeighborsOf(left) == 1) countOfNeighborsOnlyConnectedWith++;
        if (contains(beneath) && countNeighborsOf(beneath) == 1) countOfNeighborsOnlyConnectedWith++;
        return countOfNeighborsOnlyConnectedWith;
    }

    private boolean allGridPointsHaveOnlyEnterAndExit() {
        return allGridPointsHaveLessThanThreeNeighbors();
    }

    private boolean allGridPointsHaveLessThanThreeNeighbors() {
        return values.stream().allMatch(one -> countNeighborsOf(one) < 3);
    }

    private long countNeighborsOf(GridPoint target) {
        return values.stream().filter(one -> one.isNeighborOf(target)).count();
    }
}
