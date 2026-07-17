Create Employee
------------------------
POST -> /app/v1/employees
duplicate email
duplicate phone number
duplicate employee code
Employee already exists
Employee status Enum(ACTIVE,INACTIVE,TERMINATE)
Employee Gender(MALE/FEMALE/OTHERS))
not null(DoJ, probation period, phone number)
notBlank(Emp-Code, name, email)

# Employee APIs

## Create Employee

POST /api/v1/employees

### Business Rules

- Employee Code must be unique.
- Email must be unique.
- Mobile must be unique.
- Status is always ACTIVE during creation.
- Confirmation Date = Joining Date + Probation Period.
- Employee Gender(MALE/FEMALE/OTHERS))
  not null(DoJ, probation period, phone number)
  notBlank(Emp-Code, name, email)

Get All Employees
------------------------
GET -> /app/v1/employees

Get Employee by Employee Code
------------------------
GET -> /app/v1/employees/{employeeCode}
not found
