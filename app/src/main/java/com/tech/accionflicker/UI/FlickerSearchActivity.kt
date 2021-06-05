package com.tech.accionflicker.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.GridLayoutManager
import com.tech.accionflicker.R
import kotlinx.android.synthetic.main.activity_flicker_search.*


class FlickerSearchActivity : AppCompatActivity() {
    private val flickerSearchViewModel : FlickerSearchViewModel by viewModels()
    private val flickerSearchAdapter = FlickerSearchAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flicker_search)
        flickerPhotoRecycle.adapter = flickerSearchAdapter
        flickerPhotoRecycle.layoutManager = GridLayoutManager(this,1)
        flickerSearchViewModel.FlickerLiveData.observe(this,
        Observer {
            with(flickerSearchAdapter){
                photos.clear()
                photos.addAll(it)
                notifyDataSetChanged()
            }
        })

    }
}