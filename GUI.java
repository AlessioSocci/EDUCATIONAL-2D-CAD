import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.BoxLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import java.awt.SystemColor;
import java.awt.TextArea;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridLayout;
import javax.swing.SpringLayout;
import javax.swing.JTextArea;

import java.lang.Object;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import javax.swing.JFileChooser;
import java.util.List;
import java.util.ArrayList;
import java.awt.geom.Line2D;
import java.awt.Graphics2D;
import java.awt.Event;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;


public class GUI extends JFrame 
{
	private JPanel contentPane;

	private Graphics2D g2;
	
	private int xs, ys, xe, ye;
	private Line2D lineBuffer;
	private final List<Line2D> lineContainer = new ArrayList();

	private Line2D gridBuffer;
	private final List<Line2D> gridContainer = new ArrayList();	
		
	private void DrawGrid()
	{
		int GridSize = 50;
		
		for(int x = 0; x < 800; x += GridSize)
		{
			for(int y = 0; y < 600; y += GridSize)
			{
				gridBuffer = new Line2D.Double((double)x, (double)y, (double)x, (double)y);
				gridContainer.add(gridBuffer);
			}
		}
		
		g2.setColor(Color.green);
		for(int i = 0; i < gridContainer.size(); i++)
		{
			g2.draw(gridContainer.get(i));
		}
	}
	
	private void DrawAll()
	{
		g2.setColor(Color.yellow);
		for(int i = 0; i < lineContainer.size(); i++)
		{
			g2.draw(lineContainer.get(i));
		}
	}
	
	private void getScreenShot()
	{
		
	}
	
	private void saveScreenShot(String filename)
	{
		
	}
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) 
	{	
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					GUI frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}
	
	
	/**
	 * Create the frame.
	 */
	public GUI() 
	{
		setTitle("2D CAD");
		setResizable(false);
		setLocationRelativeTo(null);
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 725);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(Color.LIGHT_GRAY);
		setJMenuBar(menuBar);
		
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.menu);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(820, 34, 168, 603);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Layers", null, panel, null);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Tools", null, panel_1, null);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("File", null, panel_2, null);	
		
		JTextArea testo = new JTextArea();
		testo.setText("set text");
		panel_2.add(testo);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 645, 464, 24);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel labelPosition = new JLabel("Position: ");
		labelPosition.setBounds(240, 5, 214, 14);
		labelPosition.setHorizontalAlignment(SwingConstants.LEFT);
		panel_3.add(labelPosition);
		
		JLabel labelCoordinate = new JLabel("Coordinate: ");
		labelCoordinate.setBounds(10, 5, 220, 14);
		panel_3.add(labelCoordinate);
		labelCoordinate.setHorizontalAlignment(SwingConstants.LEFT);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 11, 964, 12);
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		JToggleButton ToggleButton_ShowGrid = new JToggleButton("Show Grid");
		ToggleButton_ShowGrid.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(ToggleButton_ShowGrid.isSelected())
				{
					DrawGrid();
					g2.draw(gridBuffer);
				}			
			}
		});
		ToggleButton_ShowGrid.setBounds(0, 0, 100, 13);
		panel_4.add(ToggleButton_ShowGrid);
		
		
		JPanel panel_5 = new JPanel();		
		panel_5.setBackground(Color.DARK_GRAY);
		panel_5.setBounds(10, 34, 800, 600);
		contentPane.add(panel_5);
		
		
		JMenu mnFile = new JMenu("File");
		mnFile.setBackground(Color.DARK_GRAY);
		menuBar.add(mnFile);
		
		JMenuItem menuNew = new JMenuItem("New");
		menuNew.setSelected(true);
		menuNew.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				
				
			}
		});
		
		mnFile.add(menuNew);
		
		JMenuItem menuOpen = new JMenuItem("Open");
		menuOpen.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				int confirmValue = JOptionPane.showConfirmDialog(null, "Il file corrente sarà cancellato, vuoi aprire un nuovo file?");
					
				if (confirmValue == 0)
				{
					String cwd = System.getProperty("user.dir");
					JFileChooser chooser = new JFileChooser();
						
					chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
					chooser.setMultiSelectionEnabled(false);
					chooser.setDialogTitle("Open a Text File");	
					
					FileNameExtensionFilter filter = new FileNameExtensionFilter("Text Files", "txt");
					chooser.setFileFilter(filter);
						
					int returnValue = chooser.showOpenDialog(GUI.this);
						
					if(returnValue == JFileChooser.APPROVE_OPTION)
					{
						String fileName = chooser.getSelectedFile().getPath();
							
						FileReader reader = null;
						
						try 
						{
							reader = new FileReader(fileName);
						}
						catch (FileNotFoundException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
						try 
						{
							testo.read(reader, fileName);
						}
						catch (IOException e1) 
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					
					}
						
				}
					
			}
		});
		mnFile.add(menuOpen);
		
		JSeparator separator = new JSeparator();
		mnFile.add(separator);
		
		JMenuItem menuSave = new JMenuItem("Save");
		mnFile.add(menuSave);
		
		JMenuItem menuSaveAs = new JMenuItem("Save As");
		mnFile.add(menuSaveAs);
		
		JMenuItem menuQuit = new JMenuItem("Quit");
		menuQuit.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		
		JSeparator separator_1 = new JSeparator();
		mnFile.add(separator_1);
		mnFile.add(menuQuit);
		
		JMenu mnEdit = new JMenu("Edit");
		mnEdit.setBackground(Color.DARK_GRAY);
		menuBar.add(mnEdit);
		
		JMenuItem menuCopy = new JMenuItem("Copy");
		mnEdit.add(menuCopy);
		
		JMenuItem menuPaste = new JMenuItem("Paste");
		mnEdit.add(menuPaste);
		
		JMenuItem menuCut = new JMenuItem("Cut");
		mnEdit.add(menuCut);
		
		JMenuItem menuDelete = new JMenuItem("Delete");
		mnEdit.add(menuDelete);
		
		JMenu menu = new JMenu("Tools");
		menuBar.add(menu);
		
		JRadioButton radioLine = new JRadioButton("Line");
		menu.add(radioLine);
		
		JRadioButton radioArc = new JRadioButton("Arc");
		menu.add(radioArc);
		
		JRadioButton radioEllipse = new JRadioButton("Ellipse");
		menu.add(radioEllipse);
		
		JRadioButton radioRectangle = new JRadioButton("Rectangle");
		menu.add(radioRectangle);
		
		JRadioButton radioText = new JRadioButton("Text");
		menu.add(radioText );
		
		
		panel_5.addMouseMotionListener(new MouseMotionAdapter() 
		{
			@Override
			public void mouseDragged(MouseEvent e) 
			{
				if(radioLine.isSelected())
				{
					 panel_5.update(g2);
					 xe = e.getX();
					 ye = e.getY();
			
					 lineBuffer = new Line2D.Float((float)xs, (float)ys, (float)xe, (float)ye);
					 DrawAll();
					 g2.draw(lineBuffer);
				}
				
				labelPosition.setText("Position = " + e.getX() + ", " + e.getY());
			}
			
			@Override
			public void mouseMoved(MouseEvent e) 
			{
				labelCoordinate.setText("Coordinate = " + e.getX() + ", " + e.getY());
			}
		});
			
		
		panel_5.addMouseListener(new MouseAdapter() 
		{
			@Override
			public void mousePressed(MouseEvent e) 
			{
				if(g2 == null)
				{
					g2 = (Graphics2D) panel_5.getGraphics();
				}
				
				xs = e.getX();
				ys = e.getY();
				xe = e.getX();
				ye = e.getY();
			}
			
			@Override
			public void mouseReleased(MouseEvent e) 
			{
				if(radioLine.isSelected())
				{
					 panel_5.update(g2);
					 xe = e.getX();
					 ye = e.getY();
				}
				
				lineBuffer = new Line2D.Float((float)xs, (float)ys, (float)xe, (float)ye);
				lineContainer.add(lineBuffer);
				DrawAll();	
			}
						
		});
	}
}
