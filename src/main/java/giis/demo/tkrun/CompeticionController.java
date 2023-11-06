package giis.demo.tkrun;

import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;

public class CompeticionController {
	
	private CompeticionModel model;
	private CompeticionView view;
	
	public CompeticionController(CompeticionModel m, CompeticionView v) {
		this.model = m;
		this.view = v;
		//no hay inicializacion especifica del modelo, solo de la vista
		this.initView();
	}
	
	/**
	 * Inicializacion del controlador: anyade los manejadores de eventos a los objetos del UI.
	 * Cada manejador de eventos se instancia de la misma forma, para que invoque un metodo privado
	 * de este controlador, encerrado en un manejador de excepciones generico para mostrar ventanas
	 * emergentes cuando ocurra algun problema o excepcion controlada.
	 */
	public void initController() {
		//ActionListener define solo un metodo actionPerformed(), es un interfaz funcional que se puede invocar de la siguiente forma:
		view.getBtnCrear().addActionListener(e -> actualizaCompeticion());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		view.getBtnCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
	
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		
	}
	
	private void dialogoContraseña() {
		JFrame frame = new JFrame("Password Dialog Example");
        String password = JOptionPane.showInputDialog(frame, "Introduce la contraseña de administrador: ");
        if(password == null) {
        	frame.dispose();
        } else if (password.equals("ips2023")) {
            // Redirigir a otra ventana
        	view.setVisible(true);
        } else {
            // Volver a pedir la contraseña
            JOptionPane.showMessageDialog(frame, "Contraseña incorrecta. Por favor, inténtalo de nuevo.");
            dialogoContraseña();
        }
	}

	private void salir() {
		int eleccion=JOptionPane.showConfirmDialog(null, "Está segur@ de cancelar la creación de la competición");
		if(eleccion==JOptionPane.YES_OPTION)
			view.reset();
	}
	public void initView() {
		dialogoContraseña();
	}
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void actualizaCompeticion() {
		if(view.validaCampos()) {
			String tipo="";
			if(view.getRdbtnRuta().isSelected())
				tipo="Ruta";
			else
				tipo="Montaña";
			Random rand = new Random(1000);
			int id = rand.nextInt();
			model.createCompeticion(id,view.getTextNombre().getText(), view.getTextInicio().getText(), view.getTextFin().getText(), view.getTextFecha().getText(),
					view.getTextCuota().getText(), view.getTextDescripcion().getText(), tipo, view.getTextNPlazas().getText(), view.getTextIBAN().getText(), view.getTextDistancia().getText());
			
			view.reset();
			view.dispose();
			JOptionPane.showMessageDialog(null, "Competición creada con éxito");
		}
	}

}
