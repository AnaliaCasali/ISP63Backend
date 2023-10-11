package com.institucional.WebIsp63;

import com.institucional.WebIsp63.Entity.Administrador;
import com.institucional.WebIsp63.Entity.Alumno;
import com.institucional.WebIsp63.Repository.AdministradorRepository;
import com.institucional.WebIsp63.Repository.AlumnoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

public class WebIsp63Application {
	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	AdministradorRepository administradorRepository;

	public static void main(String[] args) {
		SpringApplication.run(com.institucional.WebIsp63.WebIsp63Application.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner (ApplicationContext ctx){
		return args -> {
			System.out.println("Aplicacion a iniciado");
			Alumno a = new Alumno();
			a.setTelefono(2222);
			a.setDni(444);
			a.setPassword(7777);
			a.setId(1l);
			a.setEmail("ornela@bariz");
			a.setNombre("ornela");
			a.setApellido("bariz");
			a.setIngreso("lunes");
			a.setSede("las toscas");
			a.setCarrera("tecanicatura");
			a.setEstado("activo");
			alumnoRepository.save(a);
			Administrador admi =new Administrador();
			admi.setCargo("alumnos");
			admi.setApellido("gomez");
			admi.setNombre("luis");
			admi.setTelefono(223344);
			admi.setEmail("onoerne");
			admi.setDni(1111);
			admi.setPassword(2345);
			admi.setId(2l);
			administradorRepository.save(admi);
			System.out.println(alumnoRepository.findAll());

		};
	}
}
