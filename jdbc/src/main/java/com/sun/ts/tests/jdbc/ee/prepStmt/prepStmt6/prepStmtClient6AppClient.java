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
 * %W% %E%
 */

package com.sun.ts.tests.jdbc.ee.prepStmt.prepStmt6;

import java.io.IOException;
import java.io.Serializable;
import java.net.URL;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.container.test.api.OverProtocol;
import org.jboss.arquillian.container.test.api.TargetsContainer;
import org.jboss.arquillian.test.api.ArquillianResource;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.StringAsset;
import org.jboss.shrinkwrap.api.spec.EnterpriseArchive;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.sun.ts.lib.harness.Status;

import tck.arquillian.porting.lib.spi.TestArchiveProcessor;
import tck.arquillian.protocol.common.TargetVehicle;

/**
 * The prepStmtClient6 class tests methods of PreparedStatement interface using
 * Sun's J2EE Reference Implementation.
 * 
 * @author
 * @version 1.8, 11/24/00
 */

@Tag("tck-appclient")

public class prepStmtClient6AppClient extends prepStmtClient6 implements Serializable {
  private static final String testName = "jdbc.ee.prepStmt.prepStmt6";
  
  @TargetsContainer("tck-appclient")
  @OverProtocol("appclient")
	@Deployment(name = "appclient", testable = true)
	public static EnterpriseArchive createDeploymentAppclient(@ArquillianResource TestArchiveProcessor archiveProcessor) throws IOException {
		JavaArchive archive = ShrinkWrap.create(JavaArchive.class, "prepStmt6_appclient_vehicle_client.jar");
		archive.addPackages(true, "com.sun.ts.tests.jdbc.ee.common");
		archive.addPackages(false, "com.sun.ts.tests.common.vehicle");
		archive.addPackages(true, "com.sun.ts.lib.harness");
		archive.addClasses(prepStmtClient6AppClient.class, prepStmtClient6.class);
		  // The appclient-client descriptor
	     URL appClientUrl = prepStmtClient6AppClient.class.getResource("/com/sun/ts/tests/jdbc/ee/prepStmt/prepStmt6/appclient_vehicle_client.xml");
	     if(appClientUrl != null) {
	     	archive.addAsManifestResource(appClientUrl, "application-client.xml");
	     }
	     // The sun appclient-client descriptor
	     URL sunAppClientUrl = prepStmtClient6AppClient.class.getResource("//com/sun/ts/tests/common/vehicle/appclient/appclient_vehicle_client.jar.sun-application-client.xml");
	     if(sunAppClientUrl != null) {
	     	archive.addAsManifestResource(sunAppClientUrl, "sun-application-client.xml");
	     }
		 	archive.addAsManifestResource(
					new StringAsset("Main-Class: " + "com.sun.ts.tests.common.vehicle.VehicleClient" + "\n"),
					"MANIFEST.MF");

	     // Call the archive processor
	     archiveProcessor.processClientArchive(archive, prepStmtClient6AppClient.class, sunAppClientUrl);
		  	EnterpriseArchive ear = ShrinkWrap.create(EnterpriseArchive.class, "prepStmt6_appclient_vehicle.ear");
		 		ear.addAsModule(archive);

		 		return ear;
	};


  /* Run test in standalone mode */
  public static void main(String[] args) {
    prepStmtClient6AppClient theTests = new prepStmtClient6AppClient();
    Status s = theTests.run(args, System.out, System.err);
    s.exit();
  }

  /*
   * @testName: testSetObject43
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType, int scale) method,update the column Null_Val with the
   * minimum value of Double_Tab. Call the getObject(int columnno) method to
   * retrieve this value. Extract the minimum value from the tssql.stmt file.
   * Compare this value with the value returned by the getObject(int columnno)
   * method. Both the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject43() throws Exception {
		super.testSetObject43();
  }

  /*
   * @testName: testSetObject44
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:692; JDBC:JAVADOC:693;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType, int scale) method,update the column NUll_Val with the
   * maximum value of Decimal_Tab. Call the getObject(int columnno) method to
   * retrieve this value. Extract the maximum value from the tssql.stmt file.
   * Compare this value with the value returned by the getObject(int columnno)
   * method. Both the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject44() throws Exception {
		super.testSetObject44();
  }

  /*
   * @testName: testSetObject45
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:692; JDBC:JAVADOC:693;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, targetSqlType,
   * int scale) method,update the column Null_Val with the minimum value of
   * Decimal_Tab. Call the getObject(int columnno) method to retrieve this
   * value. Extract the minimum value from the tssql.stmt file. Compare this
   * value with the value returned by the getObject(int columnno) method. Both
   * the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject45() throws Exception {
		super.testSetObject45();
  }

  /*
   * @testName: testSetObject46
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:692; JDBC:JAVADOC:693;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType, int scale) method,update the column Null_Val with the
   * maximum value of Numeric_Tab. Call the getObject(int columnno) method to
   * retrieve this value. Extract the maximum value from the tssql.stmt file.
   * Compare this value with the value returned by the getObject(int columnno)
   * method. Both the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject46() throws Exception {
		super.testSetObject46();
  }

  /*
   * @testName: testSetObject47
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:692; JDBC:JAVADOC:693;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, targetSqlType,
   * int scale) method,update the column Null_Val with the minimum value of
   * Numeric_Tab. Call the getObject(int columnno) method to retrieve this
   * value. Extract the minimum value from the tssql.stmt file. Compare this
   * value with the value returned by the getObject(int columnno) method. Both
   * the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject47() throws Exception {
		super.testSetObject47();
  }

  /*
   * @testName: testSetObject48
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JDBC:JAVADOC:1;JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Min_Val with the maximum value of
   * Bit_Tab. Call the getBoolean(int columnno) method to retrieve this value.
   * Extract the maximum value from the tssql.stmt file. Compare this value with
   * the value returned by the getBoolean(int columnno) method. Both the values
   * should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject48() throws Exception {
		super.testSetObject48();
  }

  /*
   * @testName: testSetObject49
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JDBC:JAVADOC:1; JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the minimum value of
   * Bit_Tab. Call the getBoolean(int columnno) method to retrieve this value.
   * Extract the minimum value from the tssql.stmt file. Compare this value with
   * the value returned by the getBoolean(int columnno) method. Both the values
   * should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject49() throws Exception {
		super.testSetObject49();
  }

  /*
   * @testName: testSetObject50
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the maximum value of
   * Char_Tab. Call the getObject(int columnno) method to retrieve this value.
   * Extract the maximum value from the tssql.stmt file. Compare this value with
   * the value returned by the getObject(int columnno) method. Both the values
   * should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject50() throws Exception {
		super.testSetObject50();
  }

  /*
   * @testName: testSetObject51
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the minimum value of
   * Char_Tab. Call the getObject(int columnno) method to retrieve this value.
   * Extract the minimum value from the tssql.stmt file. Compare this value with
   * the value returned by the getObject(int columnno) method. Both the values
   * should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject51() throws Exception {
		super.testSetObject51();
  }

  /*
   * @testName: testSetObject52
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the maximum value of
   * Varchar_Tab. Call the getObject(int columnno) method to retrieve this
   * value. Extract the maximum value from the tssql.stmt file. Compare this
   * value with the value returned by the getObject(int columnno) method. Both
   * the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject52() throws Exception {
		super.testSetObject52();
  }

  /*
   * @testName: testSetObject53
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the minimum value of
   * Varchar_Tab. Call the getObject(int columnno) method to retrieve this
   * value. Extract the minimum value from the tssql.stmt file. Compare this
   * value with the value returned by the getObject(int columnno) method. Both
   * the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject53() throws Exception {
		super.testSetObject53();
  }

  /*
   * @testName: testSetObject54
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the maximum value of
   * Longvarchar_Tab. Call the getObject(int columnno) method to retrieve this
   * value. Extract the maximum value from the tssql.stmt file. Compare this
   * value with the value returned by the getObject(int columnno) method. Both
   * the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject54() throws Exception {
		super.testSetObject54();
  }

  /*
   * @testName: testSetObject59
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the Non Null value of
   * Date_Tab. Call the getObject(int columnno) method to retrieve this value.
   * Extract the Non Null value from the tssql.stmt file. Compare this value
   * with the value returned by the getObject(int columnno) method. Both the
   * values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject59() throws Exception {
		super.testSetObject59();
  }

  /*
   * @testName: testSetObject60
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the Non Null value of
   * Time_Tab. Call the getObject(int columnno) method to retrieve this value.
   * Extract the Non Null value from the tssql.stmt file. Compare this value
   * with the value returned by the getObject(int columnno) method. Both the
   * values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject60() throws Exception {
		super.testSetObject60();
  }

  /*
   * @testName: testSetObject61
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, int
   * targetSqlType) method,update the column Null_Val with the Non Null value of
   * Timestamp_Tab. Call the getObject(int columnno) method to retrieve this
   * value. Extract the Non Null value from the tssql.stmt file. Compare this
   * value with the value returned by the getObject(int columnno) method. Both
   * the values should be equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject61() throws Exception {
		super.testSetObject61();
  }

  /*
   * @testName: testSetObject62
   * 
   * @assertion_ids: JDBC:SPEC:9; JDBC:JAVADOC:694; JDBC:JAVADOC:695;
   * JavaEE:SPEC:186;
   *
   * @test_Strategy: Get a PreparedStatement object from the connection to the
   * database. Using the setObject(int parameterIndex, Object x, targetSqlType)
   * method,update the column Min_Val with the maximum value of Tinyint_Tab.
   * Call the getObject(int columnno) method to retrieve this value. Extract the
   * maximum value from the tssql.stmt file. Compare this value with the value
   * returned by the getObject(int columnno) method. Both the values should be
   * equal.
   */

	@Test
	@TargetVehicle("appclient")
  public void testSetObject62() throws Exception {
		super.testSetObject62();
  }
}