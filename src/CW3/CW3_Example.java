package CW3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Sample Methods
 */
public class CW3_Example {
    
    // Returns a new picture that is a grayscale version the given picture.
    public static Picture grayScale(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture newPic = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                Color color = picture.getColor(col, row);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                double luminance = 0.299 * r + 0.587 * g + 0.114 * b;
                int y = (int) (Math.round(luminance));
                Color gray = new Color(y, y, y);
                newPic.setColor(col, row, gray);
            }
        }
        return newPic;
    }
    
    
    public static void main(String[] args) {
        Picture andrew = new Picture("src\\cw3\\Andrew.png");
        andrew.show();
        
        Picture grayAndrew = new Picture("src\\cw3\\Expected\\GrayAndrew.png");
        System.out.println(grayAndrew.equals(grayScale(andrew)));
        
    }
    
}
