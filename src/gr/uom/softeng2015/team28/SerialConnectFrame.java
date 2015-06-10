package gr.uom.softeng2015.team28;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import jssc.SerialPortList;

public class SerialConnectFrame extends JFrame {
	private JLabel portSelectPrompt;
	private JButton refreshButton;
	private JButton connectButton;
	private JPanel portPanel;
	private JComboBox portList;	//portList.addActionListener(this);
	//private JList portList;
	//private JTextField field;
	//private ArrayList<> ports;

	public SerialConnectFrame() {

		portSelectPrompt = new JLabel("Select Arduino Port:");
		refreshButton = new JButton("Refresh");
		connectButton = new JButton("Connect");
		portPanel = new JPanel();
		portList = new JComboBox();

		// ----------------------------------------
		portPanel.add(portSelectPrompt);
		portPanel.add(portList);
		portPanel.add(refreshButton);
		portPanel.add(connectButton);

		// ----------------------------------------
		this.setContentPane(portPanel);

		SetPortNames();

		ButtonListener listener = new ButtonListener();
		refreshButton.addActionListener(listener);
		connectButton.addActionListener(listener);

		this.setVisible(true);
		this.setSize(400, 200);
		this.setTitle("Port Selection");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}


	public void ListPorts() {
		String[] portNames = SerialPortList.getPortNames();
		for(int i = 0; i < portNames.length; i++) {
			System.out.println(portNames[i]);
		}
	}

	private void SetPortNames() {
		portList.removeAllItems();
		String[] portNames = SerialPortList.getPortNames();
		System.out.println("Available COM ports:");
		for (String portName : portNames) {
			portList.addItem(portName);
			System.out.println(portName);
		}
	}                                            

	class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			if(e.getSource() == refreshButton) {
				SetPortNames();
			}
			else if(e.getSource() == connectButton) {
			}

		}
	}

}
