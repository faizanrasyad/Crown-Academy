package com.example.crownacademy

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.crownacademy.databinding.ActivityLoginPageBinding
import com.example.crownacademy.repos.data

class LoginPage : AppCompatActivity() {
    private lateinit var binding : ActivityLoginPageBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityLoginPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            btnLogin.setOnClickListener {
                login()
            }
            btnRegister.setOnClickListener {
                startActivity(Intent(this@LoginPage, RegisterPage::class.java))
            }
        }
    }

    private fun login() {
        binding.apply {
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

            data.namaUser = edtEmail.text.toString()
            startActivity(Intent(this@LoginPage, MainActivity::class.java))
            finish()

        }
    }


}