package com.medicalcenter;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.medicalcenter.dto.DoctorDTO;
import com.medicalcenter.dto.PatientDTO;
import com.medicalcenter.dto.UserDTO;
import com.medicalcenter.enums.ActiveOrInactiveEnum;
import com.medicalcenter.service.DoctorService;
import com.medicalcenter.service.PatientService;
import com.medicalcenter.service.UserService;

@SpringBootApplication
@EnableJpaRepositories
public class MedicalCenterApplication implements ApplicationRunner {

	@Autowired
	private DoctorService doctorService;

	@Autowired
	private UserService userService;

	@Autowired
	private PatientService patientService;

	public static void main(String[] args) {
		SpringApplication.run(MedicalCenterApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) throws Exception {

		System.out.println(" ####### Database initial load started ###### ");

		List<DoctorDTO> doctors = Arrays.asList(new DoctorDTO(null, "Arnaldo Nunes", "Cardiologista", null),
				new DoctorDTO(null, "João Pereira", "Dentista", null),
				new DoctorDTO(null, "Maria Souza", "Endócrinologista", null));
		doctors.forEach(doctor -> doctorService.save(doctor));

		List<UserDTO> users = Arrays.asList(new UserDTO(null, "Bernardo Mallet", "14725836978", "M", "21995825547",
				"medicalcenter", "bernardomallet@gmail.com", null));
		users.forEach(u -> this.userService.save(u));

		for (int i = 1; i <= 10; i++) {

			this.patientService.save(new PatientDTO(i + "4785296385", "Teste " + i, "21 98874521" + i, "Rua Teste " + i,
					"" + i, "Bairro " + i, "Comp " + i, "Rio de Janeiro", "RJ", "", ActiveOrInactiveEnum.ACTIVE,
					new DoctorDTO(1, "Arnaldo Nunes", "Cardiologista", null), null));

		}

		System.out.println(" ####### Database initial load ended ###### ");

	}

}
