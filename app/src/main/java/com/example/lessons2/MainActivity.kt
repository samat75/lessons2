package com.example.lessons2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.lessons2.databinding.ActivityMainBinding
import com.example.lessons2.extensions.loadImage
import com.example.lessons2.extensions.showMessage

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding
    private var arrayUrl = mutableListOf<String?>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        arrayUrl.add("https://www.planetware.com/wpimages/2020/02/france-in-pictures-beautiful-places-to-photograph-eiffel-tower.jpg")
        arrayUrl.add("http://static1.squarespace.com/static/58cf261e86e6c09542dfec57/59c121dcb7411ce9fad50792/5dbbf26fe3e0fc792ac382ea/1572599900682/NewYork.jpeg?format=1500w")
        arrayUrl.add("https://www.state.gov/wp-content/uploads/2018/11/Germany-2109x1406.jpg")
        arrayUrl.add("https://storage.googleapis.com/afs-prod/media/332c4712c92649cfa1f7806a2e85b8c0/800.jpeg")
        arrayUrl.add("https://kalpak-travel.com/wp-content/uploads/2016/11/kyrgyzstan-1.jpg")

        ui = ActivityMainBinding.inflate(layoutInflater)
        setContentView(ui.root)

        ui.sumbit.setOnClickListener {
            if (!ui.editText.editText?.text.isNullOrBlank()) {
                arrayUrl.add(ui.editText.editText?.text.toString())
                showMessage(ui.editText.editText?.text.toString())
            }
        }

        ui.btnRandom.setOnClickListener {
            if (!arrayUrl.isNullOrEmpty()) {
                val url = arrayUrl.random()
                if (url != null) {
                    ui.imageView.loadImage(this, url)
                }
            }
        }
    }
}