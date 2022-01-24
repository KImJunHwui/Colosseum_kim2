package com.kim.colosseum_kim2.datas

import org.json.JSONObject

class Reply {

    var id = 0
    var content = ""

    companion object{

        fun getReplyFromJson(jsonObj : JSONObject) : Reply{
            val resultReply = Reply()

            resultReply.id = jsonObj.getInt("id")
            resultReply.content = jsonObj.getString("content")

            return resultReply
        }

    }

}