package br.senac.vacinacao.dao

import br.senac.vacinacao.model.Vacina


class VacinasDao {
    fun adiciona(vacina: Vacina) {
        vacinas.add(vacina)
    }

    fun buscaTodos() : List<Vacina> {
        return vacinas.toList()
    }

    companion object {
        private val vacinas = mutableListOf<Vacina>()
    }
}