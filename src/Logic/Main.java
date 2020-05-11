package Logic;

import GUI.Resolution;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        int[] res = Resolution.getResolution();
        Window window = new Window(res[0], res[1]);
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
