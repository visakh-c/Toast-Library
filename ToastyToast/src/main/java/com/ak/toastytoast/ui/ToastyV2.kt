package com.ak.toastytoast.ui

import android.content.Context
import android.graphics.Color
import android.os.Build
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.core.content.res.ResourcesCompat
import coil.loadAny
import com.ak.toastytoast.R
import com.ak.toastytoast.utils.hide
import com.ak.toastytoast.utils.show
import com.google.android.material.card.MaterialCardView


class ToastyV2(private val context: Context) {


    init {
        baseToast = Toast.makeText(context, "", duration)
    }

    //add lottie todo
    companion object {
        const val SHORT = Toast.LENGTH_SHORT
        const val LONG = Toast.LENGTH_LONG
        var baseToast: Toast? = null
        var duration: Int = SHORT
        var layout: Int = R.layout.layout_toasty2
        var tint: Int = R.color.offWhite
        var drawableLeft: Any? = null
        var drawableRight: Any? = null
        var drawableTop: Any? = null
        var drawableBottom: Any? = null
        var textColor = Color.BLACK
        var text: String? = null
        var textSize: Float = 15f
        var gravity: Int? = null
        var xOffset: Int? = null
        var yOffset: Int? = null
        var elevation: Float = 1f
        var typeface: Int? = null
        var cornerRadius: Float = 100f
        var shadowColor: Int = Color.BLACK
        var strokeColor: Int = Color.WHITE
        var strokeWidth: Int = 0

    }


    fun start() {
        val defGravity = Toast(context).gravity
        val defX = Toast(context).xOffset
        val defY = Toast(context).yOffset

        val Toasty = Toast.makeText(context, "", duration)

        val toastLayout: View =
            (context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater)
                .inflate(layout, null)
        toastLayout.background.setTint(ContextCompat.getColor(context, tint))

        val rootView = toastLayout.findViewById<MaterialCardView>(R.id.toast_root)
        rootView?.cardElevation = elevation
        rootView?.radius = cornerRadius
        rootView?.strokeWidth = strokeWidth
        rootView?.strokeColor = strokeColor

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            rootView?.outlineSpotShadowColor = shadowColor
        }

        val iconLeft = toastLayout.findViewById<ImageView>(R.id.iv_icon_left)
        val iconRight = toastLayout.findViewById<ImageView>(R.id.iv_icon_right)
        val iconTop = toastLayout.findViewById<ImageView>(R.id.iv_icon_top)
        val iconBottom = toastLayout.findViewById<ImageView>(R.id.iv_icon_bottom)
        if (drawableLeft != null) {
            iconLeft.loadAny(drawableLeft)
            iconLeft.show()
        } else {
            iconLeft.hide()
        }
        if (drawableRight != null) {
            iconRight.loadAny(drawableRight)
            iconRight.show()
        } else {
            iconRight.hide()
        }
        if (drawableTop != null) {
            iconTop.loadAny(drawableTop)
            iconTop.show()
        } else {
            iconTop.hide()
        }
        if (drawableBottom != null) {
            iconBottom.loadAny(drawableBottom)
            iconBottom.show()
        } else {
            iconBottom.hide()
        }

        val messageTextView = toastLayout.findViewById<TextView>(R.id.tv_message)
        messageTextView.setTextColor(textColor)
        messageTextView.text = text
        messageTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, textSize)

        if (typeface != null) {
            typeface?.let {
                val typeface = ResourcesCompat.getFont(context, it)
                messageTextView.typeface = typeface
            }
        } else {
            messageTextView.typeface = null
        }

        Toasty.view = toastLayout


        if (gravity == null && xOffset == null && yOffset == null) {
            Toasty.setGravity(defGravity, defX, defY)
        } else if (gravity == null && xOffset == null && yOffset != null) {
            Toasty.setGravity(defGravity, defX, yOffset!!)
        } else if (gravity == null && xOffset != null && yOffset == null) {
            Toasty.setGravity(defGravity, xOffset!!, defY)
        } else if (gravity == null && xOffset != null && yOffset != null) {
            Toasty.setGravity(defGravity, defX, yOffset!!)
        } else if (gravity != null && xOffset == null && yOffset == null) {
            Toasty.setGravity(gravity!!, defX, defY)
        } else if (gravity != null && xOffset == null && yOffset != null) {
            Toasty.setGravity(gravity!!, defX, yOffset!!)
        } else if (gravity != null && xOffset != null && yOffset == null) {
            Toasty.setGravity(gravity!!, xOffset!!, defY)
        } else if (gravity != null && xOffset != null && yOffset != null) {
            Toasty.setGravity(gravity!!, xOffset!!, yOffset!!)
        }

        Toasty.show()
    }
}