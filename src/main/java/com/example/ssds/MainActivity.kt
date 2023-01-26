package com.example.ssds

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ssds.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binging: ActivityMainBinding;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binging.root)
        binging.calc.setOnClickListener { factorial() }
    }

    private fun factorial() {
        val str = binging.edit.text.toString();
        if (str.length == 0) {
            Toast.makeText(this, "Некорректный формат", Toast.LENGTH_SHORT).show()
            return
        }
        val number = Integer.parseInt(str)
        if (number < 0) {
            Toast.makeText(this, "Число меньше 0", Toast.LENGTH_SHORT).show()
        } else {
            binging.result.text = calculate(number).toString()
        }

    }
    private fun calculate(number: Int): Int {
        var res: Int = 1;
        for (i in 1..number) {
            res *= i;
        }
        return res;
    }
}