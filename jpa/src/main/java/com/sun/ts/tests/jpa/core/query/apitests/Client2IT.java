/*
 * Copyright (c) 2007, 2023 Oracle and/or its affiliates. All rights reserved.
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

package com.sun.ts.tests.jpa.core.query.apitests;

import java.lang.System.Logger;

import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.sun.ts.tests.jpa.common.PMClientBase;

import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

public class Client2IT extends PMClientBase {

	private static final Logger logger = (Logger) System.getLogger(Client2IT.class.getName());

	final Department deptRef[] = new Department[5];

	public Client2IT() {
	}

	public static JavaArchive createDeployment() throws Exception {

		String pkgNameWithoutSuffix = Client1IT.class.getPackageName();
		String pkgName = Client1IT.class.getPackageName() + ".";
		String[] classes = { pkgName + "DataTypes2", pkgName + "Department", pkgName + "Employee",
				pkgName + "Insurance" };
		return createDeploymentJar("jpa_core_query_apitests2.jar", pkgNameWithoutSuffix, classes);

	}

	@BeforeAll
	public void setupNoData() throws Exception {
		logger.log(Logger.Level.TRACE, "setup");
		try {
			super.setup();
			logger.log(Logger.Level.TRACE, "Done creating test data");
		} catch (Exception e) {
			logger.log(Logger.Level.ERROR, "Unexpected Exception caught in Setup: ", e);
			throw new Exception("Setup failed:", e);

		}
	}

	@AfterAll
	public void cleanupNoData() throws Exception {
		logger.log(Logger.Level.TRACE, "in cleanupNoData");
		super.cleanup();
	}

	/*
	 * @testName: getParameterIntIllegalArgumentException2Test
	 * 
	 * @assertion_ids: PERSISTENCE:JAVADOC:562; PERSISTENCE:JAVADOC:652
	 * 
	 * @test_Strategy: create query and set a positional parameter. Verify calling
	 * getParameter with a class that is not assignable to the type throws
	 * IllegalArgumentException create TypedQuery and set a positional parameter.
	 * Verify calling getParameter with a class that is not assignable to the type
	 * throws IllegalArgumentException
	 */
	@Test
	public void getParameterIntIllegalArgumentException2Test() throws Exception {
		boolean pass1 = false;
		boolean pass2 = false;
		try {
			logger.log(Logger.Level.INFO, "Testing Query version");
			Query query = getEntityManager().createQuery("select e from Employee e where e.firstName = ?1")
					.setParameter(1, "Tom");
			query.getParameter(1, java.util.List.class);
			logger.log(Logger.Level.ERROR, "IllegalArgumentException not thrown");
		} catch (IllegalArgumentException e) {
			logger.log(Logger.Level.TRACE, "Received expected IllegalArgumentException");
			pass1 = true;
		} catch (Exception e) {
			logger.log(Logger.Level.ERROR, "Unexpected exception occurred", e);
		}
		logger.log(Logger.Level.INFO, "Testing TypedQuery version");

		try {
			TypedQuery<Employee> query = getEntityManager()
					.createQuery("select e from Employee e where e.firstName = ?1", Employee.class)
					.setParameter(1, "Tom");
			query.getParameter(1, java.util.List.class);
			logger.log(Logger.Level.ERROR, "IllegalArgumentException not thrown");
		} catch (IllegalArgumentException e) {
			logger.log(Logger.Level.TRACE, "Received expected IllegalArgumentException");
			pass2 = true;
		} catch (Exception e) {
			logger.log(Logger.Level.ERROR, "Unexpected exception occurred", e);
		}
		if (!pass1 || !pass2) {
			throw new Exception("getParameterIntIllegalArgumentException2Test failed");
		}
	}
}
