package ar.edu.unlam.analisisSoftware.ehims.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.border.EmptyBorder;

import ar.edu.unlam.analisisSoftware.ehims.utils.ClaseJava;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static GUI frame;
	private JLabel lblLines;	
	private JLabel lblBlanks;	
	private JLabel lblComment;
	private JLabel lblMulticomment;
	private JLabel lblFile;
	private JLabel lblTotalLines;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GUI() {
		setResizable(false);
		setTitle("Herramienta de Testing (Grupo 11)");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				confirmarSalir();
			}
		});
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 554, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAnalizarArchivo = new JMenuItem("Analizar archivo...");
		mntmAnalizarArchivo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final JFileChooser fc = new JFileChooser();
				int returnVal = fc.showOpenDialog(frame);
		        if (returnVal == JFileChooser.APPROVE_OPTION) {
		            File file = fc.getSelectedFile();
		            ClaseJava claseJava = new ClaseJava(file);
		            lblFile.setText(file.getAbsolutePath());
		            lblLines.setText(String.valueOf(claseJava.getCantidadLineasDeCodigo()));
		        	lblBlanks.setText(String.valueOf(claseJava.getCantidadLineasEnBlanco()));
		        	lblComment.setText(String.valueOf(claseJava.getCantidadLineasComentadas()));
		        	//lblMulticomment;
		        	lblTotalLines.setText(String.valueOf(claseJava.getCantidadDeLineas()));
		            //This is where a real application would open the file.
		            //log.append("Opening: " + file.getName() + "." + newline);
		        } else {
		            //log.append("Open command cancelled by user." + newline);
		        }
				
			}
		});
		mnArchivo.add(mntmAnalizarArchivo);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				confirmarSalir();
			}
		});
		mnArchivo.add(mntmSalir);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblLneasDeCdigo = new JLabel("L\u00EDneas de c\u00F3digo");
		lblLneasDeCdigo.setBounds(10, 115, 115, 14);
		contentPane.add(lblLneasDeCdigo);
		
		JLabel lblLneasEnBlanco = new JLabel("L\u00EDneas en blanco");
		lblLneasEnBlanco.setBounds(10, 140, 115, 14);
		contentPane.add(lblLneasEnBlanco);
		
		JLabel lblComentariosDeLnea = new JLabel("Comentarios");
		lblComentariosDeLnea.setBounds(10, 165, 179, 14);
		contentPane.add(lblComentariosDeLnea);
		
		//JLabel lblComentariosMultilnea = new JLabel("Comentarios multil\u00EDnea");
		//lblComentariosMultilnea.setBounds(10, 190, 131, 14);
		//contentPane.add(lblComentariosMultilnea);
		
		JLabel lblArchivo = new JLabel("Archivo:");
		lblArchivo.setBounds(10, 50, 46, 14);
		contentPane.add(lblArchivo);
		
		JLabel lblLneasTotales = new JLabel("L\u00EDneas totales");
		lblLneasTotales.setBounds(10, 90, 115, 14);
		contentPane.add(lblLneasTotales);
		
		lblTotalLines = new JLabel("");
		lblTotalLines.setBounds(226, 90, 121, 14);
		contentPane.add(lblTotalLines);
		
		lblFile = new JLabel("");
		lblFile.setBounds(66, 50, 462, 14);
		contentPane.add(lblFile);
		
		lblLines = new JLabel("");
		lblLines.setBounds(226, 115, 121, 14);
		contentPane.add(lblLines);
		
		lblBlanks = new JLabel("");
		lblBlanks.setBounds(226, 140, 121, 14);
		contentPane.add(lblBlanks);
		
		lblComment = new JLabel("");
		lblComment.setBounds(226, 165, 121, 14);
		contentPane.add(lblComment);
		
		//lblMulticomment = new JLabel("");
		//lblMulticomment.setBounds(135, 190, 79, 14);
		//contentPane.add(lblMulticomment);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 128, 337, 14);
		contentPane.add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(10, 153, 337, 14);
		contentPane.add(separator_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(10, 178, 337, 14);
		contentPane.add(separator_2);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setBounds(10, 103, 337, 14);
		contentPane.add(separator_4);
		
		
		
		//JSeparator separator_3 = new JSeparator();
		//separator_3.setBounds(10, 203, 206, 14);
		//contentPane.add(separator_3);
	}
	
	private void confirmarSalir() {
		int option = JOptionPane.showConfirmDialog(frame, "Esta seguro que quiere salir?",
													"Cerrando aplicacion", JOptionPane.YES_NO_OPTION);
		if(option == JOptionPane.YES_OPTION) {
			frame.dispose();
		}
	}
}

