# Reflect HTTP Integration Example

This repo contains a Java-based example of authoring an HTTP endpoint that the
Reflect agent can talk to in order to service visualization requests. The spec
is originally defined by the [Reflect API
spec](https://gist.github.com/bradhe/cf17f6cea84e36feaa2a94d1e55dfac0).

## Overview

The API exposes two endpoints: A `/fields` endpoint for describing what
attributes to report on and a `/report` endpoint for generating the report
data.

### The `/fields` endpoint

This endpoint just lists all the fields and their expected types that can be
used as metrics and dimensions when issuing a report request. For this example,
the list is hard-coded.

```bash
$ curl -s localhost:4567/fields | json
{
  "SumUnitPrice": "number",
  "RowId": "number",
  "CustomerSegment": "text",
  "OrderPriority": "text",
  "ProductName": "text",
  "ZipCode": "number",
  "SumShippingCost": "number",
  "City": "text",
  "ShipDate": "date",
  "OrderId": "number",
  "OrderDate": "date",
  "OrderQuantity": "number",
  "SumDiscount": "number",
  "SumProfit": "number",
  "ProductSubCategory": "text",
  "ProductContainer": "text",
  "AvgSales": "number",
  "ship_mode": "text",
  "State": "text",
  "ProductCategory": "text",
  "Region": "text",
  "SumSales": "number",
  "CustomerName": "text",
  "AvgProductBaseMargin": "number"
}
```

### The `/report` endpoint

This endpoint is the main integration point for the Reflect agent. It takes
report settings, generates a query to be executed against a database, and
formats the results in the format that the Reflect agent can understand.

```bash
curl -XPOST --data-binary '{
  "dimensions": ["ProductName"],
  "metrics": ["SumUnitPrice"],
  "filters": [
    {
      "field": "Region",
      "op": "=",
      "value": "west"
    }
  ],
  "sort": {
    "field": "SumUnitPrice",
    "direction": "descending"
  }
}' -s localhost:4567/report | json
{
  "results": [
    // ...
  ]
}
```

## Development

### Building the Project

To build this project, you can use maven.

```bash
$ mvn package
```

### Running the Project

The resultant JAR has all the dependencies packaged in to it, so you can run
the jar directly after building it.

```bash
$ java -jar target/reflect-http-integration-example-1.0-jar-with-dependencies.jar
[Thread-0] INFO org.eclipse.jetty.util.log - Logging initialized @236ms to org.eclipse.jetty.util.log.Slf4jLog
[Thread-0] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - == Spark has ignited ...
[Thread-0] INFO spark.embeddedserver.jetty.EmbeddedJettyServer - >> Listening on 0.0.0.0:4567
[Thread-0] INFO org.eclipse.jetty.server.Server - jetty-9.4.z-SNAPSHOT
[Thread-0] INFO org.eclipse.jetty.server.session - DefaultSessionIdManager workerName=node0
[Thread-0] INFO org.eclipse.jetty.server.session - No SessionScavenger set, using defaults
[Thread-0] INFO org.eclipse.jetty.server.session - Scavenging every 600000ms
[Thread-0] INFO org.eclipse.jetty.server.AbstractConnector - Started ServerConnector@4ccdcc4f{HTTP/1.1,[http/1.1]}{0.0.0.0:4567}
[Thread-0] INFO org.eclipse.jetty.server.Server - Started @330ms
```
