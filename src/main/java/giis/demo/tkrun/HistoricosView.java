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
import javax.swing.JRadioButton;
import java.awt.SystemColor;
import javax.swing.ButtonGroup;

/**
 * Vista de la pantalla que muestra las carreras activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde CarrerasMain) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class HistoricosView {

	private JFrame frame;
	private JTextField nombreAtleta;
	private JButton btnClasificaciones;
	private JTable tabClasificacion;
	private JRadioButton rdbtnAmbos;
	private JRadioButton rdbtnTipo;
	private JRadioButton rdbtnDistancia;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the application.
	 */
	public HistoricosView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setTitle("Clasificaciones");
		frame.setName("Clasificaciones");
		frame.setBounds(0, 0, 492, 422);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][][][][][][][]"));
		
		final JLabel lblSimulacion;
		final JLabel lbCarrera;

		lblSimulacion = new JLabel("Historico en función del atleta:");
		frame.getContentPane().add(lblSimulacion, "cell 0 1");
		
		lbCarrera = new JLabel("Correo del atleta:");
		frame.getContentPane().add(lbCarrera, "flowx,cell 0 3");
		
		nombreAtleta = new JTextField();
		nombreAtleta.setName("txtFechaHoy");
		frame.getContentPane().add(nombreAtleta, "cell 0 3,growx");
		nombreAtleta.setColumns(10);
		
		btnClasificaciones = new JButton("Ver Historico");
		lbCarrera.setLabelFor(btnClasificaciones);
		frame.getContentPane().add(btnClasificaciones, "cell 0 3");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabClasificacion = new JTable();
		tabClasificacion.setName("tabCarreras");
		tabClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabClasificacion.setDefaultEditor(Object.class, null); //readonly
		
		rdbtnAmbos = new JRadioButton("Ambos");
		rdbtnAmbos.setSelected(true);
		buttonGroup.add(rdbtnAmbos);
		rdbtnAmbos.setBackground(SystemColor.text);
		frame.getContentPane().add(rdbtnAmbos, "flowx,cell 0 4");
		JScrollPane tablePanel = new JScrollPane(tabClasificacion);
		frame.getContentPane().add(tablePanel, "cell 0 6,grow");
		
		rdbtnTipo = new JRadioButton("Tipo");
		buttonGroup.add(rdbtnTipo);
		rdbtnTipo.setBackground(SystemColor.text);
		frame.getContentPane().add(rdbtnTipo, "cell 0 4");
		
		rdbtnDistancia = new JRadioButton("Distancia");
		buttonGroup.add(rdbtnDistancia);
		rdbtnDistancia.setBackground(SystemColor.text);
		frame.getContentPane().add(rdbtnDistancia, "cell 0 4");
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frame; }
	public JButton getBtnTablaCarreras() { return this.btnClasificaciones; }
	public JTable getTablaCarreras() { return this.tabClasificacion; }
	
	public String getNombreCarrera() {
		return nombreAtleta.getText();
	}

	public void setNombreCarrera(String string) {
		this.nombreAtleta.setText(string);
	}
	
	public boolean isGeneralSelected() {
		return this.rdbtnAmbos.isSelected();
	}
	
	public boolean isTipoSelected() {
		return this.rdbtnTipo.isSelected();
	}
	
	public boolean isDistanciaSelected() {
		return this.rdbtnDistancia.isSelected();
	}
	
}
