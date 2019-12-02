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
import kotlinx.android.synthetic.main.fragment_minuman.*

/**
 * A simple [Fragment] subclass.
 */
class MinumanFragment : Fragment() {

    private lateinit var namaMinuman: Array<String>
    private lateinit var deskripsiMinuman: Array<String>
    private lateinit var gambarMinuman: TypedArray
    private lateinit var ingredients: Array<String>
    private var minuman = arrayListOf<ModelKuliner>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loadData()
    }

    private fun loadData(){
        namaMinuman = resources.getStringArray(R.array.nama_minuman)
        deskripsiMinuman = resources.getStringArray(R.array.des_minuman)
        gambarMinuman = resources.obtainTypedArray(R.array.gambar_minuman)
        ingredients = resources.getStringArray(R.array.bahan_minuman)

        for (position in namaMinuman.indices){
            val minum = ModelKuliner(position,
                namaMinuman[position],
                deskripsiMinuman[position],
                gambarMinuman.getResourceId(position, -1),
                ingredients[position]
            )
            minuman.add(minum)
        }
    }

    private fun showRecyclerList(){
        rv_minuman.setHasFixedSize(true)
        rv_minuman.layoutManager = LinearLayoutManager(context)
        rv_minuman.addItemDecoration(DividerItemDecoration(rv_minuman.context, DividerItemDecoration.VERTICAL))
        val minumanAdapter = KulinerAdapter(minuman){
            showSelectedItem(it)
        }
        rv_minuman.adapter = minumanAdapter
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
        return inflater.inflate(R.layout.fragment_minuman, container, false)
    }


}
