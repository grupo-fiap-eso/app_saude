package model;

abstract class Pessoa {
    private String nome;
    private String endereco;
    private String email;
    private String telefone;
    private int idade;

    public Pessoa(String nome, String endereco, String email, String telefone, int idade) {
        this.setNome(nome);
        this.setEndereco(endereco);
        this.setEmail(email);
        this.setTelefone(telefone);
        this.setIdade(idade);
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


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefone() {
		return telefone;
	}


	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}


	public int getIdade() {
		return idade;
	}


	public void setIdade(int idade) {
		this.idade = idade;
	}

    

}