import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Principal extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Palavra palavra;
	private Acertar acertar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setTitle("Jogo da Forca");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 212);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Digite a palavra que ser\u00E1 descoberta:");
		lblNewLabel.setBounds(52, 38, 424, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(52, 63, 329, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnIniciar = new JButton("Iniciar");
		btnIniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null,"Digite uma palavra!");
				}else{
					palavra = new Palavra(textField.getText());
					acertar = new Acertar(palavra);
					acertar.setVisible(true);
					dispose();
				}
			}
		});
		btnIniciar.setBounds(166, 94, 89, 23);
		contentPane.add(btnIniciar);
	}
}
