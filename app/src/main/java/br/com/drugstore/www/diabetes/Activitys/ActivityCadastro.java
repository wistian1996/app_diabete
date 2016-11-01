package br.com.drugstore.www.diabetes.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import br.com.drugstore.www.diabetes.Domain.Usuario;
import br.com.drugstore.www.diabetes.R;

public class ActivityCadastro extends AppCompatActivity {
    private Spinner spinnerSexo;
    private Button buttonAvancar;
    private EditText editTextNome;
    private EditText editTextIdade;
    // serve para listar as opçoes no spinner e no list view
    private ArrayAdapter<String> opcoesSpinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_cadastro);
        editTextNome = (EditText) findViewById(R.id.editTextNome);
        editTextIdade = (EditText) findViewById(R.id.editTextIdade);
        spinnerSexo = (Spinner) findViewById(R.id.spinnerSexo);
        buttonAvancar = (Button) findViewById(R.id.buttonAvancar);

        // definindo spinner
        opcoesSpinner = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item);
        // define onde vai ficar os itens do spinner
        //opcoesSpinner.setDropDownViewResource(android.R.layout.simple_spinner_item);
        spinnerSexo.setAdapter(opcoesSpinner);

        opcoesSpinner.add("Informe seu sexo");
        opcoesSpinner.add("Masculino");
        opcoesSpinner.add("Feminino");

        //definindo acao para o botao
        buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (verificarCampos()) {

                    Intent intent = new Intent(ActivityCadastro.this, ActivityCadastro2.class);
                    startActivity(intent);
                    finish();
                }

            }
        });


    }

    private boolean verificarCampos() {

        int idade;
        String sexo;
        String nome;

        try {
            idade = Integer.parseInt(editTextIdade.getText().toString());
            if (idade <= 0 || idade > 150) {
                editTextIdade.setError("Idade inválida!");
                return false;
            }
        } catch (Exception e) {
            editTextIdade.setError("Idade inválida!");
            return false;
        }

        try {
            nome = editTextNome.getText().toString();


            if (nome.trim().equals("")) {
                // exibindo mensagem na tela
                editTextNome.setError("Preencha seu nome!");
                return false;
            }

        } catch (Exception e) {
            editTextNome.setError("Nome inválido");
            return false;
        }

        sexo = spinnerSexo.getSelectedItem().toString();

        if (sexo.equals("Informe seu sexo")) {
            Toast toast = Toast.makeText(getApplicationContext(), "Selecione seu sexo", Toast.LENGTH_SHORT);
            toast.show();
            return false;
        }

        return true;
    }
}
