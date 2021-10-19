/*
 * Copyright (c) 2021 Oracle and/or its affiliates. All rights reserved.
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
 * $Id$
 */
package com.sun.ts.tests.activation.pluggability.activationprovidertests;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.ServiceLoader;

import com.sun.javatest.Status;
import com.sun.ts.lib.harness.ServiceEETest;

import jakarta.activation.MailcapCommandMap;
import jakarta.activation.MimetypesFileTypeMap;

public class Client extends ServiceEETest {


  public static void main(String[] args) {
    Client theTests = new Client();
    Status s = theTests.run(args, System.out, System.err);
    s.exit();
  }

  /* Test setup */

  /*
   * @class.setup_props:
   */

  public void setup(String[] args, Properties p) throws Fault {
    logMsg("setup ok");
  }
  
  public void cleanup() throws Fault {
    logMsg("cleanup ok");
  }

  /*
   * @testName: activationProviderTest1
   * 
   * @test_Strategy: Checks that a custom implementation of MailcapRegistryProvider
   * can be loaded by SPI added for JAF 2.1.
   */
  public void activationProviderTest1() throws Fault {
      try {
          MailcapCommandMap mailcap = new MailcapCommandMap("MailcapRegistryProvider_Test");
          if (mailcap.getMimeTypes() != null && mailcap.getMimeTypes()[0].equals("MIME/Pluggability_Test")) {
              System.out.println("com.sun.ts.tests.activation.provider.MyMailcapRegistryProvider was loaded correctly");
          } else {
              throw new Fault("com.sun.ts.tests.activation.provider.MyMailcapRegistryProvider was NOT loaded");
          }
      } catch (IOException e) {
          throw new Fault(e);
      }
  }

  /*
   * @testName: activationProviderTest2
   * 
   * @test_Strategy: Checks that a custom implementation of MimeTypeRegistryProvider
   * can be loaded by SPI added for JAF 2.1.
   */
  public void activationProviderTest2() throws Fault {
      try {
          MimetypesFileTypeMap mimetypes = new MimetypesFileTypeMap("MimeTypeRegistryProvider_Test");
          if ("MIMEType/Pluggability_Test".equals(mimetypes.getContentType("anything.anything"))) {
              System.out.println("com.sun.ts.tests.activation.provider.MyMimeTypeRegistryProvider was loaded correctly");
          } else {
              throw new Fault("com.sun.ts.tests.activation.provider.MyMimeTypeRegistryProvider was NOT loaded");
          }
      } catch (IOException e) {
          throw new Fault(e);
      }
  }
}
