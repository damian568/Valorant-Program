package com.example.valorantapplication.data

import android.content.Context
import com.example.valorantapplication.R

class AgentsGenerator(private val context: Context) {

    fun generateAgentsList(): List<Agents> {
        return listOf(
            Agents(
                imageResourceAgent = R.drawable.agent_brim,
                nameAgent = "Brimstone",
                roleAgent = context.getString(R.string.controller)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_phoenix,
                nameAgent = "Phoenix",
                roleAgent = context.getString(R.string.duelist)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_sage,
                nameAgent = "Sage",
                roleAgent = context.getString(R.string.sentinel)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_sova,
                nameAgent = "Sova",
                roleAgent = context.getString(R.string.initiator)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_viper,
                nameAgent = "Viper",
                roleAgent = context.getString(R.string.controller)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_cypher,
                nameAgent = "Cypher",
                roleAgent = context.getString(R.string.sentinel)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_reyna,
                nameAgent = "Reyna",
                roleAgent = context.getString(R.string.duelist)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_killjoy,
                nameAgent = "Killjoy",
                roleAgent = context.getString(R.string.sentinel)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_breach,
                nameAgent = "Breach",
                roleAgent = context.getString(R.string.initiator)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_omen,
                nameAgent = "Omen",
                roleAgent = context.getString(R.string.controller)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_jett,
                nameAgent = "Jett",
                roleAgent = context.getString(R.string.duelist)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_raze,
                nameAgent = "Raze",
                roleAgent = context.getString(R.string.duelist)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_skye,
                nameAgent = "Skye",
                roleAgent = context.getString(R.string.initiator)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_yoru,
                nameAgent = "Yoru",
                roleAgent = context.getString(R.string.duelist)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_astra,
                nameAgent = "Astra",
                roleAgent = context.getString(R.string.controller)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_kayo,
                nameAgent = "Kay'o",
                roleAgent = context.getString(R.string.initiator)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_chamber,
                nameAgent = "Chamber",
                roleAgent = context.getString(R.string.sentinel)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_neon,
                nameAgent = "Neon",
                roleAgent = context.getString(R.string.duelist)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_fade,
                nameAgent = "Fade",
                roleAgent = context.getString(R.string.initiator)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_harbor,
                nameAgent = "Harbor",
                roleAgent = context.getString(R.string.controller)
            ),

            Agents(
                imageResourceAgent = R.drawable.agent_gekko,
                nameAgent = "Gekko",
                roleAgent = context.getString(R.string.initiator)
            )
        )
    }
}