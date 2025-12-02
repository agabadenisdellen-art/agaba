# System Administration Guide

## Part 1: Multiple Choice Questions

**1. What is the primary purpose of a workstation?**
   a) To provide network services to multiple clients.
   b) To facilitate specialized tasks for individual users.
   c) To manage and distribute resources in a data center.
   d) To support high-speed data transfers within a network.
   **Answer: b) To facilitate specialized tasks for individual users.**
   **Explanation:** A workstation is a high-performance computer designed for a single user to perform resource-intensive tasks such as graphic design, video editing, or software development. Unlike servers, which are designed to serve multiple clients, workstations are optimized for individual productivity.

**2. What is Active Directory?**
   a) A database management system
   b) A file sharing protocol
   c) A directory service
   d) A programming language.
   **Answer: c) A directory service**
   **Explanation:** Active Directory is a directory service developed by Microsoft for Windows domain networks. It is a centralized and standardized system that automates network management of user data, security, and distributed resources.

**3. What is the primary function of Domain Name System (DNS)?**
   a) Transferring files between computers
   b) Resolving domain names to IP addresses
   c) Sending and receiving emails
   d) Authenticating users on a network
   **Answer: b) Resolving domain names to IP addresses**
   **Explanation:** DNS acts as the phonebook of the internet, translating human-readable domain names (like www.google.com) into machine-readable IP addresses (like 172.217.168.68). This allows users to access websites without having to memorize complex numerical addresses.

**4. Which of the following is an example of a strong password?**
   a) "password123"
   b) "abc123"
   c) "P@ssw0rd!"
   d) "12345678"
   **Answer: c) "P@ssw0rd!"**
   **Explanation:** A strong password typically includes a mix of uppercase and lowercase letters, numbers, and symbols. "P@ssw0rd!" is the strongest option because it uses a combination of these elements, making it more difficult to guess or crack.

**5. What is the primary goal of disaster recovery?**
   a) Preventing disasters from occurring
   b) Minimizing the impact of disasters on business operations
   c) Identifying the causes of disasters
   d) Restoring damaged infrastructure after a disaster
   **Answer: b) Minimizing the impact of disasters on business operations**
   **Explanation:** While disaster recovery does involve restoring infrastructure, its primary goal is to minimize the downtime and data loss that can disrupt business operations. It is a holistic approach to ensure business continuity in the face of a disaster.

**6. What is the highest level of the Active Directory hierarchy?**
   a) Forest
   b) Domain
   c) Organizational Unit (OU)
   d) Site
   **Answer: a) Forest**
   **Explanation:** In the Active Directory hierarchy, the forest is the highest-level container. A forest is a collection of one or more domains that share a common global catalog, directory schema, logical structure, and directory configuration.

**7. Which mode is used in FTP (File Transfer Protocol) to establish a data connection?**
   a) Active mode
   b) Passive mode
   c) Secure mode
   d) Exclusive mode
   **Answer: a) Active mode & b) Passive mode**
   **Explanation:** FTP can use either active or passive mode to establish a data connection. In active mode, the client opens a port and listens for the server to connect to it. In passive mode, the server opens a port and the client connects to it. Both are valid modes for establishing a data connection.

**8. What is the primary purpose of a server?**
   a) To facilitate specialized tasks for individual users.
   b) To provide network services to multiple clients.
   c) To manage and distribute resources in a data center.
   d) To support high-speed data transfers within a network.
   **Answer: b) To provide network services to multiple clients.**
   **Explanation:** A server is a computer or system that provides resources, data, services, or programs to other computers, known as clients, over a network. This is in contrast to a workstation, which is designed for individual use.

**9. What is the protocol used for transmitting web content over the Internet?**
   a) SMTP
   b) FTP
   c) HTTP
   d) DNS
   **Answer: c) HTTP**
   **Explanation:** The Hypertext Transfer Protocol (HTTP) is the foundation of data communication for the World Wide Web. It is the protocol used to transmit hypermedia documents, such as HTML, and is how web browsers and servers communicate.

**10. What is the function of a web server?**
    a) Translating domain names into IP addresses
    b) Resolving web content from cache
    c) Serving web pages to clients
    d) Managing network devices
    **Answer: c) Serving web pages to clients**
    **Explanation:** A web server's primary function is to store, process, and deliver web pages to clients. When a user requests a webpage, the web server retrieves the requested content and sends it to the user's browser.

**11. What is the purpose of Active Directory Sites in a network?**
    a) To organize objects within a domain
    b) To manage replication between domain controllers
    c) To define administrative boundaries within a forest
    d) To control access to network resources
    **Answer: b) To manage replication between domain controllers**
    **Explanation:** Active Directory sites are used to manage the replication of directory information between domain controllers, especially in networks with multiple physical locations connected by slower network links. This helps to optimize network traffic and improve performance.

**12. What distinguishes workstations from servers?**
    a) Workstations have more powerful processors.
    b) Servers are optimized for reliability and scalability.
    c) Workstations are headless and administered remotely.
    d) Servers require specialized input devices.
    **Answer: b) Servers are optimized for reliability and scalability.**
    **Explanation:** Servers are designed to run 24/7 and handle requests from many clients simultaneously. They are built with redundant components and are highly scalable to accommodate growing demands. Workstations, on the other hand, are optimized for individual user performance.

**13. What should take place in order to restore a server, its files and data after a major system failure?**
    a) Restore from storage media backup
    b) Perform a parallel test
    c) Implement recovery procedures
    d) Perform a check list test.
    **Answer: a) Restore from storage media backup**
    **Explanation:** After a major system failure, the most critical step is to restore the server's data from a backup. This is the foundation of any recovery process and is essential for bringing the system back online.

**14. Which HTTP (Hypertext Transfer Protocol) method is used to retrieve data from a web server?**
    a) GET
    b) POST
    c) PUT
    d) DELETE
    **Answer: a) GET**
    **Explanation:** The GET method is used to request data from a specified resource. It is the most common HTTP method and is used by browsers to retrieve web pages and other content.

**15. What is the purpose of user account management?**
    a) To restrict access to resources
    b) To ensure compliance with security policies
    c) To create backups of user data
    d) To monitor network traffic
    **Answer: a) To restrict access to resources & b) To ensure compliance with security policies**
    **Explanation:** User account management is about controlling who has access to what resources and ensuring that access is granted in accordance with security policies. It is a critical aspect of maintaining a secure and organized IT environment.

**16. Which of the following is an example of a user account management best practice?**
    a) Sharing passwords among team members for convenience
    b) Disabling automatic account lockout after multiple failed login attempts
    c) Regularly reviewing and revoking unnecessary user privileges
    d) Allowing users to choose any password they prefer
    **Answer: c) Regularly reviewing and revoking unnecessary user privileges**
    **Explanation:** The principle of least privilege dictates that users should only have access to the resources they absolutely need to perform their jobs. Regularly reviewing and revoking unnecessary privileges is a key best practice for minimizing security risks.

**17. Why is it important to regularly test data backups?**
    a) To ensure backups are not corrupted or incomplete
    b) To reduce the time required for data backup processes
    c) To verify the security of data backups
    d) To prevent unauthorized access to data backups
    **Answer: a) To ensure backups are not corrupted or incomplete**
    **Explanation:** Regularly testing backups is crucial to verify that the data is being backed up correctly and can be restored in the event of a disaster. This ensures the integrity and reliability of the backup process.

**18. Which transport protocol is commonly used by DNS (Domain Name System)?**
    a) TCP
    b) UDP
    c) HTTP
    d) FTP
    **Answer: b) UDP**
    **Explanation:** DNS primarily uses the User Datagram Protocol (UDP) because it is faster and more efficient for the small, quick requests that are typical of DNS queries. TCP is used for larger transfers, such as zone transfers.

**19. Which of the following best defines data backup?**
    a) The process of permanently deleting data
    b) The process of copying and storing data for safekeeping
    c) The process of encrypting data for secure transmission
    d) The process of compressing data for efficient storage
    **Answer: b) The process of copying and storing data for safekeeping**
    **Explanation:** Data backup is the process of creating a copy of data on a secondary storage medium to protect against data loss. This ensures that data can be recovered in the event of a hardware failure, human error, or other disaster.

**20. Which component is responsible for delivering emails between mail servers?**
    a) SMTP client
    b) SMTP server
    c) POP3 server
    d) IMAP server
    **Answer: b) SMTP server**
    **Explanation:** The Simple Mail Transfer Protocol (SMTP) server is responsible for sending, receiving, and relaying emails between mail servers. It acts as the backbone of the email system, ensuring that messages are routed to their intended recipients.

**21. Which type of backup captures all data and files, regardless of whether they have changed since the last backup?**
    a) Incremental backup
    b) Differential backup
    c) Full backup
    d) Selective backup
    **Answer: c) Full backup**
    **Explanation:** A full backup is a complete copy of all data, regardless of whether it has changed since the last backup. It is the most comprehensive type of backup but also the most time-consuming and storage-intensive.

**22. What is the purpose of off-site backup?**
    a) To keep data backups in a secure location away from the primary site
    b) To ensure immediate access to data backups in case of hardware failure
    c) To create redundant copies of data backups for added protection
    d) To synchronize data backups with multiple servers simultaneously
    **Answer: a) To keep data backups in a secure location away from the primary site**
    **Explanation:** Off-site backup involves storing a copy of data at a remote location to protect against localized disasters such as fires, floods, or theft. This ensures that the data is safe even if the primary site is completely destroyed.

**23. What is the difference between authentication and authorization?**
    a) Authentication verifies user identity, while authorization determines resource access rights.
    b) Authentication grants access to resources, while authorization verifies user credentials.
    c) Authentication ensures data confidentiality, while authorization ensures data integrity.
    d) Authentication prevents unauthorized access, while authorization protects against malware.
    **Answer: a) Authentication verifies user identity, while authorization determines resource access rights.**
    **Explanation:** Authentication is the process of verifying who a user is, while authorization is the process of determining what that user is allowed to do. For example, logging in to a system is authentication, while having permission to access a specific file is authorization.

**24. You are the network administrator for your company. Recently, one of your users in the accounting department has reported that they were unsure whether a banking website was legitimate or not. You want to configure a utility that will verify whether a website is known to be fraudulent. Which utility should you configure?**
    a) Pop – up Blocker
    b) RSS Reader
    c) Phishing Filter
    d) Add – on Manager
    **Answer: c) Phishing Filter**
    **Explanation:** A phishing filter is a security feature that is designed to detect and block phishing websites, which are fraudulent websites that are designed to trick users into revealing sensitive information. This is the most appropriate utility to address the user's concern.

## Part 2: Detailed Questions and Answers

### Topic 1: System Administration Fundamentals

1.  **What is system administration and what do systems administrators do?**
    **System Administration** is the field of work in which someone manages one or more systems, be they computers, servers, or entire networks. A **systems administrator**, or **sysadmin**, is a person who is responsible for the upkeep, configuration, and reliable operation of computer systems; especially multi-user computers, such as servers.

    **What Systems Administrators Do:**
    *   **User and Group Management:** Creating, deleting, and managing user accounts and groups, and assigning permissions.
    *   **System Monitoring:** Monitoring system performance, and troubleshooting issues.
    *   **Backup and Recovery:** Ensuring that data is backed up regularly and can be restored in the event of a disaster.
    *   **Security:** Implementing and maintaining security measures to protect the system from unauthorized access.
    *   **Software Installation and Maintenance:** Installing, configuring, and updating software.
    *   **Hardware Maintenance:** Troubleshooting and resolving hardware issues.
    *   **Network Management:** Configuring and maintaining the network infrastructure.
    *   **Automation:** Writing scripts to automate repetitive tasks.
    *   **Documentation:** Creating and maintaining documentation for the system.
    *   **Disaster Recovery Planning:** Developing and testing disaster recovery plans.

2.  **With the help of a well labeled diagram define the term system in the context of system administration.**
    In the context of system administration, a **system** can be defined as a collection of interconnected components that work together to perform a specific function. This can include hardware, software, networks, and users.

    ```
         +-----------------+
         |      Users      |
         +-----------------+
                 |
                 v
    +-------------------------+
    |        Software         |
    | (Applications, OS)      |
    +-------------------------+
                 |
                 v
    +-------------------------+
    |        Hardware         |
    | (CPU, Memory, Storage)  |
    +-------------------------+
                 |
                 v
    +-------------------------+
    |         Network         |
    | (Routers, Switches)     |
    +-------------------------+
    ```
    *   **Users:** The individuals who interact with the system.
    *   **Software:** The programs and operating systems that run on the hardware.
    *   **Hardware:** The physical components of the system, such as the CPU, memory, and storage.
    *   **Network:** The infrastructure that connects the system to other systems.

3.  **Write down and explain six principles of System administration.**
    1.  **Automation:** Automate repetitive tasks to save time and reduce the risk of human error.
    2.  **Documentation:** Document everything, including system configurations, procedures, and troubleshooting steps.
    3.  **Simplicity:** Keep systems as simple as possible to make them easier to manage and troubleshoot.
    4.  **Security:** Implement and maintain security measures to protect the system from unauthorized access.
    5.  **Backup and Recovery:** Ensure that data is backed up regularly and can be restored in the event of a disaster.
    6.  **Monitoring:** Monitor system performance and troubleshoot issues before they become critical.

4.  **Write down and explain the qualities of a Successful System administrator.**
    1.  **Problem-Solving Skills:** The ability to troubleshoot and resolve complex technical issues.
    2.  **Attention to Detail:** The ability to work carefully and accurately, with a high degree of precision.
    3.  **Communication Skills:** The ability to communicate effectively with both technical and non-technical users.
    4.  **Time Management Skills:** The ability to prioritize tasks and manage time effectively.
    5.  **Adaptability:** The ability to learn and adapt to new technologies and changing environments.

5.  **Performance of a system is affected by latency and throughput define each of these and explain how they affect the performance.**
    *   **Latency:** The time it takes for a single piece of data to travel from one point to another. High latency can make a system feel slow and unresponsive.
    *   **Throughput:** The amount of data that can be transferred from one point to another in a given amount of time. Low throughput can limit the overall performance of a system, especially for tasks that involve transferring large amounts of data.

    **How they affect performance:**
    *   High latency can make a system feel slow, even if the throughput is high. For example, a website might take a long time to load, even if the internet connection is fast.
    *   Low throughput can make a system feel slow, even if the latency is low. For example, a file transfer might take a long time, even if the network connection is responsive.

### Topic 2: Workstations vs. Servers

1.  **Discuss the key differences between a server and a workstation in terms of hardware, software, and functionality.**

| Feature | Server | Workstation |
| :--- | :--- | :--- |
| **Hardware** | Optimized for reliability and scalability, with redundant components and support for large amounts of memory and storage. | Optimized for performance, with high-end processors, graphics cards, and fast storage. |
| **Software** | Runs a server operating system, such as Windows Server or Linux, and is designed to run 24/7. | Runs a desktop operating system, such as Windows or macOS, and is designed for interactive use. |
| **Functionality**| Provides network services to multiple clients, such as file sharing, web hosting, and email. | Facilitates specialized tasks for individual users, such as graphic design, video editing, and software development. |

2.  **With the help of a well labeled diagram explain the concept of workstation management.**
    **Workstation management** is the process of managing and maintaining a fleet of workstations to ensure that they are secure, up-to-date, and running efficiently.

    ```
    +------------------------+
    |  Centralized          |
    |  Management           |
    |  Server               |
    +------------------------+
        |
        v
    +------------------------+      +------------------------+      +------------------------+
    |      Workstation 1     |      |      Workstation 2     |      |      Workstation 3     |
    +------------------------+      +------------------------+      +------------------------+
    ```
    **Key aspects of workstation management:**
    *   **Software Deployment:** Deploying and updating software on all workstations from a central location.
    *   **Patch Management:** Applying security patches and updates to all workstations to protect them from vulnerabilities.
    *   **Security:** Enforcing security policies, such as password requirements and firewall configurations.
    *   **Inventory Management:** Keeping track of all hardware and software assets.
    *   **Remote Assistance:** Providing remote support to users to troubleshoot and resolve issues.

3.  **Explain the concept of server virtualization and its benefits in terms of resource utilization and scalability.**
    **Server virtualization** is the process of creating multiple virtual servers on a single physical server. Each virtual server runs its own operating system and applications, and is completely isolated from the other virtual servers.

    **Benefits:**
    *   **Resource Utilization:** Virtualization allows you to make better use of your hardware resources by running multiple virtual servers on a single physical server.
    *   **Scalability:** Virtualization makes it easy to scale your infrastructure up or down as needed. You can quickly and easily add or remove virtual servers to meet changing demands.
    *   **Cost Savings:** Virtualization can help you save money on hardware, power, and cooling costs.
    *   **Disaster Recovery:** Virtualization makes it easier to recover from a disaster by allowing you to quickly and easily move virtual servers to a new physical server.

4.  **Describe different types of servers, such as file servers, web servers, database servers, and mail servers, and discuss their respective purposes.**
    *   **File Server:** A server that stores and manages files, and provides access to them over a network.
    *   **Web Server:** A server that stores and serves web pages to clients over the internet.
    *   **Database Server:** A server that stores and manages databases, and provides access to them over a network.
    *   **Mail Server:** A server that sends, receives, and stores emails.

5.  **Server operating systems facilitate typical server roles, list any two (2) server roles.**
    1.  **File and Storage Services:** Provides a central location for storing and sharing files.
    2.  **Web Server (IIS):** Allows you to host websites and web applications.

### Topic 3: Operating Systems

1.  **Write down and explain six (6) types of Operating System (OS).**
    1.  **Batch Operating System:** Processes jobs in batches, without any direct interaction with the user.
    2.  **Time-Sharing Operating System:** Allows multiple users to share a single computer, with each user getting a small slice of CPU time.
    3.  **Distributed Operating System:** Manages a group of independent computers and makes them appear to be a single computer.
    4.  **Network Operating System:** Provides network services to multiple clients, such as file sharing and printing.
    5.  **Real-Time Operating System:** Is designed to respond to events in a predictable and timely manner, and is used in applications such as industrial control systems and robotics.
    6.  **Mobile Operating System:** Is designed to run on mobile devices, such as smartphones and tablets.

2.  **Write down and explain six (6) functions of Operating System.**
    1.  **Process Management:** Manages the execution of processes, including scheduling and resource allocation.
    2.  **Memory Management:** Manages the allocation and deallocation of memory to processes.
    3.  **File Management:** Manages the creation, deletion, and manipulation of files and directories.
    4.  **Device Management:** Manages the interaction between the computer and its peripheral devices.
    5.  **Security:** Provides security features to protect the system from unauthorized access.
    6.  **User Interface:** Provides a user interface that allows users to interact with the system.

3.  **Give two (2) differences between Firmware and Operating System.**
    1.  **Location:** Firmware is stored in non-volatile memory, such as ROM, while the operating system is stored on a hard drive or other secondary storage device.
    2.  **Purpose:** Firmware is designed to control the basic functions of a hardware device, while the operating system is designed to provide a platform for running applications.

4.  **Explain the functions of an operating system on a workstation.**
    The functions of an operating system on a workstation are similar to the functions of an operating system on any other computer. However, there are some functions that are particularly important for workstations, such as:
    *   **High-Performance Computing:** Workstations are often used for resource-intensive tasks, such as graphic design and video editing. The operating system must be able to manage these tasks efficiently and provide a high level of performance.
    *   **Graphics and Multimedia:** Workstations are often used for graphics and multimedia applications. The operating system must provide support for high-end graphics cards and other multimedia devices.
    *   **Networking:** Workstations are often connected to a network. The operating system must provide robust networking capabilities, including support for file sharing, printing, and remote access.

### Topic 4: User and Resource Management

1.  **Explain the concept of user account management and its importance in an organization's IT infrastructure.**
    **User account management** is the process of creating, deleting, and managing user accounts and groups, and assigning permissions. It is a critical aspect of maintaining a secure and organized IT environment.

    **Importance:**
    *   **Security:** User account management helps to protect the system from unauthorized access by ensuring that only authorized users have access to the system.
    *   **Compliance:** User account management helps to ensure compliance with security policies and regulations.
    *   **Efficiency:** User account management helps to improve efficiency by making it easy to manage user access to resources.

2.  **Explain the difference between a local user account and a computer account in Active Directory.**
    *   **Local User Account:** A local user account is created on a single computer and can only be used to log in to that computer.
    *   **Computer Account:** A computer account is created in Active Directory and is used to identify a computer on the network. Computer accounts are used to manage computer settings and to control access to network resources.

3.  **Discuss the role of user account permissions and access levels in ensuring security and data integrity.**
    User account permissions and access levels are used to control what users are allowed to do on the system. By assigning appropriate permissions and access levels, you can ensure that users only have access to the resources they need to perform their jobs. This helps to protect the system from unauthorized access and to ensure the integrity of the data.

4.  **Define resource access and discuss its significance in a networked environment.**
    **Resource access** is the ability of a user to access a resource on the network, such as a file, printer, or application. In a networked environment, it is important to control resource access to ensure that only authorized users have access to the resources they need.

5.  **Describe the concept of file permissions and access control lists (ACLs) in controlling resource access.**
    *   **File Permissions:** File permissions are used to control who can read, write, and execute a file.
    *   **Access Control Lists (ACLs):** ACLs are used to specify which users and groups have access to a resource, and what level of access they have.

6.  **What is the difference between a user account and a computer account?**
    *   **User Account:** A user account is used to identify a user on the network.
    *   **Computer Account:** A computer account is used to identify a computer on the network.

7.  **Innovations and Computing Uganda Limited Scenario**
    *   **i. Who is likely to be the Administrator of this Company? Give reasons for your answer**
        Joyce is likely the administrator. The reason is that Joyce has the ability to "Delete, Read, Send, Update, and Edit any of the files," which are the most extensive permissions and indicate a high level of trust and responsibility.
    *   **ii. Generate an Access Matrix Model from the organization above.**

| User | File 1 | File 2 | File 3 | File 4 |
| :--- | :--- | :--- | :--- | :--- |
| **Joyce** | Owns, Delete, Edit, Read | Delete, Edit, Read, Send, Update | Delete, Edit, Read, Send, Update | Delete, Edit, Read, Send, Update |
| **Patrick** | Send | Owns, Read, Update, Delete | - | - |
| **Josiah** | - | Update, Send | - | - |
| **Mary** | Read, Edit | Read, Edit, Send | Owns, Read, Update, Delete, Send | Owns, Read, Update, Delete, Send |

    *   **iii. Generate an Access Control List (ACL)**

        **File 1:**
        *   Joyce: Owns, Delete, Edit, Read
        *   Patrick: Send
        *   Mary: Read, Edit

        **File 2:**
        *   Joyce: Delete, Edit, Read, Send, Update
        *   Patrick: Owns, Read, Update, Delete
        *   Josiah: Update, Send
        *   Mary: Read, Edit, Send

        **File 3:**
        *   Joyce: Delete, Edit, Read, Send, Update
        *   Mary: Owns, Read, Update, Delete, Send

        **File 4:**
        *   Joyce: Delete, Edit, Read, Send, Update
        *   Mary: Owns, Read, Update, Delete, Send

### Topic 5: Network Services and Protocols

1.  **Write down and explain any four (4) common network services.**
    1.  **DNS (Domain Name System):** Translates human-readable domain names into machine-readable IP addresses.
    2.  **DHCP (Dynamic Host Configuration Protocol):** Automatically assigns IP addresses to devices on a network.
    3.  **FTP (File Transfer Protocol):** Is used to transfer files between computers on a network.
    4.  **HTTP (Hypertext Transfer Protocol):** Is used to transmit web content over the internet.

2.  **Write down three (3) Principles for Designing a Reliable Service.**
    1.  **Redundancy:** Use redundant components to ensure that the service can continue to operate even if one component fails.
    2.  **Failover:** Use failover mechanisms to automatically switch to a backup system in the event of a failure.
    3.  **Monitoring:** Monitor the service to detect and resolve issues before they become critical.

3.  **In a Scenario where Alice sends a message to Bob, we have six (6) steps that this message goes through in order to get to its destination, write down the six stages.**
    1.  **Application Layer:** Alice creates the message in an application, such as an email client.
    2.  **Transport Layer:** The message is broken down into smaller packets, and each packet is assigned a sequence number.
    3.  **Network Layer:** The packets are routed through the network to their destination.
    4.  **Data Link Layer:** The packets are transmitted over the physical network medium.
    5.  **Physical Layer:** The packets are converted into electrical signals and transmitted over the network.
    6.  **Bob's Computer:** The process is reversed, and the message is reassembled and delivered to Bob's email client.

4.  **Explain the concept “system service” following the guidelines below.**
    *   **i. Definition:** A system service is a program that runs in the background and provides a specific function to the operating system or to other applications.
    *   **ii. Purpose:** The purpose of a system service is to provide a function that is always available, without requiring any user interaction.
    *   **iii. Components:** A system service typically consists of an executable file, a configuration file, and a set of registry entries.
    *   **iv. Examples:**
        *   **Print Spooler:** Manages print jobs.
        *   **Task Scheduler:** Schedules tasks to run at a specific time.
        *   **Windows Update:** Automatically downloads and installs updates for Windows.

5.  **Network services are programs that provide specific functions to network users. List any 5 most common network services.**
    1.  DNS (Domain Name System)
    2.  DHCP (Dynamic Host Configuration Protocol)
    3.  FTP (File Transfer Protocol)
    4.  HTTP (Hypertext Transfer Protocol)
    5.  SMTP (Simple Mail Transfer Protocol)

6.  **Network security threats are malicious attempts to harm or exploit networks. Write down four (4) most common network security threats.**
    1.  **Malware:** Malicious software that is designed to damage or disable a computer system.
    2.  **Phishing:** A type of social engineering attack that is used to trick users into revealing sensitive information.
    3.  **Denial-of-Service (DoS) Attack:** An attack that is designed to make a computer or network resource unavailable to its intended users.
    4.  **Man-in-the-Middle (MitM) Attack:** An attack in which the attacker secretly relays and possibly alters the communication between two parties who believe they are directly communicating with each other.

7.  **Write down three (3) different types of network security measures?**
    1.  **Firewall:** A network security system that monitors and controls incoming and outgoing network traffic based on predetermined security rules.
    2.  **Intrusion Detection System (IDS):** A device or software application that monitors a network or systems for malicious activity or policy violations.
    3.  **Virtual Private Network (VPN):** A secure connection over a public network, such as the internet.

8.  **Explain the purpose of FTP and how it facilitates file transfer over a network.**
    **FTP (File Transfer Protocol)** is a standard network protocol used for the transfer of computer files between a client and server on a computer network. FTP is built on a client-server model architecture and uses separate control and data connections between the client and the server.

9.  **How does FTP handle authentication and authorization of users?**
    FTP handles authentication by requiring users to provide a username and password to log in to the server. Authorization is handled by assigning permissions to users and groups, which control what they are allowed to do on the server.

10. **Describe the process of resolving a domain name to an IP address using DNS.**
    1.  The user enters a domain name into their web browser.
    2.  The web browser sends a request to a DNS resolver.
    3.  The DNS resolver sends a request to the root DNS server.
    4.  The root DNS server responds with the address of the top-level domain (TLD) DNS server.
    5.  The DNS resolver sends a request to the TLD DNS server.
    6.  The TLD DNS server responds with the address of the authoritative DNS server.
    7.  The DNS resolver sends a request to the authoritative DNS server.
    8.  The authoritative DNS server responds with the IP address of the domain name.
    9.  The DNS resolver sends the IP address to the web browser.
    10. The web browser sends a request to the IP address, and the website is loaded.

11. **Discuss the difference between SMTP and POP3. How do these protocols work together to facilitate email sending and retrieval?**
    *   **SMTP (Simple Mail Transfer Protocol):** Is used to send emails from a client to a server, and from a server to another server.
    *   **POP3 (Post Office Protocol 3):** Is used to retrieve emails from a server to a client.

    **How they work together:**
    When you send an email, your email client uses SMTP to send the email to your mail server. Your mail server then uses SMTP to send the email to the recipient's mail server. When the recipient checks their email, their email client uses POP3 to retrieve the email from their mail server.

12. **What is SNMP and what is its primary purpose in network management?**
    **SNMP (Simple Network Management Protocol)** is a standard network protocol used for managing and monitoring network devices. Its primary purpose is to collect information from network devices, such as routers, switches, and servers, and to make that information available to a network management system.

13. **Explain the purpose and usage of the following HTTP methods: GET, POST, PUT, DELETE.**
    *   **GET:** Is used to retrieve data from a web server.
    *   **POST:** Is used to submit data to a web server.
    *   **PUT:** Is used to update data on a web server.
    *   **DELETE:** Is used to delete data from a web server.

### Topic 6: Web Concepts

1.  **What is the World Wide Web and how does it differ from the internet?**
    *   **The Internet:** A global network of computers that are connected to each other.
    *   **The World Wide Web:** A system of interconnected documents and other web resources that are accessed via the internet.

2.  **What is a URL (Uniform Resource Locator), and how does it work in web addressing?**
    A **URL (Uniform Resource Locator)** is a unique address that is used to identify a resource on the internet, such as a web page, image, or video. A URL consists of several parts, including the protocol, domain name, and path.

3.  **Explain the concept of a web application and how it differs from traditional websites.**
    *   **Traditional Website:** A collection of static web pages that are linked together.
    *   **Web Application:** A dynamic website that allows users to interact with it and perform tasks, such as shopping online or booking a flight.

### Topic 7: Data Backup

1.  **Define data backup and explain its significance in ensuring data integrity and availability.**
    **Data backup** is the process of creating a copy of data on a secondary storage medium to protect against data loss. It is significant because it ensures that data can be recovered in the event of a hardware failure, human error, or other disaster.

2.  **Discuss the different types of data backups, such as full backup, incremental backup, and differential backup, and explain when each type is appropriate.**
    *   **Full Backup:** A complete copy of all data. Appropriate for the initial backup, and for periodic backups.
    *   **Incremental Backup:** A backup of all data that has changed since the last backup. Appropriate for daily backups.
    *   **Differential Backup:** A backup of all data that has changed since the last full backup. Appropriate for daily backups.

3.  **Describe the steps involved in restoring data from a backup and discuss the challenges and considerations in the restoration process.**
    **Steps:**
    1.  Identify the data that needs to be restored.
    2.  Locate the backup that contains the data.
    3.  Restore the data to its original location.
    4.  Verify that the data has been restored correctly.

    **Challenges and Considerations:**
    *   **Time:** The restoration process can be time-consuming, especially for large amounts of data.
    *   **Complexity:** The restoration process can be complex, especially for complex systems.
    *   **Data Integrity:** It is important to ensure that the data is restored correctly and that its integrity is maintained.

4.  **Define the term Data Backup, then go ahead to explain the three (3) purposes that Backups serve.**
    **Data Backup** is the process of copying and storing data for safekeeping.
    **Purposes:**
    1.  **Disaster Recovery:** To recover data in the event of a disaster.
    2.  **Archiving:** To store data for long-term retention.
    3.  **Compliance:** To comply with legal and regulatory requirements.

5.  **With the help of a diagram explain the three pillars of Backup Architecture.**
    ```
    +------------------------+      +------------------------+      +------------------------+
    |        Source        |----->|         Target         |----->|         Storage        |
    +------------------------+      +------------------------+      +------------------------+
    ```
    *   **Source:** The data that is being backed up.
    *   **Target:** The location where the backup is being stored.
    *   **Storage:** The media on which the backup is being stored.

6.  **Write down and explain any five (5) types of backups.**
    1.  **Full Backup:** A complete copy of all data.
    2.  **Incremental Backup:** A backup of all data that has changed since the last backup.
    3.  **Differential Backup:** A backup of all data that has changed since the last full backup.
    4.  **Mirror Backup:** A real-time copy of the source data.
    5.  **Cloud Backup:** A backup of data to a remote cloud server.

7.  **Write down and explain the steps taken in Backup Operation.**
    1.  **Identify the data to be backed up.**
    2.  **Select a backup type.**
    3.  **Select a backup destination.**
    4.  **Schedule the backup.**
    5.  **Run the backup.**
    6.  **Verify the backup.**

8.  **Write down and explain the steps taken in Recovery Operation.**
    1.  **Identify the data to be recovered.**
    2.  **Locate the backup that contains the data.**
    3.  **Restore the data to its original location.**
    4.  **Verify that the data has been restored correctly.**

9.  **What is the difference between backup and disaster recovery?**
    *   **Backup:** The process of copying and storing data for safekeeping.
    *   **Disaster Recovery:** The process of restoring data and systems after a disaster.

10. **What is the role of off-site backup in data protection?**
    Off-site backup is a critical component of data protection, as it ensures that data is safe even if the primary site is completely destroyed.

11. **What is the difference between local backup and cloud backup?**
    *   **Local Backup:** A backup of data to a local storage device, such as a hard drive or tape.
    *   **Cloud Backup:** A backup of data to a remote cloud server.

### Topic 8: Disaster Recovery

1.  **Describe the concept of disaster recovery planning and explain how data backups play a crucial role in the overall recovery strategy.**
    **Disaster recovery planning** is the process of creating a plan to restore data and systems after a disaster. Data backups are a crucial part of disaster recovery planning, as they provide the data that is needed to restore the systems.

2.  **Define the term disaster and explain the three categories of disasters in the IT System.**
    A **disaster** is an event that causes significant disruption to a business's operations.
    **Categories:**
    1.  **Natural Disasters:** Such as floods, earthquakes, and hurricanes.
    2.  **Human-Made Disasters:** Such as fires, power outages, and terrorist attacks.
    3.  **Technical Disasters:** Such as hardware failures, software failures, and cyberattacks.

3.  **Organizations deal with disaster recovery by address three major factors, write and explain these factors.**
    1.  **Prevention:** Taking steps to prevent disasters from occurring.
    2.  **Preparedness:** Being prepared to respond to a disaster if it does occur.
    3.  **Recovery:** Having a plan to recover from a disaster.

4.  **Explain these two concepts and how they relate to disaster recovery.**
    *   **i. Recovery Point Objective (RPO):** The maximum amount of data that a business can afford to lose.
    *   **ii. Recovery Time Objective (RTO):** The maximum amount of time that a business can afford to be without its systems.

5.  **Compare the two concepts Recovery Point Objective(RPO) and Recovery Time Objective(RTO) using the criteria i) Focus on, ii) Depends on, iii) Describes, iv) Consideration.**

| Criteria | RPO | RTO |
| :--- | :--- | :--- |
| **Focus on** | Data loss | Time to recover |
| **Depends on** | Backup frequency | Recovery process |
| **Describes** | The age of the data that must be recovered | The time it takes to recover |
| **Consideration** | How much data can be lost | How long can the business be down |

6.  **Explain what a disaster recovery plan is and list three issues you consider in a disaster recovery plan.**
    A **disaster recovery plan** is a documented process or set of procedures to recover and protect a business IT infrastructure in the event of a disaster.
    **Issues to consider:**
    1.  **RPO and RTO:** The RPO and RTO will determine the type of backup and recovery solution that is needed.
    2.  **Budget:** The budget will determine the resources that are available for disaster recovery.
    3.  **Testing:** It is important to test the disaster recovery plan regularly to ensure that it is effective.

7.  **Nkumba University Scenario**
    *   **a) For each system, what specific tasks or processes does it handle and suggest a Recovery Time Objective (RTO) for each? Briefly explain your reasoning behind the chosen RTOs.?**
        *   **Academic Information Management System (AIMS):** Handles student records, grades, and course registration. RTO: 4 hours. AIMS is a critical system that is needed for the university to function, so it should be restored as quickly as possible.
        *   **eLearning platform:** Handles online courses and learning materials. RTO: 24 hours. The eLearning platform is important, but it is not as critical as AIMS, so it can be restored more slowly.
        *   **Tradumo:** A specific application, the criticality of which would determine its RTO. Assuming it's a non-critical application, an RTO of 48 hours would be acceptable.
    *   **b) Can you explain what "system hosting" means and tell me where each of these Nkumba University systems (AIMS, eLearning platform, and Tradumo) are hosted?**
        **System hosting** is the process of storing and managing a system on a server.
        *   **AIMS:** Is likely hosted on-premises, on a server that is owned and managed by the university.
        *   **eLearning platform:** Is likely hosted in the cloud, on a server that is owned and managed by a third-party provider.
        *   **Tradumo:** Could be hosted on-premises or in the cloud.
    *   **c) As a System Administration student, what does it take to host these systems?**
        *   **Hardware:** A server with sufficient resources to run the system.
        *   **Software:** The operating system and any other software that is needed to run the system.
        *   **Network:** A network connection to the internet.
        *   **Expertise:** The expertise to install, configure, and manage the system.
    *   **d) Outline a disaster recovery strategy for the systems in question.**
        1.  **Backup:** Back up all data to a remote location.
        2.  **Failover:** Have a failover site that can be used to run the systems in the event of a disaster.
        3.  **Testing:** Test the disaster recovery plan regularly.

### Topic 9: Active Directory

1.  **What is Active Directory (AD) and what is its primary purpose in a Windows network environment?**
    **Active Directory (AD)** is a directory service that is used to manage and organize network resources in a Windows network environment. Its primary purpose is to provide a central location for storing and managing information about users, computers, and other network resources.

2.  **How does Active Directory handle authentication and authorization of users and resources?**
    *   **Authentication:** Active Directory uses Kerberos to authenticate users.
    *   **Authorization:** Active Directory uses access control lists (ACLs) to authorize users to access resources.

3.  **Describe the process of joining a computer to an Active Directory domain.**
    1.  Log in to the computer as an administrator.
    2.  Open the System Properties dialog box.
    3.  Click the Computer Name tab.
    4.  Click the Change button.
    5.  Select the Domain option button.
    6.  Enter the name of the domain.
    7.  Click the OK button.
    8.  Enter the username and password of an account that has permission to join the computer to the domain.
    9.  Click the OK button.
    10. Restart the computer.

4.  **Explain the concept of Organizational Units (OUs) in Active Directory and their role in organizing and managing objects.**
    **Organizational Units (OUs)** are containers that are used to organize and manage objects in Active Directory, such as users, computers, and groups. OUs can be used to delegate administrative tasks and to apply group policies.

5.  **Define the term Active Directory, and proceed by listing any four Active Directory objects.**
    **Active Directory** is a directory service that is used to manage and organize network resources in a Windows network environment.
    **Objects:**
    1.  **User:** A person who has access to the network.
    2.  **Computer:** A computer that is connected to the network.
    3.  **Group:** A collection of users or computers.
    4.  **Printer:** A printer that is connected to the network.

6.  **A domain has four (4) components write down and explain these components.**
    1.  **Domain Controllers:** Servers that store a copy of the Active Directory database.
    2.  **Global Catalog Servers:** Servers that store a partial copy of the Active Directory database for all domains in the forest.
    3.  **DNS Servers:** Servers that resolve domain names to IP addresses.
    4.  **DHCP Servers:** Servers that automatically assign IP addresses to devices on the network.

7.  **Give five (5) reasons why we should use Active Directory Services.**
    1.  **Centralized Management:** Provides a central location for managing network resources.
    2.  **Improved Security:** Provides a secure way to authenticate and authorize users.
    3.  **Scalability:** Can be scaled to support large and complex networks.
    4.  **Flexibility:** Can be customized to meet the specific needs of an organization.
    5.  **Interoperability:** Can be integrated with other systems and applications.

8.  **Write down five (5) areas where Active Directory Services can be used.**
    1.  **User Management:** To create, delete, and manage user accounts.
    2.  **Computer Management:** To manage computer settings and to control access to network resources.
    3.  **Group Policy:** To apply security policies and to deploy software.
    4.  **Authentication:** To authenticate users to the network.
    5.  **Authorization:** To authorize users to access resources.

9.  **Using a well-labeled diagram, illustrate the logical architecture of Active Directory. In your explanation, clearly describe and demonstrate the following components: Object, Domain, Organization Unit, Tree, Forest.**
    ```
                      +-----------------+
                      |     Forest      |
                      +-----------------+
                             |
            +----------------+----------------+
            |                                 |
    +-------+-------+                 +-------+-------+
    |      Tree     |                 |      Tree     |
    +-------+-------+                 +-------+-------+
            |                                 |
    +-------+-------+                 +-------+-------+
    |     Domain    |                 |     Domain    |
    +-------+-------+                 +-------+-------+
            |
    +-------+-------+
    |      OU       |
    +-------+-------+
            |
    +-------+-------+
    |    Object     |
    +-------+-------+
    ```
    *   **Object:** A user, computer, group, or other resource in Active Directory.
    *   **Organizational Unit (OU):** A container that is used to organize and manage objects.
    *   **Domain:** A logical grouping of objects in Active Directory.
    *   **Tree:** A collection of one or more domains that share a contiguous namespace.
    *   **Forest:** A collection of one or more trees that do not share a contiguous namespace.

### Topic 10: Practical Scripting and Commands

1.  **What is shell scripting?**
    **Shell scripting** is the process of writing scripts that are executed by a shell, which is a command-line interpreter. Shell scripts can be used to automate tasks, to create custom commands, and to extend the functionality of the shell.

2.  **Write down four examples of how shell scripting can be used.**
    1.  To automate the process of backing up files.
    2.  To create a custom command that performs a series of tasks.
    3.  To extend the functionality of the shell by adding new features.
    4.  To create a simple game or utility.

3.  **Write down a SHUTDOWN command to schedule a system shutdown to occur in 5 minutes, displaying the message "System will shut down in 5 minutes." to the user.**
    ```
    shutdown /s /t 300 /c "System will shut down in 5 minutes."
    ```

4.  **You have a folder named "OldFiles" containing several files. Write a CMD command that moves all files from the "OldFiles" folder to a new folder named "ProcessedFiles" located in the same directory. The script should create "ProcessedFiles" if it doesn't already exist.**
    ```
    if not exist ProcessedFiles mkdir ProcessedFiles
    move OldFiles\* ProcessedFiles
    ```

5.  **Write a CMD script that Creates a new folder named "Backup" in the current directory and Copies all files with the .txt extension from the current directory into the "Backup" folder.**
    ```
    mkdir Backup
    copy *.txt Backup
    ```
