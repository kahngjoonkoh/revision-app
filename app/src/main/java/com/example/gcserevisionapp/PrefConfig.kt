package com.example.gcserevisionapp

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

open class PrefConfig {

    private val LIST_KEY: String = "list_save"

    open fun writeListInPref(context: Context, list: List<String>) {
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
        val type = object : TypeToken<List<String>>() {}.type
        val list: List<String> = gson.fromJson(
            jsonString,
            type
        )
        return list
    }

    object Writer {
        private const val MAP_KEY = "map_save"
        private const val MAP2_KEY = "map2_save"
        private const val PROGRESS_KEY = "progress_save"

        @JvmName("writeMapInPref1")
        fun writeMapInPref(context: Context, map: Map<String, Int>) {
            val gson: Gson = Gson()
            val jsonString = gson.toJson(map)

            val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor: SharedPreferences.Editor = pref.edit()
            editor.putString(MAP_KEY, jsonString)
            editor.apply()
        }

        fun writeMapInPref(context: Context, map: Map<String, Map<String, Int>>) {
            val gson: Gson = Gson()
            val jsonString = gson.toJson(map)

            val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor: SharedPreferences.Editor = pref.edit()
            editor.putString(MAP2_KEY, jsonString)
            editor.apply()
        }

        fun writeInt(context: Context, int: Int) {
            val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val editor: SharedPreferences.Editor = pref.edit()
            editor.putInt(PROGRESS_KEY, int)
            editor.apply()
        }
    }

    object Reader {
        private const val MAP_KEY = "map_save"
        private const val MAP2_KEY = "map2_save"
        private const val PROGRESS_KEY = "progress_save"

        fun readMapFromPref(context: Context): Map<String, Int> {
            val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val jsonString: String? = pref.getString(MAP_KEY, "")
            val gson: Gson = Gson()
            val type = object : TypeToken<Map<String, Int>>() {}.type
            return gson.fromJson(
                jsonString,
                type
            )
        }

        fun readMap2FromPref(context: Context): Map<String, Map<String, Int>> {
            val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
            val jsonString: String? = pref.getString(MAP2_KEY, "")
            val gson: Gson = Gson()
            val type = object : TypeToken<Map<String, Map<String, Int>>>() {}.type
            return gson.fromJson(
                jsonString,
                type
            )
        }
        fun readInt(context: Context): Int {
            val pref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)

            return pref.getInt(PROGRESS_KEY, R.id.nav_home)
        }
    }
}