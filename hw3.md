# database_materials
Optimistic lock and pessimistic lock

Optimistic lock: Optimistic Locking allows a conflict to occur, but it needs to detect it at write time.

The version column is going to be incremented every time on UPDATE or DELETE statement. For Example, When reading the record, both users read its current version. When changes happened, the version will increment. So if others want to update, the version will not match. so it rollback for transaction.

pessimistic lock: Pessimistic locking aims to avoid conflicts by using locking. For Example, if two transactions are required to update one same record, The T2 transaction has to wait for the T1 released the shared lock.



Distributed Transaction 2PC (Two phase commit) Synchronized

prepare phase: means do some preparation before the transaction starts. For example,  if an request ask for the record updates, it will check the timestamp of both transactions and allows the new transaction do some preparation until the resource is available to execute.

commit phase: This is ensure that the updates of transaction can commit to the changes of DB.



Saga design pattern(asynchronized): When two services are in different database , the application will use the Saga design pattern.

Advantages: It enables an application to maintain data consistency across multiple services without using distributed transaction.

Disadvantages:  In order to be reliable, a service must atomically update its database *and* publish a message/event. It cannot use the traditional mechanism of a distributed transaction that spans the database and the message broker. Instead, it must use one of the patterns listed below.

 saga, which an asynchronous flow, using a synchronous request (e.g. HTTP `POST /orders`) needs to be able to determine its outcome.
