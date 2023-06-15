package com.gkaan.aytar

import android.app.Application
import android.content.res.Configuration
import java.util.*

object LanguageManager {
    private var currentLanguage: String = "tr"
    fun setCurrentLanguage(language: String,application: Application) {
        currentLanguage = language
        updateLocale(language, application)
    }

    fun getCurrentLanguage(): String {
        return currentLanguage
    }
    private fun updateLocale(language: String, application: Application){
        val locale = Locale(language)

        Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.setLocale(locale)
        application.resources.updateConfiguration(
            configuration,
            application.resources.displayMetrics
        )
    }
}