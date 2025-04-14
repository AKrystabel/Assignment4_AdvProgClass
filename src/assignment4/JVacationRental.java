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
    
    
    public JVacationRental() { 
        super("Vacation Rentals");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(flow);
        
        //Setting the label of the company name to companyName that holds
        // the value "Lambert's Vacation Rentals"
        JLabel companyLabel = new JLabel(companyName);
        companyLabel.setFont(bigFont);
        add(companyLabel);
        
        // Setting the location boxes
        add(new JLabel("Location:"));
        locationGrp.add(parkBox);
        locationGrp.add(poolBox);
        locationGrp.add(lakeBox);
        add(parkBox);
        add(poolBox);
        add(lakeBox);
        parkBox.addItemListener(this);
        poolBox.addItemListener(this);
        lakeBox.addItemListener(this);
        
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
        
        add(new JLabel("Meals:"));
        mealGrp.add(noMealsBox);
        mealGrp.add(mealsBox);
        add(noMealsBox);
        add(mealsBox);
        noMealsBox.addItemListener(this);
        mealsBox.addItemListener(this);
        
        add(new JLabel("Total Price:"));
        totPrice.setEditable(false);
        add(totPrice);

    } 

    public static void main(String[] arguments) { 

        JVacationRental frame = new JVacationRental(); 
        frame.setSize(320, 200); 
        frame.setVisible(true); 

    } 

    @Override 
    public void itemStateChanged(ItemEvent check) { 
       int select = check.getStateChange(); 

       if(select == ItemEvent.SELECTED){
       
            add(new JLabel("Total Price:"));
            totPrice.setEditable(false);
            add(totPrice);
            
            if (parkBox.isSelected()) {
                totalPrice += PARKPRICE;
            } else if (poolBox.isSelected()) {
                totalPrice += POOLPRICE;
            } else if (lakeBox.isSelected()) {
                totalPrice += LAKEPRICE;
            }
            
            if (oneBox.isSelected()) {
                totalPrice += ONEPRICE;
            } else if (twoBox.isSelected()) {
                totalPrice += TWOPRICE;
            } else if (threeBox.isSelected()) {
                totalPrice += THREEPRICE;
            }
            
            if (noMealsBox.isSelected()) {
                totalPrice += NOMEALSPRICE;
            } else if (mealsBox.isSelected()) {
                totalPrice += MEALSPRICE;
            }
            
            totPrice.setText("$" + totalPrice);
           
       }

    }

} 