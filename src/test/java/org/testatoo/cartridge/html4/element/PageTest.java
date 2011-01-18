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

package org.testatoo.cartridge.html4.element;

import org.junit.Before;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.core.ComponentException;
import org.testatoo.core.component.Page;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;

public class PageTest extends WebTest {

    private Page page;

    @Before
    public void setUp() {
        page = page().open("Page.html");
    }

    @Test
    public void can_open_page() throws Exception {
        assertThat(page.source().toLowerCase().contains("<title>page tests</title>"), is(true));
    }

    @Test
    public void can_get_the_title() {
        assertThat(page.title(), is("Page tests"));
    }

    @Test
    public void test_contains() {
        A a1 = component(A.class, "link_1");
        assertThat(page.contains(a1), is(true));

        try {
            component(A.class, "base_1");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=base_1"));
        }
    }

    @Test
    public void test_toString() {
        assertThat(page.toString(), is("class org.testatoo.core.component.Page with state : enabled:true, visible:true, title:Page tests"));
    }
}
