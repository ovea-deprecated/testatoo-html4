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

package org.testatoo.cartridge.multisession;

import org.testatoo.config.AbstractTestatooModule;
import org.testatoo.config.Scope;
import org.testatoo.config.cartridge.TestatooCartridge;

import static org.testatoo.container.TestatooContainer.JETTY;

final class SyncedParallelMultiSessionModule extends AbstractTestatooModule {
    @Override
    protected void configure() {
        containers().register(createContainer()
                .implementedBy(JETTY)
                .webappRoot("src/test/webapp")
                .port(7771)
                .build())
                .scope(Scope.TEST_SUITE);

        // setup one browser

        seleniumServers().register(createSeleniumServer()
                .port(7782)
                .useSingleWindow(true)
                .build())
                .scope(Scope.TEST_SUITE);

        seleniumSessions()
                .register(createSeleniumSession()
                        .website("http://127.0.0.1:7771/")
                        .browser("*firefox")
                        .serverHost("127.0.0.1")
                        .serverPort(7782)
                        .build())
                .scope(Scope.TEST_SUITE)
                .withTimeout(20000)
                .inCartridge(TestatooCartridge.HTML4);

        // setup second browser

        seleniumServers().register(createSeleniumServer()
                .port(7783)
                .useSingleWindow(true)
                .build())
                .scope(Scope.TEST_SUITE);

        seleniumSessions()
                .register(createSeleniumSession()
                        .website("http://www.google.com/")
                        .browser("*firefox")
                        .serverHost("127.0.0.1")
                        .serverPort(7783)
                        .build())
                .scope(Scope.TEST_SUITE)
                .named("MY-OTHER-SESSION-NAME")
                .withTimeout(20000)
                .inCartridge(TestatooCartridge.HTML4);

        useConcurrentTesting()
                .threads(Runtime.getRuntime().availableProcessors() * 3);
    }
}
