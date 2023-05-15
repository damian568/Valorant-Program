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
import com.example.valorantapplication.databinding.FragmentRazeBinding

class RazeFragment : Fragment() {

    private lateinit var binding: FragmentRazeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRazeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setAbilityImages()
        clickAbility()
    }

    private fun setAbilityImages(){
        val uriQ = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltdb74f287eee9fe76/5eaf862a248a28605479c91f/TX_Raze_Q.png")
        val uriE = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/bltb0eb89e122c1f4ea/5eaf862ad238e314f259fa8b/TX_Raze_E.png")
        val uriC = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt44acc030d4d60182/5eaf862aa20afe612d82fb4e/TX_Raze_C.png")
        val uriX = Uri.parse("https://images.contentstack.io/v3/assets/bltb6530b271fddd0b1/blt60023b671f330740/5eaf862ae6f6795e530a2717/TX_Raze_X.png")
        Glide.with(this)
            .load(uriQ)
            .into(binding.abilityQRaze)
        Glide.with(this)
            .load(uriE)
            .into(binding.abilityERaze)
        Glide.with(this)
            .load(uriC)
            .into(binding.abilityCRaze)
        Glide.with(this)
            .load(uriX)
            .into(binding.abilityXRaze)
    }

    private fun clickAbility(){
        binding.abilityQRaze.setOnClickListener {
            setAbilityVideo("Q - BLAST PACK", getString(R.string.raze_ability_q), R.raw.agent_raze_q)
        }
        binding.abilityERaze.setOnClickListener {
            setAbilityVideo("E - PAINT SHELLS", getString(R.string.raze_ability_e), R.raw.agent_raze_e)
        }
        binding.abilityCRaze.setOnClickListener {
            setAbilityVideo("C - BOOM BOT", getString(R.string.raze_ability_c), R.raw.agent_raze_c)
        }
        binding.abilityXRaze.setOnClickListener {
            setAbilityVideo("X - SHOWSTOPPER", getString(R.string.raze_ability_x), R.raw.agent_raze_x)
        }
    }

    private fun setAbilityVideo(textName: String, textAbility: String, videoResource: Int) {
        binding.txtNameAbilityRaze.text = textName
        binding.txtAbilityRaze.text = textAbility
        val uri: Uri = Uri.parse("android.resource://" + activity!!.packageName + "/" + videoResource)

        binding.videoRazeAbilities.setVideoURI(uri)
        binding.videoRazeAbilities.start()

        binding.videoRazeAbilities.setOnPreparedListener(OnPreparedListener { mp ->
            mp.isLooping = true
        })
    }

    override fun onResume() {
        binding.videoRazeAbilities.resume()
        super.onResume()
    }

    override fun onPause() {
        binding.videoRazeAbilities.suspend()
        super.onPause()
    }

    override fun onDestroy() {
        binding.videoRazeAbilities.stopPlayback()
        super.onDestroy()
    }
}