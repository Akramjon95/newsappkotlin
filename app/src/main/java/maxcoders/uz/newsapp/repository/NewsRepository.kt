package maxcoders.uz.newsapp.repository

import androidx.lifecycle.LiveData
import maxcoders.uz.newsapp.api.RetrofitInstance
import maxcoders.uz.newsapp.db.ArticleDatabase
import maxcoders.uz.newsapp.models.Article

class NewsRepository(val db: ArticleDatabase) {

    suspend fun getBreakingNews(countryCode: String, pageNumber: Int) =
        RetrofitInstance.api.getBreakingNews(countryCode, pageNumber)

    suspend fun searchNews(searchQuery: String, pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery, pageNumber)

    suspend fun upsert(article: Article) = db.getArticleDao().upsert(article)
    //suspend fun insertAllData(article: List<Article>) = db.getArticleDao().insertAlldata(article)

    fun getSavedNews() = db.getArticleDao().getAllArticles()

    suspend fun deleteArticle(article: Article) = db.getArticleDao().deleteArticle(article)
}