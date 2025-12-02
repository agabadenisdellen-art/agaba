# System Administration Answers

## SECTION A

### a) What is system administration and what do systems administrators do? [4 Marks]

**Introduction**

System administration is a critical field within information technology (IT) that involves maintaining and operating computer systems and networks. System administrators are the professionals responsible for ensuring that these systems run efficiently and reliably.

**Definition**

**System Administration** is the management of the hardware and software systems that make up a computer network. This includes installing, configuring, maintaining, and troubleshooting servers, workstations, and other network devices.

**What System Administrators Do**

System administrators perform a wide range of tasks to keep computer systems running smoothly. Their responsibilities can be broadly categorized as follows:

1.  **System Installation and Configuration:**
    *   Installing and configuring operating systems (e.g., Windows, Linux, macOS).
    *   Setting up server hardware and software.
    *   Configuring network services (e.g., DNS, DHCP, email).

2.  **System Maintenance and Monitoring:**
    *   Applying security patches and updates to operating systems and applications.
    *   Monitoring system performance and troubleshooting issues.
    *   Performing regular backups and ensuring data integrity.

3.  **User Management:**
    *   Creating, deleting, and managing user accounts.
    *   Assigning permissions and access rights to users.
    *   Providing technical support to users.

4.  **Security:**
    *   Implementing security policies and procedures.
    *   Monitoring for security breaches and responding to incidents.
    *   Managing firewalls and other security devices.

5.  **Disaster Recovery:**
    *   Developing and implementing disaster recovery plans.
    *   Testing disaster recovery procedures to ensure they are effective.

**Examples of System Administrator Tasks**

*   Installing a new server for a web application.
*   Updating the antivirus software on all workstations.
*   Creating a new user account for a new employee.
*   Troubleshooting a network connectivity issue.
*   Restoring a file from a backup.

### b) With the help of a well labeled diagram define the term system in the context of system administration. [5 Marks]

**Definition**

In the context of system administration, a **system** is a collection of interconnected components that work together to perform a specific function. These components can include hardware, software, and network devices.

**Diagram**

```
      +-----------------+
      |   Application   |
      +-----------------+
              |
      +-----------------+
      | Operating System|
      +-----------------+
              |
      +-----------------+
      |     Hardware    |
      +-----------------+
              |
      +-----------------+
      |     Network     |
      +-----------------+
```

**Explanation of Components**

*   **Hardware:** The physical components of the system, such as the CPU, memory, storage, and input/output devices.
*   **Operating System (OS):** The software that manages the hardware and provides a platform for applications to run. Examples include Windows, Linux, and macOS.
*   **Application:** The software that performs a specific task for the user, such as a word processor, web browser, or database.
*   **Network:** The infrastructure that connects the system to other systems and devices, allowing them to communicate with each other.

**Example**

A web server is a system that consists of the following components:

*   **Hardware:** A physical or virtual server with a CPU, memory, and storage.
*   **Operating System:** A Linux-based operating system, such as Ubuntu or CentOS.
*   **Application:** A web server application, such as Apache or Nginx.
*   **Network:** A network connection that allows users to access the web server over the internet.

### c) Write down a SHUTDOWN command to schedule a system shutdown to occur in 5 minutes, displaying the message "System will shut down in 5 minutes." to the user. [3 Marks]

```
shutdown /s /t 300 /c "System will shut down in 5 minutes."
```

**Explanation of Command**

*   `shutdown`: The command to shut down the system.
*   `/s`: Specifies that the system should be shut down.
*   `/t 300`: Specifies that the shutdown should occur in 300 seconds (5 minutes).
*   `/c "System will shut down in 5 minutes."`: Specifies the message to be displayed to the user.

### d) Write down and explain the qualities of a Successful System administrator. [2 Marks]

A successful system administrator possesses a combination of technical skills and soft skills. Here are some of the most important qualities:

1.  **Problem-Solving Skills:** System administrators are constantly faced with technical challenges. They must be able to think logically and systematically to diagnose and resolve problems.

2.  **Technical Expertise:** A deep understanding of computer hardware, software, and networking is essential. This includes knowledge of operating systems, scripting languages, and security best practices.

3.  **Communication Skills:** System administrators need to be able to communicate effectively with both technical and non-technical users. They must be able to explain complex technical concepts in simple terms.

4.  **Attention to Detail:** A small mistake can have a big impact on a computer system. System administrators must be meticulous and pay close attention to detail to avoid errors.

5.  **Time Management Skills:** System administrators often have to juggle multiple tasks at once. They must be able to prioritize their work and manage their time effectively.

6.  **Patience:** Troubleshooting technical problems can be frustrating. System administrators must be patient and persistent to find a solution.

7.  **Adaptability:** The IT industry is constantly changing. System administrators must be willing to learn new technologies and adapt to new challenges.

### e) You have a folder named "OldFiles" containing several files. Write a CMD command that moves all files from the "OldFiles" folder to a new folder named "ProcessedFiles" located in the same directory. The script should create "ProcessedFiles" if it doesn't already exist. [4 Marks]

```
if not exist "ProcessedFiles" mkdir "ProcessedFiles"
move "OldFiles\\*.*" "ProcessedFiles"
```

**Explanation of Command**

*   `if not exist "ProcessedFiles" mkdir "ProcessedFiles"`: This command checks if the "ProcessedFiles" folder exists. If it does not exist, it creates the folder.
*   `move "OldFiles\\*.*" "ProcessedFiles"`: This command moves all files from the "OldFiles" folder to the "ProcessedFiles" folder.

### f) Write a CMD script that Creates a new folder named "Backup" in the current directory and Copies all files with the .txt extension from the current directory into the "Backup" folder. [4 Marks]

```
mkdir "Backup"
copy "*.txt" "Backup"
```

**Explanation of Command**

*   `mkdir "Backup"`: This command creates a new folder named "Backup" in the current directory.
*   `copy "*.txt" "Backup"`: This command copies all files with the .txt extension from the current directory to the "Backup" folder.

### g) Performance of a system is affected by latency and throughput define each of these and explain how they affect the performance. [2 Marks]

**Definitions**

*   **Latency:** The time it takes for a single piece of data to travel from one point to another. It is often measured in milliseconds (ms).
*   **Throughput:** The amount of data that can be transferred from one point to another in a given amount of time. It is often measured in megabits per second (Mbps) or gigabits per second (Gbps).

**How They Affect Performance**

Latency and throughput are two key metrics that affect the performance of a system.

*   **Latency** is important for applications that require a quick response time, such as online gaming and video conferencing. High latency can cause lag and delays, which can make these applications unusable.
*   **Throughput** is important for applications that transfer large amounts of data, such as streaming video and downloading large files. Low throughput can cause buffering and slow download speeds.

In general, a system with low latency and high throughput will have better performance than a system with high latency and low throughput.

### h) What is the difference between a user account and a computer account? [2 Marks]

| Feature | User Account | Computer Account |
|---|---|---|
| **Purpose** | Used by a person to log on to a computer or network. | Used by a computer to log on to a network. |
| **Authentication** | Authenticated by a user name and password. | Authenticated by a computer name and password. |
| **Permissions** | Granted permissions to access resources on the network. | Granted permissions to access resources on the network. |
| **Example** | A user account for an employee to access their email and files. | A computer account for a workstation to join a domain. |

### i) What is the difference between backup and disaster recovery? [2 Marks]

| Feature | Backup | Disaster Recovery |
|---|---|---|
| **Purpose** | To create a copy of data that can be used to restore the data in case of data loss. | To restore a system to a functional state after a disaster. |
| **Scope** | Focuses on data. | Focuses on the entire system, including data, applications, and infrastructure. |
| **Timeframe** | Can be done on a regular basis, such as daily or weekly. | Is done only after a disaster has occurred. |
| **Example** | Backing up a database to a tape drive. | Restoring a server from a backup after a hardware failure. |

### j) What is the role of off-site backup in data protection? [2 Marks]

Off-site backup is a critical component of a data protection strategy. It involves storing a copy of your data in a separate location from your primary site. This protects your data from disasters that could affect your primary site, such as fires, floods, and earthquakes.

The role of off-site backup in data protection is to:

*   **Provide a secondary copy of your data:** If your primary site is destroyed, you can still recover your data from the off-site backup.
*   **Protect your data from local disasters:** Off-site backups are not affected by local disasters, so they provide a higher level of protection than on-site backups.
*   **Meet compliance requirements:** Many industries have regulations that require organizations to store a copy of their data off-site.

### k) What is the difference between local backup and cloud backup? [2 Marks]

| Feature | Local Backup | Cloud Backup |
|---|---|---|
| **Location** | Data is stored on-site, such as on a local server or external hard drive. | Data is stored off-site, in a data center owned by a cloud provider. |
| **Accessibility** | Data is accessible only from the local network. | Data is accessible from anywhere with an internet connection. |
| **Cost** | Can be less expensive than cloud backup, but requires an initial investment in hardware. | Typically has a lower initial cost, but requires a monthly or annual subscription fee. |
| **Security** | Security is the responsibility of the organization. | Security is the responsibility of the cloud provider. |

### l) What is Active Directory, and what is its primary purpose? [2 Marks]

**Definition**

Active Directory (AD) is a directory service developed by Microsoft for Windows domain networks. It is a central database of all network resources, including users, computers, printers, and files.

**Primary Purpose**

The primary purpose of Active Directory is to provide a centralized and standardized system for managing network resources. It allows administrators to:

*   **Manage user accounts and passwords:** Administrators can create, delete, and manage user accounts from a central location.
*   **Assign permissions to resources:** Administrators can control who has access to which resources on the network.
*   **Deploy software and updates:** Administrators can use Active Directory to deploy software and updates to all computers on the network.
*   **Enforce security policies:** Administrators can use Active Directory to enforce security policies, such as password complexity requirements.

### m) How does Active Directory handle authentication and authorization of users and resources? [2 Marks]

**Authentication**

Authentication is the process of verifying the identity of a user or computer. Active Directory uses the Kerberos protocol for authentication. When a user logs on to a computer, the computer sends a request to the domain controller. The domain controller then verifies the user's credentials and issues a ticket-granting ticket (TGT). The TGT is then used to request tickets for other services on the network.

**Authorization**

Authorization is the process of granting a user or computer permission to access a resource. Active Directory uses access control lists (ACLs) for authorization. An ACL is a list of users and groups that have permission to access a resource. When a user tries to access a resource, the system checks the ACL to see if the user has permission to access the resource.

### n) What is shell scripting? [2 Marks]

Shell scripting is the process of writing a script that is executed by a command-line interpreter, or shell. A shell script is a plain text file that contains a series of commands. When the script is executed, the shell reads the commands and executes them one by one.

Shell scripting is a powerful tool that can be used to automate a wide variety of tasks, such as:

*   **System administration:** Shell scripts can be used to automate tasks such as creating users, installing software, and backing up data.
*   **Software development:** Shell scripts can be used to automate tasks such as compiling code, running tests, and deploying applications.
*   **Data analysis:** Shell scripts can be used to automate tasks such as cleaning data, transforming data, and generating reports.

### o) Write down four examples of how shell scripting can be used. [2 Marks]

1.  **Automate backups:** A shell script can be used to automate the process of backing up a database or a file system.
2.  **Create new users:** A shell script can be used to automate the process of creating new user accounts.
3.  **Install software:** A shell script can be used to automate the process of installing software on a new computer.
4.  **Monitor system performance:** A shell script can be used to monitor system performance and send an alert if a problem is detected.

## SECTION B

### Question 1

#### a) Explain the concept of user account management and its importance in an organization's IT infrastructure. [4 Marks]

**Concept**

User account management is the process of creating, deleting, and managing user accounts on a computer network. It includes tasks such as:

*   Creating new user accounts for new employees.
*   Disabling or deleting user accounts for employees who have left the organization.
*   Resetting passwords for users who have forgotten them.
*   Assigning permissions and access rights to users.

**Importance**

User account management is important for a number of reasons:

*   **Security:** User account management helps to protect the security of an organization's IT infrastructure by ensuring that only authorized users have access to network resources.
*   **Compliance:** Many industries have regulations that require organizations to have a formal user account management process in place.
*   **Efficiency:** User account management can help to improve the efficiency of an organization's IT operations by automating the process of creating and managing user accounts.
*   **Productivity:** User account management can help to improve the productivity of employees by providing them with the access they need to do their jobs.

#### b) Explain the difference between a local user account and a computer account in Active Directory. [4 Marks]

| Feature | Local User Account | Computer Account |
|---|---|---|
| **Scope** | Exists only on the local computer. | Exists in Active Directory and can be used to log on to any computer in the domain. |
| **Authentication** | Authenticated by the local computer. | Authenticated by a domain controller. |
| **Permissions** | Can only be granted permissions to resources on the local computer. | Can be granted permissions to resources on any computer in the domain. |
| **Management** | Managed on the local computer. | Managed in Active Directory. |

#### c) Innovations and Computing Uganda Limited has Four senior workers Joyce, Patrick, Josiah and Mary who possess certain rights (in bold-i.e. Delete, Read, Send, Update, Owns and Edit) over four different special company files (File 1, File 2, File 3, File 4). Joyce Owns File 1 and he is be able to Delete, to Edit, and to Read it. However, he has no rights to send it to customers, it is Patrick who can Send File 1 to customers. Mary is allowed to only Read and Edit File 1. Patrick Owns File 2 and he can Read, Update as well as Delete. Josiah can also Update File 2 and can Send it to customers. Mary Owns File 3 and File 4 which she can Read, Update, Delete as well as Send. She can also Read, Edit and Send File 2. Joyce can Delete, Read, Send, Update, and Edit any of the files.

##### i. Who is likely to be the Administrator of this Company? Give reasons for your answer [2 Marks]

**Answer:** Joyce is likely to be the Administrator of this company.

**Reason:** Joyce has the most permissions of any user. He can Delete, Read, Send, Update, and Edit any of the files. This is a high level of privilege that is typically reserved for an administrator.

##### ii. Generate an Access Matrix Model from the organization above. [4 Marks]

| User | File 1 | File 2 | File 3 | File 4 |
|---|---|---|---|---|
| Joyce | Owns, Delete, Edit, Read | Delete, Read, Send, Update, Edit | Delete, Read, Send, Update, Edit | Delete, Read, Send, Update, Edit |
| Patrick | Send | Owns, Read, Update, Delete | | |
| Josiah | | Update, Send | | |
| Mary | Read, Edit | Read, Edit, Send | Owns, Read, Update, Delete, Send | Owns, Read, Update, Delete, Send |

##### iii. Generate an Access Control List (ACL) [6 Marks]

**File 1**

*   Joyce: Owns, Delete, Edit, Read
*   Patrick: Send
*   Mary: Read, Edit

**File 2**

*   Patrick: Owns, Read, Update, Delete
*   Josiah: Update, Send
*   Mary: Read, Edit, Send
*   Joyce: Delete, Read, Send, Update, Edit

**File 3**

*   Mary: Owns, Read, Update, Delete, Send
*   Joyce: Delete, Read, Send, Update, Edit

**File 4**

*   Mary: Owns, Read, Update, Delete, Send
*   Joyce: Delete, Read, Send, Update, Edit

### Question 2

#### a) For each system, what specific tasks or processes does it handle and suggest a Recovery Time Objective (RTO) for each? Briefly explain your reasoning behind the chosen RTOs.? [5 Marks]

**Academic Information Management System (AIMS)**

*   **Tasks:** Manages student records, grades, and course registration.
*   **RTO:** 4 hours.
*   **Reasoning:** AIMS is a critical system that is used by students, faculty, and staff on a daily basis. A long outage would have a significant impact on the university's operations.

**eLearning platform**

*   **Tasks:** Hosts online courses and learning materials.
*   **RTO:** 24 hours.
*   **Reasoning:** The eLearning platform is an important system for students, but it is not as critical as AIMS. A 24-hour outage would be an inconvenience, but it would not have a major impact on the university's operations.

**Tradumo**

*   **Tasks:** A system for managing university finances.
*   **RTO:** 1 hour.
*   **Reasoning:** Tradumo is a critical system that is used to manage the university's finances. A long outage could have a serious financial impact on the university.

#### b) Can you explain what "system hosting" means and tell me where each of these Nkumba University systems (AIMS, eLearning platform, and Tradumo) are hosted? [5 Marks]

**System Hosting**

System hosting is the process of storing and maintaining a computer system on a server. The server can be located on-premises, in a data center, or in the cloud.

**Hosting of Nkumba University Systems**

*   **AIMS:** AIMS is likely hosted on-premises, on a server in the university's data center. This is because AIMS is a critical system that requires a high level of security and control.
*   **eLearning platform:** The eLearning platform could be hosted on-premises or in the cloud. A cloud-based solution would offer a number of advantages, such as scalability and reliability.
*   **Tradumo:** Tradumo is likely hosted on-premises, on a server in the university's data center. This is because Tradumo is a critical system that requires a high level of security and control.

#### c) As a System Administration student, what does it take to host these systems? [5 Marks]

To host these systems, a System Administration student would need to have the following skills and knowledge:

*   **Hardware:** The student would need to be able to select and configure the appropriate hardware for each system. This includes the server, storage, and networking equipment.
*   **Software:** The student would need to be able to install and configure the operating system, database, and application software for each system.
*   **Security:** The student would need to be able to implement security measures to protect the systems from unauthorized access.
*   **Monitoring:** The student would need to be able to monitor the systems for performance and availability issues.
*   **Troubleshooting:** The student would need to be able to troubleshoot and resolve problems with the systems.

#### d) Outline a disaster recovery strategy for the systems in question. [5 Marks]

A disaster recovery strategy for these systems should include the following:

*   **Backups:** All systems should be backed up on a regular basis. The backups should be stored in a secure location, both on-site and off-site.
*   **Redundancy:** All critical systems should have redundant components, such as redundant power supplies and hard drives. This will help to ensure that the systems remain available in the event of a component failure.
*   **Failover:** All critical systems should have a failover plan in place. This will allow the systems to be quickly restored to a functional state in the event of a disaster.
*   **Testing:** The disaster recovery plan should be tested on a regular basis to ensure that it is effective.

### Question 3

#### a) What is SNMP and what is its primary purpose in network management? [2 Marks]

**Definition**

SNMP (Simple Network Management Protocol) is a protocol that is used to manage devices on a network. It is a part of the TCP/IP protocol suite.

**Primary Purpose**

The primary purpose of SNMP is to allow network administrators to monitor and manage network devices from a central location. SNMP can be used to:

*   **Monitor the performance of network devices:** SNMP can be used to collect information about the CPU utilization, memory utilization, and network traffic of network devices.
*   **Configure network devices:** SNMP can be used to configure the settings of network devices, such as the IP address and routing table.
*   **Receive alerts from network devices:** SNMP can be used to receive alerts from network devices when a problem is detected.

#### b) Discuss the key differences between a server and a workstation in terms of hardware, software, and functionality. [8 Marks]

| Feature | Server | Workstation |
|---|---|---|
| **Hardware** | Designed for high performance and reliability. Often has multiple CPUs, large amounts of memory, and redundant components. | Designed for a single user. Has a single CPU, a moderate amount of memory, and no redundant components. |
| **Software** | Runs a server operating system, such as Windows Server or Linux. | Runs a desktop operating system, such as Windows 10 or macOS. |
| **Functionality** | Provides services to other computers on the network, such as file sharing, email, and web hosting. | Used by a single user to perform tasks such as word processing, web browsing, and email. |

#### c) What is the World Wide Web and how does it differ from the internet? [4 Marks]

**World Wide Web**

The World Wide Web (WWW) is a system of interconnected documents and other web resources that are identified by Uniform Resource Locators (URLs). The WWW is accessed via the internet.

**Internet**

The internet is a global network of computers that are connected to each other. The internet provides the infrastructure for the WWW, as well as for other services such as email and file transfer.

**Difference**

The main difference between the WWW and the internet is that the WWW is a system of documents, while the internet is a network of computers. The WWW is a service that runs on top of the internet.

#### d) What is a URL (Uniform Resource Locator), and how does it work in web addressing? [2 Marks]

**Definition**

A URL (Uniform Resource Locator) is a unique address that is used to identify a resource on the internet. A URL consists of a protocol, a domain name, and a path.

**How it Works**

When you type a URL into your web browser, the browser sends a request to a DNS (Domain Name System) server. The DNS server then translates the domain name into an IP address. The browser then sends a request to the IP address, and the web server sends the requested resource back to the browser.

#### e) Explain the concept of a web application and how it differs from traditional websites. [4 Marks]

**Web Application**

A web application is a software application that is accessed via a web browser. A web application can be used to perform a wide variety of tasks, such as online banking, online shopping, and social networking.

**Traditional Website**

A traditional website is a collection of static web pages that are linked together. A traditional website is typically used to provide information to users.

**Difference**

The main difference between a web application and a traditional website is that a web application is interactive, while a traditional website is not. A web application allows users to interact with the application, while a traditional website only allows users to view information.

### Question 4

#### a) Define the term Data Backup, then go ahead to explain the three (3) purposes that Backups serve. [4 Marks]

**Definition**

Data backup is the process of creating a copy of data that can be used to restore the data in case of data loss.

**Purposes of Backups**

Backups serve three main purposes:

1.  **Data recovery:** Backups can be used to recover data that has been lost due to a hardware failure, software error, or human error.
2.  **Disaster recovery:** Backups can be used to restore a system to a functional state after a disaster, such as a fire, flood, or earthquake.
3.  **Archiving:** Backups can be used to archive data that is no longer in active use, but that needs to be retained for legal or regulatory reasons.

#### b) With the help of a diagram explain the three pillars of Backup Architecture. [4 Marks]

```
      +-----------------+
      |   Backup Source |
      +-----------------+
              |
      +-----------------+
      |  Backup Target  |
      +-----------------+
              |
      +-----------------+
      | Backup Software |
      +-----------------+
```

**Backup Source**

The backup source is the data that is being backed up. This can be a file system, a database, or a virtual machine.

**Backup Target**

The backup target is the location where the backup is stored. This can be a local server, a network attached storage (NAS) device, or a cloud storage service.

**Backup Software**

The backup software is the software that is used to create and manage backups. The backup software is responsible for copying the data from the backup source to the backup target.

#### c) Write down and explain the steps taken in Backup Operation [7 Marks]

1.  **Identify the data to be backed up:** The first step is to identify the data that needs to be backed up. This includes all critical data, such as financial records, customer data, and intellectual property.
2.  **Select a backup method:** There are a number of different backup methods available, such as full backups, incremental backups, and differential backups. The best backup method for your organization will depend on your specific needs.
3.  **Choose a backup target:** The next step is to choose a backup target. This is the location where the backup will be stored.
4.  **Schedule the backup:** The backup should be scheduled to run on a regular basis, such as daily or weekly.
5.  **Test the backup:** It is important to test the backup on a regular basis to ensure that it is working properly.
6.  **Monitor the backup:** The backup should be monitored to ensure that it is running as scheduled and that there are no errors.
7.  **Store the backup in a secure location:** The backup should be stored in a secure location, both on-site and off-site.

#### d) Write down and explain the steps taken in Recovery Operation [5 Marks]

1.  **Identify the data to be recovered:** The first step is to identify the data that needs to be recovered.
2.  **Locate the backup:** The next step is to locate the backup that contains the data to be recovered.
3.  **Restore the data:** The data is then restored from the backup.
4.  **Verify the data:** The data is then verified to ensure that it has been restored correctly.
5.  **Bring the system back online:** The system is then brought back online.

### Question 5

#### a) Define the term disaster and explain the three categories of disasters in the IT System. [4 Marks]

**Definition**

A disaster is an event that causes a significant disruption to an organization's IT operations.

**Categories of Disasters**

There are three main categories of disasters in the IT system:

1.  **Natural disasters:** These are disasters that are caused by natural events, such as fires, floods, earthquakes, and hurricanes.
2.  **Man-made disasters:** These are disasters that are caused by human actions, such as power outages, cyberattacks, and terrorism.
3.  **Technical disasters:** These are disasters that are caused by technical failures, such as hardware failures, software errors, and network outages.

#### b) Organizations deal with disaster recovery by address three major factors, write and explain these factors. [4 Marks]

1.  **Prevention:** The first factor is to prevent disasters from happening in the first place. This can be done by implementing security measures, such as firewalls and antivirus software, and by having a disaster recovery plan in place.
2.  **Mitigation:** The second factor is to mitigate the impact of a disaster if one does occur. This can be done by having backups of all critical data and by having a failover plan in place.
3.  **Recovery:** The third factor is to recover from a disaster as quickly as possible. This can be done by having a disaster recovery team in place and by testing the disaster recovery plan on a regular basis.

#### c) Explain these two concepts and how they relate to disaster recovery. [4 Marks]

##### i. Recovery Point Objective (RPO)

The Recovery Point Objective (RPO) is the maximum amount of data that can be lost in a disaster. The RPO is typically measured in hours or minutes.

##### ii. Recovery Time Objective (RTO)

The Recovery Time Objective (RTO) is the maximum amount of time that a system can be down after a disaster. The RTO is typically measured in hours or minutes.

**How they Relate to Disaster Recovery**

The RPO and RTO are two key metrics that are used to measure the effectiveness of a disaster recovery plan. The goal of a disaster recovery plan is to minimize the RPO and RTO.

#### d) Compare the two concepts Recovery Point Objective (RPO) and Recovery Time Objective (RTO) using the criteria i) Focus on, ii) Depends on, iii) Describes, iv) Consideration. [4 Marks]

| Criteria | Recovery Point Objective (RPO) | Recovery Time Objective (RTO) |
|---|---|---|
| **Focus on** | Data loss | Time to recover |
| **Depends on** | Backup frequency | Recovery process |
| **Describes** | How much data can be lost | How long it takes to recover |
| **Consideration** | The cost of data loss | The cost of downtime |

#### e) Explain what a disaster recovery plan is and list three issues you consider in a disaster recovery plan. [4 Marks]

**Definition**

A disaster recovery plan is a documented process that outlines the steps to be taken in the event of a disaster. The goal of a disaster recovery plan is to minimize the impact of a disaster and to restore IT operations as quickly as possible.

**Issues to Consider in a Disaster Recovery Plan**

1.  **Identify critical systems:** The first step is to identify the critical systems that need to be protected.
2.  **Develop a backup and recovery strategy:** The next step is to develop a backup and recovery strategy for the critical systems.
3.  **Create a disaster recovery team:** The disaster recovery team will be responsible for implementing the disaster recovery plan in the event of a disaster.

### Question 6

#### a) Using a well-labeled diagram, illustrate the logical architecture of Active Directory. In your explanation, clearly describe and demonstrate the following components: [10 Marks]

```
      +-----------------+
      |      Forest     |
      +-----------------+
              |
      +-----------------+
      |       Tree      |
      +-----------------+
              |
      +-----------------+
      |      Domain     |
      +-----------------+
              |
      +-----------------+
      | Organizational  |
      |       Unit      |
      +-----------------+
              |
      +-----------------+
      |      Object     |
      +-----------------+
```

**Object**

An object is a basic unit of storage in Active Directory. An object can be a user, a computer, a printer, or a group.

**Domain**

A domain is a logical grouping of objects in Active Directory. A domain can be used to represent a company, a department, or a location.

**Organizational Unit (OU)**

An organizational unit (OU) is a container that can be used to organize objects within a domain. An OU can be used to represent a department, a location, or a project.

**Tree**

A tree is a collection of one or more domains that are connected in a hierarchical structure.

**Forest**

A forest is a collection of one or more trees that are connected in a trust relationship.

#### b) Give five (5) reasons why we should use Active Directory Services. [5 Marks]

1.  **Centralized management:** Active Directory provides a centralized location for managing all network resources. This makes it easier for administrators to manage the network and to enforce security policies.
2.  **Improved security:** Active Directory provides a number of security features, such as authentication, authorization, and encryption. This helps to protect the network from unauthorized access.
3.  **Increased scalability:** Active Directory is a scalable solution that can be used to manage a large number of users and computers.
4.  **Reduced costs:** Active Directory can help to reduce the costs of managing a network by automating a number of tasks.
5.  **Improved user experience:** Active Directory can help to improve the user experience by providing a single sign-on solution for all network resources.

#### c) Write down five (3) areas where Active Directory Services can be used [3 Marks]

1.  **User authentication and authorization:** Active Directory can be used to authenticate and authorize users to access network resources.
2.  **Group Policy:** Active Directory can be used to deploy and manage Group Policy settings.
3.  **Software deployment:** Active Directory can be used to deploy software to computers on the network.

#### d) Describe the process of joining a computer to an Active Directory domain. [2 Marks]

1.  **Open the System Properties dialog box.**
2.  **Click the Computer Name tab.**
3.  **Click the Change button.**
4.  **In the Computer Name/Domain Changes dialog box, select the Domain option and enter the name of the domain.**
5.  **Click OK.**
6.  **Enter the user name and password of a user who has permission to join the computer to the domain.**
7.  **Click OK.**
8.  **Restart the computer.**
