package com.example.compose.lazycolumn.bug

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.core.view.postDelayed

class FiveSecondsTextView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = -1
) : TextView(context, attrs, defStyleAttr) {

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        postDelayed(5000L) {
            visibility = GONE
        }
    }
}
