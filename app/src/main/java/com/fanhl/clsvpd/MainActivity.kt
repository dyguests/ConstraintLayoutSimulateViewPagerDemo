package com.fanhl.clsvpd

import android.os.Build
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.v7.app.AppCompatActivity
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.partial_main_bottom.*

class MainActivity : AppCompatActivity() {
    private val constraint1 by lazy {
        ConstraintSet().apply {
            clone(cl_container as ConstraintLayout)
        }
    }
    private val constraint2 by lazy {
        ConstraintSet().apply {
            clone(this@MainActivity, R.layout.partial_main_bottom_alt)
        }
    }

    var status = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var guidePercent = 1f
        btn_1.setOnClickListener {
            guidePercent = if (guidePercent == 0f) 1f else 0f

            TransitionManager.beginDelayedTransition(cl_container as ConstraintLayout)
            gl_l.apply {
                this.layoutParams = (this.layoutParams as ConstraintLayout.LayoutParams).apply {
                    this.guidePercent = guidePercent - 1f
                }
            }
            gl_m.apply {
                this.layoutParams = (this.layoutParams as ConstraintLayout.LayoutParams).apply {
                    this.guidePercent = guidePercent
                }
            }
            gl_r.apply {
                this.layoutParams = (this.layoutParams as ConstraintLayout.LayoutParams).apply {
                    this.guidePercent = guidePercent + 1f
                }
            }
        }

//        btn_1.setOnClickListener { changeStatus() }
    }

    private fun changeStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            status = !status
            TransitionManager.beginDelayedTransition(cl_container as ConstraintLayout)
            val constraint = if (status) constraint2 else constraint1
            constraint.applyTo(cl_container as ConstraintLayout)
        } else {
            //去掉动画
        }
    }
}
