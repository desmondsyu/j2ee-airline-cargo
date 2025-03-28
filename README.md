# Airline Cargo Booking and Tracking System

The system enables external clients to book cargo shipments, retrieve shipment statuses, update shipment tracking events, and cancel shipments. The application will be deployed on a Java EE-compatible application server and must conform to web service standards including WSDL exposure, JAXB-annotated data exchange, and XML message structures.

## How to Run

1. Clone the repository

```bash
git clone https://github.com/desmondsyu/AirlineCargo.git
cd AirlineCargo
```
2. Build each module

```bash
cd AirlineCargoSys
mvn clean install
```
```bash
cd AirlineCargoSysEJB
mvn clean install
```
```bash
cd AirlineCargoSysWeb
mvn clean install
```
```bash
cd ..
mvn clean install
```

3. Deploy the ear artifact in Wildfly and start the server

4. Access web UI

```
http://localhost:8080/AirlineCargoSysWeb/dashboard.jsp
```

## WSDL endpoint URL

```
http://localhost:8080/AirlineCargoSysWeb/CargoService?wsdl
```

## Sample SOAP requests/responses

[]

## Screenshots

[]

## Members
| Name             | N_ID      |
|------------------|-----------|
| Marina Carvalho  | N01606437 |
| Vitaly Sukhinin  | N01605938 |
| Kexin Zhu        | N01621302 |
| Samruddhi Chavan | N01604191 |
| Sruthi Pandiath  | N01618202 |
