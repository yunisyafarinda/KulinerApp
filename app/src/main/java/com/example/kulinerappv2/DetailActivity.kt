package com.example.kulinerappv2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    companion object{
        const val KEY_KULINER = "kuliner"
    }
    var modelKuliner:ModelKuliner? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        modelKuliner = intent.getParcelableExtra(DetailActivity.KEY_KULINER )
        supportActionBar?.title = modelKuliner?.nama?:resources.getString(R.string.txt_title)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        txt_nama_detail.text = modelKuliner?.nama
        txt_des_detail.text = modelKuliner?.deskripsi
        txt_ingredient.text = modelKuliner?.bahannya
        img_detail_kuliner.setImageResource( modelKuliner?.gambar?:0)
    }

    override fun onOptionsItemSelected(item: android.view.MenuItem): kotlin.Boolean {
        if (item?.itemId == android.R.id.home){
            finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
