/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.CCAuthorization;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Commands.Command;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.ResourceCollection;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionSearchRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Sergio
 */
public class UpdateCCAuthorization implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        //If login successful, store the session id for this client...
        HttpSession session = request.getSession();

        String forwardToJsp = "fail.jsp";
        // Getting generated gateway
        BraintreeGateway gateway = (BraintreeGateway) session.getAttribute("gateway");

        // Geting back the result
        Result<Transaction> TResult = (Result<Transaction>) session.getAttribute("TResult");

        //Getting the Id
        String id = request.getParameter("transactionid");

        // Getting the update
        String update = request.getParameter("submitForSettle");

        if (update != null) {
            if (update.equalsIgnoreCase("true")) {
                TResult = gateway.transaction().submitForSettlement(id);
            } else if (update.equalsIgnoreCase("void")) {
                TResult = gateway.transaction().voidTransaction(id);
            }
        }

        TransactionSearchRequest TSRequest = new TransactionSearchRequest().paymentInstrumentType().in("credit_card");

        ResourceCollection<Transaction> collection = gateway.transaction().search(TSRequest);

        session.setAttribute("collection", collection);

        if (TSRequest != null) {
            forwardToJsp = "CCAuthorizationStatus.jsp";
        } else {
            forwardToJsp = "fail.jsp";
        }

        return forwardToJsp;
    }

}
