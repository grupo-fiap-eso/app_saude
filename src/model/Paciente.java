package model;

public class Paciente extends Pessoa {
	private String cpf;
	
    private Exame[] exames = new Exame[10];
    private Autorizacao auth = new Autorizacao(false);
    
    public Paciente(String nome, String endereco, String email, String telefone, int idade, String cpf) {
        super(nome, endereco, email, telefone, idade);
    }

    public String exibirInformacoes() {
    	String msg = "";
    	msg = "Tipo: " + getTipo() + "\n";
		msg += "Nome: " + getNome() + "\n";
		msg += "Endereco: " + getEndereco() + "\n";
		msg += "Email: " + getEmail() + "\n";
		msg += "Telefone: " + getTelefone() + "\n";
		msg += "Idade: " + getIdade() + "\n";
		msg += "CPF: " + getCpf() + "\n";
		msg += " === Exames Feitos (" + this.contExames() + "):" + "\n";
		msg += this.getExames();
		msg += this.getAutorizacao().isAutoriza();
    	return msg;
    }

  

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public void salvaExame(Exame exame) {
        // encontra primeira posição disponivel no vetor
        int posicaoNula = -1;
        for (int i = 0; i < this.exames.length; i++) {
            if (this.exames[i] == null) {
                posicaoNula = i;
                break;
            }
        }
        
        if (posicaoNula != -1) {
            exames[posicaoNula] = exame;
            System.out.println("Exame: "+ exame.getNome() + " salvo!");
        } else {
            System.out.println("Erro: sem espaço disponível");
        }
    }

	public String getExames() {
		String msg = "";
		for (int i = 0; i < (this.exames.length); i++) {
			if (this.exames[i] != null) {
			  msg += (i+1) + " - " + this.exames[i].getNome()  + "\n";
			}
		}
		return msg;
	}
	
	// Conta quantos exames o paciente tem
	public int contExames() {
	    int contador = 0;

	    for(int i = 0; i < this.exames.length; i++){
	           if(this.exames[i] != null){
	        	   contador += 1;
	           }
	    }

	    return contador;
	}
	
	public void autorizaAcesso() {
		this.auth.autorizar_acesso();
	}
	
	public void negarAcesso() {
		this.auth.negar_acesso();
	}
	
	public Autorizacao getAutorizacao() {
		return this.auth;
	}
	
	private String getTipo() {
		return "Paciente";
	}

}
