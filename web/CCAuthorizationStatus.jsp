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
            ResourceCollection<Transaction> collection = ( ResourceCollection<Transaction>) session.getAttribute("collection");
        %>
    </head>
    <body>
<a href="index.jsp">Back to index </a>
        <table style="width: 50%; margin-left: 25%">
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
                <td style="width: 40%; text-align: center">
                    <p>
                        <font color='black'>Submit for settlement </font>
                    </p>
                </td>
                <td style="width: 40%; text-align: center">
                    <p>
                        <font color='black'>Void</font>
                    </p>
                </td>
            </tr>
            <%
            for (Transaction transaction : collection) {
                
                %>
            <tr>
                <td style="width: 20%; text-align: center">
                    <p>
                        <%
                            String id = transaction.getId();
                        %>
                        <font color='black' ><%=id%></font>
                    </p>
                </td>
                <td style="width: 40%; text-align: center">
                    <p>
                        <font color='black'><%=transaction.getStatus()%></font>
                    </p>
                </td>
                <td style="width: 40%; text-align: center">
                    <%
                        Status st = transaction.getStatus();
                        if (st.toString().equalsIgnoreCase("AUTHORIZED")) {
                    %>
                    <form  action="processRequest" id="submitForm" method="post" style="margin-left: 30px ">
                        <input type='hidden' name='transactionid' value='<%=transaction.getId()%>'/>
                        <input type='hidden' name='submitForSettle' value='true'/>
                        <input type="hidden" name="action" value="updateccauthorization" />
                        <input type="submit" name="submitButton" value="Submit" />

                    </form>
                    <%
                        }
                    %>
                </td>
                <td style="width: 40%; text-align: center">

                    <%
                        if (st.toString().equalsIgnoreCase("SUBMITTED_FOR_SETTLEMENT") || st.toString().equalsIgnoreCase("AUTHORIZED")) {
                    %>
                    <form  action="processRequest" id="submitForm" method="post" style="margin-left: 30px ">
                        <input type='hidden' name='transactionid' value='<%=transaction.getId()%>'/>
                        <input type='hidden' name='submitForSettle' value='void'/>
                        <input type="hidden" name="action" value="updateccauthorization" />
                        <input type="submit" name="submitButton" value="Void" />

                    </form>
                    <%
                        }
                    %>
                </td>
            </tr>
            <%
                }
            %>
        </table>
    </body>
</html>
