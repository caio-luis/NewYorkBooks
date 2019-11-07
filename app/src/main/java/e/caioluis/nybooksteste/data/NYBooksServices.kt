package e.caioluis.nybooksteste.data

import e.caioluis.nybooksteste.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface NYBooksServices {

    @GET("lists.json")
    fun syncCallBooks(
        @Query("api-key") apiKey: String = "RY9X9iS9BTbqiYmJFjSNAZWr8quEB601",
        @Query("list") list: String = "hardcover-fiction"
    ): Call<BookBodyResponse>
}