package com.example.parimpar_wagner

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    var resultado = 0
    private var score = 0
    lateinit var txtResultado: TextView
    lateinit var txtScore: TextView
    lateinit var btnNovo: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inicialização dos componentes da UI
        txtResultado = findViewById(R.id.txtResultado)
        txtScore = findViewById(R.id.txtScore)
        btnNovo = findViewById(R.id.btnNovo)

        // Dispara a função de inicialização
        novoJogo()
    }

    private fun novoJogo(){
        txtResultado.text = "Par ou Ímpar"
        resultado = Random.nextInt(0,99)
        btnNovo.visibility = View.INVISIBLE
    }

    fun novoJogo(view: View){
        novoJogo()
    }

    fun jogada(view: View){
        if(resultado % 2 == view.tag.toString().toInt())
            if (btnNovo.visibility == View.INVISIBLE) {
                score++
                getPreferences(MODE_PRIVATE).edit().putInt("SCORE", score).commit() // salvar
            }

        txtScore.text = "Score: $score"
        txtResultado.text = "$resultado"

        if (resultado % 5 == 0){
            Toast.makeText(/* context = */ this@MainActivity, /* text = */
                "Múltiplo de 5", /* duration = */
                Toast.LENGTH_SHORT).show()
        }

        if (resultado % 10 == 0){
            Toast.makeText(/* context = */ this@MainActivity, /* text = */
                "Múltiplo de 10", /* duration = */
                Toast.LENGTH_SHORT).show()
        }

        btnNovo.visibility = View.VISIBLE
    }
}