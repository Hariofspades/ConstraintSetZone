package com.hariofspades.constraintsetzone

import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintSet
import android.transition.ChangeBounds
import android.transition.TransitionManager
import android.view.animation.OvershootInterpolator
import kotlinx.android.synthetic.main.activity_shopping.*

@RequiresApi(Build.VERSION_CODES.KITKAT)
class ShoppingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)
        setupAnimations()
    }

    private fun setupAnimations() {
        askSize.setOnClickListener {
            updateConstraints(R.layout.activity_shopping_alt)
            askSize.text = "ADD TO CART - 1234 INR"
        }

        close.setOnClickListener {
            updateConstraints(R.layout.activity_shopping)
            askSize.text = "SELECT SIZE"
        }
    }


    fun updateConstraints(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(shoppingRoot)
        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(shoppingRoot, transition)
    }
}
