/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.26
 * Generated at: 2016-06-17 11:42:20 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class AboutUs_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <title>bxSlider Plugin</title>\r\n");
      out.write("    <!-- Normal style sheet -->\r\n");
      out.write("    <link href=\"css/styles.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- bxSlider styles -->\r\n");
      out.write("\t<link href=\"css/jquery.bxslider.css\" rel=\"stylesheet\">\r\n");
      out.write("    <!-- jQuery library -->\r\n");
      out.write("     <script src=\"http://code.jquery.com/jquery-2.1.3.min.js\"></script>\r\n");
      out.write("    <!-- The bxSlider plugin -->\r\n");
      out.write("    <script src=\"js/jquery.bxslider.min.js\"></script>\r\n");
      out.write("    <!-- Call to the bxSlider function -->\r\n");
      out.write("    <script>\r\n");
      out.write("    \t$(document).ready(function() {\r\n");
      out.write("        \t$(\"#slider\").bxSlider({\r\n");
      out.write("\t\t\t  auto: true,\r\n");
      out.write("\t\t\t  autoControls: true,\r\n");
      out.write("\t\t\t  captions: true,\r\n");
      out.write("\t\t\t  minSlides: 2,\r\n");
      out.write("\t\t\t  maxSlides: 2,\r\n");
      out.write("\t\t\t  slideWidth: 450,\r\n");
      out.write("\t\t\t  slideMargin: 100\r\n");
      out.write("\t\t\t});\r\n");
      out.write("    \t});\r\n");
      out.write("    </script>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("    <section>\r\n");
      out.write("        <h1>About Us</h1>\r\n");
      out.write("        <p>This is online shopping website, provide you any what you want!</p>\r\n");
      out.write("        <ul id=\"slider\">\r\n");
      out.write("            <li><img src=\"images/18.jpg\" alt=\"\" title=\"pants\"></li>\r\n");
      out.write("            <li><img src=\"images/19.jpg\" alt=\"\" title=\"sunglasses\"></li>\r\n");
      out.write("            <li><img src=\"images/20.jpg\" alt=\"\" title=\"legging\"></li>\r\n");
      out.write("            <li><img src=\"images/22.jpg\" alt=\"\" title=\"outwear\"></li>\r\n");
      out.write("            <li><img src=\"images/23.jpg\" alt=\"\" title=\"T-shirt\"></li>\r\n");
      out.write("        </ul>\r\n");
      out.write("    </section>\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}