package Application.Entities;

/*

    Project     Programming21
    Package     Application.Entities    
    
    Version     1.0      
    Author      Carlos Pomares
    Date        2021-03-12

    DESCRIPTION
    
*/

/**
 * @author Carlos Pomares
 */

public class Client {

    /**
     * Identificador del cliente.
     */
    private final int id;
    /**
     * Primer nombre del cliente
     */
    private final String firstName;
    /**
     * Segundo nombre del cliente.
     */
    private final String secondName;
    /**
     * Primer apellido del cliente.
     */
    private final String firstLastname;
    /**
     * Segundo apellido del cliente.
     */
    private final String secondLastname;
    /**
     * Dirección del domicilio del cliente.
     */
    private final String streetAddress;
    /**
     * Dirección de correo electronico del cliente.
     */
    private final String mailAddress;
    /**
     * Número de teléfono del cliente.
     */
    private final String phoneNumber;

    /**
     *
     * Entidad cliente, consta de diferentes parámetros.
     *
     * @param id el id.
     * @param firstName el primer nombre.
     * @param secondName el segundo nombre.
     * @param firstLastname el primer apellido.
     * @param secondLastname el segundo apellido.
     * @param streetAddress la dirección del domilicio.
     * @param mailAddress la dirección de correo electrónico.
     * @param phoneNumber el número de teléfono.
     */
    public Client(int id, String firstName, String secondName, String firstLastname, String secondLastname, String streetAddress, String mailAddress, String phoneNumber) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.firstLastname = firstLastname;
        this.secondLastname = secondLastname;
        this.streetAddress = streetAddress;
        this.mailAddress = mailAddress;
        this.phoneNumber = phoneNumber;
    }

    public int getId() {
        return id;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getFirstLastname() {
        return firstLastname;
    }
    public String getSecondLastname() {
        return secondLastname;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getMailAddress() {
        return mailAddress;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }

}
