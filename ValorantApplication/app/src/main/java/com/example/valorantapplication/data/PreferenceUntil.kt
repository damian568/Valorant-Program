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

    fun getUserImage(): UserImage? {
        val json: String = sPref.getString(PREF_SERIALIZABLE_IMAGE, null) ?: return null
        return Json.decodeFromString(json)
    }

    fun setUserImage(image: UserImage){
        val json = Json.encodeToString(image)
        sPref.edit().putString(PREF_SERIALIZABLE_IMAGE, json).apply()
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

    fun getAgents(): List<Agents> {
        val json: String = sPref.getString(PREF_SERIALIZABLE_AGENTS, null) ?: return listOf()
        return Json.decodeFromString(json)
    }

    fun setAgents(agent: List<Agents>) {
        val json = Json.encodeToString(agent)
        sPref.edit().putString(PREF_SERIALIZABLE_AGENTS, json).apply()
    }

    companion object {

        private lateinit var sPref: SharedPreferences
        private const val PREF_FILE_NAME = "com.example.valorantapplication.data"
        private const val PREF_SERIALIZABLE_USER = "com.example.valorantapplication.data.local.PREF_USER"
        private const val PREF_SERIALIZABLE_AGENTS = "com.example.valorantapplication.data.local.PREF_AGENTS"
        private const val PREF_SERIALIZABLE_IMAGE = "com.example.valorantapplication.data.local.PREF_IMAGE"
        private var instance: PreferenceUntil? = null
        fun getInstance(context: Context): PreferenceUntil {
            if (instance == null) {
                instance = PreferenceUntil(context)
            }
            return instance as PreferenceUntil
        }
    }
}