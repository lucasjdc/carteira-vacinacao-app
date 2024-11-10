package br.senac.card

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.senac.card.model.ViaCepResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

class PostoActivity : AppCompatActivity() {

    private lateinit var editCep: EditText
    private lateinit var buttonBuscar: Button
    private lateinit var enderecoTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_posto_saude)

        // Oculta a Action Bar
        supportActionBar?.hide()

        // Referências aos componentes
        editCep = findViewById(R.id.tela_posto_saude_edit_cep)                     // onde o usuário digita o CEP
        buttonBuscar = findViewById(R.id.tela_posto_saude_bt_buscar)               // botão de buscar
        enderecoTextView = findViewById(R.id.enderereco_do_posto_saude_pelo_cep)       // exibir o endereço

        // Configura o clique do botão
        buttonBuscar.setOnClickListener {
            val cep = editCep.text.toString().trim()
            if (cep.isNotEmpty()) {
                buscarEndereco(cep)
            } else {
                Toast.makeText(this, "Por favor, insira um CEP", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buscarEndereco(cep: String) {
        // Faz a chamada à API ViaCEP
        RetrofitClient.viaCepService.buscaCep(cep).enqueue(object : Callback<ViaCepResponse> {
            override fun onResponse(call: Call<ViaCepResponse>, response: Response<ViaCepResponse>) {
                if (response.isSuccessful) {
                    val endereco = response.body()
                    if (endereco != null) {
                        enderecoTextView.text = "Endereço: ${endereco.logradouro}, ${endereco.bairro}, ${endereco.localidade} - ${endereco.uf}"
                    } else {
                        enderecoTextView.text = "Endereço não encontrado"
                    }
                } else {
                    enderecoTextView.text = "Erro na busca do endereço"
                }
            }

            override fun onFailure(call: Call<ViaCepResponse>, t: Throwable) {
                enderecoTextView.text = "Erro de conexão: ${t.message}"
            }
        })
    }

    interface ViaCepService {
        @GET("{cep}/json/")
        fun buscaCep(@Path("cep") cep: String): Call<ViaCepResponse>
    }

    object RetrofitClient {
        private const val BASE_URL = "https://viacep.com.br/ws/"

        val viaCepService: ViaCepService by lazy {
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(ViaCepService::class.java)
        }
    }
}
