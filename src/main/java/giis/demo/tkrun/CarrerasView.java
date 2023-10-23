package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.Dimension;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

/**
 * Vista de la pantalla que muestra las carreras activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde CarrerasMain) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class CarrerasView {

	private JFrame frame;
	private JTextField txtFechaHoy;
	private JButton btnTabCarreras;
	private JTable tabCarreras;

	/**
	 * Create the application.
	 */
	public CarrerasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Carreras");
		frame.setName("Carreras");
		frame.setBounds(0, 0, 492, 422);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		
		final JLabel lblSimulacion;
		final JLabel lblFechaHoy;

		lblSimulacion = new JLabel("Simulación de la fecha de hoy para mostrar las carreras");
		frame.getContentPane().add(lblSimulacion, "cell 0 1");
		
		lblFechaHoy = new JLabel("Fecha de hoy (formato ISO):");
		frame.getContentPane().add(lblFechaHoy, "flowx,cell 0 3");
		
		txtFechaHoy = new JTextField();
		txtFechaHoy.setName("txtFechaHoy");
		frame.getContentPane().add(txtFechaHoy, "cell 0 3,growx");
		txtFechaHoy.setColumns(10);
		
		btnTabCarreras = new JButton("Ver carreras en esta tabla");
		lblFechaHoy.setLabelFor(btnTabCarreras);
		frame.getContentPane().add(btnTabCarreras, "cell 0 3");
		
		JLabel lblLbltable = new JLabel("Proximas carreras:");
		frame.getContentPane().add(lblLbltable, "cell 0 4");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabCarreras = new JTable();
		tabCarreras.setName("tabCarreras");
		tabCarreras.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabCarreras.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabCarreras);
		frame.getContentPane().add(tablePanel, "cell 0 5,grow");
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frame; }
	public String getFechaHoy()  { return this.txtFechaHoy.getText(); }
	public void setFechaHoy(String fechaIso)  { this.txtFechaHoy.setText(fechaIso); }
	public JButton getBtnTablaCarreras() { return this.btnTabCarreras; }
	public JTable getTablaCarreras() { return this.tabCarreras; }
//	public JComboBox<Object> getListaCarreras() { return this.lstCarreras; }
//	public void setDescuento(String descuento) { this.descuento.setText(descuento+"%"); }
//	public void setDescuentoNoAplicable() { this.descuento.setText("N/A"); }
//	public JTable getDetalleCarrera() { return this.tabDetalle; }
	
}
