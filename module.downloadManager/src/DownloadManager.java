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
        
    }
}
