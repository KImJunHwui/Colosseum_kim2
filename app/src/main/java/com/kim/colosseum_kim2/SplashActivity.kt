package com.kim.colosseum_kim2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.kim.colosseum_kim2.utils.ContextUtil

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

//        3초 후에 검사 -> 저장된 토큰이 있는지? ""(빈칸)인지?

        val myHandler = Handler(Looper.getMainLooper())

        myHandler.postDelayed({

           if (ContextUtil.getToken(mContext) == ""){

//               저장된 토큰이 없다 => 로그인을 해야한다.

               val myIntent = Intent(mContext, LoginActivity::class.java)
               startActivity(myIntent)

           }

            else{

//                저장된 토근이 있다 =? 로그인이 되어 있다 => 메인 화면으로 이동.
                val myIntent = Intent(mContext, MainActivity::class.java)
               startActivity(myIntent)
            }

            finish()
        }, 3000)
            }


}