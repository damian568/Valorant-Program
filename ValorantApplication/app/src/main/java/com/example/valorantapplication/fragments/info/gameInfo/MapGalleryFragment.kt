package com.example.valorantapplication.fragments.info.gameInfo

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.example.valorantapplication.constants.ConstantsMaps
import com.example.valorantapplication.databinding.FragmentMapGalleryBinding
import com.squareup.picasso.Picasso

class MapGalleryFragment : Fragment() {

    private lateinit var binding: FragmentMapGalleryBinding
    private val handler = Handler()
    private var images = mutableListOf<String>()
    private lateinit var imageSwitcherRunnable: Runnable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapGalleryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsMaps()

        val argString = arguments?.getString("argStringMap")

        binding.nameMap.text = argString
        binding.txtMap.text = ConstantsMaps.textMap
        loadMapImages()
    }

    private fun getArgsMaps() {
        val bundle = arguments
        if (bundle != null) {
            ConstantsMaps.nameMap = bundle.getString(ConstantsMaps.ARG_MAP, ConstantsMaps.textMap).toString()
        }
    }

    private fun loadMapImages(){
        when (binding.nameMap.text) {
            "Lotus" -> {
                setMediaImagesLotus()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Pearl" -> {
                setMediaImagesPearl()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Fracture" -> {
                setMediaImagesFracture()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Breeze" -> {
                setMediaImagesBreeze()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Icebox" -> {
                setMediaImagesIcebox()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Bind" -> {
                setMediaImagesBind()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Haven" -> {
                setMediaImagesHaven()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Split" -> {
                setMediaImagesSplit()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
            "Ascent" -> {
                setMediaImagesAscent()
                setImageSwitcherFactory()
                setImageSwitcherClicker()
                setImageSwitcherRunnable()
            }
        }
    }

    private fun setMediaImagesLotus() {
        images.addAll(ConstantsMaps.imagesLotus)
    }

    private fun setMediaImagesPearl() {
        images.addAll(ConstantsMaps.imagesPearl)
    }

    private fun setMediaImagesFracture() {
        images.addAll(ConstantsMaps.imagesFracture)
    }

    private fun setMediaImagesBreeze() {
        images.addAll(ConstantsMaps.imagesBreeze)
    }

    private fun setMediaImagesIcebox() {
        images.addAll(ConstantsMaps.imagesIcebox)
    }

    private fun setMediaImagesBind() {
        images.addAll(ConstantsMaps.imagesBind)
    }

    private fun setMediaImagesHaven() {
        images.addAll(ConstantsMaps.imagesHaven)
    }

    private fun setMediaImagesSplit() {
        images.addAll(ConstantsMaps.imagesSplit)
    }

    private fun setMediaImagesAscent() {
        images.addAll(ConstantsMaps.imagesAscent)
    }

    private fun setImageSwitcherFactory() {
        val imageView = ImageView(context)
        imageView.scaleType = ImageView.ScaleType.CENTER_CROP
        imageView
        Picasso.get().load(images[ConstantsMaps.currentImageMapIndex]).into(binding.imageMapGallery)
    }

    private fun setImageSwitcherClicker() {
        binding.imageMapGallery.setOnClickListener {
            ConstantsMaps.currentImageMapIndex++
            if (ConstantsMaps.currentImageMapIndex == images.size) {
                ConstantsMaps.currentImageMapIndex = 0
            }
            Picasso.get().load(images[ConstantsMaps.currentImageMapIndex])
                .into(binding.imageMapGallery)
        }
    }

    private fun setImageSwitcherRunnable() {
        imageSwitcherRunnable = Runnable {
            ConstantsMaps.currentImageMapIndex++
            if (ConstantsMaps.currentImageMapIndex == images.size) {
                ConstantsMaps.currentImageMapIndex = 0
            }
            Picasso.get().load(images[ConstantsMaps.currentImageMapIndex])
                .into(binding.imageMapGallery)
            handler.postDelayed(imageSwitcherRunnable, ConstantsMaps.DELAY_MILLS.toLong())
        }
        handler.postDelayed(imageSwitcherRunnable, ConstantsMaps.DELAY_MILLS_IMAGE.toLong())
    }

    override fun onDestroyView() {
        handler.removeCallbacks(imageSwitcherRunnable)
        super.onDestroyView()
    }
}