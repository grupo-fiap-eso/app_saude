package app_saude;

public class Medico extends Pessoa {
	private String especialidade;
    private String crm;

    public Medico(String nome, String endereco, String email, String telefone, int idade, String crm, String especialidade) {
        super(nome, endereco, email, telefone, idade);
    }

    public void exibirInformacoes() {
    	System.out.println("Tipo: " + getTipo());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Idade: " + getIdade());
        System.out.println("CRM: " + getCrm());
        System.out.println("Especialidade: " + getEspecialidade());
    }

	public String getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}

	public String getCrm() {
		return crm;
	}

	public void setCrm(String crm) {
		this.crm = crm;
	}

	private String getTipo() {
		return "Medico";
	}
}
