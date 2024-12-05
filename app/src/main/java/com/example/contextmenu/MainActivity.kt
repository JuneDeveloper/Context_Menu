package com.example.contextmenu

import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu

import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.annotation.IntegerRes

import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.set
import kotlin.random.Random


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var textET:EditText

    private lateinit var button:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)

        button = findViewById(R.id.buttonBNB)

        button.setOnClickListener(this)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {


        when(item.itemId) {
            R.id.menu_change_color -> {
                when (Integer.parseInt(textET.text.toString())) {
                    in 1..10 -> textET.setTextColor(Color.RED)
                    in 11..20 -> textET.setTextColor(Color.parseColor("#EF8A0D"))
                    in 21..30 -> textET.setTextColor(Color.YELLOW)
                    in 31..40 -> textET.setTextColor(Color.GREEN)
                    in 41..50 -> textET.setTextColor(Color.BLUE)
                    else -> textET.setTextColor(Color.BLACK)
                }
                Toast.makeText(this, "Меняем цвет", Toast.LENGTH_LONG).show()
            }
            R.id.menu_change_text_exit -> {
                finish()
                Toast.makeText(this,"Выход из приложения",Toast.LENGTH_SHORT).show()
            }
            else ->  return super.onContextItemSelected(item)
        }
        return true
    }
    override fun onClick(v: View) {
        val x = Random.nextInt(0,50)
        when(v.id) {
            R.id.buttonBNB -> textET.setText("$x")
        }
    }
}