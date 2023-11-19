package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
//import javax.swing.JComboBox;
//
//import java.awt.Dimension;
//import java.awt.SystemColor;
//import javax.swing.UIManager;
import java.awt.Color;
import java.util.List;

import javax.swing.JList;

/**
 * Vista de la pantalla que muestra las  activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde Main) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class ComparasView {

	private JFrame frmCompararAtletas;
	private JTextField txtAtleta;
	private JButton btnTabAtletas;
	private JTable tabAtletas;
	private JButton btnAñadir;
	private JList<String> listNombresAtletas;
	private JTextField textCompeticion;
	private JButton btnVerAtletas;

	/**
	 * Create the application.
	 */
	public ComparasView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCompararAtletas = new JFrame();
		frmCompararAtletas.getContentPane().setBackground(Color.WHITE);
		frmCompararAtletas.setTitle("Comparar Atletas");
		frmCompararAtletas.setName("Atletas");
		frmCompararAtletas.setBounds(0, 0, 740, 465);
		frmCompararAtletas.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		final JLabel lblFechaHoy;
		frmCompararAtletas.getContentPane().setLayout(null);
		
		lblFechaHoy = new JLabel("Inserte su correo identificador:");
		lblFechaHoy.setBounds(21, 44, 192, 14);
		frmCompararAtletas.getContentPane().add(lblFechaHoy);
		
		txtAtleta = new JTextField();
		txtAtleta.setBounds(10, 69, 218, 20);
		txtAtleta.setName("txtAtleta");
		frmCompararAtletas.getContentPane().add(txtAtleta);
		txtAtleta.setColumns(10);
		
		btnTabAtletas = new JButton("Eliminar seleccionado(s)");
		btnTabAtletas.setEnabled(false);
		btnTabAtletas.setBounds(532, 392, 185, 23);
		lblFechaHoy.setLabelFor(btnTabAtletas);
		frmCompararAtletas.getContentPane().add(btnTabAtletas);
		
		JLabel lblNombreCompeticion = new JLabel("Inserte el nombre de la competición:");
		lblNombreCompeticion.setBounds(347, 44, 206, 14);
		frmCompararAtletas.getContentPane().add(lblNombreCompeticion);
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabAtletas = new JTable();
		tabAtletas.setName("tabAtletas");
		tabAtletas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabAtletas.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabAtletas);
		tablePanel.setBounds(361, 111, 356, 270);
		frmCompararAtletas.getContentPane().add(tablePanel);
		frmCompararAtletas.getContentPane().add(getBtnAñadir());
		
		listNombresAtletas = new JList<String>();
		listNombresAtletas.setValueIsAdjusting(true);
		listNombresAtletas.setBounds(21, 111, 313, 270);
		frmCompararAtletas.getContentPane().add(listNombresAtletas);
		frmCompararAtletas.getContentPane().add(getTextCompeticion());
		frmCompararAtletas.getContentPane().add(getBtnVerAtletas());
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmCompararAtletas; }
	public String getTextAtleta()  { return this.txtAtleta.getText(); }
	public void setTextAtleta(String fechaIso)  { this.txtAtleta.setText(fechaIso); }
	public JButton getBtnTablaAtletas() { return this.btnTabAtletas; }
	public JTable getTablaAtletas() { return this.tabAtletas; }
	
	public JButton getBtnAñadir() {
		if (btnAñadir == null) {
			btnAñadir = new JButton("Añadir");
			btnAñadir.setEnabled(false);
			btnAñadir.setBounds(211, 392, 89, 23);
		}
		return btnAñadir;
	}
	public JTextField getTextCompeticion() {
		if (textCompeticion == null) {
			textCompeticion = new JTextField();
			textCompeticion.setName("textCompeticion");
			textCompeticion.setColumns(10);
			textCompeticion.setBounds(336, 69, 218, 20);
		}
		return textCompeticion;
	}
	public JButton getBtnVerAtletas() {
		if (btnVerAtletas == null) {
			btnVerAtletas = new JButton("Ver Atletas");
			btnVerAtletas.setBounds(576, 68, 107, 23);
		}
		return btnVerAtletas;
	}

	public void setModeloLista(List<AtletaDisplayDTO> atletas) {
		DefaultListModel<String>modelo=new DefaultListModel<String>();
		for(int i=0;i<atletas.size();i++)
			modelo.add(i,atletas.get(i).getNombre());
		
		listNombresAtletas.setModel(modelo);
		
	}
	
	public JList<String> getListaCompetidores(){
		return listNombresAtletas;
	}
}
