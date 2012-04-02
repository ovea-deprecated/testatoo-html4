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

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.testatoo.cartridge.html4.element.Select;


public class VisibleRow extends TypeSafeMatcher<Select> {

    private int num;

    public boolean matchesSafely(Select select) {
        return select.visibleRows() == num;
    }

    public void describeTo(Description description) {
        description.appendText("visible rows : " + num);
    }

    public VisibleRow(int num) {
        this.num = num;
    }

    @Factory
    public static Matcher<Select> is(int num) {
        return new VisibleRow(num);
    }
}   
