package com.kim.colosseum_kim2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kim.colosseum_kim2.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.emailEdt

class MainActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {



    }

    override fun setValues() {

    }

}