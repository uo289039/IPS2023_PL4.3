package giis.demo.tkrun;

//import java.awt.EventQueue;
//
//import javax.swing.JDialog;
import javax.swing.JFrame;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
//import java.awt.Font;
//import java.awt.GridLayout;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import net.miginfocom.swing.MigLayout;
import java.awt.Component;
import javax.swing.ListSelectionModel;

public class ParticipaView extends JFrame {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private JPanel panelBotones;
	private JPanel panelB;
	private JButton btnOk;
	private JButton btnCancelar;
//	private JComboBox<CarreraDisplayDTO> comboBoxCompeticiones;
	private JTextField textFieldCorreo;
	private JPanel panelRBotones;
	private JRadioButton rdbtnTarjeta;
	private JRadioButton rdbtnTransferencia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JLabel lblIntro;
	private JLabel lblCorreo;
	private JLabel lblCompeticiones;
	private JScrollPane tablePanel;
	private JTable table;
	private JButton btnCrearCuenta;
//	private JLabel lblCbox;
	

	public ParticipaView() {
		
		setTitle("Preinscripcion");
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(new MigLayout("", "[grow][grow]", "[][][grow][][][][][][][][]"));
		getContentPane().add(getTextFieldCorreo(), "cell 1 1");
		getContentPane().add(getBtnCrearCuenta(), "cell 1 6");
		getContentPane().add(getPanelBotones(), "cell 0 7 3 1,growx,aligny top");
//		getContentPane().add(getComboBoxCompeticiones(), "cell 0 5 3 1,growx,aligny top");
		getContentPane().add(getPanelRBotones(), "cell 0 6,alignx left,aligny top");
		getContentPane().add(getLblIntro(), "cell 0 0,alignx left,aligny top");
		getContentPane().add(getLblCorreo(), "cell 0 1,alignx left,aligny center");
		getContentPane().add(getLblCompeticiones(), "cell 0 2 3 1,alignx left,aligny top");
		getContentPane().add(getTablePanel(), "cell 0 3 3 1,grow");
//		getContentPane().add(getLblCbox(), "cell 0 4 3 1,alignx left,aligny top");
		setBounds(100, 100, 720, 432);

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
//	public JComboBox<CarreraDisplayDTO> getComboBoxCompeticiones() {
//		if (comboBoxCompeticiones == null) {
//			comboBoxCompeticiones = new JComboBox<CarreraDisplayDTO>();
//			comboBoxCompeticiones.setEditable(true);
//			comboBoxCompeticiones.setBackground(Color.WHITE);
//		}
//		return comboBoxCompeticiones;
//	}
	public JTextField getTextFieldCorreo() {
		if (textFieldCorreo == null) {
			textFieldCorreo = new JTextField();
			textFieldCorreo.setColumns(10);
		}
		return textFieldCorreo;
	}

	public void reiniciar() {
//		this.getComboBoxCompeticiones().setSelectedIndex(0);
		this.getTextFieldCorreo().setText("");
		this.setVisible(false);
		
		
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
	public JRadioButton getRdbtnTarjeta() {
		if (rdbtnTarjeta == null) {
			rdbtnTarjeta = new JRadioButton("Tarjeta");
			buttonGroup.add(rdbtnTarjeta);
			rdbtnTarjeta.setSelected(true);
			rdbtnTarjeta.setBackground(Color.WHITE);
		}
		return rdbtnTarjeta;
	}
	public JRadioButton getRdbtnTransferencia() {
		if (rdbtnTransferencia == null) {
			rdbtnTransferencia = new JRadioButton("Transferencia\r\n");
			buttonGroup.add(rdbtnTransferencia);
			rdbtnTransferencia.setBackground(Color.WHITE);
		}
		return rdbtnTransferencia;
	}
	private JLabel getLblIntro() {
		if (lblIntro == null) {
			lblIntro = new JLabel("Introduccion del correo electrónico para preinscribirse");
		}
		return lblIntro;
	}
	private JLabel getLblCorreo() {
		if (lblCorreo == null) {
			lblCorreo = new JLabel("Su correo eletrónico validado:");
		}
		return lblCorreo;
	}
	private JLabel getLblCompeticiones() {
		if (lblCompeticiones == null) {
			lblCompeticiones = new JLabel("Competiciones actuales, pinche en la fila para seleccionar la competición a la que desea apuntarse:");
		}
		return lblCompeticiones;
	}
	private JScrollPane getTablePanel() {
		if (tablePanel == null) {
			tablePanel = new JScrollPane((Component) null);
			tablePanel.setViewportView(getTable());
		}
		return tablePanel;
	}
	public JTable getTable() {
		if (table == null) {
			table = new JTable();
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			table.setBackground(Color.WHITE);
		}
		return table;
	}
//	private JLabel getLblCbox() {
//		if (lblCbox == null) {
//			lblCbox = new JLabel("Puede seleccionar su competicion, también en esta lista despegable:");
//		}
//		return lblCbox;
//	}
	
	
	
	
	public JButton getBtnCrearCuenta() {
		if (btnCrearCuenta == null) {
			btnCrearCuenta = new JButton("¿No tiene una cuenta validada? Pulse aquí para crearla");
		}
		return btnCrearCuenta;
	}
}
