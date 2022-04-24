package com.ak.sampletoast

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.widget.Button
import android.widget.Toast
import com.ak.toastytoast.ui.Toasty
import com.ak.toastytoast.ui.Toasty.LONG
import com.ak.toastytoast.ui.Toasty.SHORT
import com.ak.toastytoast.ui.Toasty.drawable
import com.ak.toastytoast.ui.Toasty.duration
import com.ak.toastytoast.ui.Toasty.gravity
import com.ak.toastytoast.ui.Toasty.layout
import com.ak.toastytoast.ui.Toasty.text
import com.ak.toastytoast.ui.Toasty.textColor
import com.ak.toastytoast.ui.Toasty.tint
import com.ak.toastytoast.ui.Toasty.xOffset
import com.ak.toastytoast.ui.Toasty.yOffset

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById<Button>(R.id.btn_success).setOnClickListener {
            Toasty.success(this).also {
                textColor = Color.BLUE
                duration = LONG
                text = "test"
                duration = SHORT
                layout = R.layout.test
                tint = R.color.black
             //   gravity=Gravity.TOP
                yOffset=600
                drawable = R.drawable.ic_android_black_24dp
            }.show()

        }

        findViewById<Button>(R.id.btn_error).setOnClickListener {
            Toasty.error(this@MainActivity, "error", Toasty.SHORT).show()
        }

        findViewById<Button>(R.id.btn_warning).setOnClickListener {
            Toasty.warning(this@MainActivity, "warning", Toasty.SHORT).show()
        }
    }
}