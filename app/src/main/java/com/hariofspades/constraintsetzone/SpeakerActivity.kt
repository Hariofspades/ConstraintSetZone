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
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_speaker.*

@RequiresApi(Build.VERSION_CODES.KITKAT)
class SpeakerActivity : AppCompatActivity() {

    var flag: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_speaker)
        Glide.with(this).load(R.drawable.hari_square).into(droidconImg)
        droidconImg.setOnClickListener {
            if(!flag) {
                updateConstraints(R.layout.activity_speaker_alt)
                flag = true
            } else {
                updateConstraints(R.layout.activity_speaker)
                flag = false
            }
        }
    }

    fun updateConstraints(@LayoutRes id: Int) {
        val newConstraintSet = ConstraintSet()
        newConstraintSet.clone(this, id)
        newConstraintSet.applyTo(speakerRoot)
        val transition = ChangeBounds()
        transition.interpolator = OvershootInterpolator()
        TransitionManager.beginDelayedTransition(speakerRoot, transition)
    }

}
