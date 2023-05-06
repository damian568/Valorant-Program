package com.example.valorantapplication

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import androidx.appcompat.app.AlertDialog
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.data.User
import com.example.valorantapplication.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_login_screen.view.*
import kotlinx.android.synthetic.main.nav_header.view.*

val bundle = Bundle()

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var preferenceUntil: PreferenceUntil

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        preferenceUntil = PreferenceUntil.getInstance(applicationContext)
        val user = preferenceUntil.getUserData()
        user?.let { setNavHeader(it) }
//        setNavHeaderImage()

        val navHostFragment =
            supportFragmentManager
                .findFragmentById(R.id.navHostFragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        setAppBar()

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        setLogOutFromMenu()
    }

    private fun setAppBar(){
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.infoFragment,
                R.id.agentsFragment,
                R.id.mapsFragment,
                R.id.weaponsFragment,
                R.id.loginScreenFragment,
                R.id.logOut,
                R.id.mediaFragment,
                R.id.leaderBoardsFragment,
                R.id.specsFragment,
                R.id.communityCodeFragment,
                R.id.twitterFragment,
                R.id.youTubeFragment,
                R.id.instagramFragment,
                R.id.facebookFragment,
                R.id.discordFragment,
            ),
            drawer_layout
        )
    }

    private fun setLogOutFromMenu(){
        navView.menu.findItem(R.id.logOut).setOnMenuItemClickListener {
            closingAppQuestion()
            true
        }
    }

    private fun setNavHeader(user: User?){
        navView.getHeaderView(0).nameHeader.text = user?.username
        navView.getHeaderView(0).emailHeader.text = user?.email
//        navView.getHeaderView(0).imageHeader.setImageResource(R.id.imageViewProfile)
    }

//    private fun setNavHeaderImage(){
//        val userImage = preferenceUntil.getUserImage()
//        val imageId = userImage?.image
//        imageId?.let { navView.getHeaderView(0).imageHeader.setImageResource(it) }
//    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.logOut -> {
                true
            }
            else -> {
                item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
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