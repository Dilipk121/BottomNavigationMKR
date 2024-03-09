package com.example.bottomnavigationmkr

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.bottomnavigationmkr.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        setFragments(HomeFragment()) // set by default


        binding.bottomNavigationView.setOnItemSelectedListener(){

            when(it.itemId){
                R.id.home -> setFragments(HomeFragment())
                R.id.travel -> setFragments(TravelFragment())
                R.id.dinner -> setFragments(DinnerFragment())
                R.id.map -> setFragments(MapFragment())
                R.id.hotel -> setFragments(HotelFragment())
            }
            true
        }




    }

    private fun setFragments(fragment: Fragment){

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout,fragment)
        fragmentTransaction.commit()

        //short line of above code
/*        supportFragmentManager.beginTransaction()
            .replace(R.id.frame_layout,fragment)
            .commit()*/
    }
}