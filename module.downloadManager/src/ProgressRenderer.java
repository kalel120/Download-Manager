/**
 * This is the second class
 * Takes advantage of the fact that swings JTable class has rendering system that can accept "plug ins"
 * for rendering table cells
 * Created by Al on 07-Jul-15.
 */
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

//this class renders a JProgress in a table cell
public class ProgressRenderer extends JProgressBar implements TableCellRenderer{
    //Constructors for ProgressRenderer
    public ProgressRenderer(int min, int max){
        super(min, max);
    }
    /**
     * Returns this JProgressBar as the renderer for the given cell
     */
    public Component getTableCellRendererComponent(  JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column){
        //Set JProgressBar's percent complete value
        setValue( (int) ((Float)value).floatValue() ) ;
        return this;
    }
}
