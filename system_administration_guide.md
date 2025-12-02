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
3.  **Generality:** Design systems that can be used for a variety of purposes.
4.  **Automation:** Automate tasks whenever possible.
5.  **Communication:** Communicate with users and other stakeholders.
6.  **Basics first:** Make sure that the basics are working correctly before you move on to more complex tasks.

### d) Qualities of a Successful System Administrator

*   **Technical skills:** A successful system administrator must have strong technical skills in a variety of areas, including operating systems, networking, and security.
*   **Problem-solving skills:** A successful system administrator must be able to diagnose and resolve problems with hardware, software, and networks.
*   **Communication skills:** A successful system administrator must be able to communicate effectively with users and other stakeholders.
*   **Organizational skills:** A successful system administrator must be able to manage multiple tasks and projects at the same time.
*   **Customer service skills:** A successful system administrator must be able to provide excellent customer service to users.

### e) Performance: Latency and Throughput

*   **Latency:** The time it takes for a packet of data to travel from one point to another.
*   **Throughput:** The amount of data that can be transmitted over a network in a given amount of time.

### f) Shell Scripting

**What is Shell Scripting?**

Shell scripting is the process of writing scripts that can be executed by a shell. A shell is a command-line interpreter that is used to interact with the operating system.

**Examples of Shell Scripting:**

*   **Automate tasks:** You can use shell scripting to automate tasks such as creating new user accounts or backing up data.
*   **Manage systems:** You can use shell scripting to manage systems, such as starting and stopping services or installing and removing software.
*   **Troubleshoot problems:** You can use shell scripting to troubleshoot problems with hardware, software, and networks.

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

### c) Workstation Management

**Workstation management** is the process of managing a large number of workstations in an organization. This includes tasks such as:

*   **Deploying new workstations:** This includes installing the operating system and applications.
*   **Managing user accounts:** This includes creating and deleting user accounts, as well as setting and resetting passwords.
*   **Applying security policies:** This includes configuring firewalls and antivirus software.
*   **Troubleshooting problems:** This includes diagnosing and resolving problems with hardware and software.

### d) Server Virtualization

**Server virtualization** is the process of running multiple virtual servers on a single physical server. This has a number of benefits, including:

*   **Resource utilization:** Server virtualization can help to improve resource utilization by allowing you to run multiple servers on a single physical server.
*   **Scalability:** Server virtualization can help to improve scalability by allowing you to easily add or remove virtual servers as needed.
*   **Cost savings:** Server virtualization can help to reduce costs by reducing the number of physical servers that you need to purchase and maintain.

### e) Types of Servers

*   **File servers:** Store and manage files for users on a network.
*   **Web servers:** Host websites and web applications.
*   **Database servers:** Store and manage databases.
*   **Mail servers:** Send and receive emails.
*   **Print servers:** Manage printers on a network.
*   **Game servers:** Host online games.

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

```
      Forest
        |
      Tree
        |
      Domain
       / \
     OU   OU
    / \   / \
Object Object Object Object
```

### c) Authentication and Authorization in Active Directory

Active Directory uses the following mechanisms to authenticate and authorize users and resources:

*   **Authentication:** Active Directory uses the Kerberos protocol to authenticate users. When a user logs on to the network, they are issued a ticket-granting ticket (TGT) by the Key Distribution Center (KDC). The TGT is then used to request service tickets, which are used to access resources on the network.
*   **Authorization:** Active Directory uses access control lists (ACLs) to authorize access to resources. An ACL is a list of users and groups that are allowed to access a resource, and the level of access that they have.

### d) Joining a Computer to a Domain

To join a computer to an Active Directory domain, you need to:

1.  Log on to the computer as an administrator.
2.  Open the System Properties dialog box.
3.  Click the Computer Name tab.
4.  Click the Change button.
5.  Select the Domain option and enter the name of the domain that you want to join.
6.  Click OK.
7.  Enter the name and password of a user account that has permission to join the computer to the domain.
8.  Click OK.
9.  Restart the computer.

### e) Reasons to Use Active Directory

*   **Centralized management:** Active Directory provides a central location for managing user accounts, computers, and other resources.
*   **Improved security:** Active Directory provides a number of security features, such as authentication and authorization.
*   **Scalability:** Active Directory is a scalable solution that can be used in small, medium, and large organizations.

### f) Where Active Directory is Used

Active Directory is used in a variety of organizations, including:

*   **Businesses:** Active Directory is used to manage user accounts, computers, and other resources in a business environment.
*   **Schools:** Active Directory is used to manage student and staff accounts, as well as to control access to network resources.
*   **Government agencies:** Active Directory is used to manage user accounts, computers, and other resources in a government environment.

## 6. User Account Management

### a) Introduction to User Account Management

**User account management** is the process of creating, modifying, and deleting user accounts. It is used to control who has access to the resources on a network.

### b) Local vs. Domain and Computer Accounts

*   **Local user account:** A user account that is stored on a single computer.
*   **Domain user account:** A user account that is stored in Active Directory.
*   **Computer account:** A computer account is used to identify a computer on the network.

### c) Permissions and Access Control

**Permissions** are the rights that a user has to a resource. **Access control** is the process of granting or denying access to a resource based on the user's permissions.

### d) User Account Management Best Practices

*   **Use strong passwords:** Passwords should be long, complex, and difficult to guess.
*   **Don't share passwords:** Passwords should never be shared with anyone.
*   **Use unique passwords:** Don't use the same password for multiple accounts.
*   **Change your passwords regularly:** You should change your passwords every 90 days.
*   **Use two-factor authentication:** Two-factor authentication adds an extra layer of security to your accounts.

## 7. Backup and Disaster Recovery

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

### h) Disaster Recovery Concepts

*   **Recovery Point Objective (RPO):** The maximum amount of time that you can afford to lose data.
*   **Recovery Time Objective (RTO):** The maximum amount of time that you can afford for a system to be down.

### i) Disaster Recovery Planning

**Disaster recovery planning** is the process of creating a plan to restore an organization's IT infrastructure and data after a disaster. A disaster recovery plan should include:

*   A list of all the critical systems and data.
*   A procedure for backing up the critical systems and data.
*   A procedure for restoring the critical systems and data.
*   A procedure for testing the disaster recovery plan.

## Multiple Choice Questions and Answers

1.  **What is the primary purpose of a workstation?**
    *   **Answer:** b) To facilitate specialized tasks for individual users.
    *   **Explanation:** Workstations are high-performance computers designed for individual users who need to perform resource-intensive tasks such as video editing, 3D modeling, or scientific computing.

2.  **What is Active Directory?**
    *   **Answer:** c) A directory service
    *   **Explanation:** Active Directory is a directory service developed by Microsoft for Windows domain networks. It is a central database of all the user accounts, computers, and other resources on the network.

3.  **What is the primary function of Domain Name System (DNS)?**
    *   **Answer:** b) Resolving domain names to IP addresses
    *   **Explanation:** DNS is a system that translates human-readable domain names (such as www.google.com) into the IP addresses (such as 172.217.168.46) that computers use to communicate with each other.

4.  **Which of the following is an example of a strong password?**
    *   **Answer:** c) "P@ssw0rd!"
    *   **Explanation:** A strong password should be long, complex, and difficult to guess. It should include a mix of uppercase and lowercase letters, numbers, and symbols.

5.  **What is the primary goal of disaster recovery?**
    *   **Answer:** b) Minimizing the impact of disasters on business operations
    *   **Explanation:** Disaster recovery is the process of restoring an organization's IT infrastructure and data after a disaster. The primary goal is to minimize the downtime and financial losses that can result from a disaster.

6.  **What is the highest level of the Active Directory hierarchy?**
    *   **Answer:** a) Forest
    *   **Explanation:** A forest is a collection of one or more domains that share a common schema, configuration, and global catalog.

7.  **Which mode is used in FTP (File Transfer Protocol) to establish a data connection?**
    *   **Answer:** a) Active mode
    *   **Explanation:** In active mode, the client opens a random port and sends the port number to the server. The server then initiates a connection to the client on that port.

8.  **What is the primary purpose of a server?**
    *   **Answer:** b) To provide network services to multiple clients.
    *   **Explanation:** A server is a computer that is dedicated to providing services to other computers on a network.

9.  **What is the protocol used for transmitting web content over the Internet?**
    *   **Answer:** c) HTTP
    *   **Explanation:** HTTP (Hypertext Transfer Protocol) is the protocol that is used to transfer web pages and other web content from a web server to a web browser.

10. **What is the function of a web server?**
    *   **Answer:** c) Serving web pages to clients
    *   **Explanation:** A web server is a computer that stores and serves web pages to web browsers.

11. **What is the purpose of Active Directory Sites in a network?**
    *   **Answer:** b) To manage replication between domain controllers
    *   **Explanation:** Active Directory sites are used to group domain controllers together to optimize replication traffic.

12. **What distinguishes workstations from servers?**
    *   **Answer:** b) Servers are optimized for reliability and scalability.
    *   **Explanation:** Servers are designed to run 24/7 and to be able to handle a large number of requests from clients. They are also designed to be easily scalable, so that they can be upgraded to meet the growing demands of the network.

13. **What should take place in order to restore a server, its files and data after a major system failure?**
    *   **Answer:** a) Restore from storage media backup
    *   **Explanation:** The first step in restoring a server after a major failure is to restore the operating system, applications, and data from a backup.

14. **Which HTTP (Hypertext Transfer Protocol) method is used to retrieve data from a web server?**
    *   **Answer:** a) GET
    *   **Explanation:** The GET method is used to request a representation of the specified resource.

15. **What is the purpose of user account management?**
    *   **Answer:** a) To restrict access to resources
    *   **Explanation:** User account management is the process of creating, modifying, and deleting user accounts. It is used to control who has access to the resources on a network.

16. **Which of the following is an example of a user account management best practice?**
    *   **Answer:** c) Regularly reviewing and revoking unnecessary user privileges
    *   **Explanation:** It is a good practice to regularly review user accounts and to revoke any privileges that are no longer needed. This helps to reduce the risk of unauthorized access.

17. **Why is it important to regularly test data backups?**
    *   **Answer:** a) To ensure backups are not corrupted or incomplete
    *   **Explanation:** It is important to regularly test data backups to make sure that they are not corrupted or incomplete. This will ensure that you can restore your data if you ever need to.

18. **Which transport protocol is commonly used by DNS (Domain Name System)?**
    *   **Answer:** b) UDP
    *   **Explanation:** DNS primarily uses UDP because it is a faster protocol than TCP.

19. **Which component is responsible for delivering emails between mail servers?**
    *   **Answer:** b) SMTP server
    *   **Explanation:** An SMTP (Simple Mail Transfer Protocol) server is responsible for sending and receiving emails.

20. **Which of the following best defines data backup?**
    *   a) The process of permanently deleting data
    *   b) The process of copying and storing data for safekeeping
    *   c) The process of encrypting data for secure transmission
    *   d) The process of compressing data for efficient storage
    *   **Answer:** b) The process of copying and storing data for safekeeping
    *   **Explanation:** Data backup is the process of making copies of data so that these additional copies may be used to restore the original after a data loss event.

21. **Which type of backup captures all data and files, regardless of whether they have changed since the last backup?**
    *   **Answer:** c) Full backup
    *   **Explanation:** A full backup is a complete copy of all the data on a system.

21. **What is the purpose of off-site backup?**
    *   **Answer:** a) To keep data backups in a secure location away from the primary site
    *   **Explanation:** An off-site backup is a copy of data that is stored in a separate location from the primary site. This is done to protect the data in case of a disaster at the primary site.

22. **What is the difference between authentication and authorization?**
    *   **Answer:** a) Authentication verifies user identity, while authorization determines resource access rights.
    *   **Explanation:** Authentication is the process of verifying that a user is who they say they are. Authorization is the process of determining what a user is allowed to do.

23. **You are the network administrator for your company. Recently, one of your users in the accounting department has reported that they were unsure whether a banking website was legitimate or not. You want to configure a utility that will verify whether a website is known to be fraudulent. Which utility should you configure?**
    *   **Answer:** c) Phishing Filter
    *   **Explanation:** A phishing filter is a tool that is used to detect and block phishing websites.
