package com.sun.ts.tests.jms.core.messageProducer;

import com.sun.ts.tests.jms.core.messageProducer.MessageProducerTests;
import java.net.URL;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OperateOnDeployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.junit5.ArquillianExtension;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.exporter.ZipExporter;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;



@ExtendWith(ArquillianExtension.class)
@Tag("jms")
@Tag("platform")
@Tag("jms_web")
@Tag("web_optional")
@Tag("tck-javatest")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class MessageProducerTestsServletTest extends com.sun.ts.tests.jms.core.messageProducer.MessageProducerTests {
    static final String VEHICLE_ARCHIVE = "messageProducer_servlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        messageProducer_appclient_vehicle: 
        messageProducer_appclient_vehicle_client: META-INF/application-client.xml,jar.sun-application-client.xml
        messageProducer_ejb_vehicle: 
        messageProducer_ejb_vehicle_client: META-INF/application-client.xml,jar.sun-application-client.xml
        messageProducer_ejb_vehicle_ejb: META-INF/ejb-jar.xml,jar.sun-ejb-jar.xml
        messageProducer_jsp_vehicle: 
        messageProducer_jsp_vehicle_web: WEB-INF/web.xml,war.sun-web.xml
        messageProducer_servlet_vehicle: 
        messageProducer_servlet_vehicle_web: WEB-INF/web.xml,war.sun-web.xml

        Found Descriptors:
        War:

        /com/sun/ts/tests/jms/core/messageProducer/servlet_vehicle_web.xml
        /com/sun/ts/tests/common/vehicle/servlet/servlet_vehicle_web.xml
        Ear:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // War
            // the war with the correct archive name
            WebArchive messageProducer_servlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "messageProducer_servlet_vehicle_web.war");
            // The class files
            messageProducer_servlet_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.servlet.ServletVehicle.class,
            com.sun.ts.tests.jms.common.JmsTool.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.jms.core.messageProducer.MessageProducerTests.class
            );
            // The web.xml descriptor
            URL warResURL = MessageProducerTests.class.getResource("/com/sun/ts/tests/common/vehicle/servlet/servlet_vehicle_web.xml");
            if(warResURL != null) {
              messageProducer_servlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = MessageProducerTests.class.getResource("//com/sun/ts/tests/common/vehicle/servlet/servlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              messageProducer_servlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = MessageProducerTests.class.getResource("/com/sun/ts/tests/common/vehicle/servlet/servlet_vehicle_web.xml");
            if(warResURL != null) {
              messageProducer_servlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/servlet_vehicle_web.xml");
            }
            warResURL = MessageProducerTests.class.getResource("/com/sun/ts/tests/jms/core/messageProducer/servlet_vehicle_web.xml");
            if(warResURL != null) {
              messageProducer_servlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/servlet_vehicle_web.xml");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(messageProducer_servlet_vehicle_web, MessageProducerTests.class, warResURL);

        // Ear
            EnterpriseArchive messageProducer_servlet_vehicle_ear = ShrinkWrap.create(EnterpriseArchive.class, "messageProducer_servlet_vehicle.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            messageProducer_servlet_vehicle_ear.addAsModule(messageProducer_servlet_vehicle_web);



            // The application.xml descriptor
            URL earResURL = null;
            // The sun-application.xml descriptor
            earResURL = MessageProducerTests.class.getResource("/.ear.sun-application.xml");
            if(earResURL != null) {
              messageProducer_servlet_vehicle_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(messageProducer_servlet_vehicle_ear, MessageProducerTests.class, earResURL);
        return messageProducer_servlet_vehicle_ear;
        }

        @Test
        @Override
        @TargetVehicle("servlet")
        public void sendQueueTest1() throws java.lang.Exception {
            super.sendQueueTest1();
        }

        @Test
        @Override
        @TargetVehicle("servlet")
        public void sendQueueTest2() throws java.lang.Exception {
            super.sendQueueTest2();
        }

        @Test
        @Override
        @TargetVehicle("servlet")
        public void sendQueueTest3() throws java.lang.Exception {
            super.sendQueueTest3();
        }

        @Test
        @Override
        @TargetVehicle("servlet")
        public void sendTopicTest4() throws java.lang.Exception {
            super.sendTopicTest4();
        }

        @Test
        @Override
        @TargetVehicle("servlet")
        public void sendTopicTest5() throws java.lang.Exception {
            super.sendTopicTest5();
        }

        @Test
        @Override
        @TargetVehicle("servlet")
        public void sendTopicTest6() throws java.lang.Exception {
            super.sendTopicTest6();
        }


}