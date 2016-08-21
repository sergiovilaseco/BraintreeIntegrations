package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class DropInUI_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>DropIn UI</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <a href=\"index.jsp\">Back to index </a>\n");
      out.write("        <form  action=\"processRequest\" id=\"submitForm\" method=\"post\"><br>\n");
      out.write("            <label for='price'>Item:</label><br>\n");
      out.write("            <input type=\"text\" name=\"item\" value=\"Buying a new phone\" readonly/><br>\n");
      out.write("            <label for='price'>Name:</label><br>\n");
      out.write("            <input type=\"text\" name=\"fname\" value=\"Sergio\" readonly/><br>\n");
      out.write("            <label for='price'>Last Name:</label><br>\n");
      out.write("            <input type=\"text\" name=\"lname\" value=\"Vilaseco-Romero\" readonly/><br>\n");
      out.write("            <label for='price'>Address:</label><br>\n");
      out.write("            <input type=\"text\" name=\"address\" value=\"24 my street\" readonly/><br>\n");
      out.write("            <label for='price'>County:</label><br>\n");
      out.write("            <input type=\"text\" name=\"county\" value=\"Louth\" readonly/><br>\n");
      out.write("            <label for='price'>Country</label><br>\n");
      out.write("            <input type=\"text\" name=\"county\" value=\"Ireland\" readonly/><br>\n");
      out.write("            <label for='price'>Price:</label><br>\n");
      out.write("            <input id=\"price\" type=\"text\" name=\"price\" value=\"100.00\" /><br>\n");
      out.write("            <input type='hidden' id=\"nonce\" name='nonce' value=''/>\n");
      out.write("            <input type=\"hidden\" name=\"action\" value=\"dropinui\" />\n");
      out.write("            <br><br>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("\n");
      out.write("        <form>\n");
      out.write("            <div id=\"dropin\"></div>\n");
      out.write("            <input type='submit' value='Pay'/>\n");
      out.write("\n");
      out.write("        </form>\n");
      out.write("        <script src=\"https://js.braintreegateway.com/js/braintree-2.27.0.min.js\"></script>\n");
      out.write("        <script src=\"https://js.braintreegateway.com/js/braintree-2.21.0.min.js\"></script>\n");
      out.write("        <script>\n");
      out.write("            var token = '");
      out.print((String) session.getAttribute("clientToken"));
      out.write("';\n");
      out.write("\n");
      out.write("            braintree.setup(token, 'dropin', {\n");
      out.write("                container: 'dropin',\n");
      out.write("                onPaymentMethodReceived: function (obj) {\n");
      out.write("                    // Do some logic in here.\n");
      out.write("                    // When you're ready to submit the form:\n");
      out.write("                    //myForm.submit();\n");
      out.write("                    var nonce = obj.nonce;\n");
      out.write("                    window.alert(\"Nonce: \" + obj.nonce + \"\\nPayment Type: \" + obj.type);\n");
      out.write("                    document.getElementById(\"nonce\").value = nonce;\n");
      out.write("                    document.getElementById(\"submitForm\").submit();\n");
      out.write("                }\n");
      out.write("            });\n");
      out.write("        </script>\n");
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
