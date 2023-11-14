import com.apsl.glideapp.common.models.Coordinates
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class CoordinatesTest {

    @Test
    fun `Check if correct latitude values are assigned after constructor invocation`() {
        val coordinates1 = Coordinates(latitude = -120.0, longitude = 20.0)
        val coordinates2 = Coordinates(latitude = -45.0, longitude = 20.0)
        val coordinates3 = Coordinates(latitude = 0.0, longitude = 20.0)
        val coordinates4 = Coordinates(latitude = 45.0, longitude = 20.0)
        val coordinates5 = Coordinates(latitude = 120.0, longitude = 20.0)

        assertTrue { coordinates1.latitude == -90.0 }
        assertTrue { coordinates2.latitude == -45.0 }
        assertTrue { coordinates3.latitude == 0.0 }
        assertTrue { coordinates4.latitude == 45.0 }
        assertTrue { coordinates5.latitude == 90.0 }
    }

    @Test
    fun `Check if correct longitude values are assigned after constructor invocation`() {
        val coordinates1 = Coordinates(latitude = 50.0, longitude = -361.0)
        val coordinates2 = Coordinates(latitude = 50.0, longitude = -360.0)
        val coordinates3 = Coordinates(latitude = 50.0, longitude = -181.0)
        val coordinates4 = Coordinates(latitude = 50.0, longitude = -180.0)
        val coordinates5 = Coordinates(latitude = 50.0, longitude = -1.0)
        val coordinates6 = Coordinates(latitude = 50.0, longitude = 0.0)
        val coordinates7 = Coordinates(latitude = 50.0, longitude = 1.0)
        val coordinates8 = Coordinates(latitude = 50.0, longitude = 180.0)
        val coordinates9 = Coordinates(latitude = 50.0, longitude = 181.0)
        val coordinates10 = Coordinates(latitude = 50.0, longitude = 360.0)
        val coordinates11 = Coordinates(latitude = 50.0, longitude = 361.0)

        assertTrue { coordinates1.longitude == -1.0 }
        assertTrue { coordinates2.longitude == 0.0 }
        assertTrue { coordinates3.longitude == 179.0 }
        assertTrue { coordinates4.longitude == -180.0 }
        assertTrue { coordinates5.longitude == -1.0 }
        assertTrue { coordinates6.longitude == 0.0 }
        assertTrue { coordinates7.longitude == 1.0 }
        assertTrue { coordinates8.longitude == -180.0 }
        assertTrue { coordinates9.longitude == -179.0 }
        assertTrue { coordinates10.longitude == 0.0 }
        assertTrue { coordinates11.longitude == 1.0 }
    }

    @Test
    fun `Check equality`() {
        val coordinates1 = Coordinates(latitude = 40.0, longitude = 20.0)
        val coordinates2 = Coordinates(latitude = 40.0, longitude = 20.0)
        val coordinates3 = Coordinates(latitude = 60.0, longitude = 40.0)

        assertTrue { coordinates1 == coordinates2 }
        assertFalse { coordinates2 == coordinates3 }
        assertFalse { coordinates1 == coordinates3 }
    }

    @Test
    fun `Check if string is returned in 'data class-like' format`() {
        val coordinates = Coordinates(0.0, 0.0)
        val expected = "Coordinates(latitude=0.0, longitude=0.0)"
        val actual = coordinates.toString()
        assertEquals(expected = expected, actual = actual)
    }

    @Test
    fun `Check if 'copy' works properly`() {
        val coordinates = Coordinates(latitude = 40.0, longitude = 20.0)
        val expected = Coordinates(latitude = 50.0, longitude = 30.0)
        val actual = coordinates.copy(latitude = 50.0, longitude = 30.0)
        assertFalse { expected === actual }
        assertEquals(expected = expected, actual = actual)
    }
}
