package br.pro.hashi.ensino.desagil.aps.model.model;

import java.awt.*;

public class Light implements Receiver {
    private Color color;
    private Emitter emitter;
    private Color offColor;

    public Light(int r, int g, int b) {
        color = new Color(r, g, b);
        emitter = null;
        offColor = new Color (0, 0, 0);
    }

    public Color getColor() {
        if (emitter != null && emitter.read()) {
            return color;
        }
        return offColor;
    }

    public void setColor(Color color) {
        //this.offColor = offColor;
        this.color = color;
    }

    /*
    public void setOffColor(Color offColor) {
        this.offColor = offColor;
    }

     */



    @Override
    public void connect(int inputIndex, Emitter emitter) {
        if (inputIndex != 0) {
            throw new IndexOutOfBoundsException(inputIndex);
        }
        this.emitter = emitter;
    }
}
