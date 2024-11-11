package br.senac.vaccine.ui.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import br.senac.vaccine.R;

public class CadastroActivity extends AppCompatActivity {
    private EditText editNewUsuario;
    private EditText editTextTextEmailAddress;
    private EditText editNewSenha;
    private EditText editTextConfirmeSenha;
    private Button btnCriarConta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_cadastro);

        editNewUsuario = findViewById(R.id.editNewUsuario);
        editTextTextEmailAddress = findViewById(R.id.editTextTextEmailAddress);
        editNewSenha = findViewById(R.id.editNewSenha);
        editTextConfirmeSenha = findViewById(R.id.editTextConfirmeSenha);
        btnCriarConta = findViewById(R.id.btnCriarConta);

        btnCriarConta.setOnClickListener(v -> {
            String usuario = editNewUsuario.getText().toString();
            String email = editTextTextEmailAddress.getText().toString();
            String senha = editNewSenha.getText().toString();
            String confirmaSenha = editTextConfirmeSenha.getText().toString();

            if (usuario.isEmpty() || senha.isEmpty() || email.isEmpty() || confirmaSenha.isEmpty()) {
                Toast.makeText(this, "Por favor, preencha todos os campos", Toast.LENGTH_SHORT).show();
            } else if (!senha.equals(confirmaSenha)) {
                Toast.makeText(this, "As senhas não coincidem", Toast.LENGTH_SHORT).show();
            } else {
                SharedPreferences sharedPreferences = getSharedPreferences("UserPrefs", MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Usuario", usuario);
                editor.putString("Email", email);
                editor.putString("Senha", senha);
                editor.putString("ConfirmaSenha", confirmaSenha);
                editor.apply();

                Toast.makeText(this, "Cadastro realizado com sucesso!", Toast.LENGTH_SHORT).show();

                // Redireciona o usuário de volta para a tela de login
                Intent intent = new Intent(this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}

