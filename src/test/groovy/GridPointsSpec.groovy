import spock.lang.Specification

class GridPointsSpec extends Specification {
    def 格子点集合が指定した格子点を含む() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 7)
        def sut = new GridPoints(one, another)
        expect:
        sut.contains(new GridPoint(4, 7)) == true
    }

    def 格子点集合が指定した格子点を含まない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 7)
        def sut = new GridPoints(one, another)
        expect:
        sut.contains(new GridPoint(10, 11)) == false
    }

    def 格子点集合に含まれる点が連結している() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 7)
        def sut = new GridPoints(one, another)
        expect:
        sut.connected() == true
    }

    def 格子点集合に含まれる点が連結していない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def sut = new GridPoints(one, another)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が指定した点を含む() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(2, 2)
        def sut = new GridPoints(one, another, theOther)

        expect:
        sut.contains(new GridPoint(2, 2)) == true;
    }

    def 点3つを含む格子点集合が指定した点を含まない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(2, 2)
        def sut = new GridPoints(one, another, theOther)

        expect:
        sut.contains(new GridPoint(2, 1)) == false;
    }

    def 点3つを含む格子点集合が連結している() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(3, 7)

        def sut = new GridPoints(one, another, theOther)
        expect:
        sut.connected() == true
    }

    def 点3つを含む格子点集合が連結していない_1つも隣あっていない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(5, 9)

        def sut = new GridPoints(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_2点は隣あっている() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 6)
        def theOther = new GridPoint(5, 9)

        def sut = new GridPoints(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_同じ点を持つ() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 7)
        def theOther = new GridPoint(5, 9)

        def sut = new GridPoints(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_同じ点を持つ_残りの点とは隣() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 7)
        def theOther = new GridPoint(5, 7)

        def sut = new GridPoints(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_3点が同じ点() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 7)
        def theOther = new GridPoint(4, 7)

        def sut = new GridPoints(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点を2つもつ格子点の数は2である() {
        given:
        def one = new GridPoint(3, 7)
        def another = new GridPoint(4, 7)
        def sut = new GridPoints(one, another);
        expect:
        sut.count() == 2
    }
}
