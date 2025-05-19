package com.example.moneyflowapp

import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val tvCriarConta = findViewById<TextView>(R.id.tvCriarConta)

        tvCriarConta.setOnClickListener {
            val intent = Intent(this, CadastroEtapa1Activity::class.java)
            startActivity(intent)
        }

        super.onCreate(savedInstanceState)

        // Carrega o layout da tela de login
        setContentView(R.layout.activity_login)

        // Pega os componentes pelo ID
        val senhaEditText = findViewById<EditText>(R.id.etSenha)
        val togglePassword = findViewById<ImageView>(R.id.ivTogglePassword)

        var senhaVisivel = false

        // Funcionalidade do olhinho
        togglePassword.setOnClickListener {
            senhaVisivel = !senhaVisivel
            if (senhaVisivel) {
                senhaEditText.inputType = InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
                togglePassword.setImageResource(R.drawable.eye_open_icon)
            } else {
                senhaEditText.inputType = InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
                togglePassword.setImageResource(R.drawable.eye_close_icon)
            }
            senhaEditText.setSelection(senhaEditText.text.length)
        }
    }
}
