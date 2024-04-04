package dominando.android.adaptercostumizado.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.Toast
import dominando.android.adaptercostumizado.adapters.VehicleAdapter
import dominando.android.adaptercostumizado.model.Vehicle

class MainActivity : AppCompatActivity() {

    private val vehicles = mutableListOf(
        Vehicle("Onix", 2018, 1, true, true, false),
        Vehicle("Uno", 2007, 2, true, false, false),
        Vehicle("Del Rey", 1988, 3, false, false, false),
        Vehicle("Gol", 2014, 0, true, true, false),
        Vehicle("BYD Dolphin", 2023, 4, false, false, true),
        Vehicle("BYD Song Plus", 2024, 4, true, true ,true),
        Vehicle("Onix", 2018, 1, true, true, false),
        Vehicle("Uno", 2007, 2, true, false, false),
        Vehicle("Del Rey", 1988, 3, false, false, false),
        Vehicle("Gol", 2014, 0, true, true, false),
        Vehicle("BYD Dolphin", 2023, 4, false, false, true),
        Vehicle("BYD Song Plus", 2024, 4, true, true ,true),
        Vehicle("Onix", 2018, 1, true, true, false),
        Vehicle("Uno", 2007, 2, true, false, false),
        Vehicle("Del Rey", 1988, 3, false, false, false),
        Vehicle("Gol", 2014, 0, true, true, false),
        Vehicle("BYD Dolphin", 2023, 4, false, false, true),
        Vehicle("BYD Song Plus", 2024, 4, true, true ,true),
        Vehicle("Onix", 2018, 1, true, true, false),
        Vehicle("Uno", 2007, 2, true, false, false),
        Vehicle("Del Rey", 1988, 3, false, false, false),
        Vehicle("Gol", 2014, 0, true, true, false),
        Vehicle("BYD Dolphin", 2023, 4, false, false, true),
        Vehicle("BYD Song Plus", 2024, 4, true, true ,true),
        Vehicle("Onix", 2018, 1, true, true, false),
        Vehicle("Uno", 2007, 2, true, false, false),
        Vehicle("Del Rey", 1988, 3, false, false, false),
        Vehicle("Gol", 2014, 0, true, true, false),
        Vehicle("BYD Dolphin", 2023, 4, false, false, true),
        Vehicle("BYD Song Plus", 2024, 4, true, true ,true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val listView = ListView(this)
        setContentView(listView)
        val adapter = VehicleAdapter(this, vehicles)
        listView.adapter = adapter

        listView.setOnItemClickListener {parent, view, position, id ->
            val (model, year) = vehicles[position]
            Toast.makeText(this, "$model | $year | $position", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CarInformationActivity::class.java)
            intent.putExtra("model", model)
            intent.putExtra("year", year.toString())
            startActivity(intent)
        }
    }
}