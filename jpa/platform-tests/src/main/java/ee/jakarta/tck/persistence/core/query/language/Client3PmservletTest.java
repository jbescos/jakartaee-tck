package ee.jakarta.tck.persistence.core.query.language;

import ee.jakarta.tck.persistence.core.query.language.Client3;
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
@Tag("tck-javatest")

public class Client3PmservletTest extends ee.jakarta.tck.persistence.core.query.language.Client3 {
    static final String VEHICLE_ARCHIVE = "jpa_core_query_language_pmservlet_vehicle";

        /**
        EE10 Deployment Descriptors:
        jpa_core_query_language: META-INF/persistence.xml
        jpa_core_query_language_appmanaged_vehicle_client: META-INF/application-client.xml
        jpa_core_query_language_appmanaged_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_query_language_appmanagedNoTx_vehicle_client: META-INF/application-client.xml
        jpa_core_query_language_appmanagedNoTx_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_query_language_pmservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_query_language_puservlet_vehicle_web: WEB-INF/web.xml
        jpa_core_query_language_stateful3_vehicle_client: META-INF/application-client.xml
        jpa_core_query_language_stateful3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_query_language_stateless3_vehicle_client: META-INF/application-client.xml
        jpa_core_query_language_stateless3_vehicle_ejb: jar.sun-ejb-jar.xml
        jpa_core_query_language_vehicles: 

        Found Descriptors:
        War:

        /com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.xml
        Ear:

        */
        @TargetsContainer("tck-javatest")
        @OverProtocol("javatest")
        @Deployment(name = VEHICLE_ARCHIVE, order = 2)
        public static EnterpriseArchive createDeploymentVehicle(@ArquillianResource TestArchiveProcessor archiveProcessor) {
        // War
            // the war with the correct archive name
            WebArchive jpa_core_query_language_pmservlet_vehicle_web = ShrinkWrap.create(WebArchive.class, "jpa_core_query_language_pmservlet_vehicle_web.war");
            // The class files
            jpa_core_query_language_pmservlet_vehicle_web.addClasses(
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareBaseBean.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnerFactory.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManager.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EJB3ShareIF.class,
            com.sun.ts.lib.harness.EETest.Fault.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UseEntityManagerFactory.class,
            ee.jakarta.tck.persistence.common.PMClientBase.class,
            ee.jakarta.tck.persistence.core.query.language.Client3.class,
            com.sun.ts.tests.common.vehicle.servlet.ServletVehicle.class,
            ee.jakarta.tck.persistence.common.schema30.Util.class,
            com.sun.ts.tests.common.vehicle.VehicleRunnable.class,
            com.sun.ts.tests.common.vehicle.ejb3share.UserTransactionWrapper.class,
            com.sun.ts.lib.harness.EETest.class,
            com.sun.ts.lib.harness.ServiceEETest.class,
            com.sun.ts.tests.common.vehicle.ejb3share.EntityTransactionWrapper.class,
            com.sun.ts.tests.common.vehicle.pmservlet.PMServletVehicle.class,
            com.sun.ts.lib.harness.EETest.SetupException.class,
            com.sun.ts.tests.common.vehicle.VehicleClient.class,
            com.sun.ts.tests.common.vehicle.ejb3share.NoopTransactionWrapper.class
            );
            // The web.xml descriptor
            URL warResURL = Client3.class.getResource("/com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.xml");
            if(warResURL != null) {
              jpa_core_query_language_pmservlet_vehicle_web.addAsWebInfResource(warResURL, "web.xml");
            }
            // The sun-web.xml descriptor
            warResURL = Client3.class.getResource("//com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.war.sun-web.xml");
            if(warResURL != null) {
              jpa_core_query_language_pmservlet_vehicle_web.addAsWebInfResource(warResURL, "sun-web.xml");
            }
            // Web content
            warResURL = Client3.class.getResource("/com/sun/ts/tests/jpa/core/query/language/jpa_core_query_language.jar");
            if(warResURL != null) {
              jpa_core_query_language_pmservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/lib/jpa_core_query_language.jar");
            }
            warResURL = Client3.class.getResource("/com/sun/ts/tests/common/vehicle/pmservlet/pmservlet_vehicle_web.xml");
            if(warResURL != null) {
              jpa_core_query_language_pmservlet_vehicle_web.addAsWebResource(warResURL, "/WEB-INF/pmservlet_vehicle_web.xml");
            }

           // Call the archive processor
           archiveProcessor.processWebArchive(jpa_core_query_language_pmservlet_vehicle_web, Client3.class, warResURL);

        // Par
            // the jar with the correct archive name
            JavaArchive jpa_core_query_language = ShrinkWrap.create(JavaArchive.class, "jpa_core_query_language.jar");
            // The class files
            jpa_core_query_language.addClasses(
                ee.jakarta.tck.persistence.common.schema30.Department.class,
                ee.jakarta.tck.persistence.common.schema30.Trim.class,
                ee.jakarta.tck.persistence.common.schema30.CreditCard.class,
                ee.jakarta.tck.persistence.common.schema30.Info.class,
                ee.jakarta.tck.persistence.common.schema30.SoftwareProduct.class,
                ee.jakarta.tck.persistence.common.schema30.Product.class,
                ee.jakarta.tck.persistence.common.schema30.Phone.class,
                ee.jakarta.tck.persistence.common.schema30.Spouse.class,
                ee.jakarta.tck.persistence.common.schema30.LineItem.class,
                ee.jakarta.tck.persistence.common.schema30.Employee.class,
                ee.jakarta.tck.persistence.common.schema30.ShelfLife.class,
                ee.jakarta.tck.persistence.common.schema30.Customer.class,
                ee.jakarta.tck.persistence.common.schema30.Address.class,
                ee.jakarta.tck.persistence.common.schema30.Alias.class,
                ee.jakarta.tck.persistence.common.schema30.Order.class,
                ee.jakarta.tck.persistence.common.schema30.HardwareProduct.class,
                ee.jakarta.tck.persistence.common.schema30.LineItemException.class,
                ee.jakarta.tck.persistence.common.schema30.Country.class
            );
            // The persistence.xml descriptor
            URL parURL = Client3.class.getResource("persistence.xml");
            if(parURL != null) {
              jpa_core_query_language.addAsManifestResource(parURL, "persistence.xml");
            }
            // Call the archive processor
            archiveProcessor.processParArchive(jpa_core_query_language, Client3.class, parURL);
            // The orm.xml file
            parURL = Client3.class.getResource("orm.xml");
            if(parURL != null) {
              jpa_core_query_language.addAsManifestResource(parURL, "orm.xml");
            }

        // Ear
            EnterpriseArchive jpa_core_query_language_vehicles_ear = ShrinkWrap.create(EnterpriseArchive.class, "jpa_core_query_language_vehicles.ear");

            // Any libraries added to the ear

            // The component jars built by the package target
            jpa_core_query_language_vehicles_ear.addAsModule(jpa_core_query_language_pmservlet_vehicle_web);

            jpa_core_query_language_vehicles_ear.addAsLibrary(jpa_core_query_language);



            // The application.xml descriptor
            URL earResURL = Client3.class.getResource("/com/sun/ts/tests/jpa/core/query/language/");
            if(earResURL != null) {
              jpa_core_query_language_vehicles_ear.addAsManifestResource(earResURL, "application.xml");
            }
            // The sun-application.xml descriptor
            earResURL = Client3.class.getResource("/com/sun/ts/tests/jpa/core/query/language/.ear.sun-application.xml");
            if(earResURL != null) {
              jpa_core_query_language_vehicles_ear.addAsManifestResource(earResURL, "sun-application.xml");
            }
            // Call the archive processor
            archiveProcessor.processEarArchive(jpa_core_query_language_vehicles_ear, Client3.class, earResURL);
        return jpa_core_query_language_vehicles_ear;
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest3() throws java.lang.Exception {
            super.queryTest3();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest20() throws java.lang.Exception {
            super.queryTest20();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest21() throws java.lang.Exception {
            super.queryTest21();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest24() throws java.lang.Exception {
            super.queryTest24();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest25() throws java.lang.Exception {
            super.queryTest25();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest26() throws java.lang.Exception {
            super.queryTest26();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest28() throws java.lang.Exception {
            super.queryTest28();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest29() throws java.lang.Exception {
            super.queryTest29();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest30() throws java.lang.Exception {
            super.queryTest30();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest31() throws java.lang.Exception {
            super.queryTest31();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest49() throws java.lang.Exception {
            super.queryTest49();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest50() throws java.lang.Exception {
            super.queryTest50();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest52() throws java.lang.Exception {
            super.queryTest52();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void queryTest53() throws java.lang.Exception {
            super.queryTest53();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void test_leftouterjoin_MxM() throws java.lang.Exception {
            super.test_leftouterjoin_MxM();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void test_upperStringExpression() throws java.lang.Exception {
            super.test_upperStringExpression();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void test_lowerStringExpression() throws java.lang.Exception {
            super.test_lowerStringExpression();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void test_innerjoin_MxM() throws java.lang.Exception {
            super.test_innerjoin_MxM();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void test_fetchjoin_MxM() throws java.lang.Exception {
            super.test_fetchjoin_MxM();
        }

        @Test
        @Override
        @TargetVehicle("pmservlet")
        public void test_substringHavingClause() throws java.lang.Exception {
            super.test_substringHavingClause();
        }


}