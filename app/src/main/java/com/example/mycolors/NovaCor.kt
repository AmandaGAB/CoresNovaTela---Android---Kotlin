package com.example.mycolors

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.LinearLayout
import android.widget.SeekBar
import android.widget.TextView

class NovaCor : AppCompatActivity() {
    private lateinit var layout: LinearLayout
    private lateinit var trgb: TextView
    private lateinit var seekRed: SeekBar
    private lateinit var seekGreen: SeekBar
    private lateinit var seekBlue: SeekBar
    private lateinit var btnSalvar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nova_cor)
        Log.i("APP_CORES", "main - onCreate")

        this.layout = findViewById(R.id.background)
        this.trgb = findViewById(R.id.Trgb)
        this.seekRed = findViewById(R.id.r)
        this.seekGreen = findViewById(R.id.g)
        this.seekBlue = findViewById(R.id.b)
        this.btnSalvar = findViewById(R.id.salvar)
        this.btnCancelar = findViewById(R.id.cancelar)



        this.seekRed.setOnSeekBarChangeListener(OnChange())
        this.seekGreen.setOnSeekBarChangeListener(OnChange())
        this.seekBlue.setOnSeekBarChangeListener(OnChange())


        this.btnSalvar.setOnClickListener {this.salvar()}
        this.btnCancelar.setOnClickListener {this.finish()}


//        this.btnSalvar.setOnClickListener {
//            val intent = Intent(this, NovaCorActivity::class.java).apply { putExtra("cor", this)}
//            if (intent.resolveActivity(packageManager)!=null) {
//                startActivity(intent)
//            }
//        }



    }




    inner class OnChange: SeekBar.OnSeekBarChangeListener{
        override fun onProgressChanged(seekBar:SeekBar?, progress:Int, fromUser: Boolean){


            layout.setBackgroundColor(Color.rgb(seekRed.progress, seekGreen.progress,seekBlue.progress))
            var formato = String.format("#%02X%02X%02X", seekRed.progress, seekGreen.progress, seekBlue.progress)
            trgb.text = formato


        }

        override fun onStartTrackingTouch(seekBar: SeekBar?) {

        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {

        }
    }
    override fun onStart() {
        super.onStart()

        Log.i("APP_CORES", "main - onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_CORES", "main - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_CORES", "main - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_CORES", "main - onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_CORES", "main - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_CORES", "main - onDestroy")
    }




    private fun salvar(){
        var red = this.seekRed.progress
        var green = this.seekGreen.progress
        var blue = this.seekBlue.progress

        val cores = Cores(red, green, blue)
        val intent = Intent().apply { putExtra("CORES", cores) }
//        val intent = Intent().apply {
//            putExtra("CORES", cores)
//        }
        setResult(RESULT_OK, intent)
        this.finish()
    }


}
