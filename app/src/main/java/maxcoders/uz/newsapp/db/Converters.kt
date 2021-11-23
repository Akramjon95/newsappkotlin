package maxcoders.uz.newsapp.db

import androidx.room.TypeConverter
import maxcoders.uz.newsapp.models.Source

class Converters {

    @TypeConverter
    fun fromSource(source: Source): String?{
        return source.name
    }

    @TypeConverter
    fun toSource(name: String): Source {
        return Source(name, name)
    }
}