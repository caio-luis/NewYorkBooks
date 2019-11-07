package e.caioluis.nybooksteste.data.response

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class BookResultsResponse(
    @SerializedName("book_details")
    val bookDetailsResponse: List<BookDetailsResponse>
) : Serializable