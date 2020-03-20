package com.example.lab3kotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var lv: ListView? = null
    private var mAdapter: CustomAdapter? = null  //Adapter

    //add data to list
    private val imageUserArrayList: ArrayList<User> = arrayListOf(
    User(
    "Anna Bezeka", "A person who does not like to go out or be with " +
    "people much, you can use the word introvert. If that person doesn’t talk a lot " +
    "and doesn’t seem comfortable around others, they might be shy. People who " +
    "love company and parties are extroverts. They are often easy-going, meaning " +
    "not much bothers them.", R.drawable.photo1
    ),
    User(
    "Alex Petrov",
    "He had long been an idol of mine before I had " +
    "the opportunity to meet her personally. I have been a member of one of her " +
    "international Jane-Goodall-Institutes (JGI) for a couple of years now. ",
    R.drawable.photo2
    ),
    User(
    "Bohdan Marchenko", "Now it is your turn to think of a person you " +
    "admire and to describe the influence he/she had on you or the world. Try to " +
    "use very descriptive adjectives and possibly look up some in either a dictionary " +
    "or translator to add them to your active vocabulary.", R.drawable.photo3
    ),
    User(
    "Maria Tkachenko", "Mary is as beautiful as a Hollywood star. " +
    "Her thick, wavy, long black hair gracefully falls down to her shoulders " +
    "and encircles her diamond-shaped face. A golden suntan usually brings out " +
    "her smooth, clear complexion and high cheek bones. ", R.drawable.photo4
    ),
    User(
    "Andrew Kompaniets", "A person is good at making people laugh, " +
    "they are funny. If they’re funny in a clever (smart) way, they’re witty. " +
    "Some people don’t like to laugh a lot, and are very serious instead. " +
    "Sometimes serious people can seem boring.", R.drawable.photo5
    ),
    User(
    "Vlada Pilipenko",
    "UI designer. Her slightly arched chestnut brown " +
    "eyebrows highlight her emotions by moving up and down as she reacts to her world " +
    "around her. Her large deep blue eyes, remind me of a lake on a stormy day.",
    R.drawable.photo6
    )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //find ListView
        lv = findViewById(R.id.userListView)

       //imageUserArrayList = populateList()
        Log.d("Hello", imageUserArrayList.size.toString() + "")
        mAdapter = CustomAdapter(this, imageUserArrayList)
        lv!!.adapter = mAdapter

            userListView!!.onItemClickListener =
                AdapterView.OnItemClickListener { parent, view, position, id -> // TODO Auto-generated method stub
                    // Getting listView click value into String variable.
                    val tempListViewClickedValue = imageUserArrayList[position]
                    val intent = Intent(this@MainActivity, InfoActivity::class.java)

                    // Sending value to another activity using intent.
                    intent.putExtra("name", tempListViewClickedValue.userName)
                    intent.putExtra("details",tempListViewClickedValue.userDescription)
                    intent.putExtra("image",tempListViewClickedValue.imageDrawable)
                    //start activity  "InfoActivity"
                    startActivity(intent)
                }
        }

}



