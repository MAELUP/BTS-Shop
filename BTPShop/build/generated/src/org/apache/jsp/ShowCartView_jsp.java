package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class ShowCartView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <c:set var=\"totalPrice\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${0}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\t\t       \n");
      out.write("                <h4><span>Shopping Cart</span></h4>\n");
      out.write("\t\n");
      out.write("                        <h4>Your Cart</h4>\n");
      out.write("                        <table>\n");
      out.write("                            <thead>\n");
      out.write("                                <tr>\n");
      out.write("                                    <th>No.</th>\n");
      out.write("                                    <th>Image</th>\n");
      out.write("                                    <th>Product No.</th>\n");
      out.write("                                    <th>Product Name</th>\n");
      out.write("                                    <th>Price</th>\n");
      out.write("                                    <th>Quantity</th>\n");
      out.write("                                    <th>Total Price</th>\n");
      out.write("                                    <th>&nbsp;</th>\n");
      out.write("                                </tr>\n");
      out.write("                            </thead>\n");
      out.write("                            <tbody>\n");
      out.write("                                <c:forEach items=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${sessionScope.cart}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" var=\"c\" varStatus=\"vs\">\n");
      out.write("                                    <tr>\n");
      out.write("                                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${vs.count}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                        <td><a href=\"GetProduct?productname=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"><img src =\"image/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productimage}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(".jpg\"widtd=\"120\"></a></td>\n");
      out.write("                                        <td><a href=\"GetProduct?productname=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write('"');
      out.write('>');
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productid}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</a></td>         \n");
      out.write("                                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productprice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                        <td>\n");
      out.write("                                            <form action=\"UpdateCart\" method=\"post\">\n");
      out.write("                                                <input type =\"hidden\" name=\"productname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                                <input type =\"number\" name=\"quantity\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productqueslity}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" min=\"1\">\n");
      out.write("                                                <input type =\"submit\" value=\"Update\">\n");
      out.write("                                            </form>\n");
      out.write("                                        </td>\n");
      out.write("                                        <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productqueslity * c.productprice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</td>\n");
      out.write("                                        <td> <form action=\"RemoveCart\" method=\"post\">\n");
      out.write("                                                <input type =\"hidden\" name=\"productname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${c.productname}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">\n");
      out.write("                                                <input type =\"submit\" value=\"Remove\">\n");
      out.write("                                            </form>\n");
      out.write("                                        </td>\n");
      out.write("                                        <c:set var=\"totalPrice\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${(c.productqueslity * c.productprice) + totalPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" />\n");
      out.write("                                    </c:forEach>\n");
      out.write("                                <tr>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                    <td>&nbsp;</td>\n");
      out.write("                                    <td><strong>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</strong></td>\n");
      out.write("                                </tr>\t\t  \n");
      out.write("                            </tbody>\n");
      out.write("                        </table>\n");
      out.write("                        <hr>\n");
      out.write("                        <p>\n");
      out.write("                            <strong>Total</strong>: ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${totalPrice}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write(" Bant.<br>\n");
      out.write("                        </p>\n");
      out.write("                        <hr/>\n");
      out.write("                        <div>\n");
      out.write("                            <a href=\"Store\"><button type=\"button\">Back</button></a>\n");
      out.write("                            <a href=\"Checkout\"> <button  type=\"submit\" id=\"checkout\">Checkout</button></a>\n");
      out.write("                        </div>\t\t\t\t\t  \t\n");
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
