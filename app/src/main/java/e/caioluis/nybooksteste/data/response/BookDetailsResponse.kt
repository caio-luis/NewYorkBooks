package e.caioluis.nybooksteste.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookDetailsResponse (

    @SerializedName("title")
    val title : String,
    @SerializedName("author")
    val author: String,
    @SerializedName("description")
    val description: String
) : Serializable