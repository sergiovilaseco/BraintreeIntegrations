package Factory;


import Commands.AddPaymentMethod.AddPaymentMethod;
import Commands.CCAuthorization.CCAuthorization;
import Commands.CCAuthorization.UpdateCCAuthorization;
import Commands.ClientToken.newClientToken;
import Commands.Command;
import Commands.DropInUI.DropInUI;
import Commands.HostedFields.HostedFields;
import Commands.PPAuthorization.PPAuthorization;
import Commands.PPAuthorization.UpdatePPAuthorization;
import Commands.PayPalCheckout.PayPalCheckout;


public class CommandFactory {

    public Command createCommand(String action) {
        Command command = null;

        // Selecting the action
        switch (action) {
            // Generate new client Token
            case "newclienttoken":
                command = new newClientToken();
                break;
            // PayPak checkout
            case "paypalcheckout":
                command = new PayPalCheckout();
                break;
            // DropI  UI
            case "dropinui":
                command = new DropInUI();
                break;
            // Hosted Fields
            case "hostedfields":
                command = new HostedFields();
                break;
            // CC Authorization
            case "ccauthorization":
                command = new CCAuthorization();
                break;
            // UpdateCCAuthorization
            case "updateccauthorization":
                command = new UpdateCCAuthorization();
                break;
            // PP Authorization
            case "ppauthorization":
                command = new PPAuthorization();
                break;
            // UpdatePPAuthorization
            case "updateppauthorization":
                command = new UpdatePPAuthorization();
                break;
            // Adding payment method
            case "addpaymentmethod":
                command = new AddPaymentMethod();
                break;
            // Errors
            default:
                command = null;
                break;
        }

        //Return the instantiated Command object to the calling code...
        return command;// may be null
    }
}