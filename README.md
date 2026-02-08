# Day Calendar – Java Console & Swing GUI

This repository contains two versions of a simple **Day Calendar application** in Java:

1. **Console Version** – Command-line interface where users can set, view, and navigate days.  
2. **Swing GUI Version** – A graphical interface built with Java Swing, featuring buttons, dropdowns, and a week view.

Both versions demonstrate **object-oriented programming concepts** (encapsulation, modular design) and user interaction handling.

---

## Features

### Console Version
- Set the current day (Sun, Mon, Tue, …).  
- Show the current day.  
- Move to the next or previous day.  
- Move forward/backward by **N days** (supports negative values).  
- Menu-driven interface with user input via `Scanner`.

### Swing GUI Version
- Interactive GUI with **buttons and dropdowns**.  
- Set the current day using a combo box.  
- Navigate to next/previous day with buttons.  
- Move forward/backward by **N days** using a text field.  
- Week view panel highlights the current day in **green**.  
- Responsive UI with error handling for invalid inputs.

---

## Technologies Used
- **Java (JDK 8+)**  
- **Java Swing** – GUI framework  
- **Java AWT** – Layouts and event handling  
- **Object-Oriented Programming** – Encapsulation, modular design  

---

## Project Structure
DayCalendar:
- src/
     - Task_1.java - Console version
     - CalenderGUI.java - Swing GUI version

---

## Getting Started

### Prerequisites
- Java JDK 8 or above  
- Any IDE (IntelliJ, Eclipse, NetBeans) or command-line setup  

## Future Improvements
- Add localization (support for full day names).
- Enhance GUI with modern look (JavaFX).
- Save/load current day state from a file.
