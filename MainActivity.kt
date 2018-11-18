package com.livrokotlin.pablopestana.calculoaposentadoria

import android.os.Build
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.v7.app.AppCompatActivity
import android.widget.*

class MainActivity : AppCompatActivity() {

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //acessando o elemento spinner (dropdown)
        val spn_sexo = findViewById<Spinner>(R.id.spn_sexo)

        //acessando o editText com a idade digitada
        val txt_idade = findViewById<EditText>(R.id.txt_idade)

        //acessando o botão calcular
        val btn_calcular = findViewById<Button>(R.id.btn_calcular)

        //acessando o texto de resultado
        val txt_resultado = findViewById<TextView>(R.id.txt_resultado)

        spn_sexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Masculino","Feminino"))

        btn_calcular.setOnClickListener{
            //Aqui vai o código que será executado quando houver um click no botão
            val sexo_selecionado = spn_sexo.selectedItem as String

            //captura a idade digitada e transforma em inteiro
            val idade_digitada = txt_idade.text.toString().toInt()

            var resultado : Int = 0

            if(sexo_selecionado == "Masculino"){
                //calculo para homem
                resultado = 65 - idade_digitada
            }else{
                //calculo para mulher
                resultado = 60 - idade_digitada
            }

            if(resultado < 0){
                resultado = resultado * (-1)
                txt_resultado.setText("Você já deveria estar aposentado há $resultado anos!")

            }else{
                txt_resultado.setText("Faltam $resultado anos para sua aposentadoria!")
            }
        }
    }


}
