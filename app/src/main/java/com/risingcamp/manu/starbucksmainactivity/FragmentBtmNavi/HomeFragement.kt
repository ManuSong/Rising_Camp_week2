package com.risingcamp.manu.starbucksmainactivity.FragmentBtmNavi


import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.risingcamp.manu.starbucksmainactivity.LoginActivity
import com.risingcamp.manu.starbucksmainactivity.SingupActivity
import com.risingcamp.manu.starbucksmainactivity.databinding.FragmentHomeBinding

private lateinit var mBinding: FragmentHomeBinding

class HomeFragement : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentHomeBinding.inflate(inflater, container, false)

        val login = mBinding.login
        val signup = mBinding.signup
        login.apply {
            setOnClickListener {
                val intent = Intent(context, LoginActivity::class.java)
                intent.putExtra("data_test", "Android A반 화이팅")
                startActivity(intent)
            }
        }

        signup.apply {
            setOnClickListener {
                it.requestFocus()
                startActivity(
                    Intent(context, SingupActivity::class.java)
                )
            }
        }

        return mBinding.root
    }


    }
