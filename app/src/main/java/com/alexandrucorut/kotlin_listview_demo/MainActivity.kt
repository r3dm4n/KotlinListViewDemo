package com.alexandrucorut.kotlin_listview_demo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ListView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listView = findViewById<ListView>(R.id.main_listview)

        listView.adapter = MyCustomAdapter(this)
    }


    private class MyCustomAdapter(context: Context) : BaseAdapter() {

        private val mContext: Context

        init {
            mContext = context
        }

        override fun getView(position: Int, converView: View?, viewGroup: ViewGroup?): View {
            val textView = TextView(mContext)

            textView.text = "Here is my ROW for my ListView"

            return textView
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return 5
        }

    }
}
