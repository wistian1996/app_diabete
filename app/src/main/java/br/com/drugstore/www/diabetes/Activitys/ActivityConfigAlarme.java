package br.com.drugstore.www.diabetes.Activitys;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.drugstore.www.diabetes.DAO.DAOAlarme;
import br.com.drugstore.www.diabetes.Domain.Alarme;
import br.com.drugstore.www.diabetes.Domain.BroadcastReceiver1;
import br.com.drugstore.www.diabetes.R;

public class ActivityConfigAlarme extends AppCompatActivity {

    private AlarmManager alarmManager;
    private TimePicker timePicker;
    private CheckBox checkBoxRepetir;
    private CheckBox checkBoxSegunda;
    private CheckBox checkBoxTerca;
    private CheckBox checkBoxQuarta;
    private CheckBox checkBoxQuinta;
    private CheckBox checkBoxSexta;
    private CheckBox checkBoxSabado;
    private CheckBox checkBoxDomingo;
    private LinearLayout linearLayout;
    private Button buttonSalvarAlarme;
    private EditText editTextNomeMedicamento;
    private EditText editTextDosagem;
    private Context context;
    private Calendar calendar;
    private int hora;
    private int minuto;
    private Alarme alarme;
    private DAOAlarme daoAlarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_config_alarme);

        editTextNomeMedicamento = (EditText) findViewById(R.id.et_nomeMedicamento);
        editTextDosagem = (EditText) findViewById(R.id.et_dosagem);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutDias);
        checkBoxRepetir = (CheckBox) findViewById(R.id.checkBoxRepetir);
        checkBoxDomingo = (CheckBox) findViewById(R.id.checkBoxDomingo);
        checkBoxSegunda = (CheckBox) findViewById(R.id.checkBoxSegunda);
        checkBoxTerca = (CheckBox) findViewById(R.id.checkBoxTerca);
        checkBoxQuarta = (CheckBox) findViewById(R.id.checkBoxQuarta);
        checkBoxQuinta = (CheckBox) findViewById(R.id.checkBoxQuinta);
        checkBoxSexta = (CheckBox) findViewById(R.id.checkBoxSexta);
        checkBoxSabado = (CheckBox) findViewById(R.id.checkBoxSabado);
        alarme = new Alarme();

        daoAlarme = new DAOAlarme(getApplicationContext());
        // inicializando o time picker
        timePicker = (TimePicker) findViewById(R.id.timePicker);
        // inicializando calendário
        calendar = Calendar.getInstance();

        buttonSalvarAlarme = (Button) findViewById(R.id.buttonSalvarAlarme);

        this.context = this;

        linearLayout.setVisibility(View.GONE);
        // inicializando alarm manager
        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        // açao para o botao
        actionButtonSalvarAlarme();
        actionRaddioRepetir();
    }

    public void actionRaddioRepetir() {
        checkBoxRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (checkBoxRepetir.isChecked()) {
                    linearLayout.setVisibility(View.VISIBLE);
                } else {
                    linearLayout.setVisibility(View.GONE);
                }
            }
        });
    }

    public void actionButtonSalvarAlarme() {
        buttonSalvarAlarme.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                // get dados do medicamento
                String nomeMedicamento = editTextNomeMedicamento.getText().toString();
                String dosagem = editTextDosagem.getText().toString();

                // set horario selecionado pelo usuário
                // quando ocorre uma alteração no timePicker, este método é chamado
                timePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
                    @Override
                    public void onTimeChanged(TimePicker timePicker, int _hora, int _minuto) {
                        // nao esta funcionando
                        hora = _hora;
                        minuto = _minuto;
                        resetCadastro();
                        return;
                    }
                });

                if(checkCampos(nomeMedicamento,dosagem)){
                    // caso não ocorra nenhum erro
                    alarme.setMedicamento(nomeMedicamento);
                    alarme.setDosagem(Double.parseDouble(dosagem));
                    Log.d("Log Alarme",alarme.toString());
                    long resultado = daoAlarme.inserirAlarme(alarme);
                    if(resultado > 0){
                        Toast.makeText(getApplicationContext(),"Alarme cadastrado com sucesso!",Toast.LENGTH_SHORT).show();
                        resetCadastro();
                    }
                }
               gerarAlarme();
            }
        });

    }

    /**
     * verifica os checkbox
     * caso o check repetir esteja habilitado, deve ter pelo menos 1 dia selecionado
     * realiza o set dos dias da semana
     */
    public boolean isCheckBox(){
        // variavel de check se pelo menos 1 dia foi selecionado
        boolean select = false;
        // check segunda
        if(checkBoxSegunda.isChecked()){
            Log.d("Teste Marcação", "segunda");
            alarme.setSegunda(true);
            select = true;
        }else{
            alarme.setSegunda(false);
        }
        // check terça
        if(checkBoxTerca.isChecked()){
            Log.d("Teste Marcação", "terca");
            alarme.setTerca(true);
            select = true;
        }else{
            alarme.setTerca(false);
        }
        // check quarta
        if(checkBoxQuarta.isChecked()){
            Log.d("Teste Marcação", "quarta");
            alarme.setQuarta(true);
            select = true;
        }else{
            alarme.setQuarta(false);
        }
        // check quinta
        if(checkBoxQuinta.isChecked()){
            Log.d("Teste Marcação", "quinta");
            alarme.setQuinta(true);
            select = true;
        }else{
            alarme.setQuinta(false);
        }
        // check sexta
        if(checkBoxSexta.isChecked()){
            Log.d("Teste Marcação", "sexta");
            alarme.setSexta(true);
            select = true;
        }else{
            alarme.setSexta(false);
        }
        // check sabado
        if(checkBoxSabado.isChecked()){
            Log.d("Teste Marcação", "sabado");
            alarme.setSabado(true);
            select = true;
        }else{
            alarme.setSabado(false);
        }
        // check domingo
        if(checkBoxDomingo.isChecked()){
            Log.d("Teste Marcação", "domingo");
            alarme.setDomingo(true);
            select = true;
        }else{
            alarme.setDomingo(false);
        }
        return select;
    }

    /**
     * caso não seja habilitado a opção de repetir, deve ser chamado esta função
     * se não estiver repetição, significa que o alarme é para o dia atual, logo,
     * verifica se o horario selecionado é maior que o horario atual
     */
    public boolean checkHorario(){
        int horaAtual = calendar.get(Calendar.HOUR_OF_DAY);
        int minutoAtual = calendar.get(Calendar.MINUTE);

        Log.d("Teste Horario Atual","Horario Atual "+horaAtual+" | "+"Minuto Atual "+minutoAtual);
        Log.d("Teste Horario Escolhido","Horario "+hora+" | "+"Minuto "+minuto);

        if(hora > horaAtual){
            return true;
        }

        if(hora == horaAtual){
            if(minuto > minutoAtual){
                return true;
            }
            if(minuto == minutoAtual){
                return false;
            }
        }
        return false;
    }

    /**
     * realiza o checkup de todos os campos antes de inserir o alarme
     */
    public boolean checkCampos(String nomeMedicamento, String dosagem){
        // caso não preencha o nome do medicamento
        if(nomeMedicamento.length() == 0){
            editTextNomeMedicamento.setError("Preencha o nome do medicamento!");
            editTextNomeMedicamento.requestFocus();
            return false;
        }
        // caso não preencha o valor da dosagem
        if(dosagem.length() == 0){
            editTextDosagem.setError("Preencha o valor de dosagem!");
            editTextDosagem.requestFocus();
            return false;
        }
        // caso tenha selecionado a opção de repetir e não escolhido pelo menos 1 dia da semana
        if(checkBoxRepetir.isChecked()){
            if(!isCheckBox()){
                Toast.makeText(getApplicationContext(),"Escolha os dias que devem repetir o alarme!",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        // caso não seja selecionado a opção de repetir, o alarme será para o dia atual
        // logo, precisar validar o horário
        else{
            if(!checkHorario()){
                Toast.makeText(getApplicationContext(),"Informe um horário válido!",Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        // caso não ocorra algum erro
        return true;
    }

    /**
     * realiza o reset do cadastro
     */
    public void resetCadastro(){
        editTextDosagem.setText("");
        editTextNomeMedicamento.setText("");
        checkBoxRepetir.setChecked(false);
        checkBoxDomingo.setChecked(false);
        checkBoxSegunda.setChecked(false);
        checkBoxTerca.setChecked(false);
        checkBoxQuarta.setChecked(false);
        checkBoxQuinta.setChecked(false);
        checkBoxSexta.setChecked(false);
        checkBoxSabado.setChecked(false);
        linearLayout.setVisibility(View.GONE);
    }


    // gerar notificacao
    public void gerarNotificacao() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // texto rapido que aparece na notificacao
        builder.setTicker("Hora do remedio");
        // titulo da notificao que ficara amostra do usuario
        builder.setContentTitle("Tomar remedio");
        // texto menor que aparece na notificacao
        builder.setContentText("Tome seu remedio");
        // icone pequeno que aparece no canto
        builder.setSmallIcon(R.drawable.icon_relogio);
        // icone grande
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_medicamentos));
        builder.setContentIntent(p);
/*
        // adicionar mais textos na notificacao
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        ArrayList<String> listaTextos = new ArrayList<>();
        listaTextos.add("Texto teste 1");
        listaTextos.add("Texto teste teste tamanho maior 1");
        listaTextos.add("Texto teste tamanho maior 2");

        for (String listaT : listaTextos) {
            style.addLine(listaT);
        }
        builder.setStyle(style);
*/
        //trabalhando a notificacao
        Notification n = builder.build();
        //fazer ele vibrar

        //mililegundos  espera , vibracao , espera, vibracao

        // caso eu queira setar manualmente a vibracao
        //n.vibrate = new long[]{1000, 1000, 1000, 1000};

        //valores defaults
        n.defaults |= Notification.DEFAULT_VIBRATE;
        n.defaults |= Notification.DEFAULT_SOUND;

        // caso queira desativar a notificaaco automatico
        // n.flags = Notification.FLAG_AUTO_CANCEL;
        // cor do LED
        builder.setLights(Color.GREEN, 3000, 3000);


        //id da notificacao
        nm.notify(R.drawable.icon_relogio, n);


        // caso queira definiar o toque manualmente
/*
        try {
            Uri som = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
            Ringtone toque = RingtoneManager.getRingtone(this, som);
            toque.play();
        } catch (Exception e) {

        }
        */
        // final acessar a classe que abre ao clicar na notification e remover a notificacao
    }

    public void gerarAlarme(){

        //pegando o tempo atual do sistema em milisegundos

        Calendar c = Calendar.getInstance();
        // definir a hora que vai ser disparado o alaarme
        c.setTimeInMillis(System.currentTimeMillis());
        // alterando a hora do calendario

        c.set(Calendar.HOUR_OF_DAY, timePicker.getCurrentHour()); //zerando as horas, minuots e segundos..
        c.set(Calendar.MINUTE, timePicker.getCurrentMinute() );
        c.set(Calendar.SECOND, 0);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

        Date d = new Date(c.getTime().getTime());
        String dayOfTheWeek = sdf.format(d);

        Toast toast = Toast.makeText(getApplicationContext(),"Lembrete adicionado para:"+ timePicker.getCurrentHour()+ ":"+  timePicker.getCurrentMinute() + " "+ dayOfTheWeek , Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, BroadcastReceiver1.class);
        PendingIntent p = PendingIntent.getBroadcast(this,0,intent,0);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarm.set(AlarmManager.RTC_WAKEUP , c.getTimeInMillis(),p);


    }

}
