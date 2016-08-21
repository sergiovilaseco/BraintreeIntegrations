

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PayPal Button</title>
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
        <script src="https://js.braintreegateway.com/js/braintree-2.27.0.min.js"></script>
    </head>
    <body>
        <a href="index.jsp">Back to index </a>
        <div class="panel panel-default bootstrap-basic center-block" style="width: 60%; margin-left: 20%">
            <form  action="processRequest" id="submitForm" method="post" style="margin-left: 30px"><br>
                <label for='price'>Item:</label><br>
                <input type="text" name="item" value="Buying a new phone" readonly/><br>
                <label for='price'>Name:</label><br>
                <input type="text" name="fname" value="Sergio" readonly/><br>
                <label for='price'>Last Name:</label><br>
                <input type="text" name="lname" value="Vilaseco-Romero" readonly/><br>
                <label for='price'>Address:</label><br>
                <input type="text" name="address" value="24 my street" readonly/><br>
                <label for='price'>County:</label><br>
                <input type="text" name="county" value="Louth" readonly/><br>
                <label for='price'>Country</label><br>
                <input type="text" name="county" value="Ireland" readonly/><br>
                <label for='price'>Price:</label><br>
                <input id="price" type="text" name="price" value="100.00" /><br>
                <input type='hidden' id="nonce" name='nonce' value=''/>
                <input type="hidden" name="action" value="paypalcheckout" />
                <br><br>

            </form>
            <div style="text-align: center">
                <div id="paypal-container" style="margin: 0 45% 5% 45%"></div>
            </div>
        </div>
        <script type="text/javascript">

            braintree.setup('<%=(String) session.getAttribute("clientToken")%>', "custom", {
                paypal: {
                    container: "paypal-container",
                },
                onPaymentMethodReceived: function (obj) {
                    var nonce = obj.nonce;
                    //window.alert("Nonce received from PayPal: " + nonce);

                    document.getElementById("nonce").value = nonce;
                    document.getElementById("submitForm").submit();


                    //</editor-fold>

                }
            });
        </script>

    </body>
</html>
