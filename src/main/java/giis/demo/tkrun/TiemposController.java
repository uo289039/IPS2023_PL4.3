package giis.demo.tkrun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;
import giis.demo.util.io.FileUtil;

public class TiemposController {
	
	private TiemposModel model;
	private TiemposView view;
	private String lastSelectedKey="";
	
	public TiemposController(TiemposModel m, TiemposView v) {
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
		
		view.getBtnTablaCarreras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getClasificacion()));
		view.getTablaCarreras().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				SwingUtil.exceptionWrapper(() -> updateDetail());
			}
		});
	}
	
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		view.setNombreCarrera("San Silvestre");
		this.getClasificacion();
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}
	
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void getClasificacion() {
		
		String nombreCarrera = view.getNombreCarrera();
		model.insertarTiempos(nombreCarrera);
		insertarNombreTp(nombreCarrera);
		
		List<TiempoDisplayDto> clasificacion;
		
		if(view.isMasculinoSelected()) {
			clasificacion = model.getTiemposPorSexo(nombreCarrera, "hombre");
		} else if(view.isFemeninoSelected()) {
			clasificacion = model.getTiemposPorSexo(nombreCarrera, "mujer");
		} else {
			clasificacion = model.getTiempos(nombreCarrera);
		}
		
		TableModel tmodel=SwingUtil.getTableModelFromPojos(clasificacion, new String[] {"posicion", "nombre", "sexo", "dorsal", "tiempo", "parciales"});
		view.getTablaCarreras().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaCarreras());
		//O comentamos el getSelectedKey o guardar la posicion como un  string
		//Como se guarda la clave del ultimo elemento seleccionado, restaura la seleccion de los detalles
		this.restoreDetail();
		
	}
	

	/**
	 * Restaura la informacion del detalle de la carrera para visualizar los valores correspondientes
	 * a la ultima clave almacenada.
	 */
	public void restoreDetail() {
		this.lastSelectedKey=SwingUtil.selectAndGetSelectedKey(view.getTablaCarreras(), this.lastSelectedKey);
	}
	/**
	 * Al seleccionar un item de la tabla muestra el detalle con el valor del porcentaje de descuento
	 * de la carrera seleccinada y los valores de esta entidad
	 */
	public void updateDetail() {
		//Obtiene la clave seleccinada y la guarda para recordar la seleccion en futuras interacciones
		this.lastSelectedKey=SwingUtil.getSelectedKey(view.getTablaCarreras());
	}
	
	private void insertarNombreTp(String nombreCarrera) {
		int carreraId = Integer.parseInt(model.getId(nombreCarrera));
		CarreraEntity carrera = new CarrerasModel().getCarrera(carreraId);
		
		if(carrera.isTiemposParciales()) {
			if(carrera.getTp1() != 0) {
				view.getCbTb1().setText(carrera.getTp1() + " km");
				view.getCbTb1().setEnabled(true);
			}
			if(carrera.getTp2() != 0) {
				view.getCbTb2().setText(carrera.getTp2() + " km");
				view.getCbTb2().setEnabled(true);
			}
			if(carrera.getTp3() != 0) {
				view.getCbTb3().setText(carrera.getTp3() + " km");
				view.getCbTb3().setEnabled(true);
			}
			if(carrera.getTp4() != 0) {
				view.getCbTb4().setText(carrera.getTp4() + " km");
				view.getCbTb4().setEnabled(true);
			}
			if(carrera.getTp5() != 0) {
				view.getCbTb5().setText(carrera.getTp5() + " km");
				view.getCbTb5().setEnabled(true);
			}
		} else {
			view.getCbTb1().setEnabled(false);
			view.getCbTb2().setEnabled(false);
			view.getCbTb3().setEnabled(false);
			view.getCbTb4().setEnabled(false);
			view.getCbTb5().setEnabled(false);
		}
	}


}