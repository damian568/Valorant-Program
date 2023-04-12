package com.example.valorantapplication.fragments.info.gameInfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.valorantapplication.data.Agents
import com.example.valorantapplication.data.AgentsGenerator
import com.example.valorantapplication.data.PreferenceUntil
import com.example.valorantapplication.databinding.FragmentAgentsBinding

class AgentsFragment : Fragment() {

    private lateinit var binding: FragmentAgentsBinding
    private lateinit var preferencesUntil: PreferenceUntil
    private lateinit var agentsGenerator: AgentsGenerator
    private var agentIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAgentsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        preferencesUntil = PreferenceUntil.getInstance(view.context)
        agentsGenerator = AgentsGenerator(requireContext())
        clickButtonNextAgent()
        clickCardView()
    }

    private fun clickCardView(){
        binding.cardViewAgent.setOnClickListener {
            checkAgentName()
        }
    }

    private fun checkAgentName(){
        when (binding.agentName.text) {
            "Brimstone" -> {
                goToBrimFragment()
            }
            "Phoenix" -> {
                goToPhoenixFragment()
            }
            "Sage" -> {
                goToSageFragment()
            }
            "Sova" -> {
                goToSovaFragment()
            }
            "Viper" -> {
                goToViperFragment()
            }
            "Cypher" -> {
                goToCypherFragment()
            }
            "Reyna" -> {
                goToReynaFragment()
            }
            "Killjoy" -> {
                goToKilljoyFragment()
            }
            "Breach" -> {
                goToBreachFragment()
            }
            "Omen" -> {
                goToOmenFragment()
            }
            "Jett" -> {
                goToJettFragment()
            }
            "Raze" -> {
                goToRazeFragment()
            }
            "Skye" -> {
                goToSkyeFragment()
            }
            "Yoru" -> {
                goToYoruFragment()
            }
            "Astra" -> {
                goToAstraFragment()
            }
            "Kay'o" -> {
                goToKayoFragment()
            }
            "Chamber" -> {
                goToChamberFragment()
            }
            "Neon" -> {
                goToNeonFragment()
            }
            "Fade" -> {
                goToFadeFragment()
            }
            "Harbor" -> {
                goToHarborFragment()
            }
            "Gekko" -> {
                goToGekkoFragment()
            }
        }
    }

    private fun clickButtonNextAgent(){
        getAgents()
        binding.btnNextAgent.setOnClickListener {
            getAgents()
        }
    }

    private fun getAgents(): Agents {
        setAgents()
        val agentsList = preferencesUntil.getAgents()
        val agent = agentsList[agentIndex]
        binding.imageViewAgent.setImageResource(agent.imageResourceAgent)
        binding.agentName.text = agent.nameAgent
        binding.agentRole.text = agent.roleAgent
        agentIndex = (agentIndex + 1) % agentsList.size
        return agent
    }

    private fun setAgents() {
        preferencesUntil.setAgents(agentsGenerator.generateAgentsList())
    }

    private fun goToBrimFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToBrimstoneFragment()
        findNavController().navigate(action)
    }

    private fun goToPhoenixFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToPhoenixFragment()
        findNavController().navigate(action)
    }

    private fun goToSageFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToSageFragment()
        findNavController().navigate(action)
    }

    private fun goToSovaFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToSovaFragment()
        findNavController().navigate(action)
    }

    private fun goToViperFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToViperFragment()
        findNavController().navigate(action)
    }

    private fun goToCypherFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToCypherFragment()
        findNavController().navigate(action)
    }

    private fun goToReynaFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToReynaFragment()
        findNavController().navigate(action)
    }

    private fun goToKilljoyFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToKilljoyFragment()
        findNavController().navigate(action)
    }

    private fun goToBreachFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToBreachFragment()
        findNavController().navigate(action)
    }

    private fun goToOmenFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToOmenFragment()
        findNavController().navigate(action)
    }

    private fun goToJettFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToJettFragment()
        findNavController().navigate(action)
    }

    private fun goToRazeFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToRazeFragment()
        findNavController().navigate(action)
    }

    private fun goToSkyeFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToSkyeFragment()
        findNavController().navigate(action)
    }

    private fun goToYoruFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToYoruFragment()
        findNavController().navigate(action)
    }

    private fun goToAstraFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToAstraFragment()
        findNavController().navigate(action)
    }

    private fun goToKayoFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToKayoFragment()
        findNavController().navigate(action)
    }

    private fun goToChamberFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToChamberFragment()
        findNavController().navigate(action)
    }

    private fun goToNeonFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToNeonFragment()
        findNavController().navigate(action)
    }

    private fun goToFadeFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToFadeFragment()
        findNavController().navigate(action)
    }

    private fun goToHarborFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToHarborFragment()
        findNavController().navigate(action)
    }

    private fun goToGekkoFragment(){
        val action = AgentsFragmentDirections.actionAgentsFragmentToGekkoFragment()
        findNavController().navigate(action)
    }
}