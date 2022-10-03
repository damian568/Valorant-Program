package com.example.valorantapplication.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PreferenceUntil internal constructor(private val context: Context) {

    init {
        sPref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE)
    }

    fun getUserData(): User? {
        val json: String = sPref.getString(PREF_SERIALIZABLE_USER, null) ?: return null
        return Json.decodeFromString(json)
    }

    fun saveUserData(user: User) {
        val json = Json.encodeToString(user)
        sPref.edit().putString(PREF_SERIALIZABLE_USER, json).apply()
    }

    fun deleteUser() {
        sPref.edit().clear().apply()
    }

    companion object {

        private lateinit var sPref: SharedPreferences
        private const val PREF_FILE_NAME = "com.example.valorantapplication.data"
        private const val PREF_SERIALIZABLE_USER = "com.example.valorantapplication.data.local.PREF_USER"
        private var instance: PreferenceUntil? = null
        fun getInstance(context: Context): PreferenceUntil {
            if (instance == null) {
                instance = PreferenceUntil(context)
            }
            return instance as PreferenceUntil
        }
    }
}