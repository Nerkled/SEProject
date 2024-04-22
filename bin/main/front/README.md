# Lucas Number Sequence Calculator

This repository contains the front-end component for calculating the Lucas number sequence based on user input. The Lucas number sequence is a series of numbers where each number is the sum of its two preceding numbers.

## Features

1. **Input Options:**
   - User can input numbers individually or provide a list of numbers.
   - Alternatively, users can upload a text file containing a list of numbers.

2. **Calculation:**
   - The frontend will send the user input to the backend, where the Java code calculates the Lucas number sequence.

3. **Output:**
   - Once the calculation is complete, the frontend will display the resulting Lucas number sequence to the user.

## Technologies

  - HTML, CSS, JavaScript

## Implementation Details

- **Backend Integration:**
  - The frontend communicates with the backend, which contains the Java code responsible for calculating the Lucas number sequence.
  
- **File Upload Handling:**
  - If a text file is uploaded, the frontend sends the file data to the backend for processing.

## Usage

1. Enter numbers individually into the input field, separated by spcae.
2. Or upload a text file containing a list of numbers.
3. Click the "Calculate" button.
4. View the resulting Lucas number sequence displayed on the interface.

## Setup

To run the front-end component, follow these steps:

1. Clone this repository.
2. Open the `index.html` file in a web browser.

## Future Enhancements

- Error Handling: Implement robust error handling to handle various user input scenarios.
- Performance Optimization: Optimize the frontend and backend code for faster processing of large datasets.
- Additional Features: Explore adding options for different number sequences or customization options for users.
