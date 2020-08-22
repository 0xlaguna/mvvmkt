package com.lagunita.recycler1

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lagunita.recycler1.data.PersonAdapter
import com.lagunita.recycler1.model.Person

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var personAdapter: PersonAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private val personList = ArrayList<Person>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        personAdapter = PersonAdapter(this, personList)

        recyclerView = findViewById(R.id.recyclerId)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = personAdapter
        recyclerView.setHasFixedSize(true)

        val model: MainViewModel by viewModels()

        model.getPersons().observe(this, Observer<ArrayList<Person>> { persons ->
            personAdapter.setData(persons)
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val menuInflater: MenuInflater = menuInflater
        menuInflater.inflate(R.menu.top_app_bar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.addPersonBtn -> {
                AddPersonDialog().show(this.supportFragmentManager,"P" )
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}