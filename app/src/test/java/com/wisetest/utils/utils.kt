import com.google.common.io.Resources
import java.io.File

internal fun getJson(path:String): String {
    val uri = Resources.getResource(path)
    val file = File(uri.path)
    return String(file.readBytes())
}

 const val characterSuccess ="{\"id\":85,\"name\":\"Cyclops Morty\",\"status\":\"Alive\",\"species\":\"Humanoid\",\"type\":\"\",\"gender\":\"Male\",\"origin\":{\"name\":\"unknown\",\"url\":\"\"},\"location\":{\"name\":\"Citadel of Ricks\",\"url\":\"https://rickandmortyapi.com/api/location/3\"},\"image\":\"https://rickandmortyapi.com/api/character/avatar/85.jpeg\",\"episode\":[\"https://rickandmortyapi.com/api/episode/10\",\"https://rickandmortyapi.com/api/episode/28\"],\"url\":\"https://rickandmortyapi.com/api/character/85\",\"created\":\"2017-11-30T20:49:52.133Z\"}"