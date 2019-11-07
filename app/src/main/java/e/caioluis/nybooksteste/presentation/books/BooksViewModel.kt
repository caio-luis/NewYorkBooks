package e.caioluis.nybooksteste.presentation.books

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import e.caioluis.nybooksteste.data.ApiService
import e.caioluis.nybooksteste.data.model.Book
import e.caioluis.nybooksteste.data.response.BookBodyResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class BooksViewModel : ViewModel() {

    val booksLiveData: MutableLiveData<List<Book>> = MutableLiveData()

    fun getBooks() {

        ApiService.service.syncCallBooks().enqueue(object : Callback<BookBodyResponse> {

            override fun onFailure(call: Call<BookBodyResponse>, t: Throwable) {

            }

            override fun onResponse(
                call: Call<BookBodyResponse>,
                response: Response<BookBodyResponse>
            ) {
                if (response.isSuccessful) {

                    val books: MutableList<Book> = mutableListOf()

                    response.body()?.let { bookBodyResponse ->

                        for (result in bookBodyResponse.bookResults) {
                            val book = Book(
                                result.bookDetailsResponse.first().title,
                                result.bookDetailsResponse.first().author,
                                result.bookDetailsResponse.first().description
                            )
                            books.add(book)
                        }
                    }
                   booksLiveData.value = books
                }
            }
        })
    }
}