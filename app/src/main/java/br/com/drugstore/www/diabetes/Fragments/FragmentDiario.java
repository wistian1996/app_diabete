package br.com.drugstore.www.diabetes.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.drugstore.www.diabetes.DAO.DAODiario;
import br.com.drugstore.www.diabetes.Domain.Diario;
import br.com.drugstore.www.diabetes.R;


public class FragmentDiario extends Fragment {
    private Button buttonSalvar;
    private CalendarView calendarView;
    private EditText editTextAnotacao;
    private EditText editTextValor;
    private DAODiario sqliteDiario = new DAODiario(getContext());
    private String anotacao;
    private String valor;
    ArrayList<Diario> diarioRetorno;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_diario, container, false);

        buttonSalvar = (Button) view.findViewById(R.id.buttonSalvar);
        calendarView = (CalendarView) view.findViewById(R.id.calendarView);
        editTextAnotacao = (EditText) view.findViewById(R.id.editTextAnotacao);
        editTextValor = (EditText) view.findViewById(R.id.editTextValor);


        //acao do botao salvar

        buttonSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Date data = new Date(calendarView.getDate());

// verificando se ja há alguma anotacao caso haja tera que substituir
                if (diarioRetorno == null) {
                    try {
                        anotacao = editTextAnotacao.getText().toString();
                        valor = editTextValor.getText().toString();
                        Diario d = new Diario(data, anotacao, Double.parseDouble(valor));
                       long i= sqliteDiario.inserirDiario(d);
                        if (i != -1){
                            Toast toast = Toast.makeText(getContext(), "Anotação cadastrada com sucesso!", Toast.LENGTH_SHORT);
                            toast.show();
                        }

                    } catch (Exception e) {
                        Toast toast = Toast.makeText(getContext(), "Informe os campos corretamente!", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }


            }
        });

        //acao do calendario

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {

                Date data = new Date(view.getDate());
                diarioRetorno = sqliteDiario.getDiario(data);

                if (diarioRetorno != null) {
                    editTextAnotacao.setText(diarioRetorno.get(0).getAnotacao());
                    editTextValor.setText(String.valueOf(diarioRetorno.get(0).getGlicemia()));
                }
            }
        });


        //  return inflater.inflate(R.layout.fragment_diario, container, false);
        return view;
    }


}



