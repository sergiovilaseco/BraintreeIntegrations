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
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.ResourceCollection;
import com.braintreegateway.TransactionSearchRequest;
import com.braintreegateway.Result;
import com.braintreegateway.Transaction;
import com.braintreegateway.TransactionRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;

/**
 *
 * @author Sergio
 */
public class CCAuthorization implements Command {

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) {

        //If login successful, store the session id for this client...
        HttpSession session = request.getSession();

        String forwardToJsp = "fail.jsp";

        String nonce = request.getParameter("nonce");

        // Getting generated gateway
        BraintreeGateway gateway = (BraintreeGateway) session.getAttribute("gateway");

        // Generating a new customer
        CustomerRequest CustomerRequest = new CustomerRequest()
                .firstName(request.getParameter("fname"))
                .lastName(request.getParameter("lname"));

        Result<Customer> CustomerResult = gateway.customer().create(CustomerRequest);

        // If a customer is created, then a transaction can go through
        if (CustomerResult.isSuccess()) {
            // Getting the customer.
            Customer customer = CustomerResult.getTarget();

            //setting customer ID
            String custID = customer.getId();

            // Generating transaction
            TransactionRequest TRequest = new TransactionRequest()
                    .amount(new BigDecimal(Double.parseDouble(request.getParameter("price"))))
                    .paymentMethodNonce(nonce)
                    .customerId(custID)
                    .options()
                    .submitForSettlement(false)
                    .done();

            // Geting back the result
            Result<Transaction> TResult = gateway.transaction().sale(TRequest);

            String error = TResult.getMessage();

            if (TResult.isSuccess()) {
                forwardToJsp = "CCAuthorizationStatus.jsp";

                TransactionSearchRequest TSRequest = new TransactionSearchRequest().paymentInstrumentType().in("credit_card");

                ResourceCollection<Transaction> collection = gateway.transaction().search(TSRequest);

                session.setAttribute("collection", collection);
                session.setAttribute("TResult", TResult);
            } else {
                forwardToJsp = "fail.jsp";
            }
        }

        return forwardToJsp;
    }

}
