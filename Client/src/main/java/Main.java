import java.io.IOException;
import java.net.ConnectException;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    final static Logger LOG = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException {


        System.out.println("### Teaching-HEIGVD-RES-2019-Exercise-Calculator  Client ###");

        Scanner scanner = new Scanner(System.in);
        String ipv4UserInput = args[0];
        String portUserInput = args[1];
        boolean isUserInputOK;
        InetAddress ipAddress;
        int port;

        ipAddress = InetAddress.getByName(ipv4UserInput);
        port = Integer.parseInt(portUserInput);


        // connect by TCP with the server
        TCPClient tcpClient = null;
        try {
            tcpClient = new TCPClient(ipAddress, port);
        } catch (IOException e) {
            LOG.log(Level.SEVERE, "Failed to connect to the server\n");
        }

        // allows commandLineCommunication with the server
        try {
            tcpClient.commandLineCommunication();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            tcpClient.closeConnection();
        }
    }
}
