Java Assessment

NAB Scenario #1

To start the application: run 'CustomerMaintApplication'

Access H2 database at http://localhost:8080/h2

There are some basic tests in 'CustomerRepositoryTests'

Most significant testing was done using Postman:

    See attached file 'nab-scenario1.postman_collection.json' for test requests that can be uploaded into Postman.

    Create  POST    http://localhost:8080/api/customers
    Read    GET     http://localhost:8080/api/customers/:id
    Update  PUT     http://localhost:8080/api/customers/:id
    Delete  DEL     http://localhost:8080/api/customers/:id

    List    GET     http://localhost:8080/api/list




