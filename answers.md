# Android Development Questions and Answers

## Qn01: Compulsory (40 Marks)

### a) Provide the definition of the following terms

i. **Activity:** An activity is a single, focused thing that the user can do. Almost all activities interact with the user, so the Activity class takes care of creating a window for you in which you can place your UI with `setContentView(View)`.

ii. **Service:** A Service is an application component that can perform long-running operations in the background, and it does not provide a user interface. Another application component can start a service, and it continues to run in the background even if the user switches to another application.

iii. **Broadcast receiver:** A broadcast receiver is a component that enables the system to deliver events to the app outside of a regular user flow, allowing the app to respond to system-wide broadcast announcements.

iv. **Content provider:** A content provider manages a shared set of application data. You can store the data in the file system, in an SQLite database, on the web, or on any other persistent storage location that your application can access.

### b) Define what android is

Android is a mobile operating system based on a modified version of the Linux kernel and other open-source software, designed primarily for touchscreen mobile devices such as smartphones and tablets.

### c) Provide a list of any four features of android

1.  **Open Source:** The source code for Android is available for free, which allows for a large community of developers to contribute to its development and create custom versions of the OS.
2.  **Large Application Market:** The Google Play Store has millions of apps available for download.
3.  **Multitasking:** Android allows users to run multiple applications at the same time and switch between them seamlessly.
4.  **Rich Connectivity:** Android supports a wide range of connectivity options, including GSM/EDGE, CDMA, Wi-Fi, Bluetooth, and NFC.

### d) What do you understand by the term JDK?

JDK stands for Java Development Kit. It's a software development environment used for developing Java applications and applets. It includes the Java Runtime Environment (JRE), an interpreter/loader (java), a compiler (javac), an archiver (jar), a documentation generator (javadoc), and other tools necessary for Java development.

### e) Enumerate the four android application components.

The four main Android application components are:
1.  Activities
2.  Services
3.  Broadcast Receivers
4.  Content Providers

i. **What do you understand by the following terms?**

*   **Layouts:** Layouts are the UI architecture for an Android app. They define the structure for a user interface in an activity or app widget. Examples include `LinearLayout`, `RelativeLayout`, and `ConstraintLayout`.
*   **Fragment:** A fragment is a modular section of an activity, with its own lifecycle, that can be combined with other fragments in a single activity to build a multi-pane UI.

### f) With the help of a diagram, describe the four layers of the android software architecture.

Since I cannot draw a diagram, I will describe the layers textually from bottom to top:

1.  **Linux Kernel:** This is the foundation of the Android platform. It provides core system services such as security, memory management, process management, network stack, and a driver model.
2.  **Hardware Abstraction Layer (HAL) & Android Runtime (ART):** The HAL provides a standard interface that exposes device hardware capabilities to the higher-level Java API framework. The Android Runtime (ART) is the runtime environment used by Android applications. ART and its predecessor Dalvik were created specifically for the Android project.
3.  **Native C/C++ Libraries and Java API Framework:** This layer includes a set of C/C++ libraries used by various components of the Android system. The Java API Framework provides the high-level APIs used by developers to build apps.
4.  **System Apps:** This is the top layer, which includes the applications that are pre-installed on the device, such as the phone, email client, calendar, etc., as well as the applications installed by the user.

### g) What is information hiding and how is it implemented?

Information hiding is a principle of software design that restricts access to the internal implementation details of an object. In Java and Android development, it is implemented using access modifiers: `private`, `protected`, `public`, and the default (package-private) access level. By declaring a class's fields as `private`, you hide them from other classes, and you can then provide controlled access to them through `public` methods (getters and setters).

### h) Describe the following layouts in the context user interface of a mobile application.

i. **Relative Layout:** `RelativeLayout` is a layout that displays child views in relative positions. The position of each view can be specified as relative to sibling elements (such as to the left-of or below another view) or in positions relative to the parent `RelativeLayout` area (such as aligned to the bottom, left or center).

ii. **Frame layout:** `FrameLayout` is a placeholder on the screen that you can use to display a single view. Child views are drawn in a stack, with the most recently added child on top. `FrameLayout` is often used to hold a single child view, because it can be difficult to organize child views in a way that's scalable to different screen sizes without the children overlapping each other.

### i) Briefly describe four functions of a manifest XML file in mobile programming.

1.  **Names the Java package for the application:** This package name serves as a unique identifier for the application.
2.  **Describes the components of the application:** This includes the activities, services, broadcast receivers, and content providers that the application is composed of.
3.  **Declares which permissions the application must have:** It specifies the permissions the application needs in order to access protected parts of the system or other applications.
4.  **Declares the minimum level of the Android API that the application requires.**

## Qn02.

### i. Android applications include components that may be classified into four categories. Name and briefly describe these categories.

This is a repetition of Qn01.e. The four main Android application components are:
1.  **Activities:** A single screen with a user interface.
2.  **Services:** A component that runs in the background to perform long-running operations.
3.  **Broadcast Receivers:** A component that responds to system-wide broadcast announcements.
4.  **Content Providers:** A component that manages a shared set of application data.

### ii. Write the following files for a simple tax calculator given the income

The code for the following files will be created in the repository:
*   `MainActivity.java`
*   `activity_main.xml`
*   `AndroidManifest.xml`
*   `Incometax.java`

### iii. Android operating systems for mobile devices has been increasing its market share worldwide. Describe one reason that explains this trend.

One major reason for Android's increasing market share is its **open-source nature**. The Android Open Source Project (AOSP) allows manufacturers to use and customize the Android OS for free. This has led to a wide variety of devices at different price points, making Android accessible to a larger global audience compared to its competitors.

## Qn03.

### iv. Define and explain the relationship between default parameters and overloading.

In programming, both default parameters and function/method overloading are ways to provide more flexibility when calling functions.

*   **Overloading:** This allows you to define multiple methods with the same name but with different parameter lists (either a different number of parameters or different types of parameters). The correct method to call is determined at compile time based on the arguments passed. Java supports method overloading.
*   **Default Parameters:** This allows you to specify a default value for a parameter in a function definition. If a value is not provided for that parameter when the function is called, the default value is used. Java does not support default parameters directly, but the same effect can be achieved using method overloading.

The relationship is that both can be used to create functions that can be called with a variable number of arguments.

### ii. State and briefly describe the four parts of a GSM network.

A GSM network has four main parts:

1.  **Mobile Station (MS):** This is the user's device, such as a mobile phone or tablet. It consists of the mobile equipment and a Subscriber Identity Module (SIM).
2.  **Base Station Subsystem (BSS):** This is responsible for handling the radio communication with the mobile station. It consists of the Base Transceiver Station (BTS) and the Base Station Controller (BSC).
3.  **Network and Switching Subsystem (NSS):** This is the core of the network. It manages the connections, switching, and routing of calls and data between mobile subscribers, and between mobile and landline networks.
4.  **Operation and Support Subsystem (OSS):** This is the functional entity from which the network operator monitors and controls the system.

### iii. Discuss three limitations that are associated with mobile devices.

1.  **Limited Battery Life:** Mobile devices are powered by batteries, which have a finite capacity. This means they need to be recharged regularly, and heavy usage can drain the battery quickly.
2.  **Small Screen Size:** The screen size of mobile devices is much smaller than that of desktop computers, which can make it difficult to view and interact with content.
3.  **Limited Processing Power and Storage:** While mobile devices have become more powerful, they still have less processing power and storage capacity than traditional computers.

### j) State and briefly describe FIVE methods used to describe the fragment life cycle in android application development.

1.  **`onAttach()`:** Called when the fragment has been associated with the activity (the `Activity` has been passed in here).
2.  **`onCreateView()`:** Called to have the fragment instantiate its user interface view. This is optional, and non-graphical fragments can return null.
3.  **`onActivityCreated()`:** Called when the activity's `onCreate()` method has returned.
4.  **`onDestroyView()`:** Called when the view previously created by `onCreateView()` has been detached from the fragment.
5.  **`onDetach()`:** Called when the fragment is being disassociated from the activity.
