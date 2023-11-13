import com.apsl.glideapp.common.util.Geometry
import kotlin.math.abs
import kotlin.test.Test
import kotlin.test.assertTrue
import org.junit.jupiter.api.Nested

class GeometryTest {

    @Nested
    inner class IsInsidePolygonTest {

        private val simplePolygon: List<Pair<Double, Double>> = listOf(
            // X to Y
            3.0 to 0.0,
            0.0 to 2.0,
            2.0 to 4.0,
            1.0 to 6.0,
            8.0 to 9.0,
            10.0 to 6.0,
            8.0 to 5.0,
            10.0 to 2.0,
            6.0 to 2.0,
            7.0 to 1.0,
            5.0 to 1.0
        )

        @Test
        fun `Check if all given study points are inside the polygon`() {
            // All these points are actually inside the polygon
            val studyPoints = listOf(
                0.0005958974666 to 2.0000178769981,
                3.0007046656944 to 0.0059138180662,
                4.9983385801649 to 1.0031771968062,
                6.9958830676255 to 1.0019327674611,
                9.9918913320921 to 2.0043645036256,
                7.9952455294275 to 4.9995946630984,
                9.9961013140302 to 6.0012510330784,
                7.9982006321159 to 8.9912961321034,
                1.011874267043 to 5.9937753483848,
                2.0020789675199 to 3.9996628727616,
                2.4024564114184 to 2.0533410436899,
                5.3914113472142 to 2.8952783273784,
                3.1964415063439 to 5.3783379598631,
                6.228243599046 to 5.3646193983577,
                7.5040698190519 to 7.7104934157879,
                8.3957763169055 to 2.7306555893131
            )
            assertTrue(studyPoints.all { Geometry.isInsidePolygon(point = it, vertices = simplePolygon) })
        }

        @Test
        fun `Check if all given study points are outside the polygon`() {
            // All these points are actually outside the polygon
            val studyPoints = listOf(
                1.997711329509 to 4.0003118212654,
                0.9966531954571 to 5.9971160342586,
                8.0113926019304 to 8.998669055057,
                10.0004769983413 to 5.9981431052382,
                8.0004786918266 to 4.9999300721075,
                10.0000484148138 to 1.9999534487651,
                6.001596871593 to 1.9992352997146,
                7.0000172872807 to 1.0004293532634,
                5.0000425779466 to 0.9999012698499,
                3.0002444302048 to 0.0000363115655,
                5.1554855252942 to 0.3432495049533,
                8.6573999066811 to 1.2187281003009,
                10.634287057464 to 4.4523506540848,
                9.7164465946005 to 8.5614518032163,
                2.599652851782 to 8.7026580282724,
                0.453318230932 to 4.4382300315792,
                0.1850264033258 to 0.2444051474141,
                0.0006649652434 to 1.9986409349836
            )
            assertTrue(studyPoints.none { Geometry.isInsidePolygon(point = it, vertices = simplePolygon) })
        }
    }

    @Nested
    inner class CalculateDistanceTest {

        @Test
        fun `Check if distance is calculated correctly considering tolerance`() {
            val tolerance = 130.0 // Tolerance per 100 km
            val polyline =
                listOf(54.4 to 17.7, 53.564783 to 17.127686) // Actual distance between these points is 100 km

            val expected = 100_000.0 // meters
            val actual = Geometry.calculateDistance(polyline)
            assertTrue { abs(expected - actual) < tolerance }
        }

        @Test
        fun `Check if calculated distance is 0 if the input list size is less than 2`() {
            val polyline = emptyList<Pair<Double, Double>>()
            assertTrue { Geometry.calculateDistance(polyline) == 0.0 }
        }
    }
}
