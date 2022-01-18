package com.kim.colosseum_kim2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kim.colosseum_kim2.adapters.TopicAdapter
import com.kim.colosseum_kim2.datas.Topic
import com.kim.colosseum_kim2.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.emailEdt
import org.json.JSONObject

class MainActivity : BaseActivity() {

    val mTopicList = ArrayList<Topic>()

    lateinit var mTopicAdapter : TopicAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

topicListView.setOnItemClickListener { parent, view, position, id ->

    val clickedTopic = mTopicList[position]

    val myIntent = Intent(mContext, ViewTopicDetailActivity::class.java)
    myIntent.putExtra("topic", clickedTopic)
    startActivity(myIntent)
}





    }

    override fun setValues() {

        getTopicListFromServer()

        mTopicAdapter = TopicAdapter(mContext, R.layout.topic_list_item, mTopicList)
        topicListView.adapter = mTopicAdapter

    }

    fun getTopicListFromServer(){

//        서버에서 주제 목록을 받아오자. => /v2/main_info = ServerUtil에 기능 추가 필요.

        ServerUtil.getRequestMainInfo(mContext, object : ServerUtil.Companion.JsonReponseHandler{
            override fun onResponse(jsonObj: JSONObject) {

//                서버에서 주메목록을 받아온 상황.

                val dataObj = jsonObj.getJSONObject("data")
                val topicsArr = dataObj.getJSONArray("topics")

//               topicArr 안에 있는 여러개의 주제들을 반복적으로 파싱. => for문을 활용하자.

//               배열에 15개의 주제 : index -> 0 ~ 14 까지
                for( index in 0 until topicsArr.length()){

//                    index위치에 맞는 주제들을 Topic클래스 현태로 변환.


                    val topicObj = topicsArr.getJSONObject(index)
                    val topicData = Topic.getTopicDataFromJson(topicObj)

//                    mTopicList 추가.
                    mTopicList.add(topicData)

                }

//                어댑터가 먼저 세팅 되고 => 나중에 목록이 추가. => 새로 고침 필요(UI 영향)

                runOnUiThread {

                    mTopicAdapter.notifyDataSetChanged()
                }






            }


        })
    }

}