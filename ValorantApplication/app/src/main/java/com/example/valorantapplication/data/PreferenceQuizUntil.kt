package com.example.valorantapplication.data

import android.content.Context
import android.content.SharedPreferences
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json

class PreferenceQuizUntil internal constructor(private val context: Context) {

    init {
        sPrefUsername = context.getSharedPreferences(PREF_FILE_NAME_QUIZ_USERNAME, Context.MODE_PRIVATE)
    }

    fun getQuizUsernameData(): QuizUsername? {
        val json: String =
            sPrefUsername.getString(PREF_SERIALIZABLE_QUIZ_USERNAME, null) ?: return null
        return Json.decodeFromString(json)
    }

    fun saveQuizUsernameData(quiz: QuizUsername) {
        val json = Json.encodeToString(quiz)
        sPrefUsername.edit().putString(PREF_FILE_NAME_QUIZ_USERNAME, json).apply()
    }

    fun deleteUser() {
        sPrefUsername.edit().clear().apply()
    }

    companion object {

        private lateinit var sPrefUsername: SharedPreferences
        private const val PREF_FILE_NAME_QUIZ_USERNAME = "com.example.valorantapplication.data"
        private const val PREF_SERIALIZABLE_QUIZ_USERNAME = "com.example.valorantapplication.data.local.PREF_QUIZ"
        private var instance: PreferenceQuizUntil? = null
        fun getInstance(context: Context): PreferenceQuizUntil {
            if (instance == null) {
                instance = PreferenceQuizUntil(context)
            }
            return instance as PreferenceQuizUntil
        }
    }
}