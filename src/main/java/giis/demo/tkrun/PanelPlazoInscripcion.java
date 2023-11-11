package giis.demo.tkrun;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;

public class PanelPlazoInscripcion extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField tfInicio;
	private JLabel lbInicio;
	private JLabel lbFin;
	private JTextField tfFin;
	private JLabel lbCuota;
	private JTextField tfCuota;

	/**
	 * Create the panel.
	 */
	public PanelPlazoInscripcion() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(3, 2, 0, 0));
		add(getLbInicio());
		add(getTfInicio());
		add(getLbFin());
		add(getTfFin());
		add(getLbCuota());
		add(getTfCuota());

	}

	private JTextField getTfInicio() {
		if (tfInicio == null) {
			tfInicio = new JTextField();
			tfInicio.setName("tfInicio");
			tfInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfInicio.setColumns(10);
		}
		return tfInicio;
	}
	private JLabel getLbInicio() {
		if (lbInicio == null) {
			lbInicio = new JLabel("Fecha inicio: (YYYY-MM-DD)");
			lbInicio.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbInicio;
	}
	private JLabel getLbFin() {
		if (lbFin == null) {
			lbFin = new JLabel("Fecha fin: (YYYY-MM-DD)");
			lbFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbFin;
	}
	private JTextField getTfFin() {
		if (tfFin == null) {
			tfFin = new JTextField();
			tfFin.setName("tfFin");
			tfFin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfFin.setColumns(10);
		}
		return tfFin;
	}
	private JLabel getLbCuota() {
		if (lbCuota == null) {
			lbCuota = new JLabel("Cuota: (€)");
			lbCuota.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbCuota;
	}
	private JTextField getTfCuota() {
		if (tfCuota == null) {
			tfCuota = new JTextField();
			tfCuota.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfCuota.setColumns(10);
		}
		return tfCuota;
	}
}
