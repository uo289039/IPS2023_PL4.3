package giis.demo.tkrun;

import java.awt.EventQueue;

import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class ParticipaView extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panelBotones;
	private JPanel panelB;
	private JButton btnOk;
	private JButton btnCancelar;
	private JLabel lblTitulo;
	private JPanel panelPideInfo;
	private JLabel lblE1;
	private JLabel lblSelecCompet;
	private JLabel lblIntroduceCorreo;
	private JPanel panelDatos;
	private JLabel lblE2;
	private JComboBox<CarreraDisplayDTO> comboBoxCompeticiones;
	private JTextField textFieldCorreo;
	private JLabel lblPago;
	private JPanel panelRBotones;
	private JRadioButton rdbtnTarjeta;
	private JRadioButton rdbtnTransferencia;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public ParticipaView() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().add(getPanelBotones(), BorderLayout.SOUTH);
		getContentPane().add(getLblTitulo(), BorderLayout.NORTH);
		getContentPane().add(getPanelPideInfo(), BorderLayout.WEST);
		getContentPane().add(getPanelDatos(), BorderLayout.CENTER);
		setBounds(100, 100, 747, 422);

	}

	private JPanel getPanelBotones() {
		if (panelBotones == null) {
			panelBotones = new JPanel();
			panelBotones.setBackground(Color.WHITE);
			panelBotones.setLayout(new BorderLayout(0, 0));
			panelBotones.add(getPanelB(), BorderLayout.EAST);
		}
		return panelBotones;
	}
	private JPanel getPanelB() {
		if (panelB == null) {
			panelB = new JPanel();
			panelB.setBackground(Color.WHITE);
			panelB.add(getBtnOk());
			panelB.add(getBtnCancelar());
		}
		return panelB;
	}
	public JButton getBtnOk() {
		if (btnOk == null) {
			btnOk = new JButton("OK");
		}
		return btnOk;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	private JLabel getLblTitulo() {
		if (lblTitulo == null) {
			lblTitulo = new JLabel("PREINSCRIPCIÓN");
			lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		}
		return lblTitulo;
	}
	private JPanel getPanelPideInfo() {
		if (panelPideInfo == null) {
			panelPideInfo = new JPanel();
			panelPideInfo.setBackground(Color.WHITE);
			panelPideInfo.setLayout(new GridLayout(5, 1, 0, 0));
			panelPideInfo.add(getLblE1());
			panelPideInfo.add(getLblSelecCompet());
			panelPideInfo.add(getLblIntroduceCorreo());
			panelPideInfo.add(getLblPago());
		}
		return panelPideInfo;
	}
	private JLabel getLblE1() {
		if (lblE1 == null) {
			lblE1 = new JLabel("");
		}
		return lblE1;
	}
	private JLabel getLblSelecCompet() {
		if (lblSelecCompet == null) {
			lblSelecCompet = new JLabel("Seleccione la competición para preinscribirse: ");
		}
		return lblSelecCompet;
	}
	private JLabel getLblIntroduceCorreo() {
		if (lblIntroduceCorreo == null) {
			lblIntroduceCorreo = new JLabel("Introduzca su correo electrónico para registrarse:");
		}
		return lblIntroduceCorreo;
	}
	private JPanel getPanelDatos() {
		if (panelDatos == null) {
			panelDatos = new JPanel();
			panelDatos.setBackground(Color.WHITE);
			panelDatos.setLayout(new GridLayout(5, 1, 0, 0));
			panelDatos.add(getLblE2());
			panelDatos.add(getComboBoxCompeticiones());
			panelDatos.add(getTextFieldCorreo());
			panelDatos.add(getPanelRBotones());
		}
		return panelDatos;
	}
	private JLabel getLblE2() {
		if (lblE2 == null) {
			lblE2 = new JLabel("");
		}
		return lblE2;
	}
	public JComboBox<CarreraDisplayDTO> getComboBoxCompeticiones() {
		if (comboBoxCompeticiones == null) {
			comboBoxCompeticiones = new JComboBox<CarreraDisplayDTO>();
			comboBoxCompeticiones.setBackground(Color.WHITE);
		}
		return comboBoxCompeticiones;
	}
	public JTextField getTextFieldCorreo() {
		if (textFieldCorreo == null) {
			textFieldCorreo = new JTextField();
			textFieldCorreo.setColumns(10);
		}
		return textFieldCorreo;
	}

	public void reiniciar() {
		this.getComboBoxCompeticiones().setSelectedIndex(0);
		this.getTextFieldCorreo().setText("");
		this.setVisible(false);
		
	}
	
	
	private JLabel getLblPago() {
		if (lblPago == null) {
			lblPago = new JLabel("Seleccione su forma de pago:");
		}
		return lblPago;
	}
	private JPanel getPanelRBotones() {
		if (panelRBotones == null) {
			panelRBotones = new JPanel();
			panelRBotones.setBorder(new TitledBorder(null, "Forma de Pago", TitledBorder.LEADING, TitledBorder.TOP, null, null));
			panelRBotones.setBackground(Color.WHITE);
			panelRBotones.add(getRdbtnTarjeta());
			panelRBotones.add(getRdbtnTransferencia());
		}
		return panelRBotones;
	}
	private JRadioButton getRdbtnTarjeta() {
		if (rdbtnTarjeta == null) {
			rdbtnTarjeta = new JRadioButton("Tarjeta");
			buttonGroup.add(rdbtnTarjeta);
			rdbtnTarjeta.setSelected(true);
			rdbtnTarjeta.setBackground(Color.WHITE);
		}
		return rdbtnTarjeta;
	}
	private JRadioButton getRdbtnTransferencia() {
		if (rdbtnTransferencia == null) {
			rdbtnTransferencia = new JRadioButton("Transferencia\r\n");
			buttonGroup.add(rdbtnTransferencia);
			rdbtnTransferencia.setBackground(Color.WHITE);
		}
		return rdbtnTransferencia;
	}
}
