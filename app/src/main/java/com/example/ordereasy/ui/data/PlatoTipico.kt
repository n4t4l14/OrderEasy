package com.example.ordereasy.data

import android.os.Parcel
import android.os.Parcelable

data class PlatoTipico(
    val id: Int?, // Specify type as Int
    val nombre: String?,
    val descripcion: String?,
    val imagenUrl: String?,
    var checkCard: Boolean,
    val precio: Double = 0.0  // Atributo de precio con valor predeterminado
) : Parcelable {

    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readByte() != 0.toByte(),
        parcel.readDouble()  // Leer precio del Parcel
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nombre)
        parcel.writeString(descripcion)
        parcel.writeString(imagenUrl)
        parcel.writeByte(if (checkCard) 1 else 0)
        parcel.writeDouble(precio)  // Escribir precio en Parcel
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PlatoTipico> {
        override fun createFromParcel(parcel: Parcel): PlatoTipico {
            return PlatoTipico(parcel)
        }

        override fun newArray(size: Int): Array<PlatoTipico?> {
            return arrayOfNulls(size)
        }
    }
}
