package Application.Services.Console.Components.Menu;

/*

    Project     Programming21
    Package     Application.Services.Console.Components.Menu    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-03-18

    DESCRIPTION
    
*/

import Application.Services.Console.Components.Command.CommandParser;
import Application.Services.Console.Components.Error.ErrorLog;

import java.io.BufferedReader;

/**
 * @author Carlos Pomares
 */

public abstract class SelectionInteractiveMenu extends DefaultInteractiveMenu {

    protected SelectionMenu selectionMenu;

    public SelectionInteractiveMenu(ErrorLog e, DefaultMenu o, CommandParser p, BufferedReader r, String s, SelectionMenu selection) {
        super(e, o, p, r, s);
        this.selectionMenu = selection;
    }

    @Override
    protected void loopBlock() {
        selectionMenu.show();
        optionMenu.show();
    }

}
