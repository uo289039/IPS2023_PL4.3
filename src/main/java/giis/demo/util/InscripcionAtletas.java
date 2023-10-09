package giis.demo.util;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InscripcionAtletas extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCorreo;
	private JLabel lblPideCorreo;
	/**
	 * Create the dialog.
	 */
	public InscripcionAtletas() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			lblPideCorreo = new JLabel("Introduzca su correo para inscribirse:");
			lblPideCorreo.setDisplayedMnemonic('i');
			contentPanel.add(lblPideCorreo, BorderLayout.WEST);
		}
		{
			JLabel lblTituloVentana = new JLabel("INSCRIPCIÓN");
			contentPanel.add(lblTituloVentana, BorderLayout.NORTH);
		}
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new GridLayout(5, 1, 0, 0));
			{
				JLabel lblEspacio1 = new JLabel("");
				panel.add(lblEspacio1);
			}
			{
				JLabel lblEspacio2 = new JLabel("");
				panel.add(lblEspacio2);
			}
			{
				textCorreo = new JTextField();
				lblPideCorreo.setLabelFor(textCorreo);
				panel.add(textCorreo);
				textCorreo.setColumns(10);
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

}
