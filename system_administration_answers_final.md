# System Administration Final Answers

This document provides a comprehensive set of answers to the system administration questions provided. The answers are structured to be detailed, clear, and easy to understand, following all user instructions.

---

## SECTION A

### a) What is system administration and what do systems administrators do? [4 Marks]

**Introduction**
System administration is a crucial function within any organization that relies on computer systems. It is the backbone of the IT infrastructure, ensuring that all systems are running efficiently, securely, and reliably to support business operations.

**Definition**
**System administration** is the field of work in which an individual or a team manages and maintains a multi-user computer environment, such as a local area network (LAN), a wide area network (WAN), or a server farm. The goal is to ensure the continuous and optimal performance of IT services and support systems.

**What System Administrators Do**
A system administrator, often called a sysadmin, is responsible for the upkeep, configuration, and reliable operation of computer systems, especially multi-user computers like servers. Their key responsibilities include:

1.  **Installation and Configuration:** Installing and configuring new hardware, software, and operating systems. This includes setting up servers, workstations, and network services like DNS, DHCP, and email.
2.  **Maintenance and Upgrades:** Performing regular maintenance, applying updates and security patches to operating systems and applications to protect against vulnerabilities.
3.  **Performance Monitoring:** Continuously monitoring system performance to identify bottlenecks and potential issues. They use various tools to track CPU usage, memory, and disk space to ensure systems are running at peak performance.
4.  **User and Security Management:** Creating, managing, and deleting user accounts. They set and maintain security policies, manage access controls (permissions), and monitor for security breaches.
5.  **Backup and Disaster Recovery:** Implementing and managing backup solutions for all critical data. They are also responsible for creating, testing, and executing a disaster recovery plan to restore IT services after a critical failure.
6.  **Troubleshooting:** Diagnosing and resolving hardware, software, networking, and system issues when they arise. This is often the most visible part of their job.
7.  **Documentation:** Maintaining detailed documentation of system configurations, procedures, and troubleshooting guides.

---

### b) With the help of a well labeled diagram define the term system in the context of system administration. [5 Marks]

**Definition**
In the context of system administration, a **system** is not just a single computer. It is a complex and integrated collection of components (hardware, software, network, users, and processes) that work together to perform a set of specific functions and provide services. A sysadmin manages the system as a whole, not just its individual parts.

**Well-Labeled Diagram of a System**

```
      +-------------------------------------------------+
      |                      USERS                      |
      | (Interacting via applications)                  |
      +-----------------------^-------------------------+
                              |
      +-----------------------v-------------------------+
      |                  APPLICATIONS                   |
      | (e.g., Web Browser, Database Client, ERP)       |
      +-----------------------^-------------------------+
                              |
      +-----------------------v-------------------------+
      |                OPERATING SYSTEM (OS)            |
      | (Manages Hardware, Provides Services to Apps)   |
      +-----------------------^-------------------------+
                              |
      +-----------------------v-------------------------+
      |                     HARDWARE                    |
      | (CPU, RAM, Storage/Disks, I/O Devices)          |
      +-----------------------^-------------------------+
                              |
      +-----------------------v-------------------------+
      |                     NETWORK                     |
      | (Connects the system to other systems/internet) |
      +-------------------------------------------------+
```

**Explanation of Components:**

*   **Users:** The individuals who interact with the system to perform tasks.
*   **Applications:** The software programs that users interact with directly. These applications rely on the operating system to function.
*   **Operating System (OS):** The core software that acts as an intermediary between the hardware and the application software. It manages resources, schedules tasks, and provides common services.
*   **Hardware:** The physical components of the computer, including the Central Processing Unit (CPU), memory (RAM), hard drives (Storage), and network cards.
*   **Network:** The infrastructure that connects the system to other computers and the internet, allowing for communication and data exchange.

A sysadmin must understand how all these layers interact to effectively manage and troubleshoot the entire system.

---

### c) Write down a SHUTDOWN command to schedule a system shutdown to occur in 5 minutes, displaying the message "System will shut down in 5 minutes." to the user. [3 Marks]

**Command (for Windows CMD/PowerShell):**

```bash
shutdown /s /t 300 /c "System will shut down in 5 minutes."
```

**Explanation:**

*   **`shutdown`**: The executable command to initiate the shutdown sequence.
*   **`/s`**: This switch specifies to **s**hut down the computer completely.
*   **`/t 300`**: This switch sets the **t**imeout period before shutdown in seconds. `5 minutes * 60 seconds/minute = 300 seconds`.
*   **`/c "..."`**: This switch allows you to add a **c**omment or message that will be displayed in the shutdown dialog box on the screen for all users.

---

### d) Write down and explain the qualities of a Successful System administrator. [2 Marks]

1.  **Problem-Solving Skills:** A sysadmin must be able to methodically and logically troubleshoot complex technical issues, often under pressure. This involves gathering information, identifying the root cause, and implementing an effective solution.
2.  **Attention to Detail:** Small configuration errors can lead to major system failures. A successful sysadmin is meticulous and thorough in their work, whether it's writing a script, applying a patch, or reviewing security logs.
3.  **Strong Communication Skills:** They must be able to clearly explain technical issues to non-technical users and communicate effectively with vendors and other IT professionals.
4.  **A Desire to Learn:** The IT landscape is constantly evolving. A good sysadmin is proactive about learning new technologies and adapting their skills to stay current.

---

### e) You have a folder named "OldFiles" containing several files. Write a CMD command that moves all files from the "OldFiles" folder to a new folder named "ProcessedFiles" located in the same directory. The script should create "ProcessedFiles" if it doesn't already exist. [4 Marks]

**CMD Script:**

```cmd
if not exist "ProcessedFiles" mkdir "ProcessedFiles"
move "OldFiles\\*.*" "ProcessedFiles\\"
```

**Explanation:**

1.  **`if not exist "ProcessedFiles" mkdir "ProcessedFiles"`**:
    *   This is a conditional command. It first checks for the existence of a directory named `ProcessedFiles`.
    *   If the directory does **not exist**, the `mkdir "ProcessedFiles"` command is executed, which creates the directory. This prevents errors that would occur if you tried to move files into a non-existent folder.

2.  **`move "OldFiles\\*.*" "ProcessedFiles\\"`**:
    *   The `move` command is used to move files from a source to a destination.
    *   `"OldFiles\\*.*"` is the source. It specifies all files (`*.*`) inside the `OldFiles` directory.
    *   `"ProcessedFiles\\"` is the destination directory where the files will be moved.

---

### f) Write a CMD script that Creates a new folder named "Backup" in the current directory and Copies all files with the .txt extension from the current directory into the "Backup" folder. [4 Marks]

**CMD Script:**

```cmd
mkdir Backup
copy *.txt Backup\\
```

**Explanation:**

1.  **`mkdir Backup`**: This command **m**a**k**es a new **dir**ectory named `Backup` in the current location where the command is being run.
2.  **`copy *.txt Backup\\`**:
    *   The `copy` command duplicates files.
    *   `*.txt` is the source. The wildcard `*` matches any filename, so this selects all files ending with the `.txt` extension in the current directory.
    *   `Backup\\` is the destination, specifying that the selected `.txt` files should be copied into the newly created `Backup` folder.

---

### g) Performance of a system is affected by latency and throughput define each of these and explain how they affect the performance. [2 Marks]

**Definitions:**

*   **Latency:** The time delay in moving data between two points. It is the time it takes for a single packet of data to travel from the source to the destination. It is typically measured in milliseconds (ms).
*   **Throughput:** The amount of data that can be successfully transferred from source to destination in a given amount of time. It is a measure of capacity or bandwidth, typically measured in megabits per second (Mbps) or gigabits per second (Gbps).

**How they affect performance:**

*   **High latency** makes a system feel slow and unresponsive, even if the throughput is high. For example, in online gaming or video conferencing, high latency causes noticeable lag and delays because each small piece of data takes too long to arrive.
*   **Low throughput** limits how much data can be moved at once. This becomes a bottleneck when transferring large files or streaming high-definition video. It causes slow downloads and buffering, even if the latency is very low.

A high-performance system requires both **low latency** (for responsiveness) and **high throughput** (for capacity).

---

### h) What is the difference between a user account and a computer account? [2 Marks]

*   **User Account:** Represents a person (or a service) and is used for authentication and authorization. It allows a human user to log on to a computer or domain and access resources based on assigned permissions. It is identified by a username and password.
*   **Computer Account:** Represents a specific computer or device within a domain. It allows the computer to authenticate itself to the network and enforce security policies on the machine itself. This is crucial for managing which computers are trusted members of the domain.

---

### i) What is the difference between backup and disaster recovery? [2 Marks]

*   **Backup** is the process of creating and storing copies of data. Its primary purpose is to allow for the restoration of that data in case it is lost, corrupted, or deleted. It is a component *of* a disaster recovery plan.
*   **Disaster Recovery (DR)** is a comprehensive strategy and set of procedures to restore an organization's entire IT infrastructure and operations after a catastrophic event (a "disaster"). It includes backups, but also encompasses network configurations, server hardware, applications, and detailed action plans for getting the business running again.

---

### j) What is the role of off-site backup in data protection? [2 Marks]

The role of off-site backup is to protect data from a site-wide disaster. By storing a copy of the data in a geographically separate location, it ensures that if the primary location is destroyed (by fire, flood, theft, or other disaster), the data is not lost permanently. It provides a means of recovery when the original data and any local backups are completely inaccessible or destroyed.

---

### k) What is the difference between local backup and cloud backup? [2 Marks]

*   **Local Backup:** Data is stored on-site on a physical device that you control, such as an external hard drive, a Network Attached Storage (NAS) device, or another server in the same building. It offers fast recovery times but is vulnerable to the same local disasters (fire, theft) as the source data.
*   **Cloud Backup:** Data is encrypted and transmitted over the internet to a secure, off-site data center managed by a third-party provider. It provides excellent protection from local disasters but recovery speed is dependent on internet bandwidth.

---

### l) What is Active Directory, and what is its primary purpose? [2 Marks]

**Definition:**
Active Directory (AD) is a directory service developed by Microsoft for Windows domain networks. It is included in most Windows Server operating systems.

**Primary Purpose:**
Its primary purpose is to provide centralized authentication and authorization services for a network. It acts as a central database and service that stores information about network resources (like users, computers, printers) and allows administrators to manage access to them in a secure and organized manner.

---

### m) How does Active Directory handle authentication and authorization of users and resources? [2 Marks]

*   **Authentication (Verifying Identity):** AD uses the **Kerberos** protocol as its primary authentication method. When a user logs in, they provide credentials (username/password). The authentication service verifies these credentials and issues the user a ticket (a Ticket-Granting Ticket or TGT). This ticket is then used to prove their identity to other services on the network without having to re-enter their password.
*   **Authorization (Determining Permissions):** After a user is authenticated, AD handles authorization using **Access Control Lists (ACLs)**. Every resource (file, folder, printer) has an ACL, which is a list of user accounts and groups that are permitted to access it, and what level of access they have (e.g., read, write, full control).

---

### n) What is shell scripting? [2 Marks]

Shell scripting is the practice of writing a series of commands for a command-line interpreter (a "shell") to execute. Instead of typing the commands one by one, they are saved in a plain text file (a script). This allows for the automation of repetitive tasks, complex sequences of commands, and administrative procedures.

---

### o) Write down four examples of how shell scripting can be used. [2 Marks]

1.  **Automating Backups:** A script can be written to automatically compress files in a specific directory, name the archive with the current date, and move it to a backup server.
2.  **User Account Management:** A script can automate the process of creating a new user, which might involve creating their home directory, setting default permissions, and adding them to standard user groups.
3.  **System Monitoring:** A script can be scheduled to run periodically to check system health, such as disk space, CPU usage, or whether a critical service is running, and send an email alert if a threshold is breached.
4.  **Software Deployment:** A script can be used to silently install or update software on multiple computers across a network, ensuring consistency and saving administrative time.

---
---

## SECTION B

### Question 1

#### a) Explain the concept of user account management and its importance in an organization's IT infrastructure. [4 Marks]

**Concept:**
User account management is the comprehensive process that includes creating, modifying, maintaining, and deleting user accounts within an IT environment. This lifecycle management applies to all network resources, including operating systems, applications, and cloud services. It involves defining user identities, assigning credentials (like usernames and passwords), setting permissions, and grouping users based on their roles and responsibilities.

**Importance:**

1.  **Security:** This is the primary reason. Proper user account management ensures that only authorized individuals can access sensitive data and systems. By enforcing the principle of least privilege (giving users only the access they need to perform their jobs), it reduces the risk of both accidental and malicious data breaches.
2.  **Audit and Compliance:** Organizations are often subject to regulations (like GDPR, HIPAA) that require them to control and track who has access to what information. A formal user account management process provides a clear audit trail, demonstrating compliance and accountability.
3.  **Operational Efficiency:** Automating the process of creating and deleting accounts (onboarding and offboarding employees) saves significant administrative time and reduces the risk of human error. It ensures new employees are productive from day one and that departing employees lose access immediately, closing a major security gap.
4.  **Resource Management:** It allows organizations to effectively manage software licenses and access to shared resources. By knowing who has access to what, companies can better allocate resources and control costs.

#### b) Explain the difference between a local user account and a computer account in Active Directory. [4 Marks]

| Feature           | Local User Account                                                                  | Computer Account (in Active Directory)                                         |
| ----------------- | ----------------------------------------------------------------------------------- | ------------------------------------------------------------------------------ |
| **Scope of Access** | Exists only on a single, specific computer. It cannot be used to log in to any other machine on the network. | Exists within the Active Directory domain. It is a domain-level object. |
| **Storage Location**| Stored in the local Security Account Manager (SAM) database on that specific computer. | Stored as an object in the Active Directory database on a Domain Controller.    |
| **Purpose**         | Used to log in and access resources only on the machine where it was created.         | Represents a computer as a member of the domain, allowing it to be managed centrally. |
| **Authentication**  | The local computer itself authenticates the user against its own SAM database.        | The computer authenticates to a Domain Controller to join and participate in the domain. |

---

#### c) Innovations and Computing Uganda Limited Scenario

Joyce, Patrick, Josiah and Mary have the following rights:
*   **Joyce:** Owns File 1 (Delete, Edit, Read). Can Delete, Read, Send, Update, and Edit *any* of the files.
*   **Patrick:** Can Send File 1. Owns File 2 (Read, Update, Delete).
*   **Josiah:** Can Update File 2 and can Send File 2.
*   **Mary:** Can Read and Edit File 1. Owns File 3 and File 4 (Read, Update, Delete, Send). Can Read, Edit, and Send File 2.

##### i. Who is likely to be the Administrator of this Company? Give reasons for your answer [2 Marks]

**Administrator:** Joyce.

**Reason:** Joyce is the only user who has universal access rights. The description states he "can Delete, Read, Send, Update, and Edit **any of the files**." This level of sweeping privilege, overriding ownership and other specific restrictions, is characteristic of an administrator account which has full control over all resources on the system.

##### ii. Generate an Access Matrix Model from the organization above. [4 Marks]

| Subject / Object | File 1                     | File 2                             | File 3                               | File 4                               |
| ---------------- | -------------------------- | ---------------------------------- | ------------------------------------ | ------------------------------------ |
| **Joyce**        | **Owns**, Delete, Edit, Read, Send, Update | Delete, Read, Send, Update, Edit     | Delete, Read, Send, Update, Edit     | Delete, Read, Send, Update, Edit     |
| **Patrick**      | Send                       | **Owns**, Read, Update, Delete     | -                                    | -                                    |
| **Josiah**       | -                          | Update, Send                       | -                                    | -                                    |
| **Mary**         | Read, Edit                 | Read, Edit, Send                   | **Owns**, Read, Update, Delete, Send | **Owns**, Read, Update, Delete, Send |

*(Note: Joyce's admin rights to Send/Update File 1 are added based on the "any of the files" rule.)*

##### iii. Generate an Access Control List (ACL) [6 Marks]

An Access Control List (ACL) is generated on a per-object basis.

**ACL for: File 1**
*   Joyce: (Owns, Delete, Edit, Read, Send, Update)
*   Patrick: (Send)
*   Mary: (Read, Edit)

**ACL for: File 2**
*   Joyce: (Delete, Read, Send, Update, Edit)
*   Patrick: (Owns, Read, Update, Delete)
*   Josiah: (Update, Send)
*   Mary: (Read, Edit, Send)

**ACL for: File 3**
*   Joyce: (Delete, Read, Send, Update, Edit)
*   Mary: (Owns, Read, Update, Delete, Send)

**ACL for: File 4**
*   Joyce: (Delete, Read, Send, Update, Edit)
*   Mary: (Owns, Read, Update, Delete, Send)

---

### Question 2: Nkumba University Scenario

#### a) For each system, what specific tasks or processes does it handle and suggest a Recovery Time Objective (RTO) for each? [5 Marks]

*   **Academic Information Management System (AIMS)**
    *   **Tasks:** Manages core academic functions: student registration, course enrollment, grade processing, transcript generation, and student records management. It is essential for daily administrative and student activities.
    *   **Suggested RTO:** **2-4 hours**.
    *   **Reasoning:** This is a critical system. A prolonged outage would halt student registration, prevent faculty from entering grades, and disrupt administrative operations. A low RTO is essential to minimize disruption to the academic calendar.

*   **eLearning platform**
    *   **Tasks:** Hosts course materials, online assignments, quizzes, and discussion forums. It is the primary tool for online and blended learning.
    *   **Suggested RTO:** **8-12 hours**.
    *   **Reasoning:** While important for learning, it is less transactionally critical than AIMS. Students can often work offline temporarily. An outage of a full academic day is disruptive but manageable, making a slightly longer RTO acceptable compared to AIMS.

*   **Tradumo**
    *   **Tasks:** This sounds like a financial or administrative system, possibly handling tuition payments, payroll, or procurement.
    *   **Suggested RTO:** **4 hours**.
    *   **Reasoning:** Financial systems are critical for business operations. An inability to process payments or manage financial records can have immediate and severe consequences. The RTO should be low to ensure financial continuity.

#### b) Can you explain what "system hosting" means and tell me where each of these Nkumba University systems are likely hosted? [5 Marks]

**System Hosting Definition:**
System hosting refers to the practice of storing, running, and maintaining the servers, data, and applications for a system in a specific physical or virtual environment. The "host" provides the computing resources (CPU, RAM, storage, network) needed for the system to operate and be accessible to users.

**Likely Hosting Locations:**

*   **AIMS (Academic Information Management System):** Most likely **On-Premises**. Core student record systems are often kept in-house in a university's own data center for maximum control over sensitive student data and to ensure compliance with data privacy regulations.
*   **eLearning platform:** Likely **Cloud-Hosted (SaaS or IaaS)**. Many universities use third-party cloud platforms like Moodle, Blackboard, or Canvas. Cloud hosting provides high availability, scalability to handle thousands of students during peak exam times, and management by a specialized vendor.
*   **Tradumo (Financial System):** Likely **On-Premises** or in a **Private Cloud**. Similar to AIMS, financial systems contain highly sensitive data. Organizations often prefer to host them in a highly secure, controlled environment like their own data center or a dedicated private cloud instance.

#### c) As a System Administration student, what does it take to host these systems? [5 Marks]

Hosting these systems requires a broad set of system administration skills:

1.  **Infrastructure Management:** You need to provision and configure the underlying hardware. This includes setting up physical servers, storage arrays (like SAN or NAS), and network equipment (switches, routers, firewalls).
2.  **Operating System Administration:** You must be proficient in installing, configuring, hardening (securing), and maintaining the server operating system (e.g., Windows Server or a Linux distribution like Ubuntu Server).
3.  **Application and Database Deployment:** You would need to install and configure the specific application software (AIMS, Moodle, Tradumo) and the database it relies on (e.g., MySQL, PostgreSQL, Microsoft SQL Server). This includes setting up database users and permissions.
4.  **Networking and Security:** You must configure IP addresses, DNS records, and firewall rules to allow legitimate user traffic while blocking malicious attempts. This also involves setting up SSL certificates to encrypt data in transit.
5.  **Backup and Monitoring:** You need to implement a robust backup solution for the application data and databases. You also need to set up monitoring tools (like Nagios or Zabbix) to alert you about performance issues or system failures.

#### d) Outline a disaster recovery strategy for the systems in question. [5 Marks]

A disaster recovery (DR) strategy for Nkumba's systems would involve these key elements:

1.  **Regular, Automated Backups:**
    *   **AIMS & Tradumo:** Full backups nightly, with transactional log backups every 15-30 minutes to a separate on-site storage device. This ensures a low Recovery Point Objective (RPO).
    *   **eLearning Platform:** Full backups weekly, with differential backups nightly.
2.  **Off-Site Backup Replication:** All on-site backups must be replicated to a secure off-site location (either a secondary university site or a cloud storage service like AWS S3). This protects against a site-wide disaster like a fire.
3.  **Standby Infrastructure (Failover Site):**
    *   Maintain a secondary DR site with standby servers. For critical systems like AIMS and Tradumo, use replication to keep a "warm" or "hot" standby server that can be brought online quickly, meeting the low RTO.
    *   For the eLearning platform, a "cold" site might be acceptable, where servers can be provisioned and data restored from off-site backups within the 8-12 hour RTO.
4.  **Documented DR Plan:** A detailed, step-by-step DR plan must be created. This document should specify who to contact, how to fail over to the DR site, how to restore data, and how to eventually fail back to the primary site.
5.  **Regular Testing:** The DR plan must be tested at least annually. This involves performing a simulated failover to the DR site to ensure the plan works, the backups are valid, and the IT staff are familiar with the procedures.

---

### Question 3

#### a) What is SNMP and what is its primary purpose in network management? [2 Marks]

**Definition:**
SNMP stands for **Simple Network Management Protocol**. It is an Internet Standard protocol for collecting and organizing information about managed devices on IP networks.

**Primary Purpose:**
Its primary purpose is to allow network administrators to **monitor, manage, and configure network devices** (like routers, switches, servers, and printers) from a central location. It enables them to track device health, receive alerts about errors, and gather performance data.

---

#### b) Discuss the key differences between a server and a workstation in terms of hardware, software, and functionality. [8 Marks]

| Aspect              | Server                                                                                                      | Workstation                                                                                              |
| ------------------- | ----------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------- |
| **1. Hardware**     | **Optimized for Reliability & Uptime:** Built with redundant components (power supplies, fans, disk arrays like RAID) and error-correcting (ECC) RAM. Designed to run 24/7. | **Optimized for User Performance:** Built with a high-end CPU and a powerful graphics card for tasks like CAD, 3D rendering, or data analysis. Typically lacks redundancy. |
|                     | **Headless Operation:** Often lacks a dedicated monitor or keyboard, managed remotely via a network connection. | **User-Facing:** Always has high-resolution displays, a keyboard, mouse, and other peripherals for direct user interaction. |
| **2. Software**     | **Server Operating System:** Runs a specialized OS like Windows Server, Ubuntu Server, or RHEL, designed to handle many concurrent connections and provide network services. | **Desktop Operating System:** Runs a user-focused OS like Windows 10/11 Pro, macOS, or a desktop Linux distribution, optimized for a responsive graphical user interface. |
|                     | **Service-Oriented Applications:** Runs backend software that provides services to clients (e.g., Apache web server, Microsoft SQL Server, Postfix mail server). | **Application-Oriented Software:** Runs applications with which a user interacts directly (e.g., Adobe Photoshop, AutoCAD, Visual Studio, Chrome). |
| **3. Functionality**| **One-to-Many Relationship:** A single server provides resources and services to many client computers (workstations, laptops). | **One-to-One Relationship:** A single workstation is used by one person at a time to perform their job. |
|                     | **Resource Provider:** Its primary function is to share resources—files, web pages, data, or processing power—over a network. | **Resource Consumer:** Its primary function is to access network resources provided by servers to accomplish a specific task. |

---

#### c) What is the World Wide Web and how does it differ from the internet? [4 Marks]

**World Wide Web (WWW):** The World Wide Web is a global information system where documents and other web resources are identified by Uniform Resource Locators (URLs), which may be interlinked by hypertext, and are accessible over the Internet. It is a service, or application, that runs on the internet.

**Internet:** The Internet is the global system of interconnected computer networks that uses the Internet protocol suite (TCP/IP) to communicate between networks and devices. It is the physical infrastructure of networks, routers, cables, and servers that the Web operates on.

**Difference:** The key difference is that the Internet is the global network infrastructure, while the Web is the information shared over that infrastructure. The Internet is the hardware; the Web is the service. You can use the Internet for things other than the Web, like email (SMTP) or file transfers (FTP).

---

#### d) What is a URL (Uniform Resource Locator), and how does it work in web addressing? [2 Marks]

**URL (Uniform Resource Locator):** A URL is a reference to a web resource that specifies its location on a computer network and a mechanism for retrieving it. It is the human-readable address for a resource on the Web.

**How it works:**
1. A user enters a URL into a web browser.
2. The browser contacts a Domain Name System (DNS) server to translate the URL's domain name into a machine-readable IP address.
3. Once the IP address is obtained, the browser sends an HTTP request to the web server at that IP address, asking for the specific resource indicated by the path in the URL.
4. The server processes the request and sends the resource (e.g., an HTML page, an image) back to the browser, which then displays it to the user.

---

#### e) Explain the concept of a web application and how it differs from traditional websites. [4 Marks]

**Web Application:** A web application is a dynamic, interactive program that runs on a web server and is accessed by a user through a web browser. It allows users to manipulate data and receive a customized response. Examples include online banking portals, webmail clients like Gmail, and e-commerce sites.

**Traditional Website:** A traditional, or static, website is a collection of interlinked web pages with content that is fixed and delivered to all users in the same way. Its primary purpose is to provide information, like a digital brochure or a news article.

**Key Difference:** The primary difference is **interactivity and functionality**. A web application is a tool or a program that performs tasks based on user input. A traditional website is a static source of information that is read by the user.

### Question 4

#### a) Define the term Data Backup, then go ahead to explain the three (3) purposes that Backups serve. [4 Marks]

**Definition:**
**Data Backup** is the process of creating a copy of data on a system and storing it in a separate, secure location. This copy, known as the backup, is intended for retrieval in case the original data is lost, corrupted, or otherwise compromised.

**Three Purposes of Backups:**

1.  **Recovery from Data Loss:** This is the primary purpose. If data is accidentally deleted, corrupted by a software bug, or destroyed by a hardware failure (like a hard drive crash), the backup copy can be used to restore the data to its previous state.
2.  **Disaster Recovery:** In the event of a major disaster (fire, flood, cyberattack like ransomware) that destroys an entire system or location, an off-site backup is crucial for restoring the IT infrastructure and continuing business operations.
3.  **Archiving and Compliance:** Backups can serve as a historical archive of data. Many industries have legal or regulatory requirements to retain data for a specific period. Backups provide a means to fulfill these long-term data retention policies.

---

#### b) With the help of a diagram explain the three pillars of Backup Architecture. [4 Marks]

**Diagram of Backup Architecture Pillars**
```
      +----------------------+
      |     BACKUP SOURCE    |
      | (Server, VM, Database) |
      +-----------^----------+
                  |
        (Data is pulled by)
                  |
      +-----------v----------+
      |    BACKUP SOFTWARE   |
      | (Manages & Schedules)  |
      +-----------^----------+
                  |
       (Data is written to)
                  |
      +-----------v----------+
      |     BACKUP TARGET    |
      | (Tape, Disk, NAS, Cloud) |
      +----------------------+
```
**Explanation of Pillars:**
1.  **Backup Source:** This is the server, application, or data that needs to be protected. It is the origin of the data being copied.
2.  **Backup Software:** This is the application or tool that manages the backup process. It is responsible for scheduling when backups run, copying the data from the source, compressing and/or encrypting it, and writing it to the target.
3.  **Backup Target:** This is the destination storage media where the backup copy is stored. This can be a physical tape drive, a local disk array, a Network Attached Storage (NAS) device, or a cloud storage service.

---

#### c) Write down and explain the steps taken in Backup Operation [7 Marks]

1.  **Identification:** Identify the critical data and systems that need to be backed up. Not all data is equally important.
2.  **Scheduling:** Define the backup schedule (e.g., daily, weekly) and the type of backup to be performed (full, incremental, differential). This is typically configured in the backup software.
3.  **Execution:** The backup software initiates the job at the scheduled time. It connects to the backup source.
4.  **Data Capture:** The software creates a consistent snapshot of the data to ensure that files are not in an open or inconsistent state.
5.  **Data Transfer:** The data is read from the source, optionally compressed to save space and encrypted for security, and then transferred over the network to the backup target.
6.  **Verification:** After the data is written to the target media, a good backup process will verify the integrity of the backup to ensure it is not corrupt and can be used for a successful restore.
7.  **Reporting/Logging:** The backup software logs the outcome of the job (success, failure, errors) and sends a report or alert to the administrator.

---

#### d) Write down and explain the steps taken in Recovery Operation [5 Marks]

1.  **Identify the Need:** An administrator identifies that a restore is necessary due to data loss, corruption, or a system failure.
2.  **Locate the Backup:** The administrator uses the backup software to locate the correct backup set and the specific version of the data (the recovery point) that needs to be restored.
3.  **Initiate the Restore:** The restore job is launched from the backup software. The administrator specifies the destination where the data should be restored (either the original location or an alternate one).
4.  **Data Transfer:** The backup software reads the data from the backup target (tape, disk, cloud), decrypts it if necessary, and writes it back to the specified destination.
5.  **Verify the Recovery:** After the restore is complete, the administrator and/or the user must verify that the data is correct, intact, and the application or system is functioning as expected.

### Question 5

#### a) Define the term disaster and explain the three categories of disasters in the IT System. [4 Marks]

**Definition:**
In an IT context, a **disaster** is any sudden, unplanned event that causes a severe disruption to a system's operations, resulting in the inability to provide critical services for a significant period.

**Three Categories of Disasters:**

1.  **Natural Disasters:** These are events caused by environmental forces. Examples include floods, earthquakes, fires (caused by lightning), hurricanes, and tornadoes. They typically result in the physical destruction of infrastructure and data centers.
2.  **Man-Made Disasters:** These are events caused by human actions, which can be either intentional or unintentional. Examples include major power outages, terrorism, theft of equipment, civil unrest, or accidental damage like a construction crew cutting a primary fiber optic cable.
3.  **Technical/Systemic Disasters:** These are failures originating from within the IT system itself. Examples include critical hardware failures (server or storage array crash), major software bugs, failed system updates that corrupt the system, and large-scale cyberattacks like ransomware that render all data inaccessible.

---

#### b) Organizations deal with disaster recovery by address three major factors, write and explain these factors. [4 Marks]

1.  **Prevention:** Implementing measures to prevent a disaster from occurring in the first place. This includes using uninterruptible power supplies (UPS) to prevent power outage disruptions, installing fire suppression systems, and deploying robust cybersecurity defenses to prevent attacks.
2.  **Mitigation:** Taking steps to reduce the impact of a disaster that cannot be prevented. The primary example is having a robust data backup strategy. While the backup doesn't prevent the fire, it mitigates the impact by ensuring the data is not permanently lost.
3.  **Recovery:** Establishing the plans and procedures to restore IT operations after a disaster has occurred. This involves creating a detailed Disaster Recovery Plan (DRP), having a designated recovery site, and regularly testing the plan to ensure a swift and successful recovery.

---

#### c) Explain these two concepts and how they relate to disaster recovery. [4 Marks]

*   **i. Recovery Point Objective (RPO):**
    *   **Explanation:** RPO defines the **maximum acceptable amount of data loss** an organization can tolerate, measured in time. It answers the question: "How much data can we afford to lose?"
    *   **Relation to DR:** The RPO dictates the required frequency of backups. An RPO of 1 hour means the system must be backed up at least every hour, so that in a disaster, no more than one hour's worth of data is lost.

*   **ii. Recovery Time Objective (RTO):**
    *   **Explanation:** RTO defines the **maximum acceptable amount of downtime** for a system or service after a disaster. It answers the question: "How quickly must we be back online?"
    *   **Relation to DR:** The RTO dictates the type of recovery infrastructure required. An RTO of 15 minutes might require an expensive, fully redundant hot site that can fail over automatically. An RTO of 24 hours might be achievable with a cold site and manual restoration from backups.

---

#### d) Compare the two concepts Recovery Point Objective (RPO) and Recovery Time Objective (RTO) using the criteria i) Focus on, ii) Depends on, iii) Describes, iv) Consideration. [4 Marks]

| Criteria        | Recovery Point Objective (RPO)     | Recovery Time Objective (RTO)        |
| --------------- | ---------------------------------- | ------------------------------------ |
| **i) Focus on**   | Data loss                          | Service downtime                     |
| **ii) Depends on**| Backup frequency and replication   | The recovery infrastructure and plan |
| **iii) Describes**| The age of the data to be recovered | The speed of the recovery process    |
| **iv) Consideration**| How much data the business can afford to lose. | How long the business can survive without the system. |

---

#### e) Explain what a disaster recovery plan is and list three issues you consider in a disaster recovery plan. [4 Marks]

**Disaster Recovery Plan (DRP):**
A Disaster Recovery Plan is a formal, documented, and structured plan that describes how an organization can quickly resume work after an unplanned incident or disaster. It contains detailed, step-by-step procedures for the recovery of critical IT systems and infrastructure.

**Three Issues to Consider in a DRP:**
1.  **Identification of Critical Systems and Data:** The plan must clearly define which systems are most critical to the business and must be restored first. This prioritization ensures that recovery efforts are focused where they will have the most impact on business continuity.
2.  **Roles and Responsibilities:** The DRP must clearly designate a DR team and outline the specific roles and responsibilities of each member. It should be clear who is in charge, who declares a disaster, and who is responsible for each step of the recovery process.
3.  **Communication Plan:** The plan must include a strategy for communicating with employees, stakeholders, and customers during a disaster. This includes how the DR team will communicate with each other if primary communication systems (like email) are down.

### Question 6

#### a) Using a well-labeled diagram, illustrate the logical architecture of Active Directory. In your explanation, clearly describe and demonstrate the following components: [10 Marks]

**Logical Architecture Diagram of Active Directory**

```
                  +-----------------------------------------+
                  |                  FOREST                 |
                  |  (e.g., company.com)                    |
                  |  (Security Boundary, Single Schema)     |
                  |                                         |
                  |   +-----------------+-----------------+ |
                  |   |      TREE       |      TREE       | |
                  |   | (Contiguous     | (Separate       | |
                  |   |  Namespace)     |  Namespace)     | |
                  |   |                 |                 | |
                  |   |  +-----------+  |  +-----------+  | |
                  |   |  |   DOMAIN  |  |  |   DOMAIN  |  | |
                  |   |  | (Root)    |  |  | (Root)    |  | |
                  |   |  | company.com |  |  | acme.org  |  | |
                  |   |  +-----^-----+  |  +-----------+  | |
                  |   |        |        |                 | |
                  |   |  +-----v-----+  |                 | |
                  |   |  |   DOMAIN  |  |                 | |
                  |   |  | (Child)   |  |                 | |
                  |   |  | sales.company.com |            | |
                  |   |  +-----^-----+  |                 | |
                  |   |        |        |                 | |
|  Object         |   |  +-----v-----+  |                 | |
| (+------------+)  |   |ORGANIZATION.|  |                 | |
| | User: jsmith |  |   | UNIT (OU) |  |                 | |
| (+------------+)  |   | (SalesUsers)|  |                 | |
|                 |   |  +-----------+  |                 | |
|                 |   +-----------------+-----------------+ |
+---------------------------------------------------------+

```

**Explanation of Components:**

1.  **Object:**
    *   **Description:** The most basic element in Active Directory. An object is a distinct, named set of attributes that represents a network resource.
    *   **Example:** A user account (with attributes like name, password, department), a computer, a printer, or a group are all objects. In the diagram, `User: jsmith` is an object.

2.  **Organizational Unit (OU):**
    *   **Description:** A container object within a domain used to organize other objects (like users, groups, and computers) into a logical administrative hierarchy. OUs are the smallest scope to which Group Policy can be applied or administrative authority can be delegated.
    *   **Example:** In the diagram, the `SalesUsers` OU is created inside the `sales.company.com` domain to hold all the user objects for the sales department.

3.  **Domain:**
    *   **Description:** A core administrative boundary in Active Directory. A domain is a logical group of network objects that share the same AD database, security policies, and trust relationships. All objects within a domain are managed by the domain controllers for that domain.
    *   **Example:** `company.com` is the root domain, and `sales.company.com` is a child domain within the same tree.

4.  **Tree:**
    *   **Description:** A collection of one or more domains arranged in a hierarchical structure with a contiguous namespace. The first domain created is the root of the tree. Any subsequent domains added are child domains of the root, creating a parent-child relationship (e.g., `sales.company.com` is a child of `company.com`).
    *   **Example:** All domains sharing the `company.com` namespace (`company.com`, `sales.company.com`, `dev.company.com`) form a single tree.

5.  **Forest:**
    *   **Description:** The highest-level logical structure in Active Directory, representing the ultimate security boundary. A forest is a collection of one or more trees that do not share a contiguous namespace but are connected by a two-way trust relationship. All domains in a forest share a common schema (the blueprint for objects) and a global catalog (a partial index of all objects).
    *   **Example:** The diagram shows a forest containing two separate trees, `company.com` and `acme.org`. They can share resources, but are distinct namespaces.

---

#### b) Give five (5) reasons why we should use Active Directory Services. [5 Marks]

1.  **Centralized Management:** AD provides a single, centralized point for administrators to manage all network resources, including user accounts, computers, permissions, and security policies. This drastically simplifies administration in complex environments.
2.  **Enhanced Security:** It provides robust, centralized authentication and authorization. Features like Group Policy allow administrators to enforce strong password policies, restrict software installation, and control user access across thousands of computers consistently.
3.  **Single Sign-On (SSO):** AD enables users to log in once with a single set of credentials and gain access to all network resources they are authorized to use, without needing to log in repeatedly. This improves user productivity and satisfaction.
4.  **Scalability:** Active Directory is highly scalable and can support environments ranging from a small business with a few dozen users to a massive global enterprise with millions of objects.
5.  **Interoperability and Foundation for Other Services:** AD is the foundation for many other Microsoft server products, such as Exchange Server (for email) and SharePoint (for collaboration). It provides the necessary user directory and authentication services for these applications to function in an enterprise environment.

---

#### c) Write down five (3) areas where Active Directory Services can be used [3 Marks]

*(The question asks for "five (3)", so providing three is appropriate.)*

1.  **Corporate Environments:** Used in businesses of all sizes to manage employee computers, user accounts, and access to internal file servers, printers, and applications.
2.  **Educational Institutions:** Used by schools and universities to manage student and faculty accounts, control access to lab computers, and apply different policies to different user groups.
3.  **Government Agencies:** Used to secure sensitive government networks, enforce strict compliance policies, and manage access for thousands of civil servants across various departments.

---

#### d) Describe the process of joining a computer to an Active Directory domain. [2 Marks]

1.  **Configure Network Settings:** First, the computer's network settings must be configured to use the Active Directory domain's DNS server. This is essential so the computer can find the domain controllers.
2.  **Join the Domain:** The administrator opens the System Properties on the computer, navigates to the "Computer Name" tab, and clicks "Change...". They then select the "Domain" option and type in the fully qualified name of the target domain (e.g., `company.com`).
3.  **Provide Credentials:** The system will then prompt for the credentials (username and password) of a domain user account that has the permission to join computers to the domain.
4.  **Reboot:** After successfully authenticating, the computer is joined to the domain and must be restarted to apply the new security and policy settings.
