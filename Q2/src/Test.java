import java.util.Date;
import java.util.Date;
import java.util.concurrent.TimeUnit;
public class Test {


    public static void main(String[] args) {



//        Maintest s = new Maintest();
//
//        System.out.println(s.getAgeInSeconds());


        try
        {
            System.out.println("Start of delay: "+ new Date());
            // Delay for 7 seonds
            Thread.sleep(7000);
            System.out.println("End of delay: "+ new Date());
        }
        catch(InterruptedException ex)
        {
            ex.printStackTrace();
        }
    }
}
