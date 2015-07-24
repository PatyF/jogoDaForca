import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class Acertar extends JFrame {

	private JPanel contentPane;
	private static Palavra palavra;
	private static JTextField txtPalavraAcertar;
	private JTextField txtLetra;
	private int retorno; 
	private Principal principal;


	public Acertar(Palavra p) {
		palavra = p;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPalavraAcertar = new JTextField();
		txtPalavraAcertar.setHorizontalAlignment(SwingConstants.CENTER);
		txtPalavraAcertar.setEnabled(false);
		txtPalavraAcertar.setFont(new Font("Tahoma", Font.PLAIN, 32));
		txtPalavraAcertar.setBounds(43, 23, 361, 56);
		contentPane.add(txtPalavraAcertar);
		txtPalavraAcertar.setColumns(10);
		
		JLabel lblDigiteALetra = new JLabel("Digite a Letra:");
		lblDigiteALetra.setBounds(32, 265, 113, 14);
		contentPane.add(lblDigiteALetra);
		
		txtLetra = new JTextField();
		txtLetra.setFont(new Font("Tahoma", Font.PLAIN, 17));
		txtLetra.setBounds(155, 254, 30, 32);
		contentPane.add(txtLetra);
		txtLetra.setColumns(10);
		
		final JLabel lblImagem = new JLabel("");
		lblImagem.setHorizontalAlignment(SwingConstants.CENTER);
		lblImagem.setIcon(new ImageIcon(Acertar.class.getResource("/img/img1.png")));
		lblImagem.setBounds(43, 90, 362, 148);
		contentPane.add(lblImagem);
		redesenhaTela();
		JButton btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(txtLetra.getText().trim().equals("")){
					JOptionPane.showMessageDialog(null,"Digite uma letra!");
				}
				else{
					retorno = palavra.verificaExisteLetra(txtLetra.getText().charAt(0));
					redesenhaTela();
					if(retorno == 1){
						JOptionPane.showMessageDialog(null,"Parabéns, você acertou!");
						principal = new Principal();
						principal.setVisible(true);
						dispose();
					}
					else if(retorno == -2){
						JOptionPane.showMessageDialog(null,"Letra já informada!");
						lblImagem.setIcon(new ImageIcon(Acertar.class.getResource("/img/img"+palavra.getChances()+".png")));
					}
					else if(retorno == -1){
						JOptionPane.showMessageDialog(null,"Você errou a letra!");
						lblImagem.setIcon(new ImageIcon(Acertar.class.getResource("/img/img"+palavra.getChances()+".png")));
					}
					if(palavra.getChances()==7){
						JOptionPane.showMessageDialog(null,"Você Perdeu!");
						principal = new Principal();
						principal.setVisible(true);
						dispose();
					}
					txtLetra.setText("");
					
				}
			}
		});
		btnVerificar.setBounds(195, 261, 89, 23);
		contentPane.add(btnVerificar);
	}
	public static void redesenhaTela(){
		int i;
		txtPalavraAcertar.setText("");
		for(i=0;i<palavra.getLetrasCorretas().length();i++){
			txtPalavraAcertar.setText(txtPalavraAcertar.getText() + palavra.getLetrasCorretas().charAt(i)+" ");
		}
	}
}
