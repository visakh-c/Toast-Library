package com.ak.sampletoast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.ak.toastytoast.ui.Toasty
import com.ak.toastytoast.ui.ToastyV2

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_success).setOnClickListener {
            ToastyV2(this@MainActivity).apply {
                ToastyV2.text = "Hi I'm Testing"
                ToastyV2.drawableLeft= R.drawable.ic_android_black_24dp
            }.start()
            //todo make enum classes
        }

        findViewById<Button>(R.id.btn_error).setOnClickListener {
            Toasty.error(this@MainActivity, "error", Toasty.SHORT).show()
        }

        findViewById<Button>(R.id.btn_warning).setOnClickListener {
            Toasty.warning(this@MainActivity, "warning", Toasty.SHORT).show()
        }
    }
}