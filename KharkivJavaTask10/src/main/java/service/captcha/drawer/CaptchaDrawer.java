package service.captcha.drawer;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * @author Arsalan
 */
public class CaptchaDrawer {

    private int width = 150;
    private int height = 50;
    private BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
    private String captcha;

    public void drawCaptcha() {
        char[] chars = generateNumbers();
        Graphics2D graphics2D = create2DGraphic(image);
        int x = 0;
        int y = 0;
        Random random = new Random();
        for (int i = 0; i < chars.length; i++) {
            x += 10 + (Math.abs(random.nextInt()) % 15);
            y = 20 + Math.abs(random.nextInt()) % 20;
            graphics2D.drawChars(chars, i, 1, x, y);
        }
        graphics2D.dispose();
        captcha = String.copyValueOf(chars);
    }

    private char[] generateNumbers() {
        Random random = new Random();
        return String.valueOf(random.nextInt(900000)).toCharArray();
    }

    private Graphics2D create2DGraphic(BufferedImage image) {
        Graphics2D graphics2D = image.createGraphics();
        graphics2D.setFont(new Font("Georgia", Font.BOLD, 18));
        graphics2D.setRenderingHints(createRenderingHints());
        graphics2D.setPaint(new GradientPaint(0, 0, new Color(129, 98, 99), 0, height / 2, Color.black, true));
        graphics2D.fillRect(0, 0, width, height);
        graphics2D.setColor(new Color(255, 255, 255));
        return graphics2D;
    }

    private RenderingHints createRenderingHints() {
        RenderingHints renderingHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        renderingHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        return renderingHints;
    }

    public BufferedImage getImage() {
        return image;
    }

    public String getCaptcha() {
        return captcha;
    }
}
