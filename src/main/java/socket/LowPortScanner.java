package socket;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * 扫描tcp端口
 */
public class LowPortScanner {
    public static void main(String[] args) {
        String host = args.length > 0 ? args[0] : "localhost";
        for (int i = 1; i < 1024; i ++) {
            try (Socket socket = new Socket(host, i)) {
                System.out.println("There is a server on port " + i + " of" + host);
            } catch (UnknownHostException e) {
                break;
            } catch (IOException e) {
                System.out.println(i);
            }
        }
    }
}
