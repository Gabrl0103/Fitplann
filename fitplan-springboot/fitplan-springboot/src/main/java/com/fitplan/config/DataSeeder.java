package com.fitplan.config;

import com.fitplan.model.Ejercicio;
import com.fitplan.model.ObjetivoFisico;
import com.fitplan.model.Usuario;
import com.fitplan.repository.EjercicioRepository;
import com.fitplan.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataSeeder implements CommandLineRunner {

    private final EjercicioRepository ejercicioRepo;
    private final UsuarioRepository usuarioRepo;

    public DataSeeder(EjercicioRepository ejercicioRepo, UsuarioRepository usuarioRepo) {
        this.ejercicioRepo = ejercicioRepo;
        this.usuarioRepo = usuarioRepo;
    }

    @Override
    public void run(String... args) {
        if (ejercicioRepo.count() == 0) {
            insertarEjercicios();
            System.out.println("18 ejercicios insertados.");
        }
        if (!usuarioRepo.existsByCorreo("admin@fitplan.com")) {
            usuarioRepo.save(new Usuario("Administrador", "admin@fitplan.com",
                    PasswordUtil.hashPassword("admin123"), "admin"));
            System.out.println("Admin creado: admin@fitplan.com / admin123");
        }
    }

    private void insertarEjercicios() {
        Object[][] data = {
            {"Press de banca", 4, 8, 90, "Pecho", ObjetivoFisico.MASA_MUSCULAR},
            {"Sentadilla con barra", 4, 8, 120, "Piernas", ObjetivoFisico.MASA_MUSCULAR},
            {"Remo con barra", 3, 10, 90, "Espalda", ObjetivoFisico.MASA_MUSCULAR},
            {"Press militar", 3, 10, 60, "Hombros", ObjetivoFisico.MASA_MUSCULAR},
            {"Curl de biceps", 3, 12, 45, "Biceps", ObjetivoFisico.MASA_MUSCULAR},
            {"Extension de triceps", 3, 12, 45, "Triceps", ObjetivoFisico.MASA_MUSCULAR},
            {"Carrera continua", 1, 1, 0, "Cardio", ObjetivoFisico.PERDER_GRASA},
            {"Burpees", 4, 15, 30, "Cuerpo completo", ObjetivoFisico.PERDER_GRASA},
            {"Jumping jacks", 3, 30, 20, "Cardio", ObjetivoFisico.PERDER_GRASA},
            {"Sentadilla sumo", 3, 15, 30, "Piernas", ObjetivoFisico.PERDER_GRASA},
            {"Plancha", 3, 1, 30, "Core", ObjetivoFisico.PERDER_GRASA},
            {"Mountain climbers", 3, 20, 30, "Core", ObjetivoFisico.PERDER_GRASA},
            {"Trote 45 minutos", 1, 1, 0, "Cardio", ObjetivoFisico.RESISTENCIA},
            {"Ciclismo estatico", 1, 1, 0, "Cardio", ObjetivoFisico.RESISTENCIA},
            {"Saltar cuerda", 1, 1, 0, "Cardio", ObjetivoFisico.RESISTENCIA},
            {"Zancadas", 3, 12, 45, "Piernas", ObjetivoFisico.RESISTENCIA},
            {"Abdominales", 4, 20, 30, "Core", ObjetivoFisico.RESISTENCIA},
            {"Fondos en paralelas", 3, 10, 60, "Triceps", ObjetivoFisico.RESISTENCIA}
        };
        for (Object[] e : data) {
            ejercicioRepo.save(new Ejercicio(
                (String)e[0], (int)e[1], (int)e[2],
                (int)e[3], (String)e[4], (ObjetivoFisico)e[5]));
        }
    }
}
