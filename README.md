# accountCreditService
An example of a microservice which is responsible for crediting accounts which are accessed from the accounts service. Rules are applied when crediting account which are dependent on the account sub-type. This is an example of an implementation of both the Factory and Command patterns which are used to decouple the logic for validating and crediting accounts from the account type implementations.

This service acts as a client node to the [account](https://github.com/johnhunsley/account) which should be running as a service, using the 'service' profile. This service also uses the [account](https://github.com/johnhunsley/account) as a dependency with which it serializes/deserializes model objects when making requests to and reading responses from the account service. 
