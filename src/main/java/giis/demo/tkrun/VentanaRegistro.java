package giis.demo.tkrun;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private JLabel lbIban;
	private JLabel lbSucursal;
	private JLabel lbBanco;
	private JTextField tfNombre;
	private JTextField tfIban;
	private JTextField tfBanco;
	private JTextField tfSucursal;
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
		setBounds(100, 100, 600, 423);
		setLocationRelativeTo(null);
		pnTransferencia = new JPanel();
		pnTransferencia.setBackground(new Color(255, 255, 255));

		setContentPane(pnTransferencia);
		pnTransferencia.setLayout(null);
		pnTransferencia.add(getBtBorrar());
		pnTransferencia.add(getBtPagar());
		pnTransferencia.add(getLbNombre());
		pnTransferencia.add(getLbIban());
		pnTransferencia.add(getLbSucursal());
		pnTransferencia.add(getLbBanco());
		pnTransferencia.add(getTfNombre());
		
		JSeparator separator = new JSeparator();
		separator.setBounds(20, 346, 228, 2);
		pnTransferencia.add(separator);
		pnTransferencia.add(getTfPrecioBase());
		pnTransferencia.add(getTfGastosGestion());
		pnTransferencia.add(getTfTotal());
		pnTransferencia.add(getLbImporte());
		pnTransferencia.add(getTfIban());
		pnTransferencia.add(getTfBanco());
		pnTransferencia.add(getTfSucursal());
		pnTransferencia.add(getLbInfoGastos());
		pnTransferencia.add(getLbPrecioBase());
		pnTransferencia.add(getLbGastosGestion());
		pnTransferencia.add(getLbTotal());
	}
	
	public JButton getBtBorrar() {
		if (btBorrar == null) {
			btBorrar = new JButton("Borrar datos");
			btBorrar.setBounds(358, 352, 117, 23);
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
		getTfIban().setText("");
		getTfBanco().setText("");
		getTfSucursal().setText("");
	}
	
	private boolean comprobarCampos() {
		if(this.getTfNombre().getText().isBlank()) {
			return false;
		} else if(this.getTfIban().getText().isBlank()) {
			return false;
		} else if(this.getTfBanco().getText().isBlank()) {
			return false;
		} else if(this.getTfSucursal().getText().isBlank()) {
			return false;
		}
		return true;
	}
	
	public void validateFormulario() {
		if(!comprobarCampos()) {
			JOptionPane.showMessageDialog(null, "Tienes que rellenar todos los campos para continuar");
		}
	}

	public JButton getBtPagar() {
		if (btPagar == null) {
			btPagar = new JButton("Pagar");
			btPagar.setBounds(485, 352, 89, 23);
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
		String iban = getTfIban().getText();
		String banco = getTfBanco().getText();
		String sucursal = getTfSucursal().getText();
		double importe = Double.parseDouble(getTfTotal().getText());
		pm.insertaTrans(nombre, correo, iban, banco, sucursal, importe);
	}
	
	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre y Apellidos del titular de la cuenta");
			lbNombre.setBounds(20, 22, 273, 14);
			lbNombre.setForeground(new Color(128, 128, 128));
		}
		return lbNombre;
	}
	
	private JLabel getLbIban() {
		if (lbIban == null) {
			lbIban = new JLabel("N\u00FAmero de IBAN");
			lbIban.setBounds(20, 78, 133, 14);
			lbIban.setForeground(new Color(128, 128, 128));
		}
		return lbIban;
	}
	
	private JLabel getLbSucursal() {
		if (lbSucursal == null) {
			lbSucursal = new JLabel("Direcci\u00F3n de la sucursal");
			lbSucursal.setBounds(20, 189, 193, 14);
			lbSucursal.setForeground(new Color(128, 128, 128));
		}
		return lbSucursal;
	}
	
	private JLabel getLbBanco() {
		if (lbBanco == null) {
			lbBanco = new JLabel("Nombre del banco");
			lbBanco.setBounds(20, 133, 169, 14);
			lbBanco.setForeground(new Color(128, 128, 128));
		}
		return lbBanco;
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
			lbPrecioBase.setBounds(20, 290, 150, 23);
		}
		return lbPrecioBase;
	}
	private JLabel getLbGastosGestion() {
		if (lbGastosGestion == null) {
			lbGastosGestion = new JLabel("Gastos de gesti\u00F3n");
			lbGastosGestion.setForeground(Color.GRAY);
			lbGastosGestion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbGastosGestion.setBounds(20, 312, 150, 23);
		}
		return lbGastosGestion;
	}
	private JLabel getLbTotal() {
		if (lbTotal == null) {
			lbTotal = new JLabel("TOTAL");
			lbTotal.setForeground(Color.BLACK);
			lbTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
			lbTotal.setBounds(125, 351, 45, 23);
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
			tfPrecioBase.setBounds(180, 292, 68, 20);
			String id=SwingUtil.getSelectedKey(pv.getTable());;
			tfPrecioBase.setText(Double.toString(pm.getCuotaCompeticion(id).getCuota()));
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
			tfGastosGestion.setBounds(180, 315, 68, 20);
			tfGastosGestion.setText(String.valueOf(Double.parseDouble(getTfPrecioBase().getText())*0.05));
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
			tfTotal.setBounds(180, 353, 68, 20);
			double a = Double.parseDouble(getTfPrecioBase().getText()) + Double.parseDouble(getTfGastosGestion().getText());
			tfTotal.setText(String.valueOf(a));
		}
		return tfTotal;
	}
	private JLabel getLbImporte() {
		if (lbImporte == null) {
			lbImporte = new JLabel("Importe a pagar:");
			lbImporte.setForeground(Color.GRAY);
			lbImporte.setBounds(20, 265, 193, 14);
		}
		return lbImporte;
	}
	private JTextField getTfIban() {
		if (tfIban == null) {
			tfIban = new JTextField();
			tfIban.setToolTipText("Introduzca aqu\u00ED el IBAN de su cuenta bancaria");
			tfIban.setColumns(10);
			tfIban.setBackground(Color.WHITE);
			tfIban.setBounds(20, 103, 386, 20);
		}
		return tfIban;
	}
	private JTextField getTfBanco() {
		if (tfBanco == null) {
			tfBanco = new JTextField();
			tfBanco.setToolTipText("Introduzca aqu\u00ED el nombre de su banco");
			tfBanco.setColumns(10);
			tfBanco.setBackground(Color.WHITE);
			tfBanco.setBounds(20, 158, 386, 20);
		}
		return tfBanco;
	}
	private JTextField getTfSucursal() {
		if (tfSucursal == null) {			
			tfSucursal = new JTextField();
			tfSucursal.setToolTipText("Introduzca aqu\u00ED la direcci\u00F3n de la sucursal de tu banco");
			tfSucursal.setColumns(10);
			tfSucursal.setBackground(Color.WHITE);
			tfSucursal.setBounds(20, 207, 386, 20);
		}
		return tfSucursal;
	}

	private JLabel getLbInfoGastos() {
		if (lbInfoGastos == null) {
			lbInfoGastos = new JLabel("Al importe se le a\u00F1adir\u00E1 un porcentaje en concepto de gastos de gesti\u00F3n");
			lbInfoGastos.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lbInfoGastos.setForeground(Color.GRAY);
			lbInfoGastos.setBounds(20, 238, 422, 23);
		}
		return lbInfoGastos;
	}
}
