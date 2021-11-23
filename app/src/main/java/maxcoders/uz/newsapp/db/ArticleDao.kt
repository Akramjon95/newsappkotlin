package maxcoders.uz.newsapp.db

import androidx.lifecycle.LiveData
import androidx.room.*
import maxcoders.uz.newsapp.models.Article

@Dao
interface ArticleDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(article: Article): Long

    //@Insert
   // suspend fun insertAlldata(article: List<Article>): LiveData<List<Article>>

    @Query("SELECT * FROM article")
    fun getAllArticles(): LiveData<List<Article>>

    @Delete
    suspend fun deleteArticle(article: Article)
}