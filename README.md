# pizzeriaHead
Simple backend microservice for the management of a Pizzeria with Java Spring Boot and MySql

Note:
Per svolgere questo piccolo progetto, ho utilizzato il framework Spring Boot ed il database mysql. 
Ho sfruttato docker desktop per gestire i microservizi. 
Ho utilizzato intellij come IDE. 

Note di avvio: 
Per avviarlo basta fare "docker-compose up -d". All'interno del docker compose sono presenti sia il microservizio dell'applicazione e sia il microservizio di sql. 

Post Request Pizza
{
"nome": "Margherita",
"aggiunta":"Prosciutto, Melanzane",
"rimozione" :"no",
"prezzo":6.5,
"pizzaiolo": {"id": 1}
}

Post Request Pizzaiolo 
{
"nome":"Giuseppe",
"cognome":"Testa",
"eta":26
}
