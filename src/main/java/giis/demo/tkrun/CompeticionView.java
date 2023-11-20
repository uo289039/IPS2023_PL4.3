package giis.demo.tkrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import net.miginfocom.swing.MigLayout;
import java.awt.FlowLayout;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class CompeticionView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lbDatos;
	private JButton btnCrear;
	private JButton btnCancelar;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JPanel pnDatos1;
	private JLabel lbNombre;
	private JTextField tfNombre;
	private JLabel lbFecha;
	private JTextField tfFecha;
	private JLabel lbDescripcion;
	private JTextField tfDescripcion;
	private JLabel lbTipo;
	private JPanel pnTipo;
	private JRadioButton rdbtnMontaña;
	private JRadioButton rdbtnRuta;
	private JLabel lbCategorias;
	private JScrollPane spCategorias;
	private JTable tbCategorias;
	private JLabel lbPlazos;
	private JScrollPane spPlazos;
	private JTable tbPlazos;
	private JPanel pnDatos2;
	private JLabel lbPlazas;
	private JTextField tfPlazas;
	private JLabel lblDistancia;
	private JTextField tfDistancia;
	private JLabel lbIban;
	private JTextField tfIban;
	private JLabel lbExpPlazos;
	private JLabel lbExpPlazos2;

	
	public CompeticionView() {
		setTitle("Crear competición");
		setBounds(100, 100, 997, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow][grow][][grow][][][][][][][][][][grow][][][][][][][][][][]"));
		contentPanel.add(getLbDatos(), "cell 0 0,growx,aligny center");
		contentPanel.add(getPnDatos1(), "cell 0 1 3 1,grow");
		contentPanel.add(getPnDatos2(), "cell 0 2 3 1,grow");
		contentPanel.add(getLbCategorias(), "cell 0 6");
		contentPanel.add(getSpCategorias(), "flowx,cell 1 8,alignx center,growy");
		contentPanel.add(getLbPlazos(), "cell 0 11");
		contentPanel.add(getLbExpPlazos(), "cell 0 12");
		contentPanel.add(getLbExpPlazos2(), "cell 0 13");
		contentPanel.add(getSpPlazos(), "cell 1 18,alignx center,growy");
		contentPanel.add(getBtnCancelar(), "flowx,cell 1 24,alignx right,aligny top");
		contentPanel.add(getBtnCrear(), "cell 2 24,growx,aligny top");
	}
	private JLabel getLbDatos() {
		if (lbDatos == null) {
			lbDatos = new JLabel("Datos Competición:");
			lbDatos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbDatos.setBackground(Color.WHITE);
		}
		return lbDatos;
	}
	public JButton getBtnCrear() {
		if (btnCrear == null) {
			btnCrear = new JButton("Crear");
		}
		return btnCrear;
	}
	public JButton getBtnCancelar() {
		if (btnCancelar == null) {
			btnCancelar = new JButton("Cancelar");
		}
		return btnCancelar;
	}
	public void reset() {
		this.getTfNombre().setText("");
		this.getTfFecha().setText("");
		this.getTfDescripcion().setText("");
		this.getTfPlazas().setText("");
		this.getTfDistancia().setText("");
		this.getTfIban().setText("");
		this.setVisible(false);
		
	}
	public boolean validaCampos() {
		if(!comprobarCampos()) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");
			return false;
		} else if (!compruebaPlazos()) {
			return false;
		}
		return true;
	}
	private boolean compruebaPlazos() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date fecha = dateFormat.parse(getTfFecha().getText());
		    Date hoy = new Date();
		    if (fecha.compareTo(hoy) < 0) {
		    	JOptionPane.showMessageDialog(null, "La fecha " + getTfFecha().getText() + " es anterior a la fecha actual.");
		    	return false;
		    }
			
			List<PlazoDisplayDTO> plazos = devuelvePlazos();
			boolean primero = true;
			PlazoDisplayDTO p = null;
			for (PlazoDisplayDTO pl: plazos) {
				Date fIni = dateFormat.parse(pl.getFechaIni());
				Date fFin = dateFormat.parse(pl.getfechaFin());
				
				if(fIni.compareTo(hoy) < 0) {
					JOptionPane.showMessageDialog(null, "La fecha " + pl.getFechaIni() + " es anterior a la fecha actual");
					return false;
				}
				
				if(!(fIni.compareTo(fFin) < 0)) {
					JOptionPane.showMessageDialog(null, "La fecha " + pl.getFechaIni() + " no es anterior a la fecha " + pl.getfechaFin());
					return false;
				}
				
				if (!primero) {
					Date fFinAnt = dateFormat.parse(p.getfechaFin());
					if(!(fFin.compareTo(fFinAnt) == 0)) {
						JOptionPane.showMessageDialog(null, "La fecha " + pl.getfechaFin() + " no es igual a la fecha " + p.getfechaFin());
						return false;
					}
				}
				primero = false;
				p = pl;
			}
			Date fFinAnt = dateFormat.parse(p.getfechaFin());
			if(!(fecha.compareTo(fFinAnt) == 0)) {
				JOptionPane.showMessageDialog(null, "La fecha " + getTfFecha().getText() + " no es igual a la fecha " + p.getfechaFin());
				return false;
			}
			return true;
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, "Alguna fecha no tiene formato correcto");
			return false;
		}
	}
	public List<CategoriaDisplayDTO> devuelveCategorias() {
		List<CategoriaDisplayDTO> categorias = new ArrayList<>();
		for (int i = 0; i < getTbCategorias().getRowCount(); i++) {
			CategoriaDisplayDTO cat = new CategoriaDisplayDTO();
			boolean cond = true;
		    for (int j = 0; j < getTbCategorias().getColumnCount(); j++) {
		    	if (getTbPlazos().getValueAt(i, j) == null) {
		    		cond = false;
		    	} else  {
		    		String value = getTbCategorias().getValueAt(i, j).toString();
			        if (value.isEmpty() || value.equals("0")) {
			            cond = false;
			        } else {
			            if (j==0)
			            	cat.setNombre(value);
			            if (j==1)
			            	cat.setEdadMin(Integer.parseInt(value));
			            if (j==2)
			            	cat.setEdadMax(Integer.parseInt(value));
			            if (j==3)
			            	cat.setGenero(value);
			        }
		    	}
		    }
		    if(cond)
		    	categorias.add(cat);
		}
		return categorias;

	}
	private boolean comprobarCampos() {
		if(this.getTfNombre().getText().isBlank()) {
			return false;
		} else if(this.getTfFecha().getText().isBlank()) {
			return false;
		} else if(this.getTfDescripcion().getText().isBlank()) {
			return false;
		} else if(this.getTfPlazas().getText().isBlank()) {
			return false;
		} else if(this.getTfDistancia().getText().isBlank()) {
			return false;
		} else if(this.getTfIban().getText().isBlank()) {
			return false;
		}
		return true;
	}
	private JPanel getPnDatos1() {
		if (pnDatos1 == null) {
			pnDatos1 = new JPanel();
			FlowLayout fl_pnDatos1 = (FlowLayout) pnDatos1.getLayout();
			fl_pnDatos1.setHgap(15);
			pnDatos1.setBackground(Color.WHITE);
			pnDatos1.add(getLbNombre());
			pnDatos1.add(getTfNombre());
			pnDatos1.add(getLbFecha());
			pnDatos1.add(getTfFecha());
			pnDatos1.add(getLbDescripcion());
			pnDatos1.add(getTfDescripcion());
			pnDatos1.add(getLbTipo());
			pnDatos1.add(getPnTipo());
		}
		return pnDatos1;
	}
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre");
		}
		return lbNombre;
	}
	public JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}
	private JLabel getLbFecha() {
		if (lbFecha == null) {
			lbFecha = new JLabel("Fecha (YYYY-MM-DD)");
		}
		return lbFecha;
	}
	public JTextField getTfFecha() {
		if (tfFecha == null) {
			tfFecha = new JTextField();
			tfFecha.setColumns(10);
		}
		return tfFecha;
	}
	private JLabel getLbDescripcion() {
		if (lbDescripcion == null) {
			lbDescripcion = new JLabel("Descripción");
		}
		return lbDescripcion;
	}
	public JTextField getTfDescripcion() {
		if (tfDescripcion == null) {
			tfDescripcion = new JTextField();
			tfDescripcion.setColumns(10);
		}
		return tfDescripcion;
	}
	private JLabel getLbTipo() {
		if (lbTipo == null) {
			lbTipo = new JLabel("Tipo");
		}
		return lbTipo;
	}
	private JPanel getPnTipo() {
		if (pnTipo == null) {
			pnTipo = new JPanel();
			pnTipo.setBackground(Color.WHITE);
			pnTipo.add(getRdbtnMontaña());
			pnTipo.add(getRdbtnRuta());
		}
		return pnTipo;
	}
	private JRadioButton getRdbtnMontaña() {
		if (rdbtnMontaña == null) {
			rdbtnMontaña = new JRadioButton("Montaña");
			rdbtnMontaña.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMontaña);
		}
		return rdbtnMontaña;
	}
	public JRadioButton getRdbtnRuta() {
		if (rdbtnRuta == null) {
			rdbtnRuta = new JRadioButton("Ruta");
			rdbtnRuta.setSelected(true);
			rdbtnRuta.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnRuta);
		}
		return rdbtnRuta;
	}
	private JLabel getLbCategorias() {
		if (lbCategorias == null) {
			lbCategorias = new JLabel("Categorías: (Por defecto editables) (Máx 20)");
			lbCategorias.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbCategorias.setBackground(Color.WHITE);
		}
		return lbCategorias;
	}
	private JScrollPane getSpCategorias() {
		if (spCategorias == null) {
			spCategorias = new JScrollPane();
			spCategorias.setViewportView(getTbCategorias());
		}
		return spCategorias;
	}
	public JTable getTbCategorias() {
		if (tbCategorias == null) {
			tbCategorias = new JTable();
		}
		return tbCategorias;
	}
	private JLabel getLbPlazos() {
		if (lbPlazos == null) {
			lbPlazos = new JLabel("Plazos: (Máx 10, formato fechas YYYY-MM-DD)");
			lbPlazos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbPlazos.setBackground(Color.WHITE);
		}
		return lbPlazos;
	}
	private JScrollPane getSpPlazos() {
		if (spPlazos == null) {
			spPlazos = new JScrollPane();
			spPlazos.setViewportView(getTbPlazos());
		}
		return spPlazos;
	}
	public JTable getTbPlazos() {
		if (tbPlazos == null) {
			tbPlazos = new JTable();
		}
		return tbPlazos;
	}
	private JPanel getPnDatos2() {
		if (pnDatos2 == null) {
			pnDatos2 = new JPanel();
			pnDatos2.setBackground(Color.WHITE);
			pnDatos2.add(getLblPlazas());
			pnDatos2.add(getTfPlazas());
			pnDatos2.add(getLblDistancia());
			pnDatos2.add(getTfDistancia());
			pnDatos2.add(getLblIban());
			pnDatos2.add(getTfIban());
		}
		return pnDatos2;
	}
	private JLabel getLblPlazas() {
		if (lbPlazas == null) {
			lbPlazas = new JLabel("Nº Plazas");
		}
		return lbPlazas;
	}
	public JTextField getTfPlazas() {
		if (tfPlazas == null) {
			tfPlazas = new JTextField();
			tfPlazas.setColumns(10);
		}
		return tfPlazas;
	}
	private JLabel getLblDistancia() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Distancia");
		}
		return lblDistancia;
	}
	public JTextField getTfDistancia() {
		if (tfDistancia == null) {
			tfDistancia = new JTextField();
			tfDistancia.setColumns(10);
		}
		return tfDistancia;
	}
	private JLabel getLblIban() {
		if (lbIban == null) {
			lbIban = new JLabel("IBAN");
		}
		return lbIban;
	}
	public JTextField getTfIban() {
		if (tfIban == null) {
			tfIban = new JTextField();
			tfIban.setColumns(10);
		}
		return tfIban;
	}
	public List<PlazoDisplayDTO> devuelvePlazos() {
		List<PlazoDisplayDTO> plazos = new ArrayList<>();
		for (int i = 0; i < getTbPlazos().getRowCount(); i++) {
			PlazoDisplayDTO plz = new PlazoDisplayDTO();
			boolean cond = true;
		    for (int j = 0; j < getTbPlazos().getColumnCount(); j++) {
		    	if (getTbPlazos().getValueAt(i, j) == null) {
		    		cond = false;
		    	} else {
			        String value = getTbPlazos().getValueAt(i, j).toString();
			        if (value.isEmpty() || value.equals("0")) {
			            cond = false;
			        } else {
			            if (j==0)
			            	plz.setDescr(value);
			            if (j==1)
			            	plz.setFechaIni(value);
			            if (j==2)
			            	plz.setFechaFin(value);
			            if (j==3)
			            	plz.setCuota(Integer.parseInt(value));
			        }
		    	}
		    }
		    if(cond)
		    	plazos.add(plz);
		}
		return plazos;
	}
	private JLabel getLbExpPlazos() {
		if (lbExpPlazos == null) {
			lbExpPlazos = new JLabel("Ordenados de arriba a abajo de ");
			lbExpPlazos.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lbExpPlazos.setBackground(Color.WHITE);
		}
		return lbExpPlazos;
	}
	private JLabel getLbExpPlazos2() {
		if (lbExpPlazos2 == null) {
			lbExpPlazos2 = new JLabel("- a + lejano a más próximo a la competición");
		}
		return lbExpPlazos2;
	}
}
