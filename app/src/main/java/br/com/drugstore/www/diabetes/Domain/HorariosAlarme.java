package br.com.drugstore.www.diabetes.Domain;

/**
 * Created by wisti on 31/10/2016.
 */
public class HorariosAlarme {
    private int id;
    private int idAlarme;
    private int hour;
    private int minute;

    HorariosAlarme(int id , int idAlarme, int hour , int minute){
        this.idAlarme = idAlarme;
        this.id = id;
        this.hour = hour;
        this.minute = minute;

    }

    HorariosAlarme(int idAlarme, int hour , int minute){
        this.idAlarme = idAlarme;
        this.id = id;
        this.hour = hour;
        this.minute = minute;

    }

    public int getId() {
        return id;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }
}
