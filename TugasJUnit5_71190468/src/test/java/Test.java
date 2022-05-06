import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;



public class Test {

    static Pajak pajak;

    @BeforeAll
    static void init(){
        pajak = new Pajak();
    }

    private static Stream<Arguments> eCParameters(){
        return Stream.of(
                Arguments.of(0,2000000),
                Arguments.of(10,10000000),
                Arguments.of(22,20000000),
                Arguments.of(40f,50000000),
                Arguments.of(-1,-1000),
                Arguments.of(-1,1000000000000d)
        );
    }

    @ParameterizedTest
    @MethodSource("eCParameters")
    public void testEc(float expected, double salary){
        Assertions.assertNotNull(pajak);
        Assertions.assertEquals(expected,pajak.getPajak(salary));
    }

    private static Stream<Arguments> bva1Parameters(){
        return Stream.of(

                Arguments.of(true,3999999),
                Arguments.of(true,4000000),
                Arguments.of(false,4000001)

        );
    }

    @ParameterizedTest
    @MethodSource("bva1Parameters")
    public void testBva1(boolean expected,double salary){
        Assertions.assertNotNull(pajak);
        Assertions.assertEquals(expected,pajak.getPajak(salary)==0);
    }

    private static Stream<Arguments> bva2Parameters(){
        return Stream.of(
                Arguments.of(true,14999999),
                Arguments.of(true,15000000),
                Arguments.of(false,15000001)
        );
    }

    @ParameterizedTest
    @MethodSource("bva2Parameters")
    public void testBva2(boolean expected,double salary){

        Assertions.assertNotNull(pajak);
        Assertions.assertEquals(expected,pajak.getPajak(salary)==10);

    }

    private static Stream<Arguments> bva3Parameters(){
        return Stream.of(
                Arguments.of(true,39999999),
                Arguments.of(true,40000000),
                Arguments.of(false,40000001)
        );
    }

    @ParameterizedTest
    @MethodSource("bva3Parameters")
    public void testBva3(boolean expected,double salary){

        Assertions.assertNotNull(pajak);
        Assertions.assertEquals(expected,pajak.getPajak(salary)==22);

    }

    private static Stream<Arguments> bva4Parameters(){
        return Stream.of(
                Arguments.of(true,99999999998f),
                Arguments.of(true,999999999999f),
                Arguments.of(false,1000000000000d)
        );
    }

    @ParameterizedTest
    @MethodSource("bva4Parameters")
    public void testBva4(boolean expected,double salary){

        Assertions.assertNotNull(pajak);
        Assertions.assertEquals(expected,pajak.getPajak(salary)==40f);

    }

    @AfterAll
    static void clean(){
        pajak = null;
    }

}
