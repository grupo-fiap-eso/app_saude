package model;

public class Autorizacao {
	private Paciente paciente;
	private boolean autoriza;
	
    public Autorizacao(Paciente paciente, boolean autoriza) {
        this.setPaciente(paciente);
        this.setAutoriza(autoriza);
    }
	
	public static Autorizacao autorizar_acesso(Paciente paciente) {
		return new Autorizacao(paciente, true);
	}
	
	public static Autorizacao negar_acesso(Paciente paciente) {
		return new Autorizacao(paciente, false);
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public String isAutoriza() {
		String msg = "O paciente: " + paciente.getNome();

		if(this.autoriza){
			return msg + " autorizou o acesso a informaçoes";
		} else {
			return msg + " negou o acesso a informaçoes";
		}
	}

	public void setAutoriza(boolean autoriza) {
		this.autoriza = autoriza;
	}

	
}
