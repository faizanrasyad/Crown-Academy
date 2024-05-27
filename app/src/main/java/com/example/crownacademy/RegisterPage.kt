package com.example.crownacademy

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crownacademy.databinding.ActivityRegisterPageBinding

class RegisterPage : AppCompatActivity() {
    private lateinit var binding : ActivityRegisterPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityRegisterPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnLogin.setOnClickListener {
                startActivity(Intent(this@RegisterPage, LoginPage::class.java))
                finish()
            }
            btnDaftar.setOnClickListener {
                daftar()
            }
        }
    }

    fun daftar(){
        binding.apply {

            if(edtNama.text.isEmpty()){
                edtNama.setError("Nama harus terisi!")
                return
            }
            if(edtEmail.text.isEmpty()){
                edtEmail.setError("Email harus terisi!")
                return
            }
            if(!edtEmail.text.contains('@')){
                edtEmail.setError("Format email salah!")
                return
            }
            if(edtPassword.text.isEmpty()){
                edtPassword.setError("Password harus terisi!")
                return
            }

            Toast.makeText(this@RegisterPage, "Anda telah terdaftar! Selamat datang, ${edtNama.text}", Toast.LENGTH_SHORT)
            startActivity(Intent(this@RegisterPage, LoginPage::class.java))
            finish()

        }
    }
}