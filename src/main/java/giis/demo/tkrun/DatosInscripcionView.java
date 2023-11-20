package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
//import javax.swing.JComboBox;
//
//import java.awt.Dimension;
//import java.awt.SystemColor;
//import javax.swing.UIManager;
import java.awt.Color;

/**
 * Vista de la pantalla que muestra las  activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde Main) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class DatosInscripcionView {

	private JFrame frmDatosInscripciones;
	private JTextField txtCorreo;
	private JButton btnTabInformacion;
	private JTable tabAtletas;

	/**
	 * Create the application.
	 */
	public DatosInscripcionView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDatosInscripciones = new JFrame();
		frmDatosInscripciones.getContentPane().setBackground(Color.WHITE);
		frmDatosInscripciones.setTitle("Datos de las Competiciones del Atleta");
		frmDatosInscripciones.setName("Atletas");
		frmDatosInscripciones.setBounds(0, 0, 492, 422);
		frmDatosInscripciones.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frmDatosInscripciones.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		
		final JLabel lblSimulacion;
		final JLabel lblFechaHoy;

		lblSimulacion = new JLabel("Simulación de las inscripciones para mostrar los ");
		frmDatosInscripciones.getContentPane().add(lblSimulacion, "cell 0 1");
		
		lblFechaHoy = new JLabel("Atletas, introduzca el correo: ");
		frmDatosInscripciones.getContentPane().add(lblFechaHoy, "flowx,cell 0 3");
		
		txtCorreo = new JTextField();
		txtCorreo.setName("txtId");
		frmDatosInscripciones.getContentPane().add(txtCorreo, "cell 0 3,growx");
		txtCorreo.setColumns(10);
		
		btnTabInformacion = new JButton("Ver datos de las inscripciones");
		lblFechaHoy.setLabelFor(btnTabInformacion);
		frmDatosInscripciones.getContentPane().add(btnTabInformacion, "cell 0 3");
		
		JLabel lblLbltable = new JLabel("Competiciones e información del Atleta :");
		frmDatosInscripciones.getContentPane().add(lblLbltable, "cell 0 4");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabAtletas = new JTable();
		tabAtletas.setName("tabAtletas");
		tabAtletas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabAtletas.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabAtletas);
		frmDatosInscripciones.getContentPane().add(tablePanel, "cell 0 5,grow");
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmDatosInscripciones; }
	public String getCorreo()  { return this.txtCorreo.getText(); }
	public void setCorreo(String fechaIso)  { this.txtCorreo.setText(fechaIso); }
	public JButton getBtnTablaInscripcionesAtletas() { return this.btnTabInformacion; }
	public JTable getTablaInscripcionesAtletas() { return this.tabAtletas; }

	public void avisaCorreo(String correo) {
		JOptionPane.showMessageDialog(null, "Introduzca un correo valido, "+correo+" no es valido");
		
	}
	
	
}
