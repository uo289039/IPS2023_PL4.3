package giis.demo.tkrun;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private JButton btnNewButton;

	
	public CompeticionView() {
		setTitle("Crear competición");
		setBounds(100, 100, 997, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow][grow][][grow][][][][][][][grow][][][][][][][][]"));
		contentPanel.add(getLbDatos(), "cell 0 0,growx,aligny center");
		contentPanel.add(getPnDatos1(), "cell 0 1 3 1,grow");
		contentPanel.add(getPnDatos2(), "cell 0 2 3 1,grow");
		contentPanel.add(getLbCategorias(), "cell 0 6");
		contentPanel.add(getSpCategorias(), "flowx,cell 1 8,alignx center,growy");
		contentPanel.add(getLbPlazos(), "cell 0 12");
		contentPanel.add(getSpPlazos(), "cell 0 13 3 1,grow");
		contentPanel.add(getBtnCancelar(), "flowx,cell 1 19,alignx right,aligny top");
		contentPanel.add(getBtnCrear(), "cell 2 19,growx,aligny top");
		contentPanel.add(getBtnNewButton(), "cell 1 8");
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
//	public void reset() {
////		this.getTextNombre().setText("");
////		this.getTextInicio().setText("");
////		this.getTextFin().setText("");
//		this.getTextFecha().setText("");
////		this.getTextCategoria().setText("");
//		this.getTextDescripcion().setText("");
//		this.getTextNPlazas().setText("");
//		this.getTextIBAN().setText("");
//		this.setVisible(false);
//		
//	}
//	public boolean validaCampos() {
//		if(!comprobarCampos()) {
//			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");
//			return false;
//		} else if(compruebaFecha()) {
//			
//		} else if(!compruebaPlazos()) {
//			return false;
//		} else if(!compruebaCategorias()){
//			
//		}
//		return true;
//	}
//	private boolean compruebaFecha() {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String fecha = getTextFecha().getText();
//		LocalDate fechaComp = LocalDate.parse(fecha, formatter);
//		LocalDate hoy = LocalDate.now();
//		if(!fechaComp.isAfter(hoy)) {
//			JOptionPane.showMessageDialog(null, "La fecha de la competición tiene que ser posterior a la fecha actual");
//			return false;
//		}
//		return true;
//	}
//	private boolean compruebaPlazos() {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//		String fecha = getTextFecha().getText();
//		LocalDate fechaComp = LocalDate.parse(fecha, formatter);
//		LocalDate hoy = LocalDate.now();
//		
//		LocalDate ant = null;
//		for (Component c: getPnPlazos().getComponents()) {
//			if(c instanceof JPanel) {
//				JPanel panelSec = (JPanel) c;
//				JTextField compInicio = null, compFin = null;
//				for (Component comp : panelSec.getComponents()) {
//					if (comp instanceof JTextField) {
//						if (comp.getName().equals("tfInicio")) {
//			            	compInicio = (JTextField) comp;
//			            } else if(comp.getName().equals("tfFin")) {
//			            	compFin = (JTextField) comp;
//			            }
//					}
//		        }
//				// NO FUNCIONA
//				String inicio = compInicio.getText();
//	            LocalDate fechaInicio = LocalDate.parse(inicio, formatter);
//	            String fin = compFin.getText();
//	    		LocalDate fechaFin = LocalDate.parse(fin, formatter);
//	    		if(ant != null) {
//	    			if(!fechaInicio.isAfter(ant)) {
//		    			JOptionPane.showMessageDialog(null, "La fecha de inicio tiene que ser posterior a la fecha de fin del anterior plazo");
//		    			return false;
//		    		} else if (fechaInicio.isAfter(ant.plusDays(1))) {
//		    			JOptionPane.showMessageDialog(null, "No puede haber separación entre los plazos de inscripción");
//		    			return false;
//		    		}
//	    		}
//	            if(!fechaInicio.isAfter(hoy)) {
//	    			JOptionPane.showMessageDialog(null, "La fecha de inicio tiene que ser posterior a la fecha actual");
//	    			return false;
//	    		} else if(!fechaFin.isAfter(fechaInicio)) {
//	    			JOptionPane.showMessageDialog(null, "La fecha de fin tiene que ser posterior a la de inicio");
//	    			return false;
//	    		}
//	            ant = fechaFin;
//			}
//		}
//		if(!fechaComp.isAfter(ant)) {
//			JOptionPane.showMessageDialog(null, "La fecha de competición tiene que ser posterior a la fecha de fin del último plazo");
//			return false;
//		}
//		return true;
//	}
//	private boolean compruebaCategorias() {
//		int ant = 0;
//		int min = 0;
//		for (Component c: getPnCategorias().getComponents()) {
//			if(c instanceof JPanel) {
//				JPanel panelSec = (JPanel) c;
//				
//				for (Component comp : panelSec.getComponents()) {
//		            if (comp instanceof JTextField) {
//		            	JTextField compTexto = (JTextField) comp;
//
//		                if (compTexto.getName().equals("tfMin")) {
//		                	min = Integer.parseInt(compTexto.getText());
//		                    if (min <= ant) {
//		                    	JOptionPane.showMessageDialog(null, "La edad mínima tiene que ser mayor que la máxima de la anterior categoría");
//		            			return false;
//		                    }
//		                } else if(compTexto.getName().equals("tfMax")) {
//		                	if (Integer.parseInt(compTexto.getText()) <= ant) {
//		                    	JOptionPane.showMessageDialog(null, "La edad mínima tiene que ser mayor que la máxima de la anterior categoría");
//		            			return false;
//		                    }
//		                }
//		            }
//		        }
//			}
//		}
//		return true;
//	}
//	private boolean comprobarCampos() {
//		if(!compruebaPanel(getPnPlazos())) {
//			return false;
//		} else if(!compruebaPanel(getPnCategorias())) {
//			return false;
//		} else if(this.getTextDescripcion().getText().isBlank()) {
//			return false;
//		} else if(this.getTextFecha().getText().isBlank()) {
//			return false;
//		} else if(this.getTextIBAN().getText().isBlank()) {
//			return false;
//		} else if(this.getTextNombre().getText().isBlank()) {
//			return false;
//		} else if(this.getTextNPlazas().getText().isBlank()) {
//			return false;
//		} else if(this.getTextDistancia().getText().isBlank()) {
//			return false;
//		}
//		return true;
//	}
	private boolean compruebaPanel(JPanel panelComp) {
		for (Component c: panelComp.getComponents()) {
			if(c instanceof JPanel) {
				JPanel panelSec = (JPanel) c;
				
				for (Component comp : panelSec.getComponents()) {
		            if (comp instanceof JTextField) {
		            	JTextField compTexto = (JTextField) comp;

		                if (compTexto.getText().isBlank()) {
		                    return false;
		                }
		            }
		        }
			}
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
	private JTextField getTfNombre() {
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
	private JTextField getTfFecha() {
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
	private JTextField getTfDescripcion() {
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
	private JRadioButton getRdbtnRuta() {
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
			lbCategorias = new JLabel("Categorías: (Por defecto editables)");
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
			lbPlazos = new JLabel("Plazos:");
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
			pnDatos2.add(getLblNewLabel_4_1());
			pnDatos2.add(getTextField_3_1());
			pnDatos2.add(getLblNewLabel_5_1());
			pnDatos2.add(getTextField_4_1());
			pnDatos2.add(getLblNewLabel_6_1());
			pnDatos2.add(getTextField_5_1());
		}
		return pnDatos2;
	}
	private JLabel getLblNewLabel_4_1() {
		if (lbPlazas == null) {
			lbPlazas = new JLabel("Nº Plazas");
		}
		return lbPlazas;
	}
	private JTextField getTextField_3_1() {
		if (tfPlazas == null) {
			tfPlazas = new JTextField();
			tfPlazas.setColumns(10);
		}
		return tfPlazas;
	}
	private JLabel getLblNewLabel_5_1() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Distancia");
		}
		return lblDistancia;
	}
	private JTextField getTextField_4_1() {
		if (tfDistancia == null) {
			tfDistancia = new JTextField();
			tfDistancia.setColumns(10);
		}
		return tfDistancia;
	}
	private JLabel getLblNewLabel_6_1() {
		if (lbIban == null) {
			lbIban = new JLabel("IBAN");
		}
		return lbIban;
	}
	private JTextField getTextField_5_1() {
		if (tfIban == null) {
			tfIban = new JTextField();
			tfIban.setColumns(10);
		}
		return tfIban;
	}
	private JButton getBtnNewButton() {
		if (btnNewButton == null) {
			btnNewButton = new JButton("New button");
		}
		return btnNewButton;
	}
}
