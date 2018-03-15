package com.hariofspades.constraintsetzone

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_carousel.*

@RequiresApi(Build.VERSION_CODES.KITKAT)
class CarouselActivity : AppCompatActivity() {

    private var selectedView: View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupFullScreen()
        setContentView(R.layout.activity_carousel)
        setupAnimations()
    }

    private fun setupFullScreen() {
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN)
    }

    private fun setupAnimations() {
        selectedView  = null

        root.setOnClickListener{
            toDefault()
        }

        javaImg.setOnClickListener {
            if (selectedView != javaImg){
                updateConstraints(R.layout.activity_carousel_java)
                selectedView = javaImg
            }else
                toDefault()
        }

        kotlinImg.setOnClickListener {
            if (selectedView != kotlinImg){
                updateConstraints(R.layout.activity_carousal_kotlin)
                selectedView = kotlinImg
            }else
                toDefault()
        }
    }

    private fun toDefault() {
        if (selectedView != null) {
            updateConstraints(R.layout.activity_carousel)
            selectedView = null
        }
    }


    private fun updateConstraints(@LayoutRes id: Int) {

        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(root)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(root, transition)
    }
}
