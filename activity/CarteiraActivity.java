package br.senac.vaccine.ui.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import br.senac.vaccine.R;

public class CarteiraActivity extends AppCompatActivity {

    private EditText edVacina;
    private EditText edPosto;
    private EditText edData;
    private EditText edReforco;
    private Button btSalvar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activitity_carteira);

        edVacina = findViewById(R.id.activity_carteira_edit_vacina);
        edPosto = findViewById(R.id.activity_carteira_edit_posto);
        edData = findViewById(R.id.activity_carteira_edit_data);
        edReforco = findViewById(R.id.activity_carteira_edit_reforco);
        btSalvar = findViewById(R.id.activity_carteira_btSalvar);
    }
}
