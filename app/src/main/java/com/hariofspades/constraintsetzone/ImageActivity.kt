package com.hariofspades.constraintsetzone

import android.annotation.TargetApi
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.RequiresApi
import android.support.constraint.ConstraintLayout
import android.support.constraint.ConstraintSet
import android.transition.TransitionManager
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_image.*

@TargetApi(Build.VERSION_CODES.KITKAT)
class ImageActivity : AppCompatActivity() {

    private lateinit var parentConstraint: ConstraintLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
        addAnimationOperations()
    }

    private fun addAnimationOperations() {
        parentConstraint = findViewById(R.id.root)
        var set = false
        val constraint1 = ConstraintSet()
        constraint1.clone(parentConstraint)
        val constraint2 = ConstraintSet()
        constraint2.load(this, R.layout.activity_image_alt)
        findViewById<ImageView>(R.id.imageView).setOnClickListener{
                TransitionManager.beginDelayedTransition(parentConstraint)
                val constraint = if(set) constraint1 else constraint2
                constraint.applyTo(parentConstraint)
                set = !set
        }

    }

}
