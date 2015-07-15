/**
 * This class is reponsible for creating and running the download manager's GUI.
 * This class has a main method declared, so on creation it will invoked first
 *
 * Created by Al on 13-Jul-15.
 */
import java.awt.*;
import java.awt.event.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;


public class DownloadManager extends JFrame implements Observer{
    //Add download text field
    private JTextField addTextField;

    //Download table's data model
    private DownloadsTableModel tableModel;

    //Table listing downloads
    private JTable table;

    //These are buttons for managing the selected downloads
    private JButton pushButton, resumeButton, cancelButton, clearButton;

    //Currently selected download
    private Download selectedDownload;

    //Flag for whether or not table selection is being cleard
    private boolean clearing;

    //Constructor for Download Manager
    public DownloadManager (){
        //set application title
        setTitle("Download Manager");
        //set window size
        setSize(640, 480);

        //Handle window closing events
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                actionExit();
            }
        } );

        //Set up file menu
        JMenuBar  menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        JMenuItem fileExitMenuItem = new JMenuItem("Exit", KeyEvent.VK_X);
        fileExitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                actionExit();
            }
        });
        fileMenu.add(fileExitMenuItem);
        menuBar.add(fileMenu);
        setJMenuBar(menuBar);

       //Set up add panel
        JPanel addPanel = new JPanel();
        addTextField = new JTextField(30);
        addPanel.add(addTextField);
        JButton addButton = new JButton ("Add Download");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent et) {
                actionAdd();
            }
        });
        addPanel.add(addButton);

        //set up Download Table
        tableModel = new DownloadsTableModel();
        table = new JTable(tableModel);
        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                tableSelectionChanged();
            }
        });

        //Allow only one row at a time to be selected.
        table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);

        //set up ProgressBar as renderer for progress colum
        ProgressRenderer renderer = new ProgressRenderer(0,100);
        renderer.setStringPainted(true);                        //show progress text
        table.setDefaultRenderer(JProgressBar.class , renderer);

        //set table's row height large enough to fit JProgressBar.
        table.setRowHeight( (int)renderer.getPreferredSize().getHeight());

        //set up download panel
        JPanel downloadsPanel = new JPanel();
        downloadsPanel.setBorder(BorderFactory.createTitledBorder("Downloads"));
        downloadsPanel.setLayout(new BorderLayout());
        downloadsPanel.add(new JScrollPane(table), BorderLayout.CENTER );
    }
}
