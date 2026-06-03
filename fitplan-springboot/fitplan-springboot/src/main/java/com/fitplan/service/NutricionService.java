package com.fitplan.service;

import com.fitplan.model.ObjetivoFisico;
import com.fitplan.model.PerfilFisico;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;

@Service
public class NutricionService {

    private static final double FACTOR_ACTIVIDAD = 1.55;

    public Map<String, Object> calcularRecomendacion(PerfilFisico perfil) {
        double tmb = calcularTMB(perfil);
        double caloriasObjetivo = (tmb * FACTOR_ACTIVIDAD) +
                perfil.getObjetivo().getAjusteCaloricoKcal();
        double proteinas = calcularProteinas(perfil);
        double grasas = caloriasObjetivo * factorGrasa(perfil.getObjetivo()) / 9.0;
        double carbohidratos = (caloriasObjetivo - (proteinas * 4) - (grasas * 9)) / 4.0;

        Map<String, Object> result = new HashMap<>();
        result.put("objetivo", perfil.getObjetivo().getDescripcion());
        result.put("caloriasEstimadas", (int) caloriasObjetivo);
        result.put("proteinasGramos", Math.round(proteinas * 10.0) / 10.0);
        result.put("carbohidratosGramos", Math.round(carbohidratos * 10.0) / 10.0);
        result.put("grasasGramos", Math.round(grasas * 10.0) / 10.0);
        return result;
    }

    private double calcularTMB(PerfilFisico perfil) {
        if ("Masculino".equals(perfil.getGenero())) {
            return 88.36 + (13.4 * perfil.getPeso()) +
                   (4.8 * perfil.getAltura()) - (5.7 * perfil.getEdad());
        }
        return 447.6 + (9.2 * perfil.getPeso()) +
               (3.1 * perfil.getAltura()) - (4.3 * perfil.getEdad());
    }

    private double calcularProteinas(PerfilFisico perfil) {
        switch (perfil.getObjetivo()) {
            case MASA_MUSCULAR: return perfil.getPeso() * 2.2;
            case PERDER_GRASA:  return perfil.getPeso() * 2.0;
            default:            return perfil.getPeso() * 1.6;
        }
    }

    private double factorGrasa(ObjetivoFisico objetivo) {
        switch (objetivo) {
            case MASA_MUSCULAR: return 0.25;
            case PERDER_GRASA:  return 0.30;
            default:            return 0.28;
        }
    }
}
