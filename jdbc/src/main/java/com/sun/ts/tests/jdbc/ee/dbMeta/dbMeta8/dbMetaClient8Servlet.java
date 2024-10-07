/*
 * Copyright (c) 2007, 2020 Oracle and/or its affiliates. All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v. 2.0, which is available at
 * http://www.eclipse.org/legal/epl-2.0.
 *
 * This Source Code may also be made available under the following Secondary
 * Licenses when the conditions for such availability set forth in the
 * Eclipse Public License v. 2.0 are satisfied: GNU General Public License,
 * version 2 with the GNU Classpath Exception, which is available at
 * https://www.gnu.org/software/classpath/license.html.
 *
 * SPDX-License-Identifier: EPL-2.0 OR GPL-2.0 WITH Classpath-exception-2.0
 */

/*
 * @(#)dbMetaClient8.java	1.28 03/05/16
 */

package com.sun.ts.tests.jdbc.ee.dbMeta.dbMeta8;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.sun.ts.lib.harness.Status;

import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;

// Merant DataSource class
//import com.merant.sequelink.jdbcx.datasource.*;

/**
 * The dbMetaClient8 class tests methods of DatabaseMetaData interface using
 * Sun's J2EE Reference Implementation.
 * 
 * @author
 * @version 1.7, 06/16/99
 */

@Tag("tck-javatest")

public class dbMetaClient8Servlet extends dbMetaClient8 implements Serializable {
  private static final String testName = "jdbc.ee.dbMeta.dbMeta8";
  
  @TargetsContainer("tck-javatest")
  @OverProtocol("javatest")
	@Deployment(name = "servlet", testable = true)
	public static WebArchive createDeploymentservlet(@ArquillianResource TestArchiveProcessor archiveProcessor) throws IOException {
		WebArchive archive = ShrinkWrap.create(WebArchive.class, "dbMeta8_servlet_vehicle_web.war");
		archive.addPackages(true, "com.sun.ts.tests.jdbc.ee.common");
		archive.addPackages(false, "com.sun.ts.tests.common.vehicle");
		archive.addPackages(false, "com.sun.ts.tests.common.vehicle.servlet");
		archive.addPackages(true, "com.sun.ts.lib.harness");
		archive.addClasses(dbMetaClient8Servlet.class, dbMetaClient8.class);
	       // The servlet descriptor
URL servletUrl = dbMetaClient8Servlet.class.getResource("servlet_vehicle_web.xml");
if(servletUrl != null) {
	archive.addAsWebInfResource(servletUrl, "web.xml");
}
// The sun servlet descriptor
URL sunServletUrl = dbMetaClient8Servlet.class.getResource("dbMeta8_servlet_vehicle_web.war.sun-web.xml");
if(sunServletUrl != null) {
	archive.addAsWebInfResource(sunServletUrl, "sun-web.xml");
}
// Call the archive processor
archiveProcessor.processWebArchive(archive, dbMetaClient8Servlet.class, sunServletUrl);
		
		return archive;
	};


  /* Run test in standalone mode */
  public static void main(String[] args) {
    dbMetaClient8Servlet theTests = new dbMetaClient8Servlet();
    Status s = theTests.run(args, System.out, System.err);
    s.exit();
  }

  /*
   * @testName: testDoesMaxRowSizeIncludeBlobs
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1016; JDBC:JAVADOC:1017;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the doesMaxRowSizeIncludeBlobs() method. It should return
   * a boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testDoesMaxRowSizeIncludeBlobs() throws Exception {
		super.testDoesMaxRowSizeIncludeBlobs();
  }

  /*
   * @testName: testGetMaxStatementLength
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1018; JDBC:JAVADOC:1019;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getMaxStatementLength() method. It should return an
   * integer value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetMaxStatementLength() throws Exception {
		super.testGetMaxStatementLength();
  }

  /*
   * @testName: testGetMaxStatements
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1020; JDBC:JAVADOC:1021;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getMaxStatements() method. It should return an
   * integer value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetMaxStatements() throws Exception {
		super.testGetMaxStatements();
  }

  /*
   * @testName: testGetMaxTableNameLength
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1022; JDBC:JAVADOC:1023;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getMaxTableNameLength() method. It should return an
   * integer value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetMaxTableNameLength() throws Exception {
		super.testGetMaxTableNameLength();
  }

  /*
   * @testName: testGetMaxTablesInSelect
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1024; JDBC:JAVADOC:1025;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getMaxTablesInSelect() method. It should return an
   * integer value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetMaxTablesInSelect() throws Exception {
		super.testGetMaxTablesInSelect();
  }

  /*
   * @testName: testGetMaxUserNameLength
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1026; JDBC:JAVADOC:1027;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getMaxUserNameLength() method. It should return an
   * integer value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetMaxUserNameLength() throws Exception {
		super.testGetMaxUserNameLength();
  }

  /*
   * @testName: testGetDefaultTransactionIsolation
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1028; JDBC:JAVADOC:1029;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getDefaultTransactionIsolation() method. It should
   * return an integer value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetDefaultTransactionIsolation() throws Exception {
		super.testGetDefaultTransactionIsolation();
  }

  /*
   * @testName: testSupportsTransactions
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1030; JDBC:JAVADOC:1031;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the supportsTransactions() method. It should return a
   * boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testSupportsTransactions() throws Exception {
		super.testSupportsTransactions();
  }

  /*
   * @testName: testSupportsBatchUpdates
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1098; JDBC:JAVADOC:1099;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the supportsBatchUpdates() method. It should return a
   * boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testSupportsBatchUpdates() throws Exception {
		super.testSupportsBatchUpdates();
  }

  /*
   * @testName: testSupportsDataDefinitionAndDataManipulationTransactions
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1034; JDBC:JAVADOC:1035;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the
   * supportsDataDefinitionAndDataManipulationTransactions() method. It should
   * return a boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testSupportsDataDefinitionAndDataManipulationTransactions()
      throws Exception {
		super.testSupportsDataDefinitionAndDataManipulationTransactions();
  }

  /*
   * @testName: testSupportsDataManipulationTransactionsOnly
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1036; JDBC:JAVADOC:1037;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the supportsDataManipulationTransactionsOnly() method. It
   * should return a boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testSupportsDataManipulationTransactionsOnly() throws Exception {
		super.testSupportsDataManipulationTransactionsOnly();
  }

  /*
   * @testName: testDataDefinitionCausesTransactionCommit
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1038; JDBC:JAVADOC:1039;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the dataDefinitionCausesTransactionCommit() method. It
   * should return a boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testDataDefinitionCausesTransactionCommit() throws Exception {
		super.testDataDefinitionCausesTransactionCommit();
  }

  /*
   * @testName: testDataDefinitionIgnoredInTransactions
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1040; JDBC:JAVADOC:1041;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the dataDefinitionIgnoredInTransactions() method. It
   * should return a boolean value
   *
   */
	@Test
	@TargetVehicle("servlet")
  public void testDataDefinitionIgnoredInTransactions() throws Exception {
		super.testDataDefinitionIgnoredInTransactions();
  }

  /*
   * @testName: testGetProcedures
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1042; JDBC:JAVADOC:1043;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getProcedures() method. It should return a ResultSet
   * object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetProcedures() throws Exception {
		super.testGetProcedures();
  }

  /*
   * @testName: testGetProcedureColumns
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1044; JDBC:JAVADOC:1045;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getProcedureColumns() method. It should return a
   * ResultSet object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetProcedureColumns() throws Exception {
		super.testGetProcedureColumns();
  }

  /*
   * @testName: testGetTables
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1046; JDBC:JAVADOC:1047;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getTables() method. It should return a ResultSet
   * object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetTables() throws Exception {
		super.testGetTables();
  }

  /*
   * @testName: testGetSchemas
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1048; JDBC:JAVADOC:1049;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getSchemas() method. It should return a ResultSet
   * object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetSchemas() throws Exception {
		super.testGetSchemas();
  }

  /*
   * @testName: testGetCatalogs
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1050; JDBC:JAVADOC:1051;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getCatalogs() method. It should return a ResultSet
   * object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetCatalogs() throws Exception {
		super.testGetCatalogs();
  }

  /*
   * @testName: testGetTableTypes
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1052; JDBC:JAVADOC:1053;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getTableTypes() method. It should return a ResultSet
   * object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetTableTypes() throws Exception {
		super.testGetTableTypes();
  }

  /*
   * @testName: testGetColumns
   * 
   * @assertion_ids: JDBC:SPEC:8; JDBC:JAVADOC:1054; JDBC:JAVADOC:1055;
   * JavaEE:SPEC:193;
   *
   * @test_Strategy: Get a DatabaseMetadata object from the connection to the
   * database and call the getColumns() method. It should return a ResultSet
   * object Validate the column names and column ordering.
   */
	@Test
	@TargetVehicle("servlet")
  public void testGetColumns() throws Exception {
		super.testGetColumns();
  }

}