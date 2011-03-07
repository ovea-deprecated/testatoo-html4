/**
 * Copyright (C) 2008 Ovea <dev@testatoo.org>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.testatoo.multisession;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.testatoo.config.AbstractTestatooModule;
import org.testatoo.config.Scope;
import org.testatoo.config.cartridge.TestatooCartridge;

import static org.testatoo.container.TestatooContainer.JETTY;

final class MultiSessionModule extends AbstractTestatooModule {
    @Override
    protected void configure() {
        containers().register(createContainer()
                .implementedBy(JETTY)
                .webappRoot("src/test/webapp")
                .port(7770)
                .build())
                .scope(Scope.TEST_SUITE);

        // setup one browser

        seleniumServers().register(createSeleniumServer()
                .port(7780)
                .useSingleWindow(true)
                .build())
                .scope(Scope.TEST_SUITE);

        seleniumSessions()
                .register(createSeleniumSession()
                        .website("http://127.0.0.1:7770/")
                        .browser("*firefox")
                        .serverHost("127.0.0.1")
                        .serverPort(7780)
                        .build())
                .scope(Scope.TEST_SUITE)
                .withTimeout(20000)
                .inCartridge(TestatooCartridge.HTML4);

        // setup second browser

        seleniumServers().register(createSeleniumServer()
                .port(7781)
                .useSingleWindow(true)
                .build())
                .scope(Scope.TEST_SUITE);

        seleniumSessions()
                .register(createSeleniumSession()
                        .website("http://www.google.com/")
                        .browser("*firefox")
                        .serverHost("127.0.0.1")
                        .serverPort(7781)
                        .build())
                .scope(Scope.TEST_SUITE)
                .named("MY-OTHER-SESSION-NAME")
                .withTimeout(20000)
                .inCartridge(TestatooCartridge.HTML4);


        // This is to test the ability of chaining interceptors.
        // Interceptor 2 is around interceptor 1 which is around the test
        lifecycle().onTest(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                try {
                    System.out.println("INTERCEPT 1 - before");
                    return invocation.proceed();
                } finally {
                    System.out.println("INTERCEPT 1 - after");
                }
            }
        });
        lifecycle().onTest(new MethodInterceptor() {
            @Override
            public Object invoke(MethodInvocation invocation) throws Throwable {
                try {
                    System.out.println("INTERCEPT 2 AROUND - before");
                    return invocation.proceed();
                } finally {
                    System.out.println("INTERCEPT 2 AROUND - after");
                }
            }
        });

    }
}
