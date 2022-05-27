package com.risingcamp.manu.starbucksmainactivity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.risingcamp.manu.starbucksmainactivity.databinding.ActivityLoginBinding
import com.risingcamp.manu.starbucksmainactivity.databinding.ActivityMainBinding

private lateinit var binding : ActivityLoginBinding

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val signupLogin = binding.signupLogin
        val loginButton = binding.loginviewLoginBtn
        val backBtn = binding.loginBackArrow

        val data : String? = intent.extras?.getString("data_test")


        if (data != null) {
            Log.d("testt", data)
            binding.idText.setText(data)
        }

        signupLogin.apply {
            setOnClickListener {
                startActivity(
                    Intent(this@LoginActivity, SingupActivity::class.java)
                )
            }
        }

        backBtn.apply {
            setOnClickListener {
                startActivity(
                    Intent(this@LoginActivity, MainActivity::class.java)
                )
            }
        }
    }


    //현재 상태 저장장
    override fun onPause() {
        super.onPause()

        saveCurrentText()
    }

    //restoreState로 현재 상태 복구
    override fun onResume() {
        super.onResume()

        restoreIdText()

    }

    override fun onDestroy() {
        super.onDestroy()
        clearSharedPreference()
    }

    private fun saveCurrentText() {
        val sharedPreferences = getSharedPreferences("login_text", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()

        editor.putString("login_id", binding.idText.text.toString())
        editor.putString("login_pw", binding.pwText.text.toString())
        editor.apply()
    }

    private fun restoreIdText() {
        val sharedPreferences = getSharedPreferences("login_text", Context.MODE_PRIVATE)
        if (sharedPreferences.contains("login_id")) {
            val restoreIdText = sharedPreferences.getString("login_id", "Wrong ID")
            val restorePwText = sharedPreferences.getString("login_pw", "Worng PW")

            binding.idText.setText(restoreIdText)
            binding.pwText.setText(restorePwText)
        }



    }

    private fun clearSharedPreference() {
        val sharedPreferences = getSharedPreferences("login_text", Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sharedPreferences.edit()
        editor.clear()
        editor.apply()
    }
}