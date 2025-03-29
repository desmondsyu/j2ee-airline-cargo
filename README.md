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
cd AirlineCargoSysEJB
mvn clean install
```
```bash
cd AirlineCargoSysWeb
mvn clean install
```
```bash
cd AirlineCargoSys
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

---

###  1. `bookShipment`

###  **Request:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.cargo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:bookShipment>
         <request>
            <origin>JFK</origin>
            <destination>LAX</destination>
            <description>Electronics</description>
            <weight>5.5</weight>
            <shipperName>John Doe</shipperName>
            <shipperContact>1234567890</shipperContact>
            <consigneeName>Jane Smith</consigneeName>
            <consigneeContact>9876543210</consigneeContact>
            <declaredValue>500.00</declaredValue>
         </request>
      </ser:bookShipment>
   </soapenv:Body>
</soapenv:Envelope>
```

###  **Response:**
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:bookShipmentResponse xmlns:ns2="http://service.cargo.com/">
         <return>SLA1743286077141</return>
      </ns2:bookShipmentResponse>
   </S:Body>
</S:Envelope>
```

---

### 2. `getShipmentStatus`

###  **Request:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.cargo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getShipmentStatus>
         <trackingNumber>SLA1743286077141</trackingNumber>
      </ser:getShipmentStatus>
   </soapenv:Body>
</soapenv:Envelope>
```

###  **Response:**
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:getShipmentStatusResponse xmlns:ns2="http://service.cargo.com/">
         <return>BOOKED</return>
      </ns2:getShipmentStatusResponse>
   </S:Body>
</S:Envelope>
```

---

###  3. `updateShipmentEvent`

###  **Request:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.cargo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:updateShipmentEvent>
         <trackingNumber>SLA1743286077141</trackingNumber>
         <cargoEvent>
            <eventType>IN_TRANSIT</eventType>
            <eventTimestamp>2025-03-29T10:00:00</eventTimestamp>
         </cargoEvent>
      </ser:updateShipmentEvent>
   </soapenv:Body>
</soapenv:Envelope>
```

###  **Response:**
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:updateShipmentEventResponse xmlns:ns2="http://service.cargo.com/">
         <return>true</return>
      </ns2:updateShipmentEventResponse>
   </S:Body>
</S:Envelope>
```

---

###  4. `cancelShipment`

###  **Request:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.cargo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:cancelShipment>
         <trackingNumber>SLA1743286077141</trackingNumber>
      </ser:cancelShipment>
   </soapenv:Body>
</soapenv:Envelope>
```

###  **Response:**
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:cancelShipmentResponse xmlns:ns2="http://service.cargo.com/">
         <return>true</return>
      </ns2:cancelShipmentResponse>
   </S:Body>
</S:Envelope>
```

---

###  5. `getShipmentByShipper`

###  **Request:**
```xml
<?xml version="1.0" encoding="UTF-8"?>
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/soap/envelope/"
                  xmlns:ser="http://service.cargo.com/">
   <soapenv:Header/>
   <soapenv:Body>
      <ser:getShipmentByShipper>
         <arg0>John Doe</arg0>
      </ser:getShipmentByShipper>
   </soapenv:Body>
</soapenv:Envelope>
```

###  **Response:**
```xml
<S:Envelope xmlns:S="http://schemas.xmlsoap.org/soap/envelope/">
   <S:Body>
      <ns2:getShipmentByShipperResponse xmlns:ns2="http://service.cargo.com/">
         <return>
            <trackingNumber>SLA1743286077141</trackingNumber>
            <origin>JFK</origin>
            <destination>LAX</destination>
            <status>BOOKED</status>
            <bookingDetails>
               <shipperName>John Doe</shipperName>
               <shipperContact>1234567890</shipperContact>
               <consigneeName>Jane Smith</consigneeName>
               <consigneeContact>9876543210</consigneeContact>
               <description>Electronics</description>
               <weight>5.5</weight>
               <declaredValue>500.00</declaredValue>
            </bookingDetails>
         </return>
      </ns2:getShipmentByShipperResponse>
   </S:Body>
</S:Envelope>
```

---


## Screenshots
###BookShipment -
![image](https://github.com/user-attachments/assets/78195eb6-dbe0-4e9d-ae57-84526fb538c8)

###getShipmentStatus -
![image](https://github.com/user-attachments/assets/ad36d6bf-8084-401a-888f-21f305c195ad)

###updateShipmentEvent -
![image](https://github.com/user-attachments/assets/14a7fdcd-f1f0-47f1-9eb6-036612b11773)

###cancelShipment-
![image](https://github.com/user-attachments/assets/28cd33cc-329d-46cf-b9b5-c5e4d0abcb36)

###getShipmentByShipper -
![image](https://github.com/user-attachments/assets/e894c082-ea24-487f-b8ea-0dc6c7292c07)


## Members
| Name             | N_ID      |
|------------------|-----------|
| Marina Carvalho  | N01606437 |
| Vitaly Sukhinin  | N01605938 |
| Kexin Zhu        | N01621302 |
| Samruddhi Chavan | N01604191 |
| Sruthi Pandiath  | N01618202 |
