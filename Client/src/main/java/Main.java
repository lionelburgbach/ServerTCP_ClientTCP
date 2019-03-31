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

    /*
    static InetAddress parseIPv4Address(String ipv4Address) throws UnknownHostException, IllegalArgumentException {
        String[] lines = ipv4Address.split("\\.");
        if(lines.length != 4) throw new IllegalArgumentException("ipv4 address argument should be string of" +
                "type: ?.?.?.?\n ? being a number between 0 and 255");
        byte[] bytes = new byte[4];


        //TODO change this if it is not suitable
        bytes[0] = (byte) Integer.parseInt(lines[0]);
        bytes[1] = (byte) Integer.parseInt(lines[1]);
        bytes[2] = (byte) Integer.parseInt(lines[2]);
        bytes[3] = (byte) Integer.parseInt(lines[3]);
        /*
        bytes[0] = Byte.parseByte(lines[0], 10);
        bytes[1] = Byte.parseByte(lines[1], 10);
        bytes[2] = Byte.parseByte(lines[2], 10);
        bytes[3] = Byte.parseByte(lines[3], 10);
        return Inet4Address.getByAddress(bytes);
    }

    static int parsePortNumber(String port){
        return Integer.parseInt(port);
    }
    */

}
