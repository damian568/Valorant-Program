package com.example.valorantapplication.fragments.info.others

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.constants.ConstantsMedia
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentMediaBinding
import com.squareup.picasso.Picasso

class MediaFragment : Fragment() {

    private lateinit var binding: FragmentMediaBinding
    private val handler = Handler()
    private var images = mutableListOf<String>()
    private lateinit var imageSwitcherRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMediaBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.txtMedia.text = getString(R.string.media_text)
        setMediaImages()
        setImageSwitcherFactory()
        setImageSwitcherClicker()
        setImageSwitcherRunnable()
    }

    private fun setMediaImages() {
        images.addAll(ConstantsMedia.images)
    }

    private fun setImageSwitcherFactory() {
        val imageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView
        Picasso.get().load(images[ConstantsMedia.currentImageIndex]).into(binding.imageSwitcherMedia)
    }

    private fun setImageSwitcherClicker() {
        binding.imageSwitcherMedia.setOnClickListener {
            ConstantsMedia.currentImageIndex++
            if (ConstantsMedia.currentImageIndex == images.size) {
                ConstantsMedia.currentImageIndex = 0
            }
            Picasso.get().load(images[ConstantsMedia.currentImageIndex])
                .into(binding.imageSwitcherMedia)
        }
    }

    private fun setImageSwitcherRunnable() {
        imageSwitcherRunnable = Runnable {
            ConstantsMedia.currentImageIndex++
            if (ConstantsMedia.currentImageIndex == images.size) {
                ConstantsMedia.currentImageIndex = 0
            }
            Picasso.get().load(images[ConstantsMedia.currentImageIndex])
                .into(binding.imageSwitcherMedia)
            handler.postDelayed(imageSwitcherRunnable, Constants.DELAY_MILLS.toLong())
        }
        handler.postDelayed(imageSwitcherRunnable, Constants.DELAY_MILLS.toLong())
    }

    override fun onDestroyView() {
        handler.removeCallbacks(imageSwitcherRunnable)
        super.onDestroyView()
    }
}