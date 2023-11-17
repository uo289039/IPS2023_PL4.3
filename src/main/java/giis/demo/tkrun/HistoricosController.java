package giis.demo.tkrun;

//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.table.TableModel;
import giis.demo.util.SwingUtil;

public class HistoricosController {
	
	private HistoricosModel model;
	private HistoricosView view;
	private String lastSelectedKey="";
	
	public HistoricosController(HistoricosModel m, HistoricosView v) {
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
		
		view.getBtnTablaCarreras().addActionListener(e -> SwingUtil.exceptionWrapper(() -> getHistorico()));
//		view.getTablaCarreras().addMouseListener(new MouseAdapter() {
//			@Override
//			public void mouseReleased(MouseEvent e) {
//				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
//				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
//				SwingUtil.exceptionWrapper(() -> updateDetail());
//			}
//		});
	}
	
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		view.setNombreCarrera("");
		cargaView();
		this.getHistorico();
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		view.getFrame().setVisible(true); 
	}
	
	private void cargaView() {
		List<String> tipos=model.getTipos();
		String[] tipado=tipos.toArray(new String[tipos.size()+1]);
		tipado[tipos.size()]="Todas";
		view.fijaModeloTipo(tipado);
		
	}
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void getHistorico() {
		
		String correo = view.getNombreCarrera();
		if(!correo.equals(""))
			model.insertarHistorial(correo);
		
		List<HistoricoDisplayDTO> clasificacion;
		
		if(view.isTipoSelected()) {
			clasificacion = model.getTiemposPorTipo(correo, (String)view.getComboTipo().getSelectedItem());
		} else if(view.isDistanciaSelected()) {
			double distancia=model.getDistancia(correo);
			String nombreDist=(String)view.getComboDistancia().getSelectedItem();
			clasificacion = model.getTiemposPorDistancia(correo,distancia,nombreDist);
		} else {
			clasificacion = model.getTiempos(correo);
		}
		
		TableModel tmodel=SwingUtil.getTableModelFromPojos(clasificacion, new String[] {"nombre_c","dorsal", "fecha", "posicion", "tiempo","categoria"});
		view.getTablaCarreras().setModel(tmodel);
		SwingUtil.autoAdjustColumns(view.getTablaCarreras());
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


}
