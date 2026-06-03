package com.fitplan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "ejercicios")
public class Ejercicio {

    @Id
    private String id;
    private String nombre;
    private int series;
    private int repeticiones;
    private int descansoSegundos;
    private String grupoMuscular;
    private ObjetivoFisico objetivo;

    public Ejercicio() {}

    public Ejercicio(String nombre, int series, int repeticiones,
                     int descansoSegundos, String grupoMuscular, ObjetivoFisico objetivo) {
        this.nombre = nombre;
        this.series = series;
        this.repeticiones = repeticiones;
        this.descansoSegundos = descansoSegundos;
        this.grupoMuscular = grupoMuscular;
        this.objetivo = objetivo;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getSeries() { return series; }
    public void setSeries(int series) { this.series = series; }
    public int getRepeticiones() { return repeticiones; }
    public void setRepeticiones(int repeticiones) { this.repeticiones = repeticiones; }
    public int getDescansoSegundos() { return descansoSegundos; }
    public void setDescansoSegundos(int descansoSegundos) { this.descansoSegundos = descansoSegundos; }
    public String getGrupoMuscular() { return grupoMuscular; }
    public void setGrupoMuscular(String grupoMuscular) { this.grupoMuscular = grupoMuscular; }
    public ObjetivoFisico getObjetivo() { return objetivo; }
    public void setObjetivo(ObjetivoFisico objetivo) { this.objetivo = objetivo; }
}
