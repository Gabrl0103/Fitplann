package com.fitplan.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "perfiles_fisicos")
public class PerfilFisico {

    @Id
    private String id;
    private String usuarioId;
    private double peso;
    private double altura;
    private int edad;
    private String genero;
    private ObjetivoFisico objetivo;

    public PerfilFisico() {}

    public double calcularIMC() {
        double alturaMetros = altura / 100.0;
        return Math.round((peso / (alturaMetros * alturaMetros)) * 100.0) / 100.0;
    }

    public String clasificarIMC() {
        double imc = calcularIMC();
        if (imc < 18.5) return "Bajo peso";
        if (imc < 25.0) return "Normal";
        if (imc < 30.0) return "Sobrepeso";
        return "Obesidad";
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getUsuarioId() { return usuarioId; }
    public void setUsuarioId(String usuarioId) { this.usuarioId = usuarioId; }
    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }
    public double getAltura() { return altura; }
    public void setAltura(double altura) { this.altura = altura; }
    public int getEdad() { return edad; }
    public void setEdad(int edad) { this.edad = edad; }
    public String getGenero() { return genero; }
    public void setGenero(String genero) { this.genero = genero; }
    public ObjetivoFisico getObjetivo() { return objetivo; }
    public void setObjetivo(ObjetivoFisico objetivo) { this.objetivo = objetivo; }
}
