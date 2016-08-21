/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.ClientToken;

import Commands.Command;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Environment;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class newClientToken implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        //If login successful, store the session id for this client...
        HttpSession session = request.getSession();

        String forwardToJsp = request.getParameter("forwardToJsp");

        /// Generate a cliente Token \\\ 
           String clientToken = gateway.clientToken().generate();
           session.setAttribute("clientToken",clientToken);
           session.setAttribute("gateway", gateway);
       
        
        return forwardToJsp;
    }

    BraintreeGateway gateway = new BraintreeGateway(
            Environment.SANDBOX,
            "83cr4qfg7cpdm32v",
            "hfmqcdgkrxxb4b6w",
            "9a58840d9a2f377d3ce31557dbbedc87"
    );
}
