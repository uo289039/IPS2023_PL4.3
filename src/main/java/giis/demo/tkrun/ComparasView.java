package giis.demo.tkrun;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
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
import javax.swing.JOptionPane;

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
		frmCompararAtletas.getContentPane().setLayout(new MigLayout("", "[grow][grow][grow][grow]", "[grow][grow][grow][grow]"));
		
		lblFechaHoy = new JLabel("Inserte su correo identificador:");
		frmCompararAtletas.getContentPane().add(lblFechaHoy, "cell 0 0,alignx left,aligny top");
		
		txtAtleta = new JTextField();
		txtAtleta.setName("txtAtleta");
		frmCompararAtletas.getContentPane().add(txtAtleta, "cell 0 1,growx,aligny center");
		txtAtleta.setColumns(10);
		
		btnTabAtletas = new JButton("Eliminar seleccionado(s)");
		btnTabAtletas.setEnabled(false);
		lblFechaHoy.setLabelFor(btnTabAtletas);
		frmCompararAtletas.getContentPane().add(btnTabAtletas, "cell 1 3 3 1,alignx right,aligny top");
		
		JLabel lblNombreCompeticion = new JLabel("Inserte el nombre de la competición:");
		frmCompararAtletas.getContentPane().add(lblNombreCompeticion, "cell 1 0,growx,aligny top");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabAtletas = new JTable();
		tabAtletas.setName("tabAtletas");
		tabAtletas.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabAtletas.setDefaultEditor(Object.class, null); //readonly
		JScrollPane tablePanel = new JScrollPane(tabAtletas);
		frmCompararAtletas.getContentPane().add(tablePanel, "cell 1 2 3 1,grow");
		frmCompararAtletas.getContentPane().add(getBtnAñadir(), "cell 0 3,alignx right,aligny top");
		
		listNombresAtletas = new JList<String>();
		listNombresAtletas.setValueIsAdjusting(true);
		frmCompararAtletas.getContentPane().add(listNombresAtletas, "cell 0 2,grow");
		frmCompararAtletas.getContentPane().add(getTextCompeticion(), "cell 1 1,growx,aligny center");
		frmCompararAtletas.getContentPane().add(getBtnVerAtletas(), "cell 3 1,alignx left,aligny top");
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
		}
		return btnAñadir;
	}
	public JTextField getTextCompeticion() {
		if (textCompeticion == null) {
			textCompeticion = new JTextField();
			textCompeticion.setName("textCompeticion");
			textCompeticion.setColumns(10);
		}
		return textCompeticion;
	}
	public JButton getBtnVerAtletas() {
		if (btnVerAtletas == null) {
			btnVerAtletas = new JButton("Ver Atletas");
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

	public void carreraNoExiste(String carrera) {
		JOptionPane.showMessageDialog(null, "La carrera "+carrera+" no existe");
		
	}

	public void avisaSelecciona() {
		JOptionPane.showMessageDialog(null, "Por favor seleccione al menos un competidor para poder comparar sus resultados");
		
	}
	
	public void avisaCorreo() {
		JOptionPane.showMessageDialog(null, "Por favor introduzca un correoValido");
		
	}

	public void borraFila(int fila) {
		DefaultTableModel modelo=(DefaultTableModel)tabAtletas.getModel();
		modelo.removeRow(fila);
		tabAtletas.setModel(modelo);
		
	}
}
