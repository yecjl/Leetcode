import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class PrintUtils {
    enum Color {
        RED, GREEN, YELLOW, BLUE, PURPLE, DARKGREEN, GRAY, WHITE
    }

    public static void println(String str, Color color) {
        System.out.println(getColorStr(str, color));
    }

    public static void println(String str) {
        println(str, Color.RED);
    }

    public static String getColorStr(String str, Color color) {
        return getColorStr(str, color, null);
    }

    public static String getColorStr(String str, Color color, Color background) {
        String colorStr = "";
        String backgroundStr = "";
        if (color != null) {
            switch (color) {
                case RED:
                    colorStr = "31";
                    break;
                case GREEN:
                    colorStr = "32";
                    break;
                case YELLOW:
                    colorStr = "33";
                    break;
                case BLUE:
                    colorStr = "34";
                    break;
                case PURPLE:
                    colorStr = "35";
                    break;
                case DARKGREEN:
                    colorStr = "36";
                    break;
                default:
                    break;
            }
        }
        if (background != null) {
            switch (background) {
                case WHITE:
                    backgroundStr = "40";
                    break;
                case RED:
                    backgroundStr = "41";
                    break;
                case GREEN:
                    backgroundStr = "42";
                    break;
                case YELLOW:
                    backgroundStr = "43";
                    break;
                case BLUE:
                    backgroundStr = "44";
                    break;
                case PURPLE:
                    backgroundStr = "45";
                    break;
                case DARKGREEN:
                    backgroundStr = "46";
                    break;
                case GRAY:
                    backgroundStr = "47";
                    break;
                default:
                    break;
            }
        }
        if ("".equals(colorStr) && "".equals(backgroundStr)) {
            return str;
        }
        if (!"".equals(colorStr) && !"".equals(backgroundStr)) {
            backgroundStr = backgroundStr + ";";
        }
        return ("\033[" + backgroundStr + colorStr + "m" + str + "\033[5m");
    }

    public static String getColorStr(String str, int index, Color color, Color background) {
        if (index < str.length()) {
            StringBuilder sb = new StringBuilder();
            sb.append(str.substring(0, index));
            char charAt = str.charAt(index);
            sb.append(getColorStr(String.valueOf(charAt), color, background));
            sb.append(str.substring(index + 1));
            return sb.toString();
        }
        return str;
    }

    public static String getColorStr(String str, int index) {
        return getColorStr(str, index, Color.RED, null);
    }

    public static String getColorStr(String str, int index, Color background) {
        return getColorStr(str, index, Color.RED, background);
    }

    public static String getColorStr(String str, ColorParam[] colorParams) {
        if (colorParams != null && colorParams.length > 0) {
            List<String> list = new ArrayList<>();
            int[] deals = new int[str.length()];
            Color[] dealColors = new Color[str.length()];
            Color[] dealBackgrounds = new Color[str.length()];
            for (ColorParam colorParam : colorParams) {
                int index = colorParam.index;
                int begin = colorParam.begin;
                int end = colorParam.end;
                Color color = colorParam.color;
                Color background = colorParam.background;
                if (index != -1) {
                    if (color != null) {
                        dealColors[index] = color;
                    }
                    if (background != null) {
                        dealBackgrounds[index] = background;
                    }
                }
                if (end != 0 && end >= begin) {
                    end = end > str.length() ? str.length() : end;
                    for (int i = begin; i < end; i++) {
                        if (color != null) {
                            dealColors[i] = color;
                        }
                        if (background != null) {
                            dealBackgrounds[i] = background;
                        }
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < str.length(); i++) {
                char charAt = str.charAt(i);
                sb.append(getColorStr(String.valueOf(charAt), dealColors[i], dealBackgrounds[i]));
            }
            return sb.toString();
        }
        return str;
    }

    public static void main(String[] args) {
//        System.out.println("step " + 1 + " : sChar(" + getColorStr("aaab", 3) + ") == pChar(" + getColorStr("aa*aaab", 2) + ")");
//        System.out.println("step " + 1 + " : sChar(" + getColorStr("aaab", 3) + ") == pChar(" + getColorStr("aa*aaab", new ColorParam[]{new ColorParam(1, Color.DARKGREEN), new ColorParam(3, Color.RED)}) + ")");
//        System.out.println("step " + 1 + " : sChar(" + getColorStr("aaab", 3, Color.WHITE) + ") == pChar(" + getColorStr("aa*aaab", new ColorParam[]{new ColorParam(1, Color.DARKGREEN), new ColorParam(3, Color.RED)}) + ")");
//        System.out.println("step " + 1 + " : sChar(" +
//                        getColorStr("aaaaabvvvedd",
//                                new ColorParam[]{
//                                        new ColorParam(0, 2, null, Color.WHITE),
//                                        new ColorParam(4, 5, null, Color.WHITE),
//                                        new ColorParam(0, Color.RED),
//                                        new ColorParam(7,8, Color.RED, Color.WHITE)
//                                })
//        );

//
//        System.out.println("-----LE PETIT MINT-----");
//        BigDecimal a1 = new BigDecimal("224");
//        BigDecimal a2 = new BigDecimal("298");
//        System.out.println("衣服 = " + a1);
//        System.out.println("裤子 = " + a2);
//        BigDecimal c1 = new BigDecimal("600").subtract(a1).subtract(a2);
//        System.out.println("**凑单** = " + c1);
//        System.out.println("-----HOPE SHOW-----");
//        BigDecimal b1 = new BigDecimal("563.4");
//        BigDecimal b2 = new BigDecimal("263.4");
//        BigDecimal b3 = new BigDecimal("261.4");
//        BigDecimal c2 = new BigDecimal("600").subtract(b1);
//        System.out.println("衣服 = " + b1 + ", **凑单** = " + c2);
//        System.out.println("裤子 = " + b2);
//        System.out.println("衬衫 = " + b3);
//        BigDecimal c3 = new BigDecimal("600").subtract(b2).subtract(b3);
//        System.out.println("**凑单** = " + c3);
//        System.out.println("----------");
//        System.out.println("**1、凑单** = " + (600-80-40));
//        System.out.println("**2、凑单** = " + (600-80-40));
//        System.out.println("**3、凑单** = " + (600-80-40));
//        System.out.println("**总共** = " + (480*3));
//        System.out.println("----------");
//        BigDecimal z1 = b1.add(a1).subtract(new BigDecimal(80 + 40));
//        System.out.println("**1、非凑单** = " + z1);
//        BigDecimal z2 = a2.add(b2).add(b3).subtract(new BigDecimal(80 + 40));
//        System.out.println("**2、非凑单** = " + z2);
//        System.out.println("**总共** = " + z1.add(z2));
//        System.out.println("----------");
//        System.out.println("**凑与不凑的差别** = " + new BigDecimal(480*3).subtract(z1).subtract(z2));
//        System.out.println("**不凑商品总价** = " + a1.add(a2).add(b1).add(b2).add(b3));
//        System.out.println("**凑商品总价** = " + a1.add(a2).add(b1).add(b2).add(b3).add(c1).add(c2).add(c3));
//        System.out.println("**还需凑商品总价** = " + c1.add(c2).add(c3));
//
//
//        System.out.println("**** = " + (1061.3 - (299*2*0.88-10-40)/2));
//        System.out.println("**** = " + (476.2/2+565.1));
        double x = -123.888;
        int y = (int) x;
        System.out.println("**** y= " + y);

    }

    static class ColorParam {
        public int index = -1;
        public Color color;
        public Color background;
        public int begin;
        public int end;

        public ColorParam(int index) {
            this(index, Color.RED);
        }

        public ColorParam(int index, Color color) {
            this(index, color, null);
        }

        public ColorParam(int index, Color color, Color background) {
            this.index = index;
            this.color = color;
            this.background = background;
        }

        public ColorParam(int begin, int end, Color color) {
            this(begin, end, color, null);
        }

        public ColorParam(int begin, int end, Color color, Color background) {
            this.begin = begin;
            this.end = end;
            this.color = color;
            this.background = background;
        }
    }

}
