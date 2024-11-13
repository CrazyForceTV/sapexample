# SAP working sample
 
For the submission of a project built with Vue.js and Spring Boot, I am submitting a current university project. 
This project is intended to become a small SaaS application designed to help sports clubs manage waiting lists digitally and in compliance with GDPR regulations. 
The entire system is divided into microservices to ensure scalability and maintainability. One of them is managing the team data.For the sake of simplicity, only the team data CRUD has been presented.

Currently, the application is being developed specifically for my football club, SC Minerva 1893, which faces challenges in managing youth teams due to a shortage of coaches. 

##The application works as follows: 

The club administrators will set up teams, coaches, and training schedules. 
Potential new members can then send a training request.

If there is space available in the team, an invitation email will be sent with the relevant training times, and the corresponding coaches will be notified.
If the team is full, an email will inform the applicant that the team is currently at capacity and ask whether they would like to be added to the waiting list. 
Those on the waiting list must be manually invited by the club when space becomes available.
To comply with GDPR regulations, the application will periodically ask users every six months if they wish to remain on the waiting list or if they no longer wish to be contacted.
