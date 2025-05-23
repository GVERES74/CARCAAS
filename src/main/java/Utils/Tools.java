/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utils;

import javafx.stage.Screen;


/**
 *
 * @author djver
 */
public class Tools {

    public Double screenWidth;
    public Double screenHeight;
            
            
public void Tools(){
    screenWidth = Screen.getPrimary().getVisualBounds().getWidth(); 
    screenHeight = Screen.getPrimary().getVisualBounds().getHeight();     
}    
 
    
}
