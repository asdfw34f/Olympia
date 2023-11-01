package com.olympia.views


import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.fragment.findNavController
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.auth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.FirebaseDatabaseKtxRegistrar
import com.google.firebase.database.database
import com.olympia.R
import com.olympia.databinding.FragmentSignUpBinding
import com.olympia.extensions.toMainScreen
import com.olympia.model.repositories.UsersRepository
import com.olympia.viewModels.AccountInf
import com.olympia.viewModels.UserViewModel

class SignUpFragment : Fragment() {

  //  private lateinit var auth: FirebaseAuth
   // private lateinit var db: FirebaseDatabase

    private lateinit var binding: FragmentSignUpBinding
    private val dataModel: AccountInf by activityViewModels()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentSignUpBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        if (dataModel.userName.value?.isNotEmpty() == true) {
            dataModel.userName.observe(activity as LifecycleOwner) {
                binding.UserNameOnSignUp.text.insert(
                    1,
                    it
                )
            }
            dataModel.password.observe(activity as LifecycleOwner) {
                binding.PasswordOnSignUp.text.insert(
                    0,
                    it
                )
            }
            dataModel.gender.observe(activity as LifecycleOwner) {
                binding.GenderOnSignUp.text.insert(
                    0,
                    it
                )
            }
            dataModel.dataOfBirth.observe(activity as LifecycleOwner) {
                binding.BirthdayOnSignUp.text.insert(
                    0,
                    it
                )
            }
            dataModel.email.observe(activity as LifecycleOwner) {
                binding.EmailOnSignUp.text.insert(
                    0,
                    it
                )
            }
        }
        binding.BGoBackOnSignUp.setOnClickListener { controller.navigate(R.id.profileFragment) }
        binding.BSaveOnSignUp.setOnClickListener {
       //   dataModel.userName.value = binding.UserNameOnSignUp.text.toString()
       //   dataModel.password.value = binding.PasswordOnSignUp.text.toString()
       //   dataModel.gender.value = binding.GenderOnSignUp.text.toString()
       //   dataModel.dataOfBirth.value = binding.BirthdayOnSignUp.text.toString()
       //   dataModel.email.value = binding.EmailOnSignUp.text.toString()

     //     auth = FirebaseAuth.getInstance()
        //  auth.createUserWithEmailAndPassword(binding.EmailOnSignUp.text.toString(), binding.PasswordOnSignUp.text.toString())

            UsersRepository().writeNewUser(
                "qwer",
                "dfsjuhngbvjf",
                "f",
                "22.02.2000",
                "qwer@gmail.com"
            //   binding.UserNameOnSignUp.text.toString(),
            //   binding.PasswordOnSignUp.text.toString(),
            //   binding.GenderOnSignUp.text.toString(),
            //   binding.BirthdayOnSignUp.text.toString(),
            //   binding.EmailOnSignUp.text.toString()
            )

        }
    }

}