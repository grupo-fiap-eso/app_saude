package models;

public class Paciente extends Pessoa {
    private Exame[] exames = new Exame[10];

    public Paciente(String nome, String endereco, String email, String telefone, int idade) {
        super(nome, endereco, email, telefone, idade);
    }

    public void exibirInformacoes() {
    	System.out.println("Tipo: " + getTipo());
        System.out.println("Nome: " + getNome());
        System.out.println("Endereco: " + getEndereco());
        System.out.println("email: " + getEmail());
        System.out.println("Telefone: " + getTelefone());
        System.out.println("Idade: " + getIdade());
        System.out.println("=== Exames Feitos (" + this.exames.length + "):");
        this.getExames();
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
            System.out.println("Erro: sem espaco disponivel");
        }
    }

	public void getExames() {
		for (int i = 0; i < (this.exames.length); i++) {
			if (this.exames[i] != null) {
			  System.out.println((i+1) + " - " + this.exames[i].getNome());
			}
		}
	}
	
	private String getTipo() {
		return "Cliente";
	}
}
