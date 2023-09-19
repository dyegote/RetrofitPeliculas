package com.example.mispeliculas.data

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type

class Converters {

    var gson = Gson()

    @TypeConverter
    fun IntListToString(list: List<Int>) : String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToIntList(data: String) : List<Int> {
        val listType: Type = object: TypeToken<List<Int>>() {}.type
        return gson.fromJson(data, listType)
    }

    @TypeConverter
    fun StringListToString(list: List<String>) : String {
        return gson.toJson(list)
    }

    @TypeConverter
    fun stringToStringList(data: String) : List<String> {
        val listType: Type = object: TypeToken<List<String>>() {}.type
        return gson.fromJson(data, listType)
    }
}