import com.apsl.glideapp.common.models.Coordinates
import com.apsl.glideapp.common.models.CoordinatesBounds
import com.apsl.glideapp.common.models.Empty
import com.apsl.glideapp.common.models.toCoordinatesBounds
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue
import org.junit.jupiter.api.assertThrows

class CoordinatesBoundsTest {

    @Test
    fun `Check if constructor body throws exception if southwest coordinates exceed northeast coordinates`() {
        assertThrows<IllegalArgumentException> {
            CoordinatesBounds(
                southwest = Coordinates(latitude = 60.0, longitude = 17.0),
                northeast = Coordinates(latitude = 50.0, longitude = 17.0)
            )
        }
        assertThrows<IllegalArgumentException> {
            CoordinatesBounds(
                southwest = Coordinates(latitude = 50.0, longitude = 18.0),
                northeast = Coordinates(latitude = 50.0, longitude = 17.0)
            )
        }
    }

    @Test
    fun `Check equality`() {
        val bounds1 = CoordinatesBounds(
            southwest = Coordinates(latitude = 40.0, longitude = 17.0),
            northeast = Coordinates(latitude = 50.0, longitude = 18.0)
        )
        val bounds2 = CoordinatesBounds(
            southwest = Coordinates(latitude = 40.0, longitude = 17.0),
            northeast = Coordinates(latitude = 50.0, longitude = 18.0)
        )
        val bounds3 = CoordinatesBounds(
            southwest = Coordinates(latitude = 35.0, longitude = 17.0),
            northeast = Coordinates(latitude = 50.0, longitude = 18.0)
        )

        assertTrue { bounds1 == bounds2 }
        assertFalse { bounds2 == bounds3 }
        assertFalse { bounds1 == bounds3 }
    }

    @Test
    fun `Check if actual center is returned`() {
        val bounds = CoordinatesBounds(
            southwest = Coordinates(latitude = 20.0, longitude = 10.0),
            northeast = Coordinates(latitude = 40.0, longitude = 30.0)
        )
        val expected = Coordinates(latitude = 30.0, longitude = 20.0)
        val actual = bounds.center
        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun `Check if 'contains' works properly`() {
        val bounds = CoordinatesBounds(
            southwest = Coordinates(latitude = 40.0, longitude = 17.0),
            northeast = Coordinates(latitude = 60.0, longitude = 25.0)
        )
        assertTrue { bounds.contains(Coordinates(50.0, 20.0)) }
        assertFalse { bounds.contains(Coordinates(30.0, 20.0)) }
    }

    @Test
    fun `Check if string is returned in 'data class-like' format`() {
        val bounds = CoordinatesBounds.Empty
        val expected =
            "CoordinatesBounds(southwest=Coordinates(latitude=0.0, longitude=0.0), northeast=Coordinates(latitude=0.0, longitude=0.0), center=Coordinates(latitude=0.0, longitude=0.0))"
        val actual = bounds.toString()
        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun `Check if 'copy' works properly`() {
        val bounds = CoordinatesBounds(
            southwest = Coordinates(latitude = 40.0, longitude = 17.0),
            northeast = Coordinates(latitude = 60.0, longitude = 25.0)
        )

        val expected = CoordinatesBounds(
            southwest = Coordinates(latitude = 45.0, longitude = 18.0),
            northeast = Coordinates(latitude = 65.0, longitude = 26.0)
        )
        val actual = bounds.copy(
            southwest = Coordinates(latitude = 45.0, longitude = 18.0),
            northeast = Coordinates(latitude = 65.0, longitude = 26.0)
        )

        assertFalse { expected === actual }
        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun `Check if list of coordinates is mapped to bounds correctly`() {
        val coordinatesList = listOf(
            Coordinates(latitude = 35.0, longitude = 15.0),
            Coordinates(latitude = 25.0, longitude = 20.0),
            Coordinates(latitude = 20.0, longitude = 10.0),
            Coordinates(latitude = 40.0, longitude = 30.0)
        )
        val expected = CoordinatesBounds(
            southwest = Coordinates(latitude = 20.0, longitude = 10.0),
            northeast = Coordinates(latitude = 40.0, longitude = 30.0)
        )
        val actual = coordinatesList.toCoordinatesBounds()
        assertEquals(expected = expected, actual = actual)
    }
}
