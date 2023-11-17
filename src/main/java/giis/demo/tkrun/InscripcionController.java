package giis.demo.tkrun;


import javax.swing.JOptionPane;

import giis.demo.util.SwingUtil;

public class InscripcionController {

	private InscripcionModel model;
	private InscripcionView view;
	
	public InscripcionController(InscripcionModel m, InscripcionView v) {
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
		view.getBtnRegistrarse().addActionListener(e -> actualizaAtletas());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		view.getBtnCancelar().addActionListener(e -> SwingUtil.exceptionWrapper(() -> salir()));
	
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		
	}
	
	private void salir() {
		int eleccion=JOptionPane.showConfirmDialog(null, "Está segur@ de cancelar la creación de la cuenta");
		if(eleccion==JOptionPane.YES_OPTION)
			view.reset();
	}
	public void initView() {
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.setVisible(true); 
	}
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void actualizaAtletas() {
		String sexo="";
		if(view.getRdbtnFemenino().isSelected())
			sexo="mujer";
		else
			sexo="hombre";
		
		
		String fecha=view.getTextFecha().getText();
		
		if(view.compruebaCampos()) {
			model.updateAtletas(view.getTextCorreo().getText(), view.getTextDni().getText(), view.getTextNombre().getText(), sexo,
				fecha, view.getTextLocalidad().getText(), view.getTextTelefono().getText(), view.getTextPais().getText());
			
			if(model.isActualizado()) {
				view.inscripcionRealizada();
				view.reset();
				model.reiniciaActualizado();
			}
			
		}
		else {
			view.camposEnBlanco();
		}
		
	}
	

	/**
	 * Restaura la informacion del detalle de la carrera para visualizar los valores correspondientes
	 * a la ultima clave almacenada.
	 */
	
	/**
	 * Al seleccionar un item de la tabla muestra el detalle con el valor del porcentaje de descuento
	 * de la carrera seleccinada y los valores de esta entidad
	 */
	
}
