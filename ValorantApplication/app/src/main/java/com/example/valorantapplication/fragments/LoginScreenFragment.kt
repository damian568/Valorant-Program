package com.example.valorantapplication.fragments

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContracts
import com.example.valorantapplication.R
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.data.User
import com.example.valorantapplication.data.UserImage
import com.example.valorantapplication.databinding.FragmentLoginScreenBinding

class LoginScreenFragment : Fragment() {

    private lateinit var binding: FragmentLoginScreenBinding
    private lateinit var preferencesUntil: PreferenceUntil

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentLoginScreenBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferencesUntil = PreferenceUntil.getInstance(view.context)
        val user = preferencesUntil.getUserData()
        user?.let { printUserInfo(it) }

        changeImage()
    }

    private fun printUserInfo(user: User?) {
        binding.txtFullNameProfile.text = user?.username
        binding.txtEmailProfile.text = user?.email
        binding.txtSexProfile.text = user?.gender.toString()
    }

    private fun changeImage() {
        binding.imageViewProfile.setOnClickListener {
            openGallery()
        }
    }

    private fun openGallery() {
        val intent = Intent(Intent.ACTION_PICK)
        intent.type = getString(R.string.image_text)
        resultLauncher.launch(intent)
    }

    private var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                binding.imageViewProfile.setImageURI(data?.data)
                val imageUri = data?.data
                val image = getImageIdFromUri(imageUri)
                val userImage = UserImage(image)
                preferencesUntil.setUserImage(userImage)
            }
        }

    private fun getImageIdFromUri(uri: Uri?): Int? {
        if (uri == null) {
            return null
        }

        val contentResolver = context?.contentResolver
        val cursor = contentResolver?.query(
            uri,
            arrayOf(MediaStore.Images.Media._ID),
            null,
            null,
            null
        )

        val id: Int? = cursor?.use {
            if (it.moveToFirst()) {
                it.getInt(it.getColumnIndex(MediaStore.Images.Media._ID))
            } else {
                null
            }
        }
        cursor?.close()
        return id
    }
}