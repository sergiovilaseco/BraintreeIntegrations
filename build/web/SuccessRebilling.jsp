<%-- 
    Document   : success
    Created on : Aug 20, 2016, 6:28:44 PM
    Author     : -sergio-
--%>

<%@page import="com.braintreegateway.ResourceCollection"%>
<%@page import="com.braintreegateway.Transaction.Status"%>
<%@page import="com.braintreegateway.Transaction"%>
<%@page import="com.braintreegateway.Result"%>
<%@page import="com.braintreegateway.Result"%>
<%@page import="com.braintreegateway.TransactionRequest"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Transaction success</title>
        <%
            Result<Transaction> TResult = (Result<Transaction>) session.getAttribute("TResult");
        %><link rel='stylesheet prefetch' href='https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css'>
    </head>
    <body>
        <a href="index.jsp">Back to index </a>
        <div class="panel panel-default bootstrap-basic center-block" style="width: 60%; margin-left: 20%">
            <table style="text-align: center">            
                <tr>
                    <td style="width: 20%; text-align: center">
                        <p>
                            <font color='black' >Transaction ID </font>
                        </p>
                    </td>
                    <td style="width: 40%; text-align: center">
                        <p>
                            <font color='black'>Status </font>
                        </p>
                    </td>
                    <td style="width: 60%;">
                        <p>
                            <font color='black'>Submit for settlement </font>
                        </p>
                    </td>
                
                </tr>
                
                <tr>
                    <td style="width: 20%; text-align: center">
                        <p>

                            <font color='black' ><%=TResult.getTarget().getId()%></font>
                        </p>
                    </td>
                    <td style="width: 40%; text-align: center">
                        <p>
                            <font color='black'><%=TResult.getTarget().getStatus()%></font>
                        </p>
                    </td>
                    <td style="width: 60%;">

                        <form  action="processRequest" id="submitForm" method="post" style="margin-left: 30px ">
                            <input type='hidden' name='transactionid' value='<%=TResult.getTarget().getId()%>'/>
                            <input type='hidden' name='submitForSettle' value='true'/>
                            <input type="hidden" name="action" value="addpaymentmethod" />
                            <input type="text" name="price" placeholder="<%=TResult.getTarget().getAmount()%>" />
                            <input type="submit" name="submitButton" value="Bill this amount" />

                        </form>
                    </td>

                </tr>
            </table>
        </div>
    </body>
</html>
