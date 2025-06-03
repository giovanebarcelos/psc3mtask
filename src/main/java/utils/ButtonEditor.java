package utils;

import javax.swing.*;
import javax.swing.table.TableCellEditor;
import java.awt.*;

public class ButtonEditor extends AbstractCellEditor
        implements TableCellEditor {
    public ButtonEditor(JTable table, Object o) {
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return null;
    }

    @Override
    public Object getCellEditorValue() {
        return null;
    }
}
