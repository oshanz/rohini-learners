/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import cmjdproject.learner.controller.CandidateController;
import java.awt.event.ActionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JComboBox;
import net.sourceforge.jsorter.SwingSorter;

/**
 *
 * @author oshanz
 */
public class LoadtoCombo {

    public LoadtoCombo() {
    }

    public void load(final JComboBox jComboBox) throws ClassNotFoundException, SQLException, FileNotFoundException, IOException {
        ArrayList<String> candidateDetails = CandidateController.getCandidateDetails();

        for (String string : candidateDetails) {
            jComboBox.addItem(string);
        }

        new SwingSorter().sortComboBox(jComboBox);
        AutoCompletion autoCompletion = new AutoCompletion(jComboBox);

        MouseWheelListener mouseWheelListener = new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent evt) {

                int index = jComboBox.getSelectedIndex() + evt.getWheelRotation();
                if (index >= 0 && index < jComboBox.getItemCount()) {
                    jComboBox.setSelectedIndex(index);
                }

            }
        };

        jComboBox.addMouseWheelListener(mouseWheelListener);
        jComboBox.setEditable(true);

    }
}
