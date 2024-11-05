package br.senac.vacinacao.ui.recyclerview.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.senac.vacinacao.databinding.VacinaItemBinding
import br.senac.vacinacao.model.Vacina

class ListaVacinasAdapter(
    private val context: Context,
    vacinas: List<Vacina>
) : RecyclerView.Adapter<ListaVacinasAdapter.ViewHolder>() {

    private val vacinas = vacinas.toMutableList()

    class ViewHolder(private val binding: VacinaItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun vincula(vacina: Vacina) {
            val vacinaNome = binding.vacinaItemVacina
            vacinaNome.text = vacina.nomeDaVacina
            val posto = binding.vacinaItemPosto
            posto.text = vacina.nomeDoPosto
            val data = binding.vacinaItemData
            data.text = vacina.dataDaVacina
            val reforco = binding.vacinaItemReforco
            reforco.text = vacina.reforcoData
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = VacinaItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val vacinaHolder = vacinas[position]
        holder.vincula(vacinaHolder)
    }

    override fun getItemCount(): Int = vacinas.size

    fun atualiza(vacinas: List<Vacina>) {
        this.vacinas.clear()
        this.vacinas.addAll(vacinas)
        notifyDataSetChanged()
    }
}


