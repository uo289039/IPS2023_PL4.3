package giis.demo.tkrun;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import giis.demo.util.SwingUtil;

import javax.swing.JDialog;
import java.awt.Font;
import javax.swing.JSeparator;

public class VentanaRegistro extends JDialog {

	private static final long serialVersionUID = 1L;
	private JPanel pnTransferencia;
	private JButton btBorrar;
	private JButton btPagar;
	private JLabel lbNombre;
	private JLabel lbDNI;
	private JLabel lbIban;
	private JTextField tfNombre;
	private JTextField tfDNI;
	private JTextField tfIban;
	private JLabel lbPrecioBase;
	private JLabel lbGastosGestion;
	private JLabel lbTotal;
	private JLabel lbInfoGastos;
	private JTextField tfPrecioBase;
	private JTextField tfGastosGestion;
	private JTextField tfTotal;
	private JLabel lbImporte;
	private ParticipaView pv;
	private ParticipaModel pm;

	public VentanaRegistro(ParticipaView pv) {
		this.pv = pv;
		this.pm = new ParticipaModel();
		setTitle("Datos de transferencia bancaria");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 600, 372);
		setLocationRelativeTo(null);
		pnTransferencia = new JPanel();
		pnTransferencia.setBackground(new Color(255, 255, 255));

		setContentPane(pnTransferencia);
		pnTransferencia.setLayout(null);
		pnTransferencia.add(getBtBorrar());
		pnTransferencia.add(getBtPagar());
		pnTransferencia.add(getLbNombre());
		pnTransferencia.add(getLbDNI());
		pnTransferencia.add(getLbIban());
		pnTransferencia.add(getTfNombre());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 297, 228, 2);
		pnTransferencia.add(separator);
		pnTransferencia.add(getTfPrecioBase());
		pnTransferencia.add(getTfGastosGestion());
		pnTransferencia.add(getTfTotal());
		pnTransferencia.add(getLbImporte());
		pnTransferencia.add(getTfDNI());
		pnTransferencia.add(getTfIban());
		pnTransferencia.add(getLbInfoGastos());
		pnTransferencia.add(getLbPrecioBase());
		pnTransferencia.add(getLbGastosGestion());
		pnTransferencia.add(getLbTotal());
	}
	
	public JButton getBtBorrar() {
		if (btBorrar == null) {
			btBorrar = new JButton("Borrar datos");
			btBorrar.setBounds(358, 303, 117, 23);
			btBorrar.setMnemonic('C');
			btBorrar.setForeground(new Color(255, 255, 255));
			btBorrar.setBackground(new Color(255, 0, 0));
//			btBorrar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				getTfNombre().setText("");
//				getTfIban().setText("");
//				getTfBanco().setText("");
//				getTfSucursal().setText("");
//			}
//			});
		}
		return btBorrar;
	}
	
	public void reiniciar() {
		getTfNombre().setText("");
		getTfDNI().setText("");
		getTfIban().setText("");
	}
	
	private boolean comprobarCampos() {
		if(this.getTfNombre().getText().isBlank()) {
			return false;
		} else if(this.getTfDNI().getText().isBlank()) {
			return false;
		} else if(this.getTfIban().getText().isBlank()) {
			return false;
		}
		return true;
	}
	
	public boolean validateFormulario() {
		if(!comprobarCampos()) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");

			return false;

		} else {
			saveData();
			dispose();

		}
		return true;
	}

	public JButton getBtPagar() {
		if (btPagar == null) {
			btPagar = new JButton("Pagar");
			btPagar.setBounds(485, 303, 89, 23);
			btPagar.setMnemonic('S');
//			btPagar.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				validateFormulario();
//				saveData();
//				JOptionPane.showMessageDialog(null, "Datos guardados");
//				dispose();
//			}
//			});
			btPagar.setForeground(new Color(255, 255, 255));
			btPagar.setBackground(new Color(0, 128, 0));
		}
		return btPagar;
	}
	
	public void saveData() {
		String nombre = getTfNombre().getText();
		String correo = pv.getTextFieldCorreo().getText();
		String dni = getTfDNI().getText();
		String iban = getTfIban().getText();
		double importe = Double.parseDouble(getTfTotal().getText());
		String id_c = SwingUtil.getSelectedKey(pv.getTable());;
		pm.insertaTrans(nombre, correo, dni, iban, importe, id_c);
	}
	
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y Apellidos del titular de la cuenta");
			lbNombre.setBounds(20, 22, 273, 14);
			lbNombre.setForeground(new Color(128, 128, 128));
		}
		return lbNombre;
	}
	
	private JLabel getLbDNI() {
		if (lbDNI == null) {
			lbDNI = new JLabel("DNI del titular de la cuenta");
			lbDNI.setBounds(20, 78, 228, 14);
			lbDNI.setForeground(new Color(128, 128, 128));
		}
		return lbDNI;
	}
	
	private JLabel getLbIban() {
		if (lbIban == null) {
			lbIban = new JLabel("Número de IBAN competición");
			lbIban.setBounds(20, 133, 169, 14);
			lbIban.setForeground(new Color(128, 128, 128));
		}
		return lbIban;
	}
	
	protected JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setBounds(20, 47, 386, 20);
			tfNombre.setToolTipText("Introduzca aqu\u00ED su nombre y apellido");
			tfNombre.setBackground(new Color(255, 255, 255));
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}
	private JLabel getLbPrecioBase() {
		if (lbPrecioBase == null) {
			lbPrecioBase = new JLabel("Precio base de la carrera");
			lbPrecioBase.setForeground(Color.GRAY);
			lbPrecioBase.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbPrecioBase.setBounds(20, 241, 150, 23);
		}
		return lbPrecioBase;
	}
	private JLabel getLbGastosGestion() {
		if (lbGastosGestion == null) {
			lbGastosGestion = new JLabel("Gastos de gesti\u00F3n");
			lbGastosGestion.setForeground(Color.GRAY);
			lbGastosGestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbGastosGestion.setBounds(20, 263, 150, 23);
		}
		return lbGastosGestion;
	}
	private JLabel getLbTotal() {
		if (lbTotal == null) {
			lbTotal = new JLabel("TOTAL");
			lbTotal.setForeground(Color.BLACK);
			lbTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbTotal.setBounds(125, 302, 45, 23);
		}
		return lbTotal;
	}
	private JTextField getTfPrecioBase() {
		if (tfPrecioBase == null) {
			tfPrecioBase = new JTextField();
			tfPrecioBase.setEditable(false);
			tfPrecioBase.setToolTipText("");
			tfPrecioBase.setColumns(10);
			tfPrecioBase.setBackground(Color.WHITE);
			tfPrecioBase.setBounds(180, 243, 68, 20);
			String id=SwingUtil.getSelectedKey(pv.getTable());
//			tfPrecioBase.setText(Double.toString(pm.getCuotaCompeticion(id).getCuota()));
		}
		return tfPrecioBase;
	}
	private JTextField getTfGastosGestion() {
		if (tfGastosGestion == null) {
			tfGastosGestion = new JTextField();
			tfGastosGestion.setEditable(false);
			tfGastosGestion.setToolTipText("");
			tfGastosGestion.setColumns(10);
			tfGastosGestion.setBackground(Color.WHITE);
			tfGastosGestion.setBounds(180, 266, 68, 20);
			tfGastosGestion.setText("5%");
		}
		return tfGastosGestion;
	}
	private JTextField getTfTotal() {
		if (tfTotal == null) {
			tfTotal = new JTextField();
			tfTotal.setEditable(false);
			tfTotal.setToolTipText("");
			tfTotal.setColumns(10);
			tfTotal.setBackground(Color.WHITE);
			tfTotal.setBounds(180, 304, 68, 20);
			double a = Double.parseDouble(getTfPrecioBase().getText()) + Double.parseDouble(getTfPrecioBase().getText())*0.05;
			tfTotal.setText(String.valueOf(a));
		}
		return tfTotal;
	}
	private JLabel getLbImporte() {
		if (lbImporte == null) {
			lbImporte = new JLabel("Importe a pagar:");
			lbImporte.setForeground(Color.GRAY);
			lbImporte.setBounds(20, 216, 193, 14);
		}
		return lbImporte;
	}
	private JTextField getTfDNI() {
		if (tfDNI == null) {
			tfDNI = new JTextField();
			tfDNI.setToolTipText("Introduzca aquí el DNI de su cuenta bancaria");
			tfDNI.setColumns(10);
			tfDNI.setBackground(Color.WHITE);
			tfDNI.setBounds(20, 103, 386, 20);
		}
		return tfDNI;
	}
	private JTextField getTfIban() {
		if (tfIban == null) {
			tfIban = new JTextField();
			tfIban.setEditable(false);
			tfIban.setToolTipText("");
			tfIban.setColumns(10);
			tfIban.setBackground(Color.WHITE);
			tfIban.setBounds(20, 158, 386, 20);
			String id=SwingUtil.getSelectedKey(pv.getTable());
//			tfIban.setText(pm.getIbanCompeticion(id).getIban_c());
		}
		return tfIban;
	}

	private JLabel getLbInfoGastos() {
		if (lbInfoGastos == null) {
			lbInfoGastos = new JLabel("Al importe se le a\u00F1adir\u00E1 un porcentaje en concepto de gastos de gesti\u00F3n");
			lbInfoGastos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbInfoGastos.setForeground(Color.GRAY);
			lbInfoGastos.setBounds(20, 189, 422, 23);
		}
		return lbInfoGastos;
	}
}
