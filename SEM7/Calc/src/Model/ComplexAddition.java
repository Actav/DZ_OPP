package Model;

public class ComplexAddition implements iComplexOperation {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.real() + num2.real();
        double imaginaryPart = num1.imaginary() + num2.imaginary();
        return new ComplexNumber(realPart, imaginaryPart);
    }
}