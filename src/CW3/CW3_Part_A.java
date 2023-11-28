package CW3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Part A
 */
public class CW3_Part_A {
    
    /****************
     * CW3 Part A.1 *
     ****************/    
    
    // Returns a new picture that tilts it 30 degrees clockwise.
    public static Picture tilt(Picture picture) {
        int width = picture.width();
		int height = picture.height();
        Picture newPic = new Picture(width,height);

        for (int col=0; col<width; col++) {
            for (int row=0; row<height; row++) {
                newPic.setColor(col, row, Color.BLACK);
            }
        }

        for (int col=0; col<width; col++) {
            for (int row=0; row<height; row++) {
                double colc = 0.5*(width-1);
                double rowc = 0.5*(height-1);

                double θ = -(Math.PI)/6;
                double colt = (int)((col-colc)*Math.cos(θ) - (row-rowc)*Math.sin(θ) + colc);
                double rowt = (int)((col-colc)*Math.sin(θ) + (row-rowc)*Math.cos(θ) + rowc);

                int intcolt = (int) colt;
                int introwt = (int) rowt;

                if (intcolt>=0 && colt<width){
                    if (introwt>=0 && rowt<height){
                        Color color = picture.getColor(intcolt,introwt);
                        newPic.setColor(col,row,color);
                    }
                }

            }
        }
        return newPic;
    }
    
    /****************
     * CW3 Part A.2 *
     ****************/

    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture emboss(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture newPic = new Picture(width,height);

        Color color1 = null;
        Color color2 = null;
        Color color3 = null;
        Color color4 = null;
        Color color5 = null;
        Color color6 = null;
        Color color7 = null;
        Color color8 = null;
        Color color9 = null;

        for (int col=0; col<width; col++){
            for (int row=0; row<height; row++){
                int cola = col-1;
                int colb = col+1;
                int rowa = row-1;
                int rowb = row+1;
                //左边
                if (col-1<0) {
                    cola = width-1;
                    //左上角
                    if (row-1<0) {
                        rowa = height-1;
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                    //左下角
                    else if (row+1>=height) {
                        rowb = 0;
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                    //左边缘
                    else {
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                }
                //右边
                else if (col+1>=width) {
                    colb = 0;
                    //右上角
                    if (row-1<0) {
                        rowa = height-1;
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                    //右下角
                    else if (row+1>=height) {
                        rowb = 0;
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                    //右边缘
                    else {
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                }
                else {
                    //上边缘
                    if (row - 1 < 0) {
                        rowa = height - 1;
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                    //下边缘
                    else if (row + 1 >= height) {
                        rowb = 0;
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                    //非边缘
                    else {
                        color1 = picture.getColor(cola, rowa);
                        color2 = picture.getColor(cola, row);
                        color3 = picture.getColor(cola, rowb);
                        color4 = picture.getColor(col, rowa);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(col, rowb);
                        color7 = picture.getColor(colb, rowa);
                        color8 = picture.getColor(colb, row);
                        color9 = picture.getColor(colb, rowb);
                    }
                }
                int red = color1.getRed() * (-2)
                        + color2.getRed() * (-1)
                        + color3.getRed() * (0)
                        + color4.getRed() * (-1)
                        + color5.getRed() * (1)
                        + color6.getRed() * (1)
                        + color7.getRed() * (0)
                        + color8.getRed() * (1)
                        + color9.getRed() * (2);
                int green = color1.getGreen() * (-2)
                        + color2.getGreen() * (-1)
                        + color3.getGreen() * (0)
                        + color4.getGreen() * (-1)
                        + color5.getGreen() * (1)
                        + color6.getGreen() * (1)
                        + color7.getGreen() * (0)
                        + color8.getGreen() * (1)
                        + color9.getGreen() * (2);
                int blue = color1.getBlue() * (-2)
                        + color2.getBlue() * (-1)
                        + color3.getBlue() * (0)
                        + color4.getBlue() * (-1)
                        + color5.getBlue() * (1)
                        + color6.getBlue() * (1)
                        + color7.getBlue() * (0)
                        + color8.getBlue() * (1)
                        + color9.getBlue() * (2);
                if (red < 0) {
                    red = 0;
                }
                if (red > 255) {
                    red = 255;
                }
                if (green < 0) {
                    green = 0;
                }
                if (green > 255) {
                    green = 255;
                }
                if (blue < 0) {
                    blue = 0;
                }
                if (blue > 255) {
                    blue = 255;
                }
                int newred = Math.round(red);
                int newgreen = Math.round(green);
                int newblue = Math.round(blue);
                Color newColor = new Color(newred, newgreen, newblue);
                newPic.setColor(col, row, newColor);
            }
        }
        return newPic;
    }

    /****************
     * CW3 Part A.3 *
     ****************/
    
    // Returns a new picture that applies a blur filter to the given picture.
    public static Picture blur(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture newPic = new Picture(width,height);

        Color color1 = null;
        Color color2 = null;
        Color color3 = null;
        Color color4 = null;
        Color color5 = null;
        Color color6 = null;
        Color color7 = null;
        Color color8 = null;
        Color color9 = null;

        for (int col=0; col<width; col++) {
            for (int row = 0; row < height; row++) {
                int cola4 = col - 4;
                int cola3 = col - 3;
                int cola2 = col - 2;
                int cola1 = col - 1;
                int colb1 = col + 1;
                int colb2 = col + 2;
                int colb3 = col + 3;
                int colb4 = col + 4;
                int rowa1 = row - 1;
                int rowa2 = row - 2;
                int rowa3 = row - 3;
                int rowa4 = row - 4;
                int rowb4 = row + 4;
                int rowb3 = row + 3;
                int rowb2 = row + 2;
                int rowb1 = row + 1;

                //左边
                if (cola4<0) {
                    cola4 = width + col - 4;
                    cola3 = width + col - 3;
                    cola2 = width + col - 2;
                    cola1 = width + col - 1;
                    if (cola4 > width-1){
                        cola4 = cola4 - (width-1);
                    }
                    if (cola3 > width-1){
                        cola3 = cola3 - (width-1);
                    }
                    if (cola2 > width-1){
                        cola2 = cola2 - (width-1);
                    }
                    if (cola1 > width-1){
                        cola1 = cola1 - (width-1);
                    }
                    //左上角
                    if (rowa4<0) {
                        rowa4 = height + row - 4;
                        rowa3 = height + row - 3;
                        rowa2 = height + row - 2;
                        rowa1 = height + row - 1;
                        if (rowa4 > height-1){
                            rowa4 = rowa4 - (height-1);
                        }
                        if (rowa3 > height-1){
                            rowa3 = rowa3 - (height-1);
                        }
                        if (rowa2 > height-1){
                            rowa2 = rowa2 - (height-1);
                        }
                        if (rowa1 > height-1){
                            rowa1 = rowa1 - (height-1);
                        }
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                    //左下角
                    else if (rowb4>=height) {
                        rowb4 = row - height + 4;
                        rowb3 = row - height + 3;
                        rowb2 = row - height + 2;
                        rowb1 = row - height + 1;
                        if (rowb4 < 0){
                            rowb4 = rowb4 + (height-1);
                        }
                        if (rowb3 < 0){
                            rowb3 = rowb3 + (height-1);
                        }
                        if (rowb2 < 0){
                            rowb2 = rowb2 + (height-1);
                        }
                        if (rowb1 < 0){
                            rowb1 = rowb1 + (height-1);
                        }
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                    //左边缘
                    else {
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                }
                //右边
                else if (colb4>=width) {
                    colb4 = col - width + 4;
                    colb3 = col - width + 3;
                    colb2 = col - width + 2;
                    colb1 = col - width + 1;
                    if (colb4 < 0){
                        colb4 = colb4 + (width-1);
                    }
                    if (colb3 < 0){
                        colb3 = colb3 + (width-1);
                    }
                    if (colb2 < 0){
                        colb2 = colb2 + (width-1);
                    }
                    if (colb1 < 0){
                        colb1 = colb1 + (width-1);
                    }
                    //右上角
                    if (rowa4<0) {
                        rowa4 = height + row - 4;
                        rowa3 = height + row - 3;
                        rowa2 = height + row - 2;
                        rowa1 = height + row - 1;
                        if (rowa4 > height-1){
                            rowa4 = rowa4 - (height-1);
                        }
                        if (rowa3 > height-1){
                            rowa3 = rowa3 - (height-1);
                        }
                        if (rowa2 > height-1){
                            rowa2 = rowa2 - (height-1);
                        }
                        if (rowa1 > height-1){
                            rowa1 = rowa1 - (height-1);
                        }
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                    //右下角
                    else if (rowb4>=height) {
                        rowb4 = row - height + 4;
                        rowb3 = row - height + 3;
                        rowb2 = row - height + 2;
                        rowb1 = row - height + 1;
                        if (rowb4 < 0){
                            rowb4 = rowb4 + (height-1);
                        }
                        if (rowb3 < 0){
                            rowb3 = rowb3 + (height-1);
                        }
                        if (rowb2 < 0){
                            rowb2 = rowb2 + (height-1);
                        }
                        if (rowb1 < 0){
                            rowb1 = rowb1 + (height-1);
                        }
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                    //右边缘
                    else {
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                }
                else {
                    //上边缘
                    if (rowa4<0) {
                        rowa4 = height + row - 4;
                        rowa3 = height + row - 3;
                        rowa2 = height + row - 2;
                        rowa1 = height + row - 1;
                        if (rowa4 > height-1){
                            rowa4 = rowa4 - (height-1);
                        }
                        if (rowa3 > height-1){
                            rowa3 = rowa3 - (height-1);
                        }
                        if (rowa2 > height-1){
                            rowa2 = rowa2 - (height-1);
                        }
                        if (rowa1 > height-1){
                            rowa1 = rowa1 - (height-1);
                        }
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                    //下边缘
                    else if (rowb4>=height) {
                        rowb4 = row - height + 4;
                        rowb3 = row - height + 3;
                        rowb2 = row - height + 2;
                        rowb1 = row - height + 1;
                        if (rowb4 < 0){
                            rowb4 = rowb4 + (height-1);
                        }
                        if (rowb3 < 0){
                            rowb3 = rowb3 + (height-1);
                        }
                        if (rowb2 < 0){
                            rowb2 = rowb2 + (height-1);
                        }
                        if (rowb1 < 0){
                            rowb1 = rowb1 + (height-1);
                        }
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                    //非边缘
                    else {
                        color1 = picture.getColor(cola4, rowa4);
                        color2 = picture.getColor(cola3, rowa3);
                        color3 = picture.getColor(cola2, rowa2);
                        color4 = picture.getColor(cola1, rowa1);
                        color5 = picture.getColor(col, row);
                        color6 = picture.getColor(colb1, rowb1);
                        color7 = picture.getColor(colb2, rowb2);
                        color8 = picture.getColor(colb3, rowb3);
                        color9 = picture.getColor(colb4, rowb4);
                    }
                }
                int red = (color1.getRed()
                        + color2.getRed()
                        + color3.getRed()
                        + color4.getRed()
                        + color5.getRed()
                        + color6.getRed()
                        + color7.getRed()
                        + color8.getRed()
                        + color9.getRed()) / 9;
                int green = (color1.getGreen()
                        + color2.getGreen()
                        + color3.getGreen()
                        + color4.getGreen()
                        + color5.getGreen()
                        + color6.getGreen()
                        + color7.getGreen()
                        + color8.getGreen()
                        + color9.getGreen()) / 9;
                int blue = (color1.getBlue()
                        + color2.getBlue()
                        + color3.getBlue()
                        + color4.getBlue()
                        + color5.getBlue()
                        + color6.getBlue()
                        + color7.getBlue()
                        + color8.getBlue()
                        + color9.getBlue()) / 9;
                if (red < 0) {
                    red = 0;
                }
                if (red > 255) {
                    red = 255;
                }
                if (green < 0) {
                    green = 0;
                }
                if (green > 255) {
                    green = 255;
                }
                if (blue < 0) {
                    blue = 0;
                }
                if (blue > 255) {
                    blue = 255;
                }
                int newred = Math.round(red);
                int newgreen = Math.round(green);
                int newblue = Math.round(blue);
                Color newColor = new Color(newred, newgreen, newblue);
                newPic.setColor(col, row, newColor);
            }
        }
        return newPic;
    }
    
    
    /****************
     * CW3 Part A.4 *
     ****************/
    
    // Returns a new picture that applies an emboss filter to the given picture.
    public static Picture edge(Picture picture) {
        Picture grayPic = CW3_Example.grayScale(picture);

        int width = grayPic.width();
        int height = grayPic.height();
        Picture newPic = new Picture(width,height);

        Color color1 = null;
        Color color2 = null;
        Color color3 = null;
        Color color4 = null;
        Color color5 = null;
        Color color6 = null;
        Color color7 = null;
        Color color8 = null;
        Color color9 = null;

        for (int col=0; col<width; col++){
            for (int row=0; row<height; row++){
                int cola = col-1;
                int colb = col+1;
                int rowa = row-1;
                int rowb = row+1;
                //左边
                if (col-1<0) {
                    cola = width-1;
                    //左上角
                    if (row-1<0) {
                        rowa = height-1;
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                    //左下角
                    else if (row+1>=height) {
                        rowb = 0;
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                    //左边缘
                    else {
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                }
                //右边
                else if (col+1>=width) {
                    colb = 0;
                    //右上角
                    if (row-1<0) {
                        rowa = height-1;
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                    //右下角
                    else if (row+1>=height) {
                        rowb = 0;
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                    //右边缘
                    else {
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                }
                else {
                    //上边缘
                    if (row - 1 < 0) {
                        rowa = height - 1;
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                    //下边缘
                    else if (row + 1 >= height) {
                        rowb = 0;
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                    //非边缘
                    else {
                        color1 = grayPic.getColor(cola, rowa);
                        color2 = grayPic.getColor(cola, row);
                        color3 = grayPic.getColor(cola, rowb);
                        color4 = grayPic.getColor(col, rowa);
                        color5 = grayPic.getColor(col, row);
                        color6 = grayPic.getColor(col, rowb);
                        color7 = grayPic.getColor(colb, rowa);
                        color8 = grayPic.getColor(colb, row);
                        color9 = grayPic.getColor(colb, rowb);
                    }
                }
                int red1 = color1.getRed() * (-1)
                        + color2.getRed() * (0)
                        + color3.getRed() * (1)
                        + color4.getRed() * (-2)
                        + color5.getRed() * (0)
                        + color6.getRed() * (2)
                        + color7.getRed() * (-1)
                        + color8.getRed() * (0)
                        + color9.getRed() * (1);
                int green1 = color1.getGreen() * (-1)
                        + color2.getGreen() * (0)
                        + color3.getGreen() * (1)
                        + color4.getGreen() * (-2)
                        + color5.getGreen() * (0)
                        + color6.getGreen() * (2)
                        + color7.getGreen() * (-1)
                        + color8.getGreen() * (0)
                        + color9.getGreen() * (1);
                int blue1 = color1.getBlue() * (-1)
                        + color2.getBlue() * (0)
                        + color3.getBlue() * (1)
                        + color4.getBlue() * (-2)
                        + color5.getBlue() * (0)
                        + color6.getBlue() * (2)
                        + color7.getBlue() * (-1)
                        + color8.getBlue() * (0)
                        + color9.getBlue() * (1);
                int red2 = color1.getRed() * (1)
                        + color2.getRed() * (2)
                        + color3.getRed() * (1)
                        + color4.getRed() * (0)
                        + color5.getRed() * (0)
                        + color6.getRed() * (0)
                        + color7.getRed() * (-1)
                        + color8.getRed() * (-2)
                        + color9.getRed() * (-1);
                int green2 = color1.getGreen() * (1)
                        + color2.getGreen() * (2)
                        + color3.getGreen() * (1)
                        + color4.getGreen() * (0)
                        + color5.getGreen() * (0)
                        + color6.getGreen() * (0)
                        + color7.getGreen() * (-1)
                        + color8.getGreen() * (-2)
                        + color9.getGreen() * (-1);
                int blue2 = color1.getBlue() * (1)
                        + color2.getBlue() * (2)
                        + color3.getBlue() * (1)
                        + color4.getBlue() * (0)
                        + color5.getBlue() * (0)
                        + color6.getBlue() * (0)
                        + color7.getBlue() * (-1)
                        + color8.getBlue() * (-2)
                        + color9.getBlue() * (-1);
                double newred = (255-Math.sqrt(red1*red1+red2*red2));
                double newgreen = (255-Math.sqrt(green1*green1+green2*green2));
                double newblue = (255-Math.sqrt(blue1*blue1+blue2*blue2));
                int intnewred = (int) newred;
                int intnewgreen = (int) newgreen;
                int intnewblue = (int) newblue;
                if (intnewred < 0) {
                    intnewred = 0;
                }
                if (intnewred > 255) {
                    intnewred = 255;
                }
                if (intnewgreen < 0) {
                    intnewgreen = 0;
                }
                if (intnewgreen > 255) {
                    intnewgreen = 255;
                }
                if (intnewblue < 0) {
                    intnewblue = 0;
                }
                if (intnewblue > 255) {
                    intnewblue = 255;
                }
                Color newColor = new Color(intnewred, intnewgreen, intnewblue);
                newPic.setColor(col, row, newColor);
            }
        }
        return newPic;
    }
    
    
    public static void main (String[] args) {
        
        Picture andrew = new Picture("src\\cw3\\Andrew.png");
        andrew.show();
        
        tilt(andrew).show();
        Picture tiltAndrew = new Picture("src\\cw3\\Expected\\TiltAndrew.png");
        System.out.println(tilt(andrew).equals(tiltAndrew));
        
        emboss(andrew).show();
        Picture embossAndrew = new Picture("src\\cw3\\Expected\\EmbossAndrew.png");
        System.out.println(emboss(andrew).equals(embossAndrew));
        
        blur(andrew).show();
        Picture blurAndrew = new Picture("src\\cw3\\Expected\\BlurAndrew.png");
        System.out.println(blur(andrew).equals(blurAndrew));
        
        edge(andrew).show();
        Picture edgeAndrew = new Picture("src\\cw3\\Expected\\EdgeAndrew.png");
        System.out.println(edge(andrew).equals(edgeAndrew));
        
    }
    
}
