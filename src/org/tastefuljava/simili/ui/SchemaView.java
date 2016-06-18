package org.tastefuljava.simili.ui;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.util.Properties;
import javax.swing.JComponent;
import org.tastefuljava.simili.geometry.PaintContext;
import org.tastefuljava.simili.model.Schema;

public class SchemaView extends JComponent {
    private final Properties props = new Properties();
    private Schema schema;

    public Schema getSchema() {
        return schema;
    }

    public void setSchema(Schema schema) {
        this.schema = schema;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (schema != null) {
            paintSchema((Graphics2D)g);
        }
    }

    private void paintSchema(Graphics2D g) {
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        FontRenderContext frc = g.getFontRenderContext();
        PaintContext pc = new PaintContext(frc, props);
        Rectangle rc = g.getClipBounds();
        pc.paint(g, schema, rc.x, rc.y, rc.width, rc.height);
    }
}
