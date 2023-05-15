package com.example.valorantapplication.fragments.info.gameInfo

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.constants.ConstantsMaps
import com.example.valorantapplication.databinding.FragmentMapsBinding

class MapsFragment : Fragment() {

    private lateinit var binding: FragmentMapsBinding
    var name = ""
    var text = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMapsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsMaps()
        setMapLotus()
        setMapPearl()
        setMapFracture()
        setMapBreeze()
        setMapIcebox()
        setMapBind()
        setMapHaven()
        setMapSplit()
        setMapAscent()
    }

    private fun changeConstantsMap(){
        ConstantsMaps.nameMap = name
        ConstantsMaps.textMap = text
    }

    private fun setMapLotus(){
        val uri = Uri.parse(getString(R.string.image_lotus))
        Glide.with(this)
            .load(uri)
            .into(binding.imageLotus)
        binding.txtLotus.text = getString(R.string.name_lotus)
        binding.txtGalleryLotus.text = getString(R.string.view_gallery)
        clickLotus()
    }

    private fun putStringLotus(){
        name = getString(R.string.name_lotus)
        text = getString(R.string.txt_lotus)
    }

    private fun clickLotus(){
        binding.txtGalleryLotus.setOnClickListener {
            putStringLotus()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapPearl(){
        val uri = Uri.parse(getString(R.string.image_pearl))
        Glide.with(this)
            .load(uri)
            .into(binding.imagePearl)

        binding.txtPearl.text = getString(R.string.name_pearl)
        binding.txtGalleryPearl.text = getString(R.string.view_gallery)
        clickPearl()
    }

    private fun putStringPearl(){
        name = getString(R.string.name_pearl)
        text = getString(R.string.txt_pearl)
    }


    private fun clickPearl(){
        binding.txtGalleryPearl.setOnClickListener {
            putStringPearl()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapFracture(){
        val uri = Uri.parse(getString(R.string.image_fracture))
        Glide.with(this)
            .load(uri)
            .into(binding.imageFracture)

        binding.txtFracture.text = getString(R.string.name_fracture)
        binding.txtGalleryFracture.text = getString(R.string.view_gallery)
        clickFracture()
    }

    private fun putStringFracture(){
        name = getString(R.string.name_fracture)
        text = getString(R.string.txt_fracture)
    }

    private fun clickFracture(){
        binding.txtGalleryFracture.setOnClickListener {
            putStringFracture()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapBreeze(){
        val uri = Uri.parse(getString(R.string.image_breeze))
        Glide.with(this)
            .load(uri)
            .into(binding.imageBreeze)

        binding.txtBreeze.text = getString(R.string.name_breeze)
        binding.txtGalleryBreeze.text = getString(R.string.view_gallery)
        clickBreeze()
    }

    private fun putStringBreeze(){
        name = getString(R.string.name_breeze)
        text = getString(R.string.txt_breeze)
    }

    private fun clickBreeze(){
        binding.txtGalleryBreeze.setOnClickListener {
            putStringBreeze()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapIcebox(){
        val uri = Uri.parse(getString(R.string.image_icebox))
        Glide.with(this)
            .load(uri)
            .into(binding.imageIcebox)

        binding.txtIcebox.text = getString(R.string.name_icebox)
        binding.txtGalleryIcebox.text = getString(R.string.view_gallery)
        clickIcebox()
    }

    private fun putStringIceBox(){
        name = getString(R.string.name_icebox)
        text = getString(R.string.txt_icebox)
    }

    private fun clickIcebox(){
        binding.txtGalleryIcebox.setOnClickListener {
            putStringIceBox()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapBind(){
        val uri = Uri.parse(getString(R.string.image_bind))
        Glide.with(this)
            .load(uri)
            .into(binding.imageBind)

        binding.txtBind.text = getString(R.string.name_bind)
        binding.txtGalleryBind.text = getString(R.string.view_gallery)
        clickBind()
    }

    private fun putStringBind(){
        name = getString(R.string.name_bind)
        text = getString(R.string.txt_bind)
    }

    private fun clickBind(){
        binding.txtGalleryBind.setOnClickListener {
            putStringBind()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapHaven(){
        val uri = Uri.parse(getString(R.string.image_haven))
        Glide.with(this)
            .load(uri)
            .into(binding.imageHaven)

        binding.txtHaven.text = getString(R.string.name_haven)
        binding.txtGalleryHaven.text = getString(R.string.view_gallery)
        clickHaven()
    }

    private fun putStringHaven(){
        name = getString(R.string.name_haven)
        text = getString(R.string.txt_haven)
    }

    private fun clickHaven(){
        binding.txtGalleryHaven.setOnClickListener {
            putStringHaven()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapSplit(){
        val uri = Uri.parse(getString(R.string.image_split))
        Glide.with(this)
            .load(uri)
            .into(binding.imageSplit)

        binding.txtSplit.text = getString(R.string.name_split)
        binding.txtGallerySplit.text = getString(R.string.view_gallery)
        clickSplit()
    }

    private fun putStringSplit(){
        name = getString(R.string.name_split)
        text = getString(R.string.txt_split)
    }

    private fun clickSplit(){
        binding.txtGallerySplit.setOnClickListener {
            putStringSplit()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun setMapAscent(){
        val uri = Uri.parse(getString(R.string.image_ascent))
        Glide.with(this)
            .load(uri)
            .into(binding.imageAscent)

        binding.txtAscent.text = getString(R.string.name_ascent)
        binding.txtGalleryAscent.text = getString(R.string.view_gallery)
        clickAscent()
    }

    private fun putStringAscent(){
        name = getString(R.string.name_ascent)
        text = getString(R.string.txt_ascent)
    }

    private fun clickAscent(){
        binding.txtGalleryAscent.setOnClickListener {
            putStringAscent()
            changeConstantsMap()
            goToNextScreen()
        }
    }

    private fun goToNextScreen(){
        val action = MapsFragmentDirections.actionMapsFragmentToMapGalleryFragment(
            bundle.getString(ConstantsMaps.ARG_MAP, ConstantsMaps.nameMap)
        )
        findNavController().navigate(action)
    }

    private fun getArgsMaps() {
        val bundle = arguments
        if (bundle != null) {
            ConstantsMaps.nameMap = bundle.getString(ConstantsMaps.ARG_MAP, ConstantsMaps.textMap).toString()
        }
    }
}