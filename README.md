# Money Accounting System


## Run
For the frontend, run on the root folder:
```
npm start
```

For the backend, run over Sparkapi/target
```
java -jar Spark-api-1.0-SNAPSHOT.jar
```

## Endpoints

* **Get all Transactions**\
Fetches transactions history
```
Verb: GET
URL: http://localhost:4567/
```

Response:
```javascript
[
  {
    "id": "string",
    "type": "credit",
    "amount": 0,
    "effectiveDate": "2019-05-30T01:59:55.221Z"
  }
]
```

* **Create Transaction**\
Commit new transaction to the account
```
Verb: POST
URL: http://localhost:4567/
```
Body:
```javascript
{
  "type": "credit",
  "amount": 0
}
```

Response:

```javascript
{
  "id": "string",
  "type": "credit",
  "amount": 0,
  "effectiveDate": "2019-05-30T01:53:00.876Z"
}
```

On invalid entry:

```
code: 400
message: invalid input
```

On negative balance:

```
code: 400
message: invalid transaction
```


* **Get Transaction by Id**\
Find transaction by ID
```
Verb: GET
URL: http://localhost:4567/{id}
```

Response:
```javascript
{
  "id": "string",
  "type": "credit",
  "amount": 0,
  "effectiveDate": "2019-05-30T01:57:51.160Z"
}
```

On invalid ID format:

```
code: 400
message: invalid ID supplied
```

On transaction not found:

```
code: 404
message: transaction not found
```

## TODO / LEFT BEHIND:

* Implement: * * invalid status value * * error on GetAll
* Test * * concurrent access * * and implement if it doesn't work
* UnitTests