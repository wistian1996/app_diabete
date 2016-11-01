package br.com.drugstore.www.diabetes.Domain;

import android.app.ActionBar;
import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.support.annotation.Nullable;

import java.util.Calendar;

import br.com.drugstore.www.diabetes.Activitys.MainActivity;

/**
 * Created by wisti on 29/10/2016.
 */
public class Alarme extends Activity {
    int id;
    private String medicamento;
    private boolean repetir;
    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;

    Alarme(int id, String medicamento, boolean repetir, boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo) {
        this.id = id;
        this.medicamento = medicamento;
        this.repetir = repetir;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.domingo = domingo;

    }

    Alarme(String medicamento, boolean repetir, boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo) {
        this.medicamento = medicamento;
        this.repetir = repetir;
        this.segunda = segunda;
        this.terca = terca;
        this.quarta = quarta;
        this.quinta = quinta;
        this.sexta = sexta;
        this.sabado = sabado;
        this.domingo = domingo;

    }

    public int getId() {
        return id;
    }

    public String getMedicamento() {
        return medicamento;
    }

    public boolean isDomingo() {
        return domingo;
    }

    public boolean isQuarta() {
        return quarta;
    }

    public boolean isQuinta() {
        return quinta;
    }

    public boolean isRepetir() {
        return repetir;
    }

    public boolean isSabado() {
        return sabado;
    }

    public boolean isSegunda() {
        return segunda;
    }

    public boolean isSexta() {
        return sexta;
    }

    public boolean isTerca() {
        return terca;
    }

}
