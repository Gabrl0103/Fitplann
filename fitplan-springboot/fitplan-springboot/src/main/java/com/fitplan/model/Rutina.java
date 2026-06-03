package com.fitplan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "rutinas")
public class Rutina {

    @Id
    private String id;
    private String usuarioId;
    private String nombre;
    private ObjetivoFisico objetivo;
    private LocalDate fechaCreacion;
    private boolean completada;
    private List<String> ejercicioIds = new ArrayList<>();

    public Rutina() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public ObjetivoFisico getObjetivo() { return objetivo; }
    public void setObjetivo(ObjetivoFisico objetivo) { this.objetivo = objetivo; }
    public LocalDate getFechaCreacion() { return fechaCreacion; }
    public void setFechaCreacion(LocalDate fechaCreacion) { this.fechaCreacion = fechaCreacion; }
    public boolean isCompletada() { return completada; }
    public void setCompletada(boolean completada) { this.completada = completada; }
    public List<String> getEjercicioIds() { return ejercicioIds; }
    public void setEjercicioIds(List<String> ejercicioIds) { this.ejercicioIds = ejercicioIds; }
}
