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

package org.testatoo.cartridge.html4.matcher;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.testatoo.cartridge.html4.Language.assertThat;
import static org.testatoo.cartridge.html4.Language.optionGroups;
import static org.testatoo.cartridge.html4.Language.options;
import static org.testatoo.cartridge.html4.Language.visibleRows;
import static org.testatoo.cartridge.html4.matcher.Matchers.has;
import static org.testatoo.cartridge.html4.matcher.mock.MockFactory.selectWith2OptionGroups;
import static org.testatoo.cartridge.html4.matcher.mock.MockFactory.selectWith3Options;

public class MatchersTest {

    @Test
    public void test_optionSize_matcher() {
        assertThat(selectWith3Options(), has(3, options()));

        try {
            assertThat(selectWith3Options(), has(2, options()));
            fail();
        } catch (AssertionError e) {
            assertEquals(format(e.getMessage()), "Expected: option values size : 2 but: was <class org.testatoo.cartridge.html4.element.Select with state : enabled:true, visible:true, values:[UK, Canada, Italy], selectedValues:[UK, Italy], optionGroup:[], visibleRows:2>");
        }
    }

    @Test
    public void test_optionGroupSize_matcher() {
        assertThat(selectWith2OptionGroups(), has(2, optionGroups()));

        try {
            assertThat(selectWith2OptionGroups(), has(3, optionGroups()));
            fail();
        } catch (AssertionError e) {
            assertEquals(format(e.getMessage()), "Expected: optionGroup size : 3 but: was <class org.testatoo.cartridge.html4.element.Select with state : enabled:true, visible:true, values:[], selectedValues:[], optionGroup:[labelOptionGrp, labelOptionGrp], visibleRows:2>");
        }
    }

    @Test
    public void test_visible_rows() {
        assertThat(selectWith3Options(), has(2, visibleRows()));

        try {
            assertThat(selectWith3Options(), has(3, visibleRows()));
            fail();
        } catch (AssertionError e) {
            assertEquals(format(e.getMessage()), "Expected: visible rows : 3 but: was <class org.testatoo.cartridge.html4.element.Select with state : enabled:true, visible:true, values:[UK, Canada, Italy], selectedValues:[UK, Italy], optionGroup:[], visibleRows:2>");
        }
    }

    private static String format(String message) {
        String formatedMessage = message.replace("\n", "");
        formatedMessage = formatedMessage.replace("    ", "");
        return formatedMessage;
    }
}
