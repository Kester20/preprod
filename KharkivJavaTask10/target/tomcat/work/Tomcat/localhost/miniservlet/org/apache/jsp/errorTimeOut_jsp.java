/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-12-06 08:42:24 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class errorTimeOut_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private javax.el.ExpressionFactory _el_expressionfactory;
  private org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
    _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Register :: w3layouts</title>\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css'/>\r\n");
      out.write("    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->\r\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <!-- Custom Theme files -->\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("    <!-- Custom Theme files -->\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    <meta name=\"keywords\" content=\"Eshop Responsive web template, Bootstrap Web Templates, Flat Web Templates, Andriod Compatible web template,\r\n");
      out.write("Smartphone Compatible web template, free webdesigns for Nokia, Samsung, LG, SonyErricsson, Motorola web design\"/>\r\n");
      out.write("    <script type=\"application/x-javascript\">\r\n");
      out.write("        addEventListener(\"load\", function() {\r\n");
      out.write("            setTimeout(hideURLbar, 0);\r\n");
      out.write("        }, false);\r\n");
      out.write("\r\n");
      out.write("        function hideURLbar() {\r\n");
      out.write("            window.scrollTo(0, 1);\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("    </script>\r\n");
      out.write("    <!--webfont-->\r\n");
      out.write("    <!-- for bootstrap working -->\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap-3.1.1.min.js\"></script>\r\n");
      out.write("    <!-- //for bootstrap working -->\r\n");
      out.write("    <!-- cart -->\r\n");
      out.write("    <script src=\"js/simpleCart.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/validation.js\"></script>\r\n");
      out.write("    <!-- cart -->\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/flexslider.css\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!-- header-section-starts -->\r\n");
      out.write("<div class=\"header\">\r\n");
      out.write("    <div class=\"header-top-strip\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"header-top-left\">\r\n");
      out.write("                <ul>\r\n");
      out.write("                    <li><a href=\"account.html\"><span class=\"glyphicon glyphicon-user\"> </span>Login</a></li>\r\n");
      out.write("                    <li><a href=\"register.html\"><span class=\"glyphicon glyphicon-lock\"> </span>Create an Account</a>\r\n");
      out.write("                    </li>\r\n");
      out.write("                </ul>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"header-right\">\r\n");
      out.write("                <div class=\"cart box_1\">\r\n");
      out.write("                    <a href=\"checkout.html\">\r\n");
      out.write("                        <h3><span class=\"simpleCart_total\"> $0.00 </span> (<span id=\"simpleCart_quantity\"\r\n");
      out.write("                                                                                 class=\"simpleCart_quantity\"> 0 </span>)<img\r\n");
      out.write("                                src=\"images/bag.png\" alt=\"\"></h3>\r\n");
      out.write("                    </a>\r\n");
      out.write("                    <p><a href=\"javascript:;\" class=\"simpleCart_empty\">Empty cart</a></p>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"clearfix\"></div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- header-section-ends -->\r\n");
      out.write("<div class=\"inner-banner\">\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"banner-top inner-head\">\r\n");
      out.write("            <nav class=\"navbar navbar-default\" role=\"navigation\">\r\n");
      out.write("                <div class=\"navbar-header\">\r\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\"\r\n");
      out.write("                            data-target=\"#bs-example-navbar-collapse-1\">\r\n");
      out.write("                        <span class=\"sr-only\">Toggle navigation</span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                        <span class=\"icon-bar\"></span>\r\n");
      out.write("                    </button>\r\n");
      out.write("                    <div class=\"logo\">\r\n");
      out.write("                        <h1><a href=\"index.html\"><span>E</span> -Shop</a></h1>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--/.navbar-header-->\r\n");
      out.write("\r\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"bs-example-navbar-collapse-1\">\r\n");
      out.write("                    <ul class=\"nav navbar-nav\">\r\n");
      out.write("                        <li><a href=\"index.html\">Home</a></li>\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">Men <b class=\"caret\"></b></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu multi-column columns-3\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>NEW IN</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Clothing</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Bags</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Shoes</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Watches</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Grooming</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>CLOTHING</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">Polos & Tees</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Casual Shirts</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Casual Trousers</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Jeans</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Shorts & 3/4th</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Formal Shirts</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Formal Trousers</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Suits & Blazers</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Track Wear</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Inner Wear</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>WATCHES</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">Analog</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Chronograph</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Digital</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Watch Cases</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">women <b class=\"caret\"></b></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu multi-column columns-3\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>NEW IN</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Clothing</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Bags</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Shoes</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Watches</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Beauty</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>CLOTHING</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">Polos & Tees</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Casual Shirts</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Casual Trousers</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Jeans</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Shorts & 3/4th</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Formal Shirts</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Formal Trousers</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Suits & Blazers</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Track Wear</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Inner Wear</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-4\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>WATCHES</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">Analog</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Chronograph</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Digital</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Watch Cases</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li class=\"dropdown\">\r\n");
      out.write("                            <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\">kids <b class=\"caret\"></b></a>\r\n");
      out.write("                            <ul class=\"dropdown-menu multi-column columns-2\">\r\n");
      out.write("                                <div class=\"row\">\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>NEW IN</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Boys Clothing</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Girls Clothing</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Boys Shoes</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">New In Girls Shoes</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"col-sm-6\">\r\n");
      out.write("                                        <ul class=\"multi-column-dropdown\">\r\n");
      out.write("                                            <h6>ACCESSORIES</h6>\r\n");
      out.write("                                            <li><a href=\"products.html\">Bags</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Watches</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Sun Glasses</a></li>\r\n");
      out.write("                                            <li><a href=\"products.html\">Jewellery</a></li>\r\n");
      out.write("                                        </ul>\r\n");
      out.write("                                    </div>\r\n");
      out.write("                                    <div class=\"clearfix\"></div>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </ul>\r\n");
      out.write("                        </li>\r\n");
      out.write("                        <li><a href=\"typography.html\">TYPO</a></li>\r\n");
      out.write("                        <li><a href=\"contact.html\">CONTACT</a></li>\r\n");
      out.write("                    </ul>\r\n");
      out.write("                </div>\r\n");
      out.write("                <!--/.navbar-collapse-->\r\n");
      out.write("            </nav>\r\n");
      out.write("            <!--/.navbar-->\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <h1 class=\"errorTimeOutMessage\">TIME OUT</h1>\r\n");
      out.write("    <h3 class=\"tryAgainRegister\"><a href=\"register.jsp\">Try again</a></h3>\r\n");
      out.write("</div>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try { out.clearBuffer(); } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
