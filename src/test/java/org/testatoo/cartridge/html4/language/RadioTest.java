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
import org.testatoo.core.component.Radio;

import static org.hamcrest.Matchers.*;
import static org.testatoo.cartridge.html4.By.$;
import static org.testatoo.cartridge.html4.Language.*;
import static org.testatoo.core.ComponentFactory.component;
import static org.testatoo.core.matcher.Matchers.*;

public class RadioTest extends WebTest {

    @Before
    public void setUp() {
        goTo("Radio.html");
    }

    @Test
    public void radio_usage_through_language() {
        Radio radio = component(Radio.class, $("[name=radioName]"));

        assertThat(radio, is(not(checked())));
        and(has(label("Male")));

        check(radio);
        assertThat(radio, is(checked()));

        // Test radio group
        Radio radioYes = component(Radio.class, "yes");
        Radio radioNo = component(Radio.class, "no");

        assertThat(radioYes, is(not(checked())));
        assertThat(radioNo, is(not(checked())));

        check(radioYes);
        assertThat(radioYes, is(checked()));
        assertThat(radioNo, is(not(checked())));

        check(radioNo);
        assertThat(radioYes, is(not(checked())));
        assertThat(radioNo, is(checked()));
    }

}
