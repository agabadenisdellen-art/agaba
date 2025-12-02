# System Administration Guide

## 1. System Administration Fundamentals

### a) What is system administration and what do systems administrators do?

**System administration** is the field of work in which someone manages one or more systems (computers, servers, networks, etc.). **System administrators**, or **sysadmins**, are the people who are responsible for the upkeep, configuration, and reliable operation of computer systems; especially multi-user computers, such as servers.

**What do system administrators do?**

*   **Install and configure new hardware and software:** This includes everything from setting up new servers to installing and configuring new applications.
*   **Manage user accounts:** This includes creating and deleting user accounts, as well as setting and resetting passwords.
*   **Monitor system performance:** This includes monitoring system logs, as well as using performance monitoring tools to identify and troubleshoot problems.
*   **Perform backups and disaster recovery:** This includes creating backups of data and systems, as well as developing and testing disaster recovery plans.
*   **Ensure system security:** This includes implementing and maintaining security measures, such as firewalls and intrusion detection systems.
*   **Troubleshoot problems:** This includes diagnosing and resolving problems with hardware, software, and networks.
*   **Automate tasks:** This includes writing scripts to automate repetitive tasks, such as creating new user accounts or backing up data.
*   **Document systems and procedures:** This includes creating and maintaining documentation for systems and procedures.

### b) The System in System Administration

In the context of system administration, a **system** is a collection of interconnected components that work together to perform a specific function. This can include hardware, software, networks, and people.

```
+---------------------------------------------------+
|                                                   |
|       +-----------+   +-----------+   +-----------+ |
|       |           |   |           |   |           | |
|       | Hardware  |   | Software  |   |  Network  | |
|       |           |   |           |   |           | |
|       +-----------+   +-----------+   +-----------+ |
|             |               |               |       |
|             +---------------+---------------+       |
|                             |                       |
|                       +-----------+                   |
|                       |           |                   |
|                       |   User    |                   |
|                       |           |                   |
|                       +-----------+                   |
|                                                   |
+---------------------------------------------------+
```

### c) Principles of System Administration

1.  **Simplicity:** Keep systems as simple as possible.
2.  **Clarity:** Make sure that systems are easy to understand and manage.
3.  **Automation:** Automate tasks whenever possible.

### d) Qualities of a Successful System Administrator

*   **Technical skills:** A successful system administrator must have strong technical skills in a variety of areas, including operating systems, networking, and security.
*   **Problem-solving skills:** A successful system administrator must be able to diagnose and resolve problems with hardware, software, and networks.

### e) Performance: Latency and Throughput

*   **Latency:** The time it takes for a packet of data to travel from one point to another.
*   **Throughput:** The amount of data that can be transmitted over a network in a given amount of time.

### f) CMD and Shell Scripting

**What is shell scripting?**

Shell scripting is the process of writing scripts that can be executed by a shell. A shell is a command-line interpreter that is used to interact with the operating system.

**Examples of how shell scripting can be used:**

*   **Automate tasks:** You can use shell scripting to automate tasks such as creating new user accounts or backing up data.
*   **Manage systems:** You can use shell scripting to manage systems, such as starting and stopping services or installing and removing software.
*   **Troubleshoot problems:** You can use shell scripting to troubleshoot problems with hardware, software, and networks.
*   **Run programs:** You can use shell scripting to run programs and to pass arguments to them.

**CMD Commands:**

*   **Shutdown command:** `shutdown /s /t 300 /c "System will shut down in 5 minutes."`
*   **Move files:** `mkdir ProcessedFiles & move OldFiles\\* ProcessedFiles`
*   **Backup files:** `mkdir Backup & copy *.txt Backup`

## 2. Servers vs. Workstations

### a) Key Differences Between Servers and Workstations

| Feature | Server | Workstation |
| :--- | :--- | :--- |
| **Purpose** | To provide network services to multiple clients. | To facilitate specialized tasks for individual users. |
| **Hardware** | Optimized for reliability and scalability. | Optimized for performance. |
| **Software** | Runs a server operating system. | Runs a desktop operating system. |
| **Functionality** | Provides services such as file sharing, web hosting, and email. | Used for tasks such as video editing, 3D modeling, and scientific computing. |

### b) The Role of the Operating System on a Workstation

The operating system on a workstation is responsible for:

*   **Managing hardware resources:** This includes the CPU, memory, and storage devices.
*   **Providing a user interface:** This allows the user to interact with the computer.
*   **Providing a platform for software:** This allows the user to run applications.

### c) Server Virtualization

**Server virtualization** is the process of running multiple virtual servers on a single physical server. This has a number of benefits, including:

*   **Resource utilization:** Server virtualization can help to improve resource utilization by allowing you to run multiple servers on a single physical server.
*   **Scalability:** Server virtualization can help to improve scalability by allowing you to easily add or remove virtual servers as needed.

### d) Types of Servers

*   **File servers:** Store and manage files for users on a network.
*   **Web servers:** Host websites and web applications.
*   **Database servers:** Store and manage databases.
*   **Mail servers:** Send and receive emails.

## 3. Network Services

### a) System Services and Network Services

A **system service** is a program that runs in the background on a computer and provides a specific function. A **network service** is a program that provides a specific function to network users.

### b) Common Network Services

*   **DNS (Domain Name System):** Resolves domain names to IP addresses.
*   **DHCP (Dynamic Host Configuration Protocol):** Assigns IP addresses to devices on a network.
*   **HTTP (Hypertext Transfer Protocol):** Transfers web pages and other web content.
*   **FTP (File Transfer Protocol):** Transfers files between computers.
*   **SMTP (Simple Mail Transfer Protocol):** Sends and receives emails.

### c) Network Security

**Network security threats** are malicious attempts to harm or exploit networks. Some of the most common network security threats include:

*   **Viruses:** A type of malware that attaches itself to a program or file and then spreads to other computers.
*   **Worms:** A type of malware that can replicate itself and spread to other computers without any human interaction.
*   **Spyware:** A type of malware that is designed to collect information about a user without their knowledge.
*   **Ransomware:** A type of malware that encrypts a user's files and then demands a ransom to decrypt them.

**Network security measures** are the steps that you can take to protect your network from these threats. Some of the most common network security measures include:

*   **Firewalls:** A firewall is a security device that is used to protect a network from unauthorized access.
*   **Intrusion detection systems (IDS):** An IDS is a system that is used to detect and respond to security threats.
*   **Antivirus software:** Antivirus software is designed to protect your computer from malware.

## 4. Web Concepts

### a) The World Wide Web (WWW) and the Internet

The **Internet** is a global network of computers that are connected to each other. The **World Wide Web (WWW)** is a system of interconnected documents and other web resources that are accessed via the Internet.

### b) URL (Uniform Resource Locator)

A **URL (Uniform Resource Locator)** is a unique address that is used to identify a resource on the internet. It consists of the following parts:

*   **Protocol:** The protocol that is used to access the resource, such as HTTP or FTP.
*   **Domain name:** The domain name of the server that is hosting the resource.
*   **Path:** The path to the resource on the server.

### c) Web Applications vs. Traditional Websites

A **traditional website** is a collection of static web pages that are linked together. A **web application** is a program that is accessed over a network, such as the Internet.

### d) HTTP Methods (GET, POST, PUT, DELETE)

*   **GET:** Retrieves data from a web server.
*   **POST:** Submits data to a web server.
*   **PUT:** Updates data on a web server.
*   **DELETE:** Deletes data from a web server.

### e) Email Protocols (SMTP, POP3)

*   **SMTP (Simple Mail Transfer Protocol):** The protocol that is used to send emails.
*   **POP3 (Post Office Protocol 3):** A protocol that is used to retrieve emails from a mail server.

### f) SNMP (Simple Network Management Protocol)

**SNMP (Simple Network Management Protocol)** is a protocol that is used to manage network devices. It allows network administrators to monitor the performance of network devices, as well as to configure and troubleshoot them.

## 5. Active Directory

### a) What is Active Directory?

**Active Directory** is a directory service developed by Microsoft for Windows domain networks. It is a central database of all the user accounts, computers, and other resources on the network.

### b) Active Directory Architecture and Objects

The Active Directory architecture is a hierarchical structure that is made up of the following components:

*   **Forest:** A forest is the highest level of the Active Directory hierarchy. It is a collection of one or more domains that share a common schema, configuration, and global catalog.
*   **Tree:** A tree is a collection of one or more domains that share a contiguous namespace.
*   **Domain:** A domain is a logical grouping of user accounts, computers, and other resources.
*   **Organizational Unit (OU):** An OU is a container that is used to organize objects within a domain.
*   **Object:** An object is a representation of a resource in Active Directory, such as a user, computer, or printer.

### c) Components of a Domain

*   **Domain controllers:** Servers that store a copy of the Active Directory database.
*   **Member servers:** Servers that are members of the domain but are not domain controllers.
*   **Workstations:** Computers that are members of the domain.
*   **Users:** User accounts that are used to log on to the network.

### d) Reasons to Use Active Directory

*   **Centralized management:** Active Directory provides a central location for managing user accounts, computers, and other resources.
*   **Improved security:** Active Directory provides a number of security features, such as authentication and authorization.
*   **Scalability:** Active Directory is a scalable solution that can be used in small, medium, and large organizations.

### e) Where Active Directory is Used

Active Directory is used in a variety of organizations, including:

*   **Businesses:** Active Directory is used to manage user accounts, computers, and other resources in a business environment.
*   **Schools:** Active Directory is used to manage student and staff accounts, as well as to control access to network resources.
*   **Government agencies:** Active Directory is used to manage user accounts, computers, and other resources in a government environment.

### f) User Accounts vs. Computer Accounts

*   **User account:** A user account is used to log on to the network.
*   **Computer account:** A computer account is used to identify a computer on the network.

### g) Authentication and Authorization in Active Directory

Active Directory uses the following mechanisms to authenticate and authorize users and resources:

*   **Authentication:** Active Directory uses the Kerberos protocol to authenticate users. When a user logs on to the network, they are issued a ticket-granting ticket (TGT) by the Key Distribution Center (KDC). The TGT is then used to request service tickets, which are used to access resources on the network.
*   **Authorization:** Active Directory uses access control lists (ACLs) to authorize access to resources. An ACL is a list of users and groups that are allowed to access a resource, and the level of access that they have.

### h) Access Control Matrix and Access Control List (ACL)

An **access control matrix** is a table that is used to represent the access rights that users have to resources. An **access control list (ACL)** is a list of users and groups that are allowed to access a resource, and the level of access that they have.

**Innovations and Computing Uganda Limited Scenario:**

*   **Administrator:** Joyce is the most likely administrator. She has the ability to Delete, Read, Send, Update, and Edit any of the files, which are the most comprehensive permissions.
*   **Access Matrix Model:**

| Subject | File 1 | File 2 | File 3 | File 4 |
| :--- | :--- | :--- | :--- | :--- |
| Joyce | Owns, Delete, Edit, Read | Delete, Read, Send, Update, Edit | Delete, Read, Send, Update, Edit | Delete, Read, Send, Update, Edit |
| Patrick | Send | Owns, Read, Update, Delete | | |
| Josiah | | Update, Send | | |
| Mary | Read, Edit | Read, Edit, Send | Owns, Read, Update, Delete, Send | Owns, Read, Update, Delete, Send |

*   **Access Control List (ACL):**

    *   **File 1:**
        *   Joyce: Owns, Delete, Edit, Read
        *   Patrick: Send
        *   Mary: Read, Edit
    *   **File 2:**
        *   Patrick: Owns, Read, Update, Delete
        *   Josiah: Update, Send
        *   Mary: Read, Edit, Send
        *   Joyce: Delete, Read, Send, Update, Edit
    *   **File 3:**
        *   Mary: Owns, Read, Update, Delete, Send
        *   Joyce: Delete, Read, Send, Update, Edit
    *   **File 4:**
        *   Mary: Owns, Read, Update, Delete, Send
        *   Joyce: Delete, Read, Send, Update, Edit

## 6. Backup and Disaster Recovery

### a) Data Backup: Definition and Purposes

**Data backup** is the process of copying and storing data for safekeeping. The purposes of data backup are:

*   **To protect against data loss:** If your data is lost or damaged, you can restore it from a backup.
*   **To comply with regulations:** Some regulations require organizations to back up their data.
*   **To archive data:** You can use backups to archive data that you no longer need to access on a regular basis.

### b) Backup vs. Disaster Recovery

**Backup** is the process of copying and storing data. **Disaster recovery** is the process of restoring an organization's IT infrastructure and data after a disaster.

### c) The Three Pillars of Backup Architecture

1.  **Backup software:** The software that is used to create and manage backups.
2.  **Backup media:** The media that is used to store backups, such as tape, disk, or cloud.
3.  **Backup server:** The server that is used to store and manage backups.

### d) Types of Backups

*   **Full backup:** A complete copy of all the data on a system.
*   **Incremental backup:** A backup of only the data that has changed since the last backup.
*   **Differential backup:** A backup of all the data that has changed since the last full backup.
*   **Mirror backup:** A copy of the data that is an exact replica of the source.
*   **Local backup:** A backup that is stored on a device that is connected to the computer that is being backed up.

### e) Backup and Recovery Operations

**Backup operation:**

1.  The backup software is configured to back up the desired data.
2.  The backup software starts the backup job.
3.  The backup software copies the data to the backup media.
4.  The backup software verifies the backup.

**Recovery operation:**

1.  The backup software is configured to restore the desired data.
2.  The backup software starts the restore job.
3.  The backup software copies the data from the backup media to the original location.
4.  The backup software verifies the restored data.

### f) Local vs. Cloud Backup

| Feature | Local Backup | Cloud Backup |
| :--- | :--- | :--- |
| **Location** | Stored on a device that is connected to the computer that is being backed up. | Stored on a remote server that is accessed over the internet. |
| **Cost** | Can be less expensive. | Can be more expensive. |
| **Security** | Can be less secure. | Can be more secure. |
| **Accessibility** | Can be less accessible. | Can be more accessible. |

### g) The Role of Off-site Backup

An **off-site backup** is a copy of data that is stored in a separate location from the primary site. This is done to protect the data in case of a disaster at the primary site.

### h) Disaster Recovery Concepts (RPO and RTO)

*   **Recovery Point Objective (RPO):** The maximum amount of time that you can afford to lose data.
*   **Recovery Time Objective (RTO):** The maximum amount of time that you can afford for a system to be down.

### i) Disaster Recovery Planning

**Disaster recovery planning** is the process of creating a plan to restore an organization's IT infrastructure and data after a disaster. A disaster recovery plan should include:

*   A list of all the critical systems and data.
*   A procedure for backing up the critical systems and data.
*   A procedure for restoring the critical systems and data.
*   A procedure for testing the disaster recovery plan.

### j) Disaster Recovery Strategy for Nkumba University Systems

*   **Academic Information Management System (AIMS):** RTO: 4 hours. This is a critical system that is needed for students and staff to access academic information.
*   **eLearning platform:** RTO: 8 hours. This is a critical system that is needed for students to access course materials and submit assignments.
*   **Tradumo:** RTO: 24 hours. This is a less critical system that is used for internal communication.

**System Hosting:**

**System hosting** is the process of storing and managing a system on a server. The systems at Nkumba University could be hosted in one of the following ways:

*   **On-premise:** The systems could be hosted on servers that are located at the university.
*   **Cloud:** The systems could be hosted on servers that are located in the cloud.
*   **Hybrid:** The systems could be hosted in a hybrid environment, with some systems on-premise and some in the cloud.

**What it takes to host these systems:**

*   **Servers:** You will need to have servers to host the systems.
*   **Network:** You will need to have a network to connect the servers to the internet.
*   **Software:** You will need to have the software for the systems, as well as the software for managing the servers and the network.
*   **Staff:** You will need to have staff to manage the systems.

**Disaster Recovery Strategy:**

*   **Backups:** All of the systems should be backed up regularly.
*   **Off-site backups:** The backups should be stored in an off-site location.
*   **Disaster recovery plan:** A disaster recovery plan should be created and tested regularly.
