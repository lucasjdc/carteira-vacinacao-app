package br.senac.card

import android.app.Activity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import br.senac.card.model.Agendamento
import br.senac.card.model.GerenciadorDeAgendamentos
import android.widget.TextView

class AgendamentosActivity : Activity() {
    private lateinit var gerenciadorDeAgendamentos: GerenciadorDeAgendamentos
    private lateinit var editTextPosto: EditText
    private lateinit var editTextData: EditText
    private lateinit var editTextHorario: EditText
    private lateinit var editTextVacina: EditText
    private lateinit var btnAgendar: Button
    private lateinit var btnAlarme: Button
    private lateinit var textViewListaDeVacinas: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_agendamentos)

        // Inicializando o gerenciador de agendamentos
        gerenciadorDeAgendamentos = GerenciadorDeAgendamentos()

        // Ligando os elementos do layout
        editTextPosto = findViewById(R.id.tela_agendamento_edit_posto)
        editTextData = findViewById(R.id.editTextDate2)
        editTextHorario = findViewById(R.id.editTextTime)
        editTextVacina = findViewById(R.id.tela_agendamentos_edit_vacina)
        btnAgendar = findViewById(R.id.tela_agendamente_bt_agendar)
        btnAlarme = findViewById(R.id.tela_agendamento_bt_alarme)
        textViewListaDeVacinas = findViewById(R.id.tela_agendamento_lista_de_vacinas_agendadas)

        // Configurando ação do botão "Agendar"
        btnAgendar.setOnClickListener {
            adicionarAgendamento()
        }

        // Configurando ação do botão "Alarme" (aqui poderia ser outro método ou ação)
        btnAlarme.setOnClickListener {
            listarAgendamentos()
        }
    }

    private fun adicionarAgendamento() {
        val posto = editTextPosto.text.toString()
        val data = editTextData.text.toString()
        val horario = editTextHorario.text.toString()
        val vacina = editTextVacina.text.toString()

        if (posto.isNotEmpty() && data.isNotEmpty() && horario.isNotEmpty() && vacina.isNotEmpty()) {
            gerenciadorDeAgendamentos.adicionarAgendamento(posto, data, horario, vacina)
            Toast.makeText(this, "Agendamento adicionado com sucesso!", Toast.LENGTH_SHORT).show()

            // Limpar os campos após adicionar
            editTextPosto.text.clear()
            editTextData.text.clear()
            editTextHorario.text.clear()
            editTextVacina.text.clear()
        } else {
            Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun listarAgendamentos() {
        val agendamentos: List<Agendamento> = gerenciadorDeAgendamentos.listarAgendamentos()
        if (agendamentos.isEmpty()) {
            textViewListaDeVacinas.text = "Nenhum agendamento encontrado."
        } else {
            val listaAgendamentos = agendamentos.joinToString("\n") { agendamento ->
                "Posto: ${agendamento.posto}, Data: ${agendamento.data}, Horário: ${agendamento.horario}, Vacina: ${agendamento.vacina} \n"
            }
            textViewListaDeVacinas.text = listaAgendamentos
        }
    }
}
