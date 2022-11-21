package com.tapenjoy.actx.gogogoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.DecelerateInterpolator
import android.view.animation.RotateAnimation
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.tapenjoy.actx.R
import com.tapenjoy.actx.databinding.FragmentGameeeBinding
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameeeFragment : Fragment() {


    var alalala = false

    private val rfhtg = arrayOf(700, 1000, -100, 200, -500)
    private val sectorDegreesdfrt = rfhtg.clone()
    private val frgtgtsingleSectorDegree = 360 / rfhtg.size
    private var jkukjou = false

    private var rfrrfrr: FragmentGameeeBinding? = null
    private val jujujuju get() = rfrrfrr ?: throw RuntimeException("FragmentGameeeBinding = null")

    var ccjrjfjtjgt = 0.05f
    var gtjjth = 0.05f


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        rfrrfrr = FragmentGameeeBinding.inflate(inflater, container, false)
        return jujujuju.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        try {
            jukiklhhgdff()
            gtdgsgfug()
            vbvbvbvb()
            jujujuju.btnGoSpin.setOnClickListener {
                if (!jkukjou) {
                    fgtefrgth()
                    jkukjou = true
                }
            }
            jujujuju.btnImgRules.setOnClickListener {
                findNavController().navigate(R.id.action_gameeeFragment_to_ruuuelsFragment)
            }
            jujujuju.btnImgInfo.setOnClickListener {
                findNavController().navigate(R.id.action_gameeeFragment_to_inffffoFragment)
            }

        } catch (e: Exception) {
            frggtighj()
        }

        super.onViewCreated(view, savedInstanceState)
    }

    private fun jukiklhhgdff() {
        jujujuju.btnImgExitRaitFragment.setOnClickListener {
            ghykgjrjt()
        }
    }

    private fun fgtefrgth() {
        val winnerNumber = Random.nextInt(rfhtg.size - 1)

        val gtgtgtgt = (360 - winnerNumber * frgtgtsingleSectorDegree).toFloat()
        val jujujujuujujh = RotateAnimation(
            0f,
            (360f * rfhtg.size) + gtgtgtgt,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f,
            RotateAnimation.RELATIVE_TO_SELF,
            0.5f
        )
        jujujujuujujh.apply {
            duration = 1000
            fillAfter = true
            interpolator = DecelerateInterpolator()
            setAnimationListener(object : Animation.AnimationListener {
                override fun onAnimationStart(p0: Animation?) {
                }

                override fun onAnimationEnd(p0: Animation?) {
                    val edfrgthjk = rfhtg[winnerNumber]
                    Toast.makeText(
                        requireContext(),
                        "You winn $edfrgthjk$ points",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    jkukjou = false
                }

                override fun onAnimationRepeat(p0: Animation?) {
                }
            })
            jujujuju.imgWheelElementMain.startAnimation(jujujujuujujh)
        }
    }

    override fun onDestroy() {
        rfrrfrr = null
        super.onDestroy()
    }

    private fun vbvbvbvb() {
        for (i in rfhtg.indices) {
            sectorDegreesdfrt[i] = (i + 1) * frgtgtsingleSectorDegree
        }
    }

    private fun ghykgjrjt() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().finish()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }

    private fun gtdgsgfug() {
        if (!alalala){
            lifecycleScope.launch {
                alalala = !alalala
                while (true) {
                    jujujuju.btnGoSpin.alpha = ccjrjfjtjgt
                    if (ccjrjfjtjgt >= 1f) {
                        gtjjth = -0.05f
                    }
                    if (ccjrjfjtjgt <= 0.1f) {
                        gtjjth = 0.05f
                    }
                    delay(20)
                    ccjrjfjtjgt += gtjjth
                }
            }

        }

    }

    private fun frggtighj() {
        Snackbar.make(
            jujujuju.root,
            "There is some error, try again",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }
}