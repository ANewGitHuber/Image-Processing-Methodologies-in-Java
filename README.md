# Image-Processing-Methodologies-in-Java

## Code Description for Image Processing Part_A.java

## 1. Picture tilt(Picture picture) 

### This method tilts a picture by rotating the picture 30 degrees clockwise.

To rotate a picture by θ radians counterclockwise, it copies the color of each pixel (cols, rows) in the source picture to a target pixel (colt, rowt) whose coordinates (in int) are given by the following formulas:

colt = (int) ( (cols - colc) × cos θ - (rows - rowc) × sin θ + colc ) 

rowt = (int) ( (cols - colc) × sin θ + (rows - rowc) × cos θ + rowc )

where colc and rowc are the coordinates (in double) of the center of the width-by-height picture, computed by:

colc = 0.5 × (width - 1)

rowc = 0.5 × (height - 1)

Only copy the pixel if the target pixel is in bounds, so as not to change the dimension of the image. Use black for target pixels with no copied color.

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/3ae1c49a-c05f-4cf7-99a5-8c7d28af1179)

## 2. Picture emboss(Picture picture)

### This method adds an emboss style effect to a picture by applying the following kernel.

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/e6bac862-6aff-4864-a3a5-fe6fc7b121a5)

A kernel filter modifies the pixels in a picture by replacing each pixel with a linear combination of its neighboring pixels and itself. The matrix that characterizes the linear combination is known as the kernel.

Specifically, to apply a kernel filter to a picture, perform the following operation for each RGB components of each pixel p separately:
 Align the center of the kernel on pixel p.

 The new component value of pixel p is obtained by multiplying each kernel element with the corresponding component value, and adding the results.
After that, combine the results to get the new color.

For example, to apply an emboss kernel filter to the middle Red component value of 50 of a pixel on some part of a picture:

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/c5874da0-88e3-49c7-a1b5-4c82c2ffdef6)

we compute the new value to be

= (-2)10 + (-1)20 + (0)30 + (-1)40 + (1)50 + (1)40 + (0)10 + (1)20 + (2)30 = 90.

We then combine that with the similar computation on the Green and Blue components to obtain the new color of the corresponding pixel.

Note the following important information about the computation:

- Periodic boundary conditions. When applying a kernel filter to a pixel near the boundary, some of its neighboring pixels may not exist. In such cases, assume the leftmost column wraps around to the rightmost column, and vice versa; and the top row wraps around to the bottom row, and vice versa. For example:

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/0c69e420-cf3c-496c-aaba-ac02a3f3895b)

- Rounding. When applying a kernel filter, the resulting RGB components may become fractional if the kernel weights are fractional. Round each RGB component to the nearest integer, with ties rounding up, with Math.round() and then casting to int.

- Clamping. When applying a kernel filter, the resulting RGB components may not remain between 0 and 255. If an RGB component of a pixel is less than 0, set it to 0; if is greater than 255, set it to 255.

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/4ca6fca4-60e4-4b0e-8737-ad4b57a681c1)

## 3. Picture blur(Picture picture)

### This method blurs a picture by applying the following kernel (one-ninth in a 9-by-9 diagonal matrix).

This means applying the diagonal matrix, and then dividing the result by 9:

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/43426ef5-e84f-494d-a909-bd2fe764cb1a)

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/b1cbfa55-d27f-40e2-838e-acf95e41193b)

## 4. Picture edge(Picture picture)

### This method performs edge detection of a picture.

First convert the picture into a grayscale picture. You can achieve that by simply calling the static grayScale(picture) method, which is provided as part of the example code, and is similar to the method created in your lab classes.

Picture grayPic = CW3_Example.grayScale(picture);

Next, apply these two kernels to each grayscale component (you only need to do one computation since all three color components of a grayscale picture are the same) of a pixel, the following:

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/6df3c82f-c50b-44c8-8a6d-6c1edfae8ec3)

to obtain the value Gx, and the following

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/9be292f7-bfd9-4e7f-9e9a-51f2f92f68be)

to obtain the value Gy.

Finally, convert to int with casting and clamp the value ![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/69ef7996-8618-4ead-844c-293cf7ba08c4), and then set the color of that pixel to 255 – G.

![image](https://github.com/ANewGitHuber/Image-Processing-Methodologies-in-Java/assets/88078123/61acabff-5e05-4310-9f99-f696707ddbdb)

