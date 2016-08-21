<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Braintree integration</title>
        <link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
    </head>

    <body>
        <div class="panel panel-body center-block" style="width: 50%; margin-top: 5%">
            <a href='processRequest?action=newclienttoken&forwardToJsp=PayPalButton.jsp' class="thumbnail">PayPal Button</a>

            <a href='processRequest?action=newclienttoken&forwardToJsp=DropInUI.jsp' class="thumbnail">DropIn UI</a>

            <a href='processRequest?action=newclienttoken&forwardToJsp=HostedFields.jsp' class="thumbnail">Hosted fields</a>

            <a href='processRequest?action=newclienttoken&forwardToJsp=CCAuthorization.jsp' class="thumbnail">CC authorization / submit for settlement / void</a>

            <a href='processRequest?action=newclienttoken&forwardToJsp=processRequest?action=updateccauthorization' class="thumbnail">List of CC Transactions</a>

            <a href='processRequest?action=newclienttoken&forwardToJsp=PPAuthorization.jsp' class="thumbnail">PayPal authorization / submit for settlement / void</a>

            <a href='processRequest?action=newclienttoken&forwardToJsp=processRequest?action=updateppauthorization' class="thumbnail">List of PP Transactions</a>
            <a href='processRequest?action=newclienttoken&forwardToJsp=PaymentMethod.jsp' class="thumbnail">Setting PaymentMethod / re-billing</a>
        </div>
    </body>
</html>