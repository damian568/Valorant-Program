package com.example.valorantapplication.fragments.info.gameInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.R
import com.example.valorantapplication.bundle
import com.example.valorantapplication.constants.Constants
import com.example.valorantapplication.databinding.FragmentWeaponsBinding

class WeaponsFragment : Fragment() {

    private lateinit var binding: FragmentWeaponsBinding
    var nameArsenal = ""
    var type = ""
    var arsenalInformation = ""
    var imageArsenalURI = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWeaponsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getArgsArsenal()
        openSpinner()
    }

    private fun openSpinner(){
        binding.spinnerArsenal.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                when (position) {
                    0 -> {
                        setFirstFourWeaponsText()
                        setAllCardViewVisible()
                        clickAllCardViews()
                    }
                    1 -> {
                        setFirstFourWeaponsText()
                        setSpinner1()
                        clickCardViewsSidearms()
                    }
                    2 -> {
                        setSpinner2()
                        clickCardViewsSMGS()
                    }
                    3 -> {
                        setSpinner3()
                        clickCardViewsShotguns()
                    }
                    4 -> {
                        setSpinner4()
                        clickCardViewsRifles()
                    }
                    5 -> {
                        setSpinner5()
                        clickCardViewsSnipers()
                    }
                    6 -> {
                        setSpinner6()
                        clickCardViewsHeavies()
                    }
                    7 -> {
                        setSpinner7()
                        clickCardViewsMelee()
                    }
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                //Do nothing
            }
        }
    }

    private fun clickAllCardViews(){
        binding.cardViewClassic.setOnClickListener {
            putStringToClassic()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToShorty()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewFrenzy.setOnClickListener {
            putStringToFrenzy()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewGhost.setOnClickListener {
            putStringToGhost()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewSheriff.setOnClickListener {
            putStringToSheriff()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewStinger.setOnClickListener {
            putStringToStinger()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewSpectre.setOnClickListener {
            putStringToSpectre()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewBucky.setOnClickListener {
            putStringToBucky()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewJudge.setOnClickListener {
            putStringToJudge()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewBulldog.setOnClickListener {
            putStringToBulldog()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewGuardian.setOnClickListener {
            putStringToGuardian()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewPhantom.setOnClickListener {
            putStringToPhantom()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewVandal.setOnClickListener {
            putStringToVandal()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewMarshal.setOnClickListener {
            putStringToMarshal()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewOperator.setOnClickListener {
            putStringToOperator()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewAres.setOnClickListener {
            putStringToAres()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewOdin.setOnClickListener {
            putStringToOdin()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewKnife.setOnClickListener {
            putStringToKnife()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun putStringToClassic(){
        nameArsenal = getString(R.string.classic)
        type = getString(R.string.type_sidearm)
        arsenalInformation = getString(R.string.txt_classic_info)
        imageArsenalURI = getString(R.string.image_classic)
    }

    private fun putStringToShorty(){
        nameArsenal = getString(R.string.shorty)
        type = getString(R.string.type_sidearm)
        arsenalInformation = getString(R.string.txt_shorty_info)
        imageArsenalURI = getString(R.string.image_shorty)
    }

    private fun putStringToFrenzy(){
        nameArsenal = getString(R.string.frenzy)
        type = getString(R.string.type_sidearm)
        arsenalInformation = getString(R.string.txt_frenzy_info)
        imageArsenalURI = getString(R.string.image_frenzy)
    }

    private fun putStringToGhost(){
        nameArsenal = getString(R.string.ghost)
        type = getString(R.string.type_sidearm)
        arsenalInformation = getString(R.string.txt_ghost_info)
        imageArsenalURI = getString(R.string.image_ghost)
    }

    private fun putStringToSheriff(){
        nameArsenal = getString(R.string.sheriff)
        type = getString(R.string.type_sidearm)
        arsenalInformation = getString(R.string.txt_sheriff_info)
        imageArsenalURI = getString(R.string.image_sheriff)
    }

    private fun putStringToSpectre(){
        nameArsenal = getString(R.string.spectre)
        type = getString(R.string.type_sidearm)
        arsenalInformation = getString(R.string.txt_spectre_info)
        imageArsenalURI = getString(R.string.image_spectre)
    }

    private fun putStringToStinger(){
        nameArsenal = getString(R.string.stinger)
        type = getString(R.string.type_smg)
        arsenalInformation = getString(R.string.txt_stinger_info)
        imageArsenalURI = getString(R.string.image_stinger)
    }

    private fun putStringToBucky(){
        nameArsenal = getString(R.string.bucky)
        type = getString(R.string.type_shotgun)
        arsenalInformation = getString(R.string.txt_bucky_info)
        imageArsenalURI = getString(R.string.image_bucky)
    }

    private fun putStringToJudge(){
        nameArsenal = getString(R.string.judge)
        type = getString(R.string.type_shotgun)
        arsenalInformation = getString(R.string.txt_judge_info)
        imageArsenalURI = getString(R.string.image_judge)
    }

    private fun putStringToBulldog(){
        nameArsenal = getString(R.string.bulldog)
        type = getString(R.string.type_rifle)
        arsenalInformation = getString(R.string.txt_bulldog_info)
        imageArsenalURI = getString(R.string.image_bulldog)
    }

    private fun putStringToGuardian(){
        nameArsenal = getString(R.string.guardian)
        type = getString(R.string.type_rifle)
        arsenalInformation = getString(R.string.txt_guardian_info)
        imageArsenalURI = getString(R.string.image_guardian)
    }

    private fun putStringToPhantom(){
        nameArsenal = getString(R.string.phantom)
        type = getString(R.string.type_rifle)
        arsenalInformation = getString(R.string.txt_phantom_info)
        imageArsenalURI = getString(R.string.image_phantom)
    }

    private fun putStringToVandal(){
        nameArsenal = getString(R.string.vandal)
        type = getString(R.string.type_rifle)
        arsenalInformation = getString(R.string.txt_vandal_info)
        imageArsenalURI = getString(R.string.image_vandal)
    }

    private fun putStringToMarshal(){
        nameArsenal = getString(R.string.marshal)
        type = getString(R.string.type_sniper)
        arsenalInformation = getString(R.string.txt_marshal_info)
        imageArsenalURI = getString(R.string.image_marshal)
    }

    private fun putStringToOperator(){
        nameArsenal = getString(R.string.operator)
        type = getString(R.string.type_sniper)
        arsenalInformation = getString(R.string.txt_operator_info)
        imageArsenalURI = getString(R.string.image_operator)
    }

    private fun putStringToAres(){
        nameArsenal = getString(R.string.ares)
        type = getString(R.string.type_heavy)
        arsenalInformation = getString(R.string.txt_ares_info)
        imageArsenalURI = getString(R.string.image_ares)
    }

    private fun putStringToOdin(){
        nameArsenal = getString(R.string.odin)
        type = getString(R.string.type_heavy)
        arsenalInformation = getString(R.string.txt_odin_info)
        imageArsenalURI = getString(R.string.image_odin)
    }

    private fun putStringToKnife(){
        nameArsenal = getString(R.string.knife)
        type = getString(R.string.type_melee)
        arsenalInformation = getString(R.string.txt_knife_info)
        imageArsenalURI = getString(R.string.image_knife)
    }

    private fun clickCardViewsSidearms(){
        binding.cardViewClassic.setOnClickListener {
            putStringToClassic()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToShorty()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewFrenzy.setOnClickListener {
            putStringToFrenzy()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewGhost.setOnClickListener {
            putStringToGhost()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewSheriff.setOnClickListener {
            putStringToSheriff()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun clickCardViewsSMGS(){
        binding.cardViewClassic.setOnClickListener {
            putStringToStinger()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToSpectre()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun clickCardViewsShotguns(){
        binding.cardViewClassic.setOnClickListener {
            putStringToBucky()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToJudge()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun clickCardViewsRifles(){
        binding.cardViewClassic.setOnClickListener {
            putStringToBulldog()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToGuardian()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewFrenzy.setOnClickListener {
            putStringToPhantom()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewGhost.setOnClickListener {
            putStringToVandal()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun clickCardViewsSnipers(){
        binding.cardViewClassic.setOnClickListener {
            putStringToMarshal()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToOperator()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun clickCardViewsHeavies(){
        binding.cardViewClassic.setOnClickListener {
            putStringToAres()
            changeConstants()
            goToNextScreen()
        }
        binding.cardViewShorty.setOnClickListener {
            putStringToOdin()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun clickCardViewsMelee(){
        binding.cardViewClassic.setOnClickListener {
            putStringToKnife()
            changeConstants()
            goToNextScreen()
        }
    }

    private fun changeConstants(){
        Constants.nameArsenal = nameArsenal
        Constants.typeArsenal = type
        Constants.arsenalInformation = arsenalInformation
        Constants.imageArsenalURI = imageArsenalURI
    }

    private fun goToNextScreen(){
        val action = WeaponsFragmentDirections.actionWeaponsFragmentToArsenalInformationFragment(
            bundle.getString(Constants.ARG_ARSENAL, Constants.nameArsenal)
        )
        findNavController().navigate(action)
    }

    private fun getArgsArsenal() {
        val bundle = arguments
        if (bundle != null) {
            Constants.nameArsenal = bundle.getString(Constants.ARG_ARSENAL, Constants.typeArsenal).toString()
            Constants.nameArsenal = bundle.getString(Constants.ARG_ARSENAL, Constants.arsenalInformation).toString()
            Constants.nameArsenal = bundle.getString(Constants.ARG_ARSENAL, Constants.imageArsenalURI).toString()
        }
    }

    private fun setSpinner7(){
        setTextSpinner7()
        binding.cardViewShorty.visibility = View.INVISIBLE
        makeAllCardViewsInvisibleOnlyTwoNOT()
    }

    private fun setTextSpinner7(){
        binding.txtName1.text = getString(R.string.knife)
        binding.txt1.text = getString(R.string.txt_knife)
    }

    private fun setSpinner6(){
        setTextSpinner6()
        binding.cardViewShorty.visibility = View.VISIBLE
        makeAllCardViewsInvisibleOnlyTwoNOT()
    }

    private fun setTextSpinner6(){
        binding.txtName1.text = getString(R.string.ares)
        binding.txt1.text = getString(R.string.txt_ares)
        binding.txtName2.text = getString(R.string.odin)
        binding.txt2.text = getString(R.string.txt_odin)
    }

    private fun setSpinner5(){
        setTextSpinner5()
        binding.cardViewShorty.visibility = View.VISIBLE
        makeAllCardViewsInvisibleOnlyTwoNOT()
    }

    private fun setTextSpinner5(){
        binding.txtName1.text = getString(R.string.marshal)
        binding.txt1.text = getString(R.string.txt_marshal)
        binding.txtName2.text = getString(R.string.operator)
        binding.txt2.text = getString(R.string.txt_operator)
    }

    private fun setSpinner4(){
        setTextSpinner4()
        binding.cardViewShorty.visibility = View.VISIBLE
        binding.cardViewFrenzy.visibility = View.VISIBLE
        binding.cardViewGhost.visibility = View.VISIBLE
        binding.cardViewSheriff.visibility = View.INVISIBLE
        binding.cardViewStinger.visibility = View.INVISIBLE
        binding.cardViewSpectre.visibility = View.INVISIBLE
        binding.cardViewBucky.visibility = View.INVISIBLE
        binding.cardViewJudge.visibility = View.INVISIBLE
        binding.cardViewBulldog.visibility = View.INVISIBLE
        binding.cardViewGuardian.visibility = View.INVISIBLE
        binding.cardViewPhantom.visibility = View.INVISIBLE
        binding.cardViewVandal.visibility = View.INVISIBLE
        binding.cardViewMarshal.visibility = View.INVISIBLE
        binding.cardViewOperator.visibility = View.INVISIBLE
        binding.cardViewAres.visibility = View.INVISIBLE
        binding.cardViewOdin.visibility = View.INVISIBLE
        binding.cardViewKnife.visibility = View.INVISIBLE
    }

    private fun setTextSpinner4(){
        binding.txtName1.text = getString(R.string.bulldog)
        binding.txt1.text = getString(R.string.txt_bulldog)
        binding.txtName2.text = getString(R.string.guardian)
        binding.txt2.text = getString(R.string.txt_guardian)
        binding.txtName3.text = getString(R.string.phantom)
        binding.txt3.text = getString(R.string.txt_phantom)
        binding.txtName4.text = getString(R.string.vandal)
        binding.txt4.text = getString(R.string.txt_vandal)
    }

    private fun setSpinner3(){
        setTextSpinner3()
        binding.cardViewShorty.visibility = View.VISIBLE
        makeAllCardViewsInvisibleOnlyTwoNOT()
    }

    private fun setTextSpinner3(){
        binding.txtName1.text = getString(R.string.bucky)
        binding.txt1.text = getString(R.string.txt_bucky)
        binding.txtName2.text = getString(R.string.judge)
        binding.txt2.text = getString(R.string.txt_judge)
    }

    private fun setSpinner2(){
        setTextSpinner2()
        binding.cardViewShorty.visibility = View.VISIBLE
        makeAllCardViewsInvisibleOnlyTwoNOT()
    }

    private fun setTextSpinner2(){
        binding.txtName1.text = getString(R.string.stinger)
        binding.txt1.text = getString(R.string.txt_stinger)
        binding.txtName2.text = getString(R.string.spectre)
        binding.txt2.text = getString(R.string.txt_spectre)
    }

    private fun setSpinner1(){
        binding.cardViewClassic.visibility = View.VISIBLE
        binding.cardViewShorty.visibility = View.VISIBLE
        binding.cardViewFrenzy.visibility = View.VISIBLE
        binding.cardViewGhost.visibility = View.VISIBLE
        binding.cardViewSheriff.visibility = View.VISIBLE
        binding.cardViewStinger.visibility = View.INVISIBLE
        binding.cardViewSpectre.visibility = View.INVISIBLE
        binding.cardViewBucky.visibility = View.INVISIBLE
        binding.cardViewJudge.visibility = View.INVISIBLE
        binding.cardViewBulldog.visibility = View.INVISIBLE
        binding.cardViewGuardian.visibility = View.INVISIBLE
        binding.cardViewPhantom.visibility = View.INVISIBLE
        binding.cardViewVandal.visibility = View.INVISIBLE
        binding.cardViewMarshal.visibility = View.INVISIBLE
        binding.cardViewOperator.visibility = View.INVISIBLE
        binding.cardViewAres.visibility = View.INVISIBLE
        binding.cardViewOdin.visibility = View.INVISIBLE
        binding.cardViewKnife.visibility = View.INVISIBLE
    }

    private fun setAllCardViewVisible(){
        binding.cardViewClassic.visibility = View.VISIBLE
        binding.cardViewShorty.visibility = View.VISIBLE
        binding.cardViewFrenzy.visibility = View.VISIBLE
        binding.cardViewGhost.visibility = View.VISIBLE
        binding.cardViewSheriff.visibility = View.VISIBLE
        binding.cardViewStinger.visibility = View.VISIBLE
        binding.cardViewSpectre.visibility = View.VISIBLE
        binding.cardViewBucky.visibility = View.VISIBLE
        binding.cardViewJudge.visibility = View.VISIBLE
        binding.cardViewBulldog.visibility = View.VISIBLE
        binding.cardViewGuardian.visibility = View.VISIBLE
        binding.cardViewPhantom.visibility = View.VISIBLE
        binding.cardViewVandal.visibility = View.VISIBLE
        binding.cardViewMarshal.visibility = View.VISIBLE
        binding.cardViewOperator.visibility = View.VISIBLE
        binding.cardViewAres.visibility = View.VISIBLE
        binding.cardViewOdin.visibility = View.VISIBLE
        binding.cardViewKnife.visibility = View.VISIBLE
    }

    private fun setFirstFourWeaponsText(){
        binding.txtName1.text = getString(R.string.classic)
        binding.txt1.text = getString(R.string.txt_classic)
        binding.txtName2.text = getString(R.string.shorty)
        binding.txt2.text = getString(R.string.txt_shorty)
        binding.txtName3.text = getString(R.string.frenzy)
        binding.txt3.text = getString(R.string.txt_frenzy)
        binding.txtName4.text = getString(R.string.ghost)
        binding.txt4.text = getString(R.string.txt_ghost)
    }

    private fun makeAllCardViewsInvisibleOnlyTwoNOT(){
        binding.cardViewFrenzy.visibility = View.INVISIBLE
        binding.cardViewGhost.visibility = View.INVISIBLE
        binding.cardViewSheriff.visibility = View.INVISIBLE
        binding.cardViewStinger.visibility = View.INVISIBLE
        binding.cardViewSpectre.visibility = View.INVISIBLE
        binding.cardViewBucky.visibility = View.INVISIBLE
        binding.cardViewJudge.visibility = View.INVISIBLE
        binding.cardViewBulldog.visibility = View.INVISIBLE
        binding.cardViewGuardian.visibility = View.INVISIBLE
        binding.cardViewPhantom.visibility = View.INVISIBLE
        binding.cardViewVandal.visibility = View.INVISIBLE
        binding.cardViewMarshal.visibility = View.INVISIBLE
        binding.cardViewOperator.visibility = View.INVISIBLE
        binding.cardViewAres.visibility = View.INVISIBLE
        binding.cardViewOdin.visibility = View.INVISIBLE
        binding.cardViewKnife.visibility = View.INVISIBLE
    }
}