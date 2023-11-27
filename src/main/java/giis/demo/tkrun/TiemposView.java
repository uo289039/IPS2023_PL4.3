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
import javax.swing.JPanel;
import javax.swing.JCheckBox;

/**
 * Vista de la pantalla que muestra las carreras activas y permite interactuar con ellas.
 * <br/>Se ha generado con WindowBulder y modificado para ser conforme a MVC teniendo en cuenta:
 * - Se elimina main (es invocada desde CarrerasMain) y se incluye Title en el frame
 * - No se incluye ningun handler de eventos pues estos van en el controlador
 * - Las tablas se encierran en JOptionPane para que se puedan visualizar las cabeceras
 * - Se asinga nombre a las tablas si se van a automatizar la ejecucion de pruebas
 * - Incluye al final los metodos adicionales necesarios para acceder al UI desde el controlador
 */
public class TiemposView {

	private JFrame frame;
	private JTextField nombreCarrera;
	private JButton btnClasificaciones;
	private JTable tabClasificacion;
	private JRadioButton rdbtnGeneral;
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pnTiemposParciales;
	private JLabel lbTiemposParciales;
	private JCheckBox cbTb_1;
	private JCheckBox cbTb_5;
	private JCheckBox cbTb_2;
	private JCheckBox cbTb_3;
	private JCheckBox cbTb_4;

	/**
	 * Create the application.
	 */
	public TiemposView() {
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
		frame.setBounds(0, 0, 492, 541);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[grow]", "[][][grow][][][grow][][][][][][][]"));
		
		final JLabel lblSimulacion;
		final JLabel lbCarrera;

		lblSimulacion = new JLabel("Clasificacion en función de la carrera:");
		frame.getContentPane().add(lblSimulacion, "cell 0 1");
		
		lbCarrera = new JLabel("Nombre de la carrera:");
		frame.getContentPane().add(lbCarrera, "flowx,cell 0 3");
		
		nombreCarrera = new JTextField();
		nombreCarrera.setName("txtFechaHoy");
		frame.getContentPane().add(nombreCarrera, "cell 0 3,growx");
		nombreCarrera.setColumns(10);
		
		btnClasificaciones = new JButton("Ver Clasificación");
		lbCarrera.setLabelFor(btnClasificaciones);
		frame.getContentPane().add(btnClasificaciones, "cell 0 3");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabClasificacion = new JTable();
		tabClasificacion.setName("tabCarreras");
		tabClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabClasificacion.setDefaultEditor(Object.class, null); //readonly
		
		rdbtnGeneral = new JRadioButton("General");
		rdbtnGeneral.setSelected(true);
		buttonGroup.add(rdbtnGeneral);
		rdbtnGeneral.setBackground(SystemColor.text);
		frame.getContentPane().add(rdbtnGeneral, "flowx,cell 0 4");
		
		pnTiemposParciales = new JPanel();
		pnTiemposParciales.setBackground(new Color(255, 255, 255));
		frame.getContentPane().add(pnTiemposParciales, "cell 0 5,grow");
		
		lbTiemposParciales = new JLabel("Tiempos Parciales: ");
		pnTiemposParciales.add(lbTiemposParciales);
		
		cbTb_1 = new JCheckBox("1");
		cbTb_1.setEnabled(false);
		cbTb_1.setBackground(new Color(255, 255, 255));
		pnTiemposParciales.add(cbTb_1);
		
		cbTb_2 = new JCheckBox("2");
		cbTb_2.setEnabled(false);
		cbTb_2.setBackground(Color.WHITE);
		pnTiemposParciales.add(cbTb_2);
		
		cbTb_3 = new JCheckBox("3");
		cbTb_3.setEnabled(false);
		cbTb_3.setBackground(Color.WHITE);
		pnTiemposParciales.add(cbTb_3);
		
		cbTb_4 = new JCheckBox("4");
		cbTb_4.setEnabled(false);
		cbTb_4.setBackground(Color.WHITE);
		pnTiemposParciales.add(cbTb_4);
		
		cbTb_5 = new JCheckBox("5");
		cbTb_5.setEnabled(false);
		cbTb_5.setBackground(Color.WHITE);
		pnTiemposParciales.add(cbTb_5);
		JScrollPane tablePanel = new JScrollPane(tabClasificacion);
		frame.getContentPane().add(tablePanel, "cell 0 7,grow");
		
		rdbtnMasculino = new JRadioButton("Masculino");
		buttonGroup.add(rdbtnMasculino);
		rdbtnMasculino.setBackground(SystemColor.text);
		frame.getContentPane().add(rdbtnMasculino, "cell 0 4");
		
		rdbtnFemenino = new JRadioButton("Femenino");
		buttonGroup.add(rdbtnFemenino);
		rdbtnFemenino.setBackground(SystemColor.text);
		frame.getContentPane().add(rdbtnFemenino, "cell 0 4");
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frame; }
	public JButton getBtnTablaCarreras() { return this.btnClasificaciones; }
	public JTable getTablaCarreras() { return this.tabClasificacion; }
	
	public String getNombreCarrera() {
		return nombreCarrera.getText();
	}

	public void setNombreCarrera(String string) {
		this.nombreCarrera.setText(string);
	}
	
	public boolean isGeneralSelected() {
		return this.rdbtnGeneral.isSelected();
	}
	
	public boolean isMasculinoSelected() {
		return this.rdbtnMasculino.isSelected();
	}
	
	public boolean isFemeninoSelected() {
		return this.rdbtnFemenino.isSelected();
	}
	
	public JCheckBox getCbTb1() {
		return cbTb_1;
	}
	
	public JCheckBox getCbTb2() {
		return cbTb_2;
	}
	
	public JCheckBox getCbTb3() {
		return cbTb_3;
	}
	
	public JCheckBox getCbTb4() {
		return cbTb_4;
	}
	
	public JCheckBox getCbTb5() {
		return cbTb_5;
	}
	
}
