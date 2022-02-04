package com.kim.colosseum_kim2

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toolbar
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity : AppCompatActivity(){

    lateinit var backBtn : ImageView

    val mContext = this

    abstract fun setupEvents()
    abstract fun setValues()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        액션바가 있는 화면만, 커스텀액션바 세팅 실행.

        supportActionBar?.let {
            setCustomActionBar()
        }


    }

    fun setCustomActionBar(){

        val defaultActionBar = supportActionBar!!
        defaultActionBar.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        defaultActionBar.setCustomView(R.layout.my_custom_action_bar)

        val myToolbar = defaultActionBar.customView.parent as androidx.appcompat.widget.Toolbar
        myToolbar.setContentInsetsAbsolute(0,0)

        backBtn = defaultActionBar.customView.findViewById(R.id.backBtn)
        backBtn.setOnClickListener {

            finish()
        }



    }

    }

