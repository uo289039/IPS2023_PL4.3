package giis.demo.tkrun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.TableModel;

//import javax.swing.ComboBoxModel;
//import javax.swing.table.DefaultTableModel;


import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
//import giis.demo.util.Util;

/**
 * Controlador para la funcionalidad de visualizacion de carreras para la inscripcion.
 * Es el punto de entrada de esta pantalla que se invocará:
 * -instanciando el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class ComparasController {
	private ComparaModel model;
	private ComparasView view;
	private String lastSelectedKey=""; //recuerda la ultima fila seleccionada para restaurarla cuando cambie la tabla de carreras

	public ComparasController(ComparaModel m, ComparasView v) {
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
		//view.getBtnTablaCarreras().addActionListener(e -> getListaCarreras());
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		//view.getBtnTablaAtletas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaAtletas()));
		
		view.getBtnVerAtletas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getListaAtletas()));
		
		view.getBtnAñadir().addActionListener(e -> SwingUtil.exceptionWrapper(() -> cargaTablaComparaAtletas()));
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		view.getBtnTablaAtletas().addActionListener(e -> SwingUtil.exceptionWrapper(() -> borraAtletas()));
		
		view.getTablaAtletas().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
	}
	
	
	private void borraAtletas() {
		// TODO Auto-generated method stub
		int fila=view.getTablaAtletas().getSelectedRow();
		view.borraFila(fila);
	}
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		
//		this.getListaAtletas();
		
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
		
	}
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void getListaAtletas() {
		String carrera=view.getTextCompeticion().getText();
		String correo=view.getTextAtleta();
		if(model.compruebaNombreCarrera(carrera) && model.compruebaCorreo(correo)) {
			List<AtletaDisplayDTO> atletas=model.getListaComparaAtletas(carrera,correo);
			view.setModeloLista(atletas);
			view.getBtnAñadir().setEnabled(true);
		}
		else if(model.compruebaCorreo(correo)){
			view.carreraNoExiste(carrera);
		}
		else
			view.avisaCorreo();
		//Como se guarda la clave del ultimo elemento seleccionado, restaura la seleccion de los detalles
		this.restoreDetail();

		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
//		List<Object[]> carrerasList=model.getListaAtletasArray((view.getId()));
//		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(carrerasList);
//		view.getListaAtletas().setModel(lmodel);
	}
	

	/**
	 * Restaura la informacion del detalle de la carrera para visualizar los valores correspondientes
	 * a la ultima clave almacenada.
	 */
	public void restoreDetail() {
		//Utiliza la ultimo valor de la clave (que se reiniciara si ya no existe en la tabla)
		this.lastSelectedKey=SwingUtil.selectAndGetSelectedKey(view.getTablaAtletas(), this.lastSelectedKey);
		//Si hay clave para seleccionar en la tabla muestra el detalle, si no, lo reinicia
//		if ("".equals(this.lastSelectedKey)) { 
//			view.setDescuentoNoAplicable();
//			view.getDetalleCarrera().setModel(new DefaultTableModel());		
//		} else {
//			this.updateDetail();
		//}
	}
	
	
	private void cargaTablaComparaAtletas() {
		// TODO Auto-generated method stub
		if(view.getListaCompetidores().getSelectedValuesList().size()==0) {
			view.avisaSelecciona();
		}
		else {
			
			List<String> competidores=view.getListaCompetidores().getSelectedValuesList();
			String nombre=model.getNombreUsuario(view.getTextAtleta());
			competidores.add(0, nombre);
			String competicion=view.getTextCompeticion().getText();
			
			List<ComparaDisplayDTO>tiempos=model.getTiempos(competicion,competidores);
			TableModel mCompara=SwingUtil.getTableModelFromPojos(tiempos,new String[] {"correoE","tiempo", "puesto", "parciales","ritmo","distancia","completado"});
			view.getTablaAtletas().setModel(mCompara);
			SwingUtil.autoAdjustColumns(view.getTablaAtletas());
			view.getBtnTablaAtletas().setEnabled(true);
		}
		
		
	}
	
	
	
	
	

	
	/**
	 * Al seleccionar un item de la tabla muestra el detalle con el valor del porcentaje de descuento
	 * de la carrera seleccinada y los valores de esta entidad
	 */
	public void updateDetail() {
		//Obtiene la clave seleccinada y la guarda para recordar la seleccion en futuras interacciones
		this.lastSelectedKey=SwingUtil.getSelectedKey(view.getTablaAtletas());
//		int idCarrera=Integer.parseInt(this.lastSelectedKey);
		
		//Detalle de descuento/recargo:
		//Controla excepcion porque el modelo causa excepcion cuando no se puede calcular el descuento
		//y debe indicarse esto en la vista para evitar mostrar datos falsos que se veian antes
		try { 
			//int descuento=model.getDescuentoRecargo(idCarrera, Util.isoStringToDate(view.getFechaHoy()));
			//view.setDescuento(String.valueOf(descuento));
		} catch (ApplicationException e) {
//			view.setDescuentoNoAplicable();
		}
		
		//Detalles de la carrera seleccionada
//		CarreraEntity carrera=model.getAtletas(idCarrera);
//		TableModel tmodel=SwingUtil.getRecordModelFromPojo(carrera, new String[] {"id", "inicio", "fin", "fecha", "descr"});
//		view.getDetalleCarrera().setModel(tmodel);
//		SwingUtil.autoAdjustColumns(view.getDetalleCarrera());
	}

}
