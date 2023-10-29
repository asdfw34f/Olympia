package com.olympia.views

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.olympia.MainEntertainment
import com.olympia.R
import com.olympia.databinding.FragmentLogInBinding
import com.olympia.extensions.toMainScreen
import com.olympia.viewModels.AccountInf

class LogInFragment : Fragment() {
    private lateinit var auth: FirebaseAuth
    private lateinit var binding: FragmentLogInBinding
    private val dataModel: AccountInf by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = FragmentLogInBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val controller = findNavController()
        binding.BGoBackOnLogIn.setOnClickListener { controller.navigate(R.id.profileFragment) }
        binding.BSaveOnLogIn.setOnClickListener {
            auth = Firebase.auth
            dataModel.email.value = binding.UserNameOnLogIn.text.toString()
            dataModel.password.value = binding.PasswordOnLogIn.text.toString()
            loginUser(dataModel.email.value!!, dataModel.password.value!!)
        }
        val intent = Intent((activity as AppCompatActivity), MainEntertainment::class.java)
        //startActivity(intent)
    }

    private fun loginUser(email:String, password:String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this.context, "Login successful", Toast.LENGTH_SHORT).show()
                    toMainScreen()
                } else {
                    Toast.makeText(this.context, "Unable to login. Check your input or try again later", Toast.LENGTH_SHORT).show()
                }
            }
    }

}