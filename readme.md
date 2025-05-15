
# AWS Docker Project

## 📌 Project Description

This project demonstrates the deployment of a Spring Boot-based web application using Docker containers on an AWS EC2 instance. The application performs basic CRUD operations for managing person information.

## 🚀 Technologies Used

- **Spring Boot** 3.4.2  
- **MySQL** 8.0  
- **Docker & Docker Compose**  
- **Nginx** (as a Reverse Proxy)  
- **AWS EC2** (Ubuntu 22.04 LTS)  
- **Gradle** (Build tool)  
- **Bootstrap 5** (Frontend styling)

## 🏗️ Architectural Structure

- **Spring Boot Application**  
  A RESTful web service that performs CRUD operations on a `Person` entity. (Runs on port **8080**)

- **MySQL**  
  Used for persistent storage of person data.

- **Nginx**  
  Acts as a reverse proxy forwarding HTTP requests from port **80** to **8080**.

- **Docker**  
  All components (Spring Boot App, MySQL, Nginx) run in isolated Docker containers via Docker Compose.

---

## 🔧 Project Steps

### ✅ Local Development

1. Develop the Spring Boot application.
2. Build the application JAR using Gradle:
   ```bash
   ./gradlew build
   ```
3. Create the Docker image:
   ```bash
   docker build -t mehmettalha/awsdocker:latest .
   ```
4. Run locally using Docker Compose:
   ```bash
   docker-compose up
   ```

### ☁️ Push to Docker Hub

1. Login to Docker Hub:
   ```bash
   docker login
   ```
2. Push the image:
   ```bash
   docker push mehmettalha/awsdocker:latest
   ```

### 🌐 Deployment on AWS EC2

1. Launch an EC2 instance (Ubuntu 22.04).
2. Connect via SSH:
   ```bash
   ssh -i <your-key.pem> ubuntu@<your-ec2-ip>
   ```
3. Install Docker and Docker Compose:
   ```bash
   sudo apt update
   sudo apt install docker.io docker-compose -y
   sudo systemctl enable docker
   sudo systemctl start docker
   sudo usermod -aG docker ubuntu
   ```
4. Copy project files to EC2:
   ```bash
   scp -i <your-key.pem> docker-compose.yml nginx.conf ubuntu@<your-ec2-ip>:~/
   ```
5. Start the application:
   ```bash
   docker-compose up -d
   ```

---

## ⚙️ CI/CD Implementation

Continuous Integration and Deployment (CI/CD) pipelines are implemented to automate:
- Build
- Test
- Deployment

This ensures fast, repeatable, and reliable application updates.

---

## 🌐 Access Information

- **Docker Hub**: [https://hub.docker.com/r/mehmettalha/awsdocker](https://hub.docker.com/r/mehmettalha/awsdocker)
- **AWS EC2 Public URL**: `http://[EC2-PUBLIC-IP]`

---

## 📝 Update Notes

- ✅ Port changed from **8090** to **8080**
- ✅ Frontend redesigned using **Bootstrap 5**
- ✅ Improved **Nginx** configuration
- ✅ Added **restart policies** in `docker-compose.yml`

---

## 📂 Project Structure

```plaintext
├── src/
├── build.gradle
├── Dockerfile
├── docker-compose.yml
├── nginx.conf
└── README.md
```
