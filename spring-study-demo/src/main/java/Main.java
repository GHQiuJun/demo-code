import demo.aop.XmlAopService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @program: Main
 * @description: 测试类
 * @author: 60007949
 * @create: 2022-03-25 12:23
 **/
public class Main {
    public static void main(String[] args) {
/*        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-config.xml");
        final XmlAopService xmlAopService = applicationContext.getBean(XmlAopService.class);
        xmlAopService.print();*/

        System.out.println(convert("PAYPALISHIRING", 3));
    }

    public static String convert(String s, int numRows) {
        /**
         * 思路：
         * 维护一个大小为numRows的字符数组，对应展开后的二维数组的每一行
         * z数组的周期 t = 2 * numRows -2;
         *
         */
        int length = s.length();
        if (numRows < 2) {
            return s;
        }

        String[] z = new String[numRows];
        // 周期
        final int t = 2 * numRows - 2;

        for (int i = 0; i < length;) {
            // 处理一个周期
            boolean cycle = true;
            int tempRow = 0;
            for (int j = 0; j < t; j++) {
                z[tempRow] = z[tempRow] == null ? String.valueOf(s.charAt(i)) : z[tempRow].concat(String.valueOf(s.charAt(i)));

                if (tempRow + 1 == numRows && cycle) {
                    tempRow--;
                    cycle = false;
                } else if (!cycle) {
                    tempRow--;
                } else {
                    tempRow++;
                }

                i++;
                // 不满足一个周期的场景
                if (i >= length) {
                    break;
                }
            }
        }

        // 拼接字符
        StringBuilder newStr = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            newStr.append(z[i]);
        }
        return newStr.toString();
    }
}
