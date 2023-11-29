package models;

public class CareYourSelf {
	public static void main(String[] args) {
		
		// Cadastrar Hospitais
		Hospital hospital1 = new Hospital("Santa Casa", "Alameda dos Anjos, 0", "(055) 3622-0505");
		Hospital hospital2 = new Hospital("Hospital Evangélico", "Avenida Juscelino Kubitschek, 5566", "(061) 3623-1919");

		// Cadastrar Medicos
		Medico medico1 = new Medico("Dr. Eduardo", "Residencial Alpes, apt 123", "eduardo@gmail.com", "(012)99999-1234", 40, "CRM-123", "Clinico Geral");
		Medico medico2 = new Medico("Dra. Maria", "Rua 144, 33", "maria.com", "(021)98888-3456", 44, "CRM-8877", "Cardiologista");

		// Cadastrar Exames
		Exame exame1 = new Exame("Sangue", "../exame.pdf", hospital1, medico1);
		Exame exame2 = new Exame("Eletrocardiograma", "../exame.pdf", hospital2, medico2);
		Exame exame3 = new Exame("Radiografia", "../exame.pdf", hospital2, medico1);
		Exame exame4 = new Exame("Tumografia", "../exame.pdf", hospital1, medico2);
		
		//Cadastrar Pacientes
		Paciente paciente1 = new Paciente("Joao", "Rua das Flores", "joao@gmail.com", "(013)99999-5555", 18);
		Paciente paciente2 = new Paciente("Joana", "Rua 500", "joana@gmail.com", "(013)99999-4444", 28);
		
		paciente1.salvaExame(exame1);
		paciente1.salvaExame(exame2);
		paciente1.salvaExame(exame3);

		
		paciente2.salvaExame(exame3);
		paciente2.salvaExame(exame4);
		paciente2.salvaExame(exame2);
		
		paciente1.exibirInformacoes();
		paciente2.exibirInformacoes();
		
		//Autorizar acesso a informacoes
		Autorizacao auth1 = Autorizacao.autorizar_acesso(paciente1);
		Autorizacao auth2 = Autorizacao.negar_acesso(paciente2);

		System.out.println(auth1.isAutoriza());
		System.out.println(auth2.isAutoriza());
	}

}
