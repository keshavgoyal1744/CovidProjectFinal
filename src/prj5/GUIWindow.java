package prj5;

import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.awt.Color;
import java.util.Iterator;

public class GUIWindow {
    /**
     * These are the private fields for the GUIWindow class
     */
    private Window window;
    private Button sortAlpha;
    private Button quitButton;
    private Button sortByCFR;
    private Button representDC;
    private Button representGA;
    private Button representMD;
    private Button representNC;
    private Button representTN;
    private Button representVA;
    private String windowTitle;
    private LinkedList<State> states;
    /**
     * @param WIDTH
     *            is the width of each graph
     * @param DISPLAY_FACTOR 
     *            is the base height of a graph
     */
    public static final int WIDTH = 20;
    public static final int DISPLAY_FACTOR = 20;

    /**
     * THis is the default constructor for the class
     */
    public GUIWindow(LinkedList<State> state) {
        //Initializes the field variables
        window = new Window();
        window.setSize(500, 500);
        windowTitle = "";
        states = state;
        //This method will set up all the buttons
        setUpButtons();
    }


    /**
     * THis is the setUpButtons method which will setup All the buttons
     */
    private void setUpButtons() {
        //Setting up the sort alpha button
        sortAlpha = new Button("Sort by Alpha");
        window.addButton(sortAlpha, WindowSide.NORTH);
        sortAlpha.onClick(this, "clickedSortAlpha");

        //Setting up the quit button
        quitButton = new Button("Quit");
        window.addButton(quitButton, WindowSide.NORTH);
        quitButton.onClick(this, "clickedQuit");

        //Setting up the sort CFR button
        sortByCFR = new Button("Sort by CFR");
        window.addButton(sortByCFR, WindowSide.NORTH);
        sortByCFR.onClick(this, "clickedSortByCFR");

        //Setting up the DC button
        representDC = new Button("Represent DC");
        window.addButton(representDC, WindowSide.SOUTH);
        representDC.onClick(this, "clickedRepresentDC");

        //Setting up the GA button
        representGA = new Button("Represent GA");
        window.addButton(representGA, WindowSide.SOUTH);
        representGA.onClick(this, "clickedRepresentGA");

        //Setting up the MD button
        representMD = new Button("Represent MD");
        window.addButton(representMD, WindowSide.SOUTH);
        representMD.onClick(this, "clickedRepresentMD");

        //Setting up the NC button
        representNC = new Button("Represent NC");
        window.addButton(representNC, WindowSide.SOUTH);
        representNC.onClick(this, "clickedRepresentNC");

        //Setting up the TN button
        representTN = new Button("Represent TN");
        window.addButton(representTN, WindowSide.SOUTH);
        representTN.onClick(this, "clickedRepresentTN");

        //Setting up the VA button
        representVA = new Button("Represent VA");
        window.addButton(representVA, WindowSide.SOUTH);
        representVA.onClick(this, "clickedRepresentVA");
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

    /**
     * This will sort the linked list by race directly
     * and reorganize the list to the appropriate sort.
     *
     */
    private void sortAlphaList() {
        for (int i = 0; i < states.getLength(); i++) {
            LinkedList<Race> temp = states.getEntry(i).getRace();
            states.getEntry(i).setRace(temp.sortAlpha(0, temp.getLength()));
        }
    }

    /**
     * This will sort the linked list by CFR directly
     * and reorganize the list to the appropriate sort.
     * 
     */
    private void sortCFRList() {
        for (int i = 0; i < states.getLength(); i++) {
            LinkedList<Race> temp = states.getEntry(i).getRace();
            states.getEntry(i).setRace(temp.sortByCFR(0, temp.getLength()));
        }
    }

    /**
     * This checks which current State button was pressed
     * in order to refresh the according graphs to the
     * newly sorted versions when the sort button is called.
     * 
     */
    private void sortGraphing() {
        if (windowTitle.equals("DC Case Fatality Ratios by Race")) {
            clickedRepresentDC(representDC);
        } else if (windowTitle.equals("GA Case Fatality Ratios by Race")) {
            clickedRepresentGA(representGA);
        } else if (windowTitle.equals("MD Case Fatality Ratios by Race")) {
            clickedRepresentMD(representMD);
        } else if (windowTitle.equals("NC Case Fatality Ratios by Race")) {
            clickedRepresentNC(representNC);
        } else if (windowTitle.equals("TN Case Fatality Ratios by Race")) {
            clickedRepresentTN(representTN);
        } else if (windowTitle.equals("VA Case Fatality Ratios by Race")) {
            clickedRepresentVA(representVA);
        }
    }

    /**
     * This calls the private methods in order to sort the
     * graphs by race when the sortAlpha button is pressed.
     * 
     * @param sortAlpha
     *              This is the button that is pressed to sort
     *              by race.
     * 
     */
    public void clickedSortAlpha(Button sortAlpha) {
        sortAlphaList();
        sortGraphing();
    }

    /**
     * This calls the private methods in order to sort the
     * graphs by CFR when the sortByCFR button is pressed.
     * 
     * @param sortByCFR
     *              This is the button that is pressed to sort
     *              by ratio.
     * 
     */
    public void clickedSortByCFR(Button sortByCFR) {
        sortCFRList();
        sortGraphing();
    }

    /**
     * This adds a title to the window based on which
     * state was clicked.
     * 
     * @param stateName
     *              This is the state's name that is pressed and
     *              is used for the title.
     * 
     */
    private void windowTitle(String stateName) {
        //Makes a temp title object to check it's width
        windowTitle = stateName + " Case Fatality Ratios by Race";
        TextShape tempText = new TextShape(0, 0, windowTitle);

        //Creates a new title object and uses the previous width found from the tempText
        //and centers the title shape on the window. 
        TextShape textShape = new TextShape(window.getGraphPanelWidth() / 2 - tempText.getWidth() / 2, 
            20, windowTitle);
        window.addShape(textShape);
    } 

    /**
     * This displays the graphs for the given state
     * 
     * @param races
     *              This is the linked list of the corresponding races
     *              for the particular state that was chosen.
     * 
     */
    private void displayRaces(LinkedList<Race> races) {
        //First variable splits the window into six equal spacings for graphs
        //Second variable is multiplied to the xCoord to get the correct spacing
        int xCoord = window.getGraphPanelWidth() / states.getLength();
        int xMultiplier = 1;
        
        for (int i = 0; i < races.getLength(); i++) {
            //Multiplies the display factor by ratio to get differing heights for graphs
            int height = (int)(DISPLAY_FACTOR * races.getEntry(i).getRatio()); 

            //Sets label to NA if ratio is -1.0
            if (races.getEntry(i).getRatio() == -1.0) {
                TextShape invalid = new TextShape(xCoord * xMultiplier, 
                    window.getGraphPanelHeight() - 100, "NA");
                window.addShape(invalid);
            }

            //Creates a new rectangle and adds this to the window
            //Also adds the labels to each graph below by calling private method
            Shape shape = new Shape(xCoord * xMultiplier, 
                window.getGraphPanelHeight() - height - 100, WIDTH, 
                height, Color.blue); 
            window.addShape(shape);
            displayLabels(races, xCoord * xMultiplier, window.getGraphPanelHeight() - 50, i);
            xMultiplier++;
        }
    }

    /**
     * Creates the labels for each graph and adds them below
     * each graph.
     * 
     * @param races
     *              This is the list of races that the labels will be 
     *              created for. 
     * @param x     
     *              The x coordinate for placement
     * @param y     
     *              The y coordinate for placement
     * @param index     
     *              The index of the specific race
     */
    private void displayLabels(LinkedList<Race> races, int x, int y, int index) {
        TextShape raceShape = new TextShape(x - WIDTH / 2, y - 20, races.getEntry(index).getName()); 

        if (races.getEntry(index).getRatio() != -1.0) {
            TextShape ratioShape = new TextShape(x - WIDTH / 2, y, races.getEntry(index).getRatio() + "%");
            window.addShape(ratioShape);
        }
        window.addShape(raceShape);
    }

    /**
     * This creates the title, graphs, and labels for the 
     * respective state. Called when the state button is pressed.
     * 
     * @param representDC
     *              This is the button that was pressed.
     */
    public void clickedRepresentDC(Button representDC) {
        clear();
        windowTitle("DC");
        displayRaces(states.getEntry(0).getRace());
    }

    /**
     * This creates the title, graphs, and labels for the 
     * respective state. Called when the state button is pressed.
     * 
     * @param representGA
     *              This is the button that was pressed.
     */
    public void clickedRepresentGA(Button representGA) {
        clear();
        windowTitle("GA");
        displayRaces(states.getEntry(1).getRace());
    }

    /**
     * This creates the title, graphs, and labels for the 
     * respective state. Called when the state button is pressed.
     * 
     * @param representMD
     *              This is the button that was pressed.
     */
    public void clickedRepresentMD(Button representMD) {
        clear();
        windowTitle("MD");
        displayRaces(states.getEntry(2).getRace());
    }

    /**
     * This creates the title, graphs, and labels for the 
     * respective state. Called when the state button is pressed.
     * 
     * @param representNC
     *              This is the button that was pressed.
     */
    public void clickedRepresentNC(Button representNC) {
        clear();
        windowTitle("NC");
        displayRaces(states.getEntry(3).getRace());
    }

    /**
     * This creates the title, graphs, and labels for the 
     * respective state. Called when the state button is pressed.
     * 
     * @param representTN
     *              This is the button that was pressed.
     */
    public void clickedRepresentTN(Button representTN) {
        clear();
        windowTitle("TN");
        displayRaces(states.getEntry(4).getRace());
    }

    /**
     * This creates the title, graphs, and labels for the 
     * respective state. Called when the state button is pressed.
     * 
     * @param representVA
     *              This is the button that was pressed.
     */
    public void clickedRepresentVA(Button representVA) {
        clear();
        windowTitle("VA");
        displayRaces(states.getEntry(5).getRace());
    }

    /**
     * Clears the window of all shapes.
     * 
     */
    private void clear() {
        window.removeAllShapes();
    }
}