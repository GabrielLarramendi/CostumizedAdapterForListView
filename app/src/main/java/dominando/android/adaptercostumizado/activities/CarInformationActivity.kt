package dominando.android.adaptercostumizado.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import dominando.android.adaptercostumizado.R

class CarInformationActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_car_information)

        val txtModel = findViewById<TextView>(R.id.textViewModel)
        val txtYear = findViewById<TextView>(R.id.textViewYear)

        txtModel.text = intent.getStringExtra("model")
        txtYear.text = intent.getStringExtra("year")
    }
}