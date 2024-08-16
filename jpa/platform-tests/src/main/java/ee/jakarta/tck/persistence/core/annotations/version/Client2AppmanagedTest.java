package ee.jakarta.tck.persistence.core.annotations.version;

import ee.jakarta.tck.persistence.core.annotations.version.Client2;
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
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;



@ExtendWith(ArquillianExtension.class)
@Tag("persistence")
@Tag("platform")
@Tag("web")
@Tag("tck-appclient")

public class Client2AppmanagedTest extends ee.jakarta.tck.persistence.core.annotations.version.Client2 {
    static final String VEHICLE_ARCHIVE = "jpa_core_annotations_version_appmanaged_vehicle";

        /**
        EE10 Deployment Descriptors:
        jpa_core_annotations_version: META-INF/persistence.xml
        jpa_core_annotations_version_appmanaged_vehicle_client: META-INF/application-client.xml
        jpa_core_annotations_version_appmanaged_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_annotations_version_appmanagedNoTx_vehicle_client: META-INF/application-client.xml
        jpa_core_annotations_version_appmanagedNoTx_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_annotations_version_pmservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_annotations_version_puservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_annotations_version_stateful3_vehicle_client: META-INF/application-client.xml
        jpa_core_annotations_version_stateful3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_annotations_version_stateless3_vehicle_client: META-INF/application-client.xml
        jpa_core_annotations_version_stateless3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_annotations_version_vehicles: 

        Found Descriptors:
        Client:

        /com/sun/ts/tests/common/vehicle/appmanaged/appmanaged_vehicle_client.xml
        Ejb:

        Ear:

        */
        @TargetsContainer("tck-appclient")
        @OverProtocol("appclient")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // Client
            // the jar with the correct archive name
            JavaArchive jpa_core_annotations_version_appmanaged_vehicle_client = ShrinkWrap.create(JavaArchive.class, "jpa_core_annotations_version_appmanaged_vehicle_client.jar");
            // The class files
            jpa_core_annotations_version_appmanaged_vehicle_client.addClasses(
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleIF.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
            com.sun.ts.tests.common.vehicle.EmptyVehicleRunner.class,
            ee.jakarta.tck.persistence.common.PMClientBase.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleRunner.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The application-client.xml descriptor
            URL resURL = Client2.class.getResource("/com/sun/ts/tests/common/vehicle/appmanaged/appmanaged_vehicle_client.xml");
            if(resURL != null) {
              jpa_core_annotations_version_appmanaged_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            // The sun-application-client.xml file need to be added or should this be in in the vendor Arquillian extension?
            resURL = Client2.class.getResource("//com/sun/ts/tests/common/vehicle/appmanaged/appmanaged_vehicle_client.jar.sun-application-client.xml");
            if(resURL != null) {
              jpa_core_annotations_version_appmanaged_vehicle_client.addAsManifestResource(resURL, "application-client.xml");
            }
            jpa_core_annotations_version_appmanaged_vehicle_client.addAsManifestResource(new StringAsset("Main-Class: " + Client2.class.getName() + "\n"), "MANIFEST.MF");
            // Call the archive processor
            archiveProcessor.processClientArchive(jpa_core_annotations_version_appmanaged_vehicle_client, Client2.class, resURL);

        // Ejb
            // the jar with the correct archive name
            JavaArchive jpa_core_annotations_version_appmanaged_vehicle_ejb = ShrinkWrap.create(JavaArchive.class, "jpa_core_annotations_version_appmanaged_vehicle_ejb.jar");
            // The class files
            jpa_core_annotations_version_appmanaged_vehicle_ejb.addClasses(
                com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareBaseBean.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
                com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
                com.sun.ts.lib.harness.EETest.Fault.class,
                com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleIF.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
                ee.jakarta.tck.persistence.common.PMClientBase.class,
                com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
                com.sun.ts.tests.common.vehicle.appmanaged.AppManagedVehicleBean.class,
                com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
                com.sun.ts.lib.harness.EETest.class,
                com.sun.ts.lib.harness.ServiceEETest.class,
                com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
                com.sun.ts.lib.harness.EETest.SetupException.class,
                com.sun.ts.tests.common.vehicle.VehicleClient.class,
                com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class,
                ee.jakarta.tck.persistence.core.annotations.version.Client2.class
            );
            // The ejb-jar.xml descriptor
            URL ejbResURL = Client2.class.getResource("//vehicle/appmanaged/appmanaged_vehicle_ejb.xml");
            if(ejbResURL != null) {
              jpa_core_annotations_version_appmanaged_vehicle_ejb.addAsManifestResource(ejbResURL, "ejb-jar.xml");
            }
            // The sun-ejb-jar.xml file
            ejbResURL = Client2.class.getResource("//vehicle/appmanaged/appmanaged_vehicle_ejb.jar.sun-ejb-jar.xml");
            if(ejbResURL != null) {
              jpa_core_annotations_version_appmanaged_vehicle_ejb.addAsManifestResource(ejbResURL, "sun-ejb-jar.xml");
            }
            // Call the archive processor
            archiveProcessor.processEjbArchive(jpa_core_annotations_version_appmanaged_vehicle_ejb, Client2.class, ejbResURL);

        // Par
            // the jar with the correct archive name
            JavaArchive jpa_core_annotations_version = ShrinkWrap.create(JavaArchive.class, "jpa_core_annotations_version.jar");
            // The class files
            jpa_core_annotations_version.addClasses(
                ee.jakarta.tck.persistence.core.annotations.version.Short_Property.class,
                ee.jakarta.tck.persistence.core.annotations.version.Integer_Property.class,
                ee.jakarta.tck.persistence.core.annotations.version.LongClass_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.Timestamp_Property.class,
                ee.jakarta.tck.persistence.core.annotations.version.ShortClass_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.Long_Property.class,
                ee.jakarta.tck.persistence.core.annotations.version.LongClass_Property.class,
                ee.jakarta.tck.persistence.core.annotations.version.Timestamp_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.Short_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.Long_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.ShortClass_Property.class,
                ee.jakarta.tck.persistence.core.annotations.version.Integer_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.Int_Field.class,
                ee.jakarta.tck.persistence.core.annotations.version.Int_Property.class
            );
            // The persistence.xml descriptor
            URL parURL = Client2.class.getResource("persistence.xml");
            if(parURL != null) {
              jpa_core_annotations_version.addAsManifestResource(parURL, "persistence.xml");
            }
            // Call the archive processor
            archiveProcessor.processParArchive(jpa_core_annotations_version, Client2.class, parURL);
            // The orm.xml file
            parURL = Client2.class.getResource("orm.xml");
            if(parURL != null) {
              jpa_core_annotations_version.addAsManifestResource(parURL, "orm.xml");
            }

        // Ear
            EnterpriseArchive jpa_core_annotations_version_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_annotations_version_vehicles.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jpa_core_annotations_version_vehicles_ear.addAsModule(jpa_core_annotations_version_appmanaged_vehicle_ejb);
            jpa_core_annotations_version_vehicles_ear.addAsModule(jpa_core_annotations_version_appmanaged_vehicle_client);

            jpa_core_annotations_version_vehicles_ear.addAsLibrary(jpa_core_annotations_version);



            // The application.xml descriptor
            URL earResURL = Client2.class.getResource("/com/sun/ts/tests/jpa/core/annotations/version/");
            if(earResURL != null) {
              jpa_core_annotations_version_vehicles_ear.addAsManifestResource(earResURL, "application.xml");
            }
            // The sun-application.xml descriptor
            earResURL = Client2.class.getResource("/com/sun/ts/tests/jpa/core/annotations/version/.ear.sun-application.xml");
            if(earResURL != null) {
              jpa_core_annotations_version_vehicles_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(jpa_core_annotations_version_vehicles_ear, Client2.class, earResURL);
        return jpa_core_annotations_version_vehicles_ear;
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void shortFieldTest() throws java.lang.Exception {
            super.shortFieldTest();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void shortPropertyTest() throws java.lang.Exception {
            super.shortPropertyTest();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void shortClassFieldTest() throws java.lang.Exception {
            super.shortClassFieldTest();
        }

        @Test
        @Override
        @TargetVehicle("appmanaged")
        public void shortClassPropertyTest() throws java.lang.Exception {
            super.shortClassPropertyTest();
        }


}