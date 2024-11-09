package br.senac.card.model

data class Agendamento(
    var posto: String,
    var data: String,
    var horario: String,
    var vacina: String
)

class GerenciadorDeAgendamentos {
    private val agendamentos = mutableListOf<Agendamento>()

    // Método para adicionar um novo agendamento
    fun adicionarAgendamento(posto: String, data: String, horario: String, vacina: String): Agendamento {
        val novoAgendamento = Agendamento(posto, data, horario, vacina)
        agendamentos.add(novoAgendamento)
        return novoAgendamento
    }

    // Método para editar um agendamento existente
    fun editarAgendamento(posto: String, data: String, horario: String, vacina: String, novoPosto: String, novaData: String, novoHorario: String, novaVacina: String): Boolean {
        val agendamento = agendamentos.find {
            it.posto == posto && it.data == data && it.horario == horario && it.vacina == vacina
        }
        return if (agendamento != null) {
            agendamento.posto = novoPosto
            agendamento.data = novaData
            agendamento.horario = novoHorario
            agendamento.vacina = novaVacina
            true
        } else {
            false
        }
    }

    // Método para remover um agendamento
    fun removerAgendamento(posto: String, data: String, horario: String, vacina: String): Boolean {
        return agendamentos.removeIf {
            it.posto == posto && it.data == data && it.horario == horario && it.vacina == vacina
        }
    }

    // Método para listar todos os agendamentos
    fun listarAgendamentos(): List<Agendamento> {
        return agendamentos
    }

    // Método para obter a lista de andendamentos
    fun obterAgendamentos(): List<Agendamento> {
        return agendamentos
    }
}
