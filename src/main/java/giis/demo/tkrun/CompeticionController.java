package giis.demo.tkrun;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;

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
		getCategorias();
		getPlazos();
	}
	public void getCategorias() {
		List<CategoriaDisplayDTO> categorias=categoriasPorDefecto();
		TableModel tmodel=SwingUtil.getTableModelFromPojos(categorias, new String[] {"nombre", "edadMin","edadMax","genero"});
		view.getTbCategorias().setModel(tmodel);
//		SwingUtil.autoAdjustColumns(view.getTbCategorias());
		
		//Como se guarda la clave del ultimo elemento seleccionado, restaura la seleccion de los detalles
//		this.restoreDetail();

		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
//		List<Object[]> carrerasList=model.getListaAtletasArray((view.getId()));
//		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(carrerasList);
//		view.getListaAtletas().setModel(lmodel);
	}
	private List<CategoriaDisplayDTO> categoriasPorDefecto() {
		List<CategoriaDisplayDTO> categorias = new ArrayList<>();
		categorias.add(new CategoriaDisplayDTO("Junior masculino", 1, 15, "Masculino"));
		categorias.add(new CategoriaDisplayDTO("Sub 18 masculino", 15, 18, "Masculino"));
		categorias.add(new CategoriaDisplayDTO("Sub 25 masculino", 18, 25, "Masculino"));
		categorias.add(new CategoriaDisplayDTO("Senior 35 masculino", 25, 35, "Masculino"));
		categorias.add(new CategoriaDisplayDTO("Senior 45 masculino", 35, 45, "Masculino"));
		categorias.add(new CategoriaDisplayDTO("Senior masculino", 45, 100, "Masculino"));
		categorias.add(new CategoriaDisplayDTO("Junior femenino", 1, 15, "Femenino"));
		categorias.add(new CategoriaDisplayDTO("Sub 18 femenino", 15, 18, "Femenino"));
		categorias.add(new CategoriaDisplayDTO("Sub 25 femenino", 18, 25, "Femenino"));
		categorias.add(new CategoriaDisplayDTO("Senior 35 femenino", 25, 35, "Femenino"));
		categorias.add(new CategoriaDisplayDTO("Senior 45 femenino", 35, 45, "Femenino"));
		categorias.add(new CategoriaDisplayDTO("Senior femenino", 45, 100, "Femenino"));
		for (int i=0; i<8; i++)
			categorias.add(new CategoriaDisplayDTO());
		return categorias;
	}
	
	public void getPlazos() {
		List<PlazoDisplayDTO> plazos=plazosPorDefecto();
		TableModel tmodel=SwingUtil.getTableModelFromPojos(plazos, new String[] {"descr", "fechaIni","fechaFin","cuota"});
		view.getTbPlazos().setModel(tmodel);
//		SwingUtil.autoAdjustColumns(view.getTbPlazos());
		
		//Como se guarda la clave del ultimo elemento seleccionado, restaura la seleccion de los detalles
//		this.restoreDetail();

		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
//		List<Object[]> carrerasList=model.getListaAtletasArray((view.getId()));
//		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(carrerasList);
//		view.getListaAtletas().setModel(lmodel);
	}
	
	private List<PlazoDisplayDTO> plazosPorDefecto() {
		List<PlazoDisplayDTO> plazos = new ArrayList<>();
		for (int i=0; i<10; i++)
			plazos.add(new PlazoDisplayDTO());
		return plazos;
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
			
			actualizaCategorias(id);
			actualizaPlazos(id);
			
			String cancelacion="No";
			int devolucion = 0;
			String fechaCanc = "";
			if(view.getRdbtnSi().isSelected()) {
				cancelacion = "Si";
				devolucion = Integer.parseInt(view.getTfPorcDev().getText());
				fechaCanc = view.getTfFechaCanc().getText();
			}
			
			model.createCompeticion(id,view.getTfNombre().getText(), view.getTfFecha().getText(), view.getTfDescripcion().getText(), 
					tipo, view.getTfPlazas().getText(), view.getTfDistancia().getText(), view.getTfIban().getText(), cancelacion, devolucion, fechaCanc);
			
			// Si se desean tiempos parciales...
			if(view.getRdbtnTpSi().isSelected()) {
				List<TiempoParcialDTO> tiemposParciales = view.asignarCarreraATiemposParciales(id);
				model.insertTiemposParciales(id, tiemposParciales);
			}
			
			view.reset();
			view.dispose();
			JOptionPane.showMessageDialog(null, "Competición creada con éxito");
		}
	}

	private void actualizaPlazos(int id) {
		List<PlazoDisplayDTO> plazos = view.devuelvePlazos();
		for (PlazoDisplayDTO cat: plazos)
			model.insertPlazo(id, cat.getDescr(), cat.getFechaIni(), cat.getfechaFin(), cat.getCuota());
	}

	private void actualizaCategorias(int id) {
		List<CategoriaDisplayDTO> categorias = view.devuelveCategorias();
		for (CategoriaDisplayDTO cat: categorias)
			model.insertCategory(id, cat.getNombre(), cat.getEdadMin(), cat.getEdadMax(), cat.getGenero());
	}

}
