package com.example.kulinerappv2

import android.os.Parcel
import android.os.Parcelable

data class ModelKuliner(
    var id: Int,
    var nama: String?,
    var deskripsi: String?,
    var gambar: Int,
    var bahannya: String?
): Parcelable{
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(nama)
        parcel.writeString(deskripsi)
        parcel.writeInt(gambar)
        parcel.writeString(bahannya)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ModelKuliner> {
        override fun createFromParcel(parcel: Parcel): ModelKuliner {
            return ModelKuliner(parcel)
        }

        override fun newArray(size: Int): Array<ModelKuliner?> {
            return arrayOfNulls(size)
        }
    }

}