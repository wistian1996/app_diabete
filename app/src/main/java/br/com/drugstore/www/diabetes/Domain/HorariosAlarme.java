package br.com.drugstore.www.diabetes.Domain;

import java.util.Date;

/**
 * Created by wisti on 31/10/2016.
 */
public class HorariosAlarme {
    private int id;
    private int idAlarme;
    private Date horario;

    public HorariosAlarme() {
    }

    public HorariosAlarme(int id, int idAlarme, Date horario) {
        this.id = id;
        this.idAlarme = idAlarme;
        this.horario = horario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdAlarme() {
        return idAlarme;
    }

    public void setIdAlarme(int idAlarme) {
        this.idAlarme = idAlarme;
    }

    public Date getHorario() {
        return horario;
    }

    public void setHorario(Date horario) {
        this.horario = horario;
    }

}
