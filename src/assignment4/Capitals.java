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

import java.util.HashMap;

public class Capitals extends JFrame implements ActionListener {
    
    JComboBox<String> countryList;
    JLabel resultLabel;
    HashMap<String, String> countryCapitalMap;
    
    // constructor for the class
    public Capitals() {
        setTitle("Capital of a Country");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());

        // initialize HashMap with Country-Capital pairs. Using a hashmap
        // because of the key-value pair and in this case is the country & capital
        // which will always be true. Afterwards, just putting the country and
        // it's corresponding capital in the hashmap
        countryCapitalMap = new HashMap<>();
        countryCapitalMap.put("Austria", "Vienna");
        countryCapitalMap.put("Canada", "Toronto"); 
        countryCapitalMap.put("England", "London");
        countryCapitalMap.put("France", "Paris");
        countryCapitalMap.put("Italy", "Rome");
        countryCapitalMap.put("Brazil", "Brasilia");
        countryCapitalMap.put("India", "New Delhi");

        // create the combo box with country names
        // getting the country names from the countryCapitalMap's keys
        // and storing them in a String array named "countries".
        // create the combo box (dropdown list) using the country names from the "countries" array.
        // add the combo box to the frame.
        String[] countries = countryCapitalMap.keySet().toArray(new String[0]);
        countryList = new JComboBox<>(countries);
        add(countryList);

        // creating the result label, also including "select a country"
        resultLabel = new JLabel("Select a country");
        add(resultLabel);

        // Add action listener to the combo box
        countryList.addActionListener(this);

        // setting the size and making it visible to the user
        setSize(250, 150);
        setVisible(true);
    }
    public static void main(String[] args) {
        Capitals capitals = new Capitals();
    }

    // For this method, it is called when an action occurs on a 
    // component that this class is listening to (countryList as per written above).
    @Override
    public void actionPerformed(ActionEvent e) {
        
        // first, get the country that is selected from the combo box. that country
        // will be stored in the selectedCountry variable as string.
        // afterwards, the selectedCountry will be used as the input to get the
        // corresponding capital as stored in the hashmap. The name of the capital
        // will then be stored in the capital string variable. next, it will check 
        // that in the case the capital has a value (not null), it will update the 
        // text of the resultLabel using the setText method to display the selected 
        // country and its capital. It prints out the name of the country that the  
        // user selected and the name of the corresponding capital city.
        String selectedCountry = (String) countryList.getSelectedItem();
        String capital = countryCapitalMap.get(selectedCountry); 
        if (capital != null) {
            resultLabel.setText("The capital of " + selectedCountry + " is " + capital);
        } 
    }
    
}
