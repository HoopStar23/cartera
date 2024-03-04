public class Cuenta {
    private double saldo;

    public Cuenta() {
        saldo = 0;
    }

    public double getSaldo() {
        return saldo;
    }

    public void ingresar(double cantidad) {
        if (cantidad < 0.00 || cantidad > 7000.00) {
            cantidad = 0;
        }
        saldo += cantidad;
    }

    public void retirar(double cantidad){
        if (cantidad > saldo || cantidad < 0 || cantidad > 6000.00) {
            cantidad = 0;
        }
        saldo -= cantidad;
    }

    public void transferencia(double cantidad, Cuenta c1, Cuenta c2){
        if (cantidad > 0 && cantidad <= 3000) {
            c1.retirar(cantidad);
            c2.ingresar(cantidad);
        }
    }
}
