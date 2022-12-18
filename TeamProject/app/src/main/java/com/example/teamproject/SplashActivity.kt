package com.example.teamproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            val intent = Intent(this, MainActivity2::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
            finish()
        },DURATION)

    }
    companion object {
        private const val DURATION : Long = 3000
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
//        // 일정 시간 지연 이후 실행하기 위한 코드
//        Handler(Looper.getMainLooper()).postDelayed({
//
//            // 일정 시간이 지나면 MainActivity로 이동
//            val intent= Intent( this,MainActivity::class.java)
//            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION)
//            startActivity(intent)
//
//            // 이전 키를 눌렀을 때 스플래스 스크린 화면으로 이동을 방지하기 위해
//            // 이동한 다음 사용안함으로 finish 처리
//            finish()
//        },DURATION)
//    }
//    companion object
//    {
//        private const val DURATION : Long = 3000
//    }
//
//    override fun onBackPressed()
//    {
//        super.onBackPressed()
//    }

}