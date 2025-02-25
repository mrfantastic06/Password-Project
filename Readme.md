# Report: Password Generator
## Introduction
This project focuses on developing a Java-based password generator that allows users to create secure and customizable passwords. The program provides options for users to specify the desired password length, include different types of characters (lowercase, uppercase, digits, symbols), and generate passwords that adhere to basic security standards. Additionally, the program evaluates the generated password's strength, providing feedback on its security based on common industry standards.

## Features and Functionality
### Input
The program takes several inputs from the user to define the password's characteristics:

Password Length: The user specifies both the minimum and maximum length for the generated password.

Character Types: The user can select which character sets to include in the password. 

#### Options include:
##### Lowercase letters (a-z)
##### Uppercase letters (A-Z)
##### Digits (0-9)
##### Special symbols (e.g., !@#$%^&*())

### Output
The program generates a password that meets the following criteria:

1. The password length is randomly selected within the provided minimum and maximum range.
2. The password includes the specified character types, ensuring compliance with the user's preferences.
3. The password's strength is evaluated and classified as "Weak," "Moderate," or "Strong," based on the password's length, character variety, and complexity.

### Password Strength Evaluation
The strength of the generated password is determined based on several factors:

1. Length: A password should be at least 8 characters long to be considered reasonably secure.
2. Character Variety: A secure password should contain at least one lowercase letter, one uppercase letter, one digit, and one symbol.
3. Score System: The program uses a simple scoring system to classify the password:

    1. Weak: If only basic criteria (length and one character type) are met.
    2. Moderate: If some additional criteria (e.g., a mix of character types) are met.
    3. Strong: If the password satisfies most of the criteria (e.g., length, lowercase/uppercase letters, digits, and symbols).

## Design Choices
The password generation is performed using the SecureRandom class, which ensures better randomness compared to the default Random class. This is particularly important in generating passwords for security-sensitive applications.

The program constructs the password by:

Building a character set based on the user's preferences. Randomly selecting characters from this set to create the final password.
User Input Handling
The program ensures that user inputs are validated to prevent errors such as setting the minimum password length greater than the maximum length. The program also provides a default message in case the user does not select any character types, prompting them to make a selection.

## Password Strength Evaluation
The strength evaluation uses a simple algorithm that checks for the presence of lowercase, uppercase, digit, and symbol characters. The password length is also considered in determining strength, with longer passwords generally being more secure.

## Challenges Encountered
Handling User Input: One of the main challenges was ensuring that user inputs, such as character type selections and length constraints, were validated properly to avoid invalid or illogical password settings.

Ensuring Randomness: Ensuring true randomness in password generation was a key design consideration, which led to the use of SecureRandom. While it offers better security, it requires careful handling of the random number generation to maintain fairness.

Password Strength Evaluation: Defining a clear and understandable method for evaluating password strength was another challenge. Balancing simplicity with comprehensive security standards led to the chosen scoring system, which categorizes passwords into "Weak," "Moderate," and "Strong."

## Conclusion
The Password Generator project successfully provides a tool that allows users to create secure passwords based on customizable parameters. By using the SecureRandom class and incorporating password strength evaluation, the