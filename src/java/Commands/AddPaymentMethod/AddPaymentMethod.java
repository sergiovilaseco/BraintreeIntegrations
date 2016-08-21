/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Commands.AddPaymentMethod;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import Commands.Command;
import com.braintreegateway.BraintreeGateway;
import com.braintreegateway.Customer;
import com.braintreegateway.CustomerRequest;
import com.braintreegateway.CustomerSearchRequest;
import com.braintreegateway.PaymentMethod;
import com.braintreegateway.PaymentMethodRequest;
import com.braintreegateway.ResourceCollection;
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
public class AddPaymentMethod implements Command {

    public String execute(HttpServletRequest request, HttpServletResponse response) {

        //If login successful, store the session id for this client...
        HttpSession session = request.getSession();

        String forwardToJsp = "fail.jsp";

        String nonce = request.getParameter("nonce");

        // Getting generated gateway
        BraintreeGateway gateway = (BraintreeGateway) session.getAttribute("gateway");
        // Getting the customer from the session if exist
        Customer customer = (Customer) session.getAttribute("customer");
        
        String id = null;
        // If customer is not in the session then searching the customer
        if (customer == null) {
            
            // searching for the customer in Braintree
            CustomerSearchRequest CSRequest = new CustomerSearchRequest()
                    .firstName().is(request.getParameter("fname"))
                    .lastName().is(request.getParameter("lname"))
                    .phone().is(request.getParameter("phone"))
                    .email().is(request.getParameter("email"));

            ResourceCollection<Customer> collection = gateway.customer().search(CSRequest);
            
            CustomerRequest CustomerRequest = null;
            Result<Customer> CustomerResult = null;

            // Generating a new customer if the customer doesn't exist.
            if (collection.getMaximumSize() == 0) {
                CustomerRequest = new CustomerRequest()
                        .firstName(request.getParameter("fname"))
                        .lastName(request.getParameter("lname"))
                        .phone(request.getParameter("phone"))
                        .email(request.getParameter("email"));
                
                // Braintree response object
                CustomerResult = gateway.customer().create(CustomerRequest);
                
                id = CustomerResult.getTarget().getId();
            } else {
                customer = collection.getFirst();
                id = customer.getId();
            }
        }else{
            id = customer.getId();
        }
        
        // Creating Braintree PaymentMethod result object
        Result<? extends PaymentMethod> PMResult = null;
        
        if (nonce != null && !nonce.equals("")) {
            PaymentMethodRequest PMRequest = new PaymentMethodRequest()
                    .customerId(id)
                    .paymentMethodNonce(nonce)
                    .billingAddress()
                    .countryName(request.getParameter("country"))
                    .firstName(request.getParameter("fname"))
                    .lastName(request.getParameter("lname"))
                    .region(request.getParameter("county"))
                    .streetAddress("address")
                    .done()
                    .options()
                    .failOnDuplicatePaymentMethod(true)
                    .makeDefault(true)
                    .done();
            PMResult = gateway.paymentMethod().create(PMRequest);
            //String err2 = PMResult.getMessage();
            //int q = 0;
        } 
        
        // Geting the token to set the transaction
        String token = null;
        
        if (PMResult != null) {
            token = (String) PMResult.getTarget().getToken();
        } else {
            token = customer.getDefaultPaymentMethod().getToken();
        }

        // creating the transaction
        Double price = Double.parseDouble(request.getParameter("price"));
        
        TransactionRequest TRequest = new TransactionRequest()
                .amount(new BigDecimal(price))
                .paymentMethodToken(token)
                .customerId(id)
                .options()
                .submitForSettlement(true)
                .done();

        Result<Transaction> TResult = gateway.transaction().sale(TRequest);
        session.setAttribute("customer", customer);
        session.setAttribute("TResult", TResult);
        //String error = TResult.getMessage();

        
        if (TResult.isSuccess()) {
            forwardToJsp = "SuccessRebilling.jsp";
        } else {
            forwardToJsp = "fail.jsp";
        }

        return forwardToJsp;
    }

}
