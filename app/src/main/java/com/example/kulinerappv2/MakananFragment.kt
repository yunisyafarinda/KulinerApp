package com.example.kulinerappv2


import android.content.Intent
import android.content.res.TypedArray
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_makanan.*

/**
 * A simple [Fragment] subclass.
 */
class MakananFragment : Fragment() {

    private lateinit var namaMakanan: Array<String>
    private lateinit var deskripsiMakanan: Array<String>
    private lateinit var gambarMakanan: TypedArray
    private lateinit var ingredients: Array<String>
    private var makanan = arrayListOf<ModelKuliner>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }

    private fun loadData(){
        namaMakanan = resources.getStringArray(R.array.nama_makanan)
        deskripsiMakanan = resources.getStringArray(R.array.des_makanan)
        gambarMakanan = resources.obtainTypedArray(R.array.gambar_makanan)
        ingredients = resources.getStringArray(R.array.bahan_makanan)

        for (position in namaMakanan.indices){
            val mkn = ModelKuliner(position,
                namaMakanan[position],
                deskripsiMakanan[position],
                gambarMakanan.getResourceId(position, -1),
                ingredients[position]
                )
            makanan.add(mkn)
        }
    }

    private fun showRecyclerList(){
        rv_makanan.setHasFixedSize(true)
        rv_makanan.layoutManager = LinearLayoutManager(context)
        rv_makanan.addItemDecoration(DividerItemDecoration(rv_makanan.context, DividerItemDecoration.VERTICAL))
        val makananAdapter = KulinerAdapter(makanan){
            showSelectedItem(it)
        }
        rv_makanan.adapter = makananAdapter
    }

    private fun showSelectedItem(it: ModelKuliner){
        val pindah = Intent(context, DetailActivity::class.java)
        pindah.putExtra(DetailActivity.KEY_KULINER, it)
        startActivity(pindah)
    }

    override fun onViewCreated(view: android.view.View, savedInstanceState: android.os.Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showRecyclerList()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_makanan, container, false)
    }
}
