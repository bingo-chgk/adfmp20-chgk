package ru.spbhse.bingochgk.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import kotlinx.android.synthetic.main.activity_concrete_collection.add_topic_button
import kotlinx.android.synthetic.main.activity_concrete_collection.toolbar
import kotlinx.android.synthetic.main.activity_concrete_collection.topics_list
import ru.spbhse.bingochgk.R
import ru.spbhse.bingochgk.model.Topic

class ConcreteCollectionActivity : AppCompatActivity(), OnTopicClickListener {

    private val initTopics = listOf(
        Topic("Шагреневая кожа", 10),
        Topic("Амброз Бирс", 20),
        Topic("Большая Берта", 50),
        Topic("Батори", 75),
        Topic("Рука Бога", 99),
        Topic("Бергкамп", 0),
        Topic("Гус", 88),
        Topic("Кристи", 100),
        Topic("Hello, world!", 100),
        Topic("Deus ex machine", 20),
        Topic("Гибли", 30),
        Topic("Ллойд", 25),
        Topic("Папесса Иоанна", 44)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_concrete_collection)

        val topicAdapter = TopicAdapter(this, initTopics, this)
        topics_list.adapter = topicAdapter

        toolbar.title = "Подборка 42"

        add_topic_button.setOnClickListener {
            Toast.makeText(this, "Add button", Toast.LENGTH_LONG).show()
        }
    }

    override fun onItemClick(position: Int) {
        startActivity(Intent(this, ArticleActivity::class.java))
    }

    override fun onItemLongClick(position: Int): Boolean {
        val popupMenu = PopupMenu(this, topics_list[position])
        popupMenu.menu.add("Удалить тему")
        popupMenu.menu.add("Подгрузить вопросы по теме")
        popupMenu.show()
        Toast.makeText(this, "long click ${initTopics[position].name}", Toast.LENGTH_LONG).show()
        return true
    }

    override fun onQuestionButtonClick(position: Int) {
        Toast.makeText(this, initTopics[position].name, Toast.LENGTH_LONG).show()
    }
}

