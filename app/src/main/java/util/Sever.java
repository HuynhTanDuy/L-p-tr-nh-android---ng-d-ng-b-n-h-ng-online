package util;

public class Sever {
    public static String localhost = "192.168.1.17";
    public static String producttypelink = "http://"+localhost+ "/Sever/getdevicetype.php";
    public static String newproduct = "http://"+localhost+":80/Sever/getnewproduct.php";
    public static String product = "http://"+localhost+":80/Sever/getproduct.php";
    public static String billlink = "http://"+localhost+":80/Sever/customerinformation.php";
    public static String orderdetaillink = "http://"+localhost+":80/Sever/orderdetail.php";
}
