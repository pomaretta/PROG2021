package Application;

/*

    Project     Programming21
    Package     Application    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-03-18

    DESCRIPTION
    
*/

import Application.Services.Console.OrderConsole;

/**
 * @author Carlos Pomares
 */

public class OrderManager {

    private final OrderConsole orderConsole = new OrderConsole();

    public void run(){
        this.orderConsole.start();
    }

    public static void main(String[] args) {
        OrderManager gs = new OrderManager();
        gs.run();
    }

}
