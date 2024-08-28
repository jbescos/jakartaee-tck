package ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation;

import ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.Client;
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
@Tag("persistence")
@Tag("platform")
@Tag("web")
@Tag("tck-appclient")

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ClientStateless3Test extends ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.Client {
    static final String VEHICLE_ARCHIVE = "jpa_core_inherit_msc_annotation_stateless3_vehicle";

        /**
        EE10 Deployment Descriptors:
        jpa_core_inherit_msc_annotation: META-INF/persistence.xml
        jpa_core_inherit_msc_annotation_appmanaged_vehicle_client: META-INF/application-client.xml
        jpa_core_inherit_msc_annotation_appmanaged_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_inherit_msc_annotation_appmanagedNoTx_vehicle_client: META-INF/application-client.xml
        jpa_core_inherit_msc_annotation_appmanagedNoTx_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_inherit_msc_annotation_pmservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_inherit_msc_annotation_puservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_inherit_msc_annotation_stateful3_vehicle_client: META-INF/application-client.xml
        jpa_core_inherit_msc_annotation_stateful3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_inherit_msc_annotation_stateless3_vehicle_client: META-INF/application-client.xml
        jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_inherit_msc_annotation_vehicles: 

        Found Descriptors:
        Client:

        /com/sun/ts/tests/common/vehicle/stateless3/stateless3_vehicle_client.xml
        Ejb:

        Ear:

        */
        @TargetsContainer("tck-appclient")
        @OverProtocol("appclient")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // Client
            // the jar with the correct archive name
            JavaArchive jpa_core_inherit_msc_annotation_stateless3_vehicle_client = ShrinkWrap.create(JavaArchive.class, "jpa_core_inherit_msc_annotation_stateless3_vehicle_client.jar");
            // The class files
            jpa_core_inherit_msc_annotation_stateless3_vehicle_client.addClasses(
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
            com.sun.ts.tests.common.vehicle.EmptyVehicleRunner.class,
            ee.jakarta.tck.persistence.common.PMClientBase.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
            com.sun.ts.tests.common.vehicle.stateless3.Stateless3VehicleIF.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.tests.common.vehicle.stateless3.Stateless3VehicleRunner.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The application-client.xml descriptor
            URL resURL = Client.class.getResource("/com/sun/ts/tests/common/vehicle/stateless3/stateless3_vehicle_client.xml");
            if(resURL != null) {
              jpa_core_inherit_msc_annotation_stateless3_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            // The sun-application-client.xml file need to be added or should this be in in the vendor Arquillian extension?
            resURL = Client.class.getResource("//com/sun/ts/tests/common/vehicle/stateless3/stateless3_vehicle_client.jar.sun-application-client.xml");
            if(resURL != null) {
              jpa_core_inherit_msc_annotation_stateless3_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            jpa_core_inherit_msc_annotation_stateless3_vehicle_client.addAsManifestResource(new StringAsset("Main-Class: com.sun.ts.tests.common.vehicle.VehicleClient\n"), "MANIFEST.MF");
            // Call the archive processor
            archiveProcessor.processClientArchive(jpa_core_inherit_msc_annotation_stateless3_vehicle_client, Client.class, resURL);

        // Ejb 1
            // the jar with the correct archive name
            JavaArchive jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb = ShrinkWrap.create(JavaArchive.class, "jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb.jar");
            // The class files
            jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb.addClasses(
                com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareBaseBean.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
                com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
                com.sun.ts.lib.harness.EETest.Fault.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
                ee.jakarta.tck.persistence.common.PMClientBase.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.Client.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
                com.sun.ts.tests.common.vehicle.stateless3.Stateless3VehicleBean.class,
                com.sun.ts.tests.common.vehicle.stateless3.Stateless3VehicleIF.class,
                com.sun.ts.lib.harness.EETest.class,
                com.sun.ts.lib.harness.ServiceEETest.class,
                com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
                com.sun.ts.lib.harness.EETest.SetupException.class,
                com.sun.ts.tests.common.vehicle.VehicleClient.class,
                com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The ejb-jar.xml descriptor
            URL ejbResURL1 = Client.class.getResource("//vehicle/stateless3/stateless3_vehicle_ejb.xml");
            if(ejbResURL1 != null) {
              jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb.addAsManifestResource(ejbResURL1, "ejb-jar.xml");
            }
            // The sun-ejb-jar.xml file
            ejbResURL1 = Client.class.getResource("//vehicle/stateless3/stateless3_vehicle_ejb.jar.sun-ejb-jar.xml");
            if(ejbResURL1 != null) {
              jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb.addAsManifestResource(ejbResURL1, "sun-ejb-jar.xml");
            }
            // Call the archive processor
            archiveProcessor.processEjbArchive(jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb, Client.class, ejbResURL1);


        // Par
            // the jar with the correct archive name
            JavaArchive jpa_core_inherit_msc_annotation = ShrinkWrap.create(JavaArchive.class, "jpa_core_inherit_msc_annotation.jar");
            // The class files
            jpa_core_inherit_msc_annotation.addClasses(
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.Project.class,
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.AbstractPersonnel.class,
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.Department.class,
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.Employee.class,
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.FullTimeEmployee.class,
                ee.jakarta.tck.persistence.core.inheritance.mappedsc.annotation.PartTimeEmployee.class
            );
            // The persistence.xml descriptor
            URL parURL = Client.class.getResource("persistence.xml");
            if(parURL != null) {
              jpa_core_inherit_msc_annotation.addAsManifestResource(parURL, "persistence.xml");
            }
            // Call the archive processor
            archiveProcessor.processParArchive(jpa_core_inherit_msc_annotation, Client.class, parURL);
            // The orm.xml file
            parURL = Client.class.getResource("orm.xml");
            if(parURL != null) {
              jpa_core_inherit_msc_annotation.addAsManifestResource(parURL, "orm.xml");
            }

        // Ear
            EnterpriseArchive jpa_core_inherit_msc_annotation_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_inherit_msc_annotation_vehicles.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jpa_core_inherit_msc_annotation_vehicles_ear.addAsModule(jpa_core_inherit_msc_annotation_stateless3_vehicle_ejb);
            jpa_core_inherit_msc_annotation_vehicles_ear.addAsModule(jpa_core_inherit_msc_annotation_stateless3_vehicle_client);

            jpa_core_inherit_msc_annotation_vehicles_ear.addAsLibrary(jpa_core_inherit_msc_annotation);



            // The application.xml descriptor
            URL earResURL = null;
            // The sun-application.xml descriptor
            earResURL = Client.class.getResource("/.ear.sun-application.xml");
            if(earResURL != null) {
              jpa_core_inherit_msc_annotation_vehicles_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(jpa_core_inherit_msc_annotation_vehicles_ear, Client.class, earResURL);
        return jpa_core_inherit_msc_annotation_vehicles_ear;
        }

        @Test
        @Override
        @TargetVehicle("stateless3")
        public void test1() throws java.lang.Exception {
            super.test1();
        }

        @Test
        @Override
        @TargetVehicle("stateless3")
        public void test2() throws java.lang.Exception {
            super.test2();
        }


}