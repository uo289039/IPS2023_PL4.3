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

public class CompeticionView extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private JLabel lblNombre;
	private JLabel lblDescripcion;
	private JLabel lblTipo;
	private JButton btnCrear;
	private JButton btnCancelar;
	private JTextField textNombre;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField textIBAN;
	private JTextField textDescripcion;
	private JLabel lblFecha;
	private JPanel panel;
	private JRadioButton rdbtnMontaña;
	private JRadioButton rdbtnRuta;
	private JLabel lblNPlazas;
	private JTextField textNPlazas;
	private JLabel lblIBAN;
	private JTextField textFecha;
	private JLabel lblDistancia;
	private JTextField textDistancia;
	private JPanel pnPlazos;
	private JButton btnAgregarPlazo;
	private JButton btnAgregarCategoria;
	private JPanel pnCategorias;

	
	public CompeticionView() {
		setTitle("Crear competición");
		setBounds(100, 100, 794, 504);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[grow][grow][grow]", "[][grow][grow][grow][][][][][][]"));
		contentPanel.add(getLblNombre(), "cell 0 0,growx,aligny center");
		contentPanel.add(getTextNombre(), "cell 1 0,growx");
		contentPanel.add(getPnPlazos(), "cell 0 1 2 1,grow");
		contentPanel.add(getBtnAgregarPlazo(), "cell 2 1");
		contentPanel.add(getLblFecha(), "cell 0 2,alignx left,aligny center");
		contentPanel.add(getTextFecha(), "cell 1 2,growx");
		contentPanel.add(getPnCategorias(), "cell 0 3 2 1,grow");
		contentPanel.add(getBtnAgregarCategoria(), "cell 2 3");
		contentPanel.add(getLblDescripcion(), "cell 0 4,growx,aligny center");
		contentPanel.add(getTextDescripcion(), "cell 1 4,growx,aligny top");
		contentPanel.add(getLblTipo(), "cell 0 5,growx,aligny center");
		contentPanel.add(getPanel(), "cell 1 5,grow");
		contentPanel.add(getLblNPlazas(), "cell 0 6,alignx left");
		contentPanel.add(getTextNPlazas(), "cell 1 6,growx");
		contentPanel.add(getLblDistancia(), "cell 0 7,alignx left");
		contentPanel.add(getTextDistancia(), "cell 1 7,growx");
		contentPanel.add(getLblIBAN(), "cell 0 8,alignx left");
		contentPanel.add(getTextIBAN(), "cell 1 8,growx,aligny top");
		contentPanel.add(getBtnCancelar(), "flowx,cell 1 9,alignx right,aligny top");
		contentPanel.add(getBtnCrear(), "cell 2 9,growx,aligny top");
	}
	private JLabel getLblNombre() {
		if (lblNombre == null) {
			lblNombre = new JLabel("Introduzca el nombre para la competición:");
			lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNombre.setBackground(Color.WHITE);
		}
		return lblNombre;
	}
	private JLabel getLblDescripcion() {
		if (lblDescripcion == null) {
			lblDescripcion = new JLabel("Introduzca la descripción de la competición:");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDescripcion.setBackground(Color.WHITE);
		}
		return lblDescripcion;
	}
	private JLabel getLblTipo() {
		if (lblTipo == null) {
			lblTipo = new JLabel("Seleccione el tipo de competición:");
			lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblTipo.setBackground(Color.WHITE);
		}
		return lblTipo;
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
	public JTextField getTextNombre() {
		if (textNombre == null) {
			textNombre = new JTextField();
			textNombre.setColumns(10);
		}
		return textNombre;
	}
	public JTextField getTextIBAN() {
		if (textIBAN == null) {
			textIBAN = new JTextField();
			textIBAN.setColumns(10);
		}
		return textIBAN;
	}
	public JTextField getTextDescripcion() {
		if (textDescripcion == null) {
			textDescripcion = new JTextField();
			textDescripcion.setColumns(10);
		}
		return textDescripcion;
	}
	public JLabel getLblFecha() {
		if (lblFecha == null) {
			lblFecha = new JLabel("Introduzca la fecha de la competición: (YYYY-MM-DD)");
			lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lblFecha;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);

			panel.add(getRdbtnMontaña());
			panel.add(getRdbtnRuta());
		}
		return panel;
	}
	public JRadioButton getRdbtnMontaña() {
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
	public void reset() {
		this.getTextNombre().setText("");
//		this.getTextInicio().setText("");
//		this.getTextFin().setText("");
		this.getTextFecha().setText("");
//		this.getTextCategoria().setText("");
		this.getTextDescripcion().setText("");
		this.getTextNPlazas().setText("");
		this.getTextIBAN().setText("");
		this.setVisible(false);
		
	}
	private JLabel getLblNPlazas() {
		if (lblNPlazas == null) {
			lblNPlazas = new JLabel("Introduzca el número de plazas:");
			lblNPlazas.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblNPlazas.setBackground(Color.WHITE);
		}
		return lblNPlazas;
	}
	public JTextField getTextNPlazas() {
		if (textNPlazas == null) {
			textNPlazas = new JTextField();
			textNPlazas.setColumns(10);
		}
		return textNPlazas;
	}
	private JLabel getLblIBAN() {
		if (lblIBAN == null) {
			lblIBAN = new JLabel("Introduzca el IBAN: ");
			lblIBAN.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblIBAN.setBackground(Color.WHITE);
		}
		return lblIBAN;
	}
	public JTextField getTextFecha() {
		if (textFecha == null) {
			textFecha = new JTextField();
			textFecha.setColumns(10);
		}
		return textFecha;
	}
	public boolean validaCampos() {
		if(!comprobarCampos()) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");
			return false;
		} else if(compruebaFecha()) {
			
		} else if(!compruebaPlazos()) {
			return false;
		} else if(!compruebaCategorias()){
			
		}
		return true;
	}
	private boolean compruebaFecha() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fecha = getTextFecha().getText();
		LocalDate fechaComp = LocalDate.parse(fecha, formatter);
		LocalDate hoy = LocalDate.now();
		if(!fechaComp.isAfter(hoy)) {
			JOptionPane.showMessageDialog(null, "La fecha de la competición tiene que ser posterior a la fecha actual");
			return false;
		}
		return true;
	}
	private boolean compruebaPlazos() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String fecha = getTextFecha().getText();
		LocalDate fechaComp = LocalDate.parse(fecha, formatter);
		LocalDate hoy = LocalDate.now();
		
		LocalDate ant = null;
		for (Component c: getPnPlazos().getComponents()) {
			if(c instanceof JPanel) {
				JPanel panelSec = (JPanel) c;
				JTextField compInicio = null, compFin = null;
				for (Component comp : panelSec.getComponents()) {
					if (comp instanceof JTextField) {
						if (comp.getName().equals("tfInicio")) {
			            	compInicio = (JTextField) comp;
			            } else if(comp.getName().equals("tfFin")) {
			            	compFin = (JTextField) comp;
			            }
					}
		        }
				// NO FUNCIONA
				String inicio = compInicio.getText();
	            LocalDate fechaInicio = LocalDate.parse(inicio, formatter);
	            String fin = compFin.getText();
	    		LocalDate fechaFin = LocalDate.parse(fin, formatter);
	    		if(ant != null) {
	    			if(!fechaInicio.isAfter(ant)) {
		    			JOptionPane.showMessageDialog(null, "La fecha de inicio tiene que ser posterior a la fecha de fin del anterior plazo");
		    			return false;
		    		} else if (fechaInicio.isAfter(ant.plusDays(1))) {
		    			JOptionPane.showMessageDialog(null, "No puede haber separación entre los plazos de inscripción");
		    			return false;
		    		}
	    		}
	            if(!fechaInicio.isAfter(hoy)) {
	    			JOptionPane.showMessageDialog(null, "La fecha de inicio tiene que ser posterior a la fecha actual");
	    			return false;
	    		} else if(!fechaFin.isAfter(fechaInicio)) {
	    			JOptionPane.showMessageDialog(null, "La fecha de fin tiene que ser posterior a la de inicio");
	    			return false;
	    		}
	            ant = fechaFin;
			}
		}
		if(!fechaComp.isAfter(ant)) {
			JOptionPane.showMessageDialog(null, "La fecha de competición tiene que ser posterior a la fecha de fin del último plazo");
			return false;
		}
		return true;
	}
	private boolean compruebaCategorias() {
		// TODO Auto-generated method stub
		return false;
	}
	private boolean comprobarCampos() {
		if(!compruebaPanel(getPnPlazos())) {
			return false;
		} else if(!compruebaPanel(getPnCategorias())) {
			return false;
		} else if(this.getTextDescripcion().getText().isBlank()) {
			return false;
		} else if(this.getTextFecha().getText().isBlank()) {
			return false;
		} else if(this.getTextIBAN().getText().isBlank()) {
			return false;
		} else if(this.getTextNombre().getText().isBlank()) {
			return false;
		} else if(this.getTextNPlazas().getText().isBlank()) {
			return false;
		} else if(this.getTextDistancia().getText().isBlank()) {
			return false;
		}
		return true;
	}
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
	private JLabel getLblDistancia() {
		if (lblDistancia == null) {
			lblDistancia = new JLabel("Introduzca la distancia de la carrera:");
			lblDistancia.setFont(new Font("Tahoma", Font.PLAIN, 12));
			lblDistancia.setBackground(Color.WHITE);
		}
		return lblDistancia;
	}
	public JTextField getTextDistancia() {
		if (textDistancia == null) {
			textDistancia = new JTextField();
			textDistancia.setColumns(10);
		}
		return textDistancia;
	}
	private JPanel getPnPlazos() {
		if (pnPlazos == null) {
			pnPlazos = new JPanel();
			pnPlazos.setBackground(Color.WHITE);
			pnPlazos.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			Dimension maxDimension = new Dimension(1400, Integer.MAX_VALUE);
			pnPlazos.setMaximumSize(maxDimension);
			pnPlazos.add(new PanelPlazoInscripcion());
//			validate();
		}
		return pnPlazos;
	}
	private JButton getBtnAgregarPlazo() {
		if (btnAgregarPlazo == null) {
			btnAgregarPlazo = new JButton("Añadir Plazo Inscripción");
			btnAgregarPlazo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getPnPlazos().add(new PanelPlazoInscripcion());
					validate();
				}
			});
		}
		return btnAgregarPlazo;
	}
	private JButton getBtnAgregarCategoria() {
		if (btnAgregarCategoria == null) {
			btnAgregarCategoria = new JButton("Añadir Categoría");
			btnAgregarCategoria.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					getPnCategorias().add(new PanelCategorias());
					validate();
				}
			});
		}
		return btnAgregarCategoria;
	}
	private JPanel getPnCategorias() {
		if (pnCategorias == null) {
			pnCategorias = new JPanel();
			pnCategorias.setBackground(Color.WHITE);
			pnCategorias.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
			Dimension maxDimension = new Dimension(1500, Integer.MAX_VALUE);
			pnCategorias.add(new PanelCategorias());
			pnCategorias.setMaximumSize(maxDimension);
		}
		return pnCategorias;
	}
}
