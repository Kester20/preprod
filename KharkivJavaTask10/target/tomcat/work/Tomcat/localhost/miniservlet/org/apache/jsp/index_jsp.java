/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/7.0.47
 * Generated at: 2016-12-13 18:23:39 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("\r\n");
      out.write("<head>\r\n");
      out.write("\r\n");
      out.write("    <title>Eshop a Flat E-Commerce Bootstrap Responsive Website Template | Home :: w3layouts</title>\r\n");
      out.write("\r\n");
      out.write("    <link href=\"css/bootstrap.css\" rel='stylesheet' type='text/css'/>\r\n");
      out.write("    <link href=\"css/style.css\" rel=\"stylesheet\" type=\"text/css\" media=\"all\"/>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"css/flexslider.css\" type=\"text/css\" media=\"screen\"/>\r\n");
      out.write("\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>\r\n");
      out.write("    \r\n");
      out.write("    <script type=\"application/x-javascript\" src=\"js/addHandlerLoad.js\"></script>\r\n");
      out.write("    <script src=\"js/jquery.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/bootstrap-3.1.1.min.js\"></script>\r\n");
      out.write("    <script src=\"js/simpleCart.min.js\"></script>\r\n");
      out.write("    <script src=\"js/responsiveslides.min.js\"></script>\r\n");
      out.write("    <script type=\"text/javascript\" src=\"js/jquery.flexisel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "header.jsp", out, false);
      out.write("\r\n");
      out.write("\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"banner\">\r\n");
      out.write("\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"banner-bottom\">\r\n");
      out.write("                <div class=\"banner-bottom-left\">\r\n");
      out.write("                    <h2>B<br>U<br>Y</h2>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"banner-bottom-right\">\r\n");
      out.write("                    <div class=\"callbacks_container\">\r\n");
      out.write("                        <ul class=\"rslides\" id=\"slider4\">\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <div class=\"banner-info\">\r\n");
      out.write("                                    <h3>Smart But Casual</h3>\r\n");
      out.write("                                    <p>Start your shopping here...</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <div class=\"banner-info\">\r\n");
      out.write("                                    <h3>Shop Online</h3>\r\n");
      out.write("                                    <p>Start your shopping here...</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                            <li>\r\n");
      out.write("                                <div class=\"banner-info\">\r\n");
      out.write("                                    <h3>Pack your Bag</h3>\r\n");
      out.write("                                    <p>Start your shopping here...</p>\r\n");
      out.write("                                </div>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <script src=\"js/responsiveslides.min.js\"></script>\r\n");
      out.write("\r\n");
      out.write("                <script>\r\n");
      out.write("\r\n");
      out.write("                // You can also use \"$(window).load(function() {\"\r\n");
      out.write("\r\n");
      out.write("                $(function () {\r\n");
      out.write("\r\n");
      out.write("                  // Slideshow 4\r\n");
      out.write("\r\n");
      out.write("                  $(\"#slider4\").responsiveSlides({\r\n");
      out.write("\r\n");
      out.write("                    auto: true,\r\n");
      out.write("\r\n");
      out.write("                    pager:true,\r\n");
      out.write("\r\n");
      out.write("                    nav:false,\r\n");
      out.write("\r\n");
      out.write("                    speed: 500,\r\n");
      out.write("\r\n");
      out.write("                    namespace: \"callbacks\",\r\n");
      out.write("\r\n");
      out.write("                    before: function () {\r\n");
      out.write("\r\n");
      out.write("                      $('.events').append(\"<li>before event fired.</li>\");\r\n");
      out.write("\r\n");
      out.write("                    },\r\n");
      out.write("\r\n");
      out.write("                    after: function () {\r\n");
      out.write("\r\n");
      out.write("                      $('.events').append(\"<li>after event fired.</li>\");\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                  });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("                </script>\r\n");
      out.write("\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"shop\">\r\n");
      out.write("                <a href=\"single.jsp\">SHOP COLLECTION NOW</a>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("    <!-- content-section-starts-here -->\r\n");
      out.write("    <div class=\"container\">\r\n");
      out.write("        <div class=\"main-content\">\r\n");
      out.write("            <div class=\"online-strip\">\r\n");
      out.write("                <div class=\"col-md-4 follow-us\">\r\n");
      out.write("                    <h3>follow us : <a class=\"twitter\" href=\"#\"></a><a class=\"facebook\" href=\"#\"></a></h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 shipping-grid\">\r\n");
      out.write("                    <div class=\"shipping\">\r\n");
      out.write("                        <img src=\"images/shipping.png\" alt=\"\"/>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"shipping-text\">\r\n");
      out.write("                        <h3>Free Shipping</h3>\r\n");
      out.write("                        <p>on orders over $ 199</p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <div class=\"clearfix\"></div>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 online-order\">\r\n");
      out.write("                    <p>Order online</p>\r\n");
      out.write("                    <h3>Tel:999 4567 8902</h3>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"products-grid\">\r\n");
      out.write("                <header>\r\n");
      out.write("                    <h3 class=\"head text-center\">Latest Products</h3>\r\n");
      out.write("                </header>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/acer2.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">Acer</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1000</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/acer3.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">Acer</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1200</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/apple.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">Apple</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1900</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/hp.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">HP </a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1300</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/hp2.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">HP</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1200</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/hp06.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">HP</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1300</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/len.png\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">Lenovo</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1000</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/oi.jpg\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">Dell</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1200</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"col-md-4 product simpleCart_shelfItem text-center\">\r\n");
      out.write("                    <a href=\"single.jsp\"><img src=\"img/sams.jpg\" alt=\"\" /></a>\r\n");
      out.write("                    <div class=\"mask\">\r\n");
      out.write("                        <a href=\"single.jsp\">Quick View</a>\r\n");
      out.write("                    </div>\r\n");
      out.write("                    <a class=\"product_name\" href=\"single.jsp\">Samsung</a>\r\n");
      out.write("                    <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\"item_price\">$1500</span></a></p>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"clearfix\"></div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("    <div class=\"other-products\">\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <h3 class=\"like text-center\">Featured Collection</h3>\r\n");
      out.write("            <ul id=\"flexiselDemo3\">\r\n");
      out.write("                <li><a href=\"single.jsp\"><img src=\"images/l1.jpg\" class=\"img-responsive\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"product liked-product simpleCart_shelfItem\">\r\n");
      out.write("                        <a class=\"like_name\" href=\"single.jsp\">perfectly simple</a>\r\n");
      out.write("                        <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\" item_price\">$759</span></a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"single.jsp\"><img src=\"images/l2.jpg\" class=\"img-responsive\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"product liked-product simpleCart_shelfItem\">\r\n");
      out.write("                        <a class=\"like_name\" href=\"single.jsp\">praising pain</a>\r\n");
      out.write("                        <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\" item_price\">$699</span></a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"single.jsp\"><img src=\"images/l3.jpg\" class=\"img-responsive\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"product liked-product simpleCart_shelfItem\">\r\n");
      out.write("                        <a class=\"like_name\" href=\"single.jsp\">Neque porro</a>\r\n");
      out.write("                        <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\" item_price\">$329</span></a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"single.jsp\"><img src=\"images/l4.jpg\" class=\"img-responsive\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"product liked-product simpleCart_shelfItem\">\r\n");
      out.write("                        <a class=\"like_name\" href=\"single.jsp\">equal blame</a>\r\n");
      out.write("                        <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\" item_price\">$499</span></a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("                <li><a href=\"single.jsp\"><img src=\"images/l5.jpg\" class=\"img-responsive\" alt=\"\"/></a>\r\n");
      out.write("                    <div class=\"product liked-product simpleCart_shelfItem\">\r\n");
      out.write("                        <a class=\"like_name\" href=\"single.jsp\">perfectly simple</a>\r\n");
      out.write("                        <p><a class=\"item_add\" href=\"#\"><i></i> <span class=\" item_price\">$649</span></a></p>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </li>\r\n");
      out.write("            </ul>\r\n");
      out.write("\r\n");
      out.write("            <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("               $(window).load(function() {\r\n");
      out.write("\r\n");
      out.write("                $(\"#flexiselDemo3\").flexisel({\r\n");
      out.write("\r\n");
      out.write("                    visibleItems: 4,\r\n");
      out.write("\r\n");
      out.write("                    animationSpeed: 1000,\r\n");
      out.write("\r\n");
      out.write("                    autoPlay: true,\r\n");
      out.write("\r\n");
      out.write("                    autoPlaySpeed: 3000,\r\n");
      out.write("\r\n");
      out.write("                    pauseOnHover: true,\r\n");
      out.write("\r\n");
      out.write("                    enableResponsiveBreakpoints: true,\r\n");
      out.write("\r\n");
      out.write("                    responsiveBreakpoints: {\r\n");
      out.write("\r\n");
      out.write("                        portrait: {\r\n");
      out.write("\r\n");
      out.write("                            changePoint:480,\r\n");
      out.write("\r\n");
      out.write("                            visibleItems: 1\r\n");
      out.write("\r\n");
      out.write("                        },\r\n");
      out.write("\r\n");
      out.write("                        landscape: {\r\n");
      out.write("\r\n");
      out.write("                            changePoint:640,\r\n");
      out.write("\r\n");
      out.write("                            visibleItems: 2\r\n");
      out.write("\r\n");
      out.write("                        },\r\n");
      out.write("\r\n");
      out.write("                        tablet: {\r\n");
      out.write("\r\n");
      out.write("                            changePoint:768,\r\n");
      out.write("\r\n");
      out.write("                            visibleItems: 3\r\n");
      out.write("\r\n");
      out.write("                        }\r\n");
      out.write("\r\n");
      out.write("                    }\r\n");
      out.write("\r\n");
      out.write("                });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("            });\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("        <script type=\"text/javascript\" src=\"js/jquery.flexisel.js\"></script>\r\n");
      out.write("\r\n");
      out.write("    </div>\r\n");
      out.write("</div>\r\n");
      out.write("<!-- content-section-ends-here -->\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.jsp", out, false);
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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