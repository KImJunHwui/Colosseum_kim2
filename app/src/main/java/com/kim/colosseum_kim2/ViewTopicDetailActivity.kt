package com.kim.colosseum_kim2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.kim.colosseum_kim2.datas.Topic
import com.kim.colosseum_kim2.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_view_topic_detail.*
import org.json.JSONObject

class ViewTopicDetailActivity : BaseActivity() {

    lateinit var mTopic : Topic

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_topic_detail)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

    }

    override fun setValues() {

        mTopic = intent.getSerializableExtra("topic") as Topic
        topicTitleTxt.text = mTopic.title
        Glide.with(mContext).load(mTopic.imageURL).into(topicImg)

//      현재 투표 현황을 다시 서버에서 받아오자.

        getTopicDetailFromSever()

    }


    fun getTopicDetailFromSever(){

        ServerUtil.getRequestTopicDetail(mContext, mTopic.id, object :  ServerUtil.Companion.JsonReponseHandler{
            override fun onResponse(jsonObj: JSONObject) {

            }


        })



    }
}