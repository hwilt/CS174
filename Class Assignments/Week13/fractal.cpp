#include <stdio.h>
#include <stdlib.h>
#include "BMP.h"

#define MAX_DEPTH 8

int color[3][4] = {{255, 0 , 0, 255}, {0, 255, 0, 255}, {0, 0, 255, 255}}; 


/**
 * Draw a triangle at the specified coordinates
 * @param canvas Reference to the bitmap to which to draw triangle
 * @param x0, y0, x1, y1, x2, y2: Coordinates of points
 * @param thickness Thickness of line to draw
 */
void drawTriangle(BMP* canvas, int x0, int y0, int x1, int y1, int x2, int y2, int thickness) {
    int i = rand() % 3;
    canvas->plotLine(x0, y0, x1, y1, thickness, color[i][0], color[i][1], color[i][2], color[i][3]);
    canvas->plotLine(x1, y1, x2, y2, thickness, color[i][0], color[i][1], color[i][2], color[i][3]);
    canvas->plotLine(x2, y2, x0, y0, thickness, color[i][0], color[i][1], color[i][2], color[i][3]);
}

/**
 * Draw a triangle at the specified coordinates
 * @param canvas Reference to the bitmap to which to draw triangle
 * @param x0, y0, x1, y1, x2, y2: Coordinates of points
 * @param depth Depth of recursion
 */
void drawSierpinski(BMP* canvas, int x0, int y0, int x1, int y1, int x2, int y2, int depth) {
    drawTriangle(canvas, x0, y0, (x1+x0)/2, (y1+y0)/2, (x2+x0)/2, (y2+y0)/2, 1);
    drawTriangle(canvas, (x0+x1)/2, (y0+y1)/2, x1, y1, (x2+x1)/2, (y2+y1)/2, 1);
    drawTriangle(canvas, (x0+x2)/2, (y0+y2)/2, (x2+x1)/2, (y1+y2)/2, x2, y2, 1);
    if(depth <= MAX_DEPTH){
        drawSierpinski(canvas, x0, y0, (x1+x0)/2, (y1+y0)/2, (x2+x0)/2, (y2+y0)/2, depth + 1);
        drawSierpinski(canvas, (x0+x1)/2, (y0+y1)/2, x1, y1, (x2+x1)/2, (y2+y1)/2, depth + 1);
        drawSierpinski(canvas, (x0+x2)/2, (y0+y2)/2, (x2+x1)/2, (y1+y2)/2, x2, y2, depth + 1);
    }
}

int main() {
    int W = 1000;
    int H = 1000;
    BMP canvas(W, H);
    canvas.clearRect(0xFF, 0xFF, 0xFF, 0xFF);
    drawSierpinski(&canvas, 5, 5, 500, 990, 1000, 5, 0);

    canvas.write("result.bmp");
    return 0;
}