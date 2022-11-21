package com.tapenjoy.actx.gogogoa

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import com.google.android.material.snackbar.Snackbar
import com.tapenjoy.actx.databinding.FragmentRuuuelsBinding


class RuuuelsFragment : Fragment() {
    private var jullulujp: FragmentRuuuelsBinding? = null
    private val hyh get() = jullulujp ?: throw RuntimeException("FragmentSomeRulesBinding = null")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        jullulujp = FragmentRuuuelsBinding.inflate(inflater, container, false)
        return hyh.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        try {
            hyh.root.background.alpha = 215

            hyh.btnImgExitRulesGame.setOnClickListener {
                erfrgthyinitAlertDialog()
            }
            hyh.btnUnderstand.setOnClickListener {
                requireActivity().onBackPressed()
            }

        } catch (e: Exception) {
            gygygyg()
        }


        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroy() {
        jullulujp = null
        super.onDestroy()
    }

    private fun erfrgthyinitAlertDialog() {
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

    private fun gygygyg() {
        Snackbar.make(
            hyh.root,
            "Oops something went wrong, please try again...",
            Snackbar.LENGTH_LONG
        ).show()
        requireActivity().onBackPressed()
    }


}