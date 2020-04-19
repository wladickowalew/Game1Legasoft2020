package Logic;

import GUI.Resolution;

public class Main {
    public static void main(String[] args) {
        int[] res = Resolution.getResolution();
        Window window = new Window(res[0], res[1]);
    }
}
