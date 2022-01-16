package com.kim.colosseum_kim2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kim.colosseum_kim2.datas.Topic
import com.kim.colosseum_kim2.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlinx.android.synthetic.main.activity_sign_up.emailEdt
import org.json.JSONObject

class MainActivity : BaseActivity() {

    val mTopicList = ArrayList<Topic>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {



    }

    override fun setValues() {

        getTopicListFromServer()

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



//                    mTopicList 추가.

                }





            }


        })
    }

}