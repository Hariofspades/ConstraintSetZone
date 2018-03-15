package com.hariofspades.constraintsetzone

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.support.transition.ChangeBounds
import android.support.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_nested.*

class NestedActivity : AppCompatActivity() {

    private lateinit var parentConstraint: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nested)
        parentConstraint = findViewById(R.id.nestShoppingRoot)
        setupAnimations()
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private fun setupAnimations() {
        val firstConstraint = ConstraintSet()
        firstConstraint.clone(parentConstraint)

        val secConstraint = ConstraintSet()
        secConstraint.clone(this, R.layout.activity_nested_alt)

        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()

        askSize.setOnClickListener {
            secConstraint.applyTo(parentConstraint)
            askSize.text = "ADD TO CART - 1234 INR"
            TransitionManager.beginDelayedTransition(parentConstraint, transition)
        }

        close.setOnClickListener {
            firstConstraint.applyTo(parentConstraint)
            askSize.text = "SELECT SIZE"
            TransitionManager.beginDelayedTransition(parentConstraint, transition)
        }
    }
}
