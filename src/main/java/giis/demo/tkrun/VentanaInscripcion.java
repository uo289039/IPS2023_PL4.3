package giis.demo.tkrun;
import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;
import javax.swing.ButtonGroup;

public class VentanaInscripcion extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblICorreo;
	private JLabel lblIDNI;
	private JLabel lblINombre;
	private JLabel lblIntroduzcaSuSexo;
	private JLabel lblIntroduzcaSuFecha;
	private JLabel lblIntroduzcaSuLocalidad;
	private JLabel lblIntroduzcaSuNumero;
	private JLabel lblIntroduzcaSuPais;
	private JButton btnRegistrarse;
	private JButton btnCancelar;
	private JTextField textCorreo;
	private JTextField textDni;
	private JTextField textNombre;
	private JPanel panel;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textFecha;
	private JTextField textLocalidad;
	private JTextField textTelefono;
	private JTextField textPais;
	

	
	public VentanaInscripcion() {
		setTitle("Crear Cuenta");
		setBounds(100, 100, 653, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.add(getLblICorreo());
		contentPanel.add(getLblIDNI());
		contentPanel.add(getLblINombre());
		contentPanel.add(getLblIntroduzcaSuSexo());
		contentPanel.add(getLblIntroduzcaSuFecha());
		contentPanel.add(getLblIntroduzcaSuLocalidad());
		contentPanel.add(getLblIntroduzcaSuNumero());
		contentPanel.add(getLblIntroduzcaSuPais());
		contentPanel.add(getBtnRegistrarse());
		contentPanel.add(getBtnCancelar());
		contentPanel.add(getTextCorreo());
		contentPanel.add(getTextDni());
		contentPanel.add(getTextNombre());
		contentPanel.add(getPanel());
		contentPanel.add(getTextFecha());
		contentPanel.add(getTextLocalidad());
		contentPanel.add(getTextTelefono());
		contentPanel.add(getTextPais());
	}
	private JLabel getLblICorreo() {
		if (lblICorreo == null) {
			lblICorreo = new JLabel("Introduzca el correo para las competiciones:");
			lblICorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblICorreo.setBackground(Color.WHITE);
			lblICorreo.setBounds(10, 42, 250, 14);
		}
		return lblICorreo;
	}
	private JLabel getLblIDNI() {
		if (lblIDNI == null) {
			lblIDNI = new JLabel("Introduzca su dni:");
			lblIDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIDNI.setBackground(Color.WHITE);
			lblIDNI.setBounds(10, 78, 250, 14);
		}
		return lblIDNI;
	}
	private JLabel getLblINombre() {
		if (lblINombre == null) {
			lblINombre = new JLabel("Introduzca su nombre completo:");
			lblINombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblINombre.setBackground(Color.WHITE);
			lblINombre.setBounds(10, 109, 250, 14);
		}
		return lblINombre;
	}
	private JLabel getLblIntroduzcaSuSexo() {
		if (lblIntroduzcaSuSexo == null) {
			lblIntroduzcaSuSexo = new JLabel("Introduzca/Seleccione su sexo:");
			lblIntroduzcaSuSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuSexo.setBackground(Color.WHITE);
			lblIntroduzcaSuSexo.setBounds(10, 145, 250, 14);
		}
		return lblIntroduzcaSuSexo;
	}
	private JLabel getLblIntroduzcaSuFecha() {
		if (lblIntroduzcaSuFecha == null) {
			lblIntroduzcaSuFecha = new JLabel("Introduzca su fecha de nacimiento:");
			lblIntroduzcaSuFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuFecha.setBackground(Color.WHITE);
			lblIntroduzcaSuFecha.setBounds(10, 177, 250, 14);
		}
		return lblIntroduzcaSuFecha;
	}
	private JLabel getLblIntroduzcaSuLocalidad() {
		if (lblIntroduzcaSuLocalidad == null) {
			lblIntroduzcaSuLocalidad = new JLabel("Introduzca su localidad:");
			lblIntroduzcaSuLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuLocalidad.setBackground(Color.WHITE);
			lblIntroduzcaSuLocalidad.setBounds(10, 215, 250, 14);
		}
		return lblIntroduzcaSuLocalidad;
	}
	private JLabel getLblIntroduzcaSuNumero() {
		if (lblIntroduzcaSuNumero == null) {
			lblIntroduzcaSuNumero = new JLabel("Introduzca su número de telefono:");
			lblIntroduzcaSuNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuNumero.setBackground(Color.WHITE);
			lblIntroduzcaSuNumero.setBounds(10, 248, 250, 14);
		}
		return lblIntroduzcaSuNumero;
	}
	private JLabel getLblIntroduzcaSuPais() {
		if (lblIntroduzcaSuPais == null) {
			lblIntroduzcaSuPais = new JLabel("Introduzca su pais:");
			lblIntroduzcaSuPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuPais.setBackground(Color.WHITE);
			lblIntroduzcaSuPais.setBounds(10, 278, 250, 14);
		}
		return lblIntroduzcaSuPais;
	}
	private JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
			btnRegistrarse.setBounds(435, 363, 89, 23);
		}
		return btnRegistrarse;
	}
	private JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setBounds(538, 363, 89, 23);
		}
		return btnCancelar;
	}
	private JTextField getTextCorreo() {
		if (textCorreo == null) {
			textCorreo = new JTextField();
			textCorreo.setBounds(293, 40, 177, 20);
			textCorreo.setColumns(10);
		}
		return textCorreo;
	}
	private JTextField getTextDni() {
		if (textDni == null) {
			textDni = new JTextField();
			textDni.setColumns(10);
			textDni.setBounds(293, 76, 177, 20);
		}
		return textDni;
	}
	private JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setColumns(10);
			textNombre.setBounds(293, 107, 177, 20);
		}
		return textNombre;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(293, 138, 183, 33);
			panel.add(getRdbtnMasculino());
			panel.add(getRdbtnFemenino());
		}
		return panel;
	}
	private JRadioButton getRdbtnMasculino() {
		if (rdbtnMasculino == null) {
			rdbtnMasculino = new JRadioButton("Masculino");
			buttonGroup.add(rdbtnMasculino);
			rdbtnMasculino.setBackground(Color.WHITE);
		}
		return rdbtnMasculino;
	}
	private JRadioButton getRdbtnFemenino() {
		if (rdbtnFemenino == null) {
			rdbtnFemenino = new JRadioButton("Femenino");
			buttonGroup.add(rdbtnFemenino);
			rdbtnFemenino.setSelected(true);
			rdbtnFemenino.setBackground(Color.WHITE);
		}
		return rdbtnFemenino;
	}
	private JTextField getTextFecha() {
		if (textFecha == null) {
			textFecha = new JTextField();
			textFecha.setColumns(10);
			textFecha.setBounds(293, 177, 177, 20);
		}
		return textFecha;
	}
	private JTextField getTextLocalidad() {
		if (textLocalidad == null) {
			textLocalidad = new JTextField();
			textLocalidad.setColumns(10);
			textLocalidad.setBounds(293, 213, 177, 20);
		}
		return textLocalidad;
	}
	private JTextField getTextTelefono() {
		if (textTelefono == null) {
			textTelefono = new JTextField();
			textTelefono.setColumns(10);
			textTelefono.setBounds(293, 246, 177, 20);
		}
		return textTelefono;
	}
	private JTextField getTextPais() {
		if (textPais == null) {
			textPais = new JTextField();
			textPais.setColumns(10);
			textPais.setBounds(293, 276, 177, 20);
		}
		return textPais;
	}
}
