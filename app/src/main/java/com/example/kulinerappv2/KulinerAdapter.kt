package com.example.kulinerappv2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.tampilan_kuliner.view.*

class KulinerAdapter (
    private val daftarKuliner: ArrayList<ModelKuliner>,
    private val listener: (ModelKuliner) -> Unit
): RecyclerView.Adapter<KulinerAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.tampilan_kuliner, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = daftarKuliner.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(daftarKuliner[position], listener)
    }

    class ViewHolder (itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(modelKuliner: ModelKuliner, listener: (ModelKuliner) -> Unit) {
            with(itemView){
                Glide.with(itemView.context).load(modelKuliner.gambar)
                    .apply(
                        RequestOptions()
                            .override(
                                150,
                                150)
                    ).into(img_kuliner)
                txt_nama.text = modelKuliner.nama
                txt_des.text = modelKuliner.deskripsi

                itemView.setOnClickListener{listener(modelKuliner)}
            }
        }
    }

}