import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @program: JavaUrlTest
 * @description:
 * @author: 60007949
 * @create: 2022-02-07 15:47
 **/
public class JavaUrlTest {
    public static void main(String[] args) throws IOException {
        URL url = new URL("http://www.baidu.com");
        InputStream in = url.openStream();
    }
}
