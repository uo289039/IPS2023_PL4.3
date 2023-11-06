package giis.demo.tkrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;

public class CompeticionView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblInicio;
	private JLabel lblIFin;
	private JLabel lblCuota;
	private JLabel lblDescripcion;
	private JLabel lblTipo;
	private JButton btnCrear;
	private JButton btnCancelar;
	private JTextField textNombre;
	private JTextField textInicio;
	private JTextField textFin;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textCuota;
	private JTextField textIBAN;
	private JTextField textDescripcion;
	private JLabel lblFecha;
	private JPanel panel;
	private JRadioButton rdbtnMontaña;
	private JRadioButton rdbtnRuta;
	private JLabel lblNPlazas;
	private JTextField textNPlazas;
	private JLabel lblIBAN;
	private JTextField textFecha;
	private JLabel lblDistancia;
	private JTextField textDistancia;

	
	public CompeticionView() {
		setTitle("Crear competición");
		setBounds(100, 100, 653, 436);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[grow][grow][grow][grow][grow][][][grow][][][][][][][][][]"));
		contentPanel.add(getLblNombre(), "cell 0 4,growx,aligny center");
		contentPanel.add(getTextNombre(), "cell 1 4,growx");
		contentPanel.add(getLblInicio(), "cell 0 5,growx,aligny center");
		contentPanel.add(getTextInicio(), "cell 1 5,growx,aligny top");
		contentPanel.add(getLblIFin(), "cell 0 6,growx,aligny center");
		contentPanel.add(getTextFin(), "cell 1 6,growx,aligny top");
		contentPanel.add(getLblFecha(), "cell 0 7,alignx left,aligny center");
		contentPanel.add(getTextFecha(), "cell 1 7,growx");
		contentPanel.add(getLblCuota(), "cell 0 8,growx,aligny center");
		contentPanel.add(getTextCuota(), "cell 1 8,growx,aligny top");
		contentPanel.add(getLblDescripcion(), "cell 0 9,growx,aligny center");
		contentPanel.add(getTextDescripcion(), "cell 1 9,growx,aligny top");
		contentPanel.add(getLblTipo(), "cell 0 10,growx,aligny center");
		contentPanel.add(getPanel(), "cell 1 10,grow");
		contentPanel.add(getLblNPlazas(), "cell 0 11,alignx left");
		contentPanel.add(getTextNPlazas(), "cell 1 11,growx");
		contentPanel.add(getLblDistancia(), "cell 0 12,alignx left");
		contentPanel.add(getTextDistancia(), "cell 1 12,growx");
		contentPanel.add(getLblIBAN(), "cell 0 13,alignx left");
		contentPanel.add(getTextIBAN(), "cell 1 13,growx,aligny top");
		contentPanel.add(getBtnCancelar(), "flowx,cell 1 16,alignx right,aligny top");
		contentPanel.add(getBtnCrear(), "cell 2 16,growx,aligny top");
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Introduzca el nombre para la competición:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setBackground(Color.WHITE);
		}
		return lblNombre;
	}
	private JLabel getLblInicio() {
		if (lblInicio == null) {
			lblInicio = new JLabel("Introduzca el inicio del plazo de inscripción: (YYYY-MM-DD)");
			lblInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblInicio.setBackground(Color.WHITE);
		}
		return lblInicio;
	}
	private JLabel getLblIFin() {
		if (lblIFin == null) {
			lblIFin = new JLabel("Introduzca el fin del plazo de inscripción: (YYYY-MM-DD)");
			lblIFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIFin.setBackground(Color.WHITE);
		}
		return lblIFin;
	}
	private JLabel getLblCuota() {
		if (lblCuota == null) {
			lblCuota = new JLabel("Introduzca la cuota de inscripción:");
			lblCuota.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblCuota.setBackground(Color.WHITE);
		}
		return lblCuota;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Introduzca la descripción de la competición:");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDescripcion.setBackground(Color.WHITE);
		}
		return lblDescripcion;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Seleccione el tipo de competición:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipo.setBackground(Color.WHITE);
		}
		return lblTipo;
	}
	public JButton getBtnCrear() {
		if (btnCrear == null) {
			btnCrear = new JButton("Crear");
		}
		return btnCrear;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	public JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	public JTextField getTextInicio() {
		if (textInicio == null) {
			textInicio = new JTextField();
			textInicio.setColumns(10);
		}
		return textInicio;
	}
	public JTextField getTextFin() {
		if (textFin == null) {
			textFin = new JTextField();
			textFin.setColumns(10);
		}
		return textFin;
	}
	public JTextField getTextCuota() {
		if (textCuota == null) {
			textCuota = new JTextField();
			textCuota.setColumns(10);
		}
		return textCuota;
	}
	public JTextField getTextIBAN() {
		if (textIBAN == null) {
			textIBAN = new JTextField();
			textIBAN.setColumns(10);
		}
		return textIBAN;
	}
	public JTextField getTextDescripcion() {
		if (textDescripcion == null) {
			textDescripcion = new JTextField();
			textDescripcion.setColumns(10);
		}
		return textDescripcion;
	}
	public JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Introduzca la fecha de la competición: (YYYY-MM-DD)");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblFecha;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);

			panel.add(getRdbtnMontaña());
			panel.add(getRdbtnRuta());
		}
		return panel;
	}
	public JRadioButton getRdbtnMontaña() {
		if (rdbtnMontaña == null) {
			rdbtnMontaña = new JRadioButton("Montaña");
			rdbtnMontaña.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMontaña);
		}
		return rdbtnMontaña;
	}
	public JRadioButton getRdbtnRuta() {
		if (rdbtnRuta == null) {
			rdbtnRuta = new JRadioButton("Ruta");
			rdbtnRuta.setSelected(true);
			rdbtnRuta.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnRuta);
		}
		return rdbtnRuta;
	}
	public void reset() {
		this.getTextNombre().setText("");
		this.getTextInicio().setText("");
		this.getTextFin().setText("");
		this.getTextFecha().setText("");
		this.getTextCuota().setText("");
		this.getTextDescripcion().setText("");
		this.getTextNPlazas().setText("");
		this.getTextIBAN().setText("");
		this.setVisible(false);
		
	}
	private JLabel getLblNPlazas() {
		if (lblNPlazas == null) {
			lblNPlazas = new JLabel("Introduzca el número de plazas:");
			lblNPlazas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNPlazas.setBackground(Color.WHITE);
		}
		return lblNPlazas;
	}
	public JTextField getTextNPlazas() {
		if (textNPlazas == null) {
			textNPlazas = new JTextField();
			textNPlazas.setColumns(10);
		}
		return textNPlazas;
	}
	private JLabel getLblIBAN() {
		if (lblIBAN == null) {
			lblIBAN = new JLabel("Introduzca el IBAN: ");
			lblIBAN.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIBAN.setBackground(Color.WHITE);
		}
		return lblIBAN;
	}
	public JTextField getTextFecha() {
		if (textFecha == null) {
			textFecha = new JTextField();
			textFecha.setColumns(10);
		}
		return textFecha;
	}
	public boolean validaCampos() {
		if(!comprobarCampos()) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");
			return false;
		}
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String inicio = getTextInicio().getText();
		LocalDate fechaInicio = LocalDate.parse(inicio, formatter);
		String fin = getTextFin().getText();
		LocalDate fechaFin = LocalDate.parse(fin, formatter);
		String fecha = getTextFecha().getText();
		LocalDate fechaComp = LocalDate.parse(fecha, formatter);
		if(!fechaFin.isAfter(fechaInicio)) {
			JOptionPane.showMessageDialog(null, "La fecha de fin tiene que ser posterior a la de inicio");
			return false;
		} else if(!fechaComp.isAfter(fechaFin)) {
			JOptionPane.showMessageDialog(null, "La fecha de la competición tiene que ser posterior a la de fin de inscripción");
			return false;
		}
		return true;
	}
	private boolean comprobarCampos() {
		if(this.getTextCuota().getText().isBlank()) {
			return false;
		} else if(this.getTextDescripcion().getText().isBlank()) {
			return false;
		} else if(this.getTextFecha().getText().isBlank()) {
			return false;
		} else if(this.getTextFin().getText().isBlank()) {
			return false;
		} else if(this.getTextInicio().getText().isBlank()) {
			return false;
		} else if(this.getTextIBAN().getText().isBlank()) {
			return false;
		} else if(this.getTextNombre().getText().isBlank()) {
			return false;
		} else if(this.getTextNPlazas().getText().isBlank()) {
			return false;
		} else if(this.getTextDistancia().getText().isBlank()) {
			return false;
		}
		return true;
	}
	private JLabel getLblDistancia() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Introduzca la distancia de la carrera:");
			lblDistancia.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDistancia.setBackground(Color.WHITE);
		}
		return lblDistancia;
	}
	public JTextField getTextDistancia() {
		if (textDistancia == null) {
			textDistancia = new JTextField();
			textDistancia.setColumns(10);
		}
		return textDistancia;
	}
}
