import java.text.DecimalFormat;
import java.util.Scanner;

public class Sqr {

        public static void main(String[] args) {
            // TODO 自动生成的方法存根
            Scanner scan = new Scanner(System.in);

            DecimalFormat df = new DecimalFormat("#.000");
            int sc = scan.nextInt();
            System.out.print(sc + "的算术平方根是：");
            System.out.println(df.format(SQR(sc)));
        }

    /**
     * 牛顿下降法
     * 根据f(x)在x0附近的值和斜率，估计f(x)和x轴的交点
     *  求xn 的下一个值，有y/x = f'(x)  => x = y/f'x) ;y=f(x)
     *  故有 x2 = x1 - f(x)/f'(x)
     *  此处求平方根 则f(x)=x^2-a;(a为待求)，寻找f(x)满足精度条件
     *  x2 = x1 - (x1^2-a)/x1
     *  x2 = x1/2.0 + a/(2*x1)
     * @param a
     * @return
     */
        public static double SQR(int a) {
            double x1 = 1, x2;// x1 为任意初始值，迭代逼近
            x2 = x1 / 2.0 + a / (2 * x1);//牛顿迭代公式
            while (Math.abs(x2 - x1) > 1e-4) {
                x1 = x2;
                x2 = x1 / 2.0 + a / (2 * x1);
            }
            return x2;
        }
    }

