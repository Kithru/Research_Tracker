-- CREATE DATABASE researchtracker;
-- USE researchtracker;


-- -- //////////////////////  User Table  ///////////////////////
-- CREATE TABLE users (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     username VARCHAR(50) NOT NULL UNIQUE,
--     password VARCHAR(255) NOT NULL,
--     full_name VARCHAR(100),
--     email VARCHAR(100) UNIQUE,
--     role VARCHAR(20) NOT NULL DEFAULT 'MEMBER',
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
-- );

-- -- //////////////////////  Projects Table  ///////////////////////
-- CREATE TABLE projects (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     title VARCHAR(255) NOT NULL,
--     description TEXT,
--     start_date DATE,
--     end_date DATE,
--     pi_id BIGINT,  -- foreign key to users table
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (pi_id) REFERENCES users(id) ON DELETE SET NULL
-- );


-- -- //////////////////////  Milestones Table  ///////////////////////
-- CREATE TABLE milestones (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     project_id BIGINT NOT NULL,
--     title VARCHAR(255) NOT NULL,
--     description TEXT,
--     due_date DATE,
--     status VARCHAR(20) DEFAULT 'PENDING',
--     created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE
-- );



-- -- //////////////////////  Documents Table  ///////////////////////
-- CREATE TABLE documents (
--     id BIGINT AUTO_INCREMENT PRIMARY KEY,
--     project_id BIGINT NOT NULL,
--     file_name VARCHAR(255) NOT NULL,
--     file_path VARCHAR(255) NOT NULL,
--     uploaded_by BIGINT,
--     uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
--     FOREIGN KEY (project_id) REFERENCES projects(id) ON DELETE CASCADE,
--     FOREIGN KEY (uploaded_by) REFERENCES users(id) ON DELETE SET NULL
-- );








CREATE DATABASE researchtracker;
USE researchtracker;

CREATE TABLE users (
    id VARCHAR(36) PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    full_name VARCHAR(100),
    role VARCHAR(20) NOT NULL DEFAULT 'MEMBER',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE projects (
    id VARCHAR(36) PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    start_date DATE,
    end_date DATE,
    pi_id VARCHAR(36),
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_project_pi
        FOREIGN KEY (pi_id) REFERENCES users(id)
        ON DELETE SET NULL
);

CREATE TABLE milestones (
    id VARCHAR(36) PRIMARY KEY,
    project_id VARCHAR(36) NOT NULL,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    due_date DATE,
    completed BOOLEAN DEFAULT FALSE,
    created_by VARCHAR(36) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_milestone_project
        FOREIGN KEY (project_id) REFERENCES projects(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_milestone_created_by
        FOREIGN KEY (created_by) REFERENCES users(id)
);

CREATE TABLE documents (
    id VARCHAR(36) PRIMARY KEY,
    project_id VARCHAR(36) NOT NULL,
    file_name VARCHAR(255) NOT NULL,
    file_path VARCHAR(255) NOT NULL,
    uploaded_by VARCHAR(36),
    uploaded_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT fk_document_project
        FOREIGN KEY (project_id) REFERENCES projects(id)
        ON DELETE CASCADE,
    CONSTRAINT fk_document_uploaded_by
        FOREIGN KEY (uploaded_by) REFERENCES users(id)
        ON DELETE SET NULL
);
