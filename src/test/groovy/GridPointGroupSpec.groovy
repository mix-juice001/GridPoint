import spock.lang.Specification

class GridPointGroupSpec extends Specification {
    def 格子点集合が指定した格子点を含む() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 7)
        def sut = new GridPointGroup(one, another)
        expect:
        sut.contains(new GridPoint(4, 7)) == true
    }

    def 格子点集合が指定した格子点を含まない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 7)
        def sut = new GridPointGroup(one, another)
        expect:
        sut.contains(new GridPoint(10, 11)) == false
    }

    def 格子点集合に含まれる点が連結している() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 7)
        def sut = new GridPointGroup(one, another)
        expect:
        sut.connected() == true
    }

    def 格子点集合に含まれる点が連結していない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def sut = new GridPointGroup(one, another)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が指定した点を含む() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(2, 2)
        def sut = new GridPointGroup(one, another, theOther)

        expect:
        sut.contains(new GridPoint(2, 2)) == true;
    }

    def 点3つを含む格子点集合が指定した点を含まない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(2, 2)
        def sut = new GridPointGroup(one, another, theOther)

        expect:
        sut.contains(new GridPoint(2, 1)) == false;
    }

    def 点3つを含む格子点集合が連結している() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(3, 7)

        def sut = new GridPointGroup(one, another, theOther)
        expect:
        sut.connected() == true
    }

    def 点3つを含む格子点集合が連結していない_1つも隣あっていない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(5, 9)

        def sut = new GridPointGroup(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_2点は隣あっている() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 6)
        def theOther = new GridPoint(5, 9)

        def sut = new GridPointGroup(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_同じ点を持つ() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 7)
        def theOther = new GridPoint(5, 9)

        def sut = new GridPointGroup(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_同じ点を持つ_残りの点とは隣() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 7)
        def theOther = new GridPoint(5, 7)

        def sut = new GridPointGroup(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点3つを含む格子点集合が連結していない_3点が同じ点() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(4, 7)
        def theOther = new GridPoint(4, 7)

        def sut = new GridPointGroup(one, another, theOther)
        expect:
        sut.connected() == false
    }

    def 点を2つもつ格子点の数は2である() {
        given:
        def one = new GridPoint(3, 7)
        def another = new GridPoint(4, 7)
        def sut = new GridPointGroup(one, another);
        expect:
        sut.count() == 2
    }

    def 点4つを含む格子点集合が指定した点を含む() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(2, 2)
        def theFourth = new GridPoint(2, 1)
        def sut = new GridPointGroup(one, another, theOther, theFourth)

        expect:
        sut.contains(new GridPoint(2, 1)) == true;
    }

    def 点4つを含む格子点集合が指定した点を含まない() {
        given:
        def one = new GridPoint(4, 7)
        def another = new GridPoint(3, 6)
        def theOther = new GridPoint(2, 2)
        def theFourth = new GridPoint(2, 1)
        def sut = new GridPointGroup(one, another, theOther, theFourth)

        expect:
        sut.contains(new GridPoint(2, 0)) == false;
    }

    def 正方形の格子点集合は連結している() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(1, 1)
        def theFourth = new GridPoint(1, 0)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.connected() == true
    }

    def L字型の格子点集合は連結している() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(0, 2)
        def theFourth = new GridPoint(1, 0)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.connected() == true
    }

    def T型の格子点集合は連結している() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(0, 2)
        def theFourth = new GridPoint(1, 1)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.connected() == true
    }

    def 点が重複している格子点集合は連結していない() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(0, 2)
        def theFourth = new GridPoint(0, 0)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.connected() == false
    }

    def 連結している2点が2つで構成されていて離れている格子点集合は連結していない() {
        given:
        def first = new GridPoint(0, 0)
        def second = new GridPoint(1, 0)
        def third = new GridPoint(0, 2)
        def fourth = new GridPoint(1, 2)
        def sut = new GridPointGroup(first, second, third, fourth)
        expect:
        sut.connected() == false
    }

    def 連結している点2つの格子点集合が一筆書きできる() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def sut = new GridPointGroup(one, another);
        expect:
        sut.traversable() == true
    }

    def 連結していない点2つの格子点集合は一筆書きできない() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 2)
        def sut = new GridPointGroup(one, another);
        expect:
        sut.traversable() == false
    }

    def 連結している点3つの格子点集合が一筆書きできる() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(1, 1)
        def sut = new GridPointGroup(one, another, theOther);
        expect:
        sut.traversable() == true
    }

    def 連結していない点3つの格子点集合は一筆書きできない() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 2)
        def theOther = new GridPoint(1, 1)
        def sut = new GridPointGroup(one, another, theOther);
        expect:
        sut.traversable() == false
    }

    def 正方形の格子点集合は一筆書きできる() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(1, 1)
        def theFourth = new GridPoint(1, 0)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.traversable() == true
    }

    def L字型の格子点集合は一筆書きできる() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(0, 2)
        def theFourth = new GridPoint(1, 0)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.traversable() == true
    }

    def T型の格子点集合は一筆書きできない() {
        given:
        def one = new GridPoint(0, 0)
        def another = new GridPoint(0, 1)
        def theOther = new GridPoint(0, 2)
        def theFourth = new GridPoint(1, 1)

        def sut = new GridPointGroup(one, another, theOther, theFourth)
        expect:
        sut.traversable() == false
    }

    def 格子点集合が6つの点をもつ() {
        given:
        def one = new GridPoint(0, 0)
        def two = new GridPoint(0, 1)
        def three = new GridPoint(0, 2)
        def four = new GridPoint(0, 3)
        def five = new GridPoint(0, 4)
        def six = new GridPoint(0, 5)

        def sut = new GridPointGroup(one, two, three, four, five, six)
        expect:
        sut instanceof GridPointGroup
        sut.count() == 6
    }

    def 離れている正方形2つの格子点集合は連結していない() {
        given:
        def one = new GridPoint(0, 0)
        def two = new GridPoint(0, 1)
        def three = new GridPoint(1, 1)
        def four = new GridPoint(1, 0)
        def five = new GridPoint(3, 0)
        def six = new GridPoint(3, 1)
        def seven = new GridPoint(4, 1)
        def eight = new GridPoint(4, 0)

        def sut = new GridPointGroup(one, two, three, four, five, six, seven, eight)
        expect:
        sut.connected() ==  false
    }
}
