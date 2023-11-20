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
public class AtletasView {

	private JFrame frame;
	private JTextField txtId;
	private JButton btnTabAtletas;
	private JTable tabAtletas;

	/**
	 * Create the application.
	 */
	public AtletasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Atletas");
		frame.setName("Atletas");
		frame.setBounds(0, 0, 492, 422);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		
		final JLabel lblSimulacion;
		final JLabel lblFechaHoy;

		lblSimulacion = new JLabel("Simulación de las competiciones para mostrar las ");
		frame.getContentPane().add(lblSimulacion, "cell 0 1");
		
		lblFechaHoy = new JLabel("Atletas de competicion:");
		frame.getContentPane().add(lblFechaHoy, "flowx,cell 0 3");
		
		txtId = new JTextField();
		txtId.setName("txtId");
		frame.getContentPane().add(txtId, "cell 0 3,growx");
		txtId.setColumns(10);
		
		btnTabAtletas = new JButton("Ver atletas en esta tabla");
		lblFechaHoy.setLabelFor(btnTabAtletas);
		frame.getContentPane().add(btnTabAtletas, "cell 0 3");
		
		JLabel lblLbltable = new JLabel("Proximas :");
		frame.getContentPane().add(lblLbltable, "cell 0 4");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabAtletas = new JTable();
		tabAtletas.setName("tabAtletas");
		tabAtletas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabAtletas.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabAtletas);
		frame.getContentPane().add(tablePanel, "cell 0 5,grow");
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frame; }
	public String getId()  { return this.txtId.getText(); }
	public void setId(String fechaIso)  { this.txtId.setText(fechaIso); }
	public JButton getBtnTablaAtletas() { return this.btnTabAtletas; }
	public JTable getTablaAtletas() { return this.tabAtletas; }
	
	public void avisaNombreNoValido(String nc) {
		JOptionPane.showMessageDialog(null, "El nombre "+nc+" no pertenece a una competición");
	}
}
