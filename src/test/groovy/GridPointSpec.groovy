import spock.lang.Specification

class GridPointSpec extends Specification {

    def 文字列表現を取得できる() {
        given:
        def sut = new GridPoint(4, 7)
        expect:
        sut.notation() == "(4,7)"
    }

    def "(4,7) と (4,7) は同じ座標を持つ"() {
        given:
        def sut = new GridPoint(4, 7)
        expect:
        sut.hasSameCoordinatesWith(new GridPoint(4,7)) == true
    }

    def "(4,7) と (3,8) は同じ座標を持つ"() {
        given:
        def sut = new GridPoint(4, 7)
        expect:
        sut.hasSameCoordinatesWith(new GridPoint(3,8)) == false
    }

}
