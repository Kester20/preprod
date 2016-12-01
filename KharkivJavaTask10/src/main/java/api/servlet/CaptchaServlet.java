package api.servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;
import java.util.List;

/**
 * @author Arsalan
 */
@WebServlet("/CaptchaServlet")
public class CaptchaServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 150;
        int height = 50;
        List arrayList = new ArrayList();
        String capcode = "0123456789";
        for (int i = 1; i < capcode.length() - 1; i++) {
            arrayList.add(capcode.charAt(i));
        }
        Collections.shuffle(arrayList);
        Iterator itr = arrayList.iterator();
        String s = "";
        String s2 = "";
        Object obj;
        while (itr.hasNext()) {
            obj = itr.next();
            s = obj.toString();
            s2 = s2 + s;
        }
        String s1 = s2.substring(0, 6);
        char[] s3 = s1.toCharArray();
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = bufferedImage.createGraphics();
        Font font = new Font("Georgia", Font.BOLD, 18);
        g2d.setFont(font);
        RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2d.setRenderingHints(rh);
        GradientPaint gp = new GradientPaint(0, 0, new Color(129, 98, 99 ), 0, height / 2, Color.black, true);
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, width, height);
        g2d.setColor(new Color(255, 255, 255));
        Random r = new Random();
        int index = Math.abs(r.nextInt()) % 5;
        String captcha = String.copyValueOf(s3);
        request.getSession().setAttribute("captcha", captcha);
        int x = 0;
        int y = 0;
        for (int i = 0; i < s3.length; i++) {
            x += 10 + (Math.abs(r.nextInt()) % 15);
            y = 20 + Math.abs(r.nextInt()) % 20;
            g2d.drawChars(s3, i, 1, x, y);
        }
        g2d.dispose();
        response.setContentType("image/png");

        OutputStream os = response.getOutputStream();
        ImageIO.write(bufferedImage, "png", os);
        os.flush();
        os.close();

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }
}
