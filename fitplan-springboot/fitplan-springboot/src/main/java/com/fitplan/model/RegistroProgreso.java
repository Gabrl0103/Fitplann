package com.fitplan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDate;

@Document(collection = "registros_progreso")
public class RegistroProgreso {

    @Id
    private String id;
    private String usuarioId;
    private LocalDate fecha;
    private double peso;
    private String notas;

    public RegistroProgreso() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public String getNotas() { return notas; }
    public void setNotas(String notas) { this.notas = notas; }
}
