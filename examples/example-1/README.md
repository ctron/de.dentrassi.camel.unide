# Camel Example #1

This example shows how to use `camel-unide` in order to create a REST to MQTT bridge.

The example can be started by running:

    mvn camel:run

And then sending HTTP requests to the local port 8181 like this:

    curl -X POST -H "Content-Type: application/json" -d @camel-unide/src/test/resources/measurement.json http://localhost:8181/ppmp/measurement

## Description

This example creates a REST endpoint `/ppmp` on port 8181 on the local machine. Under this endpoint
there are three child-endpoints `measurement`, `process` and `message` which each can receive a JSON
request of the appropriate PPMP type.

All three endpoints are mapped to Camel routes which parse the message with their appropriate type and
then extract the device ID, setting this in the message header.

The final step is to publish this on some device specific MQTT topic on `iot.eclipse.org`, with
pattern on `/ppmp/<device-id>/<measurement|message|process>`. The different message types will
use different QoS, defaulting to QoS 1, but switching to QoS for measurements.

So in a nutshell this is a bridge from REST to MQTT which extracts the device ID and forwards
messages to a device ID specific topic.
