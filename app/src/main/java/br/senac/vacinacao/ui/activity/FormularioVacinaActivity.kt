package br.senac.vacinacao.ui.activity

import android.os.Build
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import br.senac.vacinacao.dao.VacinasDao
import br.senac.vacinacao.databinding.ActivityFormularioVacinaBinding
import br.senac.vacinacao.model.Vacina

class FormularioVacinaActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityFormularioVacinaBinding.inflate(layoutInflater)
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configurarBotaoSalvar()
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun configurarBotaoSalvar() {
        val botaoSalvar = binding.activityFormularioVacinaBotaoSalvar
        val dao = VacinasDao()
        botaoSalvar.setOnClickListener {
            val vacinaNova = criaVacina()
            dao.adiciona(vacinaNova)
            finish()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun criaVacina(): Vacina {
        val campoVacina = binding.activityFormularioVacinaVacina
        val vacina = campoVacina.text.toString()
        val campoPosto = binding.activityFormularioVacinaPosto
        val posto = campoPosto.text.toString()
        val campoData = binding.activityFormularioVacinaData
        val data = campoData.text.toString()
        val campoReforco = binding.activityFormularioVacinaReforco
        val reforco = campoReforco.text.toString()

        return Vacina(
            nomeDaVacina = vacina,
            nomeDoPosto = posto,
            dataDaVacina = data,
            reforcoData = reforco
        )
    }
}