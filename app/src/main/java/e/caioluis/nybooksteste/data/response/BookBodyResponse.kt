package e.caioluis.nybooksteste.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookBodyResponse (

    @SerializedName("results")
    val bookResults: List<BookResultsResponse>

) : Serializable