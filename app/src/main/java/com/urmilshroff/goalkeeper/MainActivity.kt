package com.urmilshroff.goalkeeper

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, GoalsFragment.OnFragmentInteractionListener, SettingsFragment.OnFragmentInteractionListener, AboutFragment.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val goalsFragment=GoalsFragment.newInstance()
        val transaction=supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container,goalsFragment).commit()

//        floatingActionButtonNewGoal.setOnClickListener { view ->
//            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                .setAction("Action", null).show()
//        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        menuInflater.inflate(R.menu.main, menu)
//        return true
//    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        when (item.itemId) {
//            R.id.action_settings -> return true
//            else -> return super.onOptionsItemSelected(item)
//        }
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_goals -> {
                val goalsFragment=GoalsFragment.newInstance()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_container,goalsFragment).commit()
            }

            R.id.nav_settings -> {
                val settingsFragment=SettingsFragment.newInstance()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_container,settingsFragment).commit()
            }

            R.id.nav_about -> {
                val aboutFragment=AboutFragment.newInstance()
                val transaction=supportFragmentManager.beginTransaction()
                transaction.replace(R.id.frame_container,aboutFragment).commit()
            }

            R.id.nav_share -> {
                //yo yo
            }

            R.id.nav_rate -> {
                //yo yo
            }

            R.id.nav_github -> {
                //yo yo
            }
        }

        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
