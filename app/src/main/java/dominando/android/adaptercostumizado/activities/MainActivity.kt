package dominando.android.adaptercostumizado.activities

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast
import dominando.android.adaptercostumizado.R
import dominando.android.adaptercostumizado.adapters.VehicleAdapter
import dominando.android.adaptercostumizado.model.Vehicle

class MainActivity : AppCompatActivity() {

    private lateinit var txtFooter: TextView

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
        Vehicle("BYD Song Plus", 2024, 4, true, true ,true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.listView)
        listView.emptyView = findViewById(R.id.empty)

        val adapter = VehicleAdapter(this, vehicles)
        listView.adapter = adapter

        initHeaderAndFooter(listView, adapter)

        listView.setOnItemClickListener {parent, view, position, id ->  //parent = ListView q dispara o evento, view q foi clicada, indice e id
            val vehicle = parent.getItemAtPosition(position) as? Vehicle
            if (vehicle != null) {
                val p = position -1
                val (model, year) = vehicle
                Toast.makeText(this, "$model | $year | $p", Toast.LENGTH_SHORT).show()
                vehicles.remove(vehicle)
                adapter.notifyDataSetChanged()
                txtFooter.text = resources.getQuantityString(R.plurals.footer_text, adapter.count, adapter.count)
//                val intent = Intent(this, CarInformationActivity::class.java)
//                intent.putExtra("vehicle", vehicle)
//                startActivity(intent)
            }
        }
    }

    private fun initHeaderAndFooter(listView: ListView, adapter: VehicleAdapter) {
        val padding = 8
        val txtHeader = TextView(this)
        txtHeader.setBackgroundColor(Color.GRAY)
        txtHeader.setTextColor(Color.WHITE)
        txtHeader.setText(R.string.header_text)
        txtHeader.setPadding(padding, padding, 0, padding)
        listView.addHeaderView(txtHeader)

        txtFooter = TextView(this)
        txtFooter.text = resources.getQuantityString(R.plurals.footer_text, adapter.count, adapter.count)
        txtFooter.setBackgroundColor(Color.LTGRAY)
        txtFooter.setTextColor(Color.BLACK)
        txtFooter.gravity = Gravity.END
        txtFooter.setPadding(0, padding, padding, padding)
        listView.addFooterView(txtFooter)
    }
}