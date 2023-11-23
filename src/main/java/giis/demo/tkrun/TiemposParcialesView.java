package giis.demo.tkrun;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.DropMode;

public class TiemposParcialesView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel pnPrincipal;
	private JTextField tfDistanciaTp;
	
	private CompeticionView view;

	/**
	 * Create the frame.
	 */
	public TiemposParcialesView(CompeticionView view) {
		
		this.view = view;
		
		setResizable(false);
		setTitle("Gestión De Tiempos Parciales");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		pnPrincipal = new JPanel();
		pnPrincipal.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(pnPrincipal);
		pnPrincipal.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 12, 130, 246);
		pnPrincipal.add(scrollPane);
		
		JList<TiempoParcialDTO> list = new JList<TiempoParcialDTO>();
		scrollPane.setViewportView(list);
		
		JLabel lbInfo = new JLabel("Se muestran los campos parciales.");
		lbInfo.setBounds(158, 14, 270, 15);
		pnPrincipal.add(lbInfo);
		
		JButton btnEliminar = new JButton("Eliminar Seleccionado");
		btnEliminar.setBounds(158, 233, 203, 25);
		pnPrincipal.add(btnEliminar);
		
		JLabel lbAddTp = new JLabel("Añadir un tiempo parcial:");
		lbAddTp.setBounds(158, 50, 270, 15);
		pnPrincipal.add(lbAddTp);
		
		tfDistanciaTp = new JTextField();
		//tfDistanciaTp.setDropMode(DropMode.ON);
		tfDistanciaTp.setBounds(291, 77, 114, 19);
		pnPrincipal.add(tfDistanciaTp);
		tfDistanciaTp.setColumns(10);
		
		JLabel lbDist = new JLabel("Distancia (P.K.):");
		lbDist.setBounds(158, 79, 203, 15);
		pnPrincipal.add(lbDist);
		
		JButton btnAdd = new JButton("Añadir");
		btnAdd.setBounds(158, 108, 114, 25);
		pnPrincipal.add(btnAdd);
	}
}
