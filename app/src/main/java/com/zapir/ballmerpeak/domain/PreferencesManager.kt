package com.zapir.ballmerpeak.domain

import android.content.Context
import android.content.SharedPreferences
import com.zapir.ballmerpeak.data.Drink
import com.zapir.ballmerpeak.data.User
import java.text.SimpleDateFormat
import java.util.*

class PreferencesManager(context: Context) {

    companion object {
        private const val USER_WEIGHT_KEY = "User weight key"
        private const val USER_NAME_KEY = "User name key"
        private const val USER_SEX_KEY = "User sex key"

        private const val LAST_DRINKS = "Last drinks"
        private const val LAST_DRINKS_DATE = "Last drinks date"

        private const val FIRST_LAUNCH = "first launch"
    }

    private var sharedPreferences: SharedPreferences? = context.getSharedPreferences("Main " +
            "preferences", Context.MODE_PRIVATE)

    fun getUser(defValue: User = User(-1.0, true, "Default")): User {
        sharedPreferences?.let {
            val weight = it.getFloat(USER_WEIGHT_KEY, -1.0f).toDouble()
            val isFemale = it.getBoolean(USER_SEX_KEY, true)
            val name = it.getString(USER_NAME_KEY, "")
            return User(bodyWeight = weight, isFemale = isFemale, name = name)
        }
        return  defValue
    }

    fun putUser(user: User) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putString(USER_NAME_KEY, user.name)
            editor.putBoolean(USER_SEX_KEY, user.isFemale)
            editor.putFloat(USER_NAME_KEY, user.bodyWeight.toFloat())
            editor.apply()
        }
    }

    fun getDrink(defValue: Drink = Drink(-1.0, Date())): Drink {
        sharedPreferences?.let {
            val drinks = it.getFloat(LAST_DRINKS, -1.0f).toDouble()
            val dateString = it.getString(LAST_DRINKS_DATE, "")
            val sdt = SimpleDateFormat("dd-MM-YYYY")
            val date = sdt.parse(dateString)
            return Drink(drinks, date)
        }
        return  defValue
    }

    fun putDrink(drink: Drink) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putString(LAST_DRINKS_DATE, drink.date.toString())
            editor.putFloat(USER_SEX_KEY, drink.drinks.toFloat())
            editor.apply()
        }
    }

    fun firstLaunch(): Boolean {
        return if (sharedPreferences == null) {
            true
        } else {
            sharedPreferences!!.getBoolean(FIRST_LAUNCH, false)
        }
    }

    fun registerLaunch() {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putBoolean(FIRST_LAUNCH, false)
            editor.apply()
        }
    }

    fun putString(key: String, value: String) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putString(key, value)
            editor.apply()
        }
    }

    fun getString(key: String, defValue: String = ""): String {
        return if (sharedPreferences == null) {
            defValue
        } else sharedPreferences!!.getString(key, defValue)
    }

    fun putStringSet(key: String, values: Set<String>) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putStringSet(key, values)
            editor.apply()
        }
    }

    fun getStringSet(key: String, defValues: Set<String> = emptySet()): Set<String> {
        return if (sharedPreferences == null) {
            defValues
        } else sharedPreferences!!.getStringSet(key, defValues)
    }

    fun putInt(key: String, value: Int) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putInt(key, value)
            editor.apply()
        }
    }

    fun getInt(key: String, defValue: Int = 0): Int {
        return if (sharedPreferences == null) {
            defValue
        } else sharedPreferences!!.getInt(key, defValue)
    }

    fun putBoolean(key: String, value: Boolean) {
        sharedPreferences?.let {
            val editor = it.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }
    }

    fun getBoolean(key: String, defValue: Boolean = true): Boolean {
        return if (sharedPreferences == null) {
            defValue
        } else sharedPreferences!!.getBoolean(key, defValue)
    }
}