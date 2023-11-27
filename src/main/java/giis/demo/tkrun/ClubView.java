package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JButton;
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
public class ClubView {

	private JFrame frame;
	private JTextField tfClub;
	private JButton btnApuntarClub;
	private JTable tabCarreras;

	/**
	 * Create the application.
	 */
	public ClubView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Inscripción clubes");
		frame.setName("Inscripción clubes");
		frame.setBounds(0, 0, 663, 306);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][]"));
		final JLabel lbNombreClub;
		
		lbNombreClub = new JLabel("Introduzca el nombre del club (Sin espacios):");
		frame.getContentPane().add(lbNombreClub, "flowx,cell 0 3");
		
		tfClub = new JTextField();
		tfClub.setName("txtFechaHoy");
		frame.getContentPane().add(tfClub, "cell 0 3,growx");
		tfClub.setColumns(10);
		
		btnApuntarClub = new JButton("Apuntar miembros del club");
		lbNombreClub.setLabelFor(btnApuntarClub);
		frame.getContentPane().add(btnApuntarClub, "cell 0 3");
		
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
	public JTextField getTfClub()  { return this.tfClub; }
	public void setFechaHoy(String fechaIso)  { this.tfClub.setText(fechaIso); }
	public JButton getBtnApuntarClub() { return this.btnApuntarClub; }
	public JTable getTablaCarreras() { return this.tabCarreras; }
	
}
