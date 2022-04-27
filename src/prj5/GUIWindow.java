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
    public static final int WIDTH = 20;
    public static final int DISPLAY_FACTOR = 20;

    /**
     * THis is the default constructor for the class
     */
    public GUIWindow(LinkedList<State> state) {
        window = new Window();
        window.setSize(500, 500);
        // This method will set up all the buttons
        setUpButtons();
        states = state;
        windowTitle = "";
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
    
    private void sortAlphaList() {
        for (int i = 0; i < states.getLength(); i++) {
            LinkedList<Race> temp = states.getEntry(i).getRace();
            states.getEntry(i).setRace(temp.sortAlpha(0, temp.getLength()));
        }
    }
    
    private void sortCFRList() {
        for (int i = 0; i < states.getLength(); i++) {
            LinkedList<Race> temp = states.getEntry(i).getRace();
            states.getEntry(i).setRace(temp.sortByCFR(0, temp.getLength()));
        }
    }
    
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
    
    public void clickedSortAlpha(Button sortAlpha) {
        sortAlphaList();
        sortGraphing();
    }
    
    public void clickedSortByCFR(Button sortByCFR) {
        sortCFRList();
        sortGraphing();
    }
    
    private void windowTitle(String stateName) {
        windowTitle = stateName + " Case Fatality Ratios by Race";
        TextShape tempText = new TextShape(0, 0, windowTitle);
        
        TextShape textShape = new TextShape(window.getGraphPanelWidth() / 2 - tempText.getWidth() / 2, 
            20, windowTitle);
        window.addShape(textShape);
    } 
    
    private void displayRaces(LinkedList<Race> races) {
        int xCoord = window.getGraphPanelWidth() / 6;
        
        int xMultiplier = 1;
        for (int i = 0; i < races.getLength(); i++) {
            int height = (int)(DISPLAY_FACTOR * races.getEntry(i).getRatio()); 
            
            if (races.getEntry(i).getRatio() == -1.0) {
                TextShape invalid = new TextShape(xCoord * xMultiplier, 
                    window.getGraphPanelHeight() - 100, "NA");
                window.addShape(invalid);
            }
            
            Shape shape = new Shape(xCoord * xMultiplier, 
                window.getGraphPanelHeight() - height - 100, WIDTH, 
                height, Color.blue); 
            window.addShape(shape);
            displayLabels(races, xCoord * xMultiplier, window.getGraphPanelHeight() - 50, i);
            xMultiplier++;
        }
    }
    
    private void displayLabels(LinkedList<Race> races, int x, int y, int index) {
            TextShape raceShape = new TextShape(x - WIDTH / 2, y - 20, races.getEntry(index).getName()); 
            
            if (races.getEntry(index).getRatio() != -1.0) {
                TextShape ratioShape = new TextShape(x - WIDTH / 2, y, races.getEntry(index).getRatio() + "%");
                window.addShape(ratioShape);
            }
            window.addShape(raceShape);
    }
    
    public void clickedRepresentDC(Button representDC) {
        clear();
        windowTitle("DC");
        displayRaces(states.getEntry(0).getRace());
    }
    
    public void clickedRepresentGA(Button representGA) {
        clear();
        windowTitle("GA");
        displayRaces(states.getEntry(1).getRace());
    }
    
    public void clickedRepresentMD(Button representMD) {
        clear();
        windowTitle("MD");
        displayRaces(states.getEntry(2).getRace());
    }
    
    public void clickedRepresentNC(Button representNC) {
        clear();
        windowTitle("NC");
        displayRaces(states.getEntry(3).getRace());
    }
    
    public void clickedRepresentTN(Button representTN) {
        clear();
        windowTitle("TN");
        displayRaces(states.getEntry(4).getRace());
    }
    
    public void clickedRepresentVA(Button representVA) {
        clear();
        windowTitle("VA");
        displayRaces(states.getEntry(5).getRace());
    }
    
    private void clear() {
        window.removeAllShapes();
    }

}
