/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package assignment4;

/**
 *
 * @author anastasia
 */
import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
public class JVacationRental extends JFrame implements ItemListener {
    
    // starter code from the problem, it declares and initializes the 
    // user interface (UI) components such as checkboxes, text fields, 
    // and button groups for the vacation rental program.
    // it will later be added to a frame for display.
    FlowLayout flow = new FlowLayout(); 
    String companyName = new String("Lambert's Vacation Rentals"); 
    Font bigFont = new Font("Arial", Font.PLAIN, 24); 
    final int PARKPRICE = 600, POOLPRICE = 750, LAKEPRICE = 825; 
    int totalPrice = 0; 
    ButtonGroup locationGrp = new ButtonGroup(); 
    JCheckBox parkBox = new JCheckBox("Parkside", false); 
    JCheckBox poolBox = new JCheckBox("Poolside", false); 
    JCheckBox lakeBox = new JCheckBox("Lakeside", false); 
    final int ONEPRICE = 0, TWOPRICE = 75, THREEPRICE = 150; 
    ButtonGroup bdrmGrp = new ButtonGroup(); 
    JCheckBox oneBox = new JCheckBox("1 bedroom", false); 
    JCheckBox twoBox = new JCheckBox("2 bedrooms", false); 
    JCheckBox threeBox = new JCheckBox("3 bedrooms", false); 
    final int NOMEALSPRICE = 0, MEALSPRICE = 200; 
    ButtonGroup mealGrp = new ButtonGroup(); 
    JCheckBox noMealsBox = new JCheckBox("No meals", false); 
    JCheckBox mealsBox = new JCheckBox("Meals included", false); 
    JTextField totPrice = new JTextField(10); 
    String output; 
    
    // making the constructor for the JVacationRental class
    public JVacationRental() { 
        super("Vacation Rentals");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flow);
        
        // setting the label of the company name to companyName that holds
        // the value "Lambert's Vacation Rentals", afterwards adding it to the frame
        JLabel companyLabel = new JLabel(companyName);
        companyLabel.setFont(bigFont);
        add(companyLabel);
        
        // Setting the location boxes
        add(new JLabel("Location:"));
        // this portion is for checkboxes. adding the parkBox, poolBox & lakeBox
        locationGrp.add(parkBox);
        locationGrp.add(poolBox);
        locationGrp.add(lakeBox);
        // now the it is added to the frame, afterwards the item listener is
        // also added to each of it.
        add(parkBox);
        add(poolBox);
        add(lakeBox);
        parkBox.addItemListener(this);
        poolBox.addItemListener(this);
        lakeBox.addItemListener(this);
        
        // this is similar to the previous one. It is for the number of bedrooms
        // hence why it is labeled with Bedrooms.Same as previous, we add it to
        // the frame, and we add the item listener to each.Note that we are
        // adding it to the group to make sure it is only 1 box that can be checked
        add(new JLabel("Bedrooms:"));
        bdrmGrp.add(oneBox);
        bdrmGrp.add(twoBox);
        bdrmGrp.add(threeBox);
        add(oneBox);
        add(twoBox);
        add(threeBox);
        oneBox.addItemListener(this);
        twoBox.addItemListener(this);
        threeBox.addItemListener(this);
        
        // now it is for the meals. So the options are if there is meals included
        // or no meals included. Afterwards, add it to the frame and not forget
        // to add the item listener. Note that we are adding it to the group
        // to make sure it is only 1 box that can be checked
        add(new JLabel("Meals:"));
        mealGrp.add(noMealsBox);
        mealGrp.add(mealsBox);
        add(noMealsBox);
        add(mealsBox);
        noMealsBox.addItemListener(this);
        mealsBox.addItemListener(this);
        
        // this is for the total price. Also very important to make sure it is
        // NOT editable (hence why it is set to false). Otherwise, the whole
        // program was for nothing if the price could be edited
        add(new JLabel("Total Price:"));
        totPrice.setEditable(false);
        add(totPrice);

    } 

    public static void main(String[] arguments) { 

        // calling the class constructor, creating new
        // and naming it as frame. Also creating the size and making  
        // the frame visible
        JVacationRental frame = new JVacationRental(); 
        frame.setSize(320, 200); 
        frame.setVisible(true); 

    } 

    // For this method, it is called when an event occurs 
    // when the state of an item in a component that 
    // implements the ItemSelectable interface changes (in this case
    // the checkboxes)
    @Override 
    public void itemStateChanged(ItemEvent check) { 
        // Get the new state of the item that triggered the event 
        // (ItemEvent.SELECTED or ItemEvent.DESELECTED).
        int select = check.getStateChange(); 

        // this is the condition check, if an item has been selected
        if(select == ItemEvent.SELECTED){
       
            // creating a new label for the total price, and make sure that totPrice
            // (total price) is set to not editable and then add it to the frame
            add(new JLabel("Total Price:"));
            totPrice.setEditable(false);
            add(totPrice);
            
            // this for the place portion of the checkbox. It checks if the
            // user picks either park, pool or lake. Each box corresponds with the
            // defined price for it, and then that price is added to the total price
            if (parkBox.isSelected()) {
                totalPrice += PARKPRICE;
            } else if (poolBox.isSelected()) {
                totalPrice += POOLPRICE;
            } else if (lakeBox.isSelected()) {
                totalPrice += LAKEPRICE;
            }
            
            // this one if for the portion of how many bedrooms. User can pick
            // one, two, or three bedrooms. Each has its own price as well, and
            // the price of it will be added to the total price
            if (oneBox.isSelected()) {
                totalPrice += ONEPRICE;
            } else if (twoBox.isSelected()) {
                totalPrice += TWOPRICE;
            } else if (threeBox.isSelected()) {
                totalPrice += THREEPRICE;
            }
            
            // this one is if the user picks for a meal package included or not
            // it will then be added to the total price as well
            if (noMealsBox.isSelected()) {
                totalPrice += NOMEALSPRICE;
            } else if (mealsBox.isSelected()) {
                totalPrice += MEALSPRICE;
            }
            
            // update the total price text field with the calculated total.
            totPrice.setText("$" + totalPrice);
           
       }

    }

} 