package CW3;

import java.awt.Color;

/**
 * CPT105 2020 Coursework 3 Part B
 */
public class CW3_Part_B {

    /****************
     * CW3 Part B.1 *
     ****************/

    // Original picture and positionally transformed picture.
    public static Picture positionalTransform(Picture picture) {
        int width = picture.width();
        int height = picture.height();
        Picture newPic = new Picture(width,height);

        for (int col=0; col<width; col++) {
            for (int row=0; row<height; row++) {
                newPic.setColor(col, row, Color.BLACK);
            }
        }

        //θ表示图像主对角线与左边缘的夹角,它对应的弧度为rad1
        //d表示的是某一个像素到主对角线的距离
        double rad1 = 0;
        double d = 0;
        double newcol = 0;
        double newrow = 0;

        if (width<height){
            double i = Math.atan(height/width);
            rad1 = 0.5*Math.PI-i;
        }
        if (width>=height){
            rad1 = Math.atan(width/height);
        }

        for (int col=0; col<width; col++) {
            for (int row=0; row<height; row++) {
                //α表示的是某一个像素与左上角的连线与左边界的夹角，它对应的弧度为rad2
                //对于边缘，col或row为0会导致三角函数错误，但直接不用管边缘！因为边缘像素拉伸后绝对出界，直接if掉
                if (col!=0 && row!=0){
                    double rad2 = Math.atan(col/row);
                    //对角线以下、对角线、对角线以上 三块区域分开讨论
                    if (rad2<rad1) {
                        d = (Math.sin(rad1 - rad2) / Math.sin(rad2)) * col;
                        newcol = col - d * Math.cos(rad1);
                        newrow = row - d * Math.sin(rad1);
                    }
                    else if (rad2>rad1) {
                        d = (Math.sin(rad2 - rad1) / Math.sin(rad2)) * col;
                        newcol = col + d * Math.cos(rad1);
                        newrow = row + d * Math.sin(rad1);
                    }
                    else {
                        newcol = col;
                        newrow = row;
                    }
                }

                int intnewcol = (int) newcol;
                int intnewrow = (int) newrow;

                //对于变换后在width*height范围内的像素才允许提取色彩填充
                if (intnewcol>=0 && intnewcol<width){
                    if (intnewrow>=0 && intnewrow<height){
                        Color color = picture.getColor(intnewcol,intnewrow);
                        newPic.setColor(col,row,color);
                    }
                }

            }
        }

        //合并图片
        Picture FinalPic = new Picture(width*2,height);
        for (int col=0; col<width; col++) {
            for (int row=0; row<height; row++) {
                FinalPic.setColor(col, row, picture.getColor(col, row));
                FinalPic.setColor(col+width, row, newPic.getColor(col, row));
            }
        }
        return FinalPic;
    }


    /****************
     * CW3 Part B.2 *
     ****************/

    // Original picture and color transformed picture.
    public static Picture colorTransform(Picture picture) {

        //Picture grayPic = CW3_Example.grayScale(picture);
        //进行灰度处理
        int width = picture.width();
        int height = picture.height();
        Picture grayPic = new Picture(width, height);
        for (int col = 0; col < width; col++) {
            for (int row = 0; row < height; row++) {

                Color color = picture.getColor(col, row);
                int r = color.getRed();
                int g = color.getGreen();
                int b = color.getBlue();
                double luminance = 0.299 * r + 0.587 * g + 0.114 * b;
                int y = (int) (Math.round(luminance));
                Color gray = new Color(y, y, y);
                grayPic.setColor(col, row, gray);
            }
        }

        width = grayPic.width();
        height = grayPic.height();
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
                int red1 = color1.getRed() * (9)
                        + color2.getRed() * (8)
                        + color3.getRed() * (7)
                        + color4.getRed() * (6)
                        + color5.getRed() * (5)
                        + color6.getRed() * (6)
                        + color7.getRed() * (7)
                        + color8.getRed() * (8)
                        + color9.getRed() * (9);
                int green1 = color1.getRed() * (1)
                        + color2.getRed() * (2)
                        + color3.getRed() * (-1)
                        + color4.getRed() * (-2)
                        + color5.getRed() * (0)
                        + color6.getRed() * (0)
                        + color7.getRed() * (3)
                        + color8.getRed() * (4)
                        + color9.getRed() * (-3);
                int blue1 = color1.getBlue() * (9)
                        + color2.getBlue() * (8)
                        + color3.getBlue() * (7)
                        + color4.getBlue() * (6)
                        + color5.getBlue() * (5)
                        + color6.getBlue() * (6)
                        + color7.getBlue() * (7)
                        + color8.getBlue() * (8)
                        + color9.getBlue() * (9);
                int red2 = color1.getBlue() * (9)
                        + color2.getBlue() * (8)
                        + color3.getBlue() * (7)
                        + color4.getBlue() * (6)
                        + color5.getBlue() * (5)
                        + color6.getBlue() * (6)
                        + color7.getBlue() * (7)
                        + color8.getBlue() * (8)
                        + color9.getBlue() * (9);
                int green2 = color1.getGreen() * (1)
                        + color2.getGreen() * (2)
                        + color3.getGreen() * (1)
                        + color4.getGreen() * (0)
                        + color5.getGreen() * (0)
                        + color6.getGreen() * (0)
                        + color7.getGreen() * (-1)
                        + color8.getGreen() * (-2)
                        + color9.getGreen() * (-1);
                int blue2 = color1.getBlue() * (9)
                        + color2.getBlue() * (8)
                        + color3.getBlue() * (7)
                        + color4.getBlue() * (6)
                        + color5.getBlue() * (5)
                        + color6.getBlue() * (6)
                        + color7.getBlue() * (7)
                        + color8.getBlue() * (8)
                        + color9.getBlue() * (9);
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

        //合并图片
        Picture FinalPic = new Picture(width*2,height);
            for (int col=0; col<width; col++) {
                for (int row=0; row<height; row++) {
                    FinalPic.setColor(col, row, picture.getColor(col, row));
                    FinalPic.setColor(col+width, row, newPic.getColor(col, row));
                }
            }
        return FinalPic;
    }


    public static void main(String[] args) {
        Picture Positional1 = new Picture ("src\\cw3\\PartB\\Inception.jpg");
        positionalTransform(Positional1).show();

        Picture Positional2 = new Picture ("src\\cw3\\PartB\\Memento.jpg");
        positionalTransform(Positional2).show();

        Picture Positional3 = new Picture ("src\\cw3\\PartB\\TeacherMa.jpg");
        positionalTransform(Positional3).show();

        Picture Color1 = new Picture("src\\cw3\\PartB\\CB.jpg");
        colorTransform(Color1).show();

        Picture Color2 = new Picture ("src\\cw3\\PartB\\SB.jpg");
        colorTransform(Color2).show();

        Picture Color3 = new Picture ("src\\cw3\\PartB\\SZ.jpg");
        colorTransform(Color3).show();
    }

}