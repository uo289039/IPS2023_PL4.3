package giis.demo.util;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import giis.demo.tkrun.*;

/**
 * Punto de entrada principal que incluye botones para la ejecucion de las pantallas 
 * de las aplicaciones de ejemplo
 * y acciones de inicializacion de la base de datos.
 * No sigue MVC pues es solamente temporal para que durante el desarrollo se tenga posibilidad
 * de realizar acciones de inicializacion
 */
public class SwingMain {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { //NOSONAR codigo autogenerado
			public void run() {
				try {
					SwingMain window = new SwingMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace(); //NOSONAR codigo autogenerado
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingMain() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("Main");
		frame.setBounds(0, 0, 613, 281);
		frame.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		
		JButton btnEjecutarTkrun = new JButton("Ejecutar para ver Competiciones");
		btnEjecutarTkrun.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				CarrerasController controller=new CarrerasController(new CarrerasModel(), new CarrerasView());
				controller.initController();
			}
		});
		frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
		frame.getContentPane().add(btnEjecutarTkrun);
		
			
		JButton btnInicializarBaseDeDatos = new JButton("Inicializar Base de Datos en Blanco");
		btnInicializarBaseDeDatos.setEnabled(false);
		btnInicializarBaseDeDatos.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
			}
		});
		frame.getContentPane().add(btnInicializarBaseDeDatos);
			
		JButton btnCargarDatosIniciales = new JButton("Cargar Datos Iniciales para Pruebas");
		btnCargarDatosIniciales.setEnabled(false);
		btnCargarDatosIniciales.addActionListener(new ActionListener() { //NOSONAR codigo autogenerado
			public void actionPerformed(ActionEvent e) {
				Database db=new Database();
				db.createDatabase(false);
				db.loadDatabase();
			}
		});
		frame.getContentPane().add(btnCargarDatosIniciales);
		
		JButton btnDatosAtletas = new JButton("Muestra Datos Atletas");
		btnDatosAtletas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AtletasController controller=new AtletasController(new AtletaModel(), new AtletasView());
				controller.initController();
			}
		});
		frame.getContentPane().add(btnDatosAtletas);
		
		JButton btnPreinscripcion = new JButton("Preinscripcion");
		btnPreinscripcion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ParticipaController iA=new ParticipaController(new ParticipaModel(), new ParticipaView());
				iA.initController();
			}
		});
		frame.getContentPane().add(btnPreinscripcion);
		
		JButton btnMisCompeticiones = new JButton("Mis Competiciones");
		btnMisCompeticiones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatosInscripcionController dic=new DatosInscripcionController(new DatosInscripcionModel(), new DatosInscripcionView());
				dic.initController();
			}
		});
		frame.getContentPane().add(btnMisCompeticiones);
		
		JButton btnRegistrarse = new JButton("Crear cuenta");
		btnRegistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InscripcionController ic=new InscripcionController(new InscripcionModel(), new InscripcionView());
				ic.initController();
			}
		});
		frame.getContentPane().add(btnRegistrarse);
	}

	public JFrame getFrame() { return this.frame; }
	
}
