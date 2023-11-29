package models;

public class Hospital {
    private String nome;
    private String endereco;
    private String telefone;

    public Hospital(String nome, String endereco, String telefone) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setTelefone(telefone);
    }

    public void exibirInformacoes() {
    	System.out.println("Tipo: " + getTipo());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("Telefone: " + getTelefone());
    }
    
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getTipo() {
		return "Hospital";
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
