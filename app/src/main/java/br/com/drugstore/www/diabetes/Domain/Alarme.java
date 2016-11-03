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
    private int id;
    private double dosagem;
    private String medicamento;
    private boolean repetir;
    private boolean segunda;
    private boolean terca;
    private boolean quarta;
    private boolean quinta;
    private boolean sexta;
    private boolean sabado;
    private boolean domingo;

    public Alarme() {
    }

    public Alarme(int id, String medicamento, double dosagem, boolean repetir, boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo) {
        this.dosagem = dosagem;
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

    public Alarme(String medicamento, double dosagem ,boolean repetir, boolean segunda, boolean terca, boolean quarta, boolean quinta, boolean sexta, boolean sabado, boolean domingo) {
        this.dosagem = dosagem;
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

    public Double getDosagem() {
        return dosagem;
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

    public void setId(int id) {
        this.id = id;
    }

    public void setDosagem(double dosagem) {
        this.dosagem = dosagem;
    }

    public void setMedicamento(String medicamento) {
        this.medicamento = medicamento;
    }

    public void setRepetir(boolean repetir) {
        this.repetir = repetir;
    }

    public void setSegunda(boolean segunda) {
        this.segunda = segunda;
    }

    public void setTerca(boolean terca) {
        this.terca = terca;
    }

    public void setQuarta(boolean quarta) {
        this.quarta = quarta;
    }

    public void setQuinta(boolean quinta) {
        this.quinta = quinta;
    }

    public void setSexta(boolean sexta) {
        this.sexta = sexta;
    }

    public void setSabado(boolean sabado) {
        this.sabado = sabado;
    }

    public void setDomingo(boolean domingo) {
        this.domingo = domingo;
    }

    @Override
    public String toString() {
        String log = "Medicamento: "+getMedicamento()+"\n";
        log += "Dosagem: "+getDosagem()+"\n";
        log += "Seg: "+isSegunda()+"\n";
        log += "Ter: "+isTerca()+"\n";
        log += "Qua: "+isQuarta()+"\n";
        log += "Qui: "+isQuinta()+"\n";
        log += "Sex: "+isSexta()+"\n";
        log += "Sab: "+isSabado()+"\n";
        log += "Dom: "+isDomingo()+"\n";
        return log;
    }
}
