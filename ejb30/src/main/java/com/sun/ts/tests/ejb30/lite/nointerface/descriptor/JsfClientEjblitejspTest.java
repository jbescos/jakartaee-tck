package com.sun.ts.tests.ejb30.lite.nointerface.descriptor;

import com.sun.ts.tests.ejb30.lite.nointerface.descriptor.JsfClient;
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
public class JsfClientEjblitejspTest extends com.sun.ts.tests.ejb30.lite.nointerface.descriptor.JsfClient {
    static final String VEHICLE_ARCHIVE = "ejblite_nointerface_descriptor_ejblitejsp_vehicle";

        /**
        EE10 Deployment Descriptors:
        ejblite_nointerface_descriptor_ejblitejsf_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/beans.xml,WEB-INF/faces-config.xml,WEB-INF/web.xml
        ejblite_nointerface_descriptor_ejblitejsp_vehicle_web: WEB-INF/ejb-jar.xml
        ejblite_nointerface_descriptor_ejbliteservlet_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml
        ejblite_nointerface_descriptor_ejbliteservlet2_vehicle_web: WEB-INF/ejb-jar.xml,WEB-INF/web.xml

        Found Descriptors:
        War:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static WebArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {

        // War
            // the war with the correct archive name
            WebArchive ejblite_nointerface_descriptor_ejblitejsp_vehicle_web = ShrinkWrap.create(WebArchive.class, "ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.war");
            // The class files
            ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addClasses(
            com.sun.ts.tests.ejb30.lite.nointerface.annotated.BeanBase.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.JsfClient.class,
            com.sun.ts.tests.ejb30.lite.nointerface.annotated.HasInterface.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.ejb30.lite.nointerface.annotated.ClientBase.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.NoInterfaceStatefulBean.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.ejb30.lite.nointerface.annotated.JsfClientBase.class,
            com.sun.ts.tests.ejb30.common.helper.Helper.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteClientBase.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.HasInterfaceSingletonBean.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.NoInterfaceStatelessBean.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.ejb30.common.lite.NumberIF.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.EJBLiteClientIF.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.Client.class,
            com.sun.ts.tests.common.vehicle.ejbliteshare.ReasonableStatus.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.NoInterfaceSingletonBean.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.HttpServletDelegate.class,
            com.sun.ts.tests.ejb30.common.lite.NumberEnum.class,
            com.sun.ts.tests.ejb30.lite.nointerface.descriptor.EJBLiteJSPTag.class,
            com.sun.ts.tests.ejb30.common.lite.EJBLiteJsfClientBase.class,
            com.sun.ts.tests.ejb30.common.helper.ServiceLocator.class,
            com.sun.ts.lib.harness.EETest.SetupException.class
            );
            // The web.xml descriptor
            URL warResURL = JsfClient.class.getResource("/vehicle/ejblitejsp/ejblitejsp_vehicle_web.xml");
            if(warResURL != null) {
              ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = JsfClient.class.getResource("//vehicle/ejblitejsp/ejblitejsp_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }

            // Any libraries added to the war

            // Web content
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb30/lite/nointerface/descriptor/ejb-jar.xml");
            if(warResURL != null) {
              ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/ejb-jar.xml");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/ejb30/lite/nointerface/descriptor/ejblitejsp.tld");
            if(warResURL != null) {
              ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/tlds/ejblitejsp.tld");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejblitejsp/ejblitejsp.tld");
            if(warResURL != null) {
              ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/ejblitejsp.tld");
            }
            warResURL = JsfClient.class.getResource("/com/sun/ts/tests/common/vehicle/ejblitejsp/ejblitejsp_vehicle.jsp");
            if(warResURL != null) {
              ejblite_nointerface_descriptor_ejblitejsp_vehicle_web.addAsWebResource(warResURL, "/ejblitejsp_vehicle.jsp");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(ejblite_nointerface_descriptor_ejblitejsp_vehicle_web, JsfClient.class, warResURL);

        return ejblite_nointerface_descriptor_ejblitejsp_vehicle_web;
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void nonBusinessMethods() {
            super.nonBusinessMethods();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void invokeRemovedStateful() {
            super.invokeRemovedStateful();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void passAsParam() {
            super.passAsParam();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void passAsReturn() {
            super.passAsReturn();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void passEnumAsParams() {
            super.passEnumAsParams();
        }

        @Test
        @Override
        @TargetVehicle("ejblitejsp")
        public void passEnumAsReturn() {
            super.passEnumAsReturn();
        }


}