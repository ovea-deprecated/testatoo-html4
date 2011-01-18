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

import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.testatoo.cartridge.WebTest;
import org.testatoo.core.ComponentException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;
import static org.testatoo.core.ComponentFactory.alertbox;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.Language.assertThat;
import static org.testatoo.core.Language.clickOn;

public class AlertBoxTest extends WebTest {

    @Before
    public void setUp() {
        page().open("AlertBox.html");
    }

    @Test
    public void can_find_alertBox() {
        try {
            alertbox();
            fail();
        } catch (ComponentException e) {
            MatcherAssert.assertThat(e.getMessage(), is("Cannot find component defined by id=" + AlertBox.ID));
        }
        clickOn(component(Button.class, "alertButton"));
        alertbox();
        alertbox().close();
    }

    // Cannot be implemented with Selenium
    @Test
    @Ignore
    public void exception_thrown_if_component_not_a_alertBox() {
        clickOn(component(Button.class, "dialogButton"));
        try {
            alertbox();
            fail();
        } catch (ComponentException e) {
            MatcherAssert.assertThat(e.getMessage(), is("The component with id=" + AlertBox.ID + " is not a AlertBox but a DialogBox"));
        }
    }

    @Test
    public void can_test_title() {
        clickOn(component(Button.class, "alertButton"));
        assertThat(alertbox().title(), is(""));
        alertbox().close();
    }

    @Test
    public void can_test_message() {
        clickOn(component(Button.class, "alertButton"));
        AlertBox alertBox = (AlertBox) alertbox();
        assertThat(alertBox.message(), is("Changes saved successfully."));
        alertBox.close();
    }

    @Test
    public void can_close_alertbox() {
        clickOn(component(Button.class, "alertButton"));
        alertbox();
        alertbox().close();
        try {
            alertbox();
            fail();
        } catch (ComponentException e) {
            assertThat(e.getMessage(), is("Cannot find component defined by id=" + AlertBox.ID));
        }
    }

    @Test
    public void test_toString() {
        clickOn(component(Button.class, "alertButton"));
        AlertBox alertBox = (AlertBox) alertbox();
        assertThat(alertbox().toString(), is("class org.testatoo.cartridge.html4.element.AlertBox with state : enabled:true, visible:true, title:, message:Changes saved successfully."));
        alertBox.close();
    }
}
