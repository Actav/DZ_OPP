package Calc;

public class ComplexMultiplication implements iComplexOperation {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double realPart = num1.real() * num2.real() - num1.imaginary() * num2.imaginary();
        double imaginaryPart = num1.real() * num2.imaginary() + num1.imaginary() * num2.real();
        return new ComplexNumber(realPart, imaginaryPart);
    }
}
