# 🏨 BookMyStayApp
Hotel Booking Management System (OOP + DSA + System Design)

---

## 🎯 Objective
The objective of this project is to design and implement a Hotel Booking Management System that demonstrates:

- OOP concepts
- Data Structures (Queue, Stack, List, Map)
- Real-world features:
    - Booking
    - Allocation
    - Cancellation
    - Add-on services
    - Reporting
    - Validation
    - Concurrency
    - Data Persistence

👉 The system ensures:
- Fair booking using FIFO
- Safe room allocation (no double booking)
- Error handling and validation
- Thread-safe operations
- Data recovery after restart

---

## ⚙️ Project Procedure

1. Application starts using `main()`
2. Room types created (Single, Double, Suite)
3. Inventory initialized
4. User searches rooms
5. Booking request added to Queue (FIFO)
6. Room allocated with unique ID
7. Add-on services added
8. Booking stored in history
9. Validation & error handling applied
10. Cancellation with rollback
11. Concurrent booking using threads
12. Data saved & loaded from file

---

## 🔄 Flow of Program

Start  
↓  
Initialize Inventory  
↓  
Search Rooms  
↓  
Booking Request  
↓  
Queue (FIFO)  
↓  
Room Allocation  
↓  
Booking Confirmed  
↓  
Add-On Services  
↓  
Booking History  
↓  
Cancellation (if needed)  
↓  
Rollback  
↓  
Concurrency  
↓  
Save Data  
↓  
Load Data  
↓  
End

---

## 🧩 Use Cases

- Use Case 1: Application Entry
- Use Case 2–3: Room & Inventory
- Use Case 4: Room Search
- Use Case 5: Booking Request (Queue)
- Use Case 6: Room Allocation
- Use Case 7: Add-On Services
- Use Case 8: Booking History
- Use Case 9: Validation
- Use Case 10: Cancellation
- Use Case 11: Concurrency
- Use Case 12: Persistence

---

## 🧠 Concepts Used

### OOP
- Classes & Objects
- Encapsulation
- Abstraction

### Data Structures
- Queue → Booking
- Stack → Rollback
- List → History
- Map → Inventory

### Advanced
- Exception Handling
- Multithreading
- Synchronization
- File Handling

---

## 📌 Conclusion
This project demonstrates a real-world hotel booking system with:

✔ Safe design  
✔ Scalable architecture  
✔ Proper data handling

