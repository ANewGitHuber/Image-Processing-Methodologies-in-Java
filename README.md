# Image-Processing-Methodologies-in-Java

Code Description for Image Processing Part_A.java

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


