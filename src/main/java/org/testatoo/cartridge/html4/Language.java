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

package org.testatoo.cartridge.html4;

import org.testatoo.cartridge.html4.element.Form;
import org.testatoo.cartridge.html4.element.Option;
import org.testatoo.cartridge.html4.element.OptionGroup;
import org.testatoo.core.component.Page;

import static org.testatoo.core.ComponentFactory.page;

public abstract class Language extends org.testatoo.core.Language {

    // Placeholder
    public static Option[] options() {
        return new Option[]{};
    }

    public static OptionGroup[] optionGroups() {
        return new OptionGroup[]{};
    }

    public static String[] visibleRows() {
        return new String[]{"visiblerows"};
    }

    public static Page goTo(String url) {
        return page().open(url);
    }

    public static void reset(Form form) {
        form.reset();
    }

    public static void submit(Form form) {
        form.submit();
    }
}
    
