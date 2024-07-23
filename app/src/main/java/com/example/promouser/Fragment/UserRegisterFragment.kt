package com.example.promouser.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.promouser.Base.BaseFragment
import com.example.promouser.R
import com.example.promouser.databinding.FragmentUserRegisterBinding


class UserRegisterFragment : BaseFragment<FragmentUserRegisterBinding>() {
    override fun getFragmentBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentUserRegisterBinding   = FragmentUserRegisterBinding.inflate(layoutInflater)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}