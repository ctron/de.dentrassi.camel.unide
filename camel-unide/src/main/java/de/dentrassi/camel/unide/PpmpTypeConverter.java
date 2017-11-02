/*
 * Copyright (C) 2017 Jens Reimann <jreimann@redhat.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package de.dentrassi.camel.unide;

import java.io.IOException;

import org.apache.camel.Converter;
import org.apache.camel.TypeConverters;
import org.eclipse.iot.unide.ppmp.PPMPPackager;
import org.eclipse.iot.unide.ppmp.measurements.MeasurementsWrapper;
import org.eclipse.iot.unide.ppmp.messages.MessagesWrapper;
import org.eclipse.iot.unide.ppmp.process.ProcessWrapper;

@Converter
public final class PpmpTypeConverter implements TypeConverters {

    private static final PPMPPackager PACKAGER = new PPMPPackager();

    private PpmpTypeConverter() {
    }

    @Converter
    public static MeasurementsWrapper parseMeasurements(final String json) throws IOException {
        return PACKAGER.getMeasurementsBean(json);
    }

    @Converter
    public static ProcessWrapper parseProcesses(final String json) throws IOException {
        return PACKAGER.getProcessesBean(json);
    }

    @Converter
    public static MessagesWrapper parseMessages(final String json) throws IOException {
        return PACKAGER.getMessagesBean(json);
    }

    @Converter
    public static String toStringMeasurements(final MeasurementsWrapper measurements) throws IOException {
        return PACKAGER.getMessage(measurements);
    }

    @Converter
    public static String toStringProcess(final ProcessWrapper process) throws IOException {
        return PACKAGER.getMessage(process);
    }

    @Converter
    public static String toStringMessages(final MessagesWrapper messages) throws IOException {
        return PACKAGER.getMessage(messages);
    }

}
