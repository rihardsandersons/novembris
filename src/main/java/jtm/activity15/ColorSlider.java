package jtm.activity15;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import net.miginfocom.swing.MigLayout;

/*- Install WindowBulder plugin on Eclipse
 * Then right click on this class in Project Explorer 
 * and choose "Open With" and choose "WindowBuilder editor"
 * Then choose "Design" tab of the editor.
 * You can create reference implementation of application in following way:
 *   1. select menu: New — Other...,
 *   2. choose tree: WindowBuilder — Swing Application — Application window
 *   3. press Next, enter Class name and press Finish.
 * Note that both — "Application window" and "JFrame" wizard settings use JFrame as main container object.
 * Only differences are that with "JFrame" application extends JFrame, but "Swing Application"
 * has JFrame as its internal object, thus initialization is little different.
 */

public class ColorSlider {

	JFrame frame;
	JSlider redSlider, greenSlider, blueSlider;
	JTextArea txtTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ColorSlider window = new ColorSlider();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application objects and add listeners
	 */
	public ColorSlider() {
		initialize();
		add_listeners();
	}

	/**
	 * Initialize the content of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		// Form properties
		frame.setTitle("Color slider");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new MigLayout("", "[][][grow]", "[][][][][][grow]"));

		redSlider = new JSlider(0, 255, 0);
		redSlider.setName("redSlider");
		frame.getContentPane().add(redSlider, "cell 2 0,growx");

		greenSlider = new JSlider(0, 255, 0);
		greenSlider.setName("greenSlider");
		frame.getContentPane().add(greenSlider, "cell 2 1,growx");

		blueSlider = new JSlider(0, 255, 0);
		blueSlider.setName("blueSlider");
		frame.getContentPane().add(blueSlider, "cell 2 2,growx");

		redSlider.setValue(0);
		greenSlider.setValue(0);
		blueSlider.setValue(0);

		txtTest = new JTextArea();
		txtTest.setName("testArea");
		txtTest.setText("Test area");
		txtTest.setBackground(Color.BLACK);

		frame.getContentPane().add(txtTest, "cell 0 3 3 3,grow");

		// Color labels
		JLabel lblR = new JLabel("R");
		frame.getContentPane().add(lblR, "cell 1 0");
		JLabel lblG = new JLabel("G");
		frame.getContentPane().add(lblG, "cell 1 1");
		JLabel lblB = new JLabel("B");
		frame.getContentPane().add(lblB, "cell 1 2");

		/*-add JSliders: redSlider, greenSlider, blueSlider into form
		 * set their range accordingly from 0 to 255
		 * Layout them correctly against appropriate labels
		 * red slider should be in "cell 2 0", green in "cell 2 1",
		 * and blue in "cell 2 2"
		 * use .setName("name") method to set name property of slider objects as:
		 * redSlider, greenSlider and blueSlider.
		 */

		// set initial values of sliders to 0 and background to black

		// Make JFrame visible
		frame.setVisible(true);

	}

	private void add_listeners() {

		redSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				setBackgroundColor();
			}
		});

		greenSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				setBackgroundColor();
			}
		});

		blueSlider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				setBackgroundColor();
			}
		});

		// add event listeners to all sliders and call change_color method
		// from them
	}

	private void setBackgroundColor() {
		txtTest.setBackground(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
		// change background id of txtTest object accordingly to
		// id slider values. Use Color object for that
	}

}
