import fs from 'fs';
import path from 'path';
import { fileURLToPath } from 'url';

// Get the directory name from import.meta.url
const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

// Define the file path for the JSON file
const FILE_PATH = path.join(__dirname, 'employees.json');

// Function to read existing data from the JSON file
function readExistingData() {
    if (fs.existsSync(FILE_PATH)) {
        const data = fs.readFileSync(FILE_PATH, 'utf8');
        return JSON.parse(data);
    }
    return [];
}

// Function to write a new employee object to the JSON file
function writeEmployeeToFile(employee) {
    const existingData = readExistingData();
    
    // Add the new employee to the existing data
    existingData.push(employee);
    
    // Write the updated data back to the file
    fs.writeFileSync(FILE_PATH, JSON.stringify(existingData, null, 4), 'utf8');
}

// Function to print all employee details
function printAllEmployees() {
    const data = readExistingData();
    if (data.length === 0) {
        console.log("No employee data found.");
        return;
    }
    
    data.forEach(employee => {
        console.log(`ID: ${employee.id}, Name: ${employee.name}, Salary: ${employee.salary}`);
    });
}

// Main function to collect employee details and perform actions
async function main() {
    const { createInterface } = await import('readline');
    const rl = createInterface({
        input: process.stdin,
        output: process.stdout
    });

    // Collect employee details from user input
    rl.question("Enter employee ID: ", (id) => {
        rl.question("Enter employee name: ", (name) => {
            rl.question("Enter employee salary: ", (salary) => {
                // Create an employee object
                const employee = {
                    id: id,
                    name: name,
                    salary: parseFloat(salary)
                };

                // Write employee to file
                writeEmployeeToFile(employee);
                
                // Print all employees
                console.log("\nAll Employee Details:");
                printAllEmployees();
                
                rl.close();
            });
        });
    });
}

// Execute the main function
main();
