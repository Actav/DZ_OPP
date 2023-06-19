package Model;

public record ComplexNumber(double real, double imaginary) {
    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}
