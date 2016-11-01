package br.com.drugstore.www.diabetes.Activitys;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TimePicker;
import android.widget.Toast;

import java.net.URI;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import br.com.drugstore.www.diabetes.Domain.Alarme;
import br.com.drugstore.www.diabetes.Domain.BroadcastReceiver1;
import br.com.drugstore.www.diabetes.Fragments.FragmentMedicamentos;
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
    Button buttonSalvarAlarme;
    EditText editTextNomeMedicamento;
    Context context;
    Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_config_alarme);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayoutDias);
        checkBoxRepetir = (CheckBox) findViewById(R.id.checkBoxRepetir);
        checkBoxDomingo = (CheckBox) findViewById(R.id.checkBoxDomingo);
        checkBoxSegunda = (CheckBox) findViewById(R.id.checkBoxSegunda);
        checkBoxTerca = (CheckBox) findViewById(R.id.checkBoxTerca);
        checkBoxQuarta = (CheckBox) findViewById(R.id.checkBoxQuarta);
        checkBoxQuinta = (CheckBox) findViewById(R.id.checkBoxQuinta);
        checkBoxSexta = (CheckBox) findViewById(R.id.checkBoxSexta);
        checkBoxSabado = (CheckBox) findViewById(R.id.checkBoxSabado);
        //inicializando o time picker
        this.timePicker = (TimePicker) findViewById(R.id.timePicker);
        buttonSalvarAlarme = (Button) findViewById(R.id.buttonSalvarAlarme);
        this.context = this;
        linearLayout.setVisibility(View.GONE);


        // inicializando alarm manager

        alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);

        // criando uma instancia para o calendario
        calendar = Calendar.getInstance();
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
                    Toast toast = Toast.makeText(getApplicationContext(), "Repetir", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    linearLayout.setVisibility(View.GONE);
                    Toast toast = Toast.makeText(getApplicationContext(), "Não repetir", Toast.LENGTH_SHORT);
                    toast.show();
                }

            }
        });

    }

    public void actionButtonSalvarAlarme() {
        buttonSalvarAlarme.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                calendar.set(Calendar.HOUR_OF_DAY, timePicker.getHour());
                calendar.set(Calendar.MINUTE, timePicker.getMinute());
                gerarAlarme();

            }
        });

    }

// gerar notificacao

    public void gerarNotificacao() {
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // texto rapido que aparece na notificacao
        builder.setTicker("Alarme");
        // titulo da notificao que ficara amostra do usuario
        builder.setContentTitle("Tomar remedio");
        // texto menor que aparece na notificacao
        builder.setContentText("Tome seu remedio");
        // icone pequeno que aparece no canto
        builder.setSmallIcon(R.drawable.icon_relogio);
        // icone grande
        builder.setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.icon_medicamentos));
        builder.setContentIntent(p);

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
        // acresentando um tempo a mais para saber se esta funcionando
        c.add(Calendar.SECOND, 5);

        SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
        Date d = new Date(c.getTime().getTime());
        String dayOfTheWeek = sdf.format(d);

        Toast toast = Toast.makeText(getApplicationContext(), dayOfTheWeek , Toast.LENGTH_SHORT);
        toast.show();

        Intent intent = new Intent(this, BroadcastReceiver1.class);
        PendingIntent p = PendingIntent.getBroadcast(this,0,intent,0);

        AlarmManager alarm = (AlarmManager) getSystemService(ALARM_SERVICE);

        alarm.set(AlarmManager.RTC_WAKEUP , c.getTimeInMillis(),p);


    }



}
