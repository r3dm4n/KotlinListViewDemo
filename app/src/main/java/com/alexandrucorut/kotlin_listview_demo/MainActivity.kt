package com.alexandrucorut.kotlin_listview_demo

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
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
        private val names = arrayListOf<String>(
                "Donald Trump", "Steve Jobs", "Tim Cook", "Mark Zuckerberg", "Barrack Obama")

        init {
            mContext = context
        }

        override fun getView(position: Int, converView: View?, viewGroup: ViewGroup?): View {

            val layoutInflator = LayoutInflater.from(mContext)

            val rowMain = layoutInflator.inflate(R.layout.main_row, viewGroup, false)

            val nameTextView = rowMain.findViewById<TextView>(R.id.name_textView)
            val positionTextView = rowMain.findViewById<TextView>(R.id.position_textView)

            nameTextView.text = names.get(position)
            positionTextView.text = "Row number: $position"


            return rowMain
        }

        override fun getItem(position: Int): Any {
            return "TEST STRING"
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getCount(): Int {
            return names.size
        }

    }
}
