package br.senac.vacinacao.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.senac.vacinacao.dao.VacinasDao
import br.senac.vacinacao.databinding.ActivityListaVacinasBinding
import br.senac.vacinacao.ui.recyclerview.adapter.ListaVacinasAdapter

class ListaVacinasActivity : AppCompatActivity() {
    private val dao = VacinasDao()
    private val adapter = ListaVacinasAdapter(context = this, vacinas = dao.buscaTodos())
    private val binding by lazy {
        ActivityListaVacinasBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configuraRecyclerView()
        configuraFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.buscaTodos())
    }

    private fun configuraFab() {
        val fab = binding.activityListaVacinasFloatingActionButton
        fab.setOnClickListener {
            vaiParaFormularioVacina()
        }
    }

    private fun vaiParaFormularioVacina() {
        val intent = Intent(this, FormularioVacinaActivity::class.java)
        startActivity(intent)
    }

    private fun configuraRecyclerView() {
        val recyclerView = binding.activityListaVacinasRecyclerView
        recyclerView.adapter = adapter
    }
}
