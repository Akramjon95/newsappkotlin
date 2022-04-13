package maxcoders.uz.newsapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_news.*
import maxcoders.uz.newsapp.R
import maxcoders.uz.newsapp.NewsViewModel
import maxcoders.uz.newsapp.NewsViewModelProviderFactory
import maxcoders.uz.newsapp.db.ArticleDatabase
import maxcoders.uz.newsapp.repository.NewsRepository

class NewsActivity : AppCompatActivity() {

     lateinit var viewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)

        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)

        bottomNavigationView.setupWithNavController(newsNavHostFragment.findNavController())
    }

    fun bindViewModel(): NewsViewModel{
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application,newsRepository)
        viewModel = ViewModelProvider(this,viewModelProviderFactory).get(NewsViewModel::class.java)
        return viewModel
    }

    fun newCommit(){
        Toast.makeText(this, "New commit", Toast.LENGTH_LONG).show()
    }
}