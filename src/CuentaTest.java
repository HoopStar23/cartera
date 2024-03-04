import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CuentaTest {

    @Test
    void testCrearCuenta0(){
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ASSERT
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testIngresar100EnCuentaVacia(){
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ACT
        c.ingresar(100);

        //ASSERT
        assertEquals(100, c.getSaldo());
    }

    @Test
    void testIngresar3000EnCuentaVacia(){
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ACT
        c.ingresar(3000);

        //ASSERT
        assertEquals(3000, c.getSaldo());
    }

    @Test
    void testIngresar100EnCuenta3000AlSaldo(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(100);

        //ACT
        c.ingresar(3000);

        //ASSERT
        assertEquals(3100, c.getSaldo());
    }

    @Test
    void testIngresarValorNegativoEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ACT
        c.ingresar(-100);

        //ASSERT
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testIngresarValorDecimalEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ACT
        c.ingresar(100.45);

        //ASSERT
        assertEquals(100.45, c.getSaldo());
    }

    @Test
    void testCantidadMaxIngresarEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ACT
        c.ingresar(6000.00);

        //ASSERT
        assertEquals(6000, c.getSaldo());
    }

    @Test
    void testCantidadMaxIngresarEnCuenta2(){//CAMBIE
        //Arrange SET UP
        Cuenta c = new Cuenta();

        //ACT
        c.ingresar(7000.01);

        //ASSERT
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testRestarCantidadEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(10);

        //ACT
        c.retirar(10);

        //ASSERT
        assertEquals(0, c.getSaldo());
    }

    @Test
    void testRestarCantidadEnCuenta2(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(500);

        //ACT
        c.retirar(100);

        //ASSERT
        assertEquals(400, c.getSaldo());
    }

    @Test
    void testRetirarCantidadMayorAlSaldoEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(200);

        //ACT
        c.retirar(500);

        //ASSERT
        assertEquals(200, c.getSaldo());
    }

    @Test
    void testRetirarCantidadNegativoAlSaldoEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(500);

        //ACT
        c.retirar(-100);

        //ASSERT
        assertEquals(500, c.getSaldo());
    }

    @Test
    void testRetirarCantidadDecimalAlSaldoEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(500);

        //ACT
        c.retirar(100.45);

        //ASSERT
        assertEquals(399.55, c.getSaldo());
    }

    @Test
    void testRetirarCantidadMaximoAlSaldoEnCuenta(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(7000);

        //ACT
        c.retirar(6000);

        //ASSERT
        assertEquals(1000, c.getSaldo());
    }

    @Test
    void testRetirarCantidadMaximoAlSaldoEnCuenta2(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        c.ingresar(7000);

        //ACT
        c.retirar(6000.01);

        //ASSERT
        assertEquals(7000, c.getSaldo());
    }

    @Test
    void testTransferenciaSaldo(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        Cuenta c2 = new Cuenta();
        c.ingresar(500);
        c2.ingresar(50);

        //ACT
        c.transferencia(100,c,c2);

        //ASSERT
        assertEquals(400, c.getSaldo());
        assertEquals(150, c2.getSaldo());
    }

    @Test
    void testTransferenciaNegativoSaldo(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        Cuenta c2 = new Cuenta();
        c.ingresar(500);
        c2.ingresar(50);

        //ACT
        c.transferencia(-100,c,c2);

        //ASSERT
        assertEquals(500, c.getSaldo());
        assertEquals(50, c2.getSaldo());
    }

    @Test
    void testTransferenciaMaximoSaldo(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        Cuenta c2 = new Cuenta();
        c.ingresar(3500);
        c2.ingresar(50);

        //ACT
        c.transferencia(3000,c,c2);

        //ASSERT
        assertEquals(500, c.getSaldo());
        assertEquals(3050, c2.getSaldo());
    }

    @Test
    void testTransferenciaMaximoSaldo2(){
        //Arrange SET UP
        Cuenta c = new Cuenta();
        Cuenta c2 = new Cuenta();
        c.ingresar(3500);
        c2.ingresar(50);

        //ACT
        c.transferencia(3000.01,c,c2);

        //ASSERT
        assertEquals(3500, c.getSaldo());
        assertEquals(50, c2.getSaldo());
    }
}