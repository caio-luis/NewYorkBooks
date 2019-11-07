package e.caioluis.nybooksteste.presentation.books

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import e.caioluis.nybooksteste.R
import e.caioluis.nybooksteste.presentation.details.BookDetailsActivity
import kotlinx.android.synthetic.main.activity_books.*

class BooksActivity : AppCompatActivity() {

    private lateinit var context: Context
    private lateinit var viewModel: BooksViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_books)

        initVars()
        initActions()
    }

    private fun initVars() {

        context = this@BooksActivity

        viewModel = ViewModelProviders.of(this).get(BooksViewModel::class.java)
    }

    private fun initActions() {

        toolBarMain.title = "Books"
        setSupportActionBar(toolBarMain)

        viewModel.booksLiveData.observe(this, Observer { bookList ->

            with(recycler_books) {
                layoutManager = LinearLayoutManager(
                    context,
                    RecyclerView.VERTICAL,
                    false
                )
                setHasFixedSize(true)
                adapter = BooksAdapter(bookList) { book ->

                    val intent = BookDetailsActivity.getStartIntent(
                        context,
                        book.title,
                        book.description
                    )

                    context.startActivity(intent)
                }
            }
        })
        viewModel.getBooks()
    }
}
