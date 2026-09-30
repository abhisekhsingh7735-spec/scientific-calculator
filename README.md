# Scientific Calculator

A feature-rich scientific calculator built in Java with a graphical user interface (GUI).

## Features

### Basic Operations
- Addition (+)
- Subtraction (-)
- Multiplication (×)
- Division (÷)
- Modulus (%)

### Scientific Functions
- Trigonometric: sin, cos, tan
- Inverse Trigonometric: asin, acos, atan
- Logarithmic: log (base 10), ln (natural log)
- Exponential: e^x, 2^x, x^y
- Square root (√)
- Factorial (!)
- Absolute value (|x|)

### Additional Features
- Clear (C) - Reset calculator
- Delete (DEL) - Remove last digit
- Parentheses support for complex expressions
- History of calculations
- Memory functions (M+, M-, MR, MC)

## Getting Started

### Prerequisites
- Java 8 or higher
- JDK installed on your system

### Running the Calculator

```bash
# Compile the project
javac src/*.java

# Run the application
java -cp src CalculatorApp
```

## Project Structure

```
scientific-calculator/
├── src/
│   ├── Calculator.java          # Core calculator logic
│   ├── CalculatorGUI.java       # GUI implementation
│   └── CalculatorApp.java       # Main entry point
├── README.md
└── LICENSE
```

## Usage

1. Launch the application
2. Click number buttons to enter values
3. Select operations (basic or scientific)
4. Press equals (=) to get the result
5. Use memory buttons to store/recall values

## Contributing

Feel free to fork, modify, and submit pull requests!

## License

MIT License - See LICENSE file for details
