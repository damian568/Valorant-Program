package com.example.valorantapplication.fragments.info.gameInfo.agents

import android.media.MediaPlayer.OnPreparedListener
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.valorantapplication.R
import com.example.valorantapplication.databinding.FragmentSkyeBinding

class SkyeFragment : Fragment() {

    private lateinit var binding: FragmentSkyeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSkyeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blta3c0de454b776542/5f7fa772e69fa40ef3183bda/SKye-abilities-_0000s_0003_ICONS_0000_Layer-1.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt7243683c6daf467d/5f7fa7729d46c20f09177ab7/SKye-abilities-_0000s_0002_ICONS_0001_Layer-2.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltaa1ff9d900a13d3a/5f7fa772f98ad40e91dc75e4/SKye-abilities-_0000s_0001_ICONS_0002_Layer-3.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltce2ce64e31a00348/5f7fa77202e6b80ebf902384/SKye-abilities-_0000s_0000_ICONS_0003_Layer-4.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQSkye)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityESkye)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCSkye)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXSkye)
    }

    private fun clickAbility(){
        binding.abilityQSkye.setOnClickListener {
            setAbilityVideo("Q - TRAILBLAZER", getString(R.string.skye_ability_q), R.raw.agent_skye_q)
        }
        binding.abilityESkye.setOnClickListener {
            setAbilityVideo("E - GUIDING LIGHT", getString(R.string.skye_ability_e), R.raw.agent_skye_e)
        }
        binding.abilityCSkye.setOnClickListener {
            setAbilityVideo("C - REGROWTH", getString(R.string.skye_ability_c), R.raw.agent_skye_c)
        }
        binding.abilityXSkye.setOnClickListener {
            setAbilityVideo("X - SEEKERS", getString(R.string.skye_ability_x), R.raw.agent_skye_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilitySkye.text = textName
        binding.txtAbilitySkye.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoSkyeAbilities.setVideoURI(uri)
        binding.videoSkyeAbilities.start()

        binding.videoSkyeAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoSkyeAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoSkyeAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoSkyeAbilities.stopPlayback()
        super.onDestroy()
    }
}