package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;

public class GUIWindow {
    /**
     * These are the private fields for the GUIWindow class
     */
    private Window window;
    private Button sortByAlpha;
    private Button quitButton;
    private Button sortByCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;

    /**
     * THis is the default constructor for the class
     */
    public GUIWindow() {
        // This method will set up all the buttons
        setUpButtons();
    }


    /**
     * THis is the setUpButtons method which will setup All the buttons
     */
    private void setUpButtons() {
        // Setting up the quit button
        quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuit");
    }


    /**
     * This is the clicked Quit button
     * method. This will quit the screen when clicked
     * 
     * @param quitButton
     *            is responsible for quitting
     */
    public void clickedQuit(Button quitButton) {

        int status = 0;
        System.exit(status);

    }

}
