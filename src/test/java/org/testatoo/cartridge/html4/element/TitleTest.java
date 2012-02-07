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
import static org.testatoo.core.matcher.Matchers.has;

public class TitleTest extends WebTest {

    @BeforeClass
    public static void setUp() {
        page().open("Title.html");
    }

    @Test
    public void can_find_title_by_id() {
        component(Title.class, $("#h1"));

        try {
            component(Title.class, $("#someId"));
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by jQueryExpression=$('#someId')"));
        }
    }

    @Test
    public void test_title_coreAttributes() {
        Title title = component(Title.class, $("#h2"));

        assertThat(title.title(), is("myTitle"));
        assertThat(title.id(), is("h2"));
        assertThat(title.style(), containsString("color:black"));
        assertThat(title.classname(), is("myClass"));
    }

    @Test
    public void test_title_i18nAttributes() {
        Title title = component(Title.class, $("#h2"));

        assertThat(title.language(), is("ca"));
        assertThat(title.direction(), is(Direction.lefttoright));
    }

    @Test
    public void test_title_text() {
        Title title = component(Title.class, $("#h3"));

        assertThat(title.text(), is("H3 Title"));
    }

    @Test
    public void test_title_level() {
        assertThat(component(Title.class, $("#h1")).level(), is(Title.Level.H1));
        assertThat(component(Title.class, $("#h2")).level(), is(Title.Level.H2));
        assertThat(component(Title.class, $("#h3")).level(), is(Title.Level.H3));
        assertThat(component(Title.class, $("#h4")).level(), is(Title.Level.H4));
        assertThat(component(Title.class, $("#h5")).level(), is(Title.Level.H5));
        assertThat(component(Title.class, $("#h6")).level(), is(Title.Level.H6));
    }

    @Test
    public void test_title_toString() {
        assertThat(component(Title.class, $("#h1")).toString(), is("class org.testatoo.cartridge.html4.element.Title with state : enabled:true, visible:true, text:H1 Title"));
    }

}
