package com.risingcamp.manu.starbucksmainactivity

import android.Manifest
import android.content.DialogInterface
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AlertDialog
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.risingcamp.manu.starbucksmainactivity.FragmentBtmNavi.*
import com.risingcamp.manu.starbucksmainactivity.databinding.ActivityMainBinding

private lateinit var binding : ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initNavigationBar()

    }

    fun initNavigationBar() {
        binding.mainBtmNavi.run {
            setOnItemSelectedListener {
                when (it.itemId) {
                    R.id.home_btm -> {
                        changeFragment(HomeFragement())
                    }

                    R.id.pay_btm -> {
                        changeFragment(PayFragement())
                    }

                    R.id.gift_btm -> {
                        changeFragment(GiftFragment())
                    }

                    R.id.order_btm -> {
                        changeFragment(OrderFragment())
                    }

                    else -> changeFragment(OtherFragment())
                }
                true
            }
            selectedItemId = R.id.home_btm
        }
    }

    private fun changeFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.container.id, fragment)
            .commit()
    }


    // Location Permission 확인! onStart에서
    @RequiresApi(Build.VERSION_CODES.Q)
    override fun onStart() {
        super.onStart()
        val locationPermissionRequest = registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permissions ->
            when {
                permissions.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    // Precise location access granted.
                }
                permissions.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    // Only approximate location access granted.
                } else -> {
                // No location access granted.
                permissions.getOrDefault(Manifest.permission.ACCESS_BACKGROUND_LOCATION, false)
            }
            }
        }

// ...

// Before you perform the actual permission request, check whether your app
// already has the permissions, and whether your app needs to show a permission
// rationale dialog. For more details, see Request permissions.
        locationPermissionRequest.launch(arrayOf(
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION,
            Manifest.permission.ACCESS_BACKGROUND_LOCATION
        ))

    }




    private fun AlertDialogTest() {
        val bulider = AlertDialog.Builder(this)

        bulider.setTitle("실행")
            .setMessage("다시 돌아온 것을 환영합니다.")
            .setPositiveButton("앱 종료", DialogInterface.OnClickListener{dialog, id ->
                ActivityCompat.finishAffinity(this)
                System.exit(0)
            }).setNegativeButton("아니요", DialogInterface.OnClickListener{dialog, id ->
            })

        val alertDialog = bulider.create()

        alertDialog.show()
    }
}


