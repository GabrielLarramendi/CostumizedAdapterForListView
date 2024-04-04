package dominando.android.adaptercostumizado.adapters

import android.content.Context
import android.content.res.TypedArray
import android.view.LayoutInflater
import android.view.LayoutInflater.*
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.StringRes
import androidx.recyclerview.widget.RecyclerView
import dominando.android.adaptercostumizado.R
import dominando.android.adaptercostumizado.model.Vehicle
import java.util.zip.Inflater

class VehicleAdapter(
                     private val ctx: Context,
                     private val vehicles: List<Vehicle>): BaseAdapter() {
            private val logos:TypedArray by lazy {
                ctx.resources.obtainTypedArray(R.array.array_logos)
            }

    override fun getCount(): Int = vehicles.size

    override fun getItem(position: Int) = vehicles[position]

    override fun getItemId(position: Int) = position.toLong()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val vehicle = vehicles[position]

        val row = from(ctx).inflate(R.layout.item_vehicle_for_listview, parent, false)

        val logoImg:ImageView = row.findViewById<ImageView>(R.id.img_logo)
        val textModel:TextView = row.findViewById<TextView>(R.id.textModel)
        val textYear:TextView = row.findViewById<TextView>(R.id.textYear)
        val textFuel:TextView = row.findViewById<TextView>(R.id.textFuel)

        logoImg.setImageDrawable(logos.getDrawable(vehicle.manufacturer))
        textModel.text = vehicle.model
        textYear.text = vehicle.year.toString()
        textFuel.text = ctx.getString(getFuel(vehicle))

        return row
    }

    @StringRes
    private fun getFuel(vehicle: Vehicle):Int =
        if(vehicle.gasoline && vehicle.ethanol && !vehicle.eletric) R.string.fuel_flex
        else if(vehicle.gasoline && vehicle.eletric && vehicle.ethanol || vehicle.gasoline && vehicle.eletric || vehicle.ethanol && vehicle.eletric) {
            R.string.fuel_hybrid
        }
        else if (vehicle.gasoline) R.string.fuel_gasoline
        else if (vehicle.ethanol) R.string.fuel_ethanol
        else if(vehicle.eletric) R.string.fuel_eletric
        else R.string.fuel_invalid
}