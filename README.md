<p align="center">
  <a href="https://git.io/typing-svg">
    <img src="https://readme-typing-svg.demolab.com?font=Fira+Code&weight=600&size=28&pause=1000&color=6DB33F&center=true&vCenter=true&width=600&lines=Coworking+Hub+%E2%80%94+Enterprise+Booking+System;Java+17+%2B+Spring+Boot+3+%2B+Spring+Cloud;Microservices+Architecture+%2B+Docker" alt="Typing SVG" />
  </a>
</p>

<p align="center">
  <i>A full-stack enterprise booking management system built on a modular Microservices Architecture with Spring Cloud Eureka & API Gateway.</i>
</p>

<p align="center">
  <img src="https://img.shields.io/badge/Java-17-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Boot-3.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white"/>
  <img src="https://img.shields.io/badge/Spring_Cloud-Eureka-6DB33F?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Architecture-Microservices-007396?style=for-the-badge"/>
  <img src="https://img.shields.io/badge/Docker-Containerized-2496ED?style=for-the-badge&logo=docker&logoColor=white"/>
</p>

---

## 📱 Project Overview

**Coworking Hub** is a full-stack, enterprise-grade booking management system built on a modular **Microservices Architecture**. The platform allows users to discover coworking spaces, reserve private desks and meeting rooms, and manage user accounts securely.

It leverages **Spring Cloud Eureka** for service discovery and an **API Gateway** to route requests efficiently across decentralized microservices.

---

## 🏗️ Architecture & Services

The application is decomposed into independent, scalable microservices:

* 🌐 **API Gateway (`port: 8080`):** Single entry point routing frontend client requests to appropriate services.
* 🔎 **Discovery Service (`port: 8761`):** Eureka Discovery Server for registration and dynamic service lookup.
* 👤 **User Service (`port: 8081`):** Handles authentication, profile creation, and user management.
* 📅 **Booking Service (`port: 8082`):** Core domain service for managing workspace availability and room reservations.
* 💻 **Frontend Service:** Responsive user dashboard for browsing spaces and completing bookings.

---

## 🛠️ Tech Stack

<p align="left">
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/java/java-original.svg" alt="java" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/spring/spring-original.svg" alt="spring" width="40" height="40"/>
  <img src="https://raw.githubusercontent.com/devicons/devicon/master/icons/docker/docker-original.svg" alt="docker" width="40" height="40"/>
</p>

| Layer | Technologies |
| :--- | :--- |
| **Backend Framework** | Java, Spring Boot, Spring Data JPA |
| **Microservices Suite** | Spring Cloud Eureka (Discovery), Spring Cloud Gateway |
| **Build & Tools** | Maven (`mvnw`), PowerShell Orchestration |
| **Containerization** | Docker, Docker Compose (`docker-compose.yml`) |

---

## 📸 System Screenshots

| Eureka Discovery Dashboard | Booking & Workspace UI |
| :---: | :---: |
| <img src="https://via.placeholder.com/450x250?text=Eureka+Dashboard+(:8761)" width="450"/> | <img src="https://via.placeholder.com/450x250?text=Booking+Interface" width="450"/> |

---

## 🚀 How to Run the Services

### Prerequisites
* Java JDK installed
* Maven / Docker (Optional)

### Automated Startup
Run the Powershell orchestration script from the project root:
```powershell
.\run-all-services.ps1
