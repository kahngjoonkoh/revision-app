package com.example.gcserevisionapp

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.ArrayList

open class PrefConfig {

    private val LIST_KEY: String = "list_save"
    private val MAP_KEY: String = "map_save"

    open fun writeListInPref(context: Context, list: List<String>){
        val gson: Gson = Gson()
        val jsonString = gson.toJson(list)

        val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(LIST_KEY, jsonString)
        editor.apply()
    }

    open fun readListFromPref(context: Context): List<String> {
        val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val jsonString: String? = pref.getString(LIST_KEY, "")
        val gson: Gson = Gson()
        val type = object: TypeToken<List<String>>(){}.type
        val list: List<String> = gson.fromJson(
            jsonString,
            type
        )
        return list
    }
    open fun writeMapInPref(context: Context, map: Map<String, Int>){
        val gson: Gson = Gson()
        val jsonString = gson.toJson(map)

        val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val editor: SharedPreferences.Editor = pref.edit()
        editor.putString(MAP_KEY, jsonString)
        editor.apply()
    }

    open fun readMapFromPref(context: Context): Map<String, Int> {
        val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
        val jsonString: String? = pref.getString(MAP_KEY, "")
        val gson: Gson = Gson()
        val type = object: TypeToken<Map<String, Int>>(){}.type
        val map: Map<String, Int> = gson.fromJson(
            jsonString,
            type
        )
        return map
    }
}