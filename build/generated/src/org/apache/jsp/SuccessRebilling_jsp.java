package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.braintreegateway.ResourceCollection;
import com.braintreegateway.Transaction.Status;
import com.braintreegateway.Transaction;
import com.braintreegateway.Result;
import com.braintreegateway.Result;
import com.braintreegateway.TransactionRequest;

public final class SuccessRebilling_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Transaction success</title>\n");
      out.write("        ");

            Result<Transaction> TResult = (Result<Transaction>) session.getAttribute("TResult");
        
      out.write("\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"index.jsp\">Back to index </a>\n");
      out.write("        <table style=\"width: 50%; margin-left: 25%\">\n");
      out.write("            <tr>\n");
      out.write("                <td style=\"width: 20%; text-align: center\">\n");
      out.write("                    <p>\n");
      out.write("                        <font color='black' >Transaction ID </font>\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("                <td style=\"width: 40%; text-align: center\">\n");
      out.write("                    <p>\n");
      out.write("                        <font color='black'>Status </font>\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("                <td style=\"width: 40%; text-align: center\">\n");
      out.write("                    <p>\n");
      out.write("                        <font color='black'>Submit for settlement </font>\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("                <td style=\"width: 40%; text-align: center\">\n");
      out.write("                    <p>\n");
      out.write("                        <font color='black'>Void</font>\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("\n");
      out.write("            <tr>\n");
      out.write("                <td style=\"width: 20%; text-align: center\">\n");
      out.write("                    <p>\n");
      out.write("\n");
      out.write("                        <font color='black' >");
      out.print(TResult.getTarget().getId());
      out.write("</font>\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("                <td style=\"width: 40%; text-align: center\">\n");
      out.write("                    <p>\n");
      out.write("                        <font color='black'>");
      out.print(TResult.getTarget().getStatus());
      out.write("</font>\n");
      out.write("                    </p>\n");
      out.write("                </td>\n");
      out.write("                <td style=\"width: 40%; text-align: center\">\n");
      out.write("\n");
      out.write("                    <form  action=\"processRequest\" id=\"submitForm\" method=\"post\" style=\"margin-left: 30px \">\n");
      out.write("                        <input type='hidden' name='transactionid' value='");
      out.print(TResult.getTarget().getId());
      out.write("'/>\n");
      out.write("                        <input type='hidden' name='submitForSettle' value='true'/>\n");
      out.write("                        <input type=\"hidden\" name=\"action\" value=\"updateppauthorization\" />\n");
      out.write("                        <input type=\"text\" name=\"amount\" value=\"");
      out.print(TResult.getTarget().getAmount());
      out.write("\" />\n");
      out.write("                        <input type=\"submit\" name=\"submitButton\" value=\"Bill this amount\" />\n");
      out.write("\n");
      out.write("                    </form>\n");
      out.write("\n");
      out.write("                </td>\n");
      out.write("\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
