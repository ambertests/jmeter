/*
 * Copyright 2001-2004 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 
 */

package org.apache.jmeter.protocol.http.proxy;

import org.apache.jmeter.junit.JMeterTestCase;
import org.apache.jmeter.protocol.http.sampler.HTTPSamplerBase;

public class TestHttpRequestHdr  extends JMeterTestCase {
		public TestHttpRequestHdr(String name) {
			super(name);
		}

		public void setUp() {
		}

		public void testRepeatedArguments() throws Exception {
			String TEST_REQ = 
                "GET http://localhost/matrix.html?" 
                + "update=yes&d=1&d=2&d=&d=&d=&d=&d=&d=1&d=2&d=1&d="
					+ "&d= HTTP/1.0\n\n";
			HttpRequestHdr req = new HttpRequestHdr();
			req.parse(new java.io.ByteArrayInputStream(TEST_REQ.getBytes()));
			HTTPSamplerBase s = req.getSampler();
			assertEquals(13,s.getArguments().getArguments().size());
		}
}
