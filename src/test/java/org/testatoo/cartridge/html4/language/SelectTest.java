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

import org.junit.Before;
import org.junit.Test;
import org.testatoo.WebTest;
import org.testatoo.cartridge.html4.element.Select;

import static org.hamcrest.Matchers.not;
import static org.testatoo.cartridge.html4.Language.*;
import static org.testatoo.cartridge.html4.matcher.Matchers.*;
import static org.testatoo.core.ComponentFactory.*;

public class SelectTest extends WebTest {

    @Before
    public void setUp() {
        page().open("Select.html");
    }

    @Test
    public void select_usage_through_language() {
        Select select = component(Select.class, "elements");

        assertThat(select, has(5, options()));
        and(containsValues("84", "88", "20"));
        and(it(), has(not(selectedValues())));

        on(select).select("20");
        assertThat(select, has(selectedValues("20")));

        select = component(Select.class, "os");

        assertThat(select, has(8, options()));
        assertThat(select, has(3, optionGroups()));

        select = component(Select.class, "elements");
        assertThat(select, has(2, visibleRows()));
    }
}
