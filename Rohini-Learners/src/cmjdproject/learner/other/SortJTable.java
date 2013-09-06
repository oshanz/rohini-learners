/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author oshanz
 */
public class SortJTable {

    public void sort(JTable jTable) {

        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(jTable.getModel());
        jTable.setRowSorter(sorter);
    }
}
