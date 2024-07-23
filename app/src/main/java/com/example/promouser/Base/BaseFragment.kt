package com.example.promouser.Base

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import com.example.promouser.R
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth

abstract class BaseFragment<B : ViewBinding> : Fragment() {

    lateinit var binding: B
    lateinit var auth: FirebaseAuth
//    lateinit var database: DatabaseReference
//    lateinit var firestore: FirebaseFirestore
//    lateinit var storage: FirebaseStorage
    lateinit var loader: Dialog

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        binding = getFragmentBinding(inflater, container)

//        // Initialize Firebase Auth
//        auth = Firebase.auth
//        database = FirebaseDatabase.getInstance().reference
//        firestore = Firebase.firestore
//        storage = Firebase.storage

        dialogShow()
        return binding.root
    }

    abstract fun getFragmentBinding(inflater: LayoutInflater, container: ViewGroup?): B

    fun isValidPhoneNumber(phoneNumber: String): Boolean {
        val phonePattern = Patterns.PHONE // Android's built-in phone number pattern
        return phonePattern.matcher(phoneNumber).matches()
    }

    fun dialogShow() {
        loader = Dialog(requireContext())
        loader.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        loader.setContentView(R.layout.layout_loader)
        loader.setCancelable(true)
    }

    fun showErrorSnackBar(message: String, errorMessage: Boolean) {
        val snackBar =
            Snackbar.make((requireActivity().findViewById(android.R.id.content)), message, Snackbar.LENGTH_LONG)
        val snackBarView = snackBar.view

        if (errorMessage) {
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.colorSnackBarError
                )
            )
        }else{
            snackBarView.setBackgroundColor(
                ContextCompat.getColor(
                    requireContext(),
                    R.color.colorSnackBarSuccess
                )
            )
        }
        snackBar.show()
    }



}