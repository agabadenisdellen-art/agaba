# IT and Systems Administration Q&A

## Section A (Multiple Choice)

1.  **What is the primary purpose of a workstation?**
    b) To facilitate specialized tasks for individual users.

2.  **What is Active Directory?**
    c) A directory service

3.  **What is the primary function of Domain Name System (DNS)?**
    b) Resolving domain names to IP addresses

4.  **Which of the following is an example of a strong password?**
    c) "P@ssw0rd!"

5.  **What is the primary goal of disaster recovery?**
    b) Minimizing the impact of disasters on business operations

6.  **What is the highest level of the Active Directory hierarchy?**
    a) Forest

7.  **Which mode is used in FTP (File Transfer Protocol) to establish a data connection?**
    a) Active mode
    b) Passive mode
    *(Both are valid, but passive is more common in modern networks)*

8.  **What is the primary purpose of a server?**
    b) To provide network services to multiple clients.

9.  **What is the protocol used for transmitting web content over the Internet?**
    c) HTTP

10. **What is the function of a web server?**
    c) Serving web pages to clients

11. **What is the purpose of Active Directory Sites in a network?**
    b) To manage replication between domain controllers

12. **What distinguishes workstations from servers?**
    b) Servers are optimized for reliability and scalability.

13. **What should take place in order to restore a server, its files and data after a major system failure?**
    a) Restore from storage media backup

14. **Which HTTP (Hypertext Transfer Protocol) method is used to retrieve data from a web server?**
    a) GET

15. **What is the purpose of user account management?**
    a) To restrict access to resources
    b) To ensure compliance with security policies
    *(Both are correct, but (a) is the more direct purpose)*

16. **Which of the following is an example of a user account management best practice?**
    c) Regularly reviewing and revoking unnecessary user privileges

17. **Why is it important to regularly test data backups?**
    a) To ensure backups are not corrupted or incomplete

18. **Which transport protocol is commonly used by DNS (Domain Name System)?**
    b) UDP

20. **Which of the following best defines data backup?**
    b) The process of copying and storing data for safekeeping

21. **Which component is responsible for delivering emails between mail servers?**
    b) SMTP server

22. **Which type of backup captures all data and files, regardless of whether they have changed since the last backup?**
    c) Full backup

23. **What is the purpose of off-site backup?**
    a) To keep data backups in a secure location away from the primary site

24. **What is the difference between authentication and authorization?**
    a) Authentication verifies user identity, while authorization determines resource access rights.

25. **You are the network administrator for your company. Recently, one of your users in the accounting department has reported that they were unsure whether a banking website was legitimate or not. You want to configure a utility that will verify whether a website is known to be fraudulent. Which utility should you configure?**
    c) Phishing Filter

## SECTION B (Structured Questions)

### Question 1

**a) Discuss the key differences between a server and a workstation in terms of hardware, software, and functionality.** [8 Marks]

| Feature | Server | Workstation |
| :--- | :--- | :--- |
| **Hardware** | Optimized for 24/7 operation, high reliability, and scalability. Often have redundant power supplies, hot-swappable drives, and more RAM and CPU cores. | Optimized for user interaction and performance on specialized tasks like graphic design, video editing, or software development. |
| **Software** | Runs a server operating system (e.g., Windows Server, Linux) and specialized software for providing services (e.g., web server, database server). | Runs a desktop operating system (e.g., Windows 10/11, macOS, Linux desktop) and applications for end-users. |
| **Functionality** | Provides services to multiple clients over a network. | Used by a single user to perform specific tasks. |

**b) Explain the functions of an operating system on a workstation** [8 Marks]

*   **Process Management:** Manages the execution of applications and background processes.
*   **Memory Management:** Allocates and deallocates memory to running processes.
*   **File System Management:** Organizes and provides access to files and directories.
*   **Device Management:** Manages the interaction between software and hardware devices.
*   **User Interface:** Provides a graphical user interface (GUI) or command-line interface (CLI) for user interaction.
*   **Security:** Provides mechanisms for user authentication and access control.

**c) Explain the concept of server virtualization and its benefits in terms of resource utilization and scalability.** [5 Marks]

Server virtualization is the process of creating multiple virtual servers on a single physical server. Each virtual server runs its own operating system and applications, and is isolated from the other virtual servers.

**Benefits:**

*   **Improved Resource Utilization:** Multiple virtual servers can share the resources of a single physical server, which reduces the need for physical hardware.
*   **Increased Scalability:** New virtual servers can be created and deployed quickly and easily, without the need to purchase and configure new physical hardware.
*   **Reduced Costs:** Fewer physical servers means lower hardware, power, and cooling costs.
*   **Improved Disaster Recovery:** Virtual servers can be easily backed up and restored, which simplifies disaster recovery.

**d) Describe different types of servers, such as file servers, web servers, database servers, and mail servers, and discuss their respective purposes.** [4 Marks]

*   **File Server:** Stores and manages files for multiple users on a network.
*   **Web Server:** Hosts websites and serves web pages to clients over the Internet.
*   **Database Server:** Stores and manages databases, and provides access to data for applications.
*   **Mail Server:** Sends, receives, and stores emails.

### Question 2

**a) Explain the concept of user account management and its importance in an organization's IT infrastructure.** [5 Marks]

User account management is the process of creating, managing, and deleting user accounts on a network. It is important for:

*   **Security:** Ensuring that only authorized users have access to network resources.
*   **Compliance:** Meeting regulatory requirements for data security and privacy.
*   **Efficiency:** Streamlining the process of granting and revoking access to resources.

**b) Explain the difference between a local user account and a computer account in Active Directory.** [5 Marks]

*   **Local User Account:** Exists only on a single computer and is used to log in to that computer.
*   **Computer Account:** Represents a computer in Active Directory and is used to authenticate the computer to the domain.

**c) Discuss the role of user account permissions and access levels in ensuring security and data integrity.** [5 Marks]

User account permissions and access levels are used to control what users can do on a network. By granting users only the permissions they need to perform their jobs, you can:

*   **Prevent unauthorized access to data.**
*   **Reduce the risk of accidental data deletion or modification.**
*   **Ensure that data is only accessed by authorized users.**

**d) Define resource access and discuss its significance in a networked environment** [5 Marks]

Resource access is the ability of a user to access a resource on a network, such as a file, printer, or application. It is significant because it allows users to share resources and collaborate on projects.

**e) Describe the concept of file permissions and access control lists (ACLs) in controlling resource access.** [5 Marks]

*   **File Permissions:** A set of rules that determine who can access a file and what they can do with it (e.g., read, write, execute).
*   **Access Control List (ACL):** A list of users and groups who have been granted access to a resource, and the level of access they have.

### Question 3

**a) Explain the purpose of FTP and how it facilitates file transfer over a network.** [4 Marks]

FTP (File Transfer Protocol) is a network protocol used to transfer files between computers on a network. It works by establishing two connections between the client and the server: a control connection for sending commands, and a data connection for transferring files.

**b) How does FTP handle authentication and authorization of users?** [3 Marks]

FTP uses a username and password to authenticate users. Once a user is authenticated, they are authorized to access certain files and directories on the server, based on their permissions.

**c) Describe the process of resolving a domain name to an IP address using DNS.** [8 Marks]

1.  A user enters a domain name (e.g., www.google.com) into their web browser.
2.  The web browser sends a request to a DNS resolver, which is typically provided by the user's ISP.
3.  The DNS resolver checks its cache to see if it has the IP address for the domain name.
4.  If the IP address is not in the cache, the DNS resolver sends a request to a root DNS server.
5.  The root DNS server responds with the IP address of a top-level domain (TLD) DNS server (e.g., the .com TLD server).
6.  The DNS resolver sends a request to the TLD DNS server.
7.  The TLD DNS server responds with the IP address of an authoritative DNS server for the domain name.
8.  The DNS resolver sends a request to the authoritative DNS server.
9.  The authoritative DNS server responds with the IP address for the domain name.
10. The DNS resolver sends the IP address to the web browser.
11. The web browser uses the IP address to connect to the web server and load the website.

**d) Discuss the difference between SMTP and POP3. How do these protocols work together to facilitate email sending and retrieval?** [10 Marks]

*   **SMTP (Simple Mail Transfer Protocol):** Used to send emails from a client to a server, and between servers.
*   **POP3 (Post Office Protocol version 3):** Used to retrieve emails from a server to a client.

When you send an email, your email client uses SMTP to send the email to your mail server. Your mail server then uses SMTP to send the email to the recipient's mail server. When the recipient checks their email, their email client uses POP3 to retrieve the email from their mail server.

### Question 4

**a) Define data backup and explain its significance in ensuring data integrity and availability.** [5 Marks]

Data backup is the process of creating a copy of data and storing it in a separate location. It is significant because it allows you to restore data in the event of a data loss event, such as a hardware failure, natural disaster, or cyberattack.

**b) Discuss the different types of data backups, such as full backup, incremental backup, and differential backup, and explain when each type is appropriate.** [5 Marks]

*   **Full Backup:** A complete copy of all data. Appropriate for the initial backup, and for periodic backups to ensure that you have a complete copy of your data.
*   **Incremental Backup:** A copy of all data that has changed since the last backup. Appropriate for daily backups, as it is faster than a full backup.
*   **Differential Backup:** A copy of all data that has changed since the last full backup. Appropriate for weekly backups, as it is faster to restore than an incremental backup.

**c) Describe the steps involved in restoring data from a backup and discuss the challenges and considerations in the restoration process.** [10 Marks]

1.  **Identify the data to be restored.**
2.  **Locate the backup media.**
3.  **Restore the data to the original location or to an alternate location.**
4.  **Verify that the data has been restored correctly.**

**Challenges and Considerations:**

*   **Time:** The restoration process can be time-consuming, especially for large amounts of data.
*   **Complexity:** The restoration process can be complex, especially if you are restoring data to a different location or to a different type of hardware.
*   **Data Integrity:** It is important to verify that the data has been restored correctly and that there is no data loss.

**d) Describe the concept of disaster recovery planning and explain how data backups play a crucial role in the overall recovery strategy** [5 Marks]

Disaster recovery planning is the process of creating a plan to restore your IT infrastructure in the event of a disaster. Data backups are a crucial part of disaster recovery planning because they allow you to restore your data and get your business back up and running as quickly as possible.

### Question 5

**a) What is Active Directory (AD) and what is its primary purpose in a Windows network environment?** [4 Marks]

Active Directory is a directory service that is used to manage users, computers, and other resources on a Windows network. Its primary purpose is to provide a central location for storing and managing information about network resources.

**b) How does Active Directory handle authentication and authorization of users and resources?** [5 Marks]

Active Directory uses a process called Kerberos to authenticate users. When a user logs in to a computer that is a member of an Active Directory domain, the computer sends a request to a domain controller. The domain controller authenticates the user and issues a ticket-granting ticket (TGT). The TGT is then used to request service tickets, which are used to access resources on the network.

**c) Describe the process of joining a computer to an Active Directory domain.** [8 Marks]

1.  **Open the System Properties dialog box.**
2.  **Click the Computer Name tab.**
3.  **Click the Change button.**
4.  **In the Computer Name/Domain Changes dialog box, select the Domain option and enter the name of the domain.**
5.  **Click OK.**
6.  **Enter the username and password of an account that has permission to join the computer to the domain.**
7.  **Click OK.**
8.  **Restart the computer.**

**d) Explain the concept of Organizational Units (OUs) in Active Directory and their role in organizing and managing objects.** [8 Marks]

Organizational Units (OUs) are containers that are used to organize objects in Active Directory, such as users, computers, and groups. OUs can be used to:

*   **Delegate administrative tasks.**
*   **Apply group policies.**
*   **Simplify the management of Active Directory.**

### Question 6

**a) What is SNMP and what is its primary purpose in network management?** [4 Marks]

SNMP (Simple Network Management Protocol) is a network protocol that is used to manage and monitor network devices. Its primary purpose is to provide a standard way for network devices to communicate with each other.

**b) Explain the purpose and usage of the following HTTP methods: GET, POST, PUT, DELETE.** [8 Marks]

*   **GET:** Used to retrieve data from a web server.
*   **POST:** Used to submit data to a web server.
*   **PUT:** Used to update data on a web server.
*   **DELETE:** Used to delete data from a web server.

**c) What is the World Wide Web and how does it differ from the internet?** [5 Marks]

*   **Internet:** A global network of computers that are connected to each other.
*   **World Wide Web:** A system of interconnected documents and other web resources that are accessed via the Internet.

The World Wide Web is a service that runs on the Internet.

**d) What is a URL (Uniform Resource Locator), and how does it work in web addressing?** [4 Marks]

A URL is a unique address that is used to identify a resource on the Internet. It consists of a protocol (e.g., http, https), a domain name (e.g., www.google.com), and a path to the resource.

**e) Explain the concept of a web application and how it differs from traditional websites.** [4 Marks]

*   **Website:** A collection of static web pages that are linked together.
*   **Web Application:** A dynamic website that allows users to interact with it and perform tasks.

Web applications are more complex than websites and typically require a database to store data.

### QUESTIONS

**1. a) What is system administration and what do systems administrators do?** [2 marks]

System administration is the field of work in which someone manages one or more systems, including servers, workstations, and networks. System administrators are responsible for the installation, configuration, and maintenance of these systems.

**b) With the help of a well labeled diagram define the term system in the context of system administration.** [5 marks]

A system is a collection of interconnected components that work together to perform a function. In the context of system administration, a system can be a single computer, a network of computers, or a complex IT infrastructure.

```
+-----------------+
|   Hardware      |
+-----------------+
|   Operating     |
|   System        |
+-----------------+
|   Applications  |
+-----------------+
|   Users         |
+-----------------+
```

**c) write down and explain six principles of System administration.** [3 marks]

*   **Simplicity:** Keep systems as simple as possible.
*   **Automation:** Automate repetitive tasks.
*   **Documentation:** Document everything.
*   **Security:** Protect systems from unauthorized access.
*   **Monitoring:** Monitor systems for problems.
*   **Communication:** Communicate with users and other stakeholders.

**d) Write down and explain the qualities of a Successful System administrator.** [2 marks]

*   **Problem-solving skills:** The ability to identify and solve problems quickly and efficiently.
*   **Communication skills:** The ability to communicate effectively with users and other stakeholders.
*   **Technical skills:** A strong understanding of computer hardware, software, and networking.
*   **Organizational skills:** The ability to manage multiple tasks and projects at the same time.

**2. a) Write down and explain six (6) types of Operating System (OS).** [3 marks]

*   **Batch OS:** Processes jobs in batches, without any user interaction.
*   **Time-sharing OS:** Allows multiple users to share a single computer.
*   **Distributed OS:** Manages a group of independent computers and makes them appear to be a single computer.
*   **Network OS:** Provides network services to clients.
*   **Real-time OS:** Is designed to respond to events in a predictable and timely manner.
*   **Mobile OS:** Is designed for mobile devices, such as smartphones and tablets.

**b) Write down and explain six (6) functions of Operating System.** [3 marks]

*   **Process Management:** Manages the execution of applications and background processes.
*   **Memory Management:** Allocates and deallocates memory to running processes.
*   **File System Management:** Organizes and provides access to files and directories.
*   **Device Management:** Manages the interaction between software and hardware devices.
*   **User Interface:** Provides a graphical user interface (GUI) or command-line interface (CLI) for user interaction.
*   **Security:** Provides mechanisms for user authentication and access control.

**c) Give two (2) differences between Firmware and Operating System.** [2 marks]

| Feature | Firmware | Operating System |
| :--- | :--- | :--- |
| **Location** | Stored in non-volatile memory, such as ROM. | Stored on a hard drive or other secondary storage device. |
| **Purpose** | Provides low-level control of a specific hardware device. | Provides a high-level interface between the user and the hardware. |

**3. a) Differentiate between a server and a workstation.** [2 marks]

| Feature | Server | Workstation |
| :--- | :--- | :--- |
| **Purpose** | Provides services to multiple clients over a network. | Used by a single user to perform specific tasks. |
| **Hardware** | Optimized for 24/7 operation, high reliability, and scalability. | Optimized for user interaction and performance on specialized tasks. |

**b) With the help of a well labeled diagram explain the concept of workstation management.** [4 marks]

Workstation management is the process of managing the lifecycle of workstations, from procurement to disposal.

```
+-----------------+
|   Procurement   |
+-----------------+
|   Deployment    |
+-----------------+
|   Maintenance   |
+-----------------+
|   Disposal      |
+-----------------+
```

**c) Performance of a system is affected by latency and throughput define each of these and explain how they affect the performance.** [2 marks]

*   **Latency:** The time it takes for a single bit of data to travel from the source to the destination.
*   **Throughput:** The amount of data that can be transferred from the source to the destination in a given amount of time.

High latency and low throughput can both negatively affect the performance of a system.

**d) Server operating systems facilitate typical server roles, list any two (2) server roles.** [2 marks]

*   **File Server:** Stores and manages files for multiple users on a network.
*   **Web Server:** Hosts websites and serves web pages to clients over the Internet.

**4. a) write down and explain any four (4) common network services.** [4 marks]

*   **DNS (Domain Name System):** Resolves domain names to IP addresses.
*   **DHCP (Dynamic Host Configuration Protocol):** Assigns IP addresses to devices on a network.
*   **FTP (File Transfer Protocol):** Transfers files between computers on a network.
*   **HTTP (Hypertext Transfer Protocol):** Transmits web content over the Internet.

**b) Write down three (3) Principles for Designing a Reliable Service.** [3 marks]

*   **Simplicity:** Keep the service as simple as possible.
*   **Redundancy:** Use redundant components to eliminate single points of failure.
*   **Monitoring:** Monitor the service for problems.

**c) In a Scenario where Alice sends a message to Bob, we have six (6) steps that this message goes through in order to get to its destination, write down the six stages.** [3 marks]

1.  **Application Layer:** The message is created by an application, such as an email client.
2.  **Transport Layer:** The message is broken down into segments and a port number is added to each segment.
3.  **Network Layer:** An IP address is added to each segment, creating a packet.
4.  **Data Link Layer:** A MAC address is added to each packet, creating a frame.
5.  **Physical Layer:** The frame is converted into bits and transmitted over the network.
6.  **The process is reversed on the receiving end.**

## SECTION A

**a) What is system administration and what do systems administrators do?** [4 Marks]

System administration is the field of work in which someone manages one or more systems, including servers, workstations, and networks. System administrators are responsible for the installation, configuration, and maintenance of these systems.

**b) With the help of a well labeled diagram define the term system in the context of system administration.** [5 Marks]

A system is a collection of interconnected components that work together to perform a function. In the context of system administration, a system can be a single computer, a network of computers, or a complex IT infrastructure.

```
+-----------------+
|   Hardware      |
+-----------------+
|   Operating     |
|   System        |
+-----------------+
|   Applications  |
+-----------------+
|   Users         |
+-----------------+
```

**c) Write down and explain three (3) principles of System administration.** [3 Marks]

*   **Simplicity:** Keep systems as simple as possible.
*   **Automation:** Automate repetitive tasks.
*   **Documentation:** Document everything.

**d) Write down and explain the qualities of a Successful System administrator.** [2 Marks]

*   **Problem-solving skills:** The ability to identify and solve problems quickly and efficiently.
*   **Communication skills:** The ability to communicate effectively with users and other stakeholders.
*   **Technical skills:** A strong understanding of computer hardware, software, and networking.
*   **Organizational skills:** The ability to manage multiple tasks and projects at the same time.

**e) Write down and explain any four (4) common network services.** [4 Marks]

*   **DNS (Domain Name System):** Resolves domain names to IP addresses.
*   **DHCP (Dynamic Host Configuration Protocol):** Assigns IP addresses to devices on a network.
*   **FTP (File Transfer Protocol):** Transfers files between computers on a network.
*   **HTTP (Hypertext Transfer Protocol):** Transmits web content over the Internet.

**f) Explain the purpose and usage of the following HTTP methods: GET, POST, PUT, DELETE.** [4 Marks]

*   **GET:** Used to retrieve data from a web server.
*   **POST:** Used to submit data to a web server.
*   **PUT:** Used to update data on a web server.
*   **DELETE:** Used to delete data from a web server.

**g) Performance of a system is affected by latency and throughput define each of these and explain how they affect the performance.** [2 Marks]

*   **Latency:** The time it takes for a single bit of data to travel from the source to the destination.
*   **Throughput:** The amount of data that can be transferred from the source to the destination in a given amount of time.

High latency and low throughput can both negatively affect the performance of a system.

**h) What is the difference between a user account and a computer account?** [2 Marks]

*   **User Account:** Represents a user in Active Directory and is used to authenticate the user to the domain.
*   **Computer Account:** Represents a computer in Active Directory and is used to authenticate the computer to the domain.

**i) What is the difference between backup and disaster recovery?** [2 Marks]

*   **Backup:** The process of creating a copy of data and storing it in a separate location.
*   **Disaster Recovery:** The process of restoring IT infrastructure in the event of a disaster.

**j) What is the role of off-site backup in data protection?** [2 Marks]

Off-site backup is the process of storing a copy of data in a location that is geographically separate from the primary site. This is done to protect data from disasters that may affect the primary site, such as fires, floods, and earthquakes.

**k) What is the difference between local backup and cloud backup?** [2 Marks]

*   **Local Backup:** A backup that is stored on a device that is physically connected to the computer being backed up.
*   **Cloud Backup:** A backup that is stored on a remote server that is accessed over the Internet.

**l) What is Active Directory, and what is its primary purpose?** [2 Marks]

Active Directory is a directory service that is used to manage users, computers, and other resources on a Windows network. Its primary purpose is to provide a central location for storing and managing information about network resources.

**m) How does Active Directory handle authentication and authorization of users and resources?** [2 Marks]

Active Directory uses a process called Kerberos to authenticate users. When a user logs in to a computer that is a member of an Active Directory domain, the computer sends a request to a domain controller. The domain controller authenticates the user and issues a ticket-granting ticket (TGT). The TGT is then used to request service tickets, which are used to access resources on the network.

**n) What is shell scripting?** [2 Marks]

Shell scripting is the process of writing scripts that are executed by a shell, such as the Bash shell or the PowerShell. Shell scripts can be used to automate tasks, such as creating users, managing files, and configuring network devices.

**o) Write down four examples of how shell scripting can be used.** [2 Marks]

*   Automating the creation of user accounts.
*   Managing files and directories.
*   Configuring network devices.
*   Monitoring system performance.

## SECTION B

### Question 1

**a) Discuss the key differences between a server and a workstation in terms of hardware, software, and functionality.** [8 Marks]

| Feature | Server | Workstation |
| :--- | :--- | :--- |
| **Hardware** | Optimized for 24/7 operation, high reliability, and scalability. Often have redundant power supplies, hot-swappable drives, and more RAM and CPU cores. | Optimized for user interaction and performance on specialized tasks like graphic design, video editing, or software development. |
| **Software** | Runs a server operating system (e.g., Windows Server, Linux) and specialized software for providing services (e.g., web server, database server). | Runs a desktop operating system (e.g., Windows 10/11, macOS, Linux desktop) and applications for end-users. |
| **Functionality** | Provides services to multiple clients over a network. | Used by a single user to perform specific tasks. |

**b) Explain the functions of an operating system on a workstation** [6 Marks]

*   **Process Management:** Manages the execution of applications and background processes.
*   **Memory Management:** Allocates and deallocates memory to running processes.
*   **File System Management:** Organizes and provides access to files and directories.
*   **Device Management:** Manages the interaction between software and hardware devices.
*   **User Interface:** Provides a graphical user interface (GUI) or command-line interface (CLI) for user interaction.
*   **Security:** Provides mechanisms for user authentication and access control.

**c) Explain the concept of server virtualization and its benefits in terms of resource utilization and scalability.** [2 Marks]

Server virtualization is the process of creating multiple virtual servers on a single physical server. Each virtual server runs its own operating system and applications, and is isolated from the other virtual servers.

**Benefits:**

*   **Improved Resource Utilization:** Multiple virtual servers can share the resources of a single physical server, which reduces the need for physical hardware.
*   **Increased Scalability:** New virtual servers can be created and deployed quickly and easily, without the need to purchase and configure new physical hardware.

**d) Describe different types of servers, such as file servers, web servers, database servers, and mail servers, and discuss their respective purposes.** [4 Marks]

*   **File Server:** Stores and manages files for multiple users on a network.
*   **Web Server:** Hosts websites and serves web pages to clients over the Internet.
*   **Database Server:** Stores and manages databases, and provides access to data for applications.
*   **Mail Server:** Sends, receives, and stores emails.

### Question 2

**a) Explain the concept “system service” following the guidelines below.**

*   **i. Definition** [2 Marks]
    A system service is a program that runs in the background and provides a specific function to the operating system or to other applications.
*   **ii. Purpose** [2 Marks]
    The purpose of a system service is to provide a function that is always available, regardless of whether a user is logged in to the computer.
*   **iii. Components** [2 Marks]
    A system service typically consists of an executable file, a configuration file, and a set of registry entries.
*   **iv. Examples** [2 Marks]
    *   Print Spooler
    *   Windows Update
    *   Task Scheduler

**b) Network services are programs that provide specific functions to network users. List any 5 most common network services.** [5 Marks]

*   DNS (Domain Name System)
*   DHCP (Dynamic Host Configuration Protocol)
*   FTP (File Transfer Protocol)
*   HTTP (Hypertext Transfer Protocol)
*   SMTP (Simple Mail Transfer Protocol)

**c) Network security threats are malicious attempts to harm or exploit networks. Write down four (4) most common network security threats.** [4 Marks]

*   **Viruses:** A type of malware that can replicate itself and spread to other computers.
*   **Worms:** A type of malware that can spread to other computers without any user interaction.
*   **Trojan Horses:** A type of malware that is disguised as a legitimate program.
*   **Spyware:** A type of malware that collects information about a user without their knowledge.

**d) Write down three (3) different types of network security measures?** [3 Marks]

*   **Firewalls:** A device that is used to block unauthorized access to a network.
*   **Intrusion Detection Systems (IDS):** A device that is used to detect and respond to security threats.
*   **Antivirus Software:** A program that is used to protect computers from viruses and other malware.

### Question 3

**a) What is SNMP and what is its primary purpose in network management?** [2 Marks]

SNMP (Simple Network Management Protocol) is a network protocol that is used to manage and monitor network devices. Its primary purpose is to provide a standard way for network devices to communicate with each other.

**b) Discuss the difference between SMTP and POP3. How do these protocols work together to facilitate email sending and retrieval?** [8 Marks]

*   **SMTP (Simple Mail Transfer Protocol):** Used to send emails from a client to a server, and between servers.
*   **POP3 (Post Office Protocol version 3):** Used to retrieve emails from a server to a client.

When you send an email, your email client uses SMTP to send the email to your mail server. Your mail server then uses SMTP to send the email to the recipient's mail server. When the recipient checks their email, their email client uses POP3 to retrieve the email from their mail server.

**c) What is the World Wide Web and how does it differ from the internet?** [4 Marks]

*   **Internet:** A global network of computers that are connected to each other.
*   **World Wide Web:** A system of interconnected documents and other web resources that are accessed via the Internet.

The World Wide Web is a service that runs on the Internet.

**d) What is a URL (Uniform Resource Locator), and how does it work in web addressing?** [2 Marks]

A URL is a unique address that is used to identify a resource on the Internet. It consists of a protocol (e.g., http, https), a domain name (e.g., www.google.com), and a path to the resource.

**e) Explain the concept of a web application and how it differs from traditional websites.** [4 Marks]

*   **Website:** A collection of static web pages that are linked together.
*   **Web Application:** A dynamic website that allows users to interact with it and perform tasks.

Web applications are more complex than websites and typically require a database to store data.

### Question 4

**a) Define the term Data Backup, then go ahead to explain the three (3) purposes that Backups serve.** [4 Marks]

Data backup is the process of creating a copy of data and storing it in a separate location.

**Purposes of Backups:**

*   **Disaster Recovery:** To restore data in the event of a data loss event, such as a hardware failure, natural disaster, or cyberattack.
*   **Archiving:** To store data for long-term retention.
*   **Compliance:** To meet regulatory requirements for data retention.

**b) With the help of a diagram explain the three pillars of Backup Architecture.** [4 Marks]

```
+-----------------+
|   Source        |
+-----------------+
|   Destination   |
+-----------------+
|   Schedule      |
+-----------------+
```

*   **Source:** The data that is to be backed up.
*   **Destination:** The location where the backup is to be stored.
*   **Schedule:** The frequency at which the backup is to be performed.

**c) Write down and explain any five (5) types of backups** [5 Marks]

*   **Full Backup:** A complete copy of all data.
*   **Incremental Backup:** A copy of all data that has changed since the last backup.
*   **Differential Backup:** A copy of all data that has changed since the last full backup.
*   **Mirror Backup:** A copy of all data that is an exact replica of the source data.
*   **Cloud Backup:** A backup that is stored on a remote server that is accessed over the Internet.

**d) Write down and explain the steps taken in Backup Operation** [7 Marks]

1.  **Identify the data to be backed up.**
2.  **Select a backup destination.**
3.  **Choose a backup schedule.**
4.  **Configure the backup software.**
5.  **Run the backup.**
6.  **Verify the backup.**
7.  **Store the backup in a safe location.**

### Question 5

**a) Define the term disaster and explain the three categories of disasters in the IT System.** [4 Marks]

A disaster is an event that causes a significant disruption to business operations.

**Categories of Disasters:**

*   **Natural Disasters:** Fires, floods, earthquakes, etc.
*   **Man-made Disasters:** Power outages, terrorist attacks, etc.
*   **Technical Disasters:** Hardware failures, software bugs, etc.

**b) Organizations deal with disaster recovery by address three major factors, write and explain these factors.** [4 Marks]

*   **People:** The people who are responsible for implementing the disaster recovery plan.
*   **Processes:** The steps that need to be taken to restore IT infrastructure.
*   **Technology:** The hardware and software that is needed to restore IT infrastructure.

**c) Explain these two concepts and how they relate to disaster recovery.** [4 Marks]

*   **i. Recovery Point Objective (RPO):** The maximum amount of data that can be lost in a disaster.
*   **ii. Recovery Time Objective (RTO):** The maximum amount of time that it can take to restore IT infrastructure after a disaster.

**d) Compare the two concepts Recovery Point Objective(RPO) and Recovery Time Objective(RTO) using the criteria i) Focus on, ii) Depends on, iii) Describes, iv) Consideration.** [4 Marks]

| Criteria | RPO | RTO |
| :--- | :--- | :--- |
| **Focus on** | Data loss | Time to recover |
| **Depends on** | Backup frequency | Restoration process |
| **Describes** | How much data you can afford to lose | How quickly you need to be back up and running |
| **Consideration** | Business impact of data loss | Business impact of downtime |

**e) Explain what a disaster recovery plan is and list three issues you consider in a disaster recovery plan.** [4 Marks]

A disaster recovery plan is a document that outlines the steps that need to be taken to restore IT infrastructure after a disaster.

**Issues to Consider:**

*   **Business Impact Analysis:** To identify the critical business processes and the impact of a disaster on those processes.
*   **Risk Assessment:** To identify the potential threats to IT infrastructure and the likelihood of those threats occurring.
*   **Recovery Strategy:** To determine the best way to restore IT infrastructure.

### Question 6

**a) Define the term Active Directory, and proceed by listing any four Active Directory objects.** [5 Marks]

Active Directory is a directory service that is used to manage users, computers, and other resources on a Windows network.

**Active Directory Objects:**

*   Users
*   Groups
*   Computers
*   Printers

**b) A domain has four (4) components write down and explain these components.** [5 Marks]

*   **Domain Controllers:** Servers that store a copy of the Active Directory database.
*   **Member Servers:** Servers that are members of the domain but are not domain controllers.
*   **Workstations:** Computers that are members of the domain.
*   **Users:** People who are authorized to access resources on the domain.

**c) Give five (5) reasons why we should use Active Directory Services.** [5 Marks]

*   **Centralized Management:** Provides a central location for managing users, computers, and other resources.
*   **Improved Security:** Provides a single point of authentication and authorization.
*   **Simplified Administration:** Simplifies the process of managing a large number of users and computers.
*   **Increased Scalability:** Can be scaled to support a large number of users and computers.
*   **Improved Reliability:** Provides a fault-tolerant and redundant directory service.

**d) Write down five (5) areas where Active Directory Services can be used** [5 Marks]

*   **User authentication and authorization.**
*   **Group Policy management.**
*   **Software deployment.**
*   **Certificate services.**
*   **Domain Name System (DNS).**

## SECTION A

**a) What is system administration and what do systems administrators do?** [4 Marks]

System administration is the field of work in which someone manages one or more systems, including servers, workstations, and networks. System administrators are responsible for the installation, configuration, and maintenance of these systems.

**b) With the help of a well labeled diagram define the term system in the context of system administration.** [5 Marks]

A system is a collection of interconnected components that work together to perform a function. In the context of system administration, a system can be a single computer, a network of computers, or a complex IT infrastructure.

```
+-----------------+
|   Hardware      |
+-----------------+
|   Operating     |
|   System        |
+-----------------+
|   Applications  |
+-----------------+
|   Users         |
+-----------------+
```

**c) Write down a SHUTDOWN command to schedule a system shutdown to occur in 5 minutes, displaying the message "System will shut down in 5 minutes." to the user.** [3 Marks]

```
shutdown /s /t 300 /c "System will shut down in 5 minutes."
```

**d) Write down and explain the qualities of a Successful System administrator.** [2 Marks]

*   **Problem-solving skills:** The ability to identify and solve problems quickly and efficiently.
*   **Communication skills:** The ability to communicate effectively with users and other stakeholders.
*   **Technical skills:** A strong understanding of computer hardware, software, and networking.
*   **Organizational skills:** The ability to manage multiple tasks and projects at the same time.

**e) You have a folder named "OldFiles" containing several files. Write a CMD command that moves all files from the "OldFiles" folder to a new folder named "ProcessedFiles" located in the same directory. The script should create "ProcessedFiles" if it doesn't already exist.** [4 Marks]

```
mkdir ProcessedFiles
move OldFiles\* ProcessedFiles
```

**f) Write a CMD script that Creates a new folder named "Backup" in the current directory and Copies all files with the .txt extension from the current directory into the "Backup" folder.** [4 Marks]

```
mkdir Backup
copy *.txt Backup
```

**g) Performance of a system is affected by latency and throughput define each of these and explain how they affect the performance.** [2 Marks]

*   **Latency:** The time it takes for a single bit of data to travel from the source to the destination.
*   **Throughput:** The amount of data that can be transferred from the source to the destination in a given amount of time.

High latency and low throughput can both negatively affect the performance of a system.

**h) What is the difference between a user account and a computer account?** [2 Marks]

*   **User Account:** Represents a user in Active Directory and is used to authenticate the user to the domain.
*   **Computer Account:** Represents a computer in Active Directory and is used to authenticate the computer to the domain.

**i) What is the difference between backup and disaster recovery?** [2 Marks]

*   **Backup:** The process of creating a copy of data and storing it in a separate location.
*   **Disaster Recovery:** The process of restoring IT infrastructure in the event of a disaster.

**j) What is the role of off-site backup in data protection?** [2 Marks]

Off-site backup is the process of storing a copy of data in a location that is geographically separate from the primary site. This is done to protect data from disasters that may affect the primary site, such as fires, floods, and earthquakes.

**k) What is the difference between local backup and cloud backup?** [2 Marks]

*   **Local Backup:** A backup that is stored on a device that is physically connected to the computer being backed up.
*   **Cloud Backup:** A backup that is stored on a remote server that is accessed over the Internet.

**l) What is Active Directory, and what is its primary purpose?** [2 Marks]

Active Directory is a directory service that is used to manage users, computers, and other resources on a Windows network. Its primary purpose is to provide a central location for storing and managing information about network resources.

**m) How does Active Directory handle authentication and authorization of users and resources?** [2 Marks]

Active Directory uses a process called Kerberos to authenticate users. When a user logs in to a computer that is a member of an Active Directory domain, the computer sends a request to a domain controller. The domain controller authenticates the user and issues a ticket-granting ticket (TGT). The TGT is then used to request service tickets, which are used to access resources on the network.

**n) What is shell scripting?** [2 Marks]

Shell scripting is the process of writing scripts that are executed by a shell, such as the Bash shell or the PowerShell. Shell scripts can be used to automate tasks, such as creating users, managing files, and configuring network devices.

**o) Write down four examples of how shell scripting can be used.** [2 Marks]

*   Automating the creation of user accounts.
*   Managing files and directories.
*   Configuring network devices.
*   Monitoring system performance.

## SECTION B

### Question 1

**a) Explain the concept of user account management and its importance in an organization's IT infrastructure.** [4 Marks]

User account management is the process of creating, managing, and deleting user accounts on a network. It is important for:

*   **Security:** Ensuring that only authorized users have access to network resources.
*   **Compliance:** Meeting regulatory requirements for data security and privacy.
*   **Efficiency:** Streamlining the process of granting and revoking access to resources.

**b) Explain the difference between a local user account and a computer account in Active Directory.** [4 Marks]

*   **Local User Account:** Exists only on a single computer and is used to log in to that computer.
*   **Computer Account:** Represents a computer in Active Directory and is used to authenticate the computer to the domain.

**c) Innovations and Computing Uganda Limited has Four senior workers Joyce, Patrick, Josiah and Mary who possess certain rights (in bold-i.e. Delete, Read, Send, Update, Owns and Edit) over four different special company files (File 1, File 2, File 3, File 4). Joyce Owns File 1 and he is be able to Delete, to Edit, and to Read it. However, he has no rights to send it to customers, it is Patrick who can Send File 1 to customers. Mary is allowed to only Read and Edit File 1. Patrick Owns File 2 and he can Read, Update as well as Delete. Josiah can also Update File 2 and can Send it to customers. Mary Owns File 3 and File 4 which she can Read, Update, Delete as well as Send. She can also Read, Edit and Send File 2. Joyce can Delete, Read, Send, Update, and Edit any of the files.**

*   **i. Who is likely to be the Administrator of this Company? Give reasons for your answer** [2 Marks]
    Joyce is likely to be the administrator. He has the most permissions, including the ability to delete, read, send, update, and edit any of the files.
*   **ii. Generate an Access Matrix Model from the organization above.** [4 Marks]

| User | File 1 | File 2 | File 3 | File 4 |
| :--- | :--- | :--- | :--- | :--- |
| **Joyce** | Owns, Delete, Edit, Read | Delete, Read, Send, Update, Edit | Delete, Read, Send, Update, Edit | Delete, Read, Send, Update, Edit |
| **Patrick**| Send | Owns, Read, Update, Delete | | |
| **Josiah** | | Update, Send | | |
| **Mary** | Read, Edit | Read, Edit, Send | Owns, Read, Update, Delete, Send | Owns, Read, Update, Delete, Send |

*   **iii. Generate an Access Control List (ACL)** [6 Marks]

**File 1:**
*   Joyce: Owns, Delete, Edit, Read
*   Patrick: Send
*   Mary: Read, Edit

**File 2:**
*   Patrick: Owns, Read, Update, Delete
*   Josiah: Update, Send
*   Mary: Read, Edit, Send
*   Joyce: Delete, Read, Send, Update, Edit

**File 3:**
*   Mary: Owns, Read, Update, Delete, Send
*   Joyce: Delete, Read, Send, Update, Edit

**File 4:**
*   Mary: Owns, Read, Update, Delete, Send
*   Joyce: Delete, Read, Send, Update, Edit

### Question 2

**Nkumba University utilizes various systems to support its academic and administrative functions. These systems include:**
*   **Academic Information Management System (AIMS)**
*   **eLearning platform**
*   **Tradumo**

**a) For each system, what specific tasks or processes does it handle and suggest a Recovery Time Objective (RTO) for each? Briefly explain your reasoning behind the chosen RTOs.?** [5 Marks]

*   **AIMS:** Handles student records, course registration, and grades. RTO: 4 hours. This is a critical system that needs to be restored quickly to minimize disruption to academic operations.
*   **eLearning platform:** Hosts online courses and learning materials. RTO: 24 hours. While important, this system is not as critical as AIMS and can be restored over a longer period of time.
*   **Tradumo:** A language translation platform. RTO: 72 hours. This is a non-critical system that can be restored over a longer period of time.

**b) Can you explain what "system hosting" means and tell me where each of these Nkumba University systems (AIMS, eLearning platform, and Tradumo) are hosted?** [5 Marks]

System hosting is the process of storing and managing a system on a server.

*   **AIMS:** Likely hosted on-premises, on a server that is owned and managed by the university.
*   **eLearning platform:** Likely hosted in the cloud, on a server that is owned and managed by a third-party provider.
*   **Tradumo:** Likely hosted in the cloud, on a server that is owned and managed by a third-party provider.

**c) As a System Administration student, what does it take to host these systems?** [5 Marks]

*   **AIMS:** A physical server, a server operating system, a database, and a web server.
*   **eLearning platform:** A cloud subscription, a virtual server, a server operating system, a database, and a web server.
*   **Tradumo:** A cloud subscription, a virtual server, a server operating system, a database, and a web server.

**d) Outline a disaster recovery strategy for the systems in question.** [5 Marks]

*   **AIMS:** Back up the database to a separate location every night. In the event of a disaster, restore the database to a new server.
*   **eLearning platform:** The cloud provider is responsible for disaster recovery.
*   **Tradumo:** The cloud provider is responsible for disaster recovery.

### Question 3

**a) What is SNMP and what is its primary purpose in network management?** [2 Marks]

SNMP (Simple Network Management Protocol) is a network protocol that is used to manage and monitor network devices. Its primary purpose is to provide a standard way for network devices to communicate with each other.

**b) Discuss the key differences between a server and a workstation in terms of hardware, software, and functionality.** [8 Marks]

| Feature | Server | Workstation |
| :--- | :--- | :--- |
| **Hardware** | Optimized for 24/7 operation, high reliability, and scalability. Often have redundant power supplies, hot-swappable drives, and more RAM and CPU cores. | Optimized for user interaction and performance on specialized tasks like graphic design, video editing, or software development. |
| **Software** | Runs a server operating system (e.g., Windows Server, Linux) and specialized software for providing services (e.g., web server, database server). | Runs a desktop operating system (e.g., Windows 10/11, macOS, Linux desktop) and applications for end-users. |
| **Functionality** | Provides services to multiple clients over a network. | Used by a single user to perform specific tasks. |

**c) What is the World Wide Web and how does it differ from the internet?** [4 Marks]

*   **Internet:** A global network of computers that are connected to each other.
*   **World Wide Web:** A system of interconnected documents and other web resources that are accessed via the Internet.

The World Wide Web is a service that runs on the Internet.

**d) What is a URL (Uniform Resource Locator), and how does it work in web addressing?** [2 Marks]

A URL is a unique address that is used to identify a resource on the Internet. It consists of a protocol (e.g., http, https), a domain name (e.g., www.google.com), and a path to the resource.

**e) Explain the concept of a web application and how it differs from traditional websites.** [4 Marks]

*   **Website:** A collection of static web pages that are linked together.
*   **Web Application:** A dynamic website that allows users to interact with it and perform tasks.

Web applications are more complex than websites and typically require a database to store data.

### Question 4

**a) Define the term Data Backup, then go ahead to explain the three (3) purposes that Backups serve.** [4 Marks]

Data backup is the process of creating a copy of data and storing it in a separate location.

**Purposes of Backups:**

*   **Disaster Recovery:** To restore data in the event of a data loss event, such as a hardware failure, natural disaster, or cyberattack.
*   **Archiving:** To store data for long-term retention.
*   **Compliance:** To meet regulatory requirements for data retention.

**b) With the help of a diagram explain the three pillars of Backup Architecture.** [4 Marks]

```
+-----------------+
|   Source        |
+-----------------+
|   Destination   |
+-----------------+
|   Schedule      |
+-----------------+
```

*   **Source:** The data that is to be backed up.
*   **Destination:** The location where the backup is to be stored.
*   **Schedule:** The frequency at which the backup is to be performed.

**c) Write down and explain the steps taken in Backup Operation** [7 Marks]

1.  **Identify the data to be backed up.**
2.  **Select a backup destination.**
3.  **Choose a backup schedule.**
4.  **Configure the backup software.**
5.  **Run the backup.**
6.  **Verify the backup.**
7.  **Store the backup in a safe location.**

**d) Write down and explain the steps taken in Recovery Operation** [5 Marks]

1.  **Identify the data to be restored.**
2.  **Locate the backup media.**
3.  **Restore the data to the original location or to an alternate location.**
4.  **Verify that the data has been restored correctly.**

### Question 5

**a) Define the term disaster and explain the three categories of disasters in the IT System.** [4 Marks]

A disaster is an event that causes a significant disruption to business operations.

**Categories of Disasters:**

*   **Natural Disasters:** Fires, floods, earthquakes, etc.
*   **Man-made Disasters:** Power outages, terrorist attacks, etc.
*   **Technical Disasters:** Hardware failures, software bugs, etc.

**b) Organizations deal with disaster recovery by address three major factors, write and explain these factors.** [4 Marks]

*   **People:** The people who are responsible for implementing the disaster recovery plan.
*   **Processes:** The steps that need to be taken to restore IT infrastructure.
*   **Technology:** The hardware and software that is needed to restore IT infrastructure.

**c) Explain these two concepts and how they relate to disaster recovery.** [4 Marks]

*   **i. Recovery Point Objective (RPO):** The maximum amount of data that can be lost in a disaster.
*   **ii. Recovery Time Objective (RTO):** The maximum amount of time that it can take to restore IT infrastructure after a disaster.

**d) Compare the two concepts Recovery Point Objective (RPO) and Recovery Time Objective (RTO) using the criteria i) Focus on, ii) Depends on, iii) Describes, iv) Consideration.** [4 Marks]

| Criteria | RPO | RTO |
| :--- | :--- | :--- |
| **Focus on** | Data loss | Time to recover |
| **Depends on** | Backup frequency | Restoration process |
| **Describes** | How much data you can afford to lose | How quickly you need to be back up and running |
| **Consideration** | Business impact of data loss | Business impact of downtime |

**e) Explain what a disaster recovery plan is and list three issues you consider in a disaster recovery plan.** [4 Marks]

A disaster recovery plan is a document that outlines the steps that need to be taken to restore IT infrastructure after a disaster.

**Issues to Consider:**

*   **Business Impact Analysis:** To identify the critical business processes and the impact of a disaster on those processes.
*   **Risk Assessment:** To identify the potential threats to IT infrastructure and the likelihood of those threats occurring.
*   **Recovery Strategy:** To determine the best way to restore IT infrastructure.

### Question 6

**a) Using a well-labeled diagram, illustrate the logical architecture of Active Directory. In your explanation, clearly describe and demonstrate the following components:** [10 Marks]

1.  **Object:** A user, group, computer, or other resource in Active Directory.
2.  **Domain:** A logical grouping of objects in Active Directory.
3.  **Organization Unit (OU):** A container that is used to organize objects in a domain.
4.  **Tree:** A hierarchical arrangement of domains in Active Directory.
5.  **Forest:** A collection of one or more trees in Active Directory.

```
+-----------------+
|     Forest      |
+-----------------+
|      Tree       |
+-----------------+
|     Domain      |
+-----------------+
|       OU        |
+-----------------+
|     Object      |
+-----------------+
```

**b) Give five (5) reasons why we should use Active Directory Services.** [5 Marks]

*   **Centralized Management:** Provides a central location for managing users, computers, and other resources.
*   **Improved Security:** Provides a single point of authentication and authorization.
*   **Simplified Administration:** Simplifies the process of managing a large number of users and computers.
*   **Increased Scalability:** Can be scaled to support a large number of users and computers.
*   **Improved Reliability:** Provides a fault-tolerant and redundant directory service.

**c) Write down five (3) areas where Active Directory Services can be used** [3 Marks]

*   **User authentication and authorization.**
*   **Group Policy management.**
*   **Software deployment.**

**d) Describe the process of joining a computer to an Active Directory domain.** [2 Marks]

1.  **Open the System Properties dialog box.**
2.  **Click the Computer Name tab.**
3.  **Click the Change button.**
4.  **In the Computer Name/Domain Changes dialog box, select the Domain option and enter the name of the domain.**
5.  **Click OK.**
6.  **Enter the username and password of an account that has permission to join the computer to the domain.**
7.  **Click OK.**
8.  **Restart the computer.**
