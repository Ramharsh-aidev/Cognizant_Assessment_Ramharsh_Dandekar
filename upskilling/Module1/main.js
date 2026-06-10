// 1. JavaScript Basics & Setup
console.log("Welcome to the Community Portal");

window.addEventListener('load', () => {
    alert("Page is fully loaded!");
});

// 2. Syntax, Data Types, and Operators
const demoEventName = "Community Picnic";
const demoEventDate = "2026-08-01";
let demoSeats = 30;

// Concatenating using template literals
console.log(`Demo Event: ${demoEventName} is scheduled for ${demoEventDate}. Initial seats: ${demoSeats}`);

// Use -- to manage seat count
demoSeats--;
console.log(`A user registered! Seats remaining: ${demoSeats}`);

// Dynamic Data Array for the portal
const eventsList = [
    { name: "Spring Festival Opening", location: "Main City Park", date: "2026-06-15", time: "09:00 AM", seats: 50 },
    { name: "Sports Day Kickoff", location: "Community Stadium", date: "2026-06-20", time: "11:30 AM", seats: 0 }, // Full Event
    { name: "Art Exhibition Tour", location: "Downtown Gallery", date: "2026-07-10", time: "02:00 PM", seats: 20 },
    { name: "Food Festival Tasting", location: "City Square", date: "2026-07-15", time: "05:00 PM", seats: 100 },
    { name: "Past Winter Gala", location: "City Hall", date: "2025-12-01", time: "07:00 PM", seats: 10 } // Past Event
];

// 3. Conditionals, Loops, and Error Handling
function displayEvents() {
    const tbody = document.querySelector('.schedule-table tbody');
    if (!tbody) return;
    
    tbody.innerHTML = ''; // Clear hardcoded content
    
    const currentDate = new Date().toISOString().split('T')[0];

    // Loop through the event list and display using forEach()
    eventsList.forEach(event => {
        // Use if-else to hide past or full events
        if (event.date < currentDate) {
            console.log(`[Hidden] Skipping ${event.name}: Event is in the past.`);
        } else if (event.seats <= 0) {
            console.log(`[Hidden] Skipping ${event.name}: Event is fully booked.`);
        } else {
            // Display valid events
            const tr = document.createElement('tr');
            tr.innerHTML = `
                <td>${event.time} (${event.date})</td>
                <td>${event.name} (Seats: <span id="seats-${event.name.replace(/\s+/g, '-')}">${event.seats}</span>)</td>
                <td>${event.location} <button onclick="handleRegistration('${event.name}')" style="margin-left: 10px; padding: 5px; cursor:pointer;">Register Here</button></td>
            `;
            tbody.appendChild(tr);
        }
    });
}

function handleRegistration(targetEventName) {
    // Wrap registration logic in try-catch to handle errors
    try {
        // Find the event reference
        let eventObj = eventsList.find(e => e.name === targetEventName);
        
        if (!eventObj) {
            throw new Error("Event not found in the system.");
        }
        if (eventObj.seats <= 0) {
            throw new Error("Sorry, this event is completely full.");
        }
        
        // Decrease seat count using the decrement operator
        eventObj.seats--;
        
        // Update UI dynamically
        const seatSpan = document.getElementById(`seats-${targetEventName.replace(/\s+/g, '-')}`);
        if (seatSpan) {
            seatSpan.innerText = eventObj.seats;
        }
        
        alert(`Successfully registered for ${eventObj.name}! Remaining seats: ${eventObj.seats}`);
        
    } catch (error) {
        alert(`Registration Error: ${error.message}`);
        console.error("Registration Exception:", error);
    }
}

// Initialize display after DOM is loaded
window.addEventListener('DOMContentLoaded', displayEvents);
