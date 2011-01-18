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

import org.hamcrest.Matcher;
import org.testatoo.cartridge.html4.element.Option;
import org.testatoo.cartridge.html4.element.OptionGroup;
import org.testatoo.cartridge.html4.element.Select;

/**
 * This class defines the matchers (based on hamcrest matchers) used in testatoo tests and specific to html4 testing.
 *
 * @author dev@testatoo.org
 */

public class Matchers extends org.testatoo.core.matcher.Matchers {

    /**
     * To test the number of options in a select element, using the syntax "has(4, options())"
     *
     * @param num    the expected number of options
     * @param option the tested element, here : option
     * @return a new OptionSize matcher created with the given size
     */
    public static Matcher<Select> has(int num, Option[] option) {
        return OptionSize.is(num);
    }

    /**
     * To test the number of optiongroups in a select element, using the syntax "has(4, optionGroups())"
     *
     * @param num          the expected number of optiongroups
     * @param optionGroups the tested element, here : optionGroup
     * @return a new OptionGroupSize matcher created with the given size
     */

    public static Matcher<Select> has(int num, OptionGroup[] optionGroups) {
        return OptionGroupSize.is(num);
    }

    /**
     * To test the number of something, using the syntax "has(4, xxxxxx())"
     *
     * @param num       the expected number
     * @param something the tested element, ex : visibleRows
     * @return a new matcher created with the given size
     */
    public static Matcher<Select> has(int num, String[] something) {
        if (something[0].equals("visiblerows")) {
            return VisibleRow.is(num);
        }
        throw new UnsupportedOperationException("No matcher found");
    }

}
