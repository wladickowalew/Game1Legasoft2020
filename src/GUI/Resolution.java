package GUI;

import javax.swing.*;

import static Logic.Variables.RESOLUTIONS;

public class Resolution {

    private static final String DEFAULT = RESOLUTIONS[0];
    private static Box box;
    private static ButtonGroup group;

    public static int[] getResolution(){
        JPanel panel = new JPanel();
        box = Box.createVerticalBox();
        group = new ButtonGroup();
        for (String res: RESOLUTIONS){
            addButton(res);
        }
        panel.add(box);
        JOptionPane.showMessageDialog(null, panel);
        String choice = group.getSelection().getActionCommand();
        int pos = choice.indexOf("x");
        int w = Integer.parseInt(choice.substring(0, pos));
        int h = Integer.parseInt(choice.substring(pos+1));
        return new int[] {w, h};
    }

    private static void addButton(String res){
        JRadioButton button = new JRadioButton(res);
        if (res == DEFAULT)
            button.setSelected(true);
        button.setActionCommand(res);
        group.add(button);
        box.add(button);
    }

}
