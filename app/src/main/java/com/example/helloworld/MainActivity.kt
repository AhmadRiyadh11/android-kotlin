package com.example.helloworld

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var imageView: ImageView
    private lateinit var textView: TextView
    private var index = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data = ArrayList<Hewan>()
        data.add(Hewan("Ayam", R.drawable.ayam))
        data.add(Hewan("Bebek", R.drawable.bebek))
        data.add(Hewan("Domba", R.drawable.domba))
        data.add(Hewan("kambing", R.drawable.kambing))
        data.add(Hewan("sapi", R.drawable.sapi))

        imageView = findViewById(R.id.imageView)
        textView = findViewById(R.id.textView)
        showData(data[0])

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            index = (index + 1) % data.size
            showData(data[index])
        }
    }

    private fun showData(hewan: Hewan) {
        imageView.setImageResource(hewan.gambarResId)
        textView.text = hewan.nama
    }
}