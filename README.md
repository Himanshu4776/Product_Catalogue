# Product Catalogue

Product Catalogue is a full-stack e-commerce product catalog application that provides product results based on product characteristics. It combines Angular for the frontend and Spring Boot with Hibernate for the backend, using MySQL as the database. The frontend and backend communicate through APIs developed by Spring Boot, with Angular consuming the API data.

This project was completed during my Nagarro Java ASE training and secured best score among all trainees.

### Check it out live on: https://youtu.be/xXMENclldzY

## Technologies Used

- **Frontend**: Angular
- **Backend**: Spring Boot with Hibernate
- **Database**: MySQL

## Features

- **Product Search**: Search for products based on various characteristics, including name tag, brand tag, and product code.
- **Pincode Availability**: Check the availability of products in a particular pincode.
- **Frontend-Backend Interaction**: The frontend and backend communicate seamlessly via APIs.
- **Database Storage**: MySQL is used to store product data, ensuring data reliability and persistence.

## Getting Started

Follow these steps to get the Product Catalogue application up and running on your local machine.

### Prerequisites

- Node.js and npm for Angular.
- Java Development Kit (JDK) for Spring Boot.
- MySQL database server.

### Installation

1. **Frontend (Angular)**

   ```bash
   cd frontend/
   npm install
   ng serve
   ```

   Access the frontend at `http://localhost:4200`.

2. **Backend (Spring Boot)**

   - Set up a MySQL database and configure the connection in `application.properties`.
   - Open the backend in your favorite IDE and run the Spring Boot application.

### Usage

- Access the application in your web browser.
- Search for products based on desired characteristics, such as name tag, brand tag, or product code.
- Check the availability of products in a particular pincode.
- Explore the product catalog and discover various products.
