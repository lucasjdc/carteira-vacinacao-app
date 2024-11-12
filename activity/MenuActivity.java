package br.senac.vaccine.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import br.senac.vaccine.R;

public class MenuActivity extends AppCompatActivity {
    private Button btPerfil;
    private Button btCarteira;
    private Button btAgendamentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }

        setContentView(R.layout.activity_menu);

        btPerfil = findViewById(R.id.btPerfil);
        btCarteira = findViewById(R.id.btCarteira);
        btAgendamentos = findViewById(R.id.btAgendamentos);

        // Ação do botão Meu Perfil
        btPerfil.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, PerfilActivity.class);
            startActivity(intent);
            Log.i("MenuActivity:","botão Perfil pressionado");
        });

        // Ação do botão Carteira
        btCarteira.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, CarteiraActivity.class);
            startActivity(intent);
            Log.i("MenuActivity:","botão Carteira pressionado");
        });

        // Ação do botão Agendamentos
        btAgendamentos.setOnClickListener(v -> {
            Intent intent = new Intent(MenuActivity.this, AgendamentosActivity.class);
            startActivity(intent);
            Log.i("MenuActivity:","botão Agendamentos pressionado");
        });
    }
}
