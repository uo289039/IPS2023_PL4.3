package giis.demo.tkrun;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import java.awt.Font;

public class PanelCategorias extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JLabel lbNombre;
	private JTextField tfNombre;
	private JLabel lbMin;
	private JTextField tfMin;
	private JLabel lbMax;
	private JTextField tfMax;
	private JLabel lnGenero;
	private JPanel panel;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JRadioButton rdbtnMasculino;
	private JRadioButton rdbtnFemenino;
	private JRadioButton rdbtnMixto;

	/**
	 * Create the panel.
	 */
	public PanelCategorias() {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(4, 2, 0, 0));
		add(getLbNombre());
		add(getTfNombre());
		add(getLbMin());
		add(getTfMin());
		add(getLbMax());
		add(getTfMax());
		add(getLnGenero());
		add(getPanel());

	}

	private JLabel getLbNombre() {
		if (lbNombre == null) {
			lbNombre = new JLabel("Nombre de la categoría");
			lbNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbNombre;
	}
	private JTextField getTfNombre() {
		if (tfNombre == null) {
			tfNombre = new JTextField();
			tfNombre.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfNombre.setColumns(10);
		}
		return tfNombre;
	}
	private JLabel getLbMin() {
		if (lbMin == null) {
			lbMin = new JLabel("Edad mínima");
			lbMin.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbMin;
	}
	private JTextField getTfMin() {
		if (tfMin == null) {
			tfMin = new JTextField();
			tfMin.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfMin.setColumns(10);
		}
		return tfMin;
	}
	private JLabel getLbMax() {
		if (lbMax == null) {
			lbMax = new JLabel("Edad máxima");
			lbMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lbMax;
	}
	private JTextField getTfMax() {
		if (tfMax == null) {
			tfMax = new JTextField();
			tfMax.setFont(new Font("Tahoma", Font.PLAIN, 12));
			tfMax.setColumns(10);
		}
		return tfMax;
	}
	private JLabel getLnGenero() {
		if (lnGenero == null) {
			lnGenero = new JLabel("Género");
			lnGenero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		}
		return lnGenero;
	}
	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.add(getRdbtnMasculino());
			panel.add(getRdbtnFemenino());
			panel.add(getRdbtnMixto());
		}
		return panel;
	}
	private JRadioButton getRdbtnMasculino() {
		if (rdbtnMasculino == null) {
			rdbtnMasculino = new JRadioButton("Masculino");
			rdbtnMasculino.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMasculino);
		}
		return rdbtnMasculino;
	}
	private JRadioButton getRdbtnFemenino() {
		if (rdbtnFemenino == null) {
			rdbtnFemenino = new JRadioButton("Femenino");
			rdbtnFemenino.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnFemenino);
		}
		return rdbtnFemenino;
	}
	private JRadioButton getRdbtnMixto() {
		if (rdbtnMixto == null) {
			rdbtnMixto = new JRadioButton("Mixto");
			rdbtnMixto.setSelected(true);
			rdbtnMixto.setBackground(Color.WHITE);
			buttonGroup.add(rdbtnMixto);
		}
		return rdbtnMixto;
	}
}
