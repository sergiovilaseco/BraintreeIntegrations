<%-- 
    Document   : DropInUI
    Created on : Aug 20, 2016, 6:54:43 PM
    Author     : -sergio-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DropIn UI</title>
    </head>
    <body>
        <a href="index.jsp">Back to index </a>
        <form  action="processRequest" id="submitForm" method="post"><br>
            <label for='item'>Item:</label><br>
            <input type="text" name="item" value="Buying a new phone" readonly/><br>
            <label for='fname'>Name:</label><br>
            <input type="text" name="fname" value="Sergio" readonly/><br>
            <label for='lname'>Last Name:</label><br>
            <input type="text" name="lname" value="Vilaseco-Romero" readonly/><br>
            <label for='address'>Address:</label><br>
            <input type="text" name="address" value="24 my street" readonly/><br>
            <label for='county'>County:</label><br>
            <input type="text" name="county" value="Louth" readonly/><br>
            <label for='county'>Country</label><br>
            <input type="text" name="county" value="Ireland" readonly/><br>
            <label for='price'>Price:</label><br>
            <input id="price" type="text" name="price" value="100.00" /><br>
            <input type='hidden' id="nonce" name='nonce' value=''/>
            <input type="hidden" name="action" value="dropinui" />
            <br><br>

        </form>

        <form>
            <div id="dropin"></div>
            <input type='submit' value='Pay'/>

        </form>
        <script src="https://js.braintreegateway.com/js/braintree-2.27.0.min.js"></script>
        <script>
            var token = '<%=(String) session.getAttribute("clientToken")%>';

            braintree.setup(token, 'dropin', {
                container: 'dropin',
                onPaymentMethodReceived: function (obj) {
                    // Do some logic in here.
                    // When you're ready to submit the form:
                    //myForm.submit();
                    var nonce = obj.nonce;
                    window.alert("Nonce: " + obj.nonce + "\nPayment Type: " + obj.type);


                    var client = new braintree.api.Client({
                        // Use the generated client token to instantiate the Braintree client.
                        clientToken: token
                    });

                    client.verify3DS({
                        amount: document.getElementById("price").value,
                        creditCard: nonce
                    }, function (error, response) {
                        if (!error) {
                            window.alert("passed the validation");
                            document.getElementById("nonce").value = response.nonce;
                            document.getElementById("submitForm").submit();
                        } else {
                            window.alert("Something went wrong with your card, \nPlease, try again! " + response);
                        }
                    }
                    );

                },
                paypal: {
                    button: {
                        type: 'checkout'
                    }
                }
            });

            var client = new braintree.api.Client({
                // Use the generated client token to instantiate the Braintree client.
                clientToken: '<%=(String) session.getAttribute("clientToken")%>'
            });
        </script>
    </body>
</html>
