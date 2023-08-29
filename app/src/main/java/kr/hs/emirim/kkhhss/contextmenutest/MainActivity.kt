package kr.hs.emirim.kkhhss.contextmenutest

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.View
import android.widget.Button
import android.widget.LinearLayout

class MainActivity : AppCompatActivity() {
    lateinit var linear : LinearLayout
    lateinit var button1 : Button
    lateinit var button2 : Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        linear = findViewById<LinearLayout>(R.id.linear)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        registerForContextMenu(button1)
        registerForContextMenu(button2)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?) {
        super.onCreateContextMenu(menu, v, menuInfo)
        var mInflater = this.menuInflater
        if(v === button1){
            menu!!.setHeaderTitle("배경색 변경")
            mInflater.inflate(R.menu.menu1, menu)
        }
        if(v === button2){
            menu!!.setHeaderTitle("버튼 변경")
            mInflater.inflate(R.menu.menu2, menu)
        }
    }
}