package com.kim.colosseum_kim2.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.kim.colosseum_kim2.R
import com.kim.colosseum_kim2.datas.Topic

class TopicAdapter(
    val mContext : Context,
    resId : Int,
    val mList : List<Topic> ) : ArrayAdapter<Topic>(mContext, resId,mList) {

    val mInflater = LayoutInflater.from(mContext)


    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var tempRow = convertView
        if(tempRow == null){
            tempRow = mInflater.inflate(R.layout.topic_list_item, null)

        }

        val row = tempRow!!

        return row

    }
}