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

import org.junit.BeforeClass;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.core.ComponentException;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.core.ComponentFactory.*;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.matcher.Matchers.*;

public class SpanTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Span.html");
    }

    @Test
    public void can_find_span_by_id() {
        component(Span.class, $("#spanId"));

        try {
            component(Span.class, $("#otherElement"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#otherElement')"));
        }
    }

    @Test
    public void exception_thrown_if_component_not_a_html_span() {
        try {
            component(Span.class, $("#radio"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("The component with id=radio is not a Span but a Radio"));
        }
    }

    @Test
    public void test_i18nAttributes() {
        Span span = component(Span.class, $("#spanId"));

        assertThat(span.direction(), is(Direction.lefttoright));
        assertThat(span.language(), is("en"));
    }

    @Test
    public void test_coreAttributes() {
        Span span = component(Span.class, $("#spanId"));

        assertThat(span.id(), is("spanId"));
        assertThat(span.classname(), is("myClass"));
        assertThat(span.style(), containsString("background-color:red"));
        assertThat(span.title(), is("spanTitle"));
    }

    @Test
    public void test_span_text() {
        Span span = component(Span.class, $("#myId"));
        assertThat(span, has(text("A simple text")));
    }

    @Test
    public void test_toString() {
        Span span = component(Span.class, $("#spanId"));
        assertThat(span.toString(), is("class org.testatoo.cartridge.html4.element.Span with state : enabled:true, visible:true, title:spanTitle"));
    }

}
