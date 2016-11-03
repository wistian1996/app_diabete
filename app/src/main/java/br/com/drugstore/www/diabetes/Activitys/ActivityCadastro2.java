package br.com.drugstore.www.diabetes.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import br.com.drugstore.www.diabetes.DAO.DAOUsuario;
import br.com.drugstore.www.diabetes.R;

public class ActivityCadastro2 extends AppCompatActivity {


    private Button buttonAvancar;
    private RadioGroup radioGroup;
    // iteração com o banco de dados da tabela usuario
    private DAOUsuario daoUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);

        buttonAvancar = (Button) findViewById(R.id.buttonAvancar);
        radioGroup = (RadioGroup) findViewById(R.id.radioGrupo);
        //definindo acao para o botao avancar
        buttonAvancar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // seleciona o radiobutton do grupo
                int selecionado = radioGroup.getCheckedRadioButtonId();
                // checa qual radiobutton foi selecionado e seta o tipo de diabete do usuario a ser cadastrado
                switch (selecionado){
                    case R.id.rbTipo1:
                        ActivityCadastro.usuario.setTipoDiabete("Tipo 1");
                    case R.id.rbTipo2:
                        ActivityCadastro.usuario.setTipoDiabete("Tipo 2");
                    case R.id.rbOutro:
                        ActivityCadastro.usuario.setTipoDiabete("Outro");
                    default:
                        break;
                }
                // faz a inserção do usuário no banco
                daoUsuario = new DAOUsuario(getApplicationContext());
                long i = daoUsuario.inserirUsuario(ActivityCadastro.usuario);
                if(i > 0){
                    Toast.makeText(getApplicationContext(),"Usuário cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
                    telaPrincipal();
                }else{
                    Toast.makeText(getApplicationContext(),"Erro ao cadastrar",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // chama a tela principal
    public void telaPrincipal(){
        Intent intent = new Intent(ActivityCadastro2.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}
