package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

import model.Autorizacao;
import model.Exame;
import model.Hospital;
import model.Medico;
import model.Paciente;
public class CareYourSelf extends JFrame{
	
	
	private JTextField txtnome = new JTextField();
	private JTextField txtendereco = new JTextField();
	private JTextField txtemail = new JTextField();
	private JTextField txttelefone = new JTextField();
	private JTextField txtidade = new JTextField();
	
	private JLabel lblnome = new JLabel();
	private JLabel lblendereco = new JLabel();
	private JLabel lblemail = new JLabel();
	private JLabel lbltelefone = new JLabel();
	private JLabel lblidade = new JLabel();
	
	private JCheckBox chAutorizacao;
	
	private JButton btnBusca;
	
	private JPanel pnlCadastro;
	private JPanel pnlBotao;
	
	public CareYourSelf() {
		//titulo 
		super("Cadastro");
		
		//layout 
		this.setLayout(new FlowLayout());
		this.setSize(500, 300);
		
		pnlBotao = new JPanel(new FlowLayout());
		pnlCadastro = new JPanel(new GridBagLayout());
		
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
		pnlCadastro.add(lblnome, posicoes);
		
	
		//alinhamento à direita 
		posicoes.anchor = posicoes.LINE_END;
		
		//campo de texto - nome
		posicoes.gridx = 1;
		posicoes.gridy = 1;
		txtnome= new JTextField(20);
		pnlCadastro.add(txtnome, posicoes);
		
		
		//botao salvar cadastro

		btnBusca = new JButton("Buscar ficha");
		pnlBotao.add( btnBusca);
			
		add(pnlCadastro);
		add(pnlBotao);
		
		btnBusca.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
						
					
				}
		});
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

		
		paciente2.salvaExame(exame3);
		paciente2.salvaExame(exame4);
		paciente2.salvaExame(exame2);
		
	
		paciente1.exibirInformacoes();
		paciente2.exibirInformacoes();
		
		//Autorizar acesso a informacoes
		Autorizacao auth1 = Autorizacao.autorizar_acesso(paciente1);
		Autorizacao auth2 = Autorizacao.negar_acesso(paciente2);

		System.out.println(auth1.isAutoriza());
		System.out.println(auth2.isAutoriza());
	}

}
