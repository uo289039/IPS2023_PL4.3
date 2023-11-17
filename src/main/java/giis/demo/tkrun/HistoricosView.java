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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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

	private JFrame frmHistoricos;
	private JTextField nombreAtleta;
	private JButton btnClasificaciones;
	private JTable tabClasificacion;
	private JRadioButton rdbtnAmbos;
	private JRadioButton rdbtnTipo;
	private JRadioButton rdbtnDistancia;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JComboBox<String> comboDistancia;
	private JComboBox<String> comboTipo;

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
		frmHistoricos = new JFrame();
		frmHistoricos.getContentPane().setBackground(Color.WHITE);
		frmHistoricos.setTitle("Historicos");
		frmHistoricos.setName("Historicos");
		frmHistoricos.setBounds(0, 0, 492, 422);
		frmHistoricos.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		final JLabel lblSimulacion;
		final JLabel lbCarrera;
		frmHistoricos.getContentPane().setLayout(new MigLayout("", "[57px][11px][17px][17px][11px][9px][69px][8px][113px][10px][38px][9px][93px]", "[14px][23px][23px][265px]"));

		lblSimulacion = new JLabel("Historico en función del atleta:");
		frmHistoricos.getContentPane().add(lblSimulacion, "cell 0 0 7 1,alignx left,aligny top");
		
		lbCarrera = new JLabel("Correo del atleta:");
		frmHistoricos.getContentPane().add(lbCarrera, "cell 0 1 3 1,alignx left,aligny center");
		
		nombreAtleta = new JTextField();
		nombreAtleta.setName("txtFechaHoy");
		frmHistoricos.getContentPane().add(nombreAtleta, "cell 4 1 7 1,growx,aligny center");
		nombreAtleta.setColumns(10);
		
		btnClasificaciones = new JButton("Ver Historico");
		lbCarrera.setLabelFor(btnClasificaciones);
		frmHistoricos.getContentPane().add(btnClasificaciones, "cell 12 1,alignx left,aligny top");
		
		//Incluyo la tabla en un JScrollPane y anyado este en vez de la tabla para poder ver los headers de la tabla
		tabClasificacion = new JTable();
		tabClasificacion.setName("tabCarreras");
		tabClasificacion.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tabClasificacion.setDefaultEditor(Object.class, null); //readonly
		
		rdbtnAmbos = new JRadioButton("Ambos");
		rdbtnAmbos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboDistancia.setEnabled(true);
				comboTipo.setEnabled(true);
			}
		});
		rdbtnAmbos.setSelected(true);
		buttonGroup.add(rdbtnAmbos);
		rdbtnAmbos.setBackground(SystemColor.text);
		frmHistoricos.getContentPane().add(rdbtnAmbos, "cell 0 2,alignx left,aligny top");
		frmHistoricos.getContentPane().add(getComboDistancia(), "cell 8 2,growx,aligny top");
		JScrollPane tablePanel = new JScrollPane(tabClasificacion);
		frmHistoricos.getContentPane().add(tablePanel, "cell 0 3 13 1,grow");
		
		rdbtnTipo = new JRadioButton("Tipo");
		rdbtnTipo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboDistancia.setEnabled(false);
				comboTipo.setEnabled(true);
			}
		});
		buttonGroup.add(rdbtnTipo);
		rdbtnTipo.setBackground(SystemColor.text);
		frmHistoricos.getContentPane().add(rdbtnTipo, "cell 2 2 3 1,alignx left,aligny top");
		
		rdbtnDistancia = new JRadioButton("Distancia");
		rdbtnDistancia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboDistancia.setEnabled(true);
				comboTipo.setEnabled(false);
			}
		});
		buttonGroup.add(rdbtnDistancia);
		rdbtnDistancia.setBackground(SystemColor.text);
		frmHistoricos.getContentPane().add(rdbtnDistancia, "cell 6 2,alignx left,aligny top");
		
		comboTipo = new JComboBox<String>();
		frmHistoricos.getContentPane().add(comboTipo, "cell 10 2 3 1,growx,aligny top");
	}

	//Getters y Setters anyadidos para acceso desde el controlador (repersentacion compacta)
	public JFrame getFrame() { return this.frmHistoricos; }
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
	public JComboBox<String> getComboDistancia() {
		if (comboDistancia == null) {
			
			DefaultComboBoxModel<String> dcm=new DefaultComboBoxModel<String>(new String[] { "Maraton", "Media maraton", "Ultra maraton", "Todas"});
			comboDistancia = new JComboBox<String>(dcm);
		}
		return comboDistancia;
	}
	
	public void fijaModeloTipo(String[] data) {
		DefaultComboBoxModel<String> dcm=new DefaultComboBoxModel<String>(data);
		comboTipo.setModel(dcm);
	}
	
	
	public JComboBox<String> getComboTipo(){
		return comboTipo;
	}

	
}
