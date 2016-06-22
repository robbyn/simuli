package org.tastefuljava.simuli.render;

import java.awt.Rectangle;

public enum HorizontalAlignment {
    LEFT("Left") {
        @Override
        void adjustWidth(Rectangle rc, int w) {
            rc.width = w;
        }
    },
    RIGHT("Right") {
        @Override
        void adjustWidth(Rectangle rc, int w) {
            rc.x += rc.width - w;
            rc.width = w;
        }
    },
    CENTER("Center") {
        @Override
        void adjustWidth(Rectangle rc, int w) {
            rc.x += (rc.width - w) / 2;
            rc.width = w;
        }
    };

    private final String title;

    private HorizontalAlignment(String title) {
        this.title = title;
    }

    abstract void adjustWidth(Rectangle rc, int w);

    @Override
    public String toString() {
        return title;
    }   
}
