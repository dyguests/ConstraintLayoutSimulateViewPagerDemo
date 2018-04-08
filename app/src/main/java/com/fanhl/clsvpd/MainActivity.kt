package com.fanhl.clsvpd

import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var guidePercent = 0f
        btn_1.setOnClickListener {
            guidePercent = if (guidePercent == 0f) 1f else 0f

            TransitionManager.beginDelayedTransition(cl_container)
            val layoutParams = guideline.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.guidePercent = guidePercent
            guideline.layoutParams = layoutParams
        }
    }
}
