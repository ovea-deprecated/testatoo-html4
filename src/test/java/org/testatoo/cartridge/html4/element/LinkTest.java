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
import org.testatoo.core.input.Mouse;

import java.util.concurrent.TimeUnit;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.max;
import static org.testatoo.core.Language.waitUntil;
import static org.testatoo.core.matcher.Matchers.*;

public class LinkTest extends WebTest {

    @Before
    public void setUp() {
        page().open("Link.html");
    }

    @Test
    public void can_find_a_by_id() {
        component(A.class, "a_1");

        try {
            component(A.class, "a_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=a_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_a() {
        try {
            component(A.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Link but a Radio"));
        }
    }

    @Test
    public void test_a_i18nAttributes() {
        A a = component(A.class, "a_1");

        assertThat(a.direction(), is(Direction.lefttoright));
        assertThat(a.language(), is("fr"));
    }

    @Test
    public void test_a_coreAttributes() {
        A a = component(A.class, "a_1");

        assertThat(a.id(), is("a_1"));
        assertThat(a.classname(), is("myAClass"));
        assertThat(a.style(), containsString("color:black"));
        assertThat(a.title(), is("aTitle"));
    }

    @Test
    public void test_a_specifics_attributes() {
        A a = component(A.class, "a_1");

        assertThat(a.type(), is("text/html"));
        assertThat(a.name(), is("aName"));
        assertThat(a.charset(), is("utf-8"));

        assertThat(a.href(), is("Exit.html"));
        assertThat(a.hreflang(), is("fr"));

        assertThat(a.rel(), is("foo"));
        assertThat(a.rev(), is("bar"));
        assertThat(a.accesskey(), is("C"));
        assertThat(a.shape(), is(Shape.rect));
        assertThat(a.coords(), is("rect:10,10,10,10"));
        assertThat(a.tabindex(), is(1));
    }

    @Test
    public void click_on_A_change_page() {
        A a_link = component(A.class, "a_1");
        assertThat(page().title(), is("Link tests"));
        Mouse.clickOn(a_link);
        assertThat(page().title(), is("Exit page"));
    }

    @Test
    public void can_click_on_link() throws Exception {

        // 1 - Link without js
        page().open("Link.html");
        assertThat(page(), has(title("Link tests")));
        Mouse.clickOn(component(A.class, "a_1"));
        assertThat(page(), has(title("Exit page")));

        // 2 - Link with js
        page().open("Link.html");
        assertThat(page(), has(title("Link tests")));
        Mouse.clickOn(component(A.class, "jsLink"));
        assertThat(page(), has(title("Exit page")));

        // 3 - Link with hooked js
        page().open("Link.html");
        assertThat(component(P.class, "message"), has(text("")));
        Mouse.clickOn(component(A.class, "jsHookedLink"));
        waitUntil(component(P.class, "message"), has(text("Success")), max(10, TimeUnit.SECONDS));
    }

    @Test
    public void testA_toString() {
        assertThat(component(A.class, "a_1").toString(), is("class org.testatoo.cartridge.html4.element.A with state : enabled:true, visible:true, text:Link 1 - a type, reference:Exit.html"));
    }

    //------------------------------------------
    @Test
    public void can_find_link_by_id() {
        component(Link.class, "link_1");

        try {
            component(A.class, "link_0");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=link_0"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_link() {
        try {
            component(Link.class, "radio");
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Link but a Radio"));
        }
    }

    @Test
    public void test_link_i18nAttributes() {
        Link link = component(Link.class, "link_1");

        assertThat(link.direction(), is(Direction.righttoleft));
        assertThat(link.language(), is("en"));
    }

    @Test
    public void test_link_coreAttributes() {
        Link link = component(Link.class, "link_1");

        assertThat(link.id(), is("link_1"));
        assertThat(link.classname(), is("myLINKClass"));
        assertThat(link.style(), containsString("color:orange"));
        assertThat(link.title(), is("linkTitle"));
    }

    @Test
    public void test_link_specifics_attributes() {
        Link link = component(Link.class, "link_1");

        assertThat(link.type(), is("text/html"));
        assertThat(link.charset(), is("utf-8"));

        assertThat(link.href(), is("Exit.html"));
        assertThat(link.hreflang(), is("fr"));

        assertThat(link.rel(), is("next, index"));
        assertThat(link.rev(), is("prev, chapter"));
    }

    @Test
    public void test_enability() {
        Link link = component(Link.class, "link_1");
        assertThat(link.isVisible(), is(false));
    }

    @Test
    public void testLink_toString() {
        Link link = component(Link.class, "link_1");
        assertThat(link.toString(), is("class org.testatoo.cartridge.html4.element.Link with state : enabled:true, visible:false, text:, reference:Exit.html"));
    }
}
