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

package org.testatoo.cartridge.html4.language;

import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.html4.By;
import org.testatoo.cartridge.html4.element.A;
import org.testatoo.cartridge.html4.element.Form;
import org.testatoo.core.component.Radio;

import static org.hamcrest.Matchers.not;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.cartridge.html4.Language.*;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.ComponentFactory.page;
import static org.testatoo.core.matcher.Matchers.contains;

public class ContainerTest extends WebTest {

    @Test
    public void can_test_if_element_is_embedded() {
        goTo("Page.html");

        // Trivial, page contains all the elements
        assertThat(page(), contains(component(A.class, $("#link_1"))));

        // For form
        goTo("Form.html");

        Radio maleRadio = component(Radio.class, $("#male"));

        assertThat(component(Form.class, $("#myForm")), contains(maleRadio));
        assertThat(component(Form.class, $("#myForm2")), not(contains(maleRadio)));
    }
}
