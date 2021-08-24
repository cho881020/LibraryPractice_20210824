package com.neppplus.librarypractice_20210824

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

//            TedPermission 라이브러리 활용 -> 권한 여부 대응 + 실제 체크

            val pl = object : PermissionListener {

                override fun onPermissionGranted() {

//                    권한 승인되었을때 실행할 코드를 적는부분.

//                    전화 연결 (CALL) 활용.
                    val myUri = Uri.parse("tel:02-5555-8888")
                    val myIntent = Intent( Intent.ACTION_CALL, myUri )
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

//                    토스트로 권한이 막혀서 못쓴다는 안내.
                    Toast.makeText(mContext, "권한이 거부되어 전화연결이 불가합니다.", Toast.LENGTH_SHORT).show()

                }


            }


//            실제로 권한 확인 : Manifest에도 적어두고 + 코틀린에서도 확인.

//             => 라이브러리 문제로 현재 작업 불가.




        }

        profileImg.setOnClickListener {

//            프로필 사진 클릭 이벤트 => 사진 크게 보기 화면으로 이동.

            val myIntent = Intent(mContext, ViewPhotoActivity::class.java)
            startActivity(myIntent)


        }

    }

    override fun setValues() {

//        최근 활동 사진을 -> 인터넷에서 곧바로 다운받아 앱에서 보여주기.
//         drawable에 붙여넣는 작업 없이 진행.

        Glide.with(mContext).load("https://cdn.topstarnews.net/news/photo/201912/714847_426867_3336.jpeg").into(recentImg)


    }


}