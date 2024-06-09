# Testing Strategy

## Repository Layer Tests

- **Objective:** Test data retrieval and manipulation logic using H2 in-memory database.
- **Focus:** JPA queries and entity relationships.

## Service Layer Tests

- **Objective:** Test business logic and service workflows.
- **Focus:** Mock dependencies using Mockito.

## Controller Layer Tests

- **Objective:** Test API endpoints and HTTP request handling.
- **Focus:** Validate JSON responses and status codes using MockMvc.

## Security Configuration Tests

- **Objective:** Test role-based access controls and authentication mechanisms.
- **Focus:** Verify endpoint protection and access restrictions using SpringSecurityTest.

## Integration Tests

- **Objective:** Ensure seamless integration between different layers (controller, service, repository).
- **Focus:** Test end-to-end functionality using TestRestTemplate.
