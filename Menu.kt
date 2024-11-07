package br.senac.card

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class Menu : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_de_menu)
        val btPerfil = findViewById<Button>(R.id.bt_perfil)
        btPerfil.setOnClickListener {
            IrParaPerfil()
        }
    }

    private fun IrParaPerfil() {

        var perfil = Intent(this, Perfil::class.java)
        startActivity(perfil)

    }

    private fun IrParaCarteiraDeVacinacao() {
        var carteira = Intent(this, Carteira::class.java)
        startActivity(carteira)
    }

    private fun IrParaAgendamentos() {
        var agendamentos = Intent(this, Agendamentos::class.java)
        startActivity(agendamentos)
    }

    private fun IrParaPosto() {
        var posto = Intent(this, Posto::class.java)
        startActivity(posto)
    }

    private fun IrParaSaudeGestante() {
        var gestante = Intent(this, Gestante::class.java)
        startActivity(gestante)
    }
}