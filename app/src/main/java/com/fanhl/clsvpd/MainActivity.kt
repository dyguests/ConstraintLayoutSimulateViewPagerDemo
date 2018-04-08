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

//        cl_container.viewTreeObserver
//        cl_container.measure(makeMeasureSpec(cl_container.width), makeMeasureSpec(cl_container.height))
//        cl_l.layoutParams = cl_l.layoutParams.apply {
//            width = cl_container.width
//        }
//        cl_r.layoutParams = cl_r.layoutParams.apply {
//            width = cl_container.width
//        }

        var guidePercent = 0f
        btn_1.setOnClickListener {
            guidePercent = if (guidePercent == 0f) 1f else 0f

            TransitionManager.beginDelayedTransition(cl_container)
            val layoutParams = guideline.layoutParams as ConstraintLayout.LayoutParams
            layoutParams.guidePercent = guidePercent
            guideline.layoutParams = layoutParams
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
