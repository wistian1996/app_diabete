package br.com.drugstore.www.diabetes.Domain;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.support.v7.app.NotificationCompat;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;

import br.com.drugstore.www.diabetes.Activitys.MainActivity;
import br.com.drugstore.www.diabetes.R;

/**
 * Created by wisti on 31/10/2016.
 */
public class BroadcastReceiver1 extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        // dura apenas 10 segundos , caso passe tera q criar uma servico

       gerarNotificacaoTomarRemedio(context, new Intent(context , MainActivity.class));
    }

    // gerar notificacao

    public void gerarNotificacaoTomarRemedio(Context context, Intent intent) {
        NotificationManager nm = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
       // PendingIntent p = PendingIntent.getActivity(this, 0, new Intent(this, MainActivity.class), 0);

        PendingIntent p = PendingIntent.getActivity(context,0,intent,0);

        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        // texto rapido que aparece na notificacao
        builder.setTicker("Alarme");
        // titulo da notificao que ficara amostra do usuario
        builder.setContentTitle("Tomar remedio");
        // texto menor que aparece na notificacao
        builder.setContentText("Tome seu remedio");
        // icone pequeno que aparece no canto
        builder.setSmallIcon(R.drawable.icon_relogio);
        // icone grande
        builder.setLargeIcon(BitmapFactory.decodeResource(context.getResources(), R.drawable.icon_medicamentos));
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
        builder.setLights(Color.RED, 3000, 3000);


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


}
