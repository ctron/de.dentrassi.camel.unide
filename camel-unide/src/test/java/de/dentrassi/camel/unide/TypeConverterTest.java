package de.dentrassi.camel.unide;

import java.io.IOException;
import java.io.InputStream;

import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.camel.util.IOHelper;
import org.eclipse.iot.unide.ppmp.measurements.MeasurementsWrapper;
import org.eclipse.iot.unide.ppmp.messages.MessagesWrapper;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;
import org.junit.Assert;
import org.junit.Test;

public class TypeConverterTest extends CamelTestSupport {

    @Test
    public void testMeasurements1() throws IOException {
        final MeasurementsWrapper value = testConvert("/measurement.json", MeasurementsWrapper.class);

        Assert.assertNotNull(value);
        Assert.assertEquals("urn:spec://eclipse.org/unide/measurement-message#v2", value.getContentSpec());

        Assert.assertNotNull(value.getDevice());
        Assert.assertEquals("a4927dad-58d4-4580-b460-79cefd56775b", value.getDevice().getDeviceID());

    }

    @Test
    public void testProcess1() throws IOException {
        final ProcessWrapper value = testConvert("/process.json", ProcessWrapper.class);

        Assert.assertNotNull(value);
        Assert.assertEquals("urn:spec://eclipse.org/unide/process-message#v2", value.getContentSpec());

        Assert.assertNotNull(value.getDevice());
        Assert.assertEquals("a4927dad-58d4-4580-b460-79cefd56775b", value.getDevice().getDeviceID());
    }

    @Test
    public void testMessage1() throws IOException {
        final MessagesWrapper value = testConvert("/message.json", MessagesWrapper.class);

        Assert.assertNotNull(value);
        Assert.assertEquals("urn:spec://eclipse.org/unide/machine-message#v2", value.getContentSpec());

        Assert.assertNotNull(value.getDevice());
        Assert.assertEquals("2ca5158b-8350-4592-bff9-755194497d4e", value.getDevice().getDeviceID());
    }

    private <T> T testConvert(final String name, final Class<T> clazz) throws IOException {
        try (InputStream in = TypeConverterTest.class.getResourceAsStream(name)) {
            return this.context.getTypeConverter().convertTo(clazz, IOHelper.loadText(in));
        }

    }

}
