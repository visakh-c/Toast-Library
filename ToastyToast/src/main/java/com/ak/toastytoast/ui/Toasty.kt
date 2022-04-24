package com.ak.toastytoast.ui

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import coil.loadAny
import com.ak.toastytoast.R
import com.ak.toastytoast.utils.show

object Toasty {
    const val SHORT = Toast.LENGTH_SHORT
    const val LONG = Toast.LENGTH_LONG


    var duration: Int = SHORT
    var layout: Int = R.layout.layout_toasty
    var tint: Int = R.color.white
    var drawable: Any? = null
    var textColor = Color.BLACK
    var text: String? = null
    lateinit var toast: Toast
    var gravity: Int? = null /*toast?.gravity*/
    var xOffset: Int? = null /*toast?.xOffset*/
    var yOffset: Int? = null /*toast?.yOffset*/


    private var lastToast: Toast? = null
    private const val allowQueue = true


    @SuppressLint("InflateParams")
    fun success(
        context: Context
    ): Toast {
        val baseToast = Toast.makeText(context, "", duration)

        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(layout, null)
        toastLayout.background.setTint(ContextCompat.getColor(context, tint))

        val iconView = toastLayout.findViewById<ImageView>(R.id.iv_icon)
        if (drawable != null) {
            iconView.loadAny(drawable)
            iconView.show()
        }

        val messageTextView = toastLayout.findViewById<TextView>(R.id.tv_message)
        messageTextView.setTextColor(textColor)
        messageTextView.text = text

        baseToast.view = toastLayout


        toast = Toast(context)





        if (gravity == null && xOffset == null && yOffset == null) {
            baseToast.setGravity(Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM, 0, 0)

        } else if (gravity == null && xOffset == null && yOffset != null) {
            baseToast.setGravity(Gravity.BOTTOM, toast.xOffset, yOffset!!)

        } else if (gravity == null && xOffset != null && yOffset == null) {
            baseToast.setGravity(Gravity.BOTTOM, xOffset!!, toast.yOffset)

        } else if (gravity == null && xOffset != null && yOffset != null) {
            baseToast.setGravity(Gravity.BOTTOM, toast.xOffset, yOffset!!)

        } else if (gravity != null && xOffset == null && yOffset == null) {
            baseToast.setGravity(gravity!!, toast.xOffset, toast.yOffset)

        } else if (gravity != null && xOffset == null && yOffset != null) {
            baseToast.setGravity(gravity!!, toast.xOffset, yOffset!!)

        } else if (gravity != null && xOffset != null && yOffset == null) {
            baseToast.setGravity(gravity!!, xOffset!!, toast.yOffset)

        } else if (gravity != null && xOffset != null && yOffset != null) {
            baseToast.setGravity(gravity!!, xOffset!!, yOffset!!)

        }

        if (allowQueue) {
            if (lastToast != null) lastToast?.cancel()
            lastToast = baseToast
        }
        return baseToast
    }

    /*fun success(
        context: Context,
        text: String,
        duration: Int = SHORT,
        customLayout: Int = R.layout.layout_toasty,
        tint: String = "#4CAF50"
    ): Toast {
        val currentToast = Toast.makeText(context, "", duration)

        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(customLayout, null)

        toastLayout.background.setTint(Color.parseColor(tint))

        val icon = toastLayout.findViewById<ImageView>(R.id.iv_icon)
        val messageTextView = toastLayout.findViewById<TextView>(R.id.tv_message)
        messageTextView.text = text

        currentToast.view = toastLayout

        if (allowQueue) {
            if (lastToast != null) lastToast?.cancel()
            lastToast = currentToast
        }

        return currentToast
    }
*/
    fun error(context: Context, message: String, duration: Int): Toast {
        val currentToast = Toast.makeText(context, "", duration)
        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.layout_toasty, null)

        toastLayout.background.setTint(ContextCompat.getColor(context, R.color.red))
        val icon = toastLayout.findViewById<ImageView>(R.id.iv_icon)
        val messageTextView = toastLayout.findViewById<TextView>(R.id.tv_message)
        messageTextView.text = message

        currentToast.view = toastLayout
        if (allowQueue) {
            if (lastToast != null) lastToast?.cancel()
            lastToast = currentToast
        }

        return currentToast
    }

    fun warning(context: Context, message: String, duration: Int): Toast {
        val currentToast = Toast.makeText(context, "", duration)
        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(R.layout.layout_toasty, null)

        toastLayout.background.setTint(ContextCompat.getColor(context, R.color.yellow))
        val icon = toastLayout.findViewById<ImageView>(R.id.iv_icon)
        val messageTextView = toastLayout.findViewById<TextView>(R.id.tv_message)
        messageTextView.text = message

        currentToast.view = toastLayout
        if (allowQueue) {
            if (lastToast != null) lastToast?.cancel()
            lastToast = currentToast
        }

        return currentToast
    }
}