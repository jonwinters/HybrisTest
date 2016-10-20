import org.junit.Test;
import pw.jonwinters.hybris.Operator;

/**
 * Created by Administrator on 2016/10/20 0020.
 */
public class TestSort {
    @Test
    public void testDeliverA(){
        Operator operator = new Operator();
        operator.operatorRepository("A",2);
    }

    //@Test
    public void testDelverB(){
        Operator operator = new Operator();
        operator.operatorRepository("B",4);
    }
}
