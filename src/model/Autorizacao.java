package model;

public class Autorizacao {
	private boolean autoriza;

    public Autorizacao(boolean autoriza) {
        this.setAutoriza(autoriza);
    }
	
	public Autorizacao autorizar_acesso(){
		return new Autorizacao(true);
	}
	
	public Autorizacao negar_acesso() {
		return new Autorizacao(false);
	}


	public String isAutoriza() {
		if(this.autoriza){
			return "autorizado o acesso a informaçoes\n";
		} else {
			return "negado o acesso a informaçoes\n";
		}
	}

	public void setAutoriza(boolean autoriza) {
		this.autoriza = autoriza;
	}

	
}
