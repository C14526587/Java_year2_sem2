package docSimilarity;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

@SuppressWarnings("serial")
public class Gui extends JFrame implements ActionListener, MouseListener
{
	private static JButton btnStats = new JButton("Show stats");
	private JButton btnSave = new JButton("Save");
	private JButton btnNoSave = new JButton("Don't save");
	private JButton btnFile1 = new JButton("File 1");
	private JButton btnFile2 = new JButton("File 2");
	private JButton btnFile3 = new JButton("Stop words");
	
	private File file1 = new File("");
	private File file2 = new File("");
	private File file3 = new File("C:\\");
	private File saveLoc = new File("");
	private boolean saveFile = false;
	private boolean stopWordOption = false;

	public Gui()
	{
		//Setting up the window
		JFrame window = new JFrame("DocSim");
		window.setVisible(true);
		window.setSize(400, 200);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(null);
		
		//Adding buttons
		window.add(btnStats);
		window.add(btnSave);
		window.add(btnFile1);
		window.add(btnFile2);
		window.add(btnFile3);
		window.add(btnNoSave);

		btnStats.setBounds(25, 70, 110, 40);
		btnSave.setBounds(135, 70, 110, 40);
		btnNoSave.setBounds(245, 70, 110, 40);
		
		btnFile1.setBounds(25, 20, 110, 40);
		btnFile2.setBounds(135, 20, 110, 40);
		btnFile3.setBounds(245, 20, 110, 40);
		
		//Creating the top navigation bar
		JMenuBar menu = new JMenuBar();
		window.setJMenuBar(menu);
		
		JMenu file = new JMenu("File");
		menu.add(file);
		JMenuItem findFile = new JMenuItem("File files");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(findFile);
		file.add(exit);
		
		JMenu help = new JMenu("Help");
		menu.add(help);
		JMenuItem functions = new JMenuItem("Functions");
		help.add(functions);
		
		//Adding listeners
		btnStats.addActionListener(this);
		btnSave.addActionListener(this);
		btnNoSave.addActionListener(this);
		btnFile1.addActionListener(this);
		btnFile2.addActionListener(this);
		btnFile3.addActionListener(this);
		
		findFile.addActionListener(new ExitButton());
		exit.addActionListener(new ExitButton());
		
		
	}
	
	public static void printLists(int[] countInt, String[] occured)
	{
		JOptionPane.showMessageDialog(btnStats, "save");
	}
	
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == btnFile1)
		{
			JFileChooser f1 = new JFileChooser();
			f1.showDialog(null, "Select");
			f1.setFocusable(true);
			file1 = f1.getSelectedFile();
		}
		else if (e.getSource() == btnFile2)
		{
			JFileChooser f2 = new JFileChooser();
			f2.showDialog(null, "Select");
			f2.setFocusable(true);
			file2 = f2.getSelectedFile();
		}
		else if (e.getSource() == btnFile3)
		{
			JFileChooser f3 = new JFileChooser();
			f3.showDialog(null, "Select");
			f3.setFocusable(true);
			file3 = f3.getSelectedFile();
			
			stopWordOption = true;
		}
		else if (e.getSource() == btnStats)
		{
			if (file1.exists() && file2.exists())
			{
				ReadFile.read(file1, file2, file3, stopWordOption, saveFile, saveLoc);
			}
			else
			{
				JOptionPane.showMessageDialog(this, "Error, please select the files.");
			}
		}
		else if (e.getSource() == btnSave)
		{
			JFileChooser f4 = new JFileChooser();
			f4.showDialog(null, "Select save location");
			f4.setFocusable(true);
			saveLoc = f4.getSelectedFile();
			
			JOptionPane.showMessageDialog(this, "File will save to this directory");
			saveFile = true;
		}
		else if (e.getSource() == btnNoSave)
		{
			JOptionPane.showMessageDialog(this, "File will not be saved");
			saveFile = false;
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Error");
		}
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
