package com.neppplus.librarypractice_20210824

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        profileImg.setOnClickListener {

//            프로필 사진 클릭 이벤트 => 사진 크게 보기 화면으로 이동.

            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            startActivity(myIntent)


        }

    }

    override fun setValues() {

    }


}