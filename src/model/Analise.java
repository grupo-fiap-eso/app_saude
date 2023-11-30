package model;

public class Analise {
	private Medico medicoResponsavel;
	private Paciente paciente;
	private Exame exame;

	private String resultado;
	
	public Analise () {
		
	}
	
	public Analise(Medico medicoResponsavel,Paciente paciente, Exame exame, String resultado) {
		this.resultado = resultado;
		this.exame = exame;
		this.medicoResponsavel = medicoResponsavel;
		this.paciente = paciente;
	}


	public String getResultado() {
		return resultado;
	}

	public Medico getMedicoResponsavel() {
		return medicoResponsavel;
	}

	public void setMedicoResponsavel(Medico medicoResponsavel) {
		this.medicoResponsavel = medicoResponsavel;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Exame getExame() {
		return exame;
	}

	public void setExame(Exame exame) {
		this.exame = exame;
	}

	public void setResultado(String resultado) {
		this.resultado = resultado;
	}
	
	public void realizarAnalise() {
		System.out.println("Análise do exame: " +exame.getArquivo() 
							+ " realizado pelo médico/crm " + medicoResponsavel.getCrm()
							+ " possui o seguinte respaldo " + exame.getResultado());
	}
}
