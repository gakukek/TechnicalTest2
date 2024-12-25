package com.example.technicaltest2

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.firebase.auth.FirebaseAuth


class LoginFragment : Fragment() {
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button
    private lateinit var progressBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)
        usernameEditText = view.findViewById(R.id.usernameEditText)
        passwordEditText = view.findViewById(R.id.passwordEditText)
        loginButton = view.findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            var password = passwordEditText.text.toString()
            if (username.isNotEmpty() && password.isNotEmpty()) { //not null check
                password = "$password@@" //masih workaround, min pass 6 kata
                val email = "$username@email.com" // Workaround in order to use Firebase Auth
                Toast.makeText(context, "Processing Login...", Toast.LENGTH_SHORT).show()
                progressBar = view.findViewById(R.id.progressBar)
                progressBar.visibility = View.VISIBLE
                loginWithFirebase(email, password) // dalam kasus asli, jika memang harus username-password
            } else {                               // mungkin menggunakan alternatif database lain seperti server backend sendiri atau Auth0 dll.
                Toast.makeText(context, "Username or Password Cannot be Null", Toast.LENGTH_SHORT)
                    .show()
            }
        }
        return view
    }

    private fun loginWithFirebase(email: String, password: String) {
        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(context, "Login Successful!", Toast.LENGTH_SHORT).show()
                    findNavController().navigate(R.id.action_loginFragment_to_studentListFragment)
                } else {
                    Toast.makeText(
                        context,
                        "Login Failed: ${task.exception?.message}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    }

}