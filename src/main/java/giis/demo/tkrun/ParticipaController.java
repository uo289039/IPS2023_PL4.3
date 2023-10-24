package giis.demo.tkrun;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import giis.demo.util.ApplicationException;
import giis.demo.util.SwingUtil;
import giis.demo.util.Util;

/**
 * Controlador para la funcionalidad de visualizacion de carreras para la inscripcion.
 * Es el punto de entrada de esta pantalla que se invocará:
 * -instanciando el controlador con la vista y el modelo
 * -ejecutando initController que instalara los manejadores de eventos
 */
public class ParticipaController {
	private ParticipaModel model;
	private ParticipaView view;
	private VentanaRegistro vr;
	private MuestraInformacion mI=new MuestraInformacion();
	private String lastSelectedKey=""; //recuerda la ultima fila seleccionada para restaurarla cuando cambie la tabla de carreras
	//private VentanaTablaInfo vTi=new VentanaTablaInfo();

	public ParticipaController(ParticipaModel m, ParticipaView v) {
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
		view.getBtnOk().addActionListener(e -> ventanaRegistro());
		
		
		//ademas invoco el metodo que responde al listener en el exceptionWrapper para que se encargue de las excepciones
		view.getBtnCancelar().addActionListener(e -> reinicia());
		
//		validateFormulario();
//		saveData();
//		JOptionPane.showMessageDialog(null, "Datos guardados");
//		dispose();
		initView();
		//En el caso del mouse listener (para detectar seleccion de una fila) no es un interfaz funcional puesto que tiene varios metodos
		//ver discusion: https://stackoverflow.com/questions/21833537/java-8-lambda-expressions-what-about-multiple-methods-in-nested-class
		//view.getTablaCarreras().addMouseListener(new MouseAdapter() {
			//@Override
			//public void mouseReleased(MouseEvent e) {
				//no usa mouseClicked porque al establecer seleccion simple en la tabla de carreras
				//el usuario podria arrastrar el raton por varias filas e interesa solo la ultima
				//SwingUtil.exceptionWrapper(() -> updateDetail());
			//}
		//});
	}
	
	
	private void iniciaControlVR() {
		vr.getBtBorrar().addActionListener(e -> reiniciaVr());
		
		vr.getBtPagar().addActionListener(e -> validaGuarda());
	}
	
	
	private void validaGuarda() {
		// TODO Auto-generated method stub
		vr.validateFormulario();
		vr.saveData();
		saveData();
		JOptionPane.showMessageDialog(null, "Datos guardados");
		String id=SwingUtil.getSelectedKey(view.getTable());
		String correo=view.getTextFieldCorreo().getText();
		String nombre=vr.getTfNombre().getText();
		String nombre_c=model.getNombreCompeticion(id);
		double cuota=model.getCuotaCompeticion(id).getCuota();
		String categoria=model.getCategoria(id);
		String inscripcion=model.getInscripcion(correo);
		model.insertaDataAtleta(nombre,nombre_c,categoria,inscripcion,cuota,id,correo); //Modificar, añadir metodos para conseguir el nombre,nombre_c,categoria,inscripcion,cuota 
		List<DatosAtleta> info=model.datosAtletaInscrito(correo,id);
		TableModel tmodel=SwingUtil.getTableModelFromPojos(info, new String[] {"nombre","nombre_c","categoria","inscripcion","cuota"});
		mI.setVisible(true);
		mI.getTable().setModel(tmodel);
		SwingUtil.autoAdjustColumns(mI.getTable());
//		view.getTablaAtletas().setModel(tmodel);
//		SwingUtil.autoAdjustColumns(view.getTablaAtletas());
		
		vr.dispose();
	}
	private void reiniciaVr() {
		// TODO Auto-generated method stub
		vr.reiniciar();
	}
//	private void muestraInfo() {
//		JOptionPane.showMessageDialog(null, 
//				model.getInfoParticipa(view.getTextFieldCorreo().getText()));
//		this.getListaAtletas();
//		
//	}
	public void initView() {
		//Inicializa la fecha de hoy a un valor que permitira mostrar carreras en diferentes fases 
		//y actualiza los datos de la vista
		//view.setFechaHoy("2016-11-10");
		this.getListaParticipa();
		view.setVisible(true);
		this.getListaAtletas();
		//Abre la ventana (sustituye al main generado por WindowBuilder)
		//view.getFrame().setVisible(true); 
	}
	/**
	 * La obtencion de la lista de carreras solo necesita obtener la lista de objetos del modelo 
	 * y usar metodo de SwingUtil para crear un tablemodel que se asigna finalmente a la tabla.
	 */
	public void getListaParticipa() {
		//List<ParticipaDisplayDTO> carreras=model.getListaParticipa();
//		List<CarreraDisplayDTO> carrerasList=model.getNombresCompeticiones() ;
//		TableModel lmodel=SwingUtil.getTableModelFromPojos(carrerasList,new String[]{"nombre_c","id"});
		//view.getTablaCompeticiones().setModel(lmodel);
		//SwingUtil.autoAdjustColumns(view.getTablaCarreras());
//		CarreraDisplayDTO[] carrerasList=model.getNombresCompeticiones() ;
//		ComboBoxModel<CarreraDisplayDTO> cmodel=new DefaultComboBoxModel<CarreraDisplayDTO>(carrerasList);
		//view.getComboBoxCompeticiones().setModel(cmodel); //,new String[]{"nombre_c","id"}
		
		List<CarreraDisplayDTO> lCarreras=model.getListaNombresCompeticiones();
		TableModel lmodel=SwingUtil.getTableModelFromPojos(lCarreras,new String[]{"id","nombre_c"});
		view.getTable().setModel(lmodel);
		SwingUtil.autoAdjustColumns(view.getTable());
		//Como se guarda la clave del ultimo elemento seleccionado, restaura la seleccion de los detalles
		//this.restoreDetail();

		//A modo de demo, se muestra tambien la misma informacion en forma de lista en un combobox
//		List<Object[]> carrerasList=model.getListaCarrerasArray(Util.isoStringToDate(view.getFechaHoy()));
//		ComboBoxModel<Object> lmodel=SwingUtil.getComboModelFromList(carrerasList);
//		view.getComboBoxCompeticiones().setModel(lmodel);
	}
	
	public void getListaAtletas() {
		
		
//		String correo=view.getTextFieldCorreo().getText();
//		
//		List<CarreraDisplayDTO> carreras=model.getListaParticipa((correo));
//		TableModel tmodel=SwingUtil.getTableModelFromPojos(carreras, new String[] {"nombre_c", "inicio","fin"});//,"nPlazas"
//		
//		
		
		
//		view.getTablaCompeticiones().setModel(tmodel);
//		SwingUtil.autoAdjustColumns(view.getTablaCompeticiones());

		
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
        
		//Si hay clave para seleccionar en la tabla muestra el detalle, si no, lo reinicia
		if ("".equals(this.lastSelectedKey)) { 
//			view.setDescuentoNoAplicable();
//			view.getDetalleCarrera().setModel(new DefaultTableModel());		
		} else {
			this.saveData();
		}
	}
	/**
	 * Al seleccionar un item de la tabla muestra el detalle con el valor del porcentaje de descuento
	 * de la carrera seleccinada y los valores de esta entidad
	 */
	public void saveData() {
		//Obtiene la clave seleccinada y la guarda para recordar la seleccion en futuras interacciones
//		this.lastSelectedKey=SwingUtil.getSelectedKey(view.getTablaCarreras());
		//this.lastSelectedKey=(String)view.getComboBoxCompeticiones().getSelectedItem();
		//int indexCbox=view.getTable().getSelectedRow();
		//view.getComboBoxCompeticiones().setSelectedIndex(indexCbox);
		String id=SwingUtil.getSelectedKey(view.getTable());
		//String id=((CarreraDisplayDTO) view.getComboBoxCompeticiones().getSelectedItem()).getId(); //((CarreraDisplayDTO) view.getTablaCompeticiones().getSelectedRow()).getId();
		String correo=view.getTextFieldCorreo().getText();
		if(checkData(id,correo)) {
			model.insertaData(correo, id, "Preinscrito");
			//model.datosAtletaInscrito(correo,id);
			}
		
		
		//Controla excepcion porque el modelo causa excepcion cuando no se puede calcular el descuento
		//y debe indicarse esto en la vista para evitar mostrar datos falsos que se veian antes
		try { 
//			int descuento=model.getDescuentoRecargo(idCarrera, Util.isoStringToDate(view.getFechaHoy()));
//			view.setDescuento(String.valueOf(descuento));
		} catch (ApplicationException e) {
//			view.setDescuentoNoAplicable();
		}
		
		//Detalles de la carrera seleccionada
//		CarreraEntity carrera=model.getCarrera(idCarrera);
//		TableModel tmodel=SwingUtil.getRecordModelFromPojo(carrera, new String[] {"id", "inicio", "fin", "fecha", "descr"});
//		view.getDetalleCarrera().setModel(tmodel);
//		SwingUtil.autoAdjustColumns(view.getDetalleCarrera());
	}
	
	private boolean checkData(String id, String correo) {
		
		if(!model.yaInscrito(id, correo) && model.hayPlazas(id)) //&& model.isCorreoValido(correo)
			return true;
		
		else if(model.yaInscrito(id, correo)){
			JOptionPane.showMessageDialog(null, 
					"No puede reinscribirse en una competición en la que ya lo está");return false;
		}
		else if(!model.hayPlazas(id)) {
			JOptionPane.showMessageDialog(null, 
					"No puede reinscribirse en una competición en la que ya no hay plazas");return false;}
		
//		else if(!model.isCorreoValido(correo)) {
//			JOptionPane.showMessageDialog(null, 
//			"No puede inscribirse con un correo no validado por la organización, por favor introduzca uno valido");return false;}
		
		return true;
	}
	
	
	
	public void reinicia() {
		view.reiniciar();
	}
	
	private void ventanaRegistro() {
		if(view.getRdbtnTransferencia().isSelected()) {
			this.vr=new VentanaRegistro(view);
			iniciaControlVR();
			vr.setVisible(true);
		}
	}

}
