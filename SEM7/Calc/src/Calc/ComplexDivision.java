package Calc;

public class ComplexDivision implements iComplexOperation {
    @Override
    public ComplexNumber calculate(ComplexNumber num1, ComplexNumber num2) {
        double denominator = num2.real() * num2.real() + num2.imaginary() * num2.imaginary();
        double realPart = (num1.real() * num2.real() + num1.imaginary() * num2.imaginary()) / denominator;
        double imaginaryPart = (num1.imaginary() * num2.real() - num1.real() * num2.imaginary()) / denominator;
        return new ComplexNumber(realPart, imaginaryPart);
    }
}
