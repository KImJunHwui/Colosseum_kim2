package com.kim.colosseum_kim2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kim.colosseum_kim2.datas.Side
import com.kim.colosseum_kim2.utils.ServerUtil
import kotlinx.android.synthetic.main.activity_edit_reply.*
import org.json.JSONObject

class EditReplyActivity : BaseActivity() {

    lateinit var mSelectedSide : Side

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_reply)
        setValues()
        setupEvents()
    }

    override fun setupEvents() {

        okBtn.setOnClickListener {

            val inputContent = contentEdt.text.toString()

            ServerUtil.postRequestReply(mContext, mSelectedSide.topicId, inputContent, object : ServerUtil.Companion.JsonReponseHandler{
                override fun onResponse(jsonObj: JSONObject) {

                val code = jsonObj.getInt("code")

                    if(code == 200){

                        runOnUiThread {

                             Toast.makeText(mContext, "의견 등록해 성공했습니다", Toast.LENGTH_SHORT).show()
                             finish()
                         }
                         
                    }
                    else{
                        val message = jsonObj.getString("message")
                        runOnUiThread {

                            Toast.makeText(mContext,message, Toast.LENGTH_SHORT).show()
                        }

                    }
                }

            })

        }

    }

    override fun setValues() {

        mSelectedSide = intent.getSerializableExtra("my_side") as Side
        mySelectedSideTxt.text = mSelectedSide.title


    }


}