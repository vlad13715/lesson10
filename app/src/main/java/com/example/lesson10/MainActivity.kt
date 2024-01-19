package com.example.lesson10

import android.content.Context
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    var counter = 0




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonClak=findViewById<Button>(R.id.btnclack)
        val buttonClick = findViewById<Button>(R.id.btnclick)
        val textCounterValue = findViewById<TextView>(R.id.TvCountercValue)

        textCounterValue.text = counter.toString()

        buttonClick.setOnClickListener {
            counter += 1
            //counter = counter + 1
            textCounterValue.text = counter.toString()

            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        2000,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(2000)
            }

        }
        buttonClak.setOnClickListener {
            counter -= 1
            textCounterValue.text=counter.toString()

            val vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
            if (Build.VERSION.SDK_INT >= 26) {
                vibrator.vibrate(
                    VibrationEffect.createOneShot(
                        2000,
                        VibrationEffect.DEFAULT_AMPLITUDE
                    )
                )
            } else {
                vibrator.vibrate(2000)
            }



        }


    }
}