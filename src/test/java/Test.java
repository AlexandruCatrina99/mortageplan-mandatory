import java.io.FileNotFoundException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

public class Test {
    @org.junit.Test
    public void CustomerFunctionsTest(){
        Prospect c = new Prospect("Test",1000,5,2);
        assertEquals(4,c.pow(2,2),0.001); //2^2=4
        /*
        E=U[b(1+b)^p]/[(1+b)^p-1]
        u=100
        b=0.05/12
        p=2*12=24
        E=1000*[(0.05/12)*(1+(0.05/12))^24]/[((1+(0.05/12))^24-1] = 43.87
         */
        assertEquals(43.87,c.calculateMonthlyPayment(),0.01);

    }
    @org.junit.Test
    public void ReadFileTest(){
        Main test = new Main();
        ArrayList<Prospect> arr=Main.readFile("prospects.txt");
        assertEquals(4,arr.size());

    }
}
