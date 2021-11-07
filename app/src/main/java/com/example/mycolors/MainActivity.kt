package com.example.mycolors

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    private lateinit var layout: ConstraintLayout
    private lateinit var NovaCor: Button
    private lateinit var descricao: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("APP_CORES", "novaCor - onCreate")

//        if(intent.hasExtra(""))

        val cores = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            if(it.resultCode == RESULT_OK){
                val nova = it.data?.getSerializableExtra("CORES") as Cores
                this.layout.setBackgroundColor(Color.rgb(nova.red, nova.green, nova.blue))
                var formato = String.format("#%02X%02X%02X", nova.red, nova.green, nova.blue)
                descricao.text = formato
            }else{
                Toast.makeText(this, "Cancelou", Toast.LENGTH_SHORT).show()
            }
        }

        this.layout = findViewById(R.id.layout)
        this.NovaCor = findViewById(R.id.button)
        this.descricao = findViewById(R.id.descricao)

        this.NovaCor.setOnClickListener {
            val intent = Intent(this, com.example.mycolors.NovaCor::class.java)
            cores.launch(intent)
//            cores.launch(Intent(this, NovaCor::class.java))
//            if (intent.resolveActivity(packageManager)!=null){
//                startActivity(intent)
//            }
//            this.finish()
        }

    }

    override fun onStart() {
        super.onStart()

        Log.i("APP_CORES", "novaCor - onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.i("APP_CORES", "novaCor - onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.i("APP_CORES", "novaCor - onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.i("APP_CORES", "novaCor - onStop")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("APP_CORES", "novaCor - onRestart")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("APP_CORES", "novaCor - onDestroy")
    }


}














