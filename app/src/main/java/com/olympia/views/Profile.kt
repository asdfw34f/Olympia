package com.olympia.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.olympia.R
import com.olympia.databinding.FragmentProfileBinding
import com.olympia.extensions.toMainScreen
import com.olympia.viewModels.AccountInf

class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val dataModel: AccountInf by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        if (dataModel.userName.value?.isNotEmpty() == true){
            binding.BLogInOnProfile.text = getString(R.string.go_back)
            binding.BSignUpOnProfile.visibility = View.GONE
            dataModel.userName.observe(activity as LifecycleOwner) { binding.UserNameOnProfile.text = it }
            dataModel.password.observe(activity as LifecycleOwner) { binding.PasswordOnProfile.text = it }
            dataModel.gender.observe(activity as LifecycleOwner) { binding.GenderOnProfile.text = it }
            dataModel.dataOfBirth.observe(activity as LifecycleOwner) { binding.BirthdayOnProfile.text = it }
            dataModel.email.observe(activity as LifecycleOwner) { binding.EmailOnProfile.text = it }
        } else {
            binding.TitleUNOnProfile.visibility = View.GONE
            binding.TitlePasswordOnProfile.visibility = View.GONE
            binding.TitleGenderOnProfile.visibility = View.GONE
            binding.TitleBirthdayOnProfile.visibility = View.GONE
            binding.TitleEmailOnProfile.visibility = View.GONE
        }
        binding.BLogInOnProfile.setOnClickListener {
            if (binding.BLogInOnProfile.text == getString(R.string.go_back)) toMainScreen()
            else controller.navigate(R.id.logInFragment)
        }
        binding.BSignUpOnProfile.setOnClickListener { controller.navigate(R.id.signUpFragment) }
    }
}