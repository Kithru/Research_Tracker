# Research_Tracker
Research_Tracker
# 📘 Research Tracker System

## 🧭 Overview
The **Research Tracker System** is a web-based application designed for educational and research institutions to efficiently manage and monitor academic research projects. It streamlines collaboration among teams by providing structured project tracking, document management, and role-based access control.

This platform ensures transparency and accountability throughout the research lifecycle — from project proposal to completion.

---

## 🚀 Features
- **User Authentication & Role Management**
  - Secure login and role-based access control with Spring Security.
  - Supports four distinct roles: **ADMIN**, **PI (Principal Investigator)**, **MEMBER**, and **VIEWER**.

- **Project Management**
  - Create, assign, and track research projects.
  - Manage participants, supervisors, and collaborators.

- **Milestone Tracking**
  - Log and monitor milestones throughout the research process.
  - Track progress with timeline-based reporting.

- **Document Management**
  - Upload and manage research documents and progress reports.
  - Secure file storage with access permissions based on user roles.

- **Dashboard & Reports**
  - Visual representation of ongoing and completed projects.
  - Progress tracking and summary analytics.

---

## 🧩 Technology Stack

| Layer | Technology |
|-------|-------------|
| **Backend** | Spring Boot (Java 17+) |
| **Frontend** | Thymeleaf, HTML, CSS, JavaScript |
| **Database** | MySQL |
| **Security** | Spring Security (BCrypt password encryption) |
| **Build Tool** | Maven |
| **Version Control** | Git & GitHub |

---

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone https://github.com/Kithru/Research_Tracker.git
cd Research_Tracker
```

### 2. Database Setup
- Create a new MySQL database:
  ```sql
  CREATE DATABASE research_tracker;
  ```
- Import the complete schema and data from the provided **migration.sql** file:
  ```bash
  mysql -u root -p research_tracker < migration.sql
  ```
  > 💡 The `migration.sql` file contains all required **table creation scripts** and **constraints**.

### 3. Update Configuration
Edit `src/main/resources/application.properties`:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/researchtracker
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=none
```

### 4. Build and Run
```bash
mvn clean install
mvn spring-boot:run
```

### 5. Access the Application
Visit: [http://localhost:8081](http://localhost:8081)

---

## 👥 User Roles

| Role | Description |
|------|--------------|
| **ADMIN** | Manages system-wide settings, users, and projects. |
| **PI (Principal Investigator)** | Leads research projects, manages milestones, and supervises members. |
| **MEMBER** | Contributes to assigned projects, uploads documents, and updates milestones. |
| **VIEWER** | Read-only access to view project details and progress. |

---

## 🧾 API Endpoints

| Method | Endpoint | Description |
|--------|-----------|-------------|
| `POST` | `/api/auth/signup` | Register a new user |
| `POST` | `/api/auth/login` | Authenticate user |
| `GET`  | `/api/projects` | Retrieve all projects |
| `POST` | `/api/projects` | Create a new project |
| `PUT`  | `/api/projects/{id}` | Update project details |
| `DELETE` | `/api/projects/{id}` | Delete a project |

---

## 📂 Project Structure
```
Research_Tracker/
 ├── migration.sql
 ├── pom.xml
 ├── src/
 │   ├── main/
 │   │   ├── java/lk/ijse/cmjd/
 │   │   │   ├── auth/
 │   │   │   ├── config/
 │   │   │   ├── controller/
 │   │   │   ├── model/
 │   │   │   ├── repository/
 │   │   │   └── service/
 │   │   └── resources/
 │   │       ├── templates/
 │   │       ├── static/
 │   │       └── application.properties
 └── README.md
```

---

## 🧠 Future Enhancements
- Email notifications for project milestones.
- Advanced analytics dashboards for Admin and PI roles.
- Integration with Google Drive or AWS S3.
- Export reports (PDF/Excel) based on role permissions.

---

## 👨‍💻 Author
**Kithru Viduranga**  
🔗 [https://github.com/Kithru](https://github.com/Kithru)
