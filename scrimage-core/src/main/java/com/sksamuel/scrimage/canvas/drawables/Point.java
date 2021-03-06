package com.sksamuel.scrimage.canvas.drawables;

import com.sksamuel.scrimage.canvas.Drawable;
import com.sksamuel.scrimage.canvas.GraphicsContext;
import com.sksamuel.scrimage.graphics.RichGraphics2D;

public class Point implements Drawable {
    private final int x;
    private final int y;
    private final GraphicsContext context;

    public Point(int x, int y, GraphicsContext context) {
        this.x = x;
        this.y = y;
        this.context = context;
    }

    @Override
    public void draw(RichGraphics2D g) {
        g.drawLine(x, y, x, y);
    }

    @Override
    public GraphicsContext context() {
        return context;
    }
}
