package equals;

import java.util.Objects;

class Circle implements Comparable<Circle> {
        Integer xPos, yPos, radius;

        public Circle(int x, int y, int r) {
            xPos = x;
            yPos = y;
            radius = r;
        }

        @Override
        public int hashCode() {
            return Objects.hash(xPos, yPos, radius);
        }

        @Override
        public boolean equals(Object arg) {
            if (arg == null) return false;
            if (this == arg) return true;
            if (arg instanceof Circle) {
                Circle that = (Circle) arg;
                if ((this.xPos == that.xPos) && (this.yPos == that.yPos)
                        && (this.radius == that.radius)) {
                    return true;
                }
            }
            return false;
        }

        @Override
        public int compareTo(Circle o) {
            if(equals(o)) {
                return 0;
            }
            return this.xPos.compareTo(o.xPos);
        }

    @Override
    public String toString() {
        return "Circle"+Integer.toHexString(super.hashCode())+"{" +
                "xPos=" + xPos +
                ", yPos=" + yPos +
                ", radius=" + radius +
                '}';
    }
}