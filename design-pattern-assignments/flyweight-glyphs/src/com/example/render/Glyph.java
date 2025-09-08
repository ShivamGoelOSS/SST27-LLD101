package com.example.render;

public class Glyph {
    // Intrinsic state: shared TextStyle
    private final TextStyle style;
    // Extrinsic state: character specific to this glyph
    private final char ch;

    public Glyph(char ch, TextStyle style) {
        this.ch = ch;
        this.style = style;
    }

    public int drawCost() { 
        return style.getSize() + (style.isBold() ? 10 : 0); 
    }
    
    public char getCh() { 
        return ch; 
    }
    
    public TextStyle getStyle() { 
        return style; 
    }
    
    public String getFont() { 
        return style.getFont(); 
    }
    
    public int getSize() { 
        return style.getSize(); 
    }
    
    public boolean isBold() { 
        return style.isBold(); 
    }
}
