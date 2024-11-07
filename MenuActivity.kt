package br.senac.card

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button

class MenuActivity : Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_de_menu)
        val btPerfil = findViewById<Button>(R.id.bt_perfil)
        btPerfil.setOnClickListener {
            IrParaPerfil()
        }

        val btCarteira = findViewById<Button>(R.id.bt_carteira_de_vacinacao)
        btCarteira.setOnClickListener {
            IrParaCarteiraDeVacinacao()
        }

        val btAgendamentos = findViewById<Button>(R.id.bt_agendamentos)
        btAgendamentos.setOnClickListener {
            IrParaAgendamentos()
        }

        val btPosto = findViewById<Button>(R.id.bt_posto_saude)
        btPosto.setOnClickListener {
            IrParaPosto()
        }

        val btGestante = findViewById<Button>(R.id.bt_saude_gestante)
        btGestante.setOnClickListener {
            IrParaSaudeGestante()
        }
    }

    private fun IrParaPerfil() {

        var perfil = Intent(this, PerfilActivity::class.java)
        startActivity(perfil)

    }

    private fun IrParaCarteiraDeVacinacao() {
        var carteira = Intent(this, CarteiraActivity::class.java)
        startActivity(carteira)
    }

    private fun IrParaAgendamentos() {
        var agendamentos = Intent(this, AgendamentosActivity::class.java)
        startActivity(agendamentos)
    }

    private fun IrParaPosto() {
        var posto = Intent(this, PostoActivity::class.java)
        startActivity(posto)
    }

    private fun IrParaSaudeGestante() {
        var gestante = Intent(this, PregmentActivity::class.java)
        startActivity(gestante)
    }
}