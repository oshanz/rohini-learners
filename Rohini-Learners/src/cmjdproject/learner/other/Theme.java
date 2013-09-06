/*
 * To change c template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmjdproject.learner.other;

import com.jtattoo.plaf.aero.AeroLookAndFeel;
import com.jtattoo.plaf.aluminium.AluminiumLookAndFeel;
import com.jtattoo.plaf.bernstein.BernsteinLookAndFeel;
import com.jtattoo.plaf.fast.FastLookAndFeel;
import com.jtattoo.plaf.mint.MintLookAndFeel;
import com.jtattoo.plaf.smart.SmartLookAndFeel;
import com.sun.java.swing.plaf.motif.MotifLookAndFeel;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Component;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author oshanz
 */
public class Theme {

    public void theme(int no, Component component) throws Exception {

        int i = no;
        try {

            if (i == 0) {
                //
            } else if (i == 1) {
                UIManager.setLookAndFeel(new WindowsLookAndFeel());
            } else if (i == 2) {
                UIManager.setLookAndFeel(new MotifLookAndFeel());
            } else if (i == 3) {
                UIManager.setLookAndFeel(new AeroLookAndFeel());
            } else if (i == 4) {
                UIManager.setLookAndFeel(new AluminiumLookAndFeel());
            } else if (i == 5) {
                UIManager.setLookAndFeel(new BernsteinLookAndFeel());
            } else if (i == 6) {
                UIManager.setLookAndFeel(new FastLookAndFeel());
            } else if (i == 7) {
                UIManager.setLookAndFeel(new MintLookAndFeel());
            } else if (i == 8) {
                UIManager.setLookAndFeel(new SmartLookAndFeel());
            } else if (i == 9) {
                UIManager.setLookAndFeel(new MetalLookAndFeel());
            }

            SwingUtilities.updateComponentTreeUI(component);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Selected theme isnt working");
        }
    }
}
/*


 SubstanceAutumnLookAndFeel
 SubstanceBusinessLookAndFeel
 SubstanceCremeLookAndFeel
 SubstanceFieldOfWheatLookAndFeel
 SubstanceGreenMagicLookAndFeel
 SubstanceLookAndFeel
 SubstanceMagmaLookAndFeel
 SubstanceMangoLookAndFeel
 SubstanceModerateLookAndFeel
 SubstanceOfficeBlue2007LookAndFeel
 SubstanceOfficeSilver2007LookAndFeel
 SubstanceRavenLookAndFeel
 SubstanceSaharaLookAndFeel
 SynthLookAndFeel
 SyntheticaBlackMoonLookAndFeel
 SyntheticaBlackStarLookAndFeel
 SyntheticaBlueIceLookAndFeel
 SyntheticaBlueMoonLookAndFeel
 SyntheticaBlueSteelLookAndFeel
 SyntheticaGreenDreamLookAndFeel

 */
