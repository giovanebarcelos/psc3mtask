package utils;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;
import java.util.EventObject;

public class ButtonEditor extends AbstractCellEditor
        implements TableCellEditor {
    protected JButton button;
    private String label;
    private boolean clicked;
    private ButtonClickListener listener;
    private JTable table;
    private int row;

    public interface ButtonClickListener {
        void onButtonClick(int row);
    }

    public ButtonEditor(JTable table, ButtonClickListener listener){
        this.table = table;
        this.listener = listener;
        button = new JButton();
        button.setOpaque(true);
        button.addActionListener(e -> {
            fireEditingStopped();
            listener.onButtonClick(row);
        });
    }

    @Override
    public Component getTableCellEditorComponent(JTable table,
                                                 Object value, boolean isSelected,
                                                 int row, int column) {
        this.row = row;
        label = (value == null ) ? "" : value.toString();
        button.setText(label);
        clicked = true;

        return button;

    }

    @Override
    public Object getCellEditorValue() {
        return this.label;
    }

    @Override
    public boolean stopCellEditing(){
        clicked = false;
        return super.stopCellEditing();
    }

    @Override
    public void fireEditingStopped(){
        super.fireEditingStopped();
    }

    @Override
    public boolean isCellEditable(EventObject e) {
        return true;
    }
}
