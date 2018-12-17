package ex_3;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

import game.packman;

import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Gui {

	
	private JFrame frame;
	public javafx.scene.image.Image myimage;
	public BufferedImage myImage1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		double b = System.currentTimeMillis();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Gui window = new Gui();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		 b -= System.currentTimeMillis();
		 b*=-1;
		 System.out.println(b);

	}

	/**
	 * Create the application.
	 */
	public Gui() {
		initialize();
	}
	

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(204, 255, 0));
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
	
		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);
		
		JMenuItem mntmOpen = new JMenuItem("Import");
		mntmOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jc = new JFileChooser();
				jc.setDialogTitle("Please select a csv File");
				if(jc.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
//					turn the file to lists
				}
			}
		});
		mnFile.add(mntmOpen);
		
		JMenuItem mntmExportToCsv = new JMenuItem("Export to Csv");
		mnFile.add(mntmExportToCsv);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Export to Kml");
		mnFile.add(mntmNewMenuItem_2);
		
		JMenu mnNewMenu = new JMenu("Add");
		mnNewMenu.setBackground(new Color(0, 102, 0));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("ADD PACKMAN");
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				double x = e.getX();
				double y = e.getY();
				System.out.println(x+" " +y);
				
				packman p = new packman();
				
			}
		});
		
		
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("ADD FRUIT");
		mntmNewMenuItem_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				double x1 = e.getID();
				double x = e.getX();
				double y = e.getY();
				System.out.println(x+" " +y + x1);
			}
		});
		
		mnNewMenu.add(mntmNewMenuItem_1);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("arielPic");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		java.awt.Image img = new ImageIcon(this.getClass().getResource("/Ariel1.png")).getImage();
		img.getWidth(frame);
		img.getHeight(frame);
		lblNewLabel.setIcon(new ImageIcon(img));
		lblNewLabel.setBounds(99, 0,  img.getWidth(frame),	img.getHeight(frame));
		frame.getContentPane().add(lblNewLabel);
	}
}
