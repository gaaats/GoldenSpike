package com.tapenjoy.actx.gogogoa

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.tapenjoy.actx.databinding.FragmentInffffoBinding

class InffffoFragment : Fragment() {
    private var gthgthhth: FragmentInffffoBinding? = null
    private val kpkpkppk get() = gthgthhth ?: throw RuntimeException("FragmentSomeRulesBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        gthgthhth = FragmentInffffoBinding.inflate(inflater, container, false)
        return kpkpkppk.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            kpkpkppk.root.background.alpha = 215

            kpkpkppk.btnImgExitInfo.setOnClickListener {
                gthjiyjjyhi()
            }
            kpkpkppk.btnUnderstandGameRules.setOnClickListener {
                requireActivity().onBackPressed()
            }

        } catch (e: Exception) {
            snsnsnsns()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        gthgthhth = null
        super.onDestroy()
    }



    private fun snsnsnsns() {
        Snackbar.make(
            kpkpkppk.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }

    private fun gthjiyjjyhi() {
        AlertDialog.Builder(requireContext())
            .setTitle("Exit")
            .setMessage("Current data will not be saved, EXIT?")
            .setPositiveButton("Yes, Exit") { _, _ ->
                requireActivity().onBackPressed()
            }
            .setNegativeButton("No") { _, _ ->
            }
            .setCancelable(true)
            .create()
            .show()
    }


}