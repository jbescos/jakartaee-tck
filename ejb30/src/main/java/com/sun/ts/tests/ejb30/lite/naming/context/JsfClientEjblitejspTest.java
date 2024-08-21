package com.sun.ts.tests.ejb30.lite.naming.context;

import com.sun.ts.tests.ejb30.lite.naming.context.JsfClient;
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
@Tag("platform")
@Tag("ejb_web")
@Tag("web")
@Tag("tck-javatest")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class JsfClientEjblitejspTest extends com.sun.ts.tests.ejb30.lite.naming.context.JsfClient {
    static final String VEHICLE_ARCHIVE = "ejblite_naming_context_ejblitejsp_vehicle";

        /**
        EE10 Deployment Descriptors:
        ejblite_naming_context_ejblitejsf_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/beans.xml,WEB-INF/faces-config.xml,WEB-INF/web.xml
        ejblite_naming_context_ejblitejsp_vehicle_web: WEB-INF/ejb-jar.xml
        ejblite_naming_context_ejbliteservlet_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml
        ejblite_naming_context_ejbliteservlet2_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml

        Found Descriptors:
        War:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static WebArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {

        // War
            // the war with the correct archive name
            WebArchive ejblite_naming_context_ejblitejsp_vehicle_web = ShrinkWrap.create(WebArchive.class, "ejblite_naming_context_ejblitejsp_vehicle_web.war");
            // The class files
            ejblite_naming_context_ejblitejsp_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.ejbliteshare.EJBLiteClientIF.class,
            com.sun.ts.tests.ejb30.common.helper.TestFailedException.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb30.lite.naming.context.JsfClient.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.ReasonableStatus.class,
            com.sun.ts.tests.ejb30.lite.naming.context.EJBLiteJSPTag.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.ejb30.common.lite.NumberEnum.class,
            com.sun.ts.tests.ejb30.common.helper.Helper.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteClientBase.class,
            com.sun.ts.tests.ejb30.lite.naming.context.Test.class,
            com.sun.ts.tests.ejb30.lite.naming.context.HttpServletDelegate.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteJsfClientBase.class,
            com.sun.ts.tests.ejb30.lite.naming.context.Client.class,
            com.sun.ts.tests.ejb30.lite.naming.context.TestBean.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.ejb30.common.lite.NumberIF.class
            );
            // The web.xml descriptor
            URL warResURL = JsfClient.class.getResource("/vehicle/ejblitejsp/ejblitejsp_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_naming_context_ejblitejsp_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = JsfClient.class.getResource("//vehicle/ejblitejsp/ejblitejsp_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              ejblite_naming_context_ejblitejsp_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb30/lite/naming/context/ejb-jar.xml");
            if(warResURL != null) {
              ejblite_naming_context_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/ejb-jar.xml");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb30/lite/naming/context/ejblitejsp.tld");
            if(warResURL != null) {
              ejblite_naming_context_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/tlds/ejblitejsp.tld");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejblitejsp/ejblitejsp.tld");
            if(warResURL != null) {
              ejblite_naming_context_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/ejblitejsp.tld");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejblitejsp/ejblitejsp_vehicle.jsp");
            if(warResURL != null) {
              ejblite_naming_context_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/ejblitejsp_vehicle.jsp");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(ejblite_naming_context_ejblitejsp_vehicle_web, JsfClient.class, warResURL);

        return ejblite_naming_context_ejblitejsp_vehicle_web;
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void getEnvironment() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.getEnvironment();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void bind() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.bind();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void rebind() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.rebind();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void unbind() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.unbind();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void rename() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.rename();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void close() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.close();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void createSubcontext() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.createSubcontext();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void destroySubcontext() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.destroySubcontext();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void lookup() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.lookup();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void list() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.list();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void listBindings() throws javax.naming.NamingException, com.sun.ts.tests.ejb30.common.helper.TestFailedException {
            super.listBindings();
        }


}