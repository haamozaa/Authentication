package com.example.firebaseauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firebaseauthentication.databinding.ActivitySignUpBinding
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)
            binding.SignIn2.setOnClickListener {
                startActivity(Intent(applicationContext,MainActivity::class.java))
            }

            binding.SignUp2.setOnClickListener {
                createUser(binding.Email2.text.toString(),binding.Pass2.text.toString())
            }

    }
    fun createUser(email:String,password:String){
        auth.createUserWithEmailAndPassword(email,password)
            .addOnCompleteListener {task->
                if (task.isSuccessful){

                    val user = auth.currentUser
                    Toast.makeText(applicationContext,"${user?.email} >> signUp success", Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext,"signUp Fail", Toast.LENGTH_SHORT).show()
                }
            }
    }
}