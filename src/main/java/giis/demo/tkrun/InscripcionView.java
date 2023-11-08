package giis.demo.tkrun;
import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JRadioButton;

import javax.swing.ButtonGroup;

public class InscripcionView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblICorreo;
	private JLabel lblIDNI;
	private JLabel lblINombre;
	private JLabel lblIntroduzcaSuLocalidad;
	private JLabel lblIntroduzcaSuNumero;
	private JLabel lblIntroduzcaSuPais;
	private JButton btnRegistrarse;
	private JButton btnCancelar;
	private JTextField textCorreo;
	private JTextField textDni;
	private JTextField textNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textLocalidad;
	private JTextField textPais;
	private JTextField textTelefono;
	private JLabel lblSexo;
	private JPanel panel;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JLabel lblIntroduzcaSuFecha;
	private JTextField textFecha;
	

	
	public InscripcionView() {
		setTitle("Crear Cuenta");
		setBounds(100, 100, 653, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][][][grow][][][][][][][][][]"));
		contentPanel.add(getLblICorreo(), "cell 0 4,growx,aligny center");
		contentPanel.add(getTextCorreo(), "cell 1 4,growx");
		contentPanel.add(getLblIDNI(), "cell 0 5,growx,aligny center");
		contentPanel.add(getTextDni(), "cell 1 5,growx,aligny top");
		contentPanel.add(getLblINombre(), "cell 0 6,growx,aligny center");
		contentPanel.add(getTextNombre(), "cell 1 6,growx,aligny top");
		contentPanel.add(getLblSexo(), "cell 0 7");
		contentPanel.add(getPanel(), "cell 1 7,grow");
		contentPanel.add(getLblIntroduzcaSuLocalidad(), "cell 0 8,growx,aligny center");
		contentPanel.add(getTextLocalidad(), "cell 1 8,growx,aligny top");
		contentPanel.add(getLblIntroduzcaSuNumero(), "cell 0 9,growx,aligny center");
		contentPanel.add(getTextTelefono(), "cell 1 9,growx,aligny top");
		contentPanel.add(getLblIntroduzcaSuPais(), "cell 0 10,growx,aligny center");
		contentPanel.add(getTextPais(), "cell 1 10,growx,aligny top");
		contentPanel.add(getLblIntroduzcaSuFecha(), "cell 0 11,alignx left");
		contentPanel.add(getTextFecha(), "cell 1 11,growx");
		contentPanel.add(getBtnRegistrarse(), "cell 1 16,alignx right,aligny top");
		contentPanel.add(getBtnCancelar(), "cell 2 16,growx,aligny top");
	}
	private JLabel getLblICorreo() {
		if (lblICorreo == null) {
			lblICorreo = new JLabel("Introduzca el correo para las competiciones:");
			lblICorreo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblICorreo.setBackground(Color.WHITE);
		}
		return lblICorreo;
	}
	private JLabel getLblIDNI() {
		if (lblIDNI == null) {
			lblIDNI = new JLabel("Introduzca su dni:");
			lblIDNI.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIDNI.setBackground(Color.WHITE);
		}
		return lblIDNI;
	}
	private JLabel getLblINombre() {
		if (lblINombre == null) {
			lblINombre = new JLabel("Introduzca su nombre completo:");
			lblINombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblINombre.setBackground(Color.WHITE);
		}
		return lblINombre;
	}
	private JLabel getLblIntroduzcaSuLocalidad() {
		if (lblIntroduzcaSuLocalidad == null) {
			lblIntroduzcaSuLocalidad = new JLabel("Introduzca su localidad:");
			lblIntroduzcaSuLocalidad.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuLocalidad.setBackground(Color.WHITE);
		}
		return lblIntroduzcaSuLocalidad;
	}
	private JLabel getLblIntroduzcaSuNumero() {
		if (lblIntroduzcaSuNumero == null) {
			lblIntroduzcaSuNumero = new JLabel("Introduzca su número de telefono:");
			lblIntroduzcaSuNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuNumero.setBackground(Color.WHITE);
		}
		return lblIntroduzcaSuNumero;
	}
	private JLabel getLblIntroduzcaSuPais() {
		if (lblIntroduzcaSuPais == null) {
			lblIntroduzcaSuPais = new JLabel("Introduzca su pais:");
			lblIntroduzcaSuPais.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuPais.setBackground(Color.WHITE);
		}
		return lblIntroduzcaSuPais;
	}
	public JButton getBtnRegistrarse() {
		if (btnRegistrarse == null) {
			btnRegistrarse = new JButton("Registrarse");
		}
		return btnRegistrarse;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	public JTextField getTextCorreo() {
		if (textCorreo == null) {
			textCorreo = new JTextField();
			textCorreo.setColumns(10);
		}
		return textCorreo;
	}
	public JTextField getTextDni() {
		if (textDni == null) {
			textDni = new JTextField();
			textDni.setColumns(10);
		}
		return textDni;
	}
	public JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	public JTextField getTextLocalidad() {
		if (textLocalidad == null) {
			textLocalidad = new JTextField();
			textLocalidad.setColumns(10);
		}
		return textLocalidad;
	}
	public JTextField getTextPais() {
		if (textPais == null) {
			textPais = new JTextField();
			textPais.setColumns(10);
		}
		return textPais;
	}
	public JTextField getTextTelefono() {
		if (textTelefono == null) {
			textTelefono = new JTextField();
			textTelefono.setColumns(10);
		}
		return textTelefono;
	}
	public JLabel getLblSexo() {
		if (lblSexo == null) {
			lblSexo = new JLabel("Introduzca/Seleccione su sexo");
			lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblSexo;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);

			panel.add(getRdbtnMasculino());
			panel.add(getRdbtnFemenino());
		}
		return panel;
	}
	public JRadioButton getRdbtnMasculino() {
		if (rdbtnMasculino == null) {
			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMasculino);
		}
		return rdbtnMasculino;
	}
	public JRadioButton getRdbtnFemenino() {
		if (rdbtnFemenino == null) {
			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.setSelected(true);
			rdbtnFemenino.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnFemenino);
		}
		return rdbtnFemenino;
	}
	public void reset() {
		this.getTextCorreo().setText("");
		this.getTextDni().setText("");
		this.getTextLocalidad().setText("");
		this.getTextNombre().setText("");
		this.getTextTelefono().setText("");
		this.getTextPais().setText("");
		this.setVisible(false);
		
	}
	private JLabel getLblIntroduzcaSuFecha() {
		if (lblIntroduzcaSuFecha == null) {
			lblIntroduzcaSuFecha = new JLabel("Introduzca su fecha de nacimiento:");
			lblIntroduzcaSuFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIntroduzcaSuFecha.setBackground(Color.WHITE);
		}
		return lblIntroduzcaSuFecha;
	}
	public JTextField getTextFecha() {
		if (textFecha == null) {
			textFecha = new JTextField();
			textFecha.setColumns(10);
		}
		return textFecha;
	}
	
	public boolean compruebaCampos() {
		if(comprobarCampos())
			return true;
		return false;
	}
	
	
	
	private boolean comprobarCampos() {
		if(this.getTextCorreo().getText().isBlank()) {
			return false;
		} else if(this.getTextDni().getText().isBlank()) {
			return false;
		} else if(this.getTextFecha().getText().isBlank()) {
			return false;
		} else if(this.getTextLocalidad().getText().isBlank()) {
			return false;
		} else if(this.getTextNombre().getText().isBlank()) {
			return false;
		} else if(this.getTextPais().getText().isBlank()) {
			return false;
		} else if(this.getTextTelefono().getText().isBlank()) {
			return false;
		}
		return true;
	}
	
	public void camposEnBlanco() {
		JOptionPane.showMessageDialog(null, "Ningún campo puede quedar en blanco");
	}
	
	public void inscripcionRealizada() {
		String info=getTextDni().getText()+" - "+getTextNombre().getText()+" - "+getTextCorreo().getText();
		JOptionPane.showMessageDialog(null, info+" ha sido inscrito correctamente.");
	}
	
}
