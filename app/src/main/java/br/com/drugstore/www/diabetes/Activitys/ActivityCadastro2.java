package br.com.drugstore.www.diabetes.Activitys;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import br.com.drugstore.www.diabetes.R;

public class ActivityCadastro2 extends AppCompatActivity {


    private Button buttonAvancar;
    private RadioButton radioButton1;
    private RadioButton radioButton2;
    private RadioButton radioButtonOutro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro2);

        buttonAvancar = (Button) findViewById(R.id.buttonAvancar);
        radioButton1 = (RadioButton) findViewById(R.id.radioButton1);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButtonOutro = (RadioButton) findViewById(R.id.radioButtonOutro);

        //definindo acao para o botao avancar
     buttonAvancar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View v) {
             Intent intent = new Intent(ActivityCadastro2.this, MainActivity.class);
            startActivity(intent);
             finish();
         }
     });

    }

}
