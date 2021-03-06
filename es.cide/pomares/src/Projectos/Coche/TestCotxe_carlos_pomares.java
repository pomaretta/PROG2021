package Projectos.Coche;

/*

    Project     Programming21
    Package     Projectos.Coche    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2020-12-04

    DESCRIPTION
    
*/

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Carlos Pomares
 */


public class TestCotxe_carlos_pomares {

    final private static ArrayList<Cotxe_carlos_pomares> COTXES = new ArrayList<>();
    final private static ArrayList<String> ORDRES = new ArrayList<>();
    final private static ArrayList<String> ERRORS = new ArrayList<>();
    final private static Scanner USER_IN = new Scanner(System.in);

    private static Cotxe_carlos_pomares vehicleSeleccionat;

    private static void menuPrincipal(){

        boolean exit = false;

        String[] opcions = new String[]{"Crear vehicle","Generar vehicles","Seleccionar vehicle","Conduir vehicle","Credits","Sortir"};

        System.out.printf("\t========= %s =========\n","Bienvenido");

        while(!exit){

            if(vehicleSeleccionat != null){
                informacioVehicle();
            }

            System.out.printf("\n\n\t%-15s %-30s\n",
                    "Nombre","Opcio");

            for (int i = 0; i < opcions.length ; i++) {
                if(vehicleSeleccionat != null){
                    System.out.printf("\t%-15d %-30s\n",(i + 1),opcions[i]);
                } else {
                    if(!"Conduir vehicle".equals(opcions[i])){
                        System.out.printf("\t%-15d %-30s\n",(i + 1),opcions[i]);
                    }
                }
            }

            System.out.print("\n\tOrdre: ");

            try {
                switch (Integer.parseInt(USER_IN.nextLine())){
                    case 1 -> crearVehicle();
                    case 2 -> generarVehicles();
                    case 3 -> seleccionarVehicle();
                    case 4 -> {
                        if(vehicleSeleccionat != null){
                            conduirVehicle();
                        }
                    }
                    case 5 -> author();
                    case 6 -> exit = true;
                    default -> System.out.println("Selecciona una opcio.");
                }
            } catch (Exception e){
                ERRORS.add(e.getMessage());
            }
        }
        System.out.print("\n\t========= END MAIN MENU =========\n");
    }

    private static void crearVehicle(){

        String[] datos = new String[]{"Marca","Model","Transmissio","Descapotable"};
        String marca = "marca",model = "model",canvi = "transmissio",descapotable = "descapotable";
        TipusCanvi tCanvi = TipusCanvi.CanviAutomatic;
        boolean isDescapotable = false;

        String[] opcions = new String[]{
                "Siguiente", "Introducir", "Ejecutar", "Borrar errors", "Salir"
        };

        int selected = 1;
        boolean exit = false;
        boolean created = false;

        System.out.print("\n\t========= Creacio de vehicle =========\n");


        while(!exit){
            try {

                if(canvi.equalsIgnoreCase("manual")){
                    tCanvi = TipusCanvi.CanviManual;
                } else if(canvi.equalsIgnoreCase("automatic") || canvi.equalsIgnoreCase("automatico") || canvi.equalsIgnoreCase("automatica")){
                    canvi = "automatico";
                    tCanvi = TipusCanvi.CanviAutomatic;
                } else {
                    canvi = "manual";
                }

                if(descapotable.equalsIgnoreCase("si") || descapotable.equalsIgnoreCase("true")){
                    isDescapotable = true;
                    descapotable = "true";
                } else {
                    descapotable = "false";
                }

                // MARCA
                System.out.printf("\n\n\t---------- %s ----------\n","MARCA");

                if(selected == 1){
                    Encapsulate.encapsulateString(ConsoleColorsLite.GREEN_BOLD,marca,"\t\t","-");
                } else {
                    System.out.printf("\t\t%s",marca);
                }

                // MODELO
                System.out.printf("\n\t---------- %s ----------\n","MODELO");

                if(selected == 2){
                    Encapsulate.encapsulateString(ConsoleColorsLite.GREEN_BOLD,model,"\t\t","-");
                } else {
                    System.out.printf("\t\t%s",model);
                }

                // CANVI
                System.out.printf("\n\t---------- %s ----------\n","TIPUS CANVI");

                if(selected == 3){
                    Encapsulate.encapsulateString(ConsoleColorsLite.GREEN_BOLD,canvi,"\t\t","-");
                } else {
                    System.out.printf("\t\t%s",canvi);
                }

                // DESCAPOTABLE
                System.out.printf("\n\t---------- %s ----------\n","DESCAPOTABLE");

                if(selected == 4){
                    Encapsulate.encapsulateString(ConsoleColorsLite.GREEN_BOLD,descapotable,"\t\t","-");
                } else {
                    System.out.printf("\t\t%s",descapotable);
                }

                System.out.print("\n\n");

                if(ERRORS.size() != 0){
                    informeErrors();
                }

                if(created){
                    informacioVehicle(marca,model,tCanvi,isDescapotable);
                    System.out.print("\n\n");
                }

                // OPCIONS
                for (int i = 0; i < opcions.length; i++) {
                    System.out.printf("\t(%d) %s",
                            (i + 1),opcions[i]);
                }

                System.out.print("\n\n\tOrden: ");

                // (1)
                switch (Integer.parseInt(USER_IN.nextLine())){
                    case 1 -> {
                        if(selected == 4){
                            selected = 1;
                        } else {
                            selected++;
                        }
                    }
                    case 2 -> {
                        System.out.printf("\n\tIntroduce el nuevo valor de (%s): ",datos[selected - 1]);
                        switch (selected){
                            case 1 -> marca = USER_IN.nextLine();
                            case 2 -> model = USER_IN.nextLine();
                            case 3 -> canvi = USER_IN.nextLine();
                            case 4 -> descapotable = USER_IN.nextLine();
                        }
                    }
                    case 3 -> {
                        COTXES.add(new Cotxe_carlos_pomares(marca,model,tCanvi,isDescapotable));
                        created = true;
                    }
                    case 4 -> ERRORS.clear();
                    case 5 -> exit = true;
                    default -> ERRORS.add("Creacio de vehicles. Opcio incorrecta.");
                }

                // informacioVehicle(marca,model,tCanvi,isDescapotable);
            } catch (Exception e){
                ERRORS.add(e.getMessage());
            }
        }

        System.out.print("\n\n\t========= END MODULE =========\n");

    }

    private static void generarVehicles(){
        // Default vehicles
        Cotxe_carlos_pomares lamborghini = new Cotxe_carlos_pomares("Lamborghini","Gallardo",TipusCanvi.CanviAutomatic,false);
        Cotxe_carlos_pomares fiat = new Cotxe_carlos_pomares("Fiat","500S",TipusCanvi.CanviManual,false);
        Cotxe_carlos_pomares mercedes = new Cotxe_carlos_pomares("Mercedes","McLaren",TipusCanvi.CanviAutomatic,true);
        COTXES.add(lamborghini);
        COTXES.add(fiat);
        COTXES.add(mercedes);
    }

    private static void seleccionarVehicle(){

        System.out.print("\n\t========= Seleccio de vehicle =========\n");

        System.out.printf("\n\t%-6s %-15s %-10s %-20s %-10s\n",
                "Nombre","Marca",
                "Model","Tipus canvi",
                "Descapotable");

        // Mostrar vehicles
        for(Cotxe_carlos_pomares vehicle : COTXES){
            System.out.printf("\t%-6d %-15s %-10s %-20s %-10b\n",
                    (COTXES.indexOf(vehicle) + 1),vehicle.getBrand(),
                    vehicle.getModel(),vehicle.getTransmissionType(),
                    vehicle.getConvertible());
        }

        // Donar seleccio
        int seleccio;

        System.out.print("\n\tOrdre: ");
        seleccio = Integer.parseInt(USER_IN.nextLine());

        for (int i = 0; i < COTXES.size(); i++) {
            if((seleccio - 1) == i){
                vehicleSeleccionat = COTXES.get(i);
                ORDRES.clear();
                ERRORS.clear();
            }
        }

        System.out.print("\n\t========= END SELECT MENU =========\n");
    }

    private static void conduirVehicle(){

        String[] opcions = new String[]{
            "Arrancar","Aturar","Accelerar","Frenar","Pujar marxa","Baixar marxa","Posar marxa enrrera","Configurar vehicle","Borrar ordres i Errors","Sortir"
        };

        boolean exit = false;

        System.out.print("\n\t========= Conduccio de Vehicle =========\n");

        while(!exit){
            try {

                informacioVehicle();
                informacioEstadistiques();
                informacioComponents();
                historialOrdres();
                if(ERRORS.size() != 0){
                    informeErrors();
                }

                // Mostrar opcions
                for (int i = 0; i < opcions.length ; i++) {
                    if(vehicleSeleccionat.comprovaMotor() == EstatsMotorCotxe.EnMarxa){
                        if(!"Arrancar".equals(opcions[i])) {
                            if(vehicleSeleccionat.tipuscanvi == TipusCanvi.CanviManual){
                                System.out.printf("\t(%d) %s",
                                        (i + 1), opcions[i]);
                            } else {
                                if(!"Pujar marxa".equals(opcions[i]) && !"Baixar marxa".equals(opcions[i])){
                                    System.out.printf("\t(%d) %s",
                                            (i + 1), opcions[i]);
                                }
                            }

                        }
                    } else {
                        if("Arrancar".equals(opcions[i]) || "Configurar vehicle".equals(opcions[i]) || "Sortir".equals(opcions[i])) {
                            System.out.printf("\t(%d) %s",
                                    (i + 1), opcions[i]);
                        }
                    }

                }

                System.out.print("\n\n\tOrdre: ");

                switch (Integer.parseInt(USER_IN.nextLine())){
                    case 1 -> {
                        ORDRES.add("Arrancar motor.");
                        vehicleSeleccionat.arrancarMotor();
                    }
                    case 2 -> {
                        ORDRES.add("Aturar.");
                        vehicleSeleccionat.aturarMotor();
                    }
                    case 3 -> {
                        ORDRES.add("Accelerar.");
                        vehicleSeleccionat.accelerate();
                    }
                    case 4 -> {
                        ORDRES.add("Frenar.");
                        vehicleSeleccionat.deccelerate();
                    }
                    case 5 -> {
                        if(vehicleSeleccionat.tipuscanvi == TipusCanvi.CanviManual){
                            ORDRES.add("Pujar marxa.");
                            vehicleSeleccionat.gearUp();
                        } else {
                            throw new RuntimeException("No disponible en automatic.");
                        }
                    }
                    case 6 -> {
                        if(vehicleSeleccionat.tipuscanvi == TipusCanvi.CanviManual){
                            ORDRES.add("Baixar marxa.");
                            vehicleSeleccionat.gearDown();
                        }  else {
                            throw new RuntimeException("No disponible en automatic.");
                        }
                    }
                    case 7 -> {
                        ORDRES.add("Posar/Quitar marxa enrrera");
                        if(vehicleSeleccionat.canPutReverse()){
                            vehicleSeleccionat.gearDown();
                        } else if(vehicleSeleccionat.getReverse()){
                            vehicleSeleccionat.gearUp();
                        } else {
                            throw new RuntimeException("No pot posar marxa enrrera.");
                        }
                    }
                    case 8 -> {
                        ORDRES.add("Configurar vehicle.");
                        configuracioVehicle();
                    }
                    case 9 -> {
                        ORDRES.clear();
                        ERRORS.clear();
                    }
                    case 10 -> exit = true;
                    default -> System.out.println("Opcio incorrecte.");
                }

            } catch (Exception e){
                ERRORS.add(e.getMessage());
            }
        }

        System.out.print("\n\t========= END MODULE =========\n");
    }

    private static void configuracioVehicle() {

        String[] opcions = new String[]{
                "Aire acondicionat","Capota","Limpia parabrisas","Sortir"
        };

        System.out.print("\n\t========= Configuracio de Components =========\n");

        boolean exit = false;

        while(!exit) {


            informacioComponents();
            if(ERRORS.size() != 0){
                informeErrors();
            }

            for (int i = 0; i < opcions.length; i++) {
                if(vehicleSeleccionat.getConvertible()){
                    System.out.printf("\t(%d) %s",(i+1),opcions[i]);
                } else {
                    if(!"Capota".equals(opcions[i])){
                        System.out.printf("\t(%d) %s",(i+1),opcions[i]);
                    }
                }
            }
            
            System.out.print("\n\n\tOrdre: ");

            try {
                switch (Integer.parseInt(USER_IN.nextLine())){
                    case 1 -> vehicleSeleccionat.changeAirLevel();
                    case 2 -> {
                        if (vehicleSeleccionat.getHoodState()){
                            vehicleSeleccionat.takeOffHood();
                        } else {
                            vehicleSeleccionat.putHood();
                        }
                    }
                    case 3 -> vehicleSeleccionat.changeWindScreenLevel();
                    case 4 -> exit = true;
                    default -> System.out.println("Opcio incorrecte.");
                }
            } catch (Exception e){
                ERRORS.add(e.getMessage());
            }
        }

        System.out.print("\n\t========= END MODULE =========\n");

    }

    private static void author(){

        System.out.printf("\n\t========= %s =========\n",ConsoleColorsLite.stringColor(ConsoleColorsLite.CYAN_BOLD,"Credits de l'autor"));

        /*

            Gracias por probar esta aplicacion
            espero que te haya gustado y te haya
            servido de inspiracion, lo he hecho
            con carino y he intentado aplicar
            nuevos conocimientos.

            Gracias, Carlos Pomares

            github.com/pomaretta

         */

        System.out.print("\t   ______________________________\n" +
                "\t / \\                             \\.\n" +
                "\t|   |                            |.\n" +
                "\t \\_ |  Gracias por probar        |.\n" +
                "\t    |  esta aplicación,          |.\n" +
                "\t    |  espero que te haya        |.\n" +
                "\t    |  gustado y te haya         |.\n" +
                "\t    |  servido de inspiración,   |.\n" +
                "\t    |  lo he hecho con cariño    |.\n" +
                "\t    |  y he intentado aplicar    |.\n" +
                "\t    |  nuevos conocimientos      |.\n" +
                "\t    |                            |.\n" +
                "\t    |  Gracias, Carlos Pomares   |.\n" +
                "\t    |                            |.\n" +
                "\t    |  github.com/pomaretta      |.\n" +
                "\t    |                            |.\n" +
                "\t    |  https://carlospomares.es  |.\n" +
                "\t    |                            |.\n" +
                "\t    |   _________________________|___\n" +
                "\t    |  /                            /.\n" +
                "\t    \\_/____________________________/.\n\n");

    }

    private static void informacioVehicle(){
        // Mostrar vehicle
        // MARCA - MODEL - TIPUS CANVI - DESCAPOTABLE
        System.out.printf("\n\t------------------------ %s ---------------------------",ConsoleColorsLite.stringColor(ConsoleColorsLite.GREEN,"VEHICLE"));

        System.out.printf("\n\t%-15s %-15s %-15s %-15s",
                "MARCA","MODEL",
                "TIPUS CANVI","DESCAPOTABLE");

        System.out.printf("\n\t%-15s %-15s %-15s %-15b",
                vehicleSeleccionat.getBrand(),vehicleSeleccionat.getModel(),
                vehicleSeleccionat.getTransmissionType(),vehicleSeleccionat.getConvertible());

        System.out.print("\n\t------------------------------------------------------------");
    }
    private static void informacioVehicle(String marca, String model, TipusCanvi canvi, boolean descapotable){
        // Mostrar vehicle
        // MARCA - MODEL - TIPUS CANVI - DESCAPOTABLE
        System.out.printf("\n\t------------------------ %s ---------------------------",ConsoleColorsLite.stringColor(ConsoleColorsLite.GREEN,"VEHICLE"));

        System.out.printf("\n\t%-15s %-15s %-15s %-15s",
                "MARCA","MODEL",
                "TIPUS CANVI","DESCAPOTABLE");

        System.out.printf("\n\t%-15s %-15s %-15s %-15b",
                marca,model,
                canvi,descapotable);

        System.out.print("\n\t------------------------------------------------------------");
    }
    private static void informacioEstadistiques(){
        // Mostrar estadisticas
        // VELOCITAT - REVOLUCIONS - MARXA ACTUAL - REVERSE
        System.out.printf("\n\t--------------------- %s ------------------------",
                ConsoleColorsLite.stringColor(ConsoleColorsLite.CYAN,"ESTADISTIQUES"));

        System.out.printf("\n\t%-15s %-15s %-15s %-15s",
                "VELOCITAT","REVOLUCIONS",
                "MARXA ACTUAL","ESTATUS");

        String marxa;
        if(vehicleSeleccionat.getReverse()){
            marxa = "R";
        } else {
            marxa = String.valueOf(vehicleSeleccionat.getGear());
        }

        System.out.printf("\n\t%-15s %-15s %-15s %-15s",
                vehicleSeleccionat.getVelocity(),vehicleSeleccionat.getRevolutions(),
                marxa,vehicleSeleccionat.comprovaMotor());

        System.out.print("\n\t------------------------------------------------------------");
    }
    private static void informacioComponents(){
        // CONFIGURACIO (SI)
        // AIRE ACON - VELOCITAT
        // CAPOTA - PUESTA
        // LIMPIA - VELOCITAT
        System.out.printf("\n\t---------------------- %s ------------------------",
                ConsoleColorsLite.stringColor(ConsoleColorsLite.YELLOW,"CONFIGURACIO"));

        System.out.printf("\n\t%-20s %-15s",
                "COMPONENT","VELOCITAT");

        for(Map.Entry<String,Integer> entry : vehicleSeleccionat.getComponents().entrySet()){
            System.out.printf("\n\t%-20s %-15d",
                    entry.getKey(),entry.getValue());
        }

        System.out.print("\n\t------------------------------------------------------------\n\n");
    }
    private static void historialOrdres(){
        // ORDRE ANTERIOR
        System.out.print("\t-------------------------- ORDRES --------------------------");

        for (int i = 0; i < ORDRES.size(); i++) {
            System.out.printf("\n\t%-10s %-15s",
                    (i+1), ConsoleColorsLite.stringColor(ConsoleColorsLite.GREEN_BOLD,ORDRES.get(i)));
        }

        System.out.print("\n\t------------------------------------------------------------\n\n");

    }
    private static void informeErrors(){
        // Si hi ha errors en la conduccio surten
        System.out.print("\t-------------------------- ERRORS --------------------------");

        for (int i = 0; i < ERRORS.size(); i++) {
            System.out.printf("\n\t%-10s %-15s",
                    (i+1), ConsoleColorsLite.stringColor(ConsoleColorsLite.RED_BOLD,ERRORS.get(i)));
        }

        System.out.print("\n\t------------------------------------------------------------\n\n");
    }

    public static void main(String[] args) {
        menuPrincipal();
    }
}
