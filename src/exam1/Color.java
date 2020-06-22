package exam1;

import java.io.Serializable;

enum Color implements Serializable {
    R(1), G(2),B(3);
    int c;

    Color(int c) {
        this.c=c;
    }
}
