🏨 BookMyStayApp
Hotel Booking Management System (OOP + DSA + System Design)

🎯 Objective

The objective of this project is to design and implement a Hotel Booking Management System that demonstrates:
Core Object-Oriented Programming (OOP) concepts
Use of Data Structures (Queue, Stack, List, Map)
Real-world system features like:
Booking
Allocation
Cancellation
Add-on services
Reporting
Validation
Concurrency
Data Persistence

👉 The system ensures:

Fair booking using FIFO
Safe room allocation (no double booking)
Error handling and validation
Thread-safe operations
Data recovery after restart

⚙️ Project Procedure (Step-by-Step)

Application Start
System initializes using main() method
Displays welcome message
Room Definition
Different room types created:
Single
Double
Suite
Room Inventory Setup
Initial availability stored in RoomInventory
Room Search
User checks available rooms
Only available rooms are displayed
Booking Request
User submits booking request
Requests stored in Queue (FIFO)
Room Allocation
Requests processed in order
Unique Room ID assigned
Inventory updated
Add-On Services
Optional services added:
Breakfast
Spa
Cost calculated separately
Booking History
Confirmed bookings stored in list
Used for reporting
Validation & Error Handling
Invalid inputs checked
Custom exception used
Cancellation & Rollback
Booking cancelled safely
Inventory restored
Stack used for rollback tracking
Concurrent Booking
Multiple users simulated using threads
Synchronization ensures:
No race condition
Safe allocation
Data Persistence
Inventory saved to file
Reloaded on restart


🔄 Flow of Program

Start Application
        ↓
Initialize Inventory
        ↓
User Searches Rooms
        ↓
User Sends Booking Request
        ↓
Queue Stores Requests (FIFO)
        ↓
Room Allocation Service
        ↓
Booking Confirmed (Room ID Generated)
        ↓
Add-On Services (Optional)
        ↓
Booking Stored in History
        ↓
(Admin can View Reports)
        ↓
Cancellation (if needed)
        ↓
Rollback + Inventory Restore
        ↓
Concurrent Processing (Threads)
        ↓
Save Data to File
        ↓
Restart → Load Data
        ↓
End


🧩 Use Case Descriptions (Short & Simple)

✅ Use Case 1: Application Entry
Starts system
Displays welcome message
✅ Use Case 2–3: Room & Inventory
Defines room types
Stores availability
✅ Use Case 4: Room Search
Shows available rooms
Read-only operation
✅ Use Case 5: Booking Request (Queue)
FIFO order maintained
Fair booking system
✅ Use Case 6: Room Allocation
Unique room ID assigned
Inventory updated
No double booking
✅ Use Case 7: Add-On Services
Extra services added
No impact on core booking
✅ Use Case 8: Booking History
Stores confirmed bookings
Used for reports
✅ Use Case 9: Validation
Checks input
Prevents invalid bookings
✅ Use Case 10: Cancellation
Booking cancelled
Inventory restored
Stack used for rollback
✅ Use Case 11: Concurrency
Multiple users (threads)
Synchronization used
✅ Use Case 12: Persistence
Data saved in file
Loaded after restart

🧠 Concepts Used

🔹 OOP Concepts
Classes & Objects
Encapsulation
Abstraction
Modular Design
🔹 Data Structures
Queue → Booking requests
Stack → Cancellation rollback
List → Booking history
Map → Inventory & mappings
🔹 Advanced Concepts
Exception Handling
Multithreading
Synchronization
File Handling


🔥 Key Features

✔ FIFO Booking System
✔ Thread-safe allocation
✔ No double booking
✔ Rollback support
✔ Add-on flexibility
✔ Reporting system
✔ Persistent storage

🧪 Sample Output
Booking confirmed for Guest: Abhi, Room ID: Single-1
Booking confirmed for Guest: Subha, Room ID: Double-1

Add-On Service Selection
Total Add-On Cost: 1500.0

Booking History Report
Guest: Abhi, Room Type: Single

Booking cancelled successfully
Inventory restored

Concurrent Booking Simulation completed

System Recovery
Inventory loaded successfully
