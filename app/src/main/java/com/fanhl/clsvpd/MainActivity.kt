package com.fanhl.clsvpd

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var guidePercent = 0f
        btn_1.setOnClickListener {
            guidePercent = if (guidePercent == 0f) 1f else 0f

            TransitionManager.beginDelayedTransition(cl_container)
            val layoutParams = gl_m.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.guidePercent = guidePercent
            gl_m.layoutParams = layoutParams
        }
    }


    private fun makeMeasureSpec(measureSpec: Int): Int {
        val mode: Int
        if (measureSpec == ViewGroup.LayoutParams.WRAP_CONTENT) {
            mode = View.MeasureSpec.UNSPECIFIED
        } else {
            mode = View.MeasureSpec.EXACTLY
        }
        return View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(measureSpec), mode)
    }
}
