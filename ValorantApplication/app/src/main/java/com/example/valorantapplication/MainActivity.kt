package com.example.valorantapplication

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.graphics.BlendMode
import android.graphics.BlendModeColorFilter
import android.graphics.PorterDuff
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.view.menu.MenuBuilder
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.onNavDestinationSelected
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var preferenceUntil: PreferenceUntil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        setSupportActionBar(toolbar)
        setupActionBarWithNavController(navController)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        setIconInMenu(menu)
        setColorOnIcon(menu)
        return true
    }

    @SuppressLint("RestrictedApi")
    private fun setIconInMenu(menu: Menu?) {
        if (menu is MenuBuilder) {
            menu.setOptionalIconsVisible(true)
        }
    }

    private fun setColorOnIcon(menu: Menu?) {
        menu?.apply {
            for (index in 0 until this.size()) {
                val item = this.getItem(index)
                setColorItem(item)
            }
        }
    }

    private fun setColorItem(item: MenuItem) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            item.icon.colorFilter = BlendModeColorFilter(
                getColor(R.color.blue), BlendMode.SRC_IN
            )
        } else {
            item.icon.setColorFilter(getColor(R.color.blue), PorterDuff.Mode.SRC_IN)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (item.itemId == R.id.logOut) {
            closingAppQuestion()
            true
        } else {
            item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    private fun closingAppQuestion() {
        val builder = AlertDialog.Builder(this)
        isBuildingAlertDialog(builder)
    }

    private fun isBuildingAlertDialog(builder: AlertDialog.Builder) {
        builder.setTitle(getString(R.string.text_alert_dialog))
        builder.setMessage(getString(R.string.question_alert_dialog))
        builder.setPositiveButton(getString(R.string.yes_alert_dialog)) { _: DialogInterface, _: Int ->
            preferenceUntil.deleteUser()
            finish()
        }
        builder.setNegativeButton(getString(R.string.no_alert_dialog)) { _: DialogInterface, _: Int -> }
        builder.show()
    }
}