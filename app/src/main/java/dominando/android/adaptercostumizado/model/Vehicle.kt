package dominando.android.adaptercostumizado.model

import java.io.Serializable

data class Vehicle(
    var model: String,
    var year: Int,
    var manufacturer: Int, //0 =VW; 1=CHEVROLET, 2=Fiat; 3=Ford
    var gasoline: Boolean,
    var ethanol: Boolean,
    var eletric: Boolean) : Serializable
