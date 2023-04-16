import com.apsl.glideapp.common.models.Coordinates
import kotlinx.serialization.Serializable

@Serializable
data class CoordinatesBounds(
    val southwest: Coordinates,
    val northeast: Coordinates
)
