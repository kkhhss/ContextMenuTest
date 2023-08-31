package kr.hs.emirim.kkhhss.contextmenutest

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
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

        linear = findViewById(R.id.linear)
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

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when(item.itemId){
            R.id.itemRed->{
                linear.setBackgroundColor(Color.RED)
                return true
            }
            R.id.itemBlue->{
                linear.setBackgroundColor(Color.BLUE)
                return true
            }
            R.id.itemYellow->{
                linear.setBackgroundColor(Color.YELLOW)
                return true
            }

            R.id.subRotate->{
                button2.rotation = 180f
                return true
            }
            R.id.subSize->{
                button2.scaleX = 2.0f
                return true
            }
            R.id.subOriginal->{
                button2.rotation = 0f
                button2.scaleX = 1.0f
                return true
            }
        }
        return false
    }
}