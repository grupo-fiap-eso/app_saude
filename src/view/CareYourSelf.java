package view;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import model.Exame;
import model.Hospital;
import model.Medico;
import model.Paciente;

public class CareYourSelf extends JFrame{
	private static Paciente[] pacientes = new Paciente[2];
	
	private JTextField txtnome = new JTextField();
	private JLabel lblnome = new JLabel();
	private JButton btnBusca;
	
	private JPanel pnlBusca;
	private JPanel pnlBotao;
	
	public CareYourSelf() {
		//titulo 
		super("Busca");
		
		//layout 
		this.setLayout(new FlowLayout());
		this.setSize(500, 300);
		
		pnlBotao = new JPanel(new FlowLayout());
		pnlBusca = new JPanel(new GridBagLayout());
		
		//GridBagLayout
		GridBagConstraints posicoes = new GridBagConstraints();
		//espacamento de 3px acima e abaixo
		posicoes.insets = new Insets(3, 0, 3, 0);
		
		//alinhamento À esquerda
		posicoes.anchor = posicoes.LINE_START;
		
		posicoes.gridx = 0;
		posicoes.gridy = 1;
		//posicionamento do label
		lblnome = new JLabel("Nome Completo do Paciente: ");
		pnlBusca.add(lblnome, posicoes);
		
	
		//alinhamento à direita 
		posicoes.anchor = posicoes.LINE_END;
		
		//campo de texto - nome
		posicoes.gridx = 1;
		posicoes.gridy = 1;
		txtnome= new JTextField(20);
		pnlBusca.add(txtnome, posicoes);
		
		
		//botao salvar cadastro

		btnBusca = new JButton("Buscar ficha");
		pnlBotao.add( btnBusca);
			
		add(pnlBusca);
		add(pnlBotao);
		
		btnBusca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					String nomeBusca = txtnome.getText();
					Paciente pacienteEncontrado = buscarPaciente(nomeBusca);
					
	                if (pacienteEncontrado != null) {
	                    JOptionPane.showMessageDialog(null, pacienteEncontrado.exibirInformacoes(), "Paciente", JOptionPane.INFORMATION_MESSAGE);
	                } else {
	                	JOptionPane.showMessageDialog(null, "Paciente " + nomeBusca + " Nao encontrado", "Paciente", JOptionPane.INFORMATION_MESSAGE);
	                }
				}
		});
	}
	
    // Método para buscar o paciente na lista
    private Paciente buscarPaciente(String nome) {
        for (int i = 0; i < pacientes.length; i++) {
            if (pacientes[i].getNome().equalsIgnoreCase(nome)) {
                return pacientes[i];
            }
        }
        return null;
    }
	
	public static void main(String[] args) {
		
		CareYourSelf janela = new CareYourSelf();
		janela.setDefaultCloseOperation(EXIT_ON_CLOSE);
		janela.setLocationRelativeTo(null);
		janela.setVisible(true);

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
		paciente1.autorizaAcesso();

		
		paciente2.salvaExame(exame3);
		paciente2.salvaExame(exame4);
		paciente2.salvaExame(exame2);
		paciente2.negarAcesso();
		
		pacientes[0] = paciente1;
		pacientes[1] = paciente2;
	
		System.out.print(paciente1.exibirInformacoes());

		System.out.print(paciente2.exibirInformacoes());	
	}
}
