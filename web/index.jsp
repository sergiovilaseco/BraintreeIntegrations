<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->

<html>
    <head>
        <title>Braintree integration</title>

    </head>

    <body>
        <a href='processRequest?action=newclienttoken&forwardToJsp=PayPalButton.jsp'>PayPal Button</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=DropInUI.jsp'>DropIn UI</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=HostedFields.jsp'>Hosted fields</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=CCAuthorization.jsp'>CC authorization / submit for settlement / void</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=processRequest?action=updateccauthorization'>List of CC Transactions</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=PPAuthorization.jsp'>PayPal authorization / submit for settlement / void</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=processRequest?action=updateppauthorization'>List of PP Transactions</a>
        <br><br>
        <a href='processRequest?action=newclienttoken&forwardToJsp=PaymentMethod.jsp'>Setting PaymentMethod / re-billing</a>
    </body>
</html>