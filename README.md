# Question_proAssignment
# Spring Boot Project: Hacker News API

This Spring Boot project provides a Hacker News-like API that allows users to retrieve top stories, past stories, and comments.

## Endpoints

1. `/top-stories`
   - Returns the top 10 stories ranked by score in the last 15 minutes.
   - Each story includes: title, URL, score, time of submission, and the user who submitted it.

2. `/past-stories`
   - Returns all stories served previously by the `/top-stories` endpoint.
   - Each story includes the same details as in the `/top-stories` endpoint.

3. `/comments`
   - Returns 10 comments (max) on a given story, sorted by the total number of child comments.
   - Each comment includes: comment text and the user's Hacker News handle.

## How to Use

1. Clone the repository to your local machine:

   ```bash
   git clone https://github.com/yourusername/your-repo-name.git
   cd your-repo-name


   1> Build and run the Spring Boot application: ./mvnw spring-boot:run

   2>The application will start on a local server port 8082.

Access the endpoints in your browser or using a tool like curl or Postman:

Top Stories: http://localhost:8082/top-stories
Past Stories: http://localhost:8082/past-stories
Comments for a Story: http://localhost:8082/comments/{storyId}


3>Technologies Used
java
Spring Boot
Hibernate
JPA
Docker
