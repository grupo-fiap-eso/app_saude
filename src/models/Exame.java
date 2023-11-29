package models;

public class Exame {
    private String especialidade;
    private String arquivo;
    private Hospital hospital;
    private Medico medico;
    
    public Exame(String especialidade, String arquivo, Hospital hospital, Medico medico) {
        this.setEspecialidade(especialidade);
    	this.setArquivo(arquivo);
    	this.setHospital(hospital);
    	this.setMedico(medico);
    }
    
	public String getEspecialidade() {
		return especialidade;
	}
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	public String getArquivo() {
		return arquivo;
	}
	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	public Hospital getHospital() {
		return hospital;
	}
	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	
	public String getNome() {
		return this.getEspecialidade() + " (" + this.getHospital().getNome() + ") - " + this.getMedico().getNome() + " - " + this.getArquivo();
	}
	
	public String getResultado() {
		return "Exame ("+ this.getNome() +"): Resultado";
	}


}
